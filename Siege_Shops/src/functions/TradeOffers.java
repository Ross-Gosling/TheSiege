//==================================================================================================================================

package functions;

import java.util.ArrayList;

import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Shops.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TradeOffers {

//==================================================================================================================================
	
	// Offers
	// Armour shop
	public static ItemStack buy_LeatherChestplate = makeOfferItem(MakeItemStack.leatherChestplate(), Main.value_buy_LeatherChestplate, false);
	public static ItemStack buy_IronChestplate = makeOfferItem(MakeItemStack.ironChestplate(), Main.value_buy_IronChestplate, false);
	// Sword shop
	public static ItemStack buy_RustySword = makeOfferItem(MakeItemStack.rustySword(), Main.value_buy_RustySword, false);
	public static ItemStack buy_DulledSword = makeOfferItem(MakeItemStack.dulledSword(), Main.value_buy_DulledSword, false);
	public static ItemStack buy_StandardSword = makeOfferItem(MakeItemStack.standardSword(), Main.value_buy_StandardSword, false);
	// Pickaxe shop
	public static ItemStack buy_RustyPickaxe = makeOfferItem(MakeItemStack.rustyPick(), Main.value_buy_RustyPickaxe, false);
	public static ItemStack buy_DulledPickaxe = makeOfferItem(MakeItemStack.dulledPick(), Main.value_buy_DulledPickaxe, false);
	public static ItemStack buy_StandardPickaxe = makeOfferItem(MakeItemStack.standardPick(), Main.value_buy_StandardPickaxe, false);
	// Axe shop
	public static ItemStack buy_RustyAxe = makeOfferItem(MakeItemStack.rustyAxe(), Main.value_buy_RustyAxe, false);
	public static ItemStack buy_DulledAxe = makeOfferItem(MakeItemStack.dulledAxe(), Main.value_buy_DulledAxe, false);
	public static ItemStack buy_StandardAxe = makeOfferItem(MakeItemStack.standardAxe(), Main.value_buy_StandardAxe, false);
	// Bow shop
	public static ItemStack buy_FlimsyBow = makeOfferItem(MakeItemStack.flimsyBow(), Main.value_buy_FlimsyBow, false);
	public static ItemStack buy_StandardBow = makeOfferItem(MakeItemStack.standardBow(), Main.value_buy_StandardBow, false);
	public static ItemStack buy_Arrow_1 = makeOfferItem(MakeItemStack.arrow(Main.amount_buy_Arrow1), Main.value_buy_Arrow1, false);
	public static ItemStack buy_Arrow_2 = makeOfferItem(MakeItemStack.arrow(Main.amount_buy_Arrow2), Main.value_buy_Arrow2, false);
	public static ItemStack buy_Arrow_3 = makeOfferItem(MakeItemStack.arrow(Main.amount_buy_Arrow3), Main.value_buy_Arrow3, false);
	// Equipment shop
	public static ItemStack buy_Flare_Emberstone = makeOfferItem(MakeItemStack.flare(Main.amount_buy_Flare, "Emberstone", Color.RED), Main.value_buy_Flare, false);
	public static ItemStack buy_Flare_Mykonos = makeOfferItem(MakeItemStack.flare(Main.amount_buy_Flare, "Mykonos", Color.PURPLE), Main.value_buy_Flare, false);
	public static ItemStack buy_Flare_Summerhold = makeOfferItem(MakeItemStack.flare(Main.amount_buy_Flare, "Summerhold", Color.GREEN), Main.value_buy_Flare, false);
	public static ItemStack buy_Flare_Icarus = makeOfferItem(MakeItemStack.flare(Main.amount_buy_Flare, "Icarus", Color.AQUA), Main.value_buy_Flare, false);
	// Food shop
	public static ItemStack buy_Biscuit = makeOfferItem(MakeItemStack.biscuit(Main.amount_buy_Food), Main.value_buy_Biscuit, false);
	public static ItemStack buy_Bread = makeOfferItem(MakeItemStack.bread(Main.amount_buy_Food), Main.value_buy_Bread, false);
	public static ItemStack buy_Potato = makeOfferItem(MakeItemStack.bakedPotato(Main.amount_buy_Food), Main.value_buy_Potato, false);
	public static ItemStack buy_Meat = makeOfferItem(MakeItemStack.grilledMeat(Main.amount_buy_Food), Main.value_buy_Meat, false);
	// Fish shop
	public static ItemStack buy_Haddock = makeOfferItem(MakeItemStack.friedHaddock(Main.amount_buy_Food), Main.value_buy_Haddock, false);
	public static ItemStack buy_Salmon = makeOfferItem(MakeItemStack.friedSalmon(Main.amount_buy_Food), Main.value_buy_Salmon, false);
	public static ItemStack buy_FishingRod = makeOfferItem(MakeItemStack.fishingRod(), Main.value_buy_FishingRod, false);
	// Material shop
	public static ItemStack buy_Coal = makeOfferItem(MakeItemStack.coal(Main.amount_buy_Coal), Main.value_buy_Coal, false);
	public static ItemStack buy_Stick = makeOfferItem(MakeItemStack.stick(Main.amount_buy_Stick), Main.value_buy_Stick, false);
	public static ItemStack buy_String = makeOfferItem(MakeItemStack.string(Main.amount_buy_String), Main.value_buy_String, false);
	public static ItemStack sell_Coal = makeOfferItem(MakeItemStack.coal(Main.amount_sell_Coal), Main.value_sell_Coal, true);
	public static ItemStack sell_Log = makeOfferItem(MakeItemStack.log(Main.amount_sell_Log), Main.value_sell_Log, true);
	// Horse shop
	public static ItemStack buy_IronHorseArmour = makeOfferItem(MakeItemStack.ironHorseArmour(), Main.value_buy_IronHorseArmour, false);
	public static ItemStack buy_Saddle_Basic = makeOfferItem(MakeItemStack.saddle_Basic(), Main.value_buy_Saddle_Basic, false);
	public static ItemStack buy_Saddle_Scout = makeOfferItem(MakeItemStack.saddle_Scout(), Main.value_buy_Saddle_Scout, false);
	public static ItemStack buy_Saddle_Light = makeOfferItem(MakeItemStack.saddle_Light(), Main.value_buy_Saddle_Light, false);
	public static ItemStack buy_Saddle_Ross = makeOfferItem(MakeItemStack.saddle_Ross(), Main.value_buy_Saddle_Light, false);
	public static ItemStack buy_Saddle_Lewis = makeOfferItem(MakeItemStack.saddle_Lewis(), Main.value_buy_Saddle_Light, false);
	public static ItemStack buy_Saddle_Alex = makeOfferItem(MakeItemStack.saddle_Alex(), Main.value_buy_Saddle_Light, false);
	public static ItemStack buy_Saddle_Curtis = makeOfferItem(MakeItemStack.saddle_Curtis(), Main.value_buy_Saddle_Light, false);
	// Potion shop
	public static ItemStack buy_Potion_NightVision_Lv1 = makeOfferItem(MakeItemStack.nightVisionPotion(), Main.value_buy_Potion_NightVision_Lv1, false);
	public static ItemStack buy_Potion_NightVision_Lv2 = makeOfferItem(MakeItemStack.nightVisionPotion2(), Main.value_buy_Potion_NightVision_Lv2, false);
	public static ItemStack buy_Potion_Speed_Lv1 = makeOfferItem(MakeItemStack.speedPotion(), Main.value_buy_Potion_Speed_Lv1, false);
	public static ItemStack buy_Potion_Speed_Lv2 = makeOfferItem(MakeItemStack.speedPotion2(), Main.value_buy_Potion_Speed_Lv2, false);
	public static ItemStack buy_Potion_Speed_Lv3 = makeOfferItem(MakeItemStack.speedPotion3(), Main.value_buy_Potion_Speed_Lv3, false);
	public static ItemStack buy_Potion_Invisibility_Lv1 = makeOfferItem(MakeItemStack.invisibilityPotion(), Main.value_buy_Potion_Invisibility_Lv1, false);
	public static ItemStack buy_Potion_Invisibility_Lv2 = makeOfferItem(MakeItemStack.invisibilityPotion2(), Main.value_buy_Potion_Invisibility_Lv2, false);
	
//==================================================================================================================================

	public static void Open(Player player, Entity entity) {
		
		if(((Villager) entity).getCustomName().equals("Blacksmith - Armour")) {
			player.openInventory(TradeOffers.armourShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Blacksmith - Swords")) {
			player.openInventory(TradeOffers.swordShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Blacksmith - Pickaxes")) {
			player.openInventory(TradeOffers.pickShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Blacksmith - Axes")) {
			player.openInventory(TradeOffers.axeShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Bow Trader")) {
			player.openInventory(TradeOffers.bowShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Equipment Trader")) {
			player.openInventory(TradeOffers.equipmentShop(player));
		}
		
		else if(((Villager) entity).getCustomName().equals("Food Trader")) {
			player.openInventory(TradeOffers.foodShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Fish Trader")) {
			player.openInventory(TradeOffers.fishShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Materials Trader")) {
			player.openInventory(TradeOffers.materialsShop());
		}
		
		else if(((Villager) entity).getCustomName().equals("Horse Trader")) {
			player.openInventory(TradeOffers.horseShop(player));
		}
		
		else if(((Villager) entity).getCustomName().equals("Potion Trader")) {
			player.openInventory(TradeOffers.potionShop());
		}
	}
	
//==================================================================================================================================
	
	public static Inventory armourShop() {
	
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Blacksmith - Armour");
				
		tradeInv.setItem(0, buy_LeatherChestplate);
		tradeInv.setItem(1, buy_IronChestplate);
		
		return tradeInv;
	}
	
	public static Inventory swordShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Blacksmith - Swords");
			
		tradeInv.setItem(0, buy_RustySword);
		tradeInv.setItem(1, buy_DulledSword);
		tradeInv.setItem(2, buy_StandardSword);
		
		return tradeInv;
	}
	
	public static Inventory pickShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Blacksmith - Pickaxes");
			
		tradeInv.setItem(0, buy_RustyPickaxe);
		tradeInv.setItem(1, buy_DulledPickaxe);
		tradeInv.setItem(2, buy_StandardPickaxe);
		
		return tradeInv;
	}
	
	public static Inventory axeShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Blacksmith - Axes");
			
		tradeInv.setItem(0, buy_RustyAxe);
		tradeInv.setItem(1, buy_DulledAxe);
		tradeInv.setItem(2, buy_StandardAxe);
		
		return tradeInv;
	}
	
	public static Inventory bowShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Bow Trader");
			
		tradeInv.setItem(0, buy_FlimsyBow);
		tradeInv.setItem(1, buy_StandardBow);
		tradeInv.setItem(2, buy_Arrow_1);
		tradeInv.setItem(3, buy_Arrow_2);
		tradeInv.setItem(4, buy_Arrow_3);
		
		return tradeInv;
	}
	
	public static Inventory equipmentShop(Player player) {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Equipment Trader");
			
		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			tradeInv.setItem(0, buy_Flare_Emberstone);
			tradeInv.setItem(1, buy_Flare_Mykonos);
			tradeInv.setItem(2, buy_Flare_Summerhold);
			tradeInv.setItem(3, buy_Flare_Icarus);
		}
		
		else if(player.hasPermission("GroupNode.RossFaction")) {
			tradeInv.setItem(0, buy_Flare_Emberstone);
		}
		
		else if(player.hasPermission("GroupNode.LewisFaction")) {
			tradeInv.setItem(0, buy_Flare_Mykonos);
		}
		
		else if(player.hasPermission("GroupNode.AlexFaction")) {
			tradeInv.setItem(0, buy_Flare_Summerhold);
		}
		
		else if(player.hasPermission("GroupNode.CurtisFaction")) {
			tradeInv.setItem(0, buy_Flare_Icarus);
		}
		
		return tradeInv;
	}
	
	public static Inventory foodShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Food Trader");
			
		tradeInv.setItem(0, buy_Biscuit);
		tradeInv.setItem(1, buy_Bread);
		tradeInv.setItem(2, buy_Potato);
		tradeInv.setItem(3, buy_Meat);
		
		return tradeInv;
	}
	
	public static Inventory fishShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Fish Trader");
			
		tradeInv.setItem(0, buy_Haddock);
		tradeInv.setItem(1, buy_Salmon);
		tradeInv.setItem(2, buy_FishingRod);
		
		return tradeInv;
	}
	
	public static Inventory materialsShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Materials Trader");
		
		tradeInv.setItem(0, buy_Coal);
		tradeInv.setItem(1, buy_Stick);
		tradeInv.setItem(2, buy_String);
		tradeInv.setItem(7, sell_Coal);
		tradeInv.setItem(8, sell_Log);
		
		return tradeInv;
	}
	
	public static Inventory horseShop(Player player) {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Horse Trader");
			
		tradeInv.setItem(0, buy_IronHorseArmour);
		tradeInv.setItem(1, buy_Saddle_Basic);
		tradeInv.setItem(2, buy_Saddle_Scout);
		tradeInv.setItem(3, buy_Saddle_Light);
		
		if(player.hasPermission("GroupNode.InBuildMode")) {
			
			tradeInv.setItem(5, buy_Saddle_Ross);
			tradeInv.setItem(6, buy_Saddle_Lewis);
			tradeInv.setItem(7, buy_Saddle_Alex);
			tradeInv.setItem(8, buy_Saddle_Curtis);
		}
		
		else if(player.getUniqueId().toString().equals("419a1963-afbe-4f83-9355-ac6d895f248d")) {
			tradeInv.setItem(4, buy_Saddle_Ross);
		}
		
		else if(player.getUniqueId().toString().equals("d2fd0813-0b34-4fed-92a8-b448e42f9db2")) {
			tradeInv.setItem(4, buy_Saddle_Lewis);
		}
		
		else if(player.getUniqueId().toString().equals("821c8e9d-8cd8-40cd-a976-cb07ca5eee66")) {
			tradeInv.setItem(4, buy_Saddle_Alex);
		}
		
		else if(player.getUniqueId().toString().equals("adbd6692-58fa-40f2-a65e-33e29b708077")) {
			tradeInv.setItem(4, buy_Saddle_Curtis);
		}
		
		return tradeInv;
	}
	
	public static Inventory potionShop() {
		
		Inventory tradeInv = Bukkit.createInventory(null, 9, "Potion Trader");
			
		tradeInv.setItem(0, buy_Potion_NightVision_Lv1);
		tradeInv.setItem(1, buy_Potion_NightVision_Lv2);
		tradeInv.setItem(2, buy_Potion_Speed_Lv1);
		tradeInv.setItem(3, buy_Potion_Speed_Lv2);
		tradeInv.setItem(4, buy_Potion_Speed_Lv3);
		tradeInv.setItem(5, buy_Potion_Invisibility_Lv1);
		tradeInv.setItem(6, buy_Potion_Invisibility_Lv2);
		
		return tradeInv;
	}
	
