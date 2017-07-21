//==================================================================================================================================
	
package itemHandling;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
public final class InventoryFunctions {
	
//==================================================================================================================================
	
	public static boolean canMerge(final ItemStack item, final Inventory inventory) {
		
		// A slot is NOT available
		if(inventory.firstEmpty() == -1) {
				
			// The Inventory contains another of the item
			if(inventory.contains(item.getType())) {
			
				List<ItemStack> similarStacks = new ArrayList<ItemStack>();
						
				// FOR all items
				for (ItemStack stack : inventory.getContents()) {
															
					// Is the item in the slot the same as the input item
					if(stack.getType().equals(item.getType())) {
												
						// This stack is similar to the item
						similarStacks.add(stack);
											
					}
				
				}
				
				// There are similar ItemStacks
				if(!similarStacks.isEmpty()) {
					
					int totalAmount = 0;
					
					// FOR all similar itemstacks
					for (ItemStack stack : similarStacks) {
												
						// Totals up the number of items in stacks
						totalAmount = totalAmount + stack.getAmount();
					
					}
					
					// Total space in every available stack
					int stackFreeSpace = ((similarStacks.size() * item.getMaxStackSize()) - totalAmount);
														
					// Would item fit into the inventory?
					if(stackFreeSpace >= item.getAmount()) {
					
						// Yes the item can be merged into an inventory
						return true;
					}
					
					// Wouldn't fit
					else {
												
						return false;
						
					}
					
				}
				
			}
			
			// The Inventory DOES NOT contain another of the item
			else {
							
				// No slots and no items of the same type
				return false;
				
			}
			
		}
		
		// A slot is available
		// If the item is greater than one slots worth of inv space
		else if(item.getAmount() > item.getMaxStackSize()) {
					
			ItemStack item_Deducted = item.clone();
			ItemStack item_MaxAmount = item.clone();
			
			item_MaxAmount.setAmount(item.getMaxStackSize());
			item_Deducted.setAmount(item.getAmount() - item.getMaxStackSize());
			
			Inventory inventory_Recursive = Bukkit.createInventory(null, inventory.getSize());
			inventory_Recursive.setContents(inventory.getContents());
			
			inventory_Recursive.addItem(item_MaxAmount);

			return canMerge(item_Deducted, inventory_Recursive);
		}
				
		return true;
				
	}
	
//==================================================================================================================================
	
	public static void removeItem(ItemStack item, int amount, Inventory inventory) {
		
		while(amount > 0) {
			
			inventory.removeItem(item);
			
			amount--;
		}
	}
	
//==================================================================================================================================

	public static ItemMeta hideFlags(ItemMeta stackMeta) {
		
		stackMeta.getItemFlags().add(ItemFlag.HIDE_ATTRIBUTES);
		stackMeta.getItemFlags().add(ItemFlag.HIDE_DESTROYS);
		stackMeta.getItemFlags().add(ItemFlag.HIDE_ENCHANTS);
		stackMeta.getItemFlags().add(ItemFlag.HIDE_PLACED_ON);
		stackMeta.getItemFlags().add(ItemFlag.HIDE_POTION_EFFECTS);
		stackMeta.getItemFlags().add(ItemFlag.HIDE_UNBREAKABLE);
		
		return stackMeta;
	}
	
//==================================================================================================================================

}