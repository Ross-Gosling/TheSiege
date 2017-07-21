package playerHandling;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {
	
//==================================================================================================================================

	//onEntityDeath Event
					
//==================================================================================================================================
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
						
		Player victimEntity = event.getEntity();
		LivingEntity killerEntity = event.getEntity().getKiller();
			
		event.setDeathMessage(null);
		
		event.setDroppedExp(0);
		
		ArrayList<ItemStack> remove = new ArrayList<>();
						
		for(ItemStack drop : event.getDrops()) {
			
			if(me.x3DGosling.Siege_InventorySystem.Main.undroppableItems.contains(drop.getType())) {
				remove.add(drop);
			}
			
			//You cant drop items that dont have a display name
			if(drop.getItemMeta().hasDisplayName() == false) {
				remove.add(drop);
			}
		    
		}
		 
		for(ItemStack itemStack : remove) {
		    event.getDrops().remove(itemStack);
		}
	
		Player victim = (Player) victimEntity;
		
		if(killerEntity instanceof Player) {
		
			Player killer = (Player) killerEntity;
			
			if(killer != null) {
				
				String victimTeam = "";
				ChatColor victimColour = ChatColor.WHITE;
				
				String killerTeam = "";
				ChatColor killerColour = ChatColor.WHITE;
				
				//=======
				
				if(victim.hasPermission("GroupNode.RossFaction")) {
					victimTeam = "Ross";
					victimColour = ChatColor.RED;
				}
				
				else if(victim.hasPermission("GroupNode.LewisFaction")) {
					victimTeam = "Lewis";
					victimColour = ChatColor.LIGHT_PURPLE;
				}
				
				else if(victim.hasPermission("GroupNode.AlexFaction")) {
					victimTeam = "Alex";
					victimColour = ChatColor.GREEN;
				}
				
				else if(victim.hasPermission("GroupNode.CurtisFaction")) {
					victimTeam = "Curtis";
					victimColour = ChatColor.AQUA;
				}
				
				//=======
				
				if(killer.hasPermission("GroupNode.RossFaction")) {
					killerTeam = "Ross";
					killerColour = ChatColor.RED;
				}
				
				else if(killer.hasPermission("GroupNode.LewisFaction")) {
					killerTeam = "Lewis";
					killerColour = ChatColor.LIGHT_PURPLE;
				}
				
				else if(killer.hasPermission("GroupNode.AlexFaction")) {
					killerTeam = "Alex";
					killerColour = ChatColor.GREEN;
				}
				
				else if(killer.hasPermission("GroupNode.CurtisFaction")) {
					killerTeam = "Curtis";
					killerColour = ChatColor.AQUA;
				}
				
				//=======
				
				announcePvP(victim, victimTeam, victimColour, killer, killerTeam, killerColour);
				
			}
			
		}
		
		else {
			
			if(victim.hasPermission("GroupNode.InBuildMode")) {
				
			    //Do nothing
				
			}
			
			else {
			
				String team = "";
				ChatColor teamColour = ChatColor.WHITE;
	            
				if(victim.hasPermission("GroupNode.RossFaction")) {
					team = "Ross";
					teamColour = ChatColor.RED;
				}
				
				else if(victim.hasPermission("GroupNode.LewisFaction")) {
					team = "Lewis";
					teamColour = ChatColor.LIGHT_PURPLE;
				}
				
				else if(victim.hasPermission("GroupNode.AlexFaction")) {
					team = "Alex";
					teamColour = ChatColor.GREEN;
				}
				
				else if(victim.hasPermission("GroupNode.CurtisFaction")) {
					team = "Curtis";
					teamColour = ChatColor.AQUA;
				}
				
				announcePvE(victim, team, teamColour, victim.getKiller());
            
			}
			
	    }
		
	}
	
//==================================================================================================================================

	public void announcePvP(Player victim, String victimTeam, ChatColor victimColour, Player killer, String killerTeam, ChatColor killerColour) {
		
	    for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
		    
		    if(onlinePlayers.hasPermission("GroupNode." + victimTeam + "Faction")) {
		    	
        		if(killer.hasPermission("GroupNode.Admin")) {
        			
        			if(victim.hasPermission("GroupNode.Admin")) {
        			
        				onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Lord " + killerColour + killer.getName());
        			}
        			    
        			else if(victim.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Lord " + killerColour + killer.getName());	
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Lord " + killerColour + killer.getName());
            		}
        		}
        		
        		else if(killer.hasPermission("GroupNode.Captain")) {

        			if(victim.hasPermission("GroupNode.Admin")) {
            			
        			    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Cpt " + killerColour + killer.getName());
        			}
        			    
        			else if(victim.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Cpt " + killerColour + killer.getName());
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + ChatColor.GOLD + "Cpt " + killerColour + killer.getName());
            		}
        		}
        		
        		else {
        			
        			if(victim.hasPermission("GroupNode.Admin")) {
            			
        			    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + killerColour + killer.getName());
        			}
        			    
        			else if(victim.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + killerColour + killer.getName());
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(victimColour + victim.getName() + ChatColor.YELLOW + " was killed by " + killerColour + killer.getName());
            		}
        		}
		    }
		    
		    if(onlinePlayers.hasPermission("GroupNode." + killerTeam + "Faction")) {
		    	
        		if(victim.hasPermission("GroupNode.Admin")) {
        			
        			if(killer.hasPermission("GroupNode.Admin")) {
        			
        			    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Lord " + victimColour + victim.getName());
        			}
        			    
        			else if(killer.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Lord " + victimColour + victim.getName());
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Lord " + victimColour + victim.getName());
            		}
        			
        		}
        		
        		else if(victim.hasPermission("GroupNode.Captain")) {

        			if(killer.hasPermission("GroupNode.Admin")) {
            			
        			    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Cpt " + victimColour + victim.getName());
        			}
        			    
        			else if(killer.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Cpt " + victimColour + victim.getName());
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(killerColour + killer.getName() + ChatColor.YELLOW + " killed " + ChatColor.GOLD + "Cpt " + victimColour + victim.getName());
            		}
        		}
        		
        		else {
        			
        			if(killer.hasPermission("GroupNode.Admin")) {
            			
        			    onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + victimColour + victim.getName());
        			}
        			    
        			else if(killer.hasPermission("GroupNode.Captain")) {
        				
            			onlinePlayers.sendMessage(ChatColor.GOLD + "Cpt " + killerColour + killer.getName() + ChatColor.YELLOW + " killed " + victimColour + victim.getName());
            		}
            		
            		else {
            			
            			onlinePlayers.sendMessage(killerColour + killer.getName() + ChatColor.YELLOW + " killed " + victimColour + victim.getName());
            		}
        		}
		    }
    	}
	}
	
	public void announcePvE(Player victim, String victimTeam, ChatColor victimColour, Entity killer) {
		
	    for(Player onlinePlayers: Bukkit.getServer().getOnlinePlayers()) {
		    
		    if(onlinePlayers.hasPermission("GroupNode." + victimTeam + "Faction")) {
		    	
        		if(victim.hasPermission("GroupNode.Admin")) {
        			
        			onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + victimColour + victim.getName() + ChatColor.YELLOW + " died");
        		}
        		
        		else if(victim.hasPermission("GroupNode.Captain")) {

        			onlinePlayers.sendMessage(ChatColor.GOLD + "Lord " + victimColour + victim.getName() + ChatColor.YELLOW + " died");
        		}
        		
        		else {
        			
        			onlinePlayers.sendMessage(victimColour + victim.getName() + ChatColor.YELLOW + " died");
        		}
		    }
	    }
	}
}
