package aoc.jahr2021;

import java.util.ArrayList;

import aoc.jahr2022.XYPoint;

public class Day17_2021 
{
//	target area: x=20..30, y=-10..-5  // Test
//  target area: x=195..238, y=-93..-67 // Real	
/*	
	private static int xmin = 20;
	private static int xmax = 30;
	private static int ymin = -10;
	private static int ymax = -5;
*/	

  	private static int xmin = 195;
 
	private static int xmax = 238;
	private static int ymin = -93;
	private static int ymax = -67;

	
	private static String listOKs = """
	23,-10  25,-9   27,-5   29,-6   22,-6   21,-7   9,0     27,-7   24,-5
	25,-7   26,-6   25,-5   6,8     11,-2   20,-5   29,-10  6,3     28,-7
	8,0     30,-6   29,-8   20,-10  6,7     6,4     6,1     14,-4   21,-6
	26,-10  7,-1    7,7     8,-1    21,-9   6,2     20,-7   30,-10  14,-3
	20,-8   13,-2   7,3     28,-8   29,-9   15,-3   22,-5   26,-8   25,-8
	25,-6   15,-4   9,-2    15,-2   12,-2   28,-9   12,-3   24,-6   23,-7
	25,-10  7,8     11,-3   26,-7   7,1     23,-9   6,0     22,-10  27,-6
	8,1     22,-8   13,-4   7,6     28,-6   11,-4   12,-4   26,-9   7,4
	24,-10  23,-8   30,-8   7,0     9,-1    10,-1   26,-5   22,-9   6,5
	7,5     23,-6   28,-10  10,-2   11,-1   20,-9   14,-2   29,-7   13,-3
	23,-5   24,-8   27,-9   30,-7   28,-5   21,-10  7,9     6,6     21,-5
	27,-10  7,2     30,-9   21,-8   22,-7   24,-9   20,-6   6,9     29,-5
	8,-2    27,-8   30,-5   24,-7""";

	public static void mainCheckAllPoints(String[] args) throws Exception
	{
		ArrayList<XYPoint> diffs = new ArrayList<>();
		for(String l : listOKs.split("\n"))
		{
			String[] toks = l.split(" ");
			for(String c : toks)
			{
				if (c.trim().length() > 0)
				{
					String[] xyt = c.trim().split(",");
					diffs.add( new XYPoint( Integer.parseInt(xyt[0]) , Integer.parseInt(xyt[1]) ));
				}
			}
		}
		System.out.println(diffs.size());
		
		for(XYPoint p : diffs)
		{
			ArrayList<XYPoint> points = new ArrayList<>();
			boolean isin = shot(p.x,p.y,points);
			if (!isin)
			{
				System.out.println("Bei:" + p);
				outputShot(points);
			}

		}
	}
	public static void main(String[] args) {
		mainCalc(args);
	}
	
	public static void mainCalc(String[] args) 
	{
		int totalMaxShot = Integer.MIN_VALUE;
		int byXDiff = 0;
		int byYDiff = 0;
		int isincc =0;
		for(int xdiff = 0;xdiff < xmax + 100 ;xdiff++)
		{
			for(int ydiff = xmax*4;ydiff > ymin - 10;ydiff--)
			{
				
				ArrayList<XYPoint> points = new ArrayList<>();
				boolean isin = shot(xdiff,ydiff,points);

				if (isin)
				{
					isincc++;
					int maxYShot = points.stream().max((p1,p2) -> p1.y-p2.y).get().y;
		
					if (maxYShot > totalMaxShot)
					{
						byXDiff = xdiff;
						byYDiff = ydiff;
						totalMaxShot = maxYShot;
					}
				}
			}
		}
		System.out.println(totalMaxShot + " by " + byXDiff + ";" + byYDiff);
		System.out.println("Is in:" + isincc);
	}

	private static void outputShot(ArrayList<XYPoint> points) 
	{
		for(int y = 10;y > ymin * 2;y--)
		{
			for(int x = 0;x < xmax * 1.5;x++)
			{
				if (x == 0 && y == 0) 
				{
					System.out.print("S");
				} else
				{
					XYPoint p = new XYPoint(x, y);
				
					if (points.contains(p)) 
					{
						System.out.print("#");
					} else {
					    if (between(x,xmin,xmax) && between(y,ymin,ymax)) 
				    	{
					    	System.out.print("T");
				    	} else {
				    		System.out.print(".");
				    	}
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean shot(int xdiff, int ydiff,ArrayList<XYPoint> points) 
	{
		int x = 0;
		int y = 0;
		while (true)
		{
			x += xdiff;
			y += ydiff--;
			if (xdiff > 0) xdiff--;
			
			points.add(new XYPoint(x,y));
			if (between(x,xmin,xmax) && between(y,ymin,ymax)) {
				return true;
			}
			if (x > xmax || y < ymin) return false;
		}
	}

	private static boolean between(int v, int min, int max) 
	{
		return v >= min && v <= max;
	}

	
}
