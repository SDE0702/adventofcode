package aoc.jahr2022;

import java.util.ArrayList;
import java.util.HashSet;

public class Day17_2022 
{
	private static String real = ">>><<<>><<<>>><<<>>><<<>><<><>>><<>>><>><<<>>><<><>>><<<<>>>><>><<>>>><>>>><<<<>>>><<<>>><>><<>><<<>><<<<><<>><<><<<>><<>>><<<>>>><>>><>><><<<<><>><><<>>>><<><<<<><<<><<>>>><<><<>><<<<>>>><>>>><>><><<<>>>><>>>><>><<>>>><>>>><<><<<<>><<>>>><>>><>><>><<>><<<<>>>><<<>><<<><><<<<>><<><<<<><<<><<<<>>>><<><<<>>><<>><>><<><<<<>>>><<<>>>><<<<>><<<<>><<>>>><<><>><>>>><<<<>>>><<>>><<<><<<<>>><>><<<>>><<<>>>><<<>>>><>>>><>>><<<<>>>><<<>>><<<<>>><><<>>><<<>>>><<<>>>><>>>><<<<>><<>>><<<<><>>>><><<<<>>><<<<>>>><<<>>>><<>>><>><<>><<>><<>>><<>>>><>>><<<><<<>><<<<>>><<<>>><<<><>>><<<<><>><<<>>>><><<<<><<>><<<<>><<<>>><>><<><><<<>><<<>>><<>>>><<>><><<>>>><<<<>>><<<>><<<<>><<><<<>>>><>>><>><<<>>>><<<>>><>><<<<><><<>><<<>><<<<>>>><<<<>>><<<<>><>>>><>>><>>><<>>><<<<>><<><<<<>>>><<<<>>>><<<><<>><><<<>>><>><<>><<<>>><>>><<<<>><>><><<><>><>>><>>>><<<>>><<<<>>>><<<>>>><<<>><<<<>>>><<<>>><><<>>><>>><<<>>><<<<><>>>><<<><>>>><>>><<>>><>><<<<>>><<>><<<<>><<>>>><<<><<><><<<>><<<<>>><<<><<<<>>>><<<<>>>><<<<>><<>>><<<><<<<><<<>>><><<<<><>><<><<<<>>><<>><>><<<><<<>>><<>><<<<><<<>><<<<>>><<>>><<<>>>><<<>><<<>>>><><<>><>>><<<>><><>><<>>><<<<>>><<>>>><>><<><<<>>>><<<>>><<>><<<<>>><<<<><<<<><<>>>><>><><<<>>>><<<<>><<<<>><>><<>><<<>><><<<<>>>><<<<>>>><<<>>>><>><<>><<<><<<<>><<<<><<<><<<>>><<<>><>>><<>><<><<>><<>><<><<<><<<<>>>><<<><>>>><<>><<>>><>>><<>>><><<>>><<<>>>><<<<>>>><><<<>>><<>>>><<<<><>>><>><<>><<<><><>>><<<>>>><>>><<><>>><<>>><<<>>><<<><<<>>><<<<><<<<>>>><<<>>>><<<<>>>><<<>>><<>><<>>><<<<>><><<<><<><<<>>>><<<<>>><>><<<<><<<>>>><<<<>>>><<<>><>>>><<<><<<<>>>><>>>><<>>>><<<><<<<><<>><>>>><<<>>>><<<<>>><>>>><<<><<>>><<>><<<>><>><<<>>><<>>>><<>>><<>>>><<><<>>>><<<<>>><<<<>>><<<>>><>><<><<<<>>>><<<>>><><<<<>>><<>>><<>><<<>><<<<><><<<<>>>><<<><<>>>><<<>>>><>><<<>>>><>>>><><<<<>><<<>>><>>><>>><<<>><<<<><>>><<>>><<<>>>><>>>><><<<<>>>><<>>><>>><<<<><<>>><<<><<<>>>><<<<><><<<<><<<<>><<<><>><<<<>>><>><<><<>>><<<>>><<<<>><<<>>><<<>>>><<<<>>><>><>><<<<>>>><>>><<<<>>><<>>><>><<<><>>>><<<<><<<>><><<<<>><<<<>>>><>><>><>>>><<<>>>><<>>>><<<>>><<<<>>>><<<<>>>><<><><<<>>><<>>><<<<>>>><<<<><<>>>><<<><<<<>>>><<>><<<>><<><>><<<<>>><<<<>>><<<<>>><<>>>><<<<>><<>>><<>>><>>>><<<>>>><<>>><<<<><<<>>><<<<><<><<>>><<>>>><<<<>>><<>>><<<<>>>><<<<>>><<<<><>><<<>>>><<<<>><<<>>><<<><<>>>><>>><<>>><>>>><<<><<<<><<<><<<>>>><<>>>><>>><>>>><<>>>><<<<>>>><>><<<<><<<>>>><><<>>>><<><<<>><<<<>>>><<<<><<<><<<<>>>><>><><<<<>><<<<>>><<>><<>>><>>><<<>>>><<<<>>><<<<>>><<>>>><<>><>><<<<>>>><<<>><<>><><><<>><<<<>>><<><<<<><><<<>>>><<<<>>><<<<>>>><<<>>><<<<><<<<>>><<><<><<>>><<<><<>><>>>><<<>><<>>><<<<>>>><>>>><<<>>>><<<<>><<><<<>>>><<<>>><>>>><<<<>>>><<<<><<>>><<<<>>>><<>>>><<<<><<<<>>><<>>><><<<<><<>>><>>>><<><<<>>>><>>><<<>><<<>><<<<>><>>>><<<>><<<<><>>>><<<>><<<<>>>><<<<>><<<<>><<>>><>>>><<>>><<<<><<>><>><<<<>>>><<<<>>>><<>><<<<><<<<><<>><><<>>>><<<<>>><<<<>><<<<>><<<<>><<<<>>><<<<>>><<<<><<<>>><><>>>><<>><>>><<>>><<<>>><<><>>>><<<<>>><<<>><<<<>>><<<>>><<>><<>><><<>><<>><<>>>><>>><<<>>>><<<<>>>><<<>><>>>><<<>>><<<><<>>>><<<>><<<<>><<<>>><<<<>><<><<<>>>><<>><>>>><<<<><>>>><<><<<<>><<>>><<>><<<<>>>><<>>><<>><<>>><>>>><<<>><<<><>><<<<>>><<<>>><<><<>>>><<<><>>>><>><<<>><><<<<>><<<<>>>><<<<>><><<<>>>><><<<<>>>><<>>><>>>><<>><>><<<><>><<<>>>><>><<<><<><><<<>>><<>><<<<>><<<>>><<>><<><>><<<<>>>><<<<>><<>>>><<<>><<><>>>><<<<>>>><>>><<>>><><<<<>><<>><>>>><<<<>>>><><<>>>><>>>><<<<>>>><<<<><>><><<<>>>><>>><<><><<<><<<<>>>><<<<>><<<>>>><<<<>>>><<<<>><<>>>><>><>>>><<<<><<>><<<><<<>>>><<<>>><<>>>><>><<<<>><<<>>>><<>>>><<<<>>>><<<<><<<>><>><><><<<><<<><<<><<<<>>><<>>><<>>><<<>><<<><<<<><<>>>><>><>><<<>>><<<<>>>><<<<>>><<<<>>><<<>>>><<>><<>><>><<>>><<>>>><<<<>>>><>>>><><><<<<><<<<>><<<><<<>>><<>>><<<>>>><<>>>><<>>><<<<>>>><<<><<<<>>><<<<><<>>>><<<<>>><>><><<>>><>>>><>>><<<>><<<<>><<<>>>><<>><<<>>>><<<><<<<>>><<<<><<<><<<>><<<>>>><<>>><>><<<<>>><<<>><>>>><<><><<<><><<<>>>><<<>><<><<<>>>><<<>>>><>>>><<<>>><<<>>><<<<>><<>><>><<>><>>><<><>><>>>><<<><<<><<<><<<<>><<>>>><>>>><>>><<<<><<<<>>>><<><<<>>><<<>>>><<<>>><<>>>><<>><><<<>><<<<>>>><<<<><<>><>><<<>><><<>><<<<>>><>>>><<<>><<<>><<<>>><<><<<><>><><><<>><<<>>><<<><<<><>>>><>>>><>>><<<<>>>><><<<<>>><<>><<<<>><<>>><>>>><<>>><>>>><<<>>>><<<>>>><<<<>>><<<<>><<<>>><<<>><<<>>><<<<>>><<>>>><<>>>><<<<>>>><<<<>><<<>>><<<<>>><>>>><<<<><<<<>><<<<>>>><>>><<<>><<>>>><<><<>><<<>>><<<<><<<<>>>><<<<><<<>>>><<<<>>><><<<<><<<<>><><<<>>>><>><<<<>><><>><<<>>>><><<>>>><><<<>>>><>>><<<<>>>><<<<>>><<<<>><<>>>><>>>><>>><<<><<>>>><<<<><<<<>><><>><<<>><<><<<<>>><<<<>>>><<<>><>><<>>><<<>>><<<<>>><<<><>>><<<>>><<<>><<<>>>><<<>><<>>>><<<<>>><<<<>><<<><>><<<>><><<<>><<<<><><>><<<><>><><<<>>><>>>><>>>><<<>><<<>>>><<<>>><<<<>>><<<>>>><<>>>><>><<><<<>><<>>>><>>>><<>><<<<><<<>><<>><<<><<>>>><<<<><<<>>>><<><<>>>><<><>>><><<>>><<<><<><<<<>>><<>>><>>>><><>>><<<<>><<>><<>>>><<<<>>><<<>>><<><<<><<<<>>><<>>><>><>>>><<><<<>>><<<<>>>><<>><<<<>><>>><<<>>><<>>>><<<>><<><<<>>><><<>>><<><<>>><>>>><<<<>>>><<<<>>>><<<>>>><<<<>>>><><<<<>>><>>><<<<>>><<>><<<>>>><>>>><><<<>><<>><<<>>><<<<>>><<<>>>><><<<<>>>><<><<>>><<<<>>>><<>>><<<<><>>><<<>>><<><<><<<>><>>>><<<>>>><<<>><<<>><<>>><<>>>><<<><>>>><<<<>>><<<<>><<>><<<>>><<<<>><<<<>>>><<>><<>><<<<>>>><>>>><<<>><>>><><>>><>>>><<<>>>><<>><<<>><<>><>>>><<<>>>><<<<><>>><<><<><>>>><<>>>><>>><<<<>>>><>>>><<<><<<><>>><<<>>><>>><<<>><<<<>>><>>>><<><<<<><<<>>>><<<<><<<<>><<>>><<<<><<<<>>><<>>><<<>>>><<>>>><<<>>>><<>><<>>><<<>>><<>>><>>><<>><<>><<<<><<>>>><<<>>>><<<>><<<<>>>><<>>>><>>>><>><>>>><><<<>>>><<<>>><><<<<>>><<<>><<<>><<<<>><<<>>>><<<<>>>><>>>><>><<<><><>>><>>>><<<<>>>><<<>>>><<>><>>>><<<<><<<>>>><>><<<>><<<<>>>><>>><<<<>>><<<<>><<<>>><<<<>>>><<>>><<>><<<>>><>><<>>>><<<<>>><<<<>>><<<<><<<<>>>><<<<><<<<>><>>><><<<>>><<<<>><<<<>>>><<<>>><>>><>>><<<>>><>>>><>><<>><<<<><<><>>>><<<<>>>><<<<>>>><<<>>>><><<<<>>>><<>>><<<>>>><<>>>><<<>>>><<<>><<<>><<>><<>>>><>>><>>>><<<<>>><<<>><<>>>><>>>><<<><<><<<>><<<<>>>><<<><<<<>><<><<<>><<<<><>><<<<><<>>>><>>>><<><<<<>><<>><<<>>>><<>>>><<<<>>><<><<<>>>><<<<>>>><<<>>><>>>><<>>><<<<>>><<<<>>><<<<>>>><<>>>><<>>>><<<<>>>><<>>>><<>>><>><<<<>>><>>>><>><<>>><<<<>><<<>><<><<>>>><<<>><<>><>><<<>>>><<><<><<><<><<>>>><<<>><<>>>><>>><<<<><<><>>><<<><<<<>>>><<<>>><<<<>><>>>><>><<<>>><<<>>><<>><<<><<<<>>>><<<><<><<<>>><<<<>><>>><>>><<<<>>><><<<<>><<>>>><>><<>>><<><<>>><<<<>>>><>><<<><<<>>>><<<>>>><<<>><<<>>>><<><<<<><<<<>><<>>>><>>><>>><<<<>><>><>><<<>>><<>><><>>><<<<><<<<>>>><>>><<<><<><>>><<<<>>>><><>><<<><<<>>><>>><<>><<>>>><><>><>><<<>><<>>>><<<>><<<<>>>><<<>><<>>><<<<>>>><<<<><<<>><<<><>>>><<<<>>>><<<>><<<><<<>><>>>><>>><<><>><<>>>><<<<><><<>>><<<<>>><<<<>>><<>>><<>><<<<>>>><<<<>>>><><><<>><>>>><<>>><<<<>>>><<>><<<>><<<<>>><<>>><><<>><<>><<<>>>><>><<><<<<>><<<>><<<>>>><>><<<<>><><>>>><<<<>><<<>>><<<<>><<<>><><>>>><<>><>>>><<<<>>>><<<<>>><<<<><<<<><<>>><<<<>>><<<<>>><<<<>>>><>><<><<>><<>>>><<<<>>><<<<>><<<>><>>><<<<><<>>><<<>>>><<><<<>>>><<><>><<><><<<><<<<>>><>>><<>>>><<<<><<>><>>>><<>>>><<<<>>>><<<<>>><><<<<>>>><<>><<>><<<>>>><<>>><>>><>>>><<<<>>><<>>><><>>><<><>>>><<<<>>><<<>><<>><>>>><<><<<>>><<<>>>><<<>>>><<>>>><<<<>>>><<<<><<>>><<>>>><<>>>><<><<<>><<<<><<<<>><<>>>><<><<<<>>><<<><<<<>>><<<>>>><<>>><>><<>>><>>><<>><>>><>>>><<>><<<><<>>>><>>>><<<><>>>><<<<>>>><<<<><><>>><<<>>>><><>>>><<<>><>>><<<>>>><<><<><<<<>>>><>>><<<>><<<><>><<<><><<<>>>><<>><<><<<>>>><<<>>><<<>>>><<<>>>><<<><<>><<<>><><<<>>>><<<<>>><<>><>>>><>><<>>>><<<><<>><<<><<<>>>><<<<><<<<><><<<>>>><><<<<><<<>>>><<<<>><<>><><<<>>><>><<<<>><<<>>>><>>>><<<>>><<<<><<<>>><<>>>><<<<>><<<<>>><><<><<<<><<>><>>><>><>><<<<>>>><><<>>><<<<>>>><<<<>>>><<<>><><<<<>><>>>><<>>><<<<>>><<<>>>><<>>>><<<<><<<<>>><<<>>><<>>>><<<>>>><<<>>>><<<<><<<<>>><<>>>><>>><>><<>><<<>><<<>><>><<>><<><<<<>>>><<<>><<>><<<<>>><<<><><>><<<><<>><<<<>><<>>>><<><<<<>><<<<>>><<<<>>>><<<<>><<<<>><<<>>><>>>><<<>>><<<<>>>><><<<>>><<>>>><<<><<<>><<>>><>>><<>>><>>><<>>><<<><<<>>>><<>><<>><<>>><<>><<<>>>><<<>>>><<<>>><<<><><>>>><<<<><<<>>><<<><>><<<<>>>><<<>><<<<>>><<<>><><<<>><<<<>>><<<><<<>>>><><<<<>>><<<>><<<>><<<<>>><<<<>>><<<<>>>><<>>>><<<<>>><>><<<><<<><>><<<>>><<<>><<<<>><<<<><<><>>>><<><<<>>><<<<>>>><<>><>>>><<<<>>>><<><<<<>><<<<>>><<<>>>><>>>><>><<>><<<><><<<<>>>><><>>><<<>>><<<<>>><<<<>>>><<><<<>>><<>>>><<<><>><><<<<>>>><<<<>>>><<<>>><<<>>>><<>>>><<<>>>><<<>>><>><<<<>><><>><<<<>>>><>>>><<<>><<>>>><<><<<<>>><>>><<<>>>><<<<><<><>>><<<<><<<<>>><<>><><<<<>>>><<<>><>>>><>>>><<>><<<>>>><<<<>>><<<>>>><<<>>>><<>>><<<>>><<<<>><<<<>><>>><<>>><<>>>><<<<>>>><>>><>><<><>>><<<><<>>>><><<<>>><<<><<>>>><<<>>><><<<<>>><<><>>><<>>><>>>><><>><<>>><<>>>><<>>>><<<<>>><>><><<<<>>>><<<<>>><><<>><<<<>><<>><<<>>><<<<>>><<<>>><<<<>><><<<><<<>>>><>>>><<<<>><<<>>><<<><<><<<><>><><<<>>>><<<<>>><<<<>>><<<<><<<>>>><<<<>>>><<<>>><>><><<>><<<>><<><<<<>><<><<<>>><<>>><<>>>><<>>>><><>>>><<<>>>><<<<><<>><<<<>>>><<<>><<<<>><><>>><<<<>>>><<>>><<<>><<<>>><<>>>><<<><<<<>><<>><<<>><<>>>><<>><<<<>>><>>><>><>>>><<<>>><<>>><<<>><<>>><<<<><<<><<>>><<<<>>><>><><<<<><>><>>><>><<><<<<><<>>><>><>><<>>><<>>><>>><<<<>>><<<<>>><<><>><<<<>>><<<<><<>><<<><><>>><>>><<<<>>><<<><<<>><<><>>>><<>><<>><<<<><<<<>><<>>>><>><<><<<>>>><<<>>>><<><<<<>>>><<<>><<<>>>><<<><>>>><<<>><<>><<<>><<<<>>>><<<>>><<<>><<<>>>><<<>>><<>>><<<<>>>><>>>><<>>>><><<<<>><<><<><<>><>>><<>>>><<>>><<<<><<><>><<<<><>><<<<><<<<>><<>>><<<<><>>>><>><<<>>>><<<<>>>><<>><<<<>>><<>>>><<>>><<<<>><<<><<<<>><<<>>><<<>>>><<<>><>><<>>>><<><<><>><>>><>><<<>>><<>>><<<><<<<>>>><<<<>>><<<<>>><<>>><<<<>>>><<><><><>><<>>><<<>>><<<<><>>><>><>><<<<><<<<>><<<<>>><>>>><<<>>><<<>>>><<<>>>><<<<>>>><>>><<<<>>>><><<<><<>>><<<<>>><<>><<>><<<<>>>><<>><><<<<>><<<>>><<<>>><<<<>><<<>>>><<<<>>>><>>><>>>><<>>><<><<><<<>>><<<><<<><>>>><<<<><<>>><<<>><<<<><<<>>><><<<<>>>><<>>>><>>><>><>>>><<<<><<<><<<><<><<>>>><<>>><>>>><<<><<>>><<<>><<><<<><<<><<<>><>>><<<>><>>><<>><>><<<<>>>><<<<>>>><><<<<><<><<<<>>>><>>><<<>>>><>>>><<<>>><<<>>>><<<>>><<<>>>><>>><<<>><>>><<>>>><><<<>><<<><>>>><<<>>>><<<<><<<>>>><>>><<<>><<>><<<<>><<<><<>>><<<>>>><>>>><<<<>>><<<>><>>>><><<<<><<>>>><>>>><<<><<>>>><<<<>>><>>><>>>><><<>>>><<><><><<>><<>>><<<><<>>>><<><<>><<>>>><<<>>>><<><<><<>>><<<>><<<>>>><><<<>>>><<<<><>>>><<<>>><<>><>>>><<<<><<>>><<><>><";
	private static String test = ">>><<><>><<<>><>>><<<>>><<<><<<>><>><<>>";
	
