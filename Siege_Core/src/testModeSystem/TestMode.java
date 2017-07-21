package testModeSystem;

import itemHandling.MakeItemStack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TestMode {

	public static boolean testModeActive = false;
	private static final String itemPostfix = "[TEST-MODE ITEM]";

	public static void command(Player player, String[] args) {
		
		if(player.hasPermission("GroupNode.Admin")) {
	    	
			if(args.length < 1) {
				
				player.sendMessage(ChatColor.RED + "Use: /testmode <on/off>");
			}
			
			else {
			
				if(args[0].equalsIgnoreCase("on")) {
					
					if(testModeActive) { player.sendMessage(ChatColor.RED + "TestMode already active"); }
					else { enable(); }
				}
				
				else if(args[0].equalsIgnoreCase("off")) {
					
					if(testModeActive) { disable(); }
					else { player.sendMessage(ChatColor.RED + "TestMode already inctive"); }
				}
				
				else {
					
					player.sendMessage(ChatColor.RED + "Use: /testmode <on/off>");
				}
			}
		}
	}
	
	public static void enable() {
		
		testModeActive = true;	
		
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
			
			TestMode.apply(player);
		}
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "TestMode is now active - no items gained will be kept upon deactivation");
	}
	
	public static void disable() {
		
		testModeActive = false;
		
		for(Player player : Bukkit.getServer().getOnlinePlayers()) {
						
			clearInventory(player);
		}
		
		Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "TestMode is now inactive");
	}

	public static void apply(Player player) {

		Inventory inventory = player.getInventory();
		
		inventory.addItem(MakeItemStack.goldCoin(128));
		
		player.updateInventory();
	}
	
	public static void setItemMeta(ItemMeta meta) {
		
		meta.setDisplayName(meta.getDisplayName() + " " + itemPostfix);
	}

	public static void clearInventory(Player player) {
		
		if(player.getInventory().getContents().equals(null)) {}
		else {
			for(ItemStack item : player.getInventory().getContents()) {
	
				clearItems(player, item); 
			}
		}
		
		if(player.getEnderChest().getContents().equals(null)) {}
		else {
			for(ItemStack item : player.getEnderChest().getContents()) {
	
				clearItems(player, item);
			}
		}

		player.updateInventory();
	}
	
	public static void clearItems(Player player, ItemStack item) {
		
		if(item.hasItemMeta()) {
			if(item.getItemMeta().hasDisplayName()) {
				if(item.getItemMeta().getDisplayName().endsWith(itemPostfix)) {
					
					player.getInventory().remove(item);
				}
			}
		}
	}
}
