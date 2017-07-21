package blockHandling;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlaceListener implements Listener {
	
//==================================================================================================================================

	//onTreeGrow Event
	
//==================================================================================================================================

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		
		if(event.getPlayer().hasPermission("GroupNode.InBuildMode")) { }
		
		else { event.setCancelled(true); }
	}
	
//==================================================================================================================================

}
