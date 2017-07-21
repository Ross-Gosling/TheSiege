package factionSystems;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;

import playerHandling.Functions;

public class Leave {
	
	private final static HashMap<String, Boolean> confirmLeave = new HashMap<String, Boolean>();
	
	public static void leaveTeam(Player player, String[] args) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
			
		}
		
		else if((player.hasPermission("GroupNode.RossFaction")) || (player.hasPermission("GroupNode.LewisFaction")) || (player.hasPermission("GroupNode.AlexFaction")) || (player.hasPermission("GroupNode.CurtisFaction"))) {
			
			confirmLeave.put(player.getDisplayName(), true);
			
			player.sendMessage(ChatColor.GREEN + "WARNING: Leaving a faction will clear all of your possessions!");
			player.sendMessage(ChatColor.GREEN + "Use: /Confirm to accept and leave");
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "You are not in a faction");
			
		}
		
	}
	
	public static void confirm(Player player, Configuration config) {

		if((confirmLeave.containsKey(player.getDisplayName())) && (confirmLeave.containsValue(true))) {
	
			if(player.hasPermission("GroupNode.InBuildMode")) {
				
				player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
						
			}
			
			else if(player.hasPermission("GroupNode.RossFaction")) {
				
				playerLeave(player, "Ross", "Emberstone", config);
			    
			}
			
			else if(player.hasPermission("GroupNode.LewisFaction")) {
				
				playerLeave(player, "Lewis", "Mykonos", config);
		    	
			}
		    
			else if(player.hasPermission("GroupNode.AlexFaction")) {
				
				playerLeave(player, "Alex", "Summerhold", config);
			    
			}
		    
			else if(player.hasPermission("GroupNode.CurtisFaction")) {
				
				playerLeave(player, "Curtis", "Icarus", config);
			    
			}
			
			confirmLeave.put(player.getDisplayName(), null);
			
		}
	
	}
		
	public static void playerLeave(Player player, String team, String faction, Configuration config) {
		
    	if(player.getVehicle() != null) {
    		
    		player.getVehicle().eject();
    		
    	}
    	
    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + player.getName() + " GroupNode.Captain");
	    
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
	    
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams leave " + player.getName());

	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clear " + player.getName());
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "effect " + player.getName() + " clear");
    	
        player.getEnderChest().clear();
	    player.setFoodLevel(20);
	    player.setHealth(40.0);
	    
		List<Entity> entities = player.getLocation().getWorld().getEntities();
		for(Entity entity : entities) {
			if(entity instanceof Horse) {
				if(((Horse)entity).getOwner().equals(((AnimalTamer)player))) {
					entity.remove();
				}
			}
		}
	    
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + player.getName() + " " + (config.getString("World_SpawnCoords")));
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + player.getName() + " " + (config.getString("World_SpawnCoords")));
	    
	    Functions.clearChat(player);
	    
	    player.sendMessage(ChatColor.GREEN + "You have abandoned " + faction);
	    
    	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
        	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
        		
        		onlinePlayers.sendMessage(ChatColor.RED + player.getName() + " has left " + faction);
        		
        	}
        	
    	}
		
	}
	
}
