package itemHandling;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ConsumeItemListener implements Listener {

	@EventHandler
	public void onConsumeItem(final PlayerItemConsumeEvent event) {
		
		if(event.getItem().getType().equals(Material.POTION)) {
			
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	    			event.getPlayer().getInventory().remove(Material.GLASS_BOTTLE);
	    			event.getPlayer().updateInventory();
	        		
	        	}
		    }, 1L);
		}
	}
}
