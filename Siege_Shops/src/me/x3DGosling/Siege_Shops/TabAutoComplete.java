package me.x3DGosling.Siege_Shops;

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
		
		if(cmd.getName().equalsIgnoreCase("trader") && args.length == 1) {
			
			if(sender instanceof Player) {
					
				tabList.add("armour");
				tabList.add("axe");
				tabList.add("bow");
				tabList.add("equipment");
				tabList.add("fish");
				tabList.add("food");
				tabList.add("horse");
				tabList.add("material");
				tabList.add("pickaxe");
				tabList.add("potion");
				tabList.add("sword");
			}
		}
		
		return tabList;
	}
}
