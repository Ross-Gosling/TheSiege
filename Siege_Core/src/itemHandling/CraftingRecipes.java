//==================================================================================================================================

package itemHandling;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CraftingRecipes {

	@SuppressWarnings("deprecation")
	public static void createRecipes() {
	
		//Removes all recipes from the server
		Bukkit.getServer().clearRecipes();
		
//==================================================================================================================================

	//Creates Recipes
			
//==================================================================================================================================

		//Creates a recipe for sticks
		ShapelessRecipe stickRecipe = new ShapelessRecipe(new ItemStack(MakeItemStack.stick(4)));
		stickRecipe.addIngredient(1, Material.LOG);
				
		//Creates a recipe for 4 arrows
		ShapedRecipe arrow4Recipe = new ShapedRecipe(new ItemStack(MakeItemStack.arrow(4)));
		arrow4Recipe.shape("IA","SA");
		arrow4Recipe.setIngredient('I', Material.CLAY_BRICK);
		arrow4Recipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for 16 arrows
		ShapedRecipe arrow16Recipe = new ShapedRecipe(new ItemStack(MakeItemStack.arrow(16)));
		arrow16Recipe.shape("IA","SA");
		arrow16Recipe.setIngredient('I', Material.IRON_INGOT);
		arrow16Recipe.setIngredient('S', Material.STICK);

		//Creates a recipe for flimsy bows
		ShapedRecipe flimsyBowRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.flimsyBow()));
		flimsyBowRecipe.shape("ASF", "IAS", "ASF");
		flimsyBowRecipe.setIngredient('I', Material.CLAY_BRICK);
		flimsyBowRecipe.setIngredient('S', Material.STICK);
		flimsyBowRecipe.setIngredient('F', Material.STRING);
		
		//Creates a recipe for standard bows
		ShapedRecipe standardBowRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.standardBow()));
		standardBowRecipe.shape("ASF", "IAS", "ASF");
		standardBowRecipe.setIngredient('I', Material.IRON_INGOT);
		standardBowRecipe.setIngredient('S', Material.STICK);
		standardBowRecipe.setIngredient('F', Material.STRING);
		
		//Creates a recipe for flimsy bows
		ShapedRecipe fishingRodRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.fishingRod()));
		fishingRodRecipe.shape("AAI", "AIS", "IAS");
		fishingRodRecipe.setIngredient('I', Material.STICK);
		fishingRodRecipe.setIngredient('S', Material.STRING);
		
		//Creates a recipe for rusty picks
		ShapedRecipe woodPickRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.rustyPick()));
		woodPickRecipe.shape("III", "ASA", "ASA");
		woodPickRecipe.setIngredient('I', Material.CLAY_BRICK);
		woodPickRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for rusty axes
		ShapedRecipe woodAxeRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.rustyAxe()));
		woodAxeRecipe.shape("IIA", "ISA", "ASA");
		woodAxeRecipe.setIngredient('I', Material.CLAY_BRICK);
		woodAxeRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for rusty swords
		ShapedRecipe woodSwordRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.rustySword()));
		woodSwordRecipe.shape("AIA", "AIA", "ASA");
		woodSwordRecipe.setIngredient('I', Material.CLAY_BRICK);
		woodSwordRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for iron picks
		ShapedRecipe ironPickRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.standardPick()));
		ironPickRecipe.shape("III", "ASA", "ASA");
		ironPickRecipe.setIngredient('I', Material.IRON_INGOT);
		ironPickRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for iron axes
		ShapedRecipe ironAxeRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.standardAxe()));
		ironAxeRecipe.shape("IIA", "ISA", "ASA");
		ironAxeRecipe.setIngredient('I', Material.IRON_INGOT);
		ironAxeRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for iron swords
		ShapedRecipe ironSwordRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.standardSword()));
		ironSwordRecipe.shape("AIA", "AIA", "ASA");
		ironSwordRecipe.setIngredient('I', Material.IRON_INGOT);
		ironSwordRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for iron armour
		ShapedRecipe ironArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.ironChestplate()));
		ironArmourRecipe.shape("III", "IFI", "III");
		ironArmourRecipe.setIngredient('I', Material.IRON_INGOT);
		ironArmourRecipe.setIngredient('F', Material.LEATHER);
		
		//Creates a recipe for gold picks
		ShapedRecipe goldPickRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.goldPick()));
		goldPickRecipe.shape("III", "ASA", "ASA");
		goldPickRecipe.setIngredient('I', Material.GOLD_INGOT);
		goldPickRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for gold axes
		ShapedRecipe goldAxeRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.goldAxe()));
		goldAxeRecipe.shape("IIA", "ISA", "ASA");
		goldAxeRecipe.setIngredient('I', Material.GOLD_INGOT);
		goldAxeRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for gold swords
		ShapedRecipe goldSwordRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.goldSword()));
		goldSwordRecipe.shape("AIA", "AIA", "ASA");
		goldSwordRecipe.setIngredient('I', Material.GOLD_INGOT);
		goldSwordRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for gold armour
		ShapedRecipe goldArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.goldChestplate()));
		goldArmourRecipe.shape("III", "IFI", "III");
		goldArmourRecipe.setIngredient('I', Material.GOLD_INGOT);
		goldArmourRecipe.setIngredient('F', Material.LEATHER);
		
		//Creates a recipe for diamond picks
		ShapedRecipe diamondPickRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.diamondPick()));
		diamondPickRecipe.shape("III", "ASA", "ASA");
		diamondPickRecipe.setIngredient('I', Material.DIAMOND);
		diamondPickRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for diamond axes
		ShapedRecipe diamondAxeRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.diamondAxe()));
		diamondAxeRecipe.shape("IIA", "ISA", "ASA");
		diamondAxeRecipe.setIngredient('I', Material.DIAMOND);
		diamondAxeRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for diamond swords
		ShapedRecipe diamondSwordRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.diamondSword()));
		diamondSwordRecipe.shape("AIA", "AIA", "ASA");
		diamondSwordRecipe.setIngredient('I', Material.DIAMOND);
		diamondSwordRecipe.setIngredient('S', Material.STICK);
		
		//Creates a recipe for diamond armour
		ShapedRecipe diamondArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.diamondChestplate()));
		diamondArmourRecipe.shape("III", "IFI", "III");
		diamondArmourRecipe.setIngredient('I', Material.DIAMOND);
		diamondArmourRecipe.setIngredient('F', Material.IRON_INGOT);
		
		//Creates a recipe for leather armour
		ShapedRecipe leatherArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.leatherChestplate()));
		leatherArmourRecipe.shape("III", "IAI", "III");
		leatherArmourRecipe.setIngredient('I', Material.LEATHER);
		
		//Creates a recipe for iron horse armour
		ShapedRecipe ironHorseArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.ironHorseArmour()));
		ironHorseArmourRecipe.shape("IAA", "AII", "AFA");
		ironHorseArmourRecipe.setIngredient('I', Material.IRON_INGOT);
		ironHorseArmourRecipe.setIngredient('F', Material.LEATHER);
		
		//Creates a recipe for gold horse armour
		ShapedRecipe goldHorseArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.goldHorseArmour()));
		goldHorseArmourRecipe.shape("IAA", "AII", "AFA");
		goldHorseArmourRecipe.setIngredient('I', Material.GOLD_INGOT);
		goldHorseArmourRecipe.setIngredient('F', Material.LEATHER);
		
		//Creates a recipe for diamond horse armour
		ShapedRecipe diamondHorseArmourRecipe = new ShapedRecipe(new ItemStack(MakeItemStack.diamondHorseArmour()));
		diamondHorseArmourRecipe.shape("IAA", "AII", "AFA");
		diamondHorseArmourRecipe.setIngredient('I', Material.DIAMOND);
		diamondHorseArmourRecipe.setIngredient('F', Material.LEATHER);
		
