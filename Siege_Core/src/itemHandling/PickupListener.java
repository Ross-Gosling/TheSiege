package itemHandling;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PickupListener implements Listener {

//==================================================================================================================================

	//onItemPickup Event
	
//==================================================================================================================================

	@EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
    	
		Player player = event.getPlayer();
		
		if(!player.hasPermission("GroupNode.InBuildMode")) {
		
			Item itemEntity = event.getItem();
			ItemStack stack = event.getItem().getItemStack();
			
			//You can't pick up arrows that have been shot
	        if(stack.getType().equals(Material.ARROW)) {
	        	
	        	if(stack.equals(MakeItemStack.arrow(stack.getAmount()))) {
	        		//Do Nothing
	        	}
	        	
	        	else {
	            	event.setCancelled(true);
	        	}
	        	
	        }
	        
			if(me.x3DGosling.Siege_InventorySystem.Main.undroppableItems.contains(stack.getType())) {
				itemEntity.remove();
			}
					
			//You cant pickup items that dont have a display name
			if(stack.getItemMeta().hasDisplayName() == false) {
				itemEntity.remove();
			}
			
			player.updateInventory();
		}	
		else {
			event.setCancelled(true);		
		}
	}
			
//==================================================================================================================================

	
}
