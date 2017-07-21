package blockHandling;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class SpreadListener implements Listener {

	@EventHandler
	public void onBlockSpread(BlockSpreadEvent event) {
		
		if(event.getSource().getType().equals(Material.WATER)) {	}
		else if(event.getSource().getType().equals(Material.LAVA)) {	}
		else if(event.getSource().getType().equals(Material.GRASS)) {	}
		else {
			event.setCancelled(true);
		}
	}
}
