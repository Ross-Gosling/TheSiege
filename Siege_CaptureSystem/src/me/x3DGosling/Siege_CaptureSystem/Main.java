//==================================================================================================================================

package me.x3DGosling.Siege_CaptureSystem;

import java.util.concurrent.atomic.AtomicReference;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import functions.CP_Functions;
import functions.CapturePoint_City;
import functions.CapturePoint_Fort;
import functions.CapturePoint_Throne;

public class Main extends JavaPlugin {

	public static double capRadius_Throne = 5.5D;
	public static double capRadius_City = 3.5D;
	public static double capRadius_Fort = 5.5D;
	
	public static AtomicReference<Double> capLevel_EastFort = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_WestFort = new AtomicReference<Double>(0.0);
	
	public static AtomicReference<Double> capLevel_Emberstone_Throne = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Mykonos_Throne = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Summerhold_Throne = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Icarus_Throne = new AtomicReference<Double>(0.0);
	
	public static AtomicReference<Double> capLevel_Emberstone_A = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Mykonos_A = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Summerhold_A = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Icarus_A = new AtomicReference<Double>(0.0);
	
	public static AtomicReference<Double> capLevel_Emberstone_B = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Mykonos_B = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Summerhold_B = new AtomicReference<Double>(0.0);
	public static AtomicReference<Double> capLevel_Icarus_B = new AtomicReference<Double>(0.0);
	
	public static AtomicReference<String> capturer_EastFort = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_WestFort = new AtomicReference<String>("");
	
	public static AtomicReference<String> capturer_Emberstone_Throne = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Mykonos_Throne = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Summerhold_Throne = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Icarus_Throne = new AtomicReference<String>("");
	
	public static AtomicReference<String> capturer_Emberstone_A = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Mykonos_A = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Summerhold_A = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Icarus_A = new AtomicReference<String>("");
	
	public static AtomicReference<String> capturer_Emberstone_B = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Mykonos_B = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Summerhold_B = new AtomicReference<String>("");
	public static AtomicReference<String> capturer_Icarus_B = new AtomicReference<String>("");
	
	public static AtomicReference<String> capturedBy_EastFort = new AtomicReference<String>("");
	public static AtomicReference<String> capturedBy_WestFort = new AtomicReference<String>("");
	
	public static AtomicReference<String> capturedBy_Emberstone_Throne = new AtomicReference<String>("Emberstone");
	public static AtomicReference<String> capturedBy_Mykonos_Throne = new AtomicReference<String>("Mykonos");
	public static AtomicReference<String> capturedBy_Summerhold_Throne = new AtomicReference<String>("Summerhold");
	public static AtomicReference<String> capturedBy_Icarus_Throne = new AtomicReference<String>("Icarus");
	
	public static AtomicReference<String> capturedBy_Emberstone_A = new AtomicReference<String>("Emberstone");
	public static AtomicReference<String> capturedBy_Mykonos_A = new AtomicReference<String>("Mykonos");
	public static AtomicReference<String> capturedBy_Summerhold_A = new AtomicReference<String>("Summerhold");
	public static AtomicReference<String> capturedBy_Icarus_A = new AtomicReference<String>("Icarus");
	
	public static AtomicReference<String> capturedBy_Emberstone_B = new AtomicReference<String>("Emberstone");
	public static AtomicReference<String> capturedBy_Mykonos_B = new AtomicReference<String>("Mykonos");
	public static AtomicReference<String> capturedBy_Summerhold_B = new AtomicReference<String>("Summerhold");
	public static AtomicReference<String> capturedBy_Icarus_B = new AtomicReference<String>("Icarus");
	
	public static AtomicReference<Boolean> locked_EastFort = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_WestFort = new AtomicReference<Boolean>(false);
	
	public static AtomicReference<Boolean> locked_Emberstone_Throne = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Mykonos_Throne = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Summerhold_Throne = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Icarus_Throne = new AtomicReference<Boolean>(false);
	
