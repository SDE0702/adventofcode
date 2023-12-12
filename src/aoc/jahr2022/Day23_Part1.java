package aoc.jahr2022;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Day23_Part1 
{

	private static String test = 
"""
..............
..............
.......#......
.....###.#....
...#...#.#....
....#...##....
...#.###......
...##.#.##....
....#..#......
..............
..............
..............
""";
	public static String real = 
"""	
...##.##..###.#.#....#.#######...###..#.##.#..##...#..####...#..#.##...#.#
..#.#..##.###.#..#...##....##....#..#.####...#####.#.#..#...##..#.#.#.####
#.##.##.###....#..#.#..##...##..#..#.#####.###..#.#.....####.#...#.###.##.
#.####..#.####..#.#..#####.##....##..##..##....#......#...##..#..##....###
###.#.###..####...###.###.##...#..##.#.#...##.###..##.##.##.....####..##..
#...####.#..#.#.##.#.##.#.#.####..####...#..#..##..#.#..##...#....##...##.
..#.#.##..#.##..#.#####.##..#.....###..###.#...###.#.####.###.#.#..#..##.#
##...###.###...##.###.#..#...#....#.##.#....##..#....##...#.#.#.##.....#.#
#..##.#.##..#.#..##.#.###.###....#..##...#..########..#.#..##.....##..####
##.#...#.....###..##..###.#.##..###.##.#.#..##.####.#.#.#.#..##..#...##..#
###....#.....#..##......#####...#.#.#.##.##.###.#.####.....#.#.#####....#.
.##..##..##.#..#....#.#.##.###.###....######.....###.##..######..####.#...
#..#.....##...#...#........##..##.#..##.###.##...#.####...###.#.#.##...#..
...#..#..##..#.#..##..#.###..#.#..#..#..#.######..##.#####..#...#...#.##.#
##.#.....#..#...#####.#.###..#.......#..###.##.##.##.##.###.####.#....#.#.
.##..#..##..#....#..####.##.#..########...##..##.#..#..#.###..###.........
###.#..#####.####.#....####.#####.##...#####.#.#.###.#.#.####........#..##
.##..#...###....####.##.####.#...##.....##.#..####...####..#.#...###..##..
...#.##.###.......##.#..#.#..###..#...##...#..#.###......#..##.#..##.#####
#..##..#.##..#..#..#.#.###.###.####.###.#.#.....#.....#...##...##....#...#
...##.##.##.####.##.....#.##....#.#.....#.#..##.####.###.####.##.......###
#.######....########..#...##.#.##....#...####..#.#..#....#....#...#####..#
...#.###..####..#.#####...#.##...#.###..#.#.####..######...####...#.###.#.
..###.####.#..#.#...##.##...#...#.#.#.#.#.#####.#...##..#....###.#.###..##
.#.#.#..###.....#...###......#.####..##..#.#..####.#.####..##..#.#######.#
.###.####.##..#.##..#...#...#.##.#..##....#.##.....##.#...#.###.##.##....#
..#.####..#.#.##.###..######..#####.###.#...#...###..#.#########.##..#.#.#
...###.#.###..#.#...##.#....##...#.#....#..#..#.##.#.###...#..#..#..#..#.#
.##.....###..#####.#.#######..###.###..##..##..#.#.#.#.###..#..#.#.####..#
...##...#..#...##..###..#..#..####...##.#.......#.##..##.#....###.##.##.#.
.....##.#...#..#.##...##.##.##.##..#...#.#.##..#.....##.###..###.####..###
..###..##..#..#.##.##..#....###.#..#..............#..#.#......#.##.##..###
##....##..##..####.#.##...#.......#..#.##.#..####.###.......##..#.##.##..#
##############.#.######..#.#....###..##.#....#.#.#.#.......#.##..#..#....#
#.####...#.####.#.#...##.#.#...##...##......###..###...##.#.##..#.#.#..###
#......#.#..#.#.....##..#.....##########.##.#....#.##.#.##...#.#.......#..
###.###....####.##.#####.####.#....#.......#....##...###..###.#...##..#.#.
..##.##...###.#..#....##.##..#....#...#.#.####..##...#.##.#####.###..###.#
.#.#..#####..#.#....#..#.#...#......#....#.#..#.####.#.#...#...#....####..
##.#.##.###.##.#....###..#.#..#.###.##.#....#.#.##..#..##.###..#..##.###..
.####..##.#.#.#####.#######.##....#.##..#####..#####.#....#.##.###........
#####....#....#######.#.##.#.##.....####.###..##.#.#....#.#.######.#.#....
...#.#...#.#..#....#.......#.##.#.#.##...#..#.#####..##.#..#..#.#....##.#.
..#.####.##.#.....###.###.#...#####...#..###.#..#...##.##..#.#..#.##..#.##
.#######..#.#.###.#.....#...#######..#...#....##..#.#...#.....##.##.#####.
#.##..#####.....##.###.###...###.##.#..#..#....#.#.####..##..#.###..##...#
#.##.#..##.#.....#...##..##..##.#.#...####..#...####.#...##....##..##.####
#.###.#..##.############...#...#####....###..#..#.##.##..#.##...#.##......
..#..####.#...#.####.#.#.#.#..#..#.##.#.##..##...###...#..##..#.###..#....
##.####.####...#......####.###...#...###....#.###.#..#.#....####..#....###
..#.#..#..#.....#.....#.###.#.##..#.####...##.#..#.##..#######.#...###.#.#
..#.#.###.##.##..###..##.##.#.....#..####.#######....##...#.....#..#....##
...#..###.##.####.#..##.#####.###.#####.#..#.#..#..##.##.######.#.#.#.#.#.
#.###...#####..#.....#..#.#...##...#####.#..##.######..#..###.#....##..##.
#...#...#......#....#.#....##...###.#....#.....###.#.#...##...##.#.#..##..
#...#..###.#.#.#..#..###.#.##.##..#..##..##.##..#...#.#..####.##.##.###.##
#..##.#...#..#.##..#..##...###.##.##.##.#.####.#.......##...##.#..####..##
##.###.#.#..######.##.##.##..##....#.##.#....####.....##.##.#..##.#.#####.
###.#.##...###.#####..#.##.##.#..#.#...#.....####.....#..###....#.....#.#.
#.#####.#..#.#.#...#....#.#.##...##.##.##..#...#.####.#.#..#....#.#.#.#...
#..###.####.###.##..##..........##..##.#...#.##.#....##.##.#....#########.
.##.#.#..####...#.........#...##.#...##.###.#.###.####.##....##.#.#....#..
.....####..#..##..##..#..##..###.#.#.#.#..#.#.#..##.#..#.###..#..#.#..#.#.
#...#.#.#......#..#.#...##.##.##....#..#.#.#.#.#.###..#.#...#.#.#.##..#...
..##.#.##..#...#.#####.#####.....#.....#.##...#..##.###.#.#############.##
.##..#.#.#####..#.#.#.#...####.#######.###...#########..####...#..##.....#
#....#..#...###..#.#.####..#....#.#.####.....###..###..####...##......#.#.
..........#...#.#....#..###..#..#.##..##.#..#...#.#.#....#.##...####.#....
##..#.#.#.###..#####.#..#..#....#.#.#..#....##.#.####.#.##..##.#######..##
###..###..#..##..#.#..#..####......##.#######.#..####.#.#.##.......#.#...#
..#.#.###.#.##...#.#...###..#######..##.###.###..##.#.....##.#..#.#.##....
#.###...#####.##...###..#..#.#..#.##...##..##..#.#....####.#.##.##.###.#.#
#.#..###.#..#..#.#.##...#.######......###.##.#.##......######.##..#######.
###.####.#...#..#####..##....##.#.#....#.##..#.##..##..##.....###.##.#..##	
""";
	private static String input = real;
//	private static String input = test;
	private static int rounds = 10;
	 
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		
		HashSet<ElfXYPoint> elfs = new HashSet<>(); 
		int y = 0;
		int x = 0;
		while (true)
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			if (line.startsWith("|")) continue;

			for(int i = 0;i < line.length();i++)
			{
				if (line.charAt(i) == '#')
				{
					elfs.add(new ElfXYPoint(x+i,y));
				}
			}
			y++;
		}
	
		printStatus(elfs);
		for(int r = 1;r <= rounds;r++)
		{
			elfs = play(elfs);
			System.out.println("== End of Round " + r + " ==");
//			printStatus(elfs);
			checkPermutationsCounter++;
		}
		printStatus(elfs);
		int minx = elfs.stream().min((p1,p2) -> p1.x -p2.x).get().x;
		int maxx = elfs.stream().max((p1,p2) -> p1.x -p2.x).get().x;
		int miny = elfs.stream().min((p1,p2) -> p1.y -p2.y).get().y;
		int maxy = elfs.stream().max((p1,p2) -> p1.y -p2.y).get().y;
		
		System.out.println("Xdim :" + (maxx - minx));
		System.out.println("ydim :" + (maxy - miny));
		
		System.out.println("Prod:" + (maxx - minx) * (maxy - miny));
		
	}
