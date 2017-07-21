//==================================================================================================================================

package me.x3DGosling.Siege_Lords;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import commands.Captain;
import commands.Banish;


public class Main extends JavaPlugin {
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {

		Bukkit.getServer().getPluginCommand("captain").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("banish").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("unbanish").setTabCompleter(new TabAutoComplete());
		   
		Bukkit.getLogger().info("Siege_Lords enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		Bukkit.getLogger().info("Siege_Lords disabled.");
	}
		
//==================================================================================================================================

	//onCommand Event
	
//==================================================================================================================================
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
		
			Player player = (Player) sender;
			
			//Captain command
			if(commandLabel.equalsIgnoreCase("captain")) {
				
				Captain.cpt(player, args);
			}	
			
			//Banish command
			if(commandLabel.equalsIgnoreCase("banish")) {
				
				Banish.banish(player, args);
			}
			
			//Unbanish command
			if(commandLabel.equalsIgnoreCase("unbanish")) {
				
				Banish.unbanish(player, args);
			}
		}
		
		return false;
	}
		
//==================================================================================================================================
	
}
