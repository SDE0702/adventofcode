package aoc.jahr2018;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

import aoc.jahr2022.XYPoint;

public class Day6_Part1 
{
	private static String real =
"""

""";	
			
	private static String test =
"""
1, 1
1, 6
8, 3
3, 4
5, 5
8, 9		
""";	
	private static String input = test;
	
	
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		
		ArrayList<XYPoint> points = new ArrayList<>();
		char tag = 'A';
		while (true)
		{
			String line = br.readLine();
			if (line == null) break;
			if (line.startsWith("#")) continue;
			String[] tok = line.split(",");
			points.add(new XYPoint(Integer.parseInt(tok[0].trim()), Integer.parseInt(tok[1].trim()),tag++));
		}

		System.out.println(points);
		printSystem(points);
		
		
		
	}
	
	private static void printSystem(ArrayList<XYPoint> points)
	{
		int maxy = points.stream().max((p1,p2) -> p1.y -p2.y).get().y;
		int maxx = points.stream().max((p1,p2) -> p1.x -p2.x).get().x;
		
		// Zeilen 
		int zeilen = (int)Math.floor(Math.log10(maxx)) + 1;
		int charsY = (int)Math.floor(Math.log10(maxy)) + 1;

		int teiler = (int)Math.pow(10,zeilen - 1);
		for(int i = 0;i < zeilen;i++)
		{
			System.out.print(" ".repeat(charsY + 1));
			for(int x = 0;x <= maxx;x++)
			{
				int zz = x / teiler % 10;
				System.out.print(zz);
			}
			System.out.println();
			teiler /= 10;
		}

		System.out.print(" ".repeat(charsY));
		for(int x = 0;x <= maxy + 1;x++)
		{
			System.out.print("-");
		}
		System.out.println();
		for(int y = 0;y <= maxy;y++)
		{
			String ys = Integer.toString(y);
			ys = " ".repeat(charsY - ys.length()) + ys;
			System.out.print(y);
			System.out.print("|");
			for(int x = 0;x <= maxx;x++)
			{
				int idx = points.indexOf(new XYPoint(x,y));
				char tag;
				if (idx != -1)
				{
					XYPoint p = points.get(idx);
					tag = p.tag;
				} else {
					tag = '.';
				}
				System.out.print(tag);
			}
			System.out.println("|");
		}
		System.out.print(" ".repeat(charsY));
		for(int x = 0;x <= maxy + 1;x++)
		{
			System.out.print("-");
		}
		System.out.println();
		
	}
	
}
