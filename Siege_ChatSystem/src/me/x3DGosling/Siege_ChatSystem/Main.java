//==================================================================================================================================

package me.x3DGosling.Siege_ChatSystem;

import listener.ChatListener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import commands.MeCmd;
import commands.MsgFaction;
import commands.MsgAdmin;
import commands.MsgHelp;
import commands.MsgPlayer;

public class Main extends JavaPlugin {
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {

		Bukkit.getServer().getPluginCommand("a").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("f").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("h").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("me").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("msg").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("pm").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("tell").setTabCompleter(new TabAutoComplete());
		   
		Bukkit.getServer().getPluginManager().registerEvents(new ChatListener(), this);
		
		Bukkit.getLogger().info("Siege_ChatSystem enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		Bukkit.getLogger().info("Siege_ChatSystem disabled.");
	}

//==================================================================================================================================

	//onCommand Event
	
//==================================================================================================================================
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
		
			Player player = (Player) sender;
			
			//Me command
			if(commandLabel.equalsIgnoreCase("me")) {
				
				MeCmd.message(player, args);
			}
			
			//Faction broadcast command
			if(commandLabel.equalsIgnoreCase("f")) {
				
				MsgFaction.message(player, args);
			}
			
			//Admin chat command
			if(commandLabel.equalsIgnoreCase("a")) {
				
				MsgAdmin.message(player, args);
			}
			
			//Help chat command
			if(commandLabel.equalsIgnoreCase("h")) {
				
				MsgHelp.message(player, args);
			}
			
			//Tell or Msg command
			if((commandLabel.equalsIgnoreCase("pm")) || (commandLabel.equalsIgnoreCase("tell")) || (commandLabel.equalsIgnoreCase("msg"))) {
				
				MsgPlayer.message(player, args);
			}
		}
		
		return false;
	}
	
//==================================================================================================================================

}
