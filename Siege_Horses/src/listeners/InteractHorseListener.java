package listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class InteractHorseListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEntityEvent Event
		
//==================================================================================================================================
		
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		
    	Player player = event.getPlayer();
    	Entity entity = event.getRightClicked();
    	
    	if(entity instanceof Horse) {
    		
    		Horse horse = (Horse) entity;
    		
			if(horse.getOwner().getName().equals(player.getName())) {}
			
			else {
				
				player.sendMessage(ChatColor.RED + "You can't access someone elses horse");
				event.setCancelled(true);
			}
    	}
	}
	
//==================================================================================================================================

}
