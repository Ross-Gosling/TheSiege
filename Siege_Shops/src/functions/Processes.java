//==================================================================================================================================
	
package functions;

import itemHandling.InventoryFunctions;
import itemHandling.MakeItemStack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
 
public final class Processes {
 
//==================================================================================================================================
	
	public static void processPurchase(Player player, ItemStack item, int cost) {
		
		ItemStack coin = MakeItemStack.goldCoin(1);
		
		if(player.getInventory().containsAtLeast(coin, cost)) {
			
			if(InventoryFunctions.canMerge(item, player.getInventory())) {
				
				InventoryFunctions.removeItem(coin, cost, player.getInventory());
				player.getInventory().addItem(item);
				
				String message = (ChatColor.GREEN + "Successful purchase: " + item.getItemMeta().getDisplayName() + " (x" + item.getAmount() + ")");
				
				Bukkit.getLogger().info(player.getName() + " - " +message);
				player.sendMessage(message);
				
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				player.updateInventory();
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "You don't have enough inventory space");
			}
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "You cannot afford this item");
		}
	}
	
	public static void processSale(Player player, ItemStack item, int price) {
		
		ItemStack coin = MakeItemStack.goldCoin(price);
		
		if(player.getInventory().containsAtLeast(item, item.getAmount())) {
			
			if(InventoryFunctions.canMerge(coin, player.getInventory())) {
				
				InventoryFunctions.removeItem(item, item.getAmount(), player.getInventory());
				player.getInventory().addItem(coin);
				
				String message =(ChatColor.GREEN + "Successful sale: " + item.getItemMeta().getDisplayName() + " (x" + item.getAmount() + ")");
				
				Bukkit.getLogger().info(player.getName() + " - " +message);
				player.sendMessage(message);
				
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				player.updateInventory();
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "You don't have enough inventory space");
			}
		}
		
		else {
			
			player.sendMessage(ChatColor.RED + "You don't have enough items to sell");
		}
	}
	
//==================================================================================================================================
	
}