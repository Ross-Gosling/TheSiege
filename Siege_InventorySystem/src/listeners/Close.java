//==================================================================================================================================

package listeners;

import itemHandling.InventoryFunctions;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Close implements Listener {

//==================================================================================================================================

	//onInventoryClose Event
	
//==================================================================================================================================
	
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {

		Player player = (Player) event.getPlayer();
		Inventory inventory = event.getInventory();
		InventoryType type = inventory.getType();
		
		ArmourSystem.equipSet(player);
		
		if((type.equals(InventoryType.FURNACE)) || (type.equals(InventoryType.CRAFTING)) || (type.equals(InventoryType.WORKBENCH))) {
			
			for (ItemStack item : inventory) {
								
				if (!(item == null)) {
					
					if(InventoryFunctions.canMerge(item, player.getInventory())) {
						
						player.getInventory().addItem(item);
						player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
					}
					
					else {
					
						Location location = player.getLocation();
						location.setY(location.getY()+1);
						World world = location.getWorld();
							 
						world.dropItem(location, item);
					}	
				}
			}
			
			inventory.clear();
		}
		
		player.updateInventory();
	}

//==================================================================================================================================
	
}
