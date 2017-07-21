package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgFaction {

	public static void message(Player player, String[] args) {

		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			player.sendMessage(ChatColor.RED + "You can't do this in Build-Mode");
		}
		
		else if((player.hasPermission("GroupNode.Captain")) || (player.hasPermission("GroupNode.Admin"))) {
		
			if(args.length > 0) {
			
				if(player.hasPermission("GroupNode.RossFaction")) {
	
					sendFactionMessage(player, args, "Ross", ChatColor.RED);
				}
				
				else if(player.hasPermission("GroupNode.LewisFaction")) {
	
					sendFactionMessage(player, args, "Lewis", ChatColor.LIGHT_PURPLE);
				}
				
				else if(player.hasPermission("GroupNode.AlexFaction")) {
	
					sendFactionMessage(player, args, "Alex", ChatColor.GREEN);
				}
				
				else if(player.hasPermission("GroupNode.CurtisFaction")) {
	
	                sendFactionMessage(player, args, "Curtis", ChatColor.AQUA);
				}
			}
				
			else {
				
				player.sendMessage(ChatColor.RED + "Use: /F <message>");
			}
		}
	}
	
	public static void sendFactionMessage(Player player, String[] args, String team, ChatColor nameColour) {
		
		if(player.hasPermission("GroupNode." + team + "Faction")) {

			String formattedMsg = "";
			
            for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
            	
            	if(onlinePlayers.hasPermission("GroupNode." + team + "Faction")) {
            		
            		String msg = "";
            		
            		for( int i = 0; i <= args.length - 1; i++) {
            	
            			msg = msg + (args[i] + " ");
            		}
            		
            		if(player.hasPermission("GroupNode.Admin")) {
                		
            			onlinePlayers.sendMessage(ChatColor.GOLD + "FC - " + "Lord " + nameColour + player.getName() + ChatColor.YELLOW + ": " + msg);
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(ChatColor.GOLD + "FC - " + "Cpt " + nameColour + player.getName() + ChatColor.YELLOW + ": " + msg);
            		}
            	}
            }
            
            Bukkit.getLogger().info(formattedMsg);
		}
	}
}
