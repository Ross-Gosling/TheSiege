//==================================================================================================================================

package listeners;

import itemHandling.MakeItemStack;

import java.util.ArrayList;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ArmourSystem implements Listener {

//==================================================================================================================================
	
    //EquipSet Method

//==================================================================================================================================
	
	public static void equipSet(final Player player) {
			
		Boolean update = false;
		
		if(player.hasPermission("GroupNode.InBuildMode")) {}
		
		else {
			
			if((player.getInventory().getChestplate() == null) || (player.getInventory().getChestplate().getType().equals(Material.AIR))) {
				
	            player.getInventory().setHelmet(null);
	            player.getInventory().setChestplate(null);
	            player.getInventory().setLeggings(null);
	            player.getInventory().setBoots(null);
	
	            update = true;
			}
			
		    else if(player.getInventory().getChestplate().getType().equals(Material.LEATHER_CHESTPLATE)) {
				
				player.getInventory().setHelmet(makeHelmet(player, "Leather", "Low"));
				player.getInventory().setLeggings(null);
				player.getInventory().setBoots(MakeItemStack.leatherBoots());
	
	            update = true;
			}
			
			else if(player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
				
				player.getInventory().setHelmet(makeHelmet(player, "Iron", "High"));
				player.getInventory().setLeggings(MakeItemStack.ironLeggings());
				player.getInventory().setBoots(MakeItemStack.ironBoots());
	
	            update = true;
			}
			
			else if(player.getInventory().getChestplate().getType().equals(Material.GOLD_CHESTPLATE)) {
				
				player.getInventory().setHelmet(makeHelmet(player, "Gold", "High"));
				player.getInventory().setLeggings(MakeItemStack.goldLeggings());
				player.getInventory().setBoots(MakeItemStack.goldBoots());
	
	            update = true;
			}
			
			else if(player.getInventory().getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE)) {
				
				player.getInventory().setHelmet(makeHelmet(player, "Diamond", "Highest"));
				player.getInventory().setLeggings(MakeItemStack.diamondLeggings());
				player.getInventory().setBoots(MakeItemStack.diamondBoots());
	
	            update = true;
			}
		    
			else {
							
				player.getInventory().setHelmet(null);
				player.getInventory().setChestplate(null);
				player.getInventory().setLeggings(null);
				player.getInventory().setBoots(null);
	
	            update = true;
			}
			
			if(update == true) {
				
		        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
		        	
		        	public void run() {
		        		
		        		player.updateInventory();
		        	}
			    }, 1L);
			}
		}
	}
	
//==================================================================================================================================

	//MakeHelmet Method
	
//==================================================================================================================================

	public static ItemStack makeHelmet(Player player, String tier, String desc) {
		
    	int r = 0;
    	int g = 0;
    	int b = 0;
		
    	if(player.hasPermission("GroupNode.InBuildMode")) {
	    	r = 255;
	    	g = 255;
	    	b = 255;
		}
    	
    	else if(player.hasPermission("GroupNode.RossFaction")) {
	    	r = 255;
	    	g = 0;
	    	b = 0;
		}
	    
	    else if(player.hasPermission("GroupNode.LewisFaction")) {
	    	r = 255;
	    	g = 0;
	    	b = 255;
		}
	    
	    else if(player.hasPermission("GroupNode.AlexFaction")) {
	    	r = 0;
	    	g = 255;
	    	b = 0;
		}
	    
	    else if(player.hasPermission("GroupNode.CurtisFaction")) {
	    	r = 0;
	    	g = 255;
	    	b = 255;
		}
		
		ItemStack stack = new ItemStack(Material.LEATHER_HELMET, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + tier + " Armour Set");

		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + desc + " quality armour");
		stackMeta.setLore(loreText);
		stack.setItemMeta(stackMeta);
		
		LeatherArmorMeta lam = (LeatherArmorMeta)stackMeta;
		lam.setColor(Color.fromRGB(r, g, b));
		stack.setItemMeta(stackMeta);
		
		return stack;
	}
			
//==================================================================================================================================

	//Update Events
	
//==================================================================================================================================
		
	@EventHandler
	public void onInventoryDrag(InventoryDragEvent event) {

		final Player player = (Player) event.getWhoClicked();
        equipSet(player);
	}
		
	@EventHandler
	public void onArmourBreak(PlayerItemBreakEvent event) {
		
		final Player player = (Player) event.getPlayer();
        equipSet(player);		
	}
	
//==================================================================================================================================
	
}
