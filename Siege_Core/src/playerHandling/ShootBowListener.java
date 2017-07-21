package playerHandling;

import itemHandling.MakeItemStack;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

public class ShootBowListener implements Listener {

//==================================================================================================================================

    //onEntityShootBow Event
  		
//==================================================================================================================================
  	
	@EventHandler
	public void onEntityShootBowEvent(EntityShootBowEvent event) {
		
		ItemStack bow = event.getBow();
		Entity entity = event.getEntity();
				
		if((entity instanceof Player) && (bow != null)) {
			
			Player Player = (Player) entity;
				
			if(Player.hasPermission("GroupNode.InBuildMode")) {}
			
			else {
			
				//If bow is flimsy
				if(bow.getItemMeta().getDisplayName().startsWith(MakeItemStack.flimsyBow().getItemMeta().getDisplayName())) { bow.setDurability((short) (bow.getDurability()+7)); }
				
				//If bow is standard
				else if(bow.getItemMeta().getDisplayName().startsWith(MakeItemStack.standardBow().getItemMeta().getDisplayName())) {}
			}
		}
	}
    
//==================================================================================================================================

}
