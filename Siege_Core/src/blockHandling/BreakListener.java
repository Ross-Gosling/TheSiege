//==================================================================================================================================

package blockHandling;

import itemHandling.InventoryFunctions;
import itemHandling.MakeItemStack;
import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BreakListener implements Listener {
	
//==================================================================================================================================

	//onBlockBreak event
	
//==================================================================================================================================
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		
		final Block block = event.getBlock();
		Material blockID = block.getType();
		Player player = event.getPlayer();
		
		event.setExpToDrop(0);
		
		if(player.hasPermission("GroupNode.InBuildMode")) {
			
		}
		        	
		else if(blockID == Material.COAL_ORE) {
    	
        	ItemStack coal = MakeItemStack.coal(1);
        	
			if(InventoryFunctions.canMerge(coal, player.getInventory()) == true) {
				
				player.getInventory().addItem(coal);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				
			}
			
			else {
        	
            	Location pLocation = player.getLocation();
            	pLocation.setY(pLocation.getY()+1);
            	World world = block.getWorld();
        	
            	world.dropItem(pLocation, coal);
            	
			}
			
			Main.awaitingRespawn_Coal.add(block);
			
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.STONE);;
	        		
	        	}
		    }, 1L);
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.COAL_ORE);;
	        		Main.awaitingRespawn_Coal.remove(block);
	        	}
		    }, (Main.fetchConfig().getInt("OreRespawn.Coal")*20));
            
        }
        
        else if(blockID == Material.IRON_ORE) {
    	     
        	ItemStack ironOre = MakeItemStack.ironOre(1);
        	
			if(InventoryFunctions.canMerge(ironOre, player.getInventory()) == true) {
				
				player.getInventory().addItem(ironOre);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				
			}
			
			else {
        	
            	Location pLocation = player.getLocation();
            	pLocation.setY(pLocation.getY()+1);
            	World world = block.getWorld();
              	
            	world.dropItem(pLocation, ironOre);
            	
			}
			
			Main.awaitingRespawn_Iron.add(block);
          
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.STONE);;
	        		
	        	}
		    }, 1L);
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.IRON_ORE);;
	        		Main.awaitingRespawn_Iron.remove(block);
	        	}
		    }, (Main.fetchConfig().getInt("OreRespawn.Iron")*20));
            		
        }
		
        else if(blockID == Material.GOLD_ORE) {
   	     
        	ItemStack goldOre = MakeItemStack.goldOre(1);
        	
			if(InventoryFunctions.canMerge(goldOre, player.getInventory()) == true) {
				
				player.getInventory().addItem(goldOre);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				
			}
			
			else {
        	
            	Location pLocation = player.getLocation();
            	pLocation.setY(pLocation.getY()+1);
            	World world = block.getWorld();
              	
            	world.dropItem(pLocation, goldOre);
            	
			}
			
			Main.awaitingRespawn_Gold.add(block);
          
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.STONE);;
	        		
	        	}
		    }, 1L);
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.GOLD_ORE);;
	        		Main.awaitingRespawn_Gold.remove(block);
	        	}
		    }, (Main.fetchConfig().getInt("OreRespawn.Gold")*20));
            		
        }
        
        else if(blockID == Material.DIAMOND_ORE) {
    	
        	ItemStack diamondOre = MakeItemStack.diamondOre(1);
        	
			if(InventoryFunctions.canMerge(diamondOre, player.getInventory()) == true) {
				
				player.getInventory().addItem(diamondOre);
				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
				
			}
			
			else {
        	
            	Location pLocation = player.getLocation();
            	pLocation.setY(pLocation.getY()+1);
        		World world = block.getWorld();
        	
        		world.dropItem(pLocation, diamondOre);
        		
			}
			
			Main.awaitingRespawn_Diamond.add(block);
        	
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.STONE);;
	        		
	        	}
		    }, 1L);
	        
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.fetchPlugin(), new Runnable() {
	        	public void run() {
	        		
	        		block.setType(Material.DIAMOND_ORE);;
	        		Main.awaitingRespawn_Diamond.remove(block);
	        	}
		    }, (Main.fetchConfig().getInt("OreRespawn.Diamond")*20));
                   
        }
        
        else if(blockID == Material.LOG) {
        	
        	Block regionBlock = block.getLocation().getWorld().getBlockAt((int)block.getLocation().getX(), (int)0, (int)block.getLocation().getZ());
        	
        	if(regionBlock.getType().equals(Material.STAINED_CLAY)) {
        		
    			if((regionBlock.getData() == (byte)4) && (block.getLocation().getY() < 100)) {
    				
    				// Do Nothing
    			}
    			
    			else {
    				
    				event.setCancelled(true);
    			}
        	}
        	
        	else {
        	
	        	Location location = block.getLocation();
	        	
	            Location belowLocation = block.getLocation();
	            belowLocation = checkLog(belowLocation, -1);
	            
	            while(belowLocation.getBlock().getType().equals(Material.LOG)) {
	            	
	            	belowLocation = checkLog(belowLocation, -1);
	            }
	            
	            Material belowMaterial = belowLocation.getBlock().getType();
	            
	            if((belowMaterial.equals(Material.GRASS)) || (belowMaterial.equals(Material.DIRT))) {
	     	
		            Location dirtLocation = block.getLocation();
		            dirtLocation.setY(dirtLocation.getY()-1);
		            
		            Location aboveLocation = block.getLocation().add(0, 1, 0);
		            
		            if(((dirtLocation.getBlock().getType() == Material.DIRT) || (dirtLocation.getBlock().getType() == Material.GRASS)) && (aboveLocation.getBlock().getType() == Material.AIR)) {
		            	
		            	World world = block.getWorld();
		            	world.spawnFallingBlock(location, (int) 6, (byte) block.getData());
		            }
	            	            	
	                while(aboveLocation.getBlock().getType().equals(Material.LOG)) {
	                	
	                	aboveLocation.getBlock().setType(Material.AIR);
	                	aboveLocation.getWorld().spawnFallingBlock(aboveLocation, Material.LOG, block.getData());
	                	
	                	aboveLocation = checkLog(aboveLocation, +1);
	                	
	                }
	                                  	
	            	ItemStack log = MakeItemStack.log(1);
	            	
	    			if(InventoryFunctions.canMerge(log, player.getInventory()) == true) {
	    				
	    				player.getInventory().addItem(log);
	    				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
	    				
	    			}
	    			
	    			else {
	                	
	    	        	Location pLocation = player.getLocation();
	    	        	pLocation.setY(pLocation.getY()+1);
	    	        	World world = block.getWorld();
	    	        	        	
	    	            world.dropItem(pLocation, log);
	    	            
	    			}    
		                
	            }
	            
	            else {
	            	
	            	event.setCancelled(true);
	            	
	            }
        	}
        }
		
        else if(blockID == Material.LEAVES) {
        	        
        	Block regionBlock = block.getLocation().getWorld().getBlockAt((int)block.getLocation().getX(), (int)0, (int)block.getLocation().getZ());
        	
        	if(regionBlock.getType().equals(Material.STAINED_CLAY)) {
        		
    			if((regionBlock.getData() == (byte)4) && (block.getLocation().getY() < 100)) {
    				// Do Nothing
    			}
    			
    			else {
    				event.setCancelled(true);
    			}
        	}
        	
        	else {
        	
				int random = 0;
				
				random = (int) (Math.random() * 100);
				if (random < 20) { // 0-19
	    		
	            	ItemStack stick = MakeItemStack.stick(1);
	            	
	    			if(InventoryFunctions.canMerge(stick, player.getInventory()) == true) {
	    				
	    				player.getInventory().addItem(stick);
	    				player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
	    				
	    			}
	    			
	    			else {
	            	
		            	Location pLocation = player.getLocation();
		            	pLocation.setY(pLocation.getY()+1);
		            	World world = block.getWorld();
		        	
		            	world.dropItem(pLocation, stick);
		            	
	    			}
	        	
	            }
				
        	}
            	
        }
    	
        else {
   
        	event.setCancelled(true);
        
        }
		
		player.updateInventory();
        
	}
	
//==================================================================================================================================

	public Location checkLog(Location checkLocation, int changeY) {
		
		checkLocation.setY(checkLocation.getY()+changeY);
		
		return checkLocation;
		
	}
	
//==================================================================================================================================

}
