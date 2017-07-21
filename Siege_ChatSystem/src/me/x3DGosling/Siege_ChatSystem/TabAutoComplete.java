package me.x3DGosling.Siege_ChatSystem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabAutoComplete implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
			
		List<String> tabList = new ArrayList<String>();
		
		if(cmd.getName().equalsIgnoreCase("msg") || cmd.getName().equalsIgnoreCase("pm") || cmd.getName().equalsIgnoreCase("tell")) {
			
			if(sender instanceof Player) {
					
				if(args.length == 1) {
				
					return null;
				}
			}
		}
				
		return tabList;
	}
}
