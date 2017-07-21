package functions;

import java.util.concurrent.atomic.AtomicReference;

import me.x3DGosling.Siege_CaptureSystem.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CP_Functions {
	
//==================================================================================================================================
		
	public static void reward() {

    	for(Player player: Bukkit.getServer().getOnlinePlayers()) {
    		
    		if(player.hasPermission("GroupNode.InBuildMode")) { }
        	
    		else {
    			apply("Ross", "Emberstone", player);  			
    			apply("Lewis", "Mykonos", player); 
    			apply("Alex", "Summerhold", player); 
    			apply("Curtis", "Icarus", player); 
    		}
    	}
	}
	
	public static void apply(String team, String faction, Player player) {
		
		if(player.hasPermission("GroupNode." + team + "Faction")) {
			
			if(getFortsCapped(faction) > 0) {
				
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, (int) 60, (int) (getFortsCapped(faction) - 1), true), true);
			}
		}		
	}
	
//==================================================================================================================================
	
	public static int getFortsCapped(String faction) {
		
		if((Main.capturedBy_EastFort.get().equals(faction)) && (Main.capturedBy_WestFort.get().equals(faction))) { return 2; }
		
		else if(Main.capturedBy_EastFort.get().equals(faction)) { return 1; }
		
	    else if(Main.capturedBy_WestFort.get().equals(faction)) { return 1; }	
		
		return 0;
	}
	
	public static boolean getCityCapped(String city, String faction) {
		
		if(city.equals("Emberstone")) {
			if((Main.capturedBy_Emberstone_A.get().equals(faction)) && (Main.capturedBy_Emberstone_B.get().equals(faction))) { return true; }
		}
		
		else if(city.equals("Mykonos")) {
			if((Main.capturedBy_Mykonos_A.get().equals(faction)) && (Main.capturedBy_Mykonos_B.get().equals(faction))) { return true; }
		}
		
		else if(city.equals("Summerhold")) {
			if((Main.capturedBy_Summerhold_A.get().equals(faction)) && (Main.capturedBy_Summerhold_B.get().equals(faction))) { return true; }
		}
		
		else if(city.equals("Icarus")) {
			if((Main.capturedBy_Icarus_A.get().equals(faction)) && (Main.capturedBy_Icarus_B.get().equals(faction))) { return true; }
		}
		
		return false;
	}

	public static boolean getCityLocked(String city) {
		
		if(city.equals("Emberstone")) {
			return Main.locked_Emberstone_Throne.get();
		}
		
		else if(city.equals("Mykonos")) {
			return Main.locked_Mykonos_Throne.get();
		}
		
		else if(city.equals("Summerhold")) {
			return Main.locked_Summerhold_Throne.get();
		}
		
		else if(city.equals("Icarus")) {
			return Main.locked_Icarus_Throne.get();
		}
		
		return false;
	}
	
//==================================================================================================================================
		
	public static void unlockCity(String city) {

		if(city.equals("Emberstone")) {
			
			unlock(city, 
					Main.capLevel_Emberstone_Throne, Main.capturer_Emberstone_Throne, Main.capturedBy_Emberstone_Throne, Main.locked_Emberstone_Throne,
					Main.capLevel_Emberstone_A, Main.capturer_Emberstone_A, Main.capturedBy_Emberstone_A, Main.locked_Emberstone_A,
					Main.capLevel_Emberstone_B, Main.capturer_Emberstone_B, Main.capturedBy_Emberstone_B, Main.locked_Emberstone_B);
		}
		
		else if(city.equals("Mykonos")) {
			
			unlock(city, 
					Main.capLevel_Mykonos_Throne, Main.capturer_Mykonos_Throne, Main.capturedBy_Mykonos_Throne, Main.locked_Mykonos_Throne,
					Main.capLevel_Mykonos_A, Main.capturer_Mykonos_A, Main.capturedBy_Mykonos_A, Main.locked_Mykonos_A,
					Main.capLevel_Mykonos_B, Main.capturer_Mykonos_B, Main.capturedBy_Mykonos_B, Main.locked_Mykonos_B);
		}
		
		else if(city.equals("Summerhold")) {
			
			unlock(city, 
					Main.capLevel_Summerhold_Throne, Main.capturer_Summerhold_Throne, Main.capturedBy_Summerhold_Throne, Main.locked_Summerhold_Throne,
					Main.capLevel_Summerhold_A, Main.capturer_Summerhold_A, Main.capturedBy_Summerhold_A, Main.locked_Summerhold_A,
					Main.capLevel_Summerhold_B, Main.capturer_Summerhold_B, Main.capturedBy_Summerhold_B, Main.locked_Summerhold_B);
		}
		
		else if(city.equals("Icarus")) {
			
			unlock(city, 
					Main.capLevel_Icarus_Throne, Main.capturer_Icarus_Throne, Main.capturedBy_Icarus_Throne, Main.locked_Icarus_Throne,
					Main.capLevel_Icarus_A, Main.capturer_Icarus_A, Main.capturedBy_Icarus_A, Main.locked_Icarus_A,
					Main.capLevel_Icarus_B, Main.capturer_Icarus_B, Main.capturedBy_Icarus_B, Main.locked_Icarus_B);
		}
	}
	
	public static void unlock(String city, 
			AtomicReference<Double> capLevel_Throne, AtomicReference<String> capturer_Throne, AtomicReference<String> capturedBy_Throne, AtomicReference<Boolean> locked_Throne,
			AtomicReference<Double> capLevel_A, AtomicReference<String> capturer_A, AtomicReference<String> capturedBy_A, AtomicReference<Boolean> locked_A,
			AtomicReference<Double> capLevel_B, AtomicReference<String> capturer_B, AtomicReference<String> capturedBy_B, AtomicReference<Boolean> locked_B) {
		
		capLevel_Throne.set(0.0);
		capLevel_A.set(0.0);
		capLevel_B.set(0.0);
		
		capturer_Throne.set("");
		capturer_A.set("");
		capturer_B.set("");
		
		capturedBy_Throne.set(city);
		capturedBy_A.set(city);
		capturedBy_B.set(city);
		
		locked_Throne.set(false);
		locked_A.set(false);
		locked_A.set(false);
		
		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + city + " is no longer in lockdown");
	}

//==================================================================================================================================

	public static String removeDecimals(double num) {
		
		if(num % 1 == 0) { return Double.toString(num).substring(0, Double.toString(num).length() - 2); }
		
		return Double.toString(num);
	}

//==================================================================================================================================

}