	private static String input = real;
	
//	private static final int MAXROCKS = (int)2022;
	private static final int MAXROCKS = 2022;
	private static final int MAXCHAMPERX = 7;
	private static HashSet<XYPoint> champer = new HashSet<>(); 
	
	public static void main(String[] args) throws Exception 
	{
		Rock rminus = new Rock().add("0;0,1;0,2;0,3;0"); // -
		Rock rplus = new Rock().add("1;0,0;1,1;1,2;1,1;2"); // +
		Rock rL = new Rock().add("0;0,1;0,2;0,2;1,2;2"); // L revers
		Rock rI = new Rock().add("0;0,0;1,0;2,0;3"); // I revers
		Rock rPoint = new Rock().add("0;0,1;0,0;1,1;1"); // point
		
		ArrayList<Rock> rocks = new ArrayList<Rock>();
		rocks.add(rminus);
		rocks.add(rplus);
		rocks.add(rL);
		rocks.add(rI);
		rocks.add(rPoint);
		
		int highestLine = 0;
		int rockCounter = 0;
		int jetCounter = 0;
		
		int currentrockPosx = 0;
		int currentrockPosy = 0;
		Rock currentRock = null; 
		long l = System.nanoTime();
		while (rockCounter <= MAXROCKS)
		{
			if (currentRock == null)
			{  // Init new rock
				if (rockCounter == 10)
				{
					rockCounter = rockCounter + 1 - 1;
				}
				currentRock = rocks.get(rockCounter % rocks.size());
				rockCounter++;
				currentrockPosx = 2;
				currentrockPosy = highestLine + 3;
			}
			// Falling
			// Jet
			char jet = input.charAt(jetCounter % input.length());
			jetCounter++;
			if (jet == '<' && currentrockPosx > 0)
			{
				if (checkFree(currentRock,currentrockPosx,currentrockPosy,-1,0))
				{
					currentrockPosx--;
				}
			} else if (jet == '>' && currentrockPosx < MAXCHAMPERX - currentRock.getMaxX() - 1)
			{
				if (checkFree(currentRock,currentrockPosx,currentrockPosy,1,0))
				{
					currentrockPosx++;
				}
			}
			

			if (currentrockPosy <= highestLine)
			{
				if (!checkFree(currentRock,currentrockPosx,currentrockPosy,0,-1))
				{
					// in champer eintragen
					insertRockInChamper(currentRock,currentrockPosx,currentrockPosy);
					
					int maxy = champer.stream().max( (p1,p2) -> p1.y - p2.y).get().y;
					highestLine = maxy + 1;
					currentRock = null;
				} // else noch eine Runde
			}
			currentrockPosy--;
		}
		l = System.nanoTime() - l;
		System.out.println(l / 1000 / 1000);
		System.out.println("Champer output");
		printChamper();
		int maxy = champer.stream().max( (p1,p2) -> p1.y - p2.y).get().y;
		System.out.println("Champer tall size: " + maxy);
	}
	