//==================================================================================================================================

	public static ItemStack makeOfferItem(ItemStack item, int price, Boolean buying) {
		
		ItemStack stack = item;
		ItemMeta stackMeta = item.getItemMeta();
		
		if(buying.equals(false)) {
		
			if(price == 1) {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.RED + "Buy for: " + price + " coin");
				stackMeta.setLore(loreText);
			}
			
			else if(price > 1) {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.RED + "Buy for: " + price + " coins");
				stackMeta.setLore(loreText);
			}
			
			else {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.RED + "Buy for: ERROR");
				stackMeta.setLore(loreText);
			}
		}
		
		else if(buying.equals(true)) {
		
			if(price == 1) {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.GREEN + "Sell for: " + price + " coin");
				stackMeta.setLore(loreText);
			}
			
			else if(price > 1) {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.GREEN + "Sell for: " + price + " coins");
				stackMeta.setLore(loreText);
			}
			
			else {
				
				//Sets item lore
				ArrayList<String> loreText = (ArrayList<String>) stackMeta.getLore();
				loreText.add(ChatColor.GREEN + "Sell for: ERROR");
				stackMeta.setLore(loreText);
			}
		}

		stack.setItemMeta(stackMeta);
		
		return stack;
	}
	
//==================================================================================================================================

}