	public static AtomicReference<Boolean> locked_Emberstone_A = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Mykonos_A = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Summerhold_A = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Icarus_A = new AtomicReference<Boolean>(false);
	
	public static AtomicReference<Boolean> locked_Emberstone_B = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Mykonos_B = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Summerhold_B = new AtomicReference<Boolean>(false);
	public static AtomicReference<Boolean> locked_Icarus_B = new AtomicReference<Boolean>(false);
	
//==================================================================================================================================

	//onEnable Event
	
//==================================================================================================================================
	
	public void onEnable() {
	    		
		// Creates a thread to perform systems every second (20 ticks)
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
        	public void run() {
        		
        		// Updates Fort capture points
        		CapturePoint_Fort.update("East", capLevel_EastFort, capturer_EastFort, capturedBy_EastFort, locked_EastFort);
        		CapturePoint_Fort.update("West", capLevel_WestFort, capturer_WestFort, capturedBy_WestFort, locked_WestFort);
        		
        		// Updates Emberstone capture points
        		CapturePoint_Throne.update("Emberstone", capLevel_Emberstone_Throne, capturer_Emberstone_Throne, capturedBy_Emberstone_Throne, locked_Emberstone_Throne);
        		CapturePoint_City.update("A", "Emberstone", capLevel_Emberstone_A, capturer_Emberstone_A, capturedBy_Emberstone_A, locked_Emberstone_A);
        		CapturePoint_City.update("B", "Emberstone", capLevel_Emberstone_B, capturer_Emberstone_B, capturedBy_Emberstone_B, locked_Emberstone_B);

        		// Updates Mykonos capture points
        		CapturePoint_Throne.update("Mykonos", capLevel_Mykonos_Throne, capturer_Mykonos_Throne, capturedBy_Mykonos_Throne, locked_Mykonos_Throne);
        		CapturePoint_City.update("A", "Mykonos", capLevel_Mykonos_A, capturer_Mykonos_A, capturedBy_Mykonos_A, locked_Mykonos_A);
        		CapturePoint_City.update("B", "Mykonos", capLevel_Mykonos_B, capturer_Mykonos_B, capturedBy_Mykonos_B, locked_Mykonos_B);

        		// Updates Summerhold capture points
        		CapturePoint_Throne.update("Summerhold", capLevel_Summerhold_Throne, capturer_Summerhold_Throne, capturedBy_Summerhold_Throne, locked_Summerhold_Throne);
        		CapturePoint_City.update("A", "Summerhold", capLevel_Summerhold_A, capturer_Summerhold_A, capturedBy_Summerhold_A, locked_Summerhold_A);
        		CapturePoint_City.update("B", "Summerhold", capLevel_Summerhold_B, capturer_Summerhold_B, capturedBy_Summerhold_B, locked_Summerhold_B);

        		// Updates Icarus capture points
        		CapturePoint_Throne.update("Icarus", capLevel_Icarus_Throne, capturer_Icarus_Throne, capturedBy_Icarus_Throne, locked_Icarus_Throne);
        		CapturePoint_City.update("A", "Icarus", capLevel_Icarus_A, capturer_Icarus_A, capturedBy_Icarus_A, locked_Icarus_A);
        		CapturePoint_City.update("B", "Icarus", capLevel_Icarus_B, capturer_Icarus_B, capturedBy_Icarus_B, locked_Icarus_B);
        		
        		// Distributes reward effects
        		CP_Functions.reward();
        	}
			
		}, 0, 20);
								
		Bukkit.getLogger().info("Siege_CaptureSystem enabled.");
	}

//==================================================================================================================================
	
	//onDisable Event
	
//==================================================================================================================================

	public void onDisable() {
		
		// Reset all capture points
				
		Bukkit.getLogger().info("Siege_CaptureSystem disabled.");
	}
		
//==================================================================================================================================

}
