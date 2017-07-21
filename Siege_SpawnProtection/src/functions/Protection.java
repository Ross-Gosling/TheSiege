package functions;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Protection {

	public static void protect(String faction, int x, int y, int z, int radius) {
			
		Location location = new Location(Bukkit.getWorld("SiegeWorld"), x + 0.5, y + 0.5, z + 0.5);
		
		List<Entity> near = location.getWorld().getEntities();
		
		for(Entity entity : near) {
			
			if((entity.getLocation().distance(location) <= radius) && (entity instanceof Player)) {

				LivingEntity livingEntity = (LivingEntity) entity;
				Player player = (org.bukkit.entity.Player) livingEntity;
				
				if(player.hasPermission("GroupNode.InBuildMode")) {
					//Do Nothing
				}
				
				else if(((player.hasPermission("GroupNode.RossFaction")) && (faction.equalsIgnoreCase("emberstone"))) || ((player.hasPermission("GroupNode.LewisFaction")) && (faction.equalsIgnoreCase("mykonos"))) || ((player.hasPermission("GroupNode.AlexFaction")) && (faction.equalsIgnoreCase("summerhold"))) || ((player.hasPermission("GroupNode.CurtisFaction")) && (faction.equalsIgnoreCase("icarus")))) {
										
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, (int) 60, (int) 3), true);
				}
				
			    else if(!(player.hasPermission("GroupNode.RossFaction")) && !(player.hasPermission("GroupNode.LewisFaction")) && !(player.hasPermission("GroupNode.AlexFaction")) && !(player.hasPermission("GroupNode.CurtisFaction"))) {
					// Do Nothing
				}
				
				else {
					
					Location playerLocation = player.getLocation();//Get the location from the spawn
					 
					double deltaX = playerLocation.getX() - location.getX();//Get X Delta
					double deltaZ = playerLocation.getZ() - location.getZ();//Get Z delta
					 
					Vector vec = new Vector(deltaX, 2, deltaZ);//Create new vector
					vec.normalize();//Normalize it so we don't shoot the player into oblivion
					player.setVelocity(vec.multiply(5 / (Math.sqrt(Math.pow(deltaX, 2.0) + Math.pow(deltaZ, 2.0)))));//Use a bit of trig to get 'h'(square root(a^2 + b^2) = c) then divide the max power by 'h' to get a fall off effect
					
					player.damage(0.5);
				}
			}
			
			else if((entity.getLocation().distance(location) <= radius) && (entity instanceof Horse)) {

				Horse horse = (Horse) entity;
				Player owner = (Player) horse.getOwner();
							
				if(((owner.hasPermission("GroupNode.RossFaction")) && (faction.equalsIgnoreCase("emberstone"))) || ((owner.hasPermission("GroupNode.LewisFaction")) && (faction.equalsIgnoreCase("mykonos"))) || ((owner.hasPermission("GroupNode.AlexFaction")) && (faction.equalsIgnoreCase("summerhold"))) || ((owner.hasPermission("GroupNode.CurtisFaction")) && (faction.equalsIgnoreCase("icarus")))) {			
					//Do Nothing
				}
				
				else {
											
					Location entityLocation = entity.getLocation();//Get the location from the spawn
											
					double deltaX = entityLocation.getX() - location.getX();//Get X Delta
					double deltaZ = entityLocation.getZ() - location.getZ();//Get Z delta
					 
					Vector vec = new Vector(deltaX, 2, deltaZ);//Create new vector
					vec.normalize();//Normalize it so we don't shoot the horse into oblivion
					entity.setVelocity(vec.multiply(5 / (Math.sqrt(Math.pow(deltaX, 2.0) + Math.pow(deltaZ, 2.0)))));//Use a bit of trig to get 'h'(square root(a^2 + b^2) = c) then divide the max power by 'h' to get a fall off effect
				}
			}
			
			else if((entity.getLocation().distance(location) <= radius) && (entity instanceof Zombie)) {
				
				Location entityLocation = entity.getLocation();//Get the location from the spawn
					
				double deltaX = entityLocation.getX() - location.getX();//Get X Delta
				double deltaZ = entityLocation.getZ() - location.getZ();//Get Z delta
				 
				Vector vec = new Vector(deltaX, 2, deltaZ);//Create new vector
				vec.normalize();//Normalize it so we don't shoot the skeleton into oblivion
				entity.setVelocity(vec.multiply(5 / (Math.sqrt(Math.pow(deltaX, 2.0) + Math.pow(deltaZ, 2.0)))));//Use a bit of trig to get 'h'(square root(a^2 + b^2) = c) then divide the max power by 'h' to get a fall off effect		
			}
		}
	}
}
