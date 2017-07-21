package listeners;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

//==================================================================================================================================

	//onEntityDamageByEntity Event
					
//==================================================================================================================================
		
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
			
		if(event.getEntity() instanceof Horse) {
			
			if(event.getDamager() instanceof Player) {
				
				Player damager = (Player) event.getDamager();
				Horse horse = (Horse) event.getEntity();
				
				if(damager.hasPermission("GroupNode.InBuildMode")) {}
				
				else if(horse.getOwner().equals(damager)) {
					event.setCancelled(true);
				}
				
				else if((damager.hasPermission("GroupNode.RossFaction")) && (((Player) horse.getOwner()).hasPermission("GroupNode.RossFaction"))) {
					event.setCancelled(true);
				}
				
				else if((damager.hasPermission("GroupNode.LewisFaction")) && (((Player) horse.getOwner()).hasPermission("GroupNode.LewisFaction"))) {
					event.setCancelled(true);
				}
				
				else if((damager.hasPermission("GroupNode.AlexFaction")) && (((Player) horse.getOwner()).hasPermission("GroupNode.AlexFaction"))) {
					event.setCancelled(true);
				}
				
				else if((damager.hasPermission("GroupNode.CurtisFaction")) && (((Player) horse.getOwner()).hasPermission("GroupNode.CurtisFaction"))) {
					event.setCancelled(true);
				}
			}
		}
	}
	
//==================================================================================================================================
	
}
