//==================================================================================================================================

package listeners;

import me.x3DGosling.Siege_InventorySystem.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;
import org.bukkit.plugin.Plugin;

public class Click implements Listener {

//==================================================================================================================================

	//onInventoryClick Event
	
//==================================================================================================================================

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

		final Player player = (Player) event.getWhoClicked();
		
        Bukkit.getScheduler().scheduleSyncDelayedTask(me.x3DGosling.Siege_Core.Main.fetchPlugin(), new Runnable() {
        	public void run() {
        		
        		ArmourSystem.equipSet(player);
        	}
	    }, 1L);
        
		if(event.getCurrentItem().equals(null)) {}
		
		//Can't remove saddles from Horses
		else if((event.getCurrentItem().getType().equals(Material.SADDLE)) && (event.getCurrentItem().getItemMeta().hasDisplayName() == false)) {
	        
			if(player.hasPermission("GroupNode.InBuildMode")) {}
			
			else {
			        	
				player.sendMessage(ChatColor.RED + "You cannot remove horse's saddles");
				event.setCancelled(true);
			}
	    }
		
		//Cancels event if you click armour that's equipped
		else if(event.getSlotType().equals(SlotType.ARMOR)) {
			
			if(player.hasPermission("GroupNode.InBuildMode")) {}
			
			else {
				
				if(Main.immovableArmour.contains(event.getCurrentItem().getType())) {		
					
					event.setCancelled(true);
					player.sendMessage(ChatColor.RED + "You cannot remove this armour");
					
					Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
						
						public void run() {
							
							player.updateInventory();
						}
					}, 20L);
				}
			}
		}
		
		//Removes armour if you click armour that's in your inventory
		else if(Main.immovableArmour.contains(event.getCurrentItem().getType())) {	
			
			if(player.hasPermission("GroupNode.InBuildMode")) {}
			
			else {
				
				player.getInventory().remove(event.getCurrentItem());
				player.sendMessage(ChatColor.RED + "You cannot have this here");
				
				player.updateInventory();
			}
		}
	}
	
//==================================================================================================================================

}
