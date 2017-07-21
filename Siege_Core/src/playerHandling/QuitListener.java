package playerHandling;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

//==================================================================================================================================

	//onPlayerQuit Event
					
//==================================================================================================================================
		
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		
		Player player = event.getPlayer();
		event.setQuitMessage(null);
		
	    if(player.hasPermission("GroupNode.InBuildMode")) {
	    	
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
	        		
        		if(player.hasPermission("GroupNode.Admin")) {

				    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.WHITE + player.getName() + ChatColor.YELLOW + " left the game");
        		}
        	}
	    }
		
		else if(player.hasPermission("GroupNode.RossFaction")) {
		
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.RossFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.RED + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.RED + player.getName() + ChatColor.YELLOW + " left the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.LewisFaction")) {
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.LewisFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.LIGHT_PURPLE + player.getName() + ChatColor.YELLOW + " left the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.AlexFaction")) {
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.AlexFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.GREEN + player.getName() + ChatColor.YELLOW + " left the game");
            		}
	        	}
        	}
        }
		
		else if(player.hasPermission("GroupNode.CurtisFaction")) {
			
        	for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
        	
	        	if(onlinePlayers.hasPermission("GroupNode.CurtisFaction")) {
	        		
            		if(player.hasPermission("GroupNode.Admin")) {

					    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else if(player.hasPermission("GroupNode.Captain")) {

            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " left the game");
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.AQUA + player.getName() + ChatColor.YELLOW + " left the game");
            		}
	        	}
        	}
        }
		
		else {
			
			player.sendMessage(ChatColor.YELLOW + player.getName() + " left the game");
		}
	}

//==================================================================================================================================

	
}
