package playerHandling;

import factionSystems.Placement;
import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import testModeSystem.TestMode;

public class RespawnListener implements Listener {

//==================================================================================================================================

	//onPlayerRespawn Event
						
//==================================================================================================================================	
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		
		final Player player = event.getPlayer();
		String faction = "";
		String team = "";
		
		final Configuration config = Main.fetchConfig();
				
		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			//Do Nothing
		}
		
		else if(player.hasPermission("GroupNode.RossFaction")) {
		
			faction = "Emberstone";
			team = "Ross";
			
		    //player.getInventory().addItem(MakeItemStack.map(1, faction, 1));
		}
		
		else if(player.hasPermission("GroupNode.LewisFaction")) {
			
			faction = "Mykonos";
			team = "Lewis";
			
			//player.getInventory().addItem(MakeItemStack.map(1, faction, 2));
		}
		
		else if(player.hasPermission("GroupNode.AlexFaction")) {
			
			faction = "Summerhold";
			team = "Alex";
			
			//player.getInventory().addItem(MakeItemStack.map(1, faction, 3));
		}
		
		else if(player.hasPermission("GroupNode.CurtisFaction")) {
			
			faction = "Icarus";
			team = "Curtis";
			

			//player.getInventory().addItem(MakeItemStack.map(1, faction, 4));
		}
				
		player.getInventory().addItem(MakeItemStack.compass(1, faction));
		
		final String finalFaction = faction;
		final String finalTeam = team;
	    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	    	
	        public void run() {   
	        	
	        	Placement.spawn(player, finalFaction, finalTeam, config);
				Placement.join(player, finalFaction, finalTeam, config);
	        	
				Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
	        			
				location.setX(Main.fetchConfig().getInt(finalFaction + "_SpawnCoords.X") + 0.5);
				location.setY(Main.fetchConfig().getInt(finalFaction + "_SpawnCoords.Y") + 0.5);
				location.setZ(Main.fetchConfig().getInt(finalFaction + "_SpawnCoords.Z") + 0.5);
				
				player.setCompassTarget(location);
				
				if(TestMode.testModeActive) { TestMode.apply(player); }
	        }
	        
	    }, 1);
		
	    player.updateInventory();
	}
	
//==================================================================================================================================

}
