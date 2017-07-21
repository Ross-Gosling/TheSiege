package playerHandling;

import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {

//==================================================================================================================================

	//onPlayerDamage Event
					
//==================================================================================================================================
	
	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		
		if(event.getEntity() instanceof Player) {
		
			if(event.getCause().equals(DamageCause.FALL)) {
				
				event.setDamage(event.getFinalDamage()*2);
				
				Player player = (Player) event.getEntity();
			
				int fallDistance = (int) player.getFallDistance();
				int effectLength = fallDistance*5;
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (int) effectLength, (int) 3), true);	
			}
			
			else if(event.getCause().equals(DamageCause.DROWNING)) {
				
				event.setDamage(event.getDamage()*2);							
			}
			
			else if(event.getCause().equals(DamageCause.ENTITY_ATTACK)) {
				
				Player player = (Player) event.getEntity();

				if(player.isInsideVehicle()) {
					
					if(player.getVehicle() instanceof Horse) {
						
						Horse horse = (Horse) player.getVehicle();
											
						horse.damage(event.getDamage());
						event.setDamage(0.0);
					}
				}
			}
		}		
	}
	
//==================================================================================================================================
	
}
