package listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class DamageListener implements Listener {

//==================================================================================================================================

	//onEntityDamageByEntity Event
					
//==================================================================================================================================
		
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
			
		Entity entity = event.getEntity();
		
		if(entity.getType().equals(EntityType.VILLAGER)) {
			
			if(event.getDamager() instanceof Player) {
				
				Player player = (Player) event.getDamager();
				
				if(player.hasPermission("GroupNode.InBuildMode")) {
					
					//Do Nothing
				}
				
				else {
					
					event.setCancelled(true);
				}
			}
			
			else {
			
				event.setCancelled(true);
			}
		}
	}
	
//==================================================================================================================================

	//onEntityDamage Event
				
//==================================================================================================================================
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		
		Entity entity = event.getEntity();
		
		if(entity.getType().equals(EntityType.SKELETON)) {
			
			if((event.getCause().equals(DamageCause.FIRE_TICK)) || (event.getCause().equals(DamageCause.FIRE))) {
				
				event.setDamage(((LivingEntity)entity).getMaxHealth());
			}
		}
	}
	
//==================================================================================================================================
		
}
