package factionSystems;

import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import playerHandling.Functions;
import testModeSystem.TestMode;

public class SignProcesses {

	@SuppressWarnings("deprecation")
	public static void view(Player player, String city, Configuration config) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
			
		}
		
		else {
			
			player.setGameMode(GameMode.getByValue(3));
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + config.getInt(city + "_SpawnCoords.X") + " " + (config.getInt(city + "_SpawnCoords.Y")+1) + " " + (config.getInt(city + "_SpawnCoords.Z")) + " " + (config.getInt(city + "_SpawnCoords.R1")) + " " + (config.getInt(city + "_SpawnCoords.R2")));
			
			Functions.clearChat(player);
			
			player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "You are now in " + city);
			player.sendMessage(ChatColor.GREEN + "Use: /Return to get back to the lobby");
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void returnToLobby(Player player, Configuration config) {

		if(!(player.hasPermission("GroupNode.RossFaction")) && !(player.hasPermission("GroupNode.LewisFaction")) && !(player.hasPermission("GroupNode.AlexFaction")) && !(player.hasPermission("GroupNode.CurtisFaction"))) {
			
			if(player.getGameMode().equals(GameMode.getByValue(3))) {
			
				player.setGameMode(GameMode.SURVIVAL);
		
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + config.getString("World_SpawnCoords"));
				
				Functions.clearChat(player);
				
				player.sendMessage(ChatColor.GREEN + "You are now in the lobby");
			}
		}
	}
	
	public static void join(Player player, String team, Configuration config) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
			
		}
		
		else {
						
	    	if(player.getVehicle() != null) {
	    		
	    		player.getVehicle().eject();
	    		
	    	}
	    	
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " rossfaction");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " lewisfaction");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " alexfaction");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " curtisfaction");
	    	
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " rosscpt");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " lewiscpt");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " alexcpt");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " curtiscpt");
	    	
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " rossledr");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " lewisledr");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " alexledr");
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " curtisledr");
	    	
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clear " + player.getName());
	    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "effect " + player.getName() + " clear");
	    	
	        player.getEnderChest().clear();
		    player.setFoodLevel(20);
		    player.setHealth(40.0);
			
	    	if(team.equalsIgnoreCase("ross")) {
	    		
	    		if (player.hasPermission("Banished.Emberstone")) {
	    			    		
	    			player.sendMessage(ChatColor.RED + "You have been banished from Emberstone!");
	    			
	    		}
	    		
	    		else {
	    		
	    		    joinTeam(player, "Ross", "Emberstone", 1, config);
	    		
	    		}
	    		
	    	}
		    
	    	else if(team.equalsIgnoreCase("lewis")) {
	    		
	    		if (player.hasPermission("Banished.Mykonos")) {
		    		
	    			player.sendMessage(ChatColor.RED + "You have been banished from Mykonos!");
	    			
	    		}
	    		
	    		else {
	    		
	    		    joinTeam(player, "Lewis", "Mykonos", 2, config);
	    		
	    		}
	    		
	    	}
		    
	    	else if(team.equalsIgnoreCase("alex")) {
	    		
	    		if (player.hasPermission("Banished.Summerhold")) {
		    		
	    			player.sendMessage(ChatColor.RED + "You have been banished from Summerhold!");
	    			
	    		}
	    		
	    		else {
	    		
	    		    joinTeam(player, "Alex", "Summerhold", 3, config);
	    		
	    		}
	    		
	    	}
		    
	    	else if(team.equalsIgnoreCase("curtis")) {
	    		
	    		if (player.hasPermission("Banished.Icarus")) {
		    		
	    			player.sendMessage(ChatColor.RED + "You have been banished from Icarus!");
	    			
	    		}
	    		
	    		else {
	    		
	    		    joinTeam(player, "Curtis", "Icarus", 4, config);
	    		
	    		}
	    		
	    	}
	    	
		}
		
	}
	
	public static void joinTeam(final Player player, String team, final String faction, int mapID, final Configuration config) {
		
		player.setGameMode(GameMode.SURVIVAL);
		
    	if(player.hasPermission("GroupNode.Admin")) {
    		
    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddsub " + player.getName() + " " + team.toLowerCase() + "ledr");
    		
    	}
		
    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddsub " + player.getName() + " " + team.toLowerCase() + "faction");
    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join " + team + "Faction " + player.getName());
	    
	    Placement.join(player, faction, team, config);
	    Placement.spawn(player, faction, team, config);

		Bukkit.getScheduler().scheduleSyncDelayedTask( Main.fetchPlugin(), new Runnable() {
			
			public void run() {
				
			    //player.getInventory().addItem(makeItemStack.map(1, faction, mapID));
			    player.getInventory().addItem(MakeItemStack.compass(1, faction));

			    Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
			    
				location.setX(config.getInt(faction + "_SpawnCoords.X"));
				location.setY(config.getInt(faction + "_SpawnCoords.Y"));
				location.setZ(config.getInt(faction + "_SpawnCoords.Z"));
				
				player.setCompassTarget(location);
			    
				player.getInventory().addItem(MakeItemStack.rustySword());
			    player.getInventory().addItem(MakeItemStack.rustyAxe());
			    player.getInventory().addItem(MakeItemStack.rustyPick());
			    player.getInventory().addItem(MakeItemStack.biscuit(16));

				if(TestMode.testModeActive) { TestMode.apply(player); }
				
			    player.updateInventory();
				
			}
			
		}, 20L);
		
		Functions.clearChat(player);
		
        for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
        	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
        		
        		onlinePlayers.sendMessage(ChatColor.GREEN + player.getName() + " has joined " + faction);
        		
        	}
        	
        }
		
	}
	
}
