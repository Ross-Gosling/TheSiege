package listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import functions.TradeOffers;

public class InteractEntityListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEntityEvent Event
		
//==================================================================================================================================
		
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		
    	Player player = event.getPlayer();
    	Entity entity = event.getRightClicked();
    			
		Block regionBlock = entity.getLocation().getWorld().getBlockAt((int)entity.getLocation().getX(), (int)0, (int)entity.getLocation().getZ());
		    	
		if(entity instanceof Villager) {
			
			event.setCancelled(true);
			
			// Mob is spawning in a city region
			if(regionBlock.getType().equals(Material.STAINED_CLAY)) {
				
				//If player in emberstone and in ross faction
				if((regionBlock.getData() == (byte)1) && (player.hasPermission("GroupNode.RossFaction"))) {
					
					TradeOffers.Open(player, entity);
				}
				
				//Else if player in mykonos and in lewis faction
				else if((regionBlock.getData() == (byte)2) && (player.hasPermission("GroupNode.LewisFaction"))) {
					
					TradeOffers.Open(player, entity);
				}
				
				//Else if player in summerhold and in alex faction
				else if((regionBlock.getData() == (byte)3) && (player.hasPermission("GroupNode.AlexFaction"))) {
					
					TradeOffers.Open(player, entity);
				}
				
				//Else if player in icarus and in curtis faction
				else if((regionBlock.getData() == (byte)4) && (entity.getLocation().getY() > 100) && (player.hasPermission("GroupNode.CurtisFaction"))) {
					
					TradeOffers.Open(player, entity);
				}
			
				//Else
				else {
									
					player.sendMessage(ChatColor.RED + "You cannot trade with hostile merchants");
				}
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Error - This merchant doesn't reside in a city");
			}
		}
	}
	
//==================================================================================================================================

}
