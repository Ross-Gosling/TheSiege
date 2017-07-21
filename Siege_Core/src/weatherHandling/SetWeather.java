package weatherHandling;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SetWeather {

	public static void sun(Player player) {

		if(player.hasPermission("GroupNode.Admin")) {
								
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear 900");
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 6000");

			Bukkit.broadcastMessage(ChatColor.GREEN + "Weather set to 'Sunny'");
			
		}
		
	}
	
	public static void storm(Player player) {

		if(player.hasPermission("GroupNode.Admin")) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather thunder 900");

			Bukkit.broadcastMessage(ChatColor.GREEN + "Weather set to 'Storm'");
			
		}
		
	}
	
	public static void day(Player player) {

		if(player.hasPermission("GroupNode.Admin")) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 6000");

			Bukkit.broadcastMessage(ChatColor.GREEN + "Time set to 'Day'");
			
		}
		
	}
	
	public static void night(Player player) {

		if(player.hasPermission("GroupNode.Admin")) {
			
			Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "time set 18000");

			Bukkit.broadcastMessage(ChatColor.GREEN + "Time set to 'Night'");
			
		}
		
	}
	
}
