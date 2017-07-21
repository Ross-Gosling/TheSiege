//==================================================================================================================================

package functions;

import me.x3DGosling.Siege_Core.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Display {

//==================================================================================================================================

	// Throne display
						
//==================================================================================================================================
		
	public static void throne(String faction, double capLevel, String capturer, String capturedBy) {

		int centralX = (Main.fetchConfig().getInt(faction + ".Throne.Coords.CoordsX"));
		int centralY = (Main.fetchConfig().getInt(faction + ".Throne.Coords.CoordsY"));
		int centralZ = (Main.fetchConfig().getInt(faction + ".Throne.Coords.CoordsZ"));
		
		int rossCarpetID = 14;
		int lewisCarpetID = 10;
		int alexCarpetID = 5;
		int curtisCarpetID = 9;
		
		int ownerCarpetID = 0;
		int capturerCarpetID = 0;
		
		if(capturedBy.equals("Emberstone")) { ownerCarpetID = rossCarpetID; }
		else if(capturedBy.equals("Mykonos")) { ownerCarpetID = lewisCarpetID; }
		else if(capturedBy.equals("Summerhold")) { ownerCarpetID = alexCarpetID; }
		else if(capturedBy.equals("Icarus")) { ownerCarpetID = curtisCarpetID; }
				
		if(capturer.equals("Emberstone")) { capturerCarpetID = rossCarpetID; }
		else if(capturer.equals("Mykonos")) { capturerCarpetID = lewisCarpetID; }
		else if(capturer.equals("Summerhold")) { capturerCarpetID = alexCarpetID; }
		else if(capturer.equals("Icarus")) { capturerCarpetID = curtisCarpetID; }
		else { capturerCarpetID = 8; }

		if(capLevel >= 1) {
			
			int x = centralX + 6;
			int z = centralZ;
			
			changeBlock(x, centralY, z, capturerCarpetID);
				
			if(capLevel >= 2) {
					
				x = centralX + 6;
				z = centralZ + 1;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 3) {
				
				x = centralX + 5;
				z = centralZ + 2;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 4) {
				
				x = centralX + 5;
				z = centralZ + 3;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 5) {
				
				x = centralX + 4;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 6) {
				
				x = centralX + 3;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 7) {
				
				x = centralX + 2;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 8) {
				
				x = centralX + 1;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 9) {
				
				x = centralX;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 10) {
				
				x = centralX + -1;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 11) {
				
				x = centralX + -2;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 12) {
				
				x = centralX - 3;
				z = centralZ + 5;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 13) {
				
				x = centralX - 4;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 14) {
				
				x = centralX - 5;
				z = centralZ + 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX - 5;
				z = centralZ + 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX - 6;
				z = centralZ + 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 16) {
				
				x = centralX - 6;
				z = centralZ;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 17) {
				
				x = centralX - 6;
				z = centralZ - 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 18) {
				
				x = centralX - 5;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 19) {
				
				x = centralX - 5;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 20) {
				
				x = centralX - 4;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 21) {
				
				x = centralX - 3;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 22) {
				
				x = centralX - 2;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 23) {
				
				x = centralX - 1;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 24) {
				
				x = centralX;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 25) {
				
				x = centralX + 1;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 26) {
				
				x = centralX + 2;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 27) {
				
				x = centralX + 3;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 28) {
				
				x = centralX + 4;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 29) {
				
				x = centralX + 5;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 30) {
				
				x = centralX + 5;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 31) {
				
				x = centralX + 6;
				z = centralZ - 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
		}
		
		if(capLevel <= 31) {
			
			int x = centralX + 6;
			int z = centralZ - 1;

			changeBlock(x, centralY, z, ownerCarpetID);
					
			if(capLevel <= 30) {
				
				x = centralX + 5;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 29) {
				
				x = centralX + 5;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 28) {
				
				x = centralX + 4;
				z = centralZ - 4;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 27) {
				
				x = centralX + 3;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 26) {
				
				x = centralX + 2;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 25) {
				
				x = centralX + 1;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 24) {
				
				x = centralX;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 23) {
				
				x = centralX - 1;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 22) {
				
				x = centralX - 2;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 21) {
				
				 x = centralX - 3;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 20) {
				
				x = centralX - 4;
				z = centralZ - 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 19) {
				
				x = centralX - 5;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 18) {
				
				x = centralX - 5;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 17) {
				
				x = centralX - 6;
				z = centralZ - 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 16) {
				
				x = centralX - 6;
				z = centralZ;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 15) {
				
				x = centralX - 6;
				z = centralZ + 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 14) {
				
				x = centralX - 5;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 13) {
				
				x = centralX - 5;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 12) {
				
				x = centralX - 4;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 11) {
				
				x = centralX - 3;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 10) {
				
				x = centralX - 2;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 9) {
				
				x = centralX - 1;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 8) {
				
				x = centralX;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 7) {
				
				x = centralX + 1;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 6) {
				
				x = centralX + 2;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 5) {
				
				x = centralX + 3;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 4) {
				
				x = centralX + 4;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 3) {
				
				x = centralX + 5;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 2) {
				
				x = centralX + 5;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 1) {
				
				x = centralX + 6;
				z = centralZ + 1;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 0) {
				
				x = centralX + 6;
				z = centralZ;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
		}
	}

//==================================================================================================================================

	// City display
							
//==================================================================================================================================
	
	public static void city(String cityPoint, String faction, double capLevel, String capturer, String capturedBy) {

		int centralX = (Main.fetchConfig().getInt(faction + ".Cap" + cityPoint + ".Coords.CoordsX"));
		int centralY = (Main.fetchConfig().getInt(faction + ".Cap" + cityPoint + ".Coords.CoordsY"));
		int centralZ = (Main.fetchConfig().getInt(faction + ".Cap" + cityPoint + ".Coords.CoordsZ"));
				
		int rossCarpetID = 14;
		int lewisCarpetID = 10;
		int alexCarpetID = 5;
		int curtisCarpetID = 9;
		
		int ownerCarpetID = 0;
		int capturerCarpetID = 0;

		if(capturedBy.equals("Emberstone")) { ownerCarpetID = rossCarpetID; }
		else if(capturedBy.equals("Mykonos")) { ownerCarpetID = lewisCarpetID; }
		else if(capturedBy.equals("Summerhold")) { ownerCarpetID = alexCarpetID; }
		else if(capturedBy.equals("Icarus")) { ownerCarpetID = curtisCarpetID; }
				
		if(capturer.equals("Emberstone")) { capturerCarpetID = rossCarpetID; }
		else if(capturer.equals("Mykonos")) { capturerCarpetID = lewisCarpetID; }
		else if(capturer.equals("Summerhold")) { capturerCarpetID = alexCarpetID; }
		else if(capturer.equals("Icarus")) { capturerCarpetID = curtisCarpetID; }
		else { capturerCarpetID = 8; }
		
		if(capLevel >= 1) {
						
			int x = centralX + 4;
			int z = centralZ;

			changeBlock(x, centralY, z, capturerCarpetID);
			
			if(capLevel >= 2) {
									
				x = centralX + 4;
				z = centralZ + 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 3) {
									
				x = centralX + 3;
				z = centralZ + 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 4) {
				
				x = centralX + 2;
				z = centralZ + 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 5) {
				
				x = centralX + 1;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 6) {
				
				x = centralX;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 7) {
				
				x = centralX -1;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 8) {
				
				x = centralX - 2;
				z = centralZ + 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 9) {
				
				x = centralX - 3;
				z = centralZ + 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 10) {
				
				x = centralX + -4;
				z = centralZ + 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 11) {
				
				x = centralX + -4;
				z = centralZ;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 12) {
				
				x = centralX - 4;
				z = centralZ - 1;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 13) {
				
				x = centralX - 3;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 14) {
				
				x = centralX - 2;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX - 1;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 16) {
				
				x = centralX + 1;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 17) {
				
				x = centralX + 2;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 18) {
				
				x = centralX + 3;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 19) {
				
				x = centralX + 4;
				z = centralZ - 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
		}
		
		if(capLevel <= 19) {
		
			int x = centralX + 4;
			int z = centralZ - 1;

			changeBlock(x, centralY, z, ownerCarpetID);

			if(capLevel <= 18) {
				
				x = centralX + 3;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 17) {
				
				x = centralX + 2;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 16) {
				
				x = centralX + 1;
				z = centralZ - 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 15) {
				
				x = centralX;
				z = centralZ - 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 14) {
				
				x = centralX - 1;
				z = centralZ - 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 13) {
				
				x = centralX - 2;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 12) {
				
				x = centralX - 3;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 11) {
				
				x = centralX - 4;
				z = centralZ - 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 10) {
				
				x = centralX - 4;
				z = centralZ;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 9) {
				
				x = centralX - 4;
				z = centralZ + 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 8) {
				
				x = centralX - 3;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 7) {
				
				x = centralX - 2;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 6) {
				
				x = centralX - 1;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 5) {
				
				x = centralX;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 4) {
				
				x = centralX + 1;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 3) {
				
				x = centralX + 2;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 2) {
				
				x = centralX + 3;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 1) {
				
				x = centralX + 4;
				z = centralZ + 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 0) {
								
				x = centralX + 4;
				z = centralZ;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
		}
	}
	
//==================================================================================================================================

	// Fort display
							
//==================================================================================================================================
		
	public static void fort(String fortTitle, double capLevel, String capturer, String capturedBy) {
		
		int centralX = (me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Neutral." + fortTitle + "ernFortress.Coords.CoordsX"));
		int centralZ = (me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Neutral." + fortTitle + "ernFortress.Coords.CoordsZ"));
		int centralY = (me.x3DGosling.Siege_Core.Main.fetchConfig().getInt("Neutral." + fortTitle + "ernFortress.Coords.CoordsY"));
				
		int rossCarpetID = 14;
		int lewisCarpetID = 10;
		int alexCarpetID = 5;
		int curtisCarpetID = 9;
		
		int ownerCarpetID = 0;
		int capturerCarpetID = 0;
		
		if(capturedBy.equals("Emberstone")) { ownerCarpetID = rossCarpetID; }
		else if(capturedBy.equals("Mykonos")) { ownerCarpetID = lewisCarpetID; }
		else if(capturedBy.equals("Summerhold")) { ownerCarpetID = alexCarpetID; }
		else if(capturedBy.equals("Icarus")) { ownerCarpetID = curtisCarpetID; }
		else if(capturedBy.equals("")) { ownerCarpetID = 8; }
		
		if(capturer.equals("Emberstone") && (capturedBy.equals(""))) { capturerCarpetID = rossCarpetID; }
		else if(capturer.equals("Mykonos") && (capturedBy.equals(""))) { capturerCarpetID = lewisCarpetID; }
		else if(capturer.equals("Summerhold") && (capturedBy.equals(""))) { capturerCarpetID = alexCarpetID; }
		else if(capturer.equals("Icarus") && (capturedBy.equals(""))) { capturerCarpetID = curtisCarpetID; }
		else if(!capturedBy.equals("")) { capturerCarpetID = 8; }
		
		if(capLevel >= 1) {
				
			int x = centralX + 6;
			int z = centralZ;
			
			changeBlock(x, centralY, z, capturerCarpetID);
				
			if(capLevel >= 2) {
					
				x = centralX + 6;
				z = centralZ + 1;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 3) {
				
				x = centralX + 5;
				z = centralZ + 2;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 4) {
				
				x = centralX + 5;
				z = centralZ + 3;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 5) {
				
				x = centralX + 4;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 6) {
				
				x = centralX + 3;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 7) {
				
				x = centralX + 2;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 8) {
				
				x = centralX + 1;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 9) {
				
				x = centralX;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 10) {
				
				x = centralX + -1;
				z = centralZ + 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 11) {
				
				x = centralX + -2;
				z = centralZ + 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 12) {
				
				x = centralX - 3;
				z = centralZ + 5;
				
				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 13) {
				
				x = centralX - 4;
				z = centralZ + 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 14) {
				
				x = centralX - 5;
				z = centralZ + 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX - 5;
				z = centralZ + 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 15) {
				
				x = centralX - 6;
				z = centralZ + 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 16) {
				
				x = centralX - 6;
				z = centralZ;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 17) {
				
				x = centralX - 6;
				z = centralZ - 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 18) {
				
				x = centralX - 5;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 19) {
				
				x = centralX - 5;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 20) {
				
				x = centralX - 4;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 21) {
				
				x = centralX - 3;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 22) {
				
				x = centralX - 2;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 23) {
				
				x = centralX - 1;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 24) {
				
				x = centralX;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 25) {
				
				x = centralX + 1;
				z = centralZ - 6;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 26) {
				
				x = centralX + 2;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 27) {
				
				x = centralX + 3;
				z = centralZ - 5;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 28) {
				
				x = centralX + 4;
				z = centralZ - 4;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 29) {
				
				x = centralX + 5;
				z = centralZ - 3;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 30) {
				
				x = centralX + 5;
				z = centralZ - 2;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
			
			if(capLevel >= 31) {
				
				x = centralX + 6;
				z = centralZ - 1;

				changeBlock(x, centralY, z, capturerCarpetID);
			}
		}
		
		if(capLevel <= 31) {
			
			int x = centralX + 6;
			int z = centralZ - 1;

			changeBlock(x, centralY, z, ownerCarpetID);
					
			if(capLevel <= 30) {
				
				x = centralX + 5;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 29) {
				
				x = centralX + 5;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 28) {
				
				x = centralX + 4;
				z = centralZ - 4;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 27) {
				
				x = centralX + 3;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 26) {
				
				x = centralX + 2;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 25) {
				
				x = centralX + 1;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 24) {
				
				x = centralX;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 23) {
				
				x = centralX - 1;
				z = centralZ - 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 22) {
				
				x = centralX - 2;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 21) {
				
				 x = centralX - 3;
				z = centralZ - 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 20) {
				
				x = centralX - 4;
				z = centralZ - 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 19) {
				
				x = centralX - 5;
				z = centralZ - 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 18) {
				
				x = centralX - 5;
				z = centralZ - 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 17) {
				
				x = centralX - 6;
				z = centralZ - 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 16) {
				
				x = centralX - 6;
				z = centralZ;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 15) {
				
				x = centralX - 6;
				z = centralZ + 1;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 14) {
				
				x = centralX - 5;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 13) {
				
				x = centralX - 5;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 12) {
				
				x = centralX - 4;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 11) {
				
				x = centralX - 3;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 10) {
				
				x = centralX - 2;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 9) {
				
				x = centralX - 1;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 8) {
				
				x = centralX;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 7) {
				
				x = centralX + 1;
				z = centralZ + 6;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 6) {
				
				x = centralX + 2;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 5) {
				
				x = centralX + 3;
				z = centralZ + 5;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 4) {
				
				x = centralX + 4;
				z = centralZ + 4;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 3) {
				
				x = centralX + 5;
				z = centralZ + 3;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 2) {
				
				x = centralX + 5;
				z = centralZ + 2;
	
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 1) {
				
				x = centralX + 6;
				z = centralZ + 1;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
			
			if(capLevel <= 0) {
				
				x = centralX + 6;
				z = centralZ;
				
				changeBlock(x, centralY, z, ownerCarpetID);
			}
		}
	}
	
//==================================================================================================================================

	// changeBlock function
							
//==================================================================================================================================
			
	@SuppressWarnings("deprecation")
	public static void changeBlock(int x, int y, int z, int carpetID) {
		
		World world = Bukkit.getWorld("SiegeWorld");
		
		Location location = new Location(world, x, y, z);
		
		if((location.getBlock().getType().equals(Material.CARPET)) && (location.getBlock().getData() == (byte) carpetID)) {}
		
		else {
			
			location.getBlock().setType(Material.CARPET);
			location.getBlock().setData((byte) carpetID);
		}
				
		location.setY(location.getY() - 1);
		
		if(location.getBlock().getType().equals(Material.GLOWSTONE)) {}
		
		else { 
			
			location.getBlock().setType(Material.GLOWSTONE);
		}
	}
	
//==================================================================================================================================
	
	// sendSubtitle function
	
//==================================================================================================================================
	
	public static void sendSubtitle(String message, String colour, Player player) {
				
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), ("title " + player.getName() + " times 1 9 10"));
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), ("title " + player.getName() + " subtitle ['',{'text':'" + message + "','color':'" + colour.toLowerCase() + "'}]"));
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), ("title " + player.getName() + " title ['',{'text':' '}]"));
	}
	
//==================================================================================================================================
	
}
