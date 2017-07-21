package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Captain {
	
	public static void cpt(Player player, String[] args) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
		}

		else if(player.hasPermission("GroupNode.Admin")) {
			
		    //Captain add command
			if(args[0].equalsIgnoreCase("add")) {
			
				add(player, args);
			}
			
		    //Captain remove command
			else if(args[0].equalsIgnoreCase("remove")) {
			
				remove(player, args);
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Usage: '/Captain add Fred' or '/Captain remove Fred'");
			}
		}
	}
	
	public static void add(Player player, String[] args) {
		
		Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
    	
		if(targetPlayer.hasPermission("GroupNode.Admin")) {
			
			player.sendMessage(ChatColor.RED + "Lords cannot be captains too");
		}
	    
		else if((player.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("GroupNode.RossFaction")) && !(targetPlayer.hasPermission("GroupNode.Captain"))) {
	    	
	    	applyCaptainStatus(player, targetPlayer, "Ross", "Emberstone");
		}
	    
	    else if((player.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.LewisFaction")) && !(targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
	    	applyCaptainStatus(player, targetPlayer, "Lewis", "Mykonos");
		}
        
	    else if((player.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.AlexFaction")) && !(targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
	    	applyCaptainStatus(player, targetPlayer, "Alex", "Summerhold");
        }
        
	    else if((player.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.CurtisFaction")) && !(targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
	    	applyCaptainStatus(player, targetPlayer, "Curtis", "Icarus");
		}
	    
	    else if(targetPlayer.hasPermission("GroupNode.Captain")) {
	    	
	    	player.sendMessage(ChatColor.RED + "This player is already a captain");
	    }
	
	    else {
	    	
	    	player.sendMessage(ChatColor.RED + "You can only promote players in your own faction");
	    }
	}
	
	public static void applyCaptainStatus(Player player, Player targetPlayer, String team, String faction) {
		
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + targetPlayer.getName() + " GroupNode.Captain");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manuaddsub " + targetPlayer.getName() + " " + team + "cpt");
    	
	    targetPlayer.sendMessage(ChatColor.GREEN + "You have been promoted by Lord " + player.getName() + "!");
    	
	    targetPlayer.sendMessage(ChatColor.RED + "You can now broadcast messages to your faction with '/f message'");
	    
        for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
        	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
        		
        		onlinePlayers.sendMessage(ChatColor.GREEN + targetPlayer.getName() + " is now a captain of " + faction + "!");
        	}
        }
	}
	
	public static void remove(Player player, String[] args) {
		
		Player targetPlayer = Bukkit.getServer().getPlayer(args[1]);
	    
		if((player.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("GroupNode.Captain"))) {
	    	
			deductCaptainStatus(player, targetPlayer, "Ross", "Emberstone");
		}
	    
		else if((player.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
			deductCaptainStatus(player, targetPlayer, "Lewis", "Mykonos");
		}
        
		else if((player.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
			deductCaptainStatus(player, targetPlayer, "Alex", "Summerhold");
        }
        
		else if((player.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.Captain"))) {
        	
			deductCaptainStatus(player, targetPlayer, "Curtis", "Icarus");
		}
		
	    else if((player.hasPermission("GroupNode.RossFaction")) && (targetPlayer.hasPermission("GroupNode.RossFaction"))) {
	    	
	    	player.sendMessage(ChatColor.RED + "This player is not a captain");
	    }
		
	    else if((player.hasPermission("GroupNode.LewisFaction")) && (targetPlayer.hasPermission("GroupNode.LewisFaction"))) {
	    	
	    	player.sendMessage(ChatColor.RED + "This player is not a captain");
	    }
		
	    else if((player.hasPermission("GroupNode.AlexFaction")) && (targetPlayer.hasPermission("GroupNode.AlexFaction"))) {
	    	
	    	player.sendMessage(ChatColor.RED + "This player is not a captain");
	    }
		
	    else if((player.hasPermission("GroupNode.CurtisFaction")) && (targetPlayer.hasPermission("GroupNode.CurtisFaction"))) {
	    	
	    	player.sendMessage(ChatColor.RED + "This player is not a captain");
	    }
        
	    else if(targetPlayer.hasPermission("GroupNode.Captain")) {
	    	
	    	player.sendMessage(ChatColor.RED + "You can only demote players in your own faction");
	    }
		
	    else {
	    	
	    	player.sendMessage(ChatColor.RED + "Error");
	    }
	}
		
	public static void deductCaptainStatus(Player player, Player targetPlayer, String team, String faction) {
		
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelp " + targetPlayer.getName() + " GroupNode.Captain");
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "manudelsub " + targetPlayer.getName() + " " + team + "cpt");
    	
	    targetPlayer.sendMessage(ChatColor.GREEN + "You have been demoted by Lord " + player.getName() + "!");
    	
	    targetPlayer.sendMessage(ChatColor.RED + "You can no longer broadcast messages to your faction");
	    
        for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
        	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
        		
        		onlinePlayers.sendMessage(ChatColor.GREEN + targetPlayer.getName() + " is no longer a captain of " + faction + "!");
        	}
        }
	}
}