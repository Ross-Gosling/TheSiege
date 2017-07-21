//==================================================================================================================================

package itemHandling;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import testModeSystem.TestMode;

public class MakeItemStack {
	
//==================================================================================================================================
	
	public static ItemStack stick(int number) {
		
		ItemStack stack = new ItemStack(Material.STICK, number);
		ItemMeta stackMeta = stack.getItemMeta();
		
		stackMeta.setDisplayName(ChatColor.BLUE + "Stick");
		
		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack log(int number) {
		
		ItemStack stack = new ItemStack(Material.LOG, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Log");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft sticks");
		loreText.add(ChatColor.GOLD + "Can be sold to traders");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack string(int number) {
		
		ItemStack stack = new ItemStack(Material.STRING, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "String");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack animalHide(int number) {
		
		ItemStack stack = new ItemStack(Material.LEATHER, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Animal Hide");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack rawMeat(int number) {
		
		ItemStack stack = new ItemStack(Material.RAW_BEEF, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Raw Meat");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Cooked to produce");
		loreText.add(ChatColor.YELLOW + "grilled meat");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack rawHaddock(int number) {
		
		ItemStack stack = new ItemStack(Material.RAW_FISH, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Raw Haddock");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Cooked to produce");
		loreText.add(ChatColor.YELLOW + "fried haddock");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack rawSalmon(int number) {
		
		ItemStack stack = new ItemStack(Material.RAW_FISH, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Raw Salmon");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stack.setDurability((short) 1);

		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Cooked to produce");
		loreText.add(ChatColor.YELLOW + "fried salmon");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================	
	
	public static ItemStack coal(int number) {
		
		ItemStack stack = new ItemStack(Material.COAL, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Coal");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to fuel furnaces");
		loreText.add(ChatColor.GOLD + "Can be sold to traders");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack ironOre(int number) {
		
		ItemStack stack = new ItemStack(Material.IRON_ORE, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Iron Ore");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Smelted to produce");
		loreText.add(ChatColor.YELLOW + "standard ingots");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack goldOre(int number) {
		
		ItemStack stack = new ItemStack(Material.GOLD_ORE, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Gold Ore");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Smelted to produce");
		loreText.add(ChatColor.YELLOW + "gold ingots");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack diamondOre(int number) {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_ORE, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Diamond Ore");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Smelted to produce");
		loreText.add(ChatColor.YELLOW + "diamonds");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
	
	public static ItemStack rustyIngot(int number) {
		
		ItemStack stack = new ItemStack(Material.CLAY_BRICK, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Rusty Ingot");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldIngot(int number) {
		
		ItemStack stack = new ItemStack(Material.GOLD_INGOT, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Gold Ingot");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		loreText.add(ChatColor.YELLOW + "and armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack standardIngot(int number) {
		
		ItemStack stack = new ItemStack(Material.IRON_INGOT, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Standard Ingot");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		loreText.add(ChatColor.YELLOW + "and armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamond(int number) {
		
		ItemStack stack = new ItemStack(Material.DIAMOND, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.BLUE + "Diamond");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to craft tools");
		loreText.add(ChatColor.YELLOW + "and armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
	
	public static ItemStack biscuit(int number) {
		
		ItemStack stack = new ItemStack(Material.COOKIE, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Biscuit");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 1 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack bread(int number) {
		
		ItemStack stack = new ItemStack(Material.BREAD, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Bread");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 2.5 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack bakedPotato(int number) {
		
		ItemStack stack = new ItemStack(Material.BAKED_POTATO, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Baked Potato");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 3 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack grilledMeat(int number) {
	
		ItemStack stack = new ItemStack(Material.COOKED_BEEF, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Grilled Meat");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 4 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack friedHaddock(int number) {
		
		ItemStack stack = new ItemStack(Material.COOKED_FISH, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Fried Haddock");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 2.5 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack friedSalmon(int number) {
		
		ItemStack stack = new ItemStack(Material.COOKED_FISH, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Fried Salmon");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stack.setDurability((short) 1);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Provides 3 hunger");
		loreText.add(ChatColor.YELLOW + "replenishment");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
		
	public static ItemStack flare(int number, String faction, Color colour) {
		
		ItemStack stack = new ItemStack(Material.FIREWORK, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + faction + " Flare");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to grab nearby");
		loreText.add(ChatColor.YELLOW + "players' attention");
		stackMeta.setLore(loreText);
		
		FireworkMeta stackMeta_FW = (FireworkMeta) stackMeta;
		
		Builder stack_FW = FireworkEffect.builder();
		stack_FW.with(Type.BURST);
		stack_FW.withColor(colour);
		stack_FW.withFade(colour);
		stack_FW.withTrail();
		stack_FW.withFlicker();
		stackMeta_FW.addEffect(stack_FW.build());
		
		stackMeta_FW.setPower(2);
		
		stack.setItemMeta(stackMeta_FW);
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
		
//==================================================================================================================================
	
	public static ItemStack nightVisionPotion() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.WATER_BREATHING).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.WATER_BREATHING);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, (int) 2400, (int) 0, true), false);
		
		//Applies meta
		stack.setItemMeta(potionMeta);
		
		//Sets item name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Night Vision Potion Lvl:1");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(" ");
		loreText.add(" ");
		loreText.add(ChatColor.DARK_PURPLE + "When Applied:");
		loreText.add(ChatColor.BLUE + "+Night Vision");
		loreText.add(ChatColor.BLUE + "Player emits faint particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for perfect sight");
		loreText.add(ChatColor.YELLOW + "in the dark");
		stackMeta.setLore(loreText);

		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack nightVisionPotion2() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.WATER_BREATHING).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.WATER_BREATHING);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, (int) 12000, (int) 0, false), false);
		
		//Applies meta
		stack.setItemMeta(potionMeta);
		
		//Sets item name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Night Vision Potion Lvl:2");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(" ");
		loreText.add(" ");
		loreText.add(ChatColor.DARK_PURPLE + "When Applied:");
		loreText.add(ChatColor.BLUE + "+Night Vision");
		loreText.add(ChatColor.RED + "Player emits visible particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for perfect sight");
		loreText.add(ChatColor.YELLOW + "in the dark");
		stackMeta.setLore(loreText);

		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}

	public static ItemStack speedPotion() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.INSTANT_HEAL).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.HEAL);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, (int) 1200, (int) 1, false), false);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) 1200, (int) 1, false), false);
		
		//Applies meta
		stack.setItemMeta(potionMeta);
		
		//Sets display name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Potion Lvl:1");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.RED + "Player emits visible particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for a speed boost");
		stackMeta.setLore(loreText);
		
		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack speedPotion2() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.INSTANT_HEAL).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.HEAL);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, (int) 2400, (int) 1, false), false);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) 2400, (int) 2, false), false);
		
		//Applies meta
		stack.setItemMeta(potionMeta);
		
		//Sets display name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Potion Lvl:2");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.RED + "Player emits visible particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for a speed boost");
		stackMeta.setLore(loreText);
		
		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack speedPotion3() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.INSTANT_HEAL).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.HEAL);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, (int) 3600, (int) 1, false), false);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) 3600, (int) 3, false), false);
		
		//Applies meta
		stack.setItemMeta(potionMeta);
		
		//Sets display name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Potion Lvl:3");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.RED + "Player emits visible particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for a speed boost");
		stackMeta.setLore(loreText);
		
		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack invisibilityPotion() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.INVISIBILITY).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.INVISIBILITY);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) 600, (int) 0, false), false);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) 600, (int) 3, false), false);
				
		//Applies meta
		stack.setItemMeta(potionMeta);
				
		//Sets display name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Invisibility Potion Lvl:1");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.RED + "Player emits visible particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for a brief");
		loreText.add(ChatColor.YELLOW + "period of invisibility");
		stackMeta.setLore(loreText);

		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack invisibilityPotion2() {
		
		//Makes the item look a certain colour
		ItemStack stack = new Potion(PotionType.INVISIBILITY).toItemStack(1);
		PotionMeta potionMeta = (PotionMeta) stack.getItemMeta();
		
		//Removes original effect
		potionMeta.removeCustomEffect(PotionEffectType.INVISIBILITY);
		
		//Sets effects
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, (int) 600, (int) 0, true), false);
		potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, (int) 600, (int) 3, true), false);
				
		//Applies meta
		stack.setItemMeta(potionMeta);
				
		//Sets display name
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Invisibility Potion Lvl:2");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		//Sets item lore
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.BLUE + "Player emits faint particles");
		loreText.add(" ");
		loreText.add(ChatColor.YELLOW + "Consumed for a brief");
		loreText.add(ChatColor.YELLOW + "period of invisibility");
		stackMeta.setLore(loreText);

		//Applies meta
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
	
	public static ItemStack arrow(int number) {
		
		ItemStack stack = new ItemStack(Material.ARROW, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Arrow");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Ammunition");
		loreText.add(ChatColor.YELLOW + "for bows");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack flimsyBow() {
		
		ItemStack stack = new ItemStack(Material.BOW, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Flimsy Bow");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality bow");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack standardBow() {
		
		ItemStack stack = new ItemStack(Material.BOW, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Standard Bow");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality bow");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack fishingRod() {
		
		ItemStack stack = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Fishing Rod");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Allows you to");
		loreText.add(ChatColor.YELLOW + "catch fish");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
	
	public static ItemStack rustyPick() {
		
		ItemStack stack = new ItemStack(Material.WOOD_PICKAXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Rusty Pickaxe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality pickaxe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack rustyAxe() {
		
		ItemStack stack = new ItemStack(Material.WOOD_AXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Rusty Axe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality axe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack rustySword() {
		
		ItemStack stack = new ItemStack(Material.WOOD_SWORD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Rusty Sword");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality sword");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack dulledPick() {
		
		ItemStack stack = new ItemStack(Material.STONE_PICKAXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Dulled Pickaxe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Medium quality pickaxe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
	public static ItemStack dulledAxe() {
		
		ItemStack stack = new ItemStack(Material.STONE_AXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Dulled Axe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Medium quality axe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack dulledSword() {
		
		ItemStack stack = new ItemStack(Material.STONE_SWORD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Dulled Sword");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Medium quality sword");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================

	public static ItemStack standardPick() {
		
		ItemStack stack = new ItemStack(Material.IRON_PICKAXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Standard Pickaxe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality pickaxe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack standardAxe() {
		
		ItemStack stack = new ItemStack(Material.IRON_AXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Standard Axe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality axe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack standardSword() {
		
		ItemStack stack = new ItemStack(Material.IRON_SWORD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Standard Sword");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality sword");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
				
	}
	
//==================================================================================================================================

	public static ItemStack goldPick() {
		
		ItemStack stack = new ItemStack(Material.GOLD_PICKAXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Gold Pickaxe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality pickaxe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldAxe() {
		
		ItemStack stack = new ItemStack(Material.GOLD_AXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Gold Axe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality axe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldSword() {
		
		ItemStack stack = new ItemStack(Material.GOLD_SWORD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Gold Sword");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality sword");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
				
	}
	
//==================================================================================================================================
		
	public static ItemStack diamondPick() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_PICKAXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Diamond Pickaxe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality pickaxe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamondAxe() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_AXE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Diamond Axe");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality axe");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamondSword() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Diamond Sword");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality sword");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack compass(int number, String locationName) {
		
		ItemStack stack = new ItemStack(Material.COMPASS, number);
		ItemMeta stackMeta = stack.getItemMeta();
			
		stackMeta.setDisplayName(ChatColor.GREEN + "Compass (" + locationName + ")");
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Points to a selected waypoint");
		loreText.add(ChatColor.YELLOW + "Click to change target");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack map(int number, String faction, int mapID) {
		
		ItemStack stack = new ItemStack(Material.MAP, number, (byte) mapID);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + faction + " Map");
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Assists in navigation");
		loreText.add(ChatColor.YELLOW + "Keeps track of all teammates");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
	
	}
	
//==================================================================================================================================
	
	public static ItemStack ironHorseArmour() {
		
		ItemStack stack = new ItemStack(Material.IRON_BARDING, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Iron Horse Armour");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality horse armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldHorseArmour() {
		
		ItemStack stack = new ItemStack(Material.GOLD_BARDING, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Gold Horse Armour");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality horse armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamondHorseArmour() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_BARDING, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Diamond Horse Armour");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality horse armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}

//==================================================================================================================================
		
	public static ItemStack saddle_Basic() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Basic Cavalry");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Basic Cavalry");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Scout() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Scout Cavalry");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Scout Cavalry");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Light() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Light Cavalry");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Light Cavalry");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Ross() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Sasquatch");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Sasquatch");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Lewis() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Madonna");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Madonna");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Alex() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Orion");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Orion");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack saddle_Curtis() {
		
		ItemStack stack = new ItemStack(Material.SADDLE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GREEN + "Bones");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to summon Bones");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack leatherChestplate() {
		
		ItemStack stack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Leather Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack leatherBoots() {
		
		ItemStack stack = new ItemStack(Material.LEATHER_BOOTS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Leather Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);

		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Low quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================

	public static ItemStack ironChestplate() {
		
		ItemStack stack = new ItemStack(Material.IRON_CHESTPLATE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Iron Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack ironLeggings() {
		
		ItemStack stack = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Iron Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack ironBoots() {
		
		ItemStack stack = new ItemStack(Material.IRON_BOOTS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Iron Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack goldChestplate() {
		
		ItemStack stack = new ItemStack(Material.GOLD_CHESTPLATE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Gold Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldLeggings() {
		
		ItemStack stack = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Gold Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack goldBoots() {
		
		ItemStack stack = new ItemStack(Material.GOLD_BOOTS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Gold Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "High quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
		
	public static ItemStack diamondChestplate() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Diamond Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamondLeggings() {
		
		ItemStack stack = new ItemStack(Material.IRON_LEGGINGS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Diamond Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
	public static ItemStack diamondBoots() {
		
		ItemStack stack = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.AQUA + "Diamond Armour Set");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		stackMeta = InventoryFunctions.hideFlags(stackMeta);
		
		stackMeta.spigot().setUnbreakable(true);
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Highest quality armour");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
	
//==================================================================================================================================
	
	public static ItemStack goldCoin(int number) {
		
		ItemStack stack = new ItemStack(Material.GOLD_NUGGET, number);
		ItemMeta stackMeta = stack.getItemMeta();
		stackMeta.setDisplayName(ChatColor.GOLD + "Gold Coin");

		if(TestMode.testModeActive) { TestMode.setItemMeta(stackMeta); }
		
		ArrayList<String> loreText = new ArrayList<String>();
		loreText.add(ChatColor.YELLOW + "Used to buy goods");
		stackMeta.setLore(loreText);
		
		stack.setItemMeta(stackMeta);
		
		return stack;
		
	}
		
//==================================================================================================================================
	
}
