package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgPlayer {

	public static void message(Player player, String[] args) {

		if(player.hasPermission("GroupNode.Admin")) {

			String formattedMsg = "";
			
			Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
								
        	String msg = "";
        		
        	for( int i = 1; i <= args.length - 1; i++) {
        	
        		msg = msg + (args[i] + " ");
        	}
        		
        	formattedMsg = (ChatColor.DARK_GREEN + "To " + targetPlayer.getName() + ChatColor.GREEN + ": " + msg);
        	
        	player.sendMessage(formattedMsg);
				
			targetPlayer.sendMessage(ChatColor.DARK_GREEN + "From " + player.getName() + ChatColor.GREEN + ": " + msg);
		
            Bukkit.getLogger().info(formattedMsg);
		}
	}
}
