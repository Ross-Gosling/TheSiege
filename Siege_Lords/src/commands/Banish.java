package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Banish {

	public static void banish(Player player, String[] args) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
		}
		
		else if(player.hasPermission("GroupNode.Admin")) {
	    	
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
		    
		    if((player.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("GroupNode.RossFaction"))) {
		    	
		    	banishPlayer(player, targetPlayer, "Ross", "Emberstone", ChatColor.RED);
			}
		    
		    else if((player.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.LewisFaction"))) {
            	
		    	banishPlayer(player, targetPlayer, "Lewis", "Mykonos", ChatColor.LIGHT_PURPLE);
			}
            
		    else if((player.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.AlexFaction"))) {
            	
		    	banishPlayer(player, targetPlayer, "Alex", "Summerhold", ChatColor.GREEN);
            }
            
		    else if((player.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.CurtisFaction"))) {
            	
		    	banishPlayer(player, targetPlayer, "Curtis", "Icarus", ChatColor.AQUA);
			}
		    
		    else {
		    	
		    	player.sendMessage(ChatColor.RED + "You can only banish players in your own faction");
		    }
		}
	}
	
	public static void banishPlayer(Player player, Player targetPlayer, String team, String faction, ChatColor teamColour) {
		
       	if(targetPlayer.getVehicle() != null) {
    		
    		targetPlayer.getVehicle().eject();
    	}
    	
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + targetPlayer.getName() + " " + team + "faction");
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " GroupNode.Captain");
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + targetPlayer.getName() + " " + team + "cpt");
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + targetPlayer.getName() + " " + team + "ledr");
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "scoreboard teams leave " + targetPlayer.getName());

       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clear " + player.getName());
       	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "effect " + player.getName() + " clear");
    	
        player.getEnderChest().clear();
	    player.setFoodLevel(20);
	    player.setHealth(40.0);
	    
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + targetPlayer.getName() + " Banished." + faction);
	    
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tp " + targetPlayer.getName() + " " + (me.x3DGosling.Siege_Core.Main.fetchConfig().getString("World_SpawnCoords")));
	    Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "spawnpoint " + targetPlayer.getName() + " " + (me.x3DGosling.Siege_Core.Main.fetchConfig().getString("World_SpawnCoords")));
	    targetPlayer.sendMessage(ChatColor.RED + "You have been outlawed!");
	    
    	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
        	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
        		
        		onlinePlayers.sendMessage(ChatColor.GREEN + targetPlayer.getName() + " has been banished from " + faction + " by " +  ChatColor.GOLD + "Lord " + teamColour + player.getName() + "!");
        	}
    	}
	}

	public static void unbanish(Player player, String[] args) {
		
		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
		}
		
		else if(player.hasPermission("GroupNode.Admin")) {
	    	
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
		    
		    if((player.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("Banished.Emberstone"))) {
		    	
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " Banished.Emberstone");
		    	targetPlayer.sendMessage(ChatColor.GREEN + "You have been unbanished from Emberstone!");
			}
		    
		    else if((player.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.LewisFaction"))) {
            	
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " Banished.Mykonos");
		    	targetPlayer.sendMessage(ChatColor.GREEN + "You have been unbanished from Mykonos!");
			}
            
		    else if((player.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.AlexFaction"))) {
            	
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " Banished.Summerhold");
		    	targetPlayer.sendMessage(ChatColor.GREEN + "You have been unbanished from Summerhold!");
            }
            
		    else if((player.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.CurtisFaction"))) {
            	
		    	Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " Banished.Icarus");
		    	targetPlayer.sendMessage(ChatColor.GREEN + "You have been unbanished from Icarus!");
			}
		    
		    else {
		    	
		    	player.sendMessage(ChatColor.RED + "You can only unbanish players who are banished from your own faction");
		    }
		}
	}
}
