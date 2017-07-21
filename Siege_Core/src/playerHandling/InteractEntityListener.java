package playerHandling;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class InteractEntityListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEntityEvent Event
		
//==================================================================================================================================
		
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		
    	Player player = event.getPlayer();
    	Entity entity = event.getRightClicked();
    	
    	//If ItemInHand doesn't exist
		if((player.getItemInHand() == null) || (player.getItemInHand().getType().equals(Material.AIR))) {}
    	
    	//If click item frame in build mode
		if((entity instanceof ItemFrame) && (player.hasPermission("GroupNode.InBuildMode"))) {}
		
		//Else if click item frame not in build mode
		else if(entity instanceof ItemFrame) {
			
			event.setCancelled(true);
		}
		
		//Else if entity is another player
		else if(entity instanceof Player) {
			
			//If player not in faction
			if(!player.hasPermission("GroupNode.RossFaction") && !player.hasPermission("GroupNode.LewisFaction") && !player.hasPermission("GroupNode.AlexFaction") && !player.hasPermission("GroupNode.CurtisFaction")) {
				
				event.setCancelled(true);
			}
		}
	}
	
//==================================================================================================================================

}
