//==================================================================================================================================

package me.x3DGosling.Siege_InventorySystem;

import java.util.ArrayList;

import listeners.Click;
import listeners.Close;
import listeners.Open;
import listeners.ArmourSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static ArrayList<Material> immovableArmour = new ArrayList<Material>();
	public static ArrayList<Material> undroppableItems = new ArrayList<Material>();
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
	    
		//On all tiers
		immovableArmour.add(Material.LEATHER_HELMET);
		//Tier 1 armour
		immovableArmour.add(Material.LEATHER_BOOTS);
		//Tier 2 armour
		immovableArmour.add(Material.CHAINMAIL_LEGGINGS);
		immovableArmour.add(Material.IRON_BOOTS);
		immovableArmour.add(Material.GOLD_BOOTS);
		//Tier 3 armour
		immovableArmour.add(Material.IRON_LEGGINGS);
		immovableArmour.add(Material.DIAMOND_BOOTS);
		
		//Adds armour
		undroppableItems.addAll(immovableArmour);
		undroppableItems.add(Material.COMPASS);
		undroppableItems.add(Material.MAP);
		undroppableItems.add(Material.SADDLE);

		Bukkit.getServer().getPluginManager().registerEvents(new ArmourSystem(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Click(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Close(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Open(), this);
		
		Bukkit.getLogger().info("Siege_InventorySystem enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
					
		Bukkit.getLogger().info("Siege_InventorySystem disabled.");
	}

//==================================================================================================================================

}
