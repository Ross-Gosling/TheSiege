package me.x3DGosling.Siege_Horses;

import listeners.DamageListener;
import listeners.InteractHorseListener;
import listeners.SaddleListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

//==================================================================================================================================

//onEnable Event
		
//==================================================================================================================================
		
	public void onEnable() {
	    
		Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new InteractHorseListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new SaddleListener(), this);
		
		Bukkit.getServer().getLogger().info("Siege_Horses enabled.");
	}

//==================================================================================================================================
	
//onDisable Event
		
//==================================================================================================================================

	public void onDisable() {
				
		Bukkit.getServer().getLogger().info("Siege_Horses disabled.");
	}

//==================================================================================================================================
	
}
