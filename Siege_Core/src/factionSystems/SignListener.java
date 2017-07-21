//==================================================================================================================================

package factionSystems;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEvent Event
	
//==================================================================================================================================

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Block block = null;
		Action action = null;
		
		if(event.getClickedBlock() != null) {
			block = event.getClickedBlock();
		}
		
		if(event.getAction() != null) {
			action = event.getAction();
		}
		
		if((event.getAction() == null) || (event.getClickedBlock() == null)) {}
		
		else if(action.equals(Action.RIGHT_CLICK_BLOCK)) {
						
			//Right-Click Sign
			if(block.getType().equals(Material.WALL_SIGN)) {
				
				Configuration config = Main.fetchConfig();
				World world = Bukkit.getWorld("SiegeWorld");
				
				int rossSignX = (config.getInt("Signs.Ross.X"));
				int rossSignY = (config.getInt("Signs.Ross.Y"));
				int rossSignZ = (config.getInt("Signs.Ross.Z"));
								
				Location rossJoinSign = new Location(world, rossSignX, rossSignY, rossSignZ);
				
				int lewisSignX = (config.getInt("Signs.Lewis.X"));
				int lewisSignY = (config.getInt("Signs.Lewis.Y"));
				int lewisSignZ = (config.getInt("Signs.Lewis.Z"));
								
				Location lewisJoinSign = new Location(world, lewisSignX, lewisSignY, lewisSignZ);
				
				int alexSignX = (config.getInt("Signs.Alex.X"));
				int alexSignY = (config.getInt("Signs.Alex.Y"));
				int alexSignZ = (config.getInt("Signs.Alex.Z"));
								
				Location alexJoinSign = new Location(world, alexSignX, alexSignY, alexSignZ);
				
				int curtisSignX = (config.getInt("Signs.Curtis.X"));
				int curtisSignY = (config.getInt("Signs.Curtis.Y"));
				int curtisSignZ = (config.getInt("Signs.Curtis.Z"));
								
				Location curtisJoinSign = new Location(world, curtisSignX, curtisSignY, curtisSignZ);
				
				if(block.getLocation().equals(rossJoinSign)) {
					
					SignProcesses.join(player, "ross", config);
					
				}
				
				else if(block.getLocation().equals(lewisJoinSign)) {
					
					SignProcesses.join(player, "lewis", config);
					
				}
				
				else if(block.getLocation().equals(alexJoinSign)) {
					
					SignProcesses.join(player, "alex", config);
					
				}
				
				else if(block.getLocation().equals(curtisJoinSign)) {
					
					SignProcesses.join(player, "curtis", config);
					
				}
				
			}
			
		}
		
		else if(action.equals(Action.LEFT_CLICK_BLOCK)) {
			
			//Left-Click Sign
			if(block.getType().equals(Material.WALL_SIGN)) {
				
				Configuration config = Main.fetchConfig();
				World world = Bukkit.getWorld("SiegeWorld");
				
				int rossSignX = (config.getInt("Signs.Ross.X"));
				int rossSignY = (config.getInt("Signs.Ross.Y"));
				int rossSignZ = (config.getInt("Signs.Ross.Z"));
								
				Location rossJoinSign = new Location(world, rossSignX, rossSignY, rossSignZ);
				
				int lewisSignX = (config.getInt("Signs.Lewis.X"));
				int lewisSignY = (config.getInt("Signs.Lewis.Y"));
				int lewisSignZ = (config.getInt("Signs.Lewis.Z"));
								
				Location lewisJoinSign = new Location(world, lewisSignX, lewisSignY, lewisSignZ);
				
				int alexSignX = (config.getInt("Signs.Alex.X"));
				int alexSignY = (config.getInt("Signs.Alex.Y"));
				int alexSignZ = (config.getInt("Signs.Alex.Z"));
								
				Location alexJoinSign = new Location(world, alexSignX, alexSignY, alexSignZ);
				
				int curtisSignX = (config.getInt("Signs.Curtis.X"));
				int curtisSignY = (config.getInt("Signs.Curtis.Y"));
				int curtisSignZ = (config.getInt("Signs.Curtis.Z"));
								
				Location curtisJoinSign = new Location(world, curtisSignX, curtisSignY, curtisSignZ);
				
				if(block.getLocation().equals(rossJoinSign)) {
					
					SignProcesses.view(player, "Emberstone", config);
					
				}
				
				else if(block.getLocation().equals(lewisJoinSign)) {
					
					SignProcesses.view(player, "Mykonos", config);
					
				}
				
				else if(block.getLocation().equals(alexJoinSign)) {
					
					SignProcesses.view(player, "Summerhold", config);
					
				}
				
				else if(block.getLocation().equals(curtisJoinSign)) {
					
					SignProcesses.view(player, "Icarus", config);
					
				}
				
			}
			
		}
		
	}	

//==================================================================================================================================

}
