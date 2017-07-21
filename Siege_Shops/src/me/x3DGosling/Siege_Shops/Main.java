//==================================================================================================================================

package me.x3DGosling.Siege_Shops;

import listeners.InteractEntityListener;
import listeners.InteractShopListener;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import functions.SpawnTrader;

public class Main extends JavaPlugin {
	
	// Base values
	// String = 0.25;
	// Stick = 0.0625;
	// Leather = 1;
	// RustyIngot = 0.25;
	// DulledIngot = 1
	// IronIngot = 4;
	
	// Buy values
	// Armour
	public static int value_buy_IronHorseArmour = 13; 
	
	public static int value_buy_LeatherChestplate = 8;
	public static int value_buy_IronChestplate = 33;
	
	// Weapons
	public static int value_buy_FlimsyBow = 1;
	public static int value_buy_StandardBow = 5;
	
	public static int value_buy_Arrow1 = 1; public static int amount_buy_Arrow1 = 4; 
	public static int value_buy_Arrow2 = 4; public static int amount_buy_Arrow2 = 16; 
	public static int value_buy_Arrow3 = 16; public static int amount_buy_Arrow3 = 64; 
	
	public static int value_buy_RustyAxe = 1;
	public static int value_buy_RustyPickaxe = 1;
	public static int value_buy_RustySword = 1;
	
	public static int value_buy_DulledAxe = 4;
	public static int value_buy_DulledPickaxe = 4;
	public static int value_buy_DulledSword = 3;
	
	public static int value_buy_StandardAxe = 12;
	public static int value_buy_StandardPickaxe = 12;
	public static int value_buy_StandardSword = 8;

	// Saddles
	public static int value_buy_Saddle_Basic = 12;
	public static int value_buy_Saddle_Scout = 24;
	public static int value_buy_Saddle_Light = 36;
	
	// Equipment
	public static int value_buy_Flare = 2; public static int amount_buy_Flare = 8;
	
	public static int value_buy_FishingRod = 1;
	
	// Food
	public static int value_buy_Biscuit = 2; public static int amount_buy_Food = 8;
	public static int value_buy_Bread = 5;
	public static int value_buy_Potato = 6;
	public static int value_buy_Meat = 8;
	
	public static int value_buy_Haddock = 5;
	public static int value_buy_Salmon = 6;
	
	// Potions
	public static int value_buy_Potion_Invisibility_Lv1 = 16;
	public static int value_buy_Potion_Invisibility_Lv2 = 24;
	
	public static int value_buy_Potion_NightVision_Lv1 = 2;
	public static int value_buy_Potion_NightVision_Lv2 = 8;
	
	public static int value_buy_Potion_Speed_Lv1 = 8;
	public static int value_buy_Potion_Speed_Lv2 = 16;
	public static int value_buy_Potion_Speed_Lv3 = 24;
	
	// Materials
	public static int value_buy_Coal = 2; public static int amount_buy_Coal = 8;
	public static int value_buy_Stick = 1; public static int amount_buy_Stick = 16;
	public static int value_buy_String = 2; public static int amount_buy_String = 8;

	// Sell values
	public static int value_sell_Coal = 1; public static int amount_sell_Coal = 8;
	public static int value_sell_Log = 1; public static int amount_sell_Log = 8;
			
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
		
		Bukkit.getServer().getPluginCommand("trader").setTabCompleter(new TabAutoComplete());
		 	
		Bukkit.getServer().getPluginManager().registerEvents(new InteractEntityListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractShopListener(), this);
				
		Bukkit.getLogger().info("Siege_Shops enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
				
		Bukkit.getLogger().info("Siege_Shops disabled.");
	}
	
//==================================================================================================================================

	//onCommand Event
	
//==================================================================================================================================
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if(sender instanceof Player) {
					
			Player player = (Player) sender;
			
			//Trader command
			if(commandLabel.equalsIgnoreCase("trader")) {
				
				SpawnTrader.placeShop(player, args);
			}
		}
		
		return false;
	}
			
//==================================================================================================================================
	
}
