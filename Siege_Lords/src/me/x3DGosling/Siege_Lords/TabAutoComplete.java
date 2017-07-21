package me.x3DGosling.Siege_Lords;

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
		
		if(cmd.getName().equalsIgnoreCase("captain")) {
			
			if(sender instanceof Player) {
					
				if(args.length == 1) {
				
					tabList.add("add");
					tabList.add("remove");
				}
				
				else if(args.length == 2) {
					
					return null;
				}
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("banish") || cmd.getName().equalsIgnoreCase("unbanish")) {
			
			if(sender instanceof Player) {
					
				if(args.length == 1) {
				
					return null;
				}
			}
		}
		
		return tabList;
	}
}
