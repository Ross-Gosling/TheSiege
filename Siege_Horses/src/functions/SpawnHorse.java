package functions;

import java.util.List;

import itemHandling.InventoryFunctions;
import itemHandling.MakeItemStack;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.GenericAttributes;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Color;
import org.bukkit.entity.Horse.Style;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpawnHorse {
	
	@SuppressWarnings("deprecation")
	public static void command(String team, String faction, byte teamBlockID, Player player, ItemStack saddle, String command) {
		
		Block regionBlock = player.getLocation().getWorld().getBlockAt((int)player.getLocation().getX(), (int)0, (int)player.getLocation().getZ());
		Block stableBlock = player.getLocation().getWorld().getBlockAt((int)player.getLocation().getX(), (int)1, (int)player.getLocation().getZ());
				
		//If in city stables
		if((stableBlock.getType().equals(Material.STAINED_CLAY)) && (regionBlock.getData() == teamBlockID)) {
			
			if((player.hasPermission("GroupNode." + team + "Faction")) && (CP_Functions.getCityCapped(faction, faction))) {
		
				if(command.equalsIgnoreCase("summon")) {
				
					summonHorse(player, saddle);
				}
				
				else if(command.equalsIgnoreCase("dismiss")) {
					
					dismissHorse(player);
				}
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "You must control both city capture points to use the stables");
			}
		}
			
		//If in eastern fort stables
		else if((stableBlock.getType().equals(Material.STAINED_CLAY)) && (stableBlock.getData() == (byte)1)) {
			
			if((player.hasPermission("GroupNode." + team + "Faction")) && (me.x3DGosling.Siege_CaptureSystem.Main.capturedBy_EastFort.get().equalsIgnoreCase(faction))) {
		
				if(command.equalsIgnoreCase("summon")) {
					
					summonHorse(player, saddle);
				}
				
				else if(command.equalsIgnoreCase("dismiss")) {
					
					dismissHorse(player);
				}
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Your faction doesn't control these stables");
			}
		}
		
		//If in western fort stables
		else if((stableBlock.getType().equals(Material.STAINED_CLAY)) && (stableBlock.getData() == (byte)2)) {
			
			if((player.hasPermission("GroupNode." + team + "Faction")) && (me.x3DGosling.Siege_CaptureSystem.Main.capturedBy_WestFort.get().equalsIgnoreCase(faction))) {
		
				if(command.equalsIgnoreCase("summon")) {
					
					summonHorse(player, saddle);
				}
				
				else if(command.equalsIgnoreCase("dismiss")) {
					
					dismissHorse(player);
				}
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Your faction doesn't control these stables");
			}
		}
		
		//Else not in any stables
		else {
			
			player.sendMessage(ChatColor.RED + "You can only use a saddle in stables");
		}
	}
	
	public static void summonHorse(Player player, ItemStack saddle) {
		
		if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Basic().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Scout().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Light().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Ross().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Lewis().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Alex().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Curtis().getItemMeta().getDisplayName())) {
			
			placeHorse(player, saddle);
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "Invalid saddle");
			
		}
	}
	
	public static void placeHorse(Player player, ItemStack saddle) {
				
		dismissHorse(player);
		
		Horse horse = (Horse) player.getLocation().getWorld().spawn(player.getLocation(), Horse.class);
		
		horse.setTamed(true);
		horse.setOwner((AnimalTamer)player);
		
		horse.setMaxHealth(40.0);
		horse.setHealth(40.0);
		
		horse.setAdult();
		horse.setCanPickupItems(false);
		horse.setRemoveWhenFarAway(false);
		
		horse.setJumpStrength(0.7);
		
        AttributeInstance attributes = ((EntityInsentient)((CraftLivingEntity)horse).getHandle()).getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
        
		ChatColor nameColor = null;
		
		if(player.hasPermission("GroupNode.RossFaction")) { nameColor = ChatColor.RED; }
		else if(player.hasPermission("GroupNode.LewisFaction")) { nameColor = ChatColor.LIGHT_PURPLE; }
		else if(player.hasPermission("GroupNode.AlexFaction")) { nameColor = ChatColor.GREEN; }
		else if(player.hasPermission("GroupNode.CurtisFaction")) { nameColor = ChatColor.AQUA; }
		
		if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Basic().getItemMeta().getDisplayName())) {

			horse.setColor(Color.BROWN);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Basic Cavalry");
			
	        attributes.setValue(0.24);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Scout().getItemMeta().getDisplayName())) {

			horse.setColor(Color.DARK_BROWN);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Scout Cavalry");
			
	        attributes.setValue(0.27);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Light().getItemMeta().getDisplayName())) {

			horse.setColor(Color.WHITE);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Light Cavalry");

	        attributes.setValue(0.3);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Ross().getItemMeta().getDisplayName())) {

			horse.setColor(Color.BLACK);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Sasquatch (Unique)");

			attributes.setValue(0.3);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Lewis().getItemMeta().getDisplayName())) {

			horse.setColor(Color.GRAY);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.DONKEY);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Madonna (Unique)");

			attributes.setValue(0.3);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Alex().getItemMeta().getDisplayName())) {

			horse.setColor(Color.GRAY);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Orion (Unique)");

			attributes.setValue(0.3);
		}
		
		else if(saddle.getItemMeta().getDisplayName().startsWith(MakeItemStack.saddle_Curtis().getItemMeta().getDisplayName())) {

			horse.setColor(Color.WHITE);
			horse.setStyle(Style.NONE);
			horse.setVariant(Variant.SKELETON_HORSE);
			horse.setCustomName(nameColor + "" + player.getDisplayName() + "'s Bones (Unique)");

			attributes.setValue(0.3);
		}
		
		else {
			
			horse.remove();
		}
		
		horse.getInventory().setSaddle(new ItemStack(Material.SADDLE, 1));
				
		player.sendMessage(ChatColor.GREEN + "Horse summoned: " + horse.getCustomName());
	}
	
	public static void dismissHorse(Player player) {
		
		List<Entity> entities = player.getLocation().getWorld().getEntities();
		
		for(Entity entity : entities) {
				
			if(entity instanceof Horse) {
				
				if(((Horse)entity).getOwner().equals(((AnimalTamer)player))) {
					
					if(((Horse) entity).getInventory().getArmor() != null) {
						
						ItemStack armour = ((Horse) entity).getInventory().getArmor();
						
		    			if(InventoryFunctions.canMerge(armour, player.getInventory()) == true) {
		    				
		    				player.getInventory().addItem(armour);
		    				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
		    			}
		    			
		    			else {
		            	
			            	Location location = player.getLocation();
			            	World world = player.getWorld();
			        	
			            	world.dropItem(location, armour);
		    			}
					}
					
					entity.remove();
					player.sendMessage(ChatColor.RED + "Horse dismissed");
				}
			}
		}
	}
}
