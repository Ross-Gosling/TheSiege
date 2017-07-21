package functions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;

public class SpawnTrader {
	
	public static void placeShop(Player player, String[] args) {
		
		if(player.hasPermission("GroupNode.Admin")) {
			
			if(args.length == 1) {
			
				Villager villager = (Villager) player.getLocation().getWorld().spawn(player.getLocation(), Villager.class);
				String name = "";
				
				if(args[0].equalsIgnoreCase("armour")) {
					name = "Blacksmith - Armour";
					villager.setProfession(Profession.BLACKSMITH);
				}
				
				else if(args[0].equalsIgnoreCase("sword")) {
					name = "Blacksmith - Swords";
					villager.setProfession(Profession.BLACKSMITH);
				}
				
				else if(args[0].equalsIgnoreCase("pickaxe")) {
					name = "Blacksmith - Pickaxes";
					villager.setProfession(Profession.BLACKSMITH);
				}
				
				else if(args[0].equalsIgnoreCase("axe")) {
					name = "Blacksmith - Axes";
					villager.setProfession(Profession.BLACKSMITH);
				}
				
				else if(args[0].equalsIgnoreCase("bow")) {
					name = "Bow Trader";
					villager.setProfession(Profession.FARMER);
				}
				
				else if(args[0].equalsIgnoreCase("equipment")) {
					name = "Equipment Trader";
					villager.setProfession(Profession.FARMER);
				}
				
				else if(args[0].equalsIgnoreCase("food")) {
					name = "Food Trader";
					villager.setProfession(Profession.BUTCHER);
				}
				
				else if(args[0].equalsIgnoreCase("fish")) {
					name = "Fish Trader";
					villager.setProfession(Profession.BUTCHER);
				}
				
				else if(args[0].equalsIgnoreCase("material")) {
					name = "Materials Trader";
					villager.setProfession(Profession.LIBRARIAN);
				}
				
				else if(args[0].equalsIgnoreCase("horse")) {
					name = "Horse Trader";
					villager.setProfession(Profession.FARMER);
				}
				
				else if(args[0].equalsIgnoreCase("potion")) {
					name = "Potion Trader";
					villager.setProfession(Profession.PRIEST);
				}
				
				else {
					
					player.sendMessage(ChatColor.RED + "Invalid Trader Type");
					name = "ERROR";
					villager.remove();
				}
				
				villager.setCustomName(name);
			}
			
			else {
				
				player.sendMessage(ChatColor.RED + "Use: /trader <type>");
			}
		}
	}
}
