package commands;

import java.util.ArrayList;
import java.util.List;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class MeCmd {

	public static void message(Player player, String[] args) {

    	String rawMessage = "";
    		
    	for( int i = 0; i <= args.length - 1; i++) {
    	
    		rawMessage = rawMessage + (args[i] + " ");
    	}
    		
    	ChatColor nameColour = null;
    	
        if(player.hasPermission("GroupNode.InBuildMode")) {
        	nameColour = ChatColor.GOLD;
        }
        
        else if(player.hasPermission("GroupNode.RossFaction")) {
        	nameColour = ChatColor.RED;
        }
        
		else if(player.hasPermission("GroupNode.LewisFaction")) {
			nameColour = ChatColor.LIGHT_PURPLE;
        }
        
		else if(player.hasPermission("GroupNode.AlexFaction")) {
			nameColour = ChatColor.GREEN;
        }
        
		else if(player.hasPermission("GroupNode.CurtisFaction")) {
			nameColour = ChatColor.AQUA;
		}
        
        String formattedMsg = "";
        
		if(player.hasPermission("GroupNode.Admin")) {
			formattedMsg = ChatColor.WHITE + "* " + ChatColor.GOLD + "Lord " + nameColour + player.getName() + ChatColor.WHITE + " " + rawMessage;
		}
		
		else if(player.hasPermission("GroupNode.Captain")) {
			formattedMsg = ChatColor.WHITE + "* " + ChatColor.GOLD + "Cpt " + nameColour + player.getName() + ChatColor.WHITE + " " + rawMessage;
		}
		
		else {
			formattedMsg =  ChatColor.WHITE + "* " + nameColour + player.getName() + ChatColor.WHITE + " " + rawMessage;
		}
    	
		List<Player> nearbyPlayers = new ArrayList<Player>();
		
		double range = Main.fetchConfig().getInt("Chat-Range");
		
    	for(Entity recipients : player.getNearbyEntities(range, range, range)) {
        	    		
    		if(recipients instanceof Player) {
    			
    			if((((Player) recipients).hasPermission("GroupNode.InBuildMode")) || (((Player) recipients).hasPermission("GroupNode.RossFaction")) || (((Player) recipients).hasPermission("GroupNode.LewisFaction")) || (((Player) recipients).hasPermission("GroupNode.AlexFaction")) || (((Player) recipients).hasPermission("GroupNode.CurtisFaction"))) {
    				nearbyPlayers.add((Player) recipients);
    		    }
    		}
    	}
    	
    	Bukkit.getLogger().info(formattedMsg);
    	player.sendMessage(formattedMsg);
    	
    	if(nearbyPlayers.isEmpty()) {
    			    		
    		if(player.hasPermission("GroupNode.InBuildMode")) {
    			player.sendMessage(ChatColor.RED + "No one heard you... (Chat range is: " + (int)range + " blocks)");	    			
    		}
    		
    		else {
    			player.sendMessage(ChatColor.RED + "No one in your faction heard you... (Chat range is: " + (int)range + " blocks)");
    		}
    	}
    	
    	else {
    		
    		boolean friendlyClose = false;
    		
        	for(Player recipient : nearbyPlayers) {
        		
        		recipient.sendMessage(formattedMsg);

        		if((player.hasPermission("GroupNode.RossFaction"))) {
        			if((recipient.hasPermission("GroupNode.RossFaction")) && !(recipient.hasPermission("GroupNode.InBuildMode"))) {
        				friendlyClose = true;
        			}
        		}
        		
        		else if((player.hasPermission("GroupNode.LewisFaction"))) {
        			if((recipient.hasPermission("GroupNode.LewisFaction")) && !(recipient.hasPermission("GroupNode.InBuildMode"))) {
        				friendlyClose = true;
        			}
        		}
        		
        		else if((player.hasPermission("GroupNode.AlexFaction"))) {
        			if((recipient.hasPermission("GroupNode.AlexFaction")) && !(recipient.hasPermission("GroupNode.InBuildMode"))) {
        				friendlyClose = true;
        			}
        		}
        		
        		else if((player.hasPermission("GroupNode.CurtisFaction"))) {
        			if((recipient.hasPermission("GroupNode.CurtisFaction")) && !(recipient.hasPermission("GroupNode.InBuildMode"))) {
        				friendlyClose = true;
        			}
        		}
        	}
        	
    		if(player.hasPermission("GroupNode.InBuildMode")) {}
    		
    		else if(friendlyClose) {}
    		
        	else {
        		player.sendMessage(ChatColor.RED + "No one in your faction heard you... (Chat range is: " + (int)range + " blocks)");
        	}
    	}
	}
}
