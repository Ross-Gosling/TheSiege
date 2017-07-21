//==================================================================================================================================

package functions;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CapturePoint_City {
	
//==================================================================================================================================
		
	public static void update(String cityPoint, String cityPoint_Faction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, AtomicReference<Boolean> locked) {
			
		boolean capturing_Ross = false;
		boolean capturing_Lewis = false;
		boolean capturing_Alex = false;
		boolean capturing_Curtis = false;
		
		int x = (Main.fetchConfig().getInt(cityPoint_Faction + ".Cap" + cityPoint + ".Coords.CoordsX"));
		int y = (Main.fetchConfig().getInt(cityPoint_Faction + ".Cap" + cityPoint + ".Coords.CoordsY"));
		int z = (Main.fetchConfig().getInt(cityPoint_Faction + ".Cap" + cityPoint + ".Coords.CoordsZ"));
		
		Location location = new Location(Bukkit.getWorld("SiegeWorld"), x + 0.5, y + 0.5, z + 0.5);
		
		List<Entity> entities = location.getWorld().getEntities();
		for(Entity entity : entities) {
		
			// If entity is in the capture point
			if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
				
				Player player = (Player) entity;
				
				if(player.hasPermission("GroupNode.InBuildMode")) {}
				else if(player.hasPermission("GroupNode.RossFaction")) { capturing_Ross = true; }
				else if(player.hasPermission("GroupNode.LewisFaction")) { capturing_Lewis = true; }
				else if(player.hasPermission("GroupNode.AlexFaction")) { capturing_Alex = true; }
				else if(player.hasPermission("GroupNode.CurtisFaction")) { capturing_Curtis = true; }
			}	
		}
		
		if(CP_Functions.getCityLocked(cityPoint_Faction)) {
			
			// Sends players a subtitle message
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
					if(((Player) entity).hasPermission("GroupNode.InBuildMode")) {}
					else if((((Player) entity).hasPermission("GroupNode.RossFaction")) && (capturedBy.get().equals("Emberstone"))) {}
					else if((((Player) entity).hasPermission("GroupNode.LewisFaction")) && (capturedBy.get().equals("Mykonos"))) {}
					else if((((Player) entity).hasPermission("GroupNode.AlexFaction")) && (capturedBy.get().equals("Summerhold"))) {}
					else if((((Player) entity).hasPermission("GroupNode.CurtisFaction")) && (capturedBy.get().equals("Icarus"))) {}
					else { Player player = (Player) entity; Display.sendSubtitle(cityPoint_Faction + " is in lockdown", "Red", player); }
				}	
			}
		}
		
		else if(locked.get()) {
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
					if(((Player) entity).hasPermission("GroupNode.InBuildMode")) {}
					else if((((Player) entity).hasPermission("GroupNode.RossFaction")) && (capturedBy.get().equals("Emberstone"))) {}
					else if((((Player) entity).hasPermission("GroupNode.LewisFaction")) && (capturedBy.get().equals("Mykonos"))) {}
					else if((((Player) entity).hasPermission("GroupNode.AlexFaction")) && (capturedBy.get().equals("Summerhold"))) {}
					else if((((Player) entity).hasPermission("GroupNode.CurtisFaction")) && (capturedBy.get().equals("Icarus"))) {}
					else { Player player = (Player) entity; Display.sendSubtitle("In lockdown", "Red", player); }
				}	
			}
		}
		
		else {
		
			double captureRate = (Main.fetchConfig().getDouble("CaptureRate_City"));
				
			// Just Emberstone is in the capture point AND they don't own the point
			if((capturing_Ross) && (!(capturing_Lewis) && !(capturing_Alex) && !(capturing_Curtis))) {
				
				preCapture("Emberstone", cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Mykonos is in the capture point AND they don't own the point
			else if((capturing_Lewis) && (!(capturing_Ross) && !(capturing_Alex) && !(capturing_Curtis))) { 
				
				preCapture("Mykonos", cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Summerhold is in the capture point AND they don't own the point
			else if((capturing_Alex) && (!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Curtis))) {
				
				preCapture("Summerhold", cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Icarus is in the capture point AND they don't own the point
			else if((capturing_Curtis) && (!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Alex))) {
				
				preCapture("Icarus", cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// If no one is in the capture point
			else if(!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Alex) && !(capturing_Curtis)) {
				
				// It restores the owners caplevel
				if(!(capturedBy.get().equals("")) && (capLevel.get() > 0)) {
					
					restore(cityPoint, capLevel, capturer, capturedBy, location, captureRate);
				}
			}
			
			// Else there are more than one faction in the circle
			else {
				
				contest(cityPoint, capLevel, capturer, location);
			}
		}
		
		Display.city(cityPoint, cityPoint_Faction, capLevel.get(), capturer.get(), capturedBy.get());
	}
	
//==================================================================================================================================
		
	public static void preCapture(String attackingFaction, String cityPoint, String cityPoint_Faction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, AtomicReference<Boolean> locked, Location location, double captureRate) {
		
		if(!capturedBy.get().equals(attackingFaction)) {
			
			// Applies the +25% bonus to cap speed per fortress held
			captureRate = captureRate + (CP_Functions.getFortsCapped(attackingFaction) * (captureRate*0.25));	
			
			if(capturer.get().equals("")) { 
				
				capturer.set(attackingFaction);

				capture(cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			else if(capturer.get().equals(attackingFaction)) {
				
				capture(cityPoint, cityPoint_Faction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
		}
	}
	
//==================================================================================================================================
		
	public static void capture(final String cityPoint, final String cityPoint_Faction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, final AtomicReference<Boolean> locked, Location location, double captureRate) {

		if(capLevel.get() < 20) {

			capLevel.set(capLevel.get() + captureRate);
			
			location.getWorld().playSound(location, Sound.NOTE_PIANO, (float) 3.0, (float) 1.0);
			
			// Sends players a subtitle message
			List<Entity> entities = location.getWorld().getEntities();
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
					Player player = (Player) entity; Display.sendSubtitle("Capturing... ( " + CP_Functions.removeDecimals(capLevel.get()) + " / 20 )", "Green", player); 
				}	
			}
		}
		
		if((capLevel.get() >= 20) && !(capturedBy.get().equals(capturer.get()))) { 
			
			int lockTime = (Main.fetchConfig().getInt("City_CooldownTime"));
			locked.set(true);
			
			Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + capturer.get() + " captured " + cityPoint_Faction + " Capture Point " + cityPoint + "!");
        	Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + cityPoint_Faction + " Capture Point " + cityPoint + " is now in lockdown for " + lockTime + " minutes");
        	
			location.getWorld().playSound(location, Sound.WITHER_SPAWN, (float) 3.0, (float) 1.0);
			
			capturedBy.set(capturer.get());
			capLevel.set(0.0);
			capturer.set("");
			
			// If both points have just been siezed
			if(CP_Functions.getCityCapped(cityPoint_Faction, capturedBy.get())) {
				
				// If it's an outsider capturing both points
				if(!cityPoint_Faction.equals(capturedBy.get())) {
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + cityPoint_Faction + " has lost control of the city!");
				}
				// If it's the defenders recapturing both points
				else if(cityPoint_Faction.equals(capturedBy.get())) {
		        	Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + cityPoint_Faction + " has been resecured by it's populus!");
				}
			}
			
			// Just one
			else {
				
				// If it's an outsider capturing both points
				if(!cityPoint_Faction.equals(capturedBy.get())) {
					Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "The " + cityPoint_Faction + " Spawn Altar has been deactivated!");
				}
				// If it's the defenders recapturing both points
				else if(cityPoint_Faction.equals(capturedBy.get())) {
		        	Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "The " + cityPoint_Faction + " Spawn Altar has been reactivated!");
				}
			}
			
			// Sends players a subtitle message
			List<Entity> entities = location.getWorld().getEntities();
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
					Player player = (Player) entity; Display.sendSubtitle("Capturing Complete", "Green", player); 
				}	
			}
			
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		if(!CP_Functions.getCityLocked(cityPoint_Faction)) {
		        		locked.set(false);
		        		Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + cityPoint_Faction + " Capture Point " + cityPoint + " is no longer in lockdown");
	        		}
	        	}
		    }, 1200 * lockTime);
		}
	}
	
//==================================================================================================================================
		
	public static void contest(String cityPoint, AtomicReference<Double> capLevel, AtomicReference<String> capturer, Location location) {
		
		location.getWorld().playSound(location, Sound.NOTE_BASS, (float) 3.0, (float) 0.8);
		
		// Sends players a subtitle message
		List<Entity> entities = location.getWorld().getEntities();
		for(Entity entity : entities) {
			// If entity is in the capture point
			if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_City) && (entity instanceof Player)) {
				Player player = (Player) entity; Display.sendSubtitle("Contested... ( " + CP_Functions.removeDecimals(capLevel.get()) + " / 20 )", "Yellow", player); 
			}	
		}
	}
		
//==================================================================================================================================

	private static void restore(String cityPoint, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, Location location, double captureRate) {

		capLevel.set(capLevel.get() - captureRate);
		
		location.getWorld().playSound(location, Sound.NOTE_BASS, (float) 3.0, (float) 0.8);
		
		if(capLevel.get() <= 0) { 
			
			capLevel.set(0.0);
			
			capturer.set("");
		}
	}
	
//==================================================================================================================================

}

