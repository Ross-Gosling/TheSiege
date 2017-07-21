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

public class CapturePoint_Throne {
	
//==================================================================================================================================
		
	public static void update(String defendingFaction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, AtomicReference<Boolean> locked) {
			
		boolean capturing_Ross = false;
		boolean capturing_Lewis = false;
		boolean capturing_Alex = false;
		boolean capturing_Curtis = false;
		
		int x = (Main.fetchConfig().getInt(defendingFaction + ".Throne.Coords.CoordsX"));
		int y = (Main.fetchConfig().getInt(defendingFaction + ".Throne.Coords.CoordsY"));
		int z = (Main.fetchConfig().getInt(defendingFaction + ".Throne.Coords.CoordsZ"));
		
		Location location = new Location(Bukkit.getWorld("SiegeWorld"), x + 0.5, y + 0.5, z + 0.5);
		
		List<Entity> entities = location.getWorld().getEntities();
		for(Entity entity : entities) {
		
			// If entity is in the capture point
			if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
				
				Player player = (Player) entity;
				
				if(player.hasPermission("GroupNode.InBuildMode")) {}
				else if(player.hasPermission("GroupNode.RossFaction")) { capturing_Ross = true; }
				else if(player.hasPermission("GroupNode.LewisFaction")) { capturing_Lewis = true; }
				else if(player.hasPermission("GroupNode.AlexFaction")) { capturing_Alex = true; }
				else if(player.hasPermission("GroupNode.CurtisFaction")) { capturing_Curtis = true; }
			}	
		}

