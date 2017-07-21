package listener;

import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class TargetListener implements Listener {

	@EventHandler
	public void onEntityTarget(EntityTargetEvent event) {
		
		if(event.getTarget() instanceof Villager) {
			
			event.setCancelled(true);
		}
	}
}
