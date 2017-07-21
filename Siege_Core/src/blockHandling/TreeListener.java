package blockHandling;

import itemHandling.MakeItemStack;

import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.inventory.ItemStack;

public class TreeListener implements Listener {
	
//==================================================================================================================================

	//onTreeGrow Event
	
//==================================================================================================================================

	@EventHandler
	public void onTreeGrow(StructureGrowEvent event) {
		
		if(event.getSpecies().equals(TreeType.BIG_TREE)) {
			
			event.setCancelled(true);
			
		}
		
	}
	
//==================================================================================================================================

	@EventHandler
	public void onLeavesDecay(LeavesDecayEvent event) {
		
		int random = 0;
		
		random = (int) (Math.random() * 100);
		if (random < 10) { // 0-9
		
        	ItemStack stick = MakeItemStack.stick(1);
    	
        	Location location = event.getBlock().getLocation();
        	World world = event.getBlock().getWorld();
    	
        	world.dropItemNaturally(location, stick);
        	    	
        }
		
	}
	
//==================================================================================================================================
	
}