		if(CP_Functions.getCityLocked(defendingFaction)) {
			
			// Sends players a subtitle message
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
					if(((Player) entity).hasPermission("GroupNode.InBuildMode")) {}
					else if((((Player) entity).hasPermission("GroupNode.RossFaction")) && (capturedBy.get().equals("Emberstone"))) {}
					else if((((Player) entity).hasPermission("GroupNode.LewisFaction")) && (capturedBy.get().equals("Mykonos"))) {}
					else if((((Player) entity).hasPermission("GroupNode.AlexFaction")) && (capturedBy.get().equals("Summerhold"))) {}
					else if((((Player) entity).hasPermission("GroupNode.CurtisFaction")) && (capturedBy.get().equals("Icarus"))) {}
					else { Player player = (Player) entity; Display.sendSubtitle(defendingFaction + " is in lockdown", "Red", player); }
				}	
			}
		}
						
		else if((!(defendingFaction.equals("Emberstone")) && (CP_Functions.getCityCapped(defendingFaction, "Emberstone")))
				|| (!(defendingFaction.equals("Mykonos")) && (CP_Functions.getCityCapped(defendingFaction, "Mykonos")))
				|| (!(defendingFaction.equals("Summerhold")) && (CP_Functions.getCityCapped(defendingFaction, "Summerhold")))
				|| (!(defendingFaction.equals("Icarus")) && (CP_Functions.getCityCapped(defendingFaction, "Icarus")))) {
		
			double captureRate = (Main.fetchConfig().getDouble("CaptureRate_Throne"));
				
			// Just Emberstone is in the capture point AND they don't own the point
			if((capturing_Ross) && (!(capturing_Lewis) && !(capturing_Alex) && !(capturing_Curtis))) {
				
				preCapture("Emberstone", defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Mykonos is in the capture point AND they don't own the point
			else if((capturing_Lewis) && (!(capturing_Ross) && !(capturing_Alex) && !(capturing_Curtis))) { 
				
				preCapture("Mykonos", defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Summerhold is in the capture point AND they don't own the point
			else if((capturing_Alex) && (!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Curtis))) {
				
				preCapture("Summerhold", defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// Just Icarus is in the capture point AND they don't own the point
			else if((capturing_Curtis) && (!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Alex))) {
				
				preCapture("Icarus", defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			// If no one is in the capture point
			else if(!(capturing_Ross) && !(capturing_Lewis) && !(capturing_Alex) && !(capturing_Curtis)) {
				
				// It restores the owners caplevel
				if(!(capturedBy.get().equals("")) && (capLevel.get() > 0)) {
					
					restore(capLevel, capturer, capturedBy, location, captureRate);
				}
			}
			
			// Else there are more than one faction in the circle
			else {
				
				contest(capLevel, capturer, location);
			}
		}
		
		else {
			// Sends players a subtitle message
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
					if(((Player) entity).hasPermission("GroupNode.InBuildMode")) {}
					else if((((Player) entity).hasPermission("GroupNode.RossFaction")) && (capturedBy.get().equals("Emberstone"))) {}
					else if((((Player) entity).hasPermission("GroupNode.LewisFaction")) && (capturedBy.get().equals("Mykonos"))) {}
					else if((((Player) entity).hasPermission("GroupNode.AlexFaction")) && (capturedBy.get().equals("Summerhold"))) {}
					else if((((Player) entity).hasPermission("GroupNode.CurtisFaction")) && (capturedBy.get().equals("Icarus"))) {}
					else { Player player = (Player) entity; Display.sendSubtitle("Locked - Capture the city", "Red", player); }
				}	
			}
		}
		
		Display.throne(defendingFaction, capLevel.get(), capturer.get(), capturedBy.get());
	}
	
//==================================================================================================================================
		
	public static void preCapture(String attackingFaction, String defendingFaction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, AtomicReference<Boolean> locked, Location location, double captureRate) {
		
		if(!capturedBy.get().equals(attackingFaction)) {
			
			// Applies the +25% bonus to cap speed per fortress held
			captureRate = captureRate + (CP_Functions.getFortsCapped(attackingFaction) * (captureRate*0.25));	
			
			if(capturer.get().equals("")) { 
				
				capturer.set(attackingFaction);

				capture(defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
			
			else if(capturer.get().equals(attackingFaction)) {
				
				capture(defendingFaction, capLevel, capturer, capturedBy, locked, location, captureRate);
			}
		}
	}
	
//==================================================================================================================================
		
	public static void capture(final String defendingFaction, AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, final AtomicReference<Boolean> locked, Location location, double captureRate) {

		if(capLevel.get() < 32) {

			capLevel.set(capLevel.get() + captureRate);
			
			location.getWorld().playSound(location, Sound.NOTE_PIANO, (float) 3.0, (float) 1.0);
			
			// Sends players a subtitle message
			List<Entity> entities = location.getWorld().getEntities();
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
					Player player = (Player) entity; Display.sendSubtitle("Capturing... ( " + CP_Functions.removeDecimals(capLevel.get()) + " / 32 )", "Green", player);
				}	
			}
		}
		
		if((capLevel.get() >= 32) && !(capturedBy.get().equals(capturer.get()))) { 
			
			int lockTime = (Main.fetchConfig().getInt("Throne_CooldownTime"));
			locked.set(true);
			
			Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + capturer.get() + " conquered " + defendingFaction + "!");
        	Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + defendingFaction + " is now in lockdown for " + lockTime + " minutes");
        	
			location.getWorld().playSound(location, Sound.WITHER_SPAWN, (float) 3.0, (float) 1.0);
			
			capturedBy.set(capturer.get());
			capLevel.set(0.0);
			capturer.set("");
			
			// Sends players a subtitle message
			List<Entity> entities = location.getWorld().getEntities();
			for(Entity entity : entities) {
				// If entity is in the capture point
				if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
					Player player = (Player) entity; Display.sendSubtitle("Capturing Complete", "Green", player); 
				}	
			}
			
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		CP_Functions.unlockCity(defendingFaction);
	        	}
		    }, 1200 * lockTime);
		}
	}
	
//==================================================================================================================================
		
	public static void contest(AtomicReference<Double> capLevel, AtomicReference<String> capturer, Location location) {
		
		location.getWorld().playSound(location, Sound.NOTE_BASS, (float) 3.0, (float) 0.8);
		
		// Sends players a subtitle message
		List<Entity> entities = location.getWorld().getEntities();
		for(Entity entity : entities) {
			// If entity is in the capture point
			if((entity.getLocation().distance(location) <= me.x3DGosling.Siege_CaptureSystem.Main.capRadius_Throne) && (entity instanceof Player)) {
				Player player = (Player) entity; Display.sendSubtitle("Contested... ( " + CP_Functions.removeDecimals(capLevel.get()) + " / 32 )", "Yellow", player); 
			}	
		}
	}
		
//==================================================================================================================================

	private static void restore(AtomicReference<Double> capLevel, AtomicReference<String> capturer, AtomicReference<String> capturedBy, Location location, double captureRate) {

		capLevel.set(capLevel.get() - captureRate);
		
		location.getWorld().playSound(location, Sound.NOTE_BASS, (float) 3.0, (float) 0.8);
		
		if(capLevel.get() <= 0) { 
			
			capLevel.set(0.0);
			
			capturer.set("");
		}
	}
	
//==================================================================================================================================

}

