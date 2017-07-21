package me.x3DGosling.Siege_Mobs;

import listener.DamageListener;
import listener.DeathListener;
import listener.SpawnListener;
import listener.TargetListener;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
		
		//DamageListener
		Bukkit.getServer().getPluginManager().registerEvents(new DamageListener(), this);
		//DeathListener
		Bukkit.getServer().getPluginManager().registerEvents(new DeathListener(), this);	
		//SpawnListener
		Bukkit.getServer().getPluginManager().registerEvents(new SpawnListener(), this);
		//TargetListener
		Bukkit.getServer().getPluginManager().registerEvents(new TargetListener(), this);
		
		Bukkit.getLogger().info("Siege_Mobs enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		Bukkit.getLogger().info("Siege_Mobs disabled.");
	}
	
//==================================================================================================================================

}
