package listener;

import java.util.ArrayList;

import itemHandling.MakeItemStack;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathListener implements Listener {
	
//==================================================================================================================================

	//onEntityDeath Event
					
//==================================================================================================================================
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
			
		ArrayList<ItemStack> remove = new ArrayList<>();
		for(ItemStack drop : event.getDrops()) {
			
			if(me.x3DGosling.Siege_InventorySystem.Main.undroppableItems.contains(drop.getType())) {
				remove.add(drop);
			}
			//You cant drop items that dont have a display name
			else if(drop.getItemMeta().hasDisplayName() == false) {
				remove.add(drop);
			}
		}
		for(ItemStack itemStack : remove) { event.getDrops().remove(itemStack); }
		
		LivingEntity victimEntity = event.getEntity();
				
        if(victimEntity instanceof Skeleton) {
			
			Location location = victimEntity.getLocation();
			location.setY(location.getY()+1);
			World world = location.getWorld();

			// Initialises newCatch
			ItemStack mobDrop = null;
			//Creates a random number
			int random = 0; random = (int) (Math.random() * 100);
			// Outcome based on random number
			if (random < 5) { mobDrop = MakeItemStack.goldCoin(1); } // 5% for a coin
			else if (random < 10) { mobDrop = MakeItemStack.goldCoin(2); } // 5% for 2 coins
			else if (random < 15) { mobDrop = MakeItemStack.rustyIngot(1); } // 5% for a rusty ingot
			else if (random < 20) { mobDrop = MakeItemStack.string(1); } // 5% for string
			else if (random < 25) { mobDrop = MakeItemStack.string(2); } // 5% for 2 string
			else { mobDrop = new ItemStack(Material.AIR); } // 75% for nothing
			
			// If entity has item in hand
			if((!victimEntity.getEquipment().getItemInHand().equals(Material.AIR)) || (!victimEntity.getEquipment().getItemInHand().equals(null))) {			
				// 20% chance to also drop the item in hand
				random = 0; random = (int) (Math.random() * 100); if (random < 20) { mobDrop = victimEntity.getEquipment().getItemInHand(); }
			}
			
			world.dropItemNaturally(location, mobDrop);		
		}
		
		else if((victimEntity instanceof Cow) || (victimEntity instanceof Pig) || (victimEntity instanceof Sheep) || (victimEntity instanceof Horse)) {
						
			Location location = victimEntity.getLocation();
			location.setY(location.getY()+1);
			World world = location.getWorld();
			
			world.dropItemNaturally(location, MakeItemStack.animalHide(1));
			world.dropItemNaturally(location, MakeItemStack.rawMeat(1));
			
			int random = 0;
			
			random = (int) (Math.random() * 100);
			if (random < 40) { // 0-39
				world.dropItemNaturally(location, MakeItemStack.animalHide(1));
			}
			
			random = (int) (Math.random() * 100);
			if (random < 20) { // 0-19
				world.dropItemNaturally(location, MakeItemStack.rawMeat(1));
			}
			
			if(victimEntity instanceof Horse) {
				
				Horse horse = (Horse) victimEntity;
				
				horse.eject();
				
				if(horse.getInventory().getArmor() != null) {
					
					world.dropItemNaturally(location, horse.getInventory().getArmor());
				}
			}
		}
	}
	
//==================================================================================================================================
		
}