/*
 * Check reihenfolge
 *  If there is no Elf in the N, NE, or NW adjacent positions, the Elf proposes moving north one step.
	If there is no Elf in the S, SE, or SW adjacent positions, the Elf proposes moving south one step.
	If there is no Elf in the W, NW, or SW adjacent positions, the Elf proposes moving west one step.
	If there is no Elf in the E, NE, or SE adjacent positions, the Elf proposes moving east one step.
 */


	private static int checkPermutationsCounter = 0;
	private static HashSet<ElfXYPoint> play(HashSet<ElfXYPoint> elfs) 
	{
		HashSet<ElfXYPoint> newElfs = new HashSet<>();
		ArrayList<ElfStatusPoints> status = new ArrayList<>();
		
		for(ElfXYPoint p : elfs)
		{
			if (p.x == 8 && p.y == 3)
			{
				p.x = p.x  +1 -1;
			}
			p.moveX = 0;
			p.moveY = 0;
			boolean n,o,s,w,nw,no,sw,so;
			
			n = checkFree(elfs,p,0,-1);
			o = checkFree(elfs,p,1,0);
			s = checkFree(elfs,p,0,1);
			w = checkFree(elfs,p,-1,0);
			
			nw = checkFree(elfs,p,-1,-1);
			no = checkFree(elfs,p,1,-1);
			sw = checkFree(elfs,p,-1,1);
			so = checkFree(elfs,p,1,1);

			if (!(n && o && s && w &&
				nw && no && sw && so))
			{
				switch (checkPermutationsCounter % 4)
				{
				case 0:
					if (nw && n && no) p.moveY = -1; else
					if (sw && s && so) p.moveY =  1; else
					if (nw && w && sw) p.moveX = -1; else
					if (no && o && so) p.moveX =  1;
					break;
				case 1:
					if (sw && s && so) p.moveY =  1; else
					if (nw && w && sw) p.moveX = -1; else
					if (no && o && so) p.moveX =  1; else
					if (nw && n && no) p.moveY = -1; 
					break;
				case 2:
					if (nw && w && sw) p.moveX = -1; else
					if (no && o && so) p.moveX =  1; else
					if (nw && n && no) p.moveY = -1; else
					if (sw && s && so) p.moveY =  1; 
					break;
				case 3:
					if (no && o && so) p.moveX =  1; else
					if (nw && n && no) p.moveY =  -1; else
					if (sw && s && so) p.moveY =   1; else
					if (nw && w && sw) p.moveX =  -1;
					break;
				}
				if (p.moveX != 0 || p.moveY != 0)
				{
					ElfXYPoint newPoint = new ElfXYPoint(p.x + p.moveX,p.y + p.moveY);
					status.add(new ElfStatusPoints(p,newPoint));
				}
			}
		}		
		// Skiping
		for(int i = 0;i < status.size();i++)
		{
			for(int j = i + 1;j < status.size();j++)
			{
				if (status.get(i).newPoint.equals(status.get(j).newPoint))
				{
					status.get(i).oldPoint.moveX = 0;
					status.get(i).oldPoint.moveY = 0;
					status.get(j).oldPoint.moveX = 0;
					status.get(j).oldPoint.moveY = 0;
				}
			}
		}
		// move!
		for(ElfXYPoint p : elfs)
		{
			newElfs.add(new ElfXYPoint(p.x + p.moveX,p.y + p.moveY));
		}
		return newElfs;
	}



	private static boolean checkFree(HashSet<ElfXYPoint> elfs,ElfXYPoint p, int diffx, int diffy) 
	{
		ElfXYPoint pn = new ElfXYPoint(p.x+diffx,p.y+diffy);
		return  !elfs.contains(pn);
	}
	
	private static void printStatus(HashSet<ElfXYPoint> elfs)
	{
		int minx = Math.min(1, elfs.stream().min((p1,p2) -> p1.x -p2.x).get().x);
		int maxx = Math.max(14, elfs.stream().max((p1,p2) -> p1.x -p2.x).get().x);
		int miny = Math.min(1, elfs.stream().min((p1,p2) -> p1.y -p2.y).get().y);
		int maxy = Math.max(12, elfs.stream().max((p1,p2) -> p1.y -p2.y).get().y);
		
		for(int y = miny; y <= maxy;y++)
		{
			for(int x = minx;x <= maxx;x++)
			{
				ElfXYPoint p = new ElfXYPoint(x, y);
				if (elfs.contains(p))
				{
					System.out.print("#");
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}



















