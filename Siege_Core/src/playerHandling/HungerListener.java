package playerHandling;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerListener implements Listener {
	
//==================================================================================================================================

	//onPlayerCraft Event
	
//==================================================================================================================================

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
    	
        if(!event.getEntity().hasPermission("GroupNode.RossFaction") && !event.getEntity().hasPermission("GroupNode.LewisFaction") && !event.getEntity().hasPermission("GroupNode.AlexFaction") && !event.getEntity().hasPermission("GroupNode.CurtisFaction")) {
        	
            event.setFoodLevel(20);
        }
    }

//==================================================================================================================================

}
