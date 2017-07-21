package playerHandling;

import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Gamemode {
		
	public static void build(Player player) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You are already in Build-Mode");
		}
		
		else if(player.hasPermission("GroupNode.Admin")) {
		
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + player.getName() + "GroupNode.InBuildMode");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddsub " + player.getName() + " adminmode");
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams leave " + player.getName());
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join BuildTeam " + player.getName());
			
			player.setOp(true);
			player.setGameMode(GameMode.CREATIVE);
		    player.sendMessage(ChatColor.GREEN + "Build-Mode Enabled");
	    }
	}	
		
	public static void play(Player player) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + player.getName() + " GroupNode.InBuildMode");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + player.getName() + " adminmode");
			
			player.setOp(false);
			player.setGameMode(GameMode.SURVIVAL);
		    player.sendMessage(ChatColor.GREEN + "Play-Mode Enabled");
		    
		    player.getInventory().remove(Material.MAP);
			
			String team = "";
			String faction = "";
			//int mapID = 0;
			
		    if(player.hasPermission("GroupNode.RossFaction")) {
		    	
		    	team = "Ross";
				faction = "Emberstone";
				//mapID = 1;
		    }
		    
		    else if(player.hasPermission("GroupNode.LewisFaction")) {
		    	
		    	team = "Lewis";
				faction = "Mykonos";
				//mapID = 2;
		    }
		    
		    else if(player.hasPermission("GroupNode.AlexFaction")) {
		    	
		    	team = "Alex";
				faction = "Summerhold";
				//mapID = 3;
		    }
		    
		    else if(player.hasPermission("GroupNode.CurtisFaction")) {
		    	
		    	team = "Curtis";
				faction = "Icarus";
				//mapID = 4;
		    }

	    	if((player.hasPermission("GroupNode.RossFaction")) || (player.hasPermission("GroupNode.LewisFaction")) || (player.hasPermission("GroupNode.AlexFaction")) || (player.hasPermission("GroupNode.CurtisFaction"))) {
			    		  
	    		//miscSystem.spawnPlacement(player, faction, team);
	    		
	    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams leave " + player.getName());
	    		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join " + team + "Faction " + player.getName());
	    		
		    	player.getInventory().remove(Material.MAP);
		    	//player.getInventory().addItem(MakeItemStack.map(1, faction, mapID));
		    
		    	player.getInventory().remove(Material.COMPASS);
	    		player.getInventory().addItem(MakeItemStack.compass(1, faction));
	    	}
	    	
	    	else if(!(player.hasPermission("GroupNode.RossFaction")) && !(player.hasPermission("GroupNode.LewisFaction")) && !(player.hasPermission("GroupNode.AlexFaction")) && !(player.hasPermission("GroupNode.CurtisFaction"))) {
		        
		    	//Sets spawn to lobby if they have no faction
				Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (Main.fetchConfig().getString("World_SpawnCoords")));
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (Main.fetchConfig().getString("World_SpawnCoords")));
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams join LobbyTeam " + player.getName());
			    
		    	player.setGameMode(GameMode.SURVIVAL);
		    	
		    	player.getInventory().clear();
		    	player.updateInventory();
		    }
	    	
		    player.updateInventory();
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "You are already in Play-Mode");
		}
	}	
}
