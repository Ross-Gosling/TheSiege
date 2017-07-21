package rewardSystem;

import itemHandling.InventoryFunctions;
import itemHandling.MakeItemStack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RewardCommand {

	public static void reward(Player player, String[] args) {
			
		if(player.hasPermission("GroupNode.Admin")) {
	    	
			if(args.length < 1) {
				
				player.sendMessage(ChatColor.RED + "Use: /reward <player> <amount> <because?...>");
			}
			
			else {
			
				String targetPlayerArg = args[0];
				
				Player targetPlayer = null;
				
				if (Bukkit.getPlayer(targetPlayerArg) == null) {
					
					player.sendMessage(ChatColor.RED + "That player does not exist or is offline");
					player.sendMessage(ChatColor.RED + "Use: /reward <player> <amount> <because?...>");
				}
				
				else {

					targetPlayer = Bukkit.getPlayer(targetPlayerArg);

					if(args.length < 2) {
						
						player.sendMessage(ChatColor.RED + "Use: /reward " + targetPlayer.getName() + " <amount> <because?...>");
					}
					
					else {
					
						String strAmount = args[1];
						
						int amount = 0;
						
						try { 
							
							amount = Integer.parseInt(strAmount);
							
							if(args.length < 3) {
														
								player.sendMessage(ChatColor.RED + "Use: /reward " + targetPlayer.getName() + " " + amount + " <because?...>");
							}
							
							else {
							
						    	String reason = "";
								
						    	for( int i = 2; i <= args.length - 1; i++) {
						    	
						    		reason = reason + (args[i] + " ");
						    			
						    	}
																	
								ItemStack coin = MakeItemStack.goldCoin(amount);
								
								if(InventoryFunctions.canMerge(coin, player.getEnderChest())) {
									
									targetPlayer.getEnderChest().addItem(coin);
									
									Bukkit.broadcastMessage(ChatColor.GREEN + targetPlayer.getName() + " has been awarded " + amount + " coins because " + reason);
									targetPlayer.sendMessage(ChatColor.GREEN + "Your reward has been placed in your enderchest");
									
								}
								
								else if(InventoryFunctions.canMerge(coin, player.getInventory())) {
									
									targetPlayer.getInventory().addItem(coin);
									targetPlayer.updateInventory();
									
									Bukkit.broadcastMessage(ChatColor.GREEN + targetPlayer.getName() + " has been awarded " + amount + " coins because " + reason);
									targetPlayer.sendMessage(ChatColor.GREEN + "Your reward has been placed in your inventory");
									
								}
								
								else {
									
									player.sendMessage(ChatColor.RED + "This player could not be rewarded (no space within their enderchest or inventory)");
									targetPlayer.sendMessage(ChatColor.RED + player.getName() + " couldnt reward you because you don't have space in your enderchest or inventory");
									
								}
								
							}
							
						}
							
						catch (NumberFormatException e) {
							player.sendMessage(ChatColor.RED + "The entered amount was not an integer");
							player.sendMessage(ChatColor.RED + "Use: /reward " + targetPlayer.getName() + " <amount> <because?...>");
						}
					
					}
						
				}
					
			}
			
		}
		
	}
	
}
