//==================================================================================================================================
	
package listeners;

import functions.Processes;
import functions.TradeOffers;
import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Shops.Main;

import org.bukkit.Color;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InteractShopListener implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {

//==================================================================================================================================
		
		// If player is in a shop menu
		// ARMOUR SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.armourShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
			
			if(clickedItem.equals(TradeOffers.buy_LeatherChestplate)) {
				Processes.processPurchase(player, MakeItemStack.leatherChestplate(), Main.value_buy_LeatherChestplate);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_IronChestplate)) {
				Processes.processPurchase(player, MakeItemStack.ironChestplate(), Main.value_buy_IronChestplate);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// SWORD SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.swordShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_RustySword)) {
				Processes.processPurchase(player, MakeItemStack.rustySword(), Main.value_buy_RustySword);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_DulledSword)) {
				Processes.processPurchase(player, MakeItemStack.dulledSword(), Main.value_buy_DulledSword);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_StandardSword)) {
				Processes.processPurchase(player, MakeItemStack.standardSword(), Main.value_buy_StandardSword);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// PICKAXE SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.pickShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_RustyPickaxe)) {
				Processes.processPurchase(player, MakeItemStack.rustyPick(), Main.value_buy_RustyPickaxe);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_DulledPickaxe)) {
				Processes.processPurchase(player, MakeItemStack.dulledPick(), Main.value_buy_DulledPickaxe);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_StandardPickaxe)) {
				Processes.processPurchase(player, MakeItemStack.standardPick(), Main.value_buy_StandardPickaxe);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// AXE SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.axeShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_RustyAxe)) {
				Processes.processPurchase(player, MakeItemStack.rustyAxe(), Main.value_buy_RustyAxe);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_DulledAxe)) {
				Processes.processPurchase(player, MakeItemStack.dulledAxe(), Main.value_buy_DulledAxe);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_StandardAxe)) {
				Processes.processPurchase(player, MakeItemStack.standardAxe(), Main.value_buy_StandardAxe);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// BOW SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.bowShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_FlimsyBow)) {
				Processes.processPurchase(player, MakeItemStack.flimsyBow(), Main.value_buy_FlimsyBow);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_StandardBow)) {
				Processes.processPurchase(player, MakeItemStack.standardBow(), Main.value_buy_StandardBow);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Arrow_1)) {
				Processes.processPurchase(player, MakeItemStack.arrow(Main.amount_buy_Arrow1), Main.value_buy_Arrow1);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Arrow_2)) {
				Processes.processPurchase(player, MakeItemStack.arrow(Main.amount_buy_Arrow2), Main.value_buy_Arrow2);
			}
			else if(clickedItem.equals(TradeOffers.buy_Arrow_3)) {
				Processes.processPurchase(player, MakeItemStack.arrow(Main.amount_buy_Arrow3), Main.value_buy_Arrow3);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// EQUIPMENT SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.equipmentShop((Player) event.getWhoClicked()).getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_Flare_Emberstone)) {
				Processes.processPurchase(player, MakeItemStack.flare(Main.amount_buy_Flare, "Emberstone", Color.RED), Main.value_buy_Flare);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Flare_Mykonos)) {
				Processes.processPurchase(player, MakeItemStack.flare(Main.amount_buy_Flare, "Mykonos", Color.PURPLE), Main.value_buy_Flare);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Flare_Summerhold)) {
				Processes.processPurchase(player, MakeItemStack.flare(Main.amount_buy_Flare, "Summerhold", Color.GREEN), Main.value_buy_Flare);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Flare_Icarus)) {
				Processes.processPurchase(player, MakeItemStack.flare(Main.amount_buy_Flare, "Icarus", Color.AQUA), Main.value_buy_Flare);
			}
						
			player.updateInventory();
		}
		
