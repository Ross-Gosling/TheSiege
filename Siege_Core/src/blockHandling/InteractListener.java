package blockHandling;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

//==================================================================================================================================

	//onPlayerInteractEvent Event
	
//==================================================================================================================================

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Block block = null;
		Action action = null;
		
		if(event.getClickedBlock() != null) {
			block = event.getClickedBlock();
		}
		
		if(event.getAction() != null) {
			action = event.getAction();
		}
		
		if((event.getAction() == null) || (event.getClickedBlock() == null)) {}
		
		else {
		
			Block regionBlock = block.getLocation().getWorld().getBlockAt((int)block.getLocation().getX(), (int)0, (int)block.getLocation().getZ());
			    	
			if (event.getAction().equals(Action.PHYSICAL)) {
				
	        	if (event.getClickedBlock().getType().equals( Material.SOIL )) {
	                
		            if (event.getPlayer() != null) {
		            	
		                event.setCancelled(true);
		                
		            }
	            }
	        }
			
			if(action.equals(org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK)) {
										
				//Click Enchanting Table
				if(block.getType().equals(Material.ENCHANTMENT_TABLE)) {
					
					event.setCancelled(true);
										
				}
				
				//Click Trapdoor
				if(block.getType().equals(Material.TRAP_DOOR)) {
					
		    		if(player.hasPermission("GroupNode.InBuildMode")) {
		    			
		    			//Do Nothing
		    			
		    		}
		    		
		    		else {
		    		        	
		    			event.setCancelled(true);
		            
		    		}
					
				}
				
				//Click Chest
				if((block.getType().equals(Material.CHEST)) || (block.getType().equals(Material.TRAPPED_CHEST))) {
						    		        	
		    		event.setCancelled(true);
		            				
				}
				
				//Click Brewing Stand
				if(block.getType().equals(Material.BREWING_STAND)) {
		    			    		        	
		    		if(player.hasPermission("GroupNode.InBuildMode")) {
		    			
		    			//Do Nothing
		    			
		    		}
		    		
		    		else {
		    		        	
		    			event.setCancelled(true);
		            
		    		}
		            				
				}
				
				//Click Beacon
				if(block.getType().equals(Material.BEACON)) {
		    	
		    		event.setCancelled(true);
		        
				}
				
				//Click Anvil
				if(block.getType().equals(Material.ANVIL)) {
		    				    		        	
		    		event.setCancelled(true);
		    			
		    		player.openWorkbench(null, true);
		            	            				
				}
				
				//Click Enderchest
				if(block.getType().equals(Material.ENDER_CHEST)) {
					
					//If player in BuildMode
					if(player.hasPermission("GroupNode.InBuildMode")) {
					
						event.setCancelled(true);
						
						player.sendMessage(ChatColor.RED + "You cannot access enderchests in Build-Mode");
						
					}
							
					//If player in emberstone and in ross faction
					else if((regionBlock.getData() == (byte)1) && (player.hasPermission("GroupNode.RossFaction"))) { }
					
					//Else if player in mykonos and in lewis faction
					else if((regionBlock.getData() == (byte)2) && (player.hasPermission("GroupNode.LewisFaction"))) { }
					
					//Else if player in summerhold and in alex faction
					else if((regionBlock.getData() == (byte)3) && (player.hasPermission("GroupNode.AlexFaction"))) { }
					
					//Else if player in icarus and in curtis faction
					else if((regionBlock.getData() == (byte)4) && (block.getY() > 100) && (player.hasPermission("GroupNode.CurtisFaction"))) { }
					
					//Else
					else {
						
						event.setCancelled(true);
						
						player.sendMessage(ChatColor.RED + "You cannot access another faction's enderchest");
					}
				}
			}
		}
	}	

//==================================================================================================================================

}
