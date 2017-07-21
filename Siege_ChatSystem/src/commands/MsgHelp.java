package commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgHelp {

	public static void message(Player player, String[] args) {

		if(args.length > 0) {
		
			String formattedMsg = "";
			List<Player> admins = new ArrayList<Player>();
		
		    for(Player onlinePlayer: Bukkit.getServer().getOnlinePlayers()) {
		    	
		    	if(onlinePlayer.hasPermission("GroupNode.Admin")) {
		    		
		    		admins.add(onlinePlayer);
		    	}
			}
		    
	    	if(admins.isEmpty()) {}
	    	
	    	else {
	    		    		
	    	    for(Player onlineAdmin: admins) {
	    	    	
	    			String msg = "";
	    			
	    			for( int i = 0; i <= args.length - 1; i++) {
	    		
	    				msg = msg + (args[i] + " ");
	    			}
	    	    	   
		    		formattedMsg = (ChatColor.DARK_AQUA + "HC - " + player.getName() + ChatColor.BLUE + ": " + msg);
		    		
		    		player.sendMessage(ChatColor.GREEN + "> " + onlineAdmin.getName() + " has been notified");
		    		
		    		onlineAdmin.sendMessage(formattedMsg);
		    	}
	    	    
	    	    Bukkit.getLogger().info(formattedMsg);
			}
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "Use: /H <message>");
		}
	}
}