//==================================================================================================================================
				
		// If player is in a shop menu
		// FOOD SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.foodShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_Biscuit)) {
				Processes.processPurchase(player, MakeItemStack.biscuit(Main.amount_buy_Food), Main.value_buy_Biscuit);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Bread)) {
				Processes.processPurchase(player, MakeItemStack.bread(Main.amount_buy_Food), Main.value_buy_Bread);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Potato)) {
				Processes.processPurchase(player, MakeItemStack.bakedPotato(Main.amount_buy_Food), Main.value_buy_Potato);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Meat)) {
				Processes.processPurchase(player, MakeItemStack.grilledMeat(Main.amount_buy_Food), Main.value_buy_Meat);
			}
						
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// FISH SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.fishShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_Haddock)) {
				Processes.processPurchase(player, MakeItemStack.friedHaddock(Main.amount_buy_Food), Main.value_buy_Haddock);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Salmon)) {
				Processes.processPurchase(player, MakeItemStack.friedSalmon(Main.amount_buy_Food), Main.value_buy_Salmon);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_FishingRod)) {
				Processes.processPurchase(player, MakeItemStack.fishingRod(), Main.value_buy_FishingRod);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// MATERIAL SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.materialsShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
			
			if(clickedItem.equals(TradeOffers.buy_Coal)) {
				Processes.processPurchase(player, MakeItemStack.coal(Main.amount_buy_Coal), Main.value_buy_Coal);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Stick)) {
				Processes.processPurchase(player, MakeItemStack.stick(Main.amount_buy_Stick), Main.value_buy_Stick);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_String)) {
				Processes.processPurchase(player, MakeItemStack.string(Main.amount_buy_String), Main.value_buy_String);
			}
			
			else if(clickedItem.equals(TradeOffers.sell_Coal)) {
				Processes.processSale(player, MakeItemStack.coal(Main.amount_sell_Coal), Main.value_sell_Coal);		
			}
			
			else if(clickedItem.equals(TradeOffers.sell_Log)) {
				Processes.processSale(player, MakeItemStack.log(Main.amount_sell_Log), Main.value_sell_Log);
			}
						
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// HORSE SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.horseShop((Player) event.getWhoClicked()).getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
									
			if(clickedItem.equals(TradeOffers.buy_IronHorseArmour)) {
				Processes.processPurchase(player, MakeItemStack.ironHorseArmour(), Main.value_buy_IronHorseArmour);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Basic)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Basic(), Main.value_buy_Saddle_Basic);		
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Scout)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Scout(), Main.value_buy_Saddle_Scout);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Light)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Light(), Main.value_buy_Saddle_Light);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Ross)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Ross(), Main.value_buy_Saddle_Light);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Lewis)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Lewis(), Main.value_buy_Saddle_Light);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Alex)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Alex(), Main.value_buy_Saddle_Light);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Saddle_Curtis)) {
				Processes.processPurchase(player, MakeItemStack.saddle_Curtis(), Main.value_buy_Saddle_Light);
			}
						
			player.updateInventory();
		}
		
//==================================================================================================================================
		
		// If player is in a shop menu
		// POTION SHOP
		if(event.getInventory().getTitle().equals(TradeOffers.potionShop().getTitle())) {
			
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			ItemStack clickedItem = null;
			
			if(event.getCurrentItem().equals(null)) {}
			else {clickedItem = event.getCurrentItem();}
			
			if(clickedItem.equals(TradeOffers.buy_Potion_NightVision_Lv1)) {
				Processes.processPurchase(player, MakeItemStack.nightVisionPotion(), Main.value_buy_Potion_NightVision_Lv1);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Potion_NightVision_Lv2)) {
				Processes.processPurchase(player, MakeItemStack.nightVisionPotion2(), Main.value_buy_Potion_NightVision_Lv2);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Potion_Speed_Lv1)) {
				Processes.processPurchase(player, MakeItemStack.speedPotion(), Main.value_buy_Potion_Speed_Lv1);
			}
						
			else if(clickedItem.equals(TradeOffers.buy_Potion_Speed_Lv2)) {
				Processes.processPurchase(player, MakeItemStack.speedPotion2(), Main.value_buy_Potion_Speed_Lv2);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Potion_Speed_Lv3)) {
				Processes.processPurchase(player, MakeItemStack.speedPotion3(), Main.value_buy_Potion_Speed_Lv3);
			}
						
			else if(clickedItem.equals(TradeOffers.buy_Potion_Invisibility_Lv1)) {
				Processes.processPurchase(player, MakeItemStack.invisibilityPotion(), Main.value_buy_Potion_Invisibility_Lv1);
			}
			
			else if(clickedItem.equals(TradeOffers.buy_Potion_Invisibility_Lv2)) {
				Processes.processPurchase(player, MakeItemStack.invisibilityPotion2(), Main.value_buy_Potion_Invisibility_Lv2);
			}
			
			player.updateInventory();
		}
		
//==================================================================================================================================
						
	}
}
