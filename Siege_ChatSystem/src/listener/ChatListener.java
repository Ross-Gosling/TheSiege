//==================================================================================================================================

package listener;

import java.util.ArrayList;
import java.util.List;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

//==================================================================================================================================

	@EventHandler
	public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
		
        String rawMessage = event.getMessage();
        String message = "";
        ChatColor nameColour = ChatColor.WHITE;
     
        Player player = event.getPlayer();
        event.getRecipients().clear();
           
		if((player.hasPermission("GroupNode.InBuildMode")) || (player.hasPermission("GroupNode.RossFaction")) || (player.hasPermission("GroupNode.LewisFaction")) || (player.hasPermission("GroupNode.AlexFaction")) || (player.hasPermission("GroupNode.CurtisFaction"))) {
			
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
	        
	        //=======
	        
			if(player.hasPermission("GroupNode.Admin")) {
				message = ChatColor.GOLD + "Lord " + nameColour + event.getPlayer().getName() + ChatColor.WHITE + ": " + rawMessage;
			}
			
			else if(player.hasPermission("GroupNode.Captain")) {
				message = ChatColor.GOLD + "Cpt " + nameColour + event.getPlayer().getName() + ChatColor.WHITE + ": " + rawMessage;
			}
			
			else {
				message =  nameColour + event.getPlayer().getName() + ChatColor.WHITE + ": " + rawMessage;
			}
			
			//=======
			
			List<Player> nearbyPlayers = new ArrayList<Player>();
			
			double range = Main.fetchConfig().getInt("Chat-Range");
			
	    	for(Entity recipients : player.getNearbyEntities(range, range, range)) {
	        	    		
	    		if(recipients instanceof Player) {
	    			
	    			if((((Player) recipients).hasPermission("GroupNode.InBuildMode")) || (((Player) recipients).hasPermission("GroupNode.RossFaction")) || (((Player) recipients).hasPermission("GroupNode.LewisFaction")) || (((Player) recipients).hasPermission("GroupNode.AlexFaction")) || (((Player) recipients).hasPermission("GroupNode.CurtisFaction"))) {
	    				nearbyPlayers.add((Player) recipients);
	    		    }
	    		}
	    	}
	    	
	    	Bukkit.getLogger().info(message);
	    	player.sendMessage(message);
	    	
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
	        		
	        		recipient.sendMessage(message);

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
		
		else {
			
			event.setCancelled(true);
		}
	}
	
//==================================================================================================================================

}
