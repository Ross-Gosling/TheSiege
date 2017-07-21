//==================================================================================================================================

package me.x3DGosling.Siege_Core;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import playerHandling.CraftListener;
import playerHandling.DamageListener;
import playerHandling.DeathListener;
import playerHandling.FishListener;
import playerHandling.Gamemode;
import playerHandling.HungerListener;
import playerHandling.InteractEntityListener;
import playerHandling.JoinListener;
import playerHandling.QuitListener;
import playerHandling.RespawnListener;
import playerHandling.ShootBowListener;
import rewardSystem.RewardCommand;
import testModeSystem.TestMode;
import weatherHandling.BlockFormListener;
import weatherHandling.SetWeather;
import blockHandling.BreakListener;
import blockHandling.InteractListener;
import blockHandling.PlaceListener;
import blockHandling.SpreadListener;
import blockHandling.TreeListener;
import itemHandling.ConsumeItemListener;
import itemHandling.CraftingRecipes;
import itemHandling.DespawnListener;
import itemHandling.DropListener;
import itemHandling.InteractItemListener;
import itemHandling.PickupListener;
import entityHandling.BreakEntityListener;
import factionSystems.Leave;
import factionSystems.SignListener;
import factionSystems.SignProcesses;

public class Main extends JavaPlugin {
	
    private static Plugin plugin;
    
    public static ArrayList<Block> awaitingRespawn_Coal = new ArrayList<Block>();
    public static ArrayList<Block> awaitingRespawn_Iron = new ArrayList<Block>();
    public static ArrayList<Block> awaitingRespawn_Gold = new ArrayList<Block>();
    public static ArrayList<Block> awaitingRespawn_Diamond = new ArrayList<Block>();
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
	    
		//Creates a config
		this.saveDefaultConfig();
	    
		plugin = this;
		
		Bukkit.getServer().getPluginCommand("reward").setTabCompleter(new TabAutoComplete());
		Bukkit.getServer().getPluginCommand("testmode").setTabCompleter(new TabAutoComplete());
		   
		//BlockHandling
		Bukkit.getServer().getPluginManager().registerEvents(new BreakListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new PlaceListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new SpreadListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new TreeListener(), plugin);
		//EntityHandling
		Bukkit.getServer().getPluginManager().registerEvents(new BreakEntityListener(), plugin);
		//FactionSystems
		Bukkit.getServer().getPluginManager().registerEvents(new SignListener(), plugin);
		//ItemHandling
		Bukkit.getServer().getPluginManager().registerEvents(new ConsumeItemListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new DespawnListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new DropListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractItemListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new PickupListener(), plugin);
		//PlayerHandling
		Bukkit.getServer().getPluginManager().registerEvents(new CraftListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new DeathListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new FishListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new HungerListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractEntityListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new QuitListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new RespawnListener(), plugin);
		Bukkit.getServer().getPluginManager().registerEvents(new ShootBowListener(), plugin);
		//WeatherHandling
		Bukkit.getServer().getPluginManager().registerEvents(new BlockFormListener(), plugin);
		
		//SetupCraftingRecipesClass
		CraftingRecipes.createRecipes();
						
		Bukkit.getLogger().info("Siege_Core enabled.");
		
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		plugin = null;

		for(Block block : awaitingRespawn_Coal) { block.setType(Material.COAL_ORE); }
		for(Block block : awaitingRespawn_Iron) { block.setType(Material.IRON_ORE); }
		for(Block block : awaitingRespawn_Gold) { block.setType(Material.GOLD_ORE); }
		for(Block block : awaitingRespawn_Diamond) { block.setType(Material.DIAMOND_ORE); }

		//Clears TestMode Items
		for(Player player : Bukkit.getServer().getOnlinePlayers()) { TestMode.clearInventory(player); }
		
		Bukkit.getLogger().info("Siege_Core disabled.");
		
	}
	
//==================================================================================================================================

	//fetchConfig Method
	
//==================================================================================================================================

	public static FileConfiguration fetchConfig() {
		return plugin.getConfig();
	}
	
//==================================================================================================================================

	//fetchPlugin Method
	
//==================================================================================================================================

	public static Plugin fetchPlugin() {
		return plugin;
	}
	
//==================================================================================================================================

	//onCommand Event
	
//==================================================================================================================================
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
				
		if(sender instanceof Player) {
		
			Player player = (Player) sender;
			
			//Play command
			if(commandLabel.equalsIgnoreCase("play")) {
				
				Gamemode.play(player);
				
			}	
			
			//Build command
			if(commandLabel.equalsIgnoreCase("build")) {
				
				Gamemode.build(player);
				
			}
			
			//Leave command
			if(commandLabel.equalsIgnoreCase("leave")) {
				
				Leave.leaveTeam(player, args);
				
			}	
			
			//Confirm command
			if(commandLabel.equalsIgnoreCase("confirm")) {
				
				Leave.confirm(player, plugin.getConfig());
				
			}
			
			//Return command
			if(commandLabel.equalsIgnoreCase("return")) {
				
				SignProcesses.returnToLobby(player, plugin.getConfig());
				
			}	
						
			//Sun weather command
			if(commandLabel.equalsIgnoreCase("sun")) {
	
				SetWeather.sun(player);
					
			}
			
			//Storm weather command
			if(commandLabel.equalsIgnoreCase("storm")) {
	
				SetWeather.storm(player);
					
			}
			
			//Day weather command
			if(commandLabel.equalsIgnoreCase("day")) {
	
				SetWeather.day(player);
					
			}
			
			//Night weather command
			if(commandLabel.equalsIgnoreCase("night")) {
	
				SetWeather.night(player);
					
			}
					    
			//Reward command
	        if(commandLabel.equalsIgnoreCase("reward")) {
					        	
	        	RewardCommand.reward(player, args);
				
			}
	        
			//Reward command
	        if(commandLabel.equalsIgnoreCase("testmode")) {
					        	
	        	TestMode.command(player, args);
				
			}		
		}
		
//==================================================================================================================================
				
		return false;
	}
	
//==================================================================================================================================

}