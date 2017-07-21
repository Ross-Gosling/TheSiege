package playerHandling;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

public class CraftListener implements Listener {
	
//==================================================================================================================================

	//onPlayerCraft Event
	
//==================================================================================================================================

    @EventHandler
    public void onPlayerCraft(PrepareItemCraftEvent event) {
    	
        if (event.isRepair()) {
        	
            event.getInventory().setResult(null);
        }
    }

//==================================================================================================================================

}
