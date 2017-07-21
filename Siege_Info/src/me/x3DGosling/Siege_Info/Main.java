//==================================================================================================================================

package me.x3DGosling.Siege_Info;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import commands.Help;
import commands.Rules;

public class Main extends JavaPlugin {
	
//==================================================================================================================================

//onEnable Event
		
//==================================================================================================================================
		
	public void onEnable() {
		
		Bukkit.getServer().getPluginCommand("help").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("rules").setTabCompleter(new TabAutoComplete());
		   
		Bukkit.getServer().getLogger().info("Siege_Info enabled.");
	}

//==================================================================================================================================
	
//onDisable Event
		
//==================================================================================================================================

	public void onDisable() {
				
		Bukkit.getServer().getLogger().info("Siege_Info disabled.");
	}

//==================================================================================================================================

//onCommand Event

//==================================================================================================================================
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
		
			Player player = (Player) sender;
			
			//Help command
			if(commandLabel.equalsIgnoreCase("help")) {
				
				Help.broadcast(player, args);
			}
			
			//Rules command
			if(commandLabel.equalsIgnoreCase("rules")) {
				
				Rules.broadcast(player, args);
			}
		}
		
		return false;
	}
	
//==================================================================================================================================

}
