package commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Rules {

	public static void broadcast(Player player, String[] args) {

		player.sendMessage("-----------------------------------");
		player.sendMessage(ChatColor.DARK_GREEN + "Rules:");
		player.sendMessage(ChatColor.GREEN + "1: " + ChatColor.WHITE + "Hacking will result in a perma-ban");
		player.sendMessage(ChatColor.GREEN + "2: " + ChatColor.WHITE + "Racism will not be tolerated");
		player.sendMessage(ChatColor.GREEN + "4: " + ChatColor.WHITE + "Do not bully other players");
		player.sendMessage(ChatColor.GREEN + "5: " + ChatColor.WHITE + "Do not ask to be an admin or operator");
		player.sendMessage(ChatColor.GREEN + "6: " + ChatColor.WHITE + "Do not ask to be teleported unless stuck");
		player.sendMessage(ChatColor.GREEN + "7: " + ChatColor.WHITE + "Abuse of help chat will result in a ban");
		player.sendMessage("-----------------------------------");
	}
}
