package playerHandling;

import itemHandling.InventoryFunctions;
import itemHandling.MakeItemStack;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class FishListener implements Listener{

//==================================================================================================================================

	//onFishCaught Event
	
//==================================================================================================================================
	
	@EventHandler
	public void onFishCaught(PlayerFishEvent event) {
				
		Player player = event.getPlayer();
		Entity caughtItem = event.getCaught();
				
		if(caughtItem != null) {
				
			// Deletes vanilla catch
			caughtItem.remove();
			
			// Initialises newCatch
			ItemStack newCatch = null;
			
			//Creates a random number
			int random = 0; random = (int) (Math.random() * 10000);
			
			// Outcome based on random number
			if (random < 7000) { newCatch = MakeItemStack.rawHaddock(1); } // 70% for a haddock
			else if (random < 9990) { newCatch = MakeItemStack.rawSalmon(1); } // 29.9% for a salmon
			else { newCatch = MakeItemStack.diamondChestplate(); } // 0.1% for a diamond chestplate
			
			if(InventoryFunctions.canMerge(newCatch, player.getInventory()) == true) {
				
				player.getInventory().addItem(newCatch);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
			}
			
			else {
            	
	        	Location location = player.getLocation();
	        	location.setY(location.getY()+1);
	        	World world = player.getWorld();
	        	 	
	            world.dropItem(location, newCatch);
			}
		}
	}
	
//==================================================================================================================================

}
