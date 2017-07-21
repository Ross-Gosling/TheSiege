package me.x3DGosling.Siege_Info;

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
		
		if(cmd.getName().equalsIgnoreCase("help")) {
			
			if(sender instanceof Player) {
					
				if(sender.hasPermission("GroupNode.InBuildMode")) {
				
					if(args.length == 1) {
					
						tabList.add("shops");
						tabList.add("teleports");
					}
				}
			}
		}
				
		return tabList;
	}
}
