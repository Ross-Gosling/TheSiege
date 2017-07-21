package me.x3DGosling.Siege_Core;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import testModeSystem.TestMode;

public class TabAutoComplete implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
			
		List<String> tabList = new ArrayList<String>();
		
		if(cmd.getName().equalsIgnoreCase("testmode")) {
			
			if(sender instanceof Player) {
					
				if(args.length == 1) {
				
					if(TestMode.testModeActive) {
						
						tabList.add("off");
					}
					
					else {
					
					tabList.add("on");
					}
				}
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("reward")) {
			
			if(sender instanceof Player) {
					
				if(args.length == 1) {
				
					return null;
				}
			}
		}
				
		return tabList;
	}
}
