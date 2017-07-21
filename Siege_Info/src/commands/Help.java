package commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {

	public static void broadcast(Player player, String[] args) {

		if(args.length == 0) {
			
			//If in build mode
		    if(player.hasPermission("GroupNode.InBuildMode")) {
						    		    	
		    	player.sendMessage("-----------------------------------");
		    	player.sendMessage(ChatColor.DARK_GREEN + "Useful commands:");
		    	player.sendMessage(ChatColor.GREEN + "/Play " + ChatColor.WHITE + "- Quits build mode");
		    	player.sendMessage(ChatColor.GREEN + "/A <Msg> " + ChatColor.WHITE + "- Broadcasts messages to all admins");
		    	player.sendMessage(ChatColor.GREEN + "/Pm <Player> " + ChatColor.WHITE + "- Messages a player");
		    	player.sendMessage(ChatColor.GREEN + "/Help Teleports " + ChatColor.WHITE + "- Displays how to teleport");
		    	player.sendMessage(ChatColor.GREEN + "/Help Shops " + ChatColor.WHITE + "- Displays how to spawn traders");
		    	player.sendMessage("-----------------------------------");
			}
			
			else {
	
				//If in a faction
	            if((player.hasPermission("GroupNode.RossFaction")) || (player.hasPermission("GroupNode.LewisFaction")) || (player.hasPermission("GroupNode.AlexFaction")) || (player.hasPermission("GroupNode.CurtisFaction"))) {
	            	
	            	player.sendMessage("-----------------------------------");
	            	player.sendMessage(ChatColor.DARK_GREEN + "Useful commands:");
	            	player.sendMessage(ChatColor.GREEN + "/Leave " + ChatColor.WHITE + "- Allows you to leave your faction");
	            	player.sendMessage(ChatColor.GREEN + "/H <Msg> " + ChatColor.WHITE + "- Sends admins a message for help");
	            		
	                //If the player is a captain or lord
	                if((player.hasPermission("GroupNode.Captain")) || (player.hasPermission("GroupNode.Admin"))) {
	                	
	                	player.sendMessage(ChatColor.GREEN + "/F <Msg> " + ChatColor.WHITE + "- Broadcasts messages to your faction");
	                }
	                
	                //If the player is a lord
	                if(player.hasPermission("GroupNode.Admin")) {
	                	
	                	player.sendMessage(ChatColor.GREEN + "/A <Msg> " + ChatColor.WHITE + "- Broadcasts messages to all admins");
	                	player.sendMessage(ChatColor.GREEN + "/Pm <Player> " + ChatColor.WHITE + "- Messages a player");
	                	player.sendMessage(ChatColor.GREEN + "/Banish <Player> " + ChatColor.WHITE + "- Banishes players from your faction");
	                	player.sendMessage(ChatColor.GREEN + "/Unbanish <Player> " + ChatColor.WHITE + "- Allows a player back into your faction");
	                	player.sendMessage(ChatColor.GREEN + "/Reward <Player> <Amount> <Because?...> " + ChatColor.WHITE + "- Rewards a player with coins");
	                	player.sendMessage(ChatColor.GREEN + "/Captain <Add/Remove> <Player> " + ChatColor.WHITE + "- Promotes/Demotes players");
	                	player.sendMessage(ChatColor.GREEN + "/Build " + ChatColor.WHITE + "- Enters build mode");
	                }
	            }
	            
	            //If not in faction, i.e. in lobby
	            else {
	            	
	            	player.sendMessage("-----------------------------------");
	            	player.sendMessage(ChatColor.DARK_GREEN + "Useful instructions:");
	            	player.sendMessage(ChatColor.GREEN + "Joining a Faction " + ChatColor.WHITE + "- To join a faction you");
	            	player.sendMessage(ChatColor.WHITE + "have to right click on of the four signs,");
	            	player.sendMessage(ChatColor.WHITE + "you may leave a faction at anytime but");
	            	player.sendMessage(ChatColor.WHITE + "your items are cleared and you have to");
	            	player.sendMessage(ChatColor.WHITE + "restart from scratch");
	            }
	            
	            player.sendMessage("-----------------------------------");
		    }
		}
		
		//If you use /help teleports
		else if((args[0].equalsIgnoreCase("teleports")) && (player.hasPermission("GroupNode.Admin"))) {
			
			player.sendMessage("-----------------------------------");
			player.sendMessage(ChatColor.DARK_GREEN + "Teleport Locations:");
			player.sendMessage(ChatColor.GREEN + "/E, /M, /S or /I " + ChatColor.WHITE + "- Teleport to a City");
			player.sendMessage(ChatColor.GREEN + "/ET, /MT etc " + ChatColor.WHITE + "- Teleport to a Throne");
			player.sendMessage(ChatColor.GREEN + "/Lobby " + ChatColor.WHITE + "- Teleport to the Spawn Lobby");
			player.sendMessage(ChatColor.GREEN + "/Diamond " + ChatColor.WHITE + "- Teleport to the Diamond Mine");
			player.sendMessage(ChatColor.GREEN + "/Iron1,2 " + ChatColor.WHITE + "- Teleport to an Iron Mine");
			player.sendMessage(ChatColor.GREEN + "/Fort1,2 " + ChatColor.WHITE + "- Teleport to a Fort");
			player.sendMessage("-----------------------------------");
		}
		
		//If you use /help shops
		else if((args[0].equalsIgnoreCase("shops")) && (player.hasPermission("GroupNode.Admin"))) {
			
			player.sendMessage("-----------------------------------");
			player.sendMessage(ChatColor.DARK_GREEN + "Summon Command:");
			player.sendMessage(ChatColor.GREEN + "/trader <type>" + ChatColor.WHITE + " - Spawns the villager");
			player.sendMessage(ChatColor.DARK_GREEN + "Trader Types:");
			player.sendMessage(ChatColor.GREEN + "Armour, Sword, Pickaxe, Axe " + ChatColor.WHITE + "- Black");
			player.sendMessage(ChatColor.GREEN + "Bow, Horse, Equipment " + ChatColor.WHITE + "- Brown");
			player.sendMessage(ChatColor.GREEN + "Potion " + ChatColor.WHITE + "- Purple");
			player.sendMessage(ChatColor.GREEN + "Food, Fish " + ChatColor.WHITE + "- Apron");
			player.sendMessage(ChatColor.GREEN + "Material " + ChatColor.WHITE + "- White");
			player.sendMessage("-----------------------------------");
		}
	}
}
