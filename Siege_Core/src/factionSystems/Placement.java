package factionSystems;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import functions.CP_Functions;

public class Placement {

	public static void join(Player player, String faction, String team, Configuration config) {
		
        if((faction.equalsIgnoreCase("")) && (team.equalsIgnoreCase(""))) {
        	
        	//Sets spawn to lobby if the player has no faction
        	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (config.getString("World_SpawnCoords")));
        }
		
        else if(!CP_Functions.getCityCapped(faction, faction)) {
        	
    		//Sets Emberstone spawn to castle if cap a/b are taken
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (config.getInt(faction + "_Castle_SpawnCoords.X")) + " " + (config.getInt(faction + "_Castle_SpawnCoords.Y")+1) + " " + (config.getInt(faction + "_Castle_SpawnCoords.Z"))  + " " + (config.getInt(faction + "_Castle_SpawnCoords.R1")) + " " + (config.getInt(faction + "_Castle_SpawnCoords.R2")));
			
    	}
		
	    else if(CP_Functions.getCityCapped(faction, faction))  {
	    	
    		//Sets Emberstone spawn to default if the town is secured
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (config.getInt(faction + "_SpawnCoords.X")) + " " + (config.getInt(faction + "_SpawnCoords.Y")+1) + " " + (config.getInt(faction + "_SpawnCoords.Z"))  + " " + (config.getInt(faction + "_SpawnCoords.R1")) + " " + (config.getInt(faction + "_SpawnCoords.R2")));
			
    	}
		
	}
	
	public static void spawn(Player player, String faction, String team, Configuration config) {
		
        if((faction.equalsIgnoreCase("")) && (team.equalsIgnoreCase(""))) {
        	
        	//Sets spawn to lobby if the player has no faction
        	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (config.getString("World_SpawnCoords")));
        }
		
        else if(!CP_Functions.getCityCapped(faction, faction)) {
			
    		//Sets spawn to castle if cap a/b are taken
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (config.getInt(faction + "_Castle_SpawnCoords.X")) + " " + (config.getInt(faction + "_Castle_SpawnCoords.Y")+1) + " " + (config.getInt(faction + "_Castle_SpawnCoords.Z")));
		}
		    	
        else if(CP_Functions.getCityCapped(faction, faction)) {
        	
    		//Sets spawn to default if the town is secured
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (config.getInt(faction + "_SpawnCoords.X")) + " " + (config.getInt(faction + "_SpawnCoords.Y")+1) + " " + (config.getInt(faction + "_SpawnCoords.Z")));
		}
		
	}
		
}
