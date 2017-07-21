package playerHandling;

import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import testModeSystem.TestMode;
import factionSystems.Placement;

public class JoinListener implements Listener {

//==================================================================================================================================

	//onPlayerJoin Event
				
//==================================================================================================================================
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		event.setJoinMessage(null);
				
		player.setMaxHealth(40.0);
				
		Configuration config = Main.fetchConfig();
			 
	    if(player.hasPermission("GroupNode.InBuildMode")) {
	    	
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
	        		
        		if(player.hasPermission("GroupNode.Admin")) {

				    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.WHITE + player.getName() + ChatColor.YELLOW + " joined the game");
        		}
        	}
	    }
	    
	    else if(!(player.hasPermission("GroupNode.RossFaction")) && !(player.hasPermission("GroupNode.LewisFaction")) && !(player.hasPermission("GroupNode.AlexFaction")) && !(player.hasPermission("GroupNode.CurtisFaction"))) {
	        
	    	//Sets spawn to lobby if they have no faction
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (config.getString("World_SpawnCoords")));
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (config.getString("World_SpawnCoords")));
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join LobbyTeam " + player.getName());
		    
	    	player.setGameMode(GameMode.SURVIVAL);
	    	
	    	player.getInventory().clear();
	    	player.updateInventory();
	    }
	    
	    else if(player.hasPermission("GroupNode.RossFaction")) {
	    	
			player.getInventory().remove(Material.COMPASS);
			player.getInventory().addItem(MakeItemStack.compass(1, "Emberstone"));

		    Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
		    
			location.setX(config.getInt("Emberstone_SpawnCoords.X"));
			location.setY(config.getInt("Emberstone_SpawnCoords.Y"));
			location.setZ(config.getInt("Emberstone_SpawnCoords.Z"));
			
			player.setCompassTarget(location);
	    	
	    	Placement.spawn(player, "Emberstone", "Ross", config);
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.RossFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.RED + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.LewisFaction")) {
			
			player.getInventory().remove(Material.COMPASS);
			player.getInventory().addItem(MakeItemStack.compass(1, "Mykonos"));

		    Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
		    
			location.setX(config.getInt("Mykonos_SpawnCoords.X"));
			location.setY(config.getInt("Mykonos_SpawnCoords.Y"));
			location.setZ(config.getInt("Mykonos_SpawnCoords.Z"));
			
			player.setCompassTarget(location);
			
	    	Placement.spawn(player, "Mykonos", "Lewis", config);
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.LewisFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.AlexFaction")) {
			
			player.getInventory().remove(Material.COMPASS);
			player.getInventory().addItem(MakeItemStack.compass(1, "Summerhold"));

		    Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
		    
			location.setX(config.getInt("Summerhold_SpawnCoords.X"));
			location.setY(config.getInt("Summerhold_SpawnCoords.Y"));
			location.setZ(config.getInt("Summerhold_SpawnCoords.Z"));
			
			player.setCompassTarget(location);
			
	    	Placement.spawn(player, "Summerhold", "Alex", config);
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.AlexFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.CurtisFaction")) {
			
			player.getInventory().remove(Material.COMPASS);
			player.getInventory().addItem(MakeItemStack.compass(1, "Icarus"));

		    Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
		    
			location.setX(config.getInt("Icarus_SpawnCoords.X"));
			location.setY(config.getInt("Icarus_SpawnCoords.Y"));
			location.setZ(config.getInt("Icarus_SpawnCoords.Z"));
			
			player.setCompassTarget(location);
			
	    	Placement.spawn(player, "Icarus", "Curtis", config);
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.CurtisFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " joined the game");
            		}
	        	}
        	}
        }
		
		else {
			
			player.sendMessage(ChatColor.YELLOW + player.getName() + " joined the game");
		}
		
		player.sendMessage(ChatColor.GREEN + "Welcome to " + (config.getString("Server_Name")));

		if(TestMode.testModeActive) { player.sendMessage(ChatColor.GOLD + "TestMode is active - no items gained will be kept upon deactivation"); }
		else { TestMode.clearInventory(player); }
	}

//==================================================================================================================================

}
