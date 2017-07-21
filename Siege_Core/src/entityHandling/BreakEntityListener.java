package entityHandling;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Painting;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;

public class BreakEntityListener implements Listener {

//==================================================================================================================================

    //onEntityBreak Event
  		
//==================================================================================================================================
  		
    @EventHandler
  	public void onEntityBreak(HangingBreakByEntityEvent event) {
  			    	
    	if(event.getCause().equals(RemoveCause.ENTITY)) {
    		
    		if(event.getRemover() instanceof Arrow) {
    			 
                if(event.getEntity() instanceof ItemFrame) {
                	 
                    event.setCancelled(true);
                }
            }
    		 
    		if(event.getRemover() instanceof Player) {
    			 
        		Player player = (org.bukkit.entity.Player) event.getRemover();
        		    			
        		if((event.getEntity() instanceof ItemFrame) && (player.hasPermission("GroupNode.InBuildMode"))) {}
    	  		
        		else if((event.getEntity() instanceof Painting) && (player.hasPermission("GroupNode.InBuildMode"))) {}
        		
        		else { 
        			
        			event.setCancelled(true);
        		}
            }
    	}
    	
    	else {
    	
	  		event.setCancelled(true);
    	}
  	}
    
//==================================================================================================================================
	
}