	private static void insertRockInChamper(Rock r, int currentrockPosx, int currentrockPosy) 
	{
		for(XYPoint p : r.massiv)
		{
			champer.add(new XYPoint(p.x + currentrockPosx,p.y + currentrockPosy));
		}
	}
	
	private static boolean checkFree(Rock r, int currentrockPosx, int currentrockPosy,int xoffset,int yoffset) 
	{
		if (currentrockPosy + yoffset < 0) return false;
		ArrayList<XYPoint> checkList = new ArrayList<XYPoint>();
		for(XYPoint p : r.massiv)
		{
			checkList.add(new XYPoint(p.x + currentrockPosx + xoffset,p.y + currentrockPosy + yoffset));
		}
		int si = checkList.size();
		checkList.removeAll(champer);
		return checkList.size() == si;
	}
	
	private static void printChamper() 
	{
		int maxy = champer.stream().max( (p1,p2) -> p1.y - p2.y).get().y;
		
		for(int y = maxy;y >= 0;y--)
		{
			System.out.print("|");
			for(int x = 0;x < MAXCHAMPERX;x++)
			{
				XYPoint p = new XYPoint(x,y);
				if (champer.contains(p))
				{
					System.out.print("#");
				} else {
					System.out.print(".");
				}
			}
			System.out.println("|");
		}
		System.out.print("+");
		for(int x = 0;x < MAXCHAMPERX;x++)
		{
			System.out.print("-");
		}
		System.out.println("+");
		System.out.println();
	}

}
