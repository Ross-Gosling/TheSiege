//==================================================================================================================================

package me.x3DGosling.Siege_SpawnProtection;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import functions.Protection;

public class Main extends JavaPlugin {
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
	    		
		final int spawnRadius = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("SpawnProtectRadius");
		final int throneRadius = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("CastleSpawnProtectRadius");
		
		final int x_EmberstoneSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_SpawnCoords.X");
		final int y_EmberstoneSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_SpawnCoords.Y");
		final int z_EmberstoneSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_SpawnCoords.Z");
		final int x_EmberstoneThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_Castle_SpawnCoords.X");
		final int y_EmberstoneThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_Castle_SpawnCoords.Y");
		final int z_EmberstoneThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Emberstone_Castle_SpawnCoords.Z");
		
		final int x_MykonosSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_SpawnCoords.X");
		final int y_MykonosSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_SpawnCoords.Y");
		final int z_MykonosSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_SpawnCoords.Z");
		final int x_MykonosThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_Castle_SpawnCoords.X");
		final int y_MykonosThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_Castle_SpawnCoords.Y");
		final int z_MykonosThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Mykonos_Castle_SpawnCoords.Z");
		
		final int x_SummerholdSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_SpawnCoords.X");
		final int y_SummerholdSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_SpawnCoords.Y");
		final int z_SummerholdSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_SpawnCoords.Z");
		final int x_SummerholdThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_Castle_SpawnCoords.X");
		final int y_SummerholdThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_Castle_SpawnCoords.Y");
		final int z_SummerholdThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Summerhold_Castle_SpawnCoords.Z");
		
		final int x_IcarusSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_SpawnCoords.X");
		final int y_IcarusSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_SpawnCoords.Y");
		final int z_IcarusSpawn = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_SpawnCoords.Z");
		final int x_IcarusThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_Castle_SpawnCoords.X");
		final int y_IcarusThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_Castle_SpawnCoords.Y");
		final int z_IcarusThrone = me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Icarus_Castle_SpawnCoords.Z");
		
		//Creates a thread to perform systems every tick
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
        	public void run() {
        		
        		Protection.protect("Emberstone", x_EmberstoneSpawn, y_EmberstoneSpawn, z_EmberstoneSpawn, spawnRadius);
        		Protection.protect("Mykonos", x_MykonosSpawn, y_MykonosSpawn, z_MykonosSpawn, spawnRadius);
        		Protection.protect("Summerhold", x_SummerholdSpawn, y_SummerholdSpawn, z_SummerholdSpawn, spawnRadius);
        		Protection.protect("Icarus", x_IcarusSpawn, y_IcarusSpawn, z_IcarusSpawn, spawnRadius);
        		
        		Protection.protect("Emberstone", x_EmberstoneThrone, y_EmberstoneThrone, z_EmberstoneThrone, throneRadius);
        		Protection.protect("Mykonos", x_MykonosThrone, y_MykonosThrone, z_MykonosThrone, throneRadius);
        		Protection.protect("Summerhold", x_SummerholdThrone, y_SummerholdThrone, z_SummerholdThrone, throneRadius);
        		Protection.protect("Icarus", x_IcarusThrone, y_IcarusThrone, z_IcarusThrone, throneRadius);
        	}
		}, 0, 1);
		
		Bukkit.getLogger().info("Siege_SpawnProtection enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		Bukkit.getLogger().info("Siege_SpawnProtection disabled.");
	}
		
//==================================================================================================================================

}
