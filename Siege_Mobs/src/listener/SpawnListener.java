package listener;

import itemHandling.MakeItemStack;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.GenericAttributes;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class SpawnListener implements Listener {

//==================================================================================================================================

	//onMobSpawn Event
	
//==================================================================================================================================

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent event) {
		
		EntityType mob = event.getEntityType();
			
		Block regionBlock = event.getLocation().getWorld().getBlockAt((int)event.getLocation().getX(), (int)0, (int)event.getLocation().getZ());
		
		// Mob is spawning in a city region
		if((regionBlock.getType().equals(Material.STAINED_CLAY)) && (!(mob.equals(EntityType.HORSE)) && !(mob.equals(EntityType.VILLAGER)))) {
				
			if((regionBlock.getData() == (byte)4) && (event.getEntity().getLocation().getY() < 100)) {
				// Do Nothing
			}
			
			else {
				event.setCancelled(true);
			}
		}
			
		else {
			
			if(mob == EntityType.SKELETON) {
				
			    Entity entity = event.getEntity();
			       
		        if(entity instanceof LivingEntity) {
		        		        	
		            LivingEntity livingEntity = (LivingEntity) entity;
		            EntityEquipment equipment = livingEntity.getEquipment();
		            
		            livingEntity.setRemoveWhenFarAway(true);
		        	livingEntity.setCanPickupItems(false);
		            
		            if(entity instanceof Skeleton) {
		            		
				        AttributeInstance attributes = ((EntityInsentient)((CraftLivingEntity)((Skeleton)entity)).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
				        				        
				        ((Skeleton) entity).setSkeletonType(SkeletonType.NORMAL);
						
						// Initialises newCatch
						ItemStack mobWeapon = null;
						//Creates a random number
						int random = 0; random = (int) (Math.random() * 100);
						// Outcome based on random number
						if (random < 20) { mobWeapon = MakeItemStack.flimsyBow(); } // 20% for flimsybow
						else if (random < 25) { mobWeapon = MakeItemStack.rustySword(); attributes.setValue(0.4); } // 5% for rusty sword
						else if (random < 30) { mobWeapon = MakeItemStack.rustyAxe(); attributes.setValue(0.4); } // 5% for rusty axe
						else if (random < 31) { mobWeapon = MakeItemStack.dulledSword(); attributes.setValue(0.4); } // 1% for dulled sword
						else if (random < 32) { mobWeapon = MakeItemStack.dulledAxe(); attributes.setValue(0.4); } // 1% for dulled axe
						else { mobWeapon = new ItemStack(Material.AIR); attributes.setValue(0.4); } // 50% for nothing
						
						if(!mobWeapon.getType().equals(Material.AIR)) {
							int randDura = 0; randDura = (int) (Math.random() * (mobWeapon.getType().getMaxDurability() - (mobWeapon.getType().getMaxDurability()) * 0.2));
							mobWeapon.setDurability((short) randDura);
						}
						
		            	equipment.setItemInHand(mobWeapon);
		                equipment.setHelmet(null);
		                equipment.setChestplate(null);
		                equipment.setLeggings(null);
		                equipment.setBoots(null);
		                
		                equipment.setItemInHandDropChance(0f);
		                equipment.setHelmetDropChance(0f);
		                equipment.setChestplateDropChance(0f);
		                equipment.setLeggingsDropChance(0f);
		                equipment.setBootsDropChance(0f);             
		            }
		        }
			}
			
			else if((mob == EntityType.COW) || (mob == EntityType.PIG) || (mob == EntityType.SHEEP)) {
	
			    Entity entity = event.getEntity();
			        
		        if(entity instanceof LivingEntity) {
			        	
		            LivingEntity livingEntity = (LivingEntity) entity;
		            EntityEquipment equipment = livingEntity.getEquipment();
		            
		            livingEntity.setRemoveWhenFarAway(false);
		            
		            if((livingEntity instanceof Cow) || (livingEntity instanceof Pig) || (livingEntity instanceof Sheep)) {
		            	
		            	equipment.setHelmet(null);
		            	equipment.setChestplate(null);
		            	equipment.setLeggings(null);
		            	equipment.setBoots(null);
			            
		            	equipment.setHelmetDropChance(0f);
		            	equipment.setChestplateDropChance(0f);
		            	equipment.setLeggingsDropChance(0f);
		            	equipment.setBootsDropChance(0f);
			        }
				}
			}
			
			else if(mob == EntityType.HORSE) {
				
				if(event.getSpawnReason() == SpawnReason.NATURAL) {
					
				    event.setCancelled(true);
				}
				
				else {
					
					event.setCancelled(false);
				}
			}
			
			else if(mob == EntityType.VILLAGER) {
				
				if(event.getSpawnReason() == SpawnReason.NATURAL) {
					
				    event.setCancelled(true);
				}
				
				else {
					
					event.setCancelled(false);
				}
			}
			
			else {
				
				event.setCancelled(true);
			}
		}
	}
	
//==================================================================================================================================

}
