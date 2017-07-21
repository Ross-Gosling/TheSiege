package commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;

public class AdminWipe {
	
	private final static int radius = 25;
	
//==================================================================================================================================

	// Execute AdminWipe function
	
//==================================================================================================================================

	@SuppressWarnings("deprecation")
	public static void execute(Block centralBlock) {
		
		centralBlock.getWorld().playEffect(centralBlock.getLocation(), Effect.EXPLOSION, 1);
		centralBlock.getWorld().playSound(centralBlock.getLocation(), Sound.EXPLODE, 1, 1);
		
		List<Block> blocks = new ArrayList<Block>();
        
        for (int x = centralBlock.getX() - radius; x < centralBlock.getX() + radius + 1; x++) {
        	
            for (int y = centralBlock.getY() - radius; y < centralBlock.getY() + radius + 1; y++) {
            	
                for (int z = centralBlock.getZ() - radius; z < centralBlock.getZ() + radius + 1; z++) {
                	
                    blocks.add(centralBlock.getWorld().getBlockAt(x,y,z));
                }
            }
        }
        
        // Creates a list of materials to break
        List<Material> materialsToBreak = new ArrayList<Material>();
        
        materialsToBreak.add(Material.ICE);
        materialsToBreak.add(Material.RED_MUSHROOM);
        materialsToBreak.add(Material.RED_ROSE);
        materialsToBreak.add(Material.YELLOW_FLOWER);
        materialsToBreak.add(Material.BROWN_MUSHROOM);
        
        // Creates a list of biomes to remove
        List<Biome> biomesToKeep = new ArrayList<Biome>();
        
        biomesToKeep.add(Biome.OCEAN);
        biomesToKeep.add(Biome.DESERT);
        biomesToKeep.add(Biome.DESERT_HILLS);
        biomesToKeep.add(Biome.DESERT_MOUNTAINS);
        biomesToKeep.add(Biome.BEACH);
        biomesToKeep.add(Biome.RIVER);
        biomesToKeep.add(Biome.TAIGA);
        biomesToKeep.add(Biome.TAIGA_HILLS);
        biomesToKeep.add(Biome.EXTREME_HILLS);
        biomesToKeep.add(Biome.EXTREME_HILLS_MOUNTAINS);
        biomesToKeep.add(Biome.FOREST);
        biomesToKeep.add(Biome.FOREST_HILLS);
        biomesToKeep.add(Biome.PLAINS);
        
        for(Block block : blocks) {
        	
            if(!biomesToKeep.contains(block.getBiome())) {
            	
            	block.setBiome(Biome.OCEAN);
            }
        	
            if(materialsToBreak.contains(block.getType())) {
            	
            	block.setType(Material.AIR);
            }
        	
            if(block.getType().equals(Material.AIR)) {
            	
            	if((block.getWorld().getBlockAt(block.getX(), block.getY() - 1, block.getZ()).getType().equals(Material.DIRT)) && (block.getWorld().getBlockAt(block.getX(), block.getY() - 1, block.getZ()).getData() == 0)
            			|| (block.getWorld().getBlockAt(block.getX(), block.getY() - 1, block.getZ()).getType().equals(Material.GRASS))) {
            		
            		block.setType(Material.LONG_GRASS); block.setData((byte) 1);
            	}
            }
                                
            else if(block.getType().equals(Material.LOG)) {
                
	        	Block regionBlock = block.getLocation().getWorld().getBlockAt((int)block.getLocation().getX(), (int)0, (int)block.getLocation().getZ());
	        	
	        	if(regionBlock.getType().equals(Material.STAINED_CLAY)) {
	        		
	    			if((regionBlock.getData() == (byte)4) && (block.getLocation().getY() < 100)) {
	    				
	    				wipeTree(block);
	    			}
	        	}
	        	
	        	else {
	        		
	        		wipeTree(block);
	        	}
            }
            
            else if(block.getType().equals(Material.LEAVES)) {
            
	        	Block regionBlock = block.getLocation().getWorld().getBlockAt((int)block.getLocation().getX(), (int)0, (int)block.getLocation().getZ());
	        	
	        	if(regionBlock.getType().equals(Material.STAINED_CLAY)) {
	        		
	    			if((regionBlock.getData() == (byte)4) && (block.getLocation().getY() < 100)) {
	    				
	    				block.setType(Material.AIR);
	    			}
	        	}
	        	
	        	else {
	        		
	        		block.setType(Material.AIR);
	        	}
            }
        }
	}
	
//==================================================================================================================================

	@SuppressWarnings("deprecation")
	private static void wipeTree(Block block) {
		
        //=========
        
        Location belowLog_Location = block.getLocation();
        belowLog_Location = checkLog(belowLog_Location, -1);
        
        while(belowLog_Location.getBlock().getType().equals(Material.LOG)) {
        	
        	belowLog_Location = checkLog(belowLog_Location, -1);
        }
        
        Block bottomLog = belowLog_Location.getWorld().getBlockAt((int) belowLog_Location.getX(), (int) belowLog_Location.getY()+1, (int) belowLog_Location.getZ());
        
        Material belowLog_Material = belowLog_Location.getBlock().getType();

    	//=========
    	
        if((belowLog_Material.equals(Material.GRASS)) || (belowLog_Material.equals(Material.DIRT))) {
 	
        	//Turns bottom log into a sapling
    		byte blockID = bottomLog.getData();
    		bottomLog.setType(Material.SAPLING); bottomLog.setData(blockID);
    		
    		// Sets the bottom log up a Y
    		bottomLog = belowLog_Location.getWorld().getBlockAt((int) bottomLog.getX(), (int) bottomLog.getY()+1, (int) bottomLog.getZ());
    		
            while(bottomLog.getType().equals(Material.LOG)) {
            	
            	bottomLog.setType(Material.AIR);
            	bottomLog = belowLog_Location.getWorld().getBlockAt((int) bottomLog.getX(), (int) bottomLog.getY()+1, (int) bottomLog.getZ());
            }
        }
	}

//==================================================================================================================================

	private static Location checkLog(Location checkLocation, int changeY) {
		
		checkLocation.setY(checkLocation.getY()+changeY);
		
		return checkLocation;
	}
	
//==================================================================================================================================

}