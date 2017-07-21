//==================================================================================================================================

package itemHandling;

import org.bukkit.ChatColor;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropListener implements Listener {

//==================================================================================================================================

    //onItemDrop Event
	
//==================================================================================================================================

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		
		Player player = event.getPlayer();
		Item Drop = event.getItemDrop();
				
		if(me.x3DGosling.Siege_InventorySystem.Main.undroppableItems.contains(event.getItemDrop().getItemStack().getType())) {
			
			event.setCancelled(true);
			player.sendMessage(ChatColor.RED + "You can't drop this");
		}
				
		//You cant drop items that dont have a display name
		else if(!Drop.getItemStack().getItemMeta().hasDisplayName()) {
			
			Drop.remove();
			player.sendMessage(ChatColor.RED + "Deleted - That's an item you shouldn't even have");
		}
		
		//Catches everyother type of item
		else {
			
			//Do Nothing		
		}
		
		player.updateInventory();
		
	}	
	
//==================================================================================================================================

	
}