//==================================================================================================================================

	//Adds Recipes
			
//==================================================================================================================================

		//Adds the furnace recipes to the server
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.standardIngot(1)), Material.IRON_ORE));
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.goldIngot(1)), Material.GOLD_ORE));
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.diamond(1)), Material.DIAMOND_ORE));
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.grilledMeat(1)), Material.RAW_BEEF));
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.friedHaddock(1)), Material.RAW_FISH, 0));
		Bukkit.getServer().addRecipe(new FurnaceRecipe(new ItemStack(MakeItemStack.friedSalmon(1)), Material.RAW_FISH, 1));
		
		//Adds the stick recipe to the server
		Bukkit.getServer().addRecipe(stickRecipe);
		
		//Adds the arrow recipes to the server
		Bukkit.getServer().addRecipe(arrow4Recipe);
		Bukkit.getServer().addRecipe(arrow16Recipe);
		
		//Adds the bow recipes to the server
		Bukkit.getServer().addRecipe(flimsyBowRecipe);
		Bukkit.getServer().addRecipe(standardBowRecipe);
		
		//Adds the fishing rod recipe to the server
		Bukkit.getServer().addRecipe(fishingRodRecipe);
		
		//Adds the wood tool recipes to the server
		Bukkit.getServer().addRecipe(woodPickRecipe);
		Bukkit.getServer().addRecipe(woodAxeRecipe);
		Bukkit.getServer().addRecipe(woodSwordRecipe);
		
		//Adds the iron tool recipes to the server
		Bukkit.getServer().addRecipe(ironPickRecipe);
		Bukkit.getServer().addRecipe(ironAxeRecipe);
		Bukkit.getServer().addRecipe(ironSwordRecipe);
		
		//Adds the gold tool recipes to the server
		Bukkit.getServer().addRecipe(goldPickRecipe);
		Bukkit.getServer().addRecipe(goldAxeRecipe);
		Bukkit.getServer().addRecipe(goldSwordRecipe);

		//Adds the diamond tool recipes to the server
		Bukkit.getServer().addRecipe(diamondPickRecipe);
		Bukkit.getServer().addRecipe(diamondAxeRecipe);
		Bukkit.getServer().addRecipe(diamondSwordRecipe);

		//Adds the leather armour recipes to the server
		Bukkit.getServer().addRecipe(leatherArmourRecipe);
		
		//Adds the iron armour recipes to the server
		Bukkit.getServer().addRecipe(ironArmourRecipe);
		Bukkit.getServer().addRecipe(ironHorseArmourRecipe);
		
		//Adds the gold armour recipes to the server
		Bukkit.getServer().addRecipe(goldArmourRecipe);
		Bukkit.getServer().addRecipe(goldHorseArmourRecipe);
		
		//Adds the diamond armour recipes to the server
		Bukkit.getServer().addRecipe(diamondArmourRecipe);
		Bukkit.getServer().addRecipe(diamondHorseArmourRecipe);
		
	}
	
//==================================================================================================================================
	
}
