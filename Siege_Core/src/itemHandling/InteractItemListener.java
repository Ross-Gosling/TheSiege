package itemHandling;

import listeners.ArmourSystem;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import commands.AdminWipe;

public class InteractItemListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEvent Event
	
//==================================================================================================================================

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		final Player player = event.getPlayer();
		Action action = event.getAction();
		
		if((player.getItemInHand() == null) || (player.getItemInHand().getType().equals(Material.AIR))) {
			
			//Do nothing
		}
		
		else if(player.getItemInHand() != null) {
		
			Configuration config = Main.fetchConfig();
			
			Material itemID = player.getItemInHand().getType();
			String itemName = player.getItemInHand().getItemMeta().getDisplayName();
	
			//If click with a chestplate
			if((itemID == Material.LEATHER_CHESTPLATE) || (itemID == Material.IRON_CHESTPLATE) || (itemID == Material.GOLD_CHESTPLATE) || (itemID == Material.DIAMOND_CHESTPLATE)) {
								
				//Right Click with chestplate
				if((action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_AIR)) || (action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
					
			        Bukkit.getScheduler().scheduleSyncDelayedTask(me.x3DGosling.Siege_Core.Main.fetchPlugin(), new Runnable() {
			        	public void run() {
			        		
			        		ArmourSystem.equipSet(player);
			        		
			        	}
				    }, 1L);				
				}
			}
						
			//If click with a compass
			if(itemID == Material.COMPASS) {
								
				//Right Click with compass
				if((action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_AIR)) || (action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
					
					Location location = new Location(Bukkit.getWorld("world"), 0, 0, 0);
					ItemStack item = event.getItem();
										
					if(itemName.endsWith("(Western Fortress)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Emberstone").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Emberstone_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Emberstone_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Emberstone_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Emberstone)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Mykonos").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Mykonos_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Mykonos_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Mykonos_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Mykonos)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Summerhold").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Summerhold_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Summerhold_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Summerhold_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Summerhold)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Icarus").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Icarus_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Icarus_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Icarus_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Icarus)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Eastern Fortress").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Neutral.EasternFortress.Coords.CoordsX") + 0.5);
						location.setY(config.getInt("Neutral.EasternFortress.Coords.CoordsY") + 0.5);
						location.setZ(config.getInt("Neutral.EasternFortress.Coords.CoordsZ") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Eastern Fortress)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Western Fortress").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Neutral.WesternFortress.Coords.CoordsX") + 0.5);
						location.setY(config.getInt("Neutral.WesternFortress.Coords.CoordsY") + 0.5);
						location.setZ(config.getInt("Neutral.WesternFortress.Coords.CoordsZ") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else {
						
						player.getInventory().remove(item);
						player.getInventory().addItem(MakeItemStack.compass(1, "Emberstone"));
					}
					
					player.updateInventory();
				}
				
				//Left Click with compass
				else if((action.equals(org.bukkit.event.block.Action.LEFT_CLICK_AIR)) || (action.equals(org.bukkit.event.block.Action.LEFT_CLICK_BLOCK))) {
					
					Location location = new Location(Bukkit.getWorld("SiegeWorld"), 0, 0, 0);
					ItemStack item = event.getItem();
										
					if(itemName.endsWith("(Mykonos)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Emberstone").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Emberstone_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Emberstone_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Emberstone_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Summerhold)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Mykonos").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Mykonos_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Mykonos_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Mykonos_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Icarus)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Summerhold").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Summerhold_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Summerhold_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Summerhold_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Eastern Fortress)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Icarus").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Icarus_SpawnCoords.X") + 0.5);
						location.setY(config.getInt("Icarus_SpawnCoords.Y") + 0.5);
						location.setZ(config.getInt("Icarus_SpawnCoords.Z") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Western Fortress)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Eastern Fortress").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Neutral.EasternFortress.Coords.CoordsX") + 0.5);
						location.setY(config.getInt("Neutral.EasternFortress.Coords.CoordsY") + 0.5);
						location.setZ(config.getInt("Neutral.EasternFortress.Coords.CoordsZ") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else if(itemName.endsWith("(Emberstone)")) {
						
						ItemMeta itemMeta = item.getItemMeta();
						itemMeta.setDisplayName(MakeItemStack.compass(1, "Western Fortress").getItemMeta().getDisplayName());
						item.setItemMeta(itemMeta);
						
						location.setX(config.getInt("Neutral.WesternFortress.Coords.CoordsX") + 0.5);
						location.setY(config.getInt("Neutral.WesternFortress.Coords.CoordsY") + 0.5);
						location.setZ(config.getInt("Neutral.WesternFortress.Coords.CoordsZ") + 0.5);
						
						player.setCompassTarget(location);
					}
					
					else {
						
						player.getInventory().remove(item);
						player.getInventory().addItem(MakeItemStack.compass(1, "Emberstone"));
					}
					
					player.updateInventory();
				}
				
				player.playSound(player.getLocation(), Sound.CLICK, 1F, 1F);
			}
			
			else if(itemID.equals(Material.TNT)) {
				
				//Right Click with TNT
				if((action.equals(Action.RIGHT_CLICK_AIR)) || (action.equals(Action.RIGHT_CLICK_BLOCK))) {
					
					event.setCancelled(true);
					
					AdminWipe.execute(event.getPlayer().getLocation().getBlock());
				}
			}
		}
	}
}
