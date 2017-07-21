package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgAdmin {
	
	public static void message(Player player, String[] args) {

		if(player.hasPermission("GroupNode.Admin")) {
			
			if(args.length > 0) {
			
				String formattedMsg = "";
				
	            for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
	            		
	            	if(onlinePlayers.hasPermission("GroupNode.Admin")) {
	            		
	            		String msg = "";
	            		
	            		for( int i = 0; i <= args.length - 1; i++) {
	            	
	            			msg = msg + (args[i] + " ");
	            		}
	            		
	            		formattedMsg = (ChatColor.GOLD + "AC - " + player.getName() + ChatColor.YELLOW + ": " + msg);
	            		
						onlinePlayers.sendMessage(formattedMsg);
	            	}
				}
	            
	            Bukkit.getLogger().info(formattedMsg);
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Use: /A <message>");
			}
		}
	}
}
