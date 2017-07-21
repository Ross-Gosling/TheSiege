package listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import functions.SpawnHorse;

public class SaddleListener implements Listener {

	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		
		if((player.getItemInHand() == null) || (player.getItemInHand().getType().equals(Material.AIR))) {}
		
		else if(player.getItemInHand() != null) {
		
			ItemStack item = event.getItem();
			
			//If click while holding saddle
			if(item.getType().equals(Material.SADDLE)) {
				
				//RightClick with saddle
				if((action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_AIR)) || (action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK))) {
				
					if(player.hasPermission("GroupNode.InBuildMode")) {
						
						player.sendMessage(ChatColor.RED + "You cannot summon a horse in Build-Mode");
					}
					
					else if(player.hasPermission("GroupNode.RossFaction")) {
					
						SpawnHorse.command("Ross", "Emberstone", (byte) 1, player, item, "Summon");
					}
					
					else if(player.hasPermission("GroupNode.LewisFaction")) {
						
						SpawnHorse.command("Lewis", "Mykonos", (byte) 2, player, item, "Summon");
					}
					
					else if(player.hasPermission("GroupNode.AlexFaction")) {
						
						SpawnHorse.command("Alex", "Summerhold", (byte) 3, player, item, "Summon");
					}
					
					else if(player.hasPermission("GroupNode.CurtisFaction")) {
						
						if(player.getLocation().getY() > 100) {
							
							SpawnHorse.command("Curtis", "Icarus", (byte) 4, player, item, "Summon");
						}
						
						else {
							
							player.sendMessage(ChatColor.RED + "You can only use a saddle in stables");
						}
					}	
					
					else {
						
						player.sendMessage(ChatColor.RED + "Error - you're not in a faction");
					}
				}
				
				//LeftClick with saddle
				else if((action.equals(org.bukkit.event.block.Action.LEFT_CLICK_AIR)) || (action.equals(org.bukkit.event.block.Action.LEFT_CLICK_BLOCK))) {
					
					if(player.hasPermission("GroupNode.InBuildMode")) {
						
						player.sendMessage(ChatColor.RED + "You cannot dismiss a horse in Build-Mode");
					}
					
				    else if(player.hasPermission("GroupNode.RossFaction")) {
						
				    	SpawnHorse.command("Ross", "Emberstone", (byte) 1, player, item, "Dismiss");
					}
					
					else if(player.hasPermission("GroupNode.LewisFaction")) {
						
						SpawnHorse.command("Lewis", "Mykonos", (byte) 2, player, item, "Dismiss");
					}
					
					else if(player.hasPermission("GroupNode.AlexFaction")) {
						
						SpawnHorse.command("Alex", "Summerhold", (byte) 3, player, item, "Dismiss");
					}
					
					else if(player.hasPermission("GroupNode.CurtisFaction")) {
												
						if(player.getLocation().getY() > 100) {
							
							SpawnHorse.command("Curtis", "Icarus", (byte) 4, player, item, "Dismiss");
						}
						
						else {
							
							player.sendMessage(ChatColor.RED + "You can only use a saddle in stables");
						}
					}
					
					else {
						
						player.sendMessage(ChatColor.RED + "Error - you're not in a faction");
					}
			    }
			}
		}
	}
}
