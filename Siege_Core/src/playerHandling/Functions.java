package playerHandling;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Functions implements Listener {
	
//==================================================================================================================================

	// clearChat method
	
//==================================================================================================================================

    @EventHandler
    public static void clearChat(Player player) {
    	
        for(int i = 0; i < 150; i++) {
        	
        	player.sendMessage(" ");
        }
    }

//==================================================================================================================================

}
