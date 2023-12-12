import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

public class Day_11_Part1_2021 
{
	static String testInput = 
"""
11111
19991
19191
19991
11111		
""";

	static String testInput2 = 
"""
5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526	
""";
	
	static String input = 
"""
4472562264
8631517827
7232144146
2447163824
1235272671
5133527146
6511372417
3841841614
8621368782
3246336677
""";
	
	
	private static int totalFlashes = 0;
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);

		int[][] grid = new int[10][10]; 
		int maxY = 0;
		int maxX = 0;
		while (true)
		{
			String line = br.readLine();
			if (line == null) break;
			int x = 0;
			for(String c : line.split("|"))
			{
				grid[x++][maxY] = Integer.parseInt(c);
			}
			if (x > maxX) maxX = x;
			maxY++;
		}
		
		System.out.println("initgrid"); dumpGrid(grid,maxX,maxY); System.out.println();
		int steps = 0;
		while (steps++ < 220)
		{
			letFlash(grid,maxX,maxY,steps);
		}
		
		System.out.println(totalFlashes);
	}
	
	private static void letFlash(int[][] grid, int maxX, int maxY,int steps) 
	{
		// Increment field
		for(int y = 0;y < maxY;y++)
		{
			for(int x = 0;x < maxX;x++)
			{
				grid[x][y]++;
			}
		}

		boolean newflash = true;
		ArrayList<XYPos> completeFlash = new ArrayList<XYPos>();
		while (newflash)
		{
			newflash = false;
			ArrayList<XYPos> willFlash = new ArrayList<XYPos>();
		
			for(int y = 0;y < maxY;y++)
			{
				for(int x = 0;x < maxX;x++)
				{
					if (grid[x][y] > 9)
					{
						XYPos p = new XYPos(x,y);
						willFlash.add(p);
						completeFlash.add(p);
						grid[x][y] = 0;
						newflash = true;
					}
					
				}
			}
	
			for(XYPos p : willFlash)
			{
				int x = p.getX(); int y = p.getY();
				incGrid(grid,maxX,maxY,x-1,y-1,completeFlash);
				incGrid(grid,maxX,maxY,x  ,y-1,completeFlash);
				incGrid(grid,maxX,maxY,x+1,y-1,completeFlash);
				
				incGrid(grid,maxX,maxY,x-1,y,completeFlash);
				incGrid(grid,maxX,maxY,x+1,y,completeFlash);
				
				incGrid(grid,maxX,maxY,x-1,y+1,completeFlash);
				incGrid(grid,maxX,maxY,x  ,y+1,completeFlash);
				incGrid(grid,maxX,maxY,x+1,y+1,completeFlash);
							
				totalFlashes++;
			}
		}
		int ccFlashes = 0;
		for(int y = 0;y < maxY;y++)
		{
			for(int x = 0;x < maxX;x++)
			{			
				if (grid[x][y] == 0) ccFlashes++;
			}
		
		}
		System.out.println("step"); dumpGrid(grid,maxX,maxY); System.out.println(ccFlashes); 
		if (ccFlashes == maxX * maxY) {
			System.out.println("alle nach " + steps);
		}
	}

	private static void dumpGrid(int[][] grid, int maxX, int maxY) {
		for(int y = 0;y < maxY;y++)
		{
			for(int x = 0;x < maxX;x++)
			{
				System.out.print(grid[x][y]);
			}
			System.out.println();
		}
	}

	private static void incGrid(int[][] grid, int maxX, int maxY, int x, int y,ArrayList<XYPos> willFlash) 
	{
		if (x < maxX && y < maxY && x >= 0 && y >= 0)
		{
			XYPos p = new XYPos(x,y);
			if (!willFlash.contains(p))
				grid[x][y]++;
		}
	}
}
