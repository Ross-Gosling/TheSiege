//==================================================================================================================================

package listeners;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class Open implements Listener {

//==================================================================================================================================

	//onInventoryOpen Event
		
//==================================================================================================================================
	
	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		
		Inventory inventory = event.getInventory();
		InventoryType type = inventory.getType();
		Player player = (Player) event.getPlayer();
		
		ArmourSystem.equipSet(player);
		
		if(type.equals(InventoryType.FURNACE)) {
			
			List<HumanEntity> viewers = inventory.getViewers();
			
			if(viewers.size() > 1) {
				
				event.setCancelled(true);
				
				player.sendMessage(ChatColor.RED + "Someone is already using this furnace");
			}
		}
		
		player.updateInventory();
	}
	
//==================================================================================================================================

}