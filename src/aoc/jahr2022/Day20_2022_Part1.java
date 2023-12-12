package aoc.jahr2022;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Day20_2022_Part1 
{
	private static String real = Day20_RealInput.real;
	private static String testInput = 
"""
1
2
-3
3
-2
0
4		
""";

	private static String input = real;
	private static boolean debug = false;
	public static void main1(String[] args) throws Exception 
	{
		ArrayList<TextWithPos> text = new ArrayList<TextWithPos>();
		
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		int pos = 0;
		while (true)
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			if (line.startsWith("#")) continue;
			TextWithPos twp = new TextWithPos(pos,Integer.parseInt(line));
			text.add(twp);
		}
		
		ArrayList<TextWithPos> backup = new ArrayList<TextWithPos>(text);
		int modop = text.size();
		
		for(int i = 0;i < backup.size();i++)
		{
			if (i == 4)
			{
				i = i +1 -1;
			}
			TextWithPos p = backup.get(i);
			
			int idx = text.indexOf(p);

			int idxnew = echtesMod(idx + p.v,modop);

			
			if (idxnew == 0)
			{
				text.add(p);
				text.remove((idx));
			} else {
				if (p.v < 0) idxnew--;					
				
				if (idxnew < idx)
				{
					text.add(idxnew + 1,p);
					text.remove((idx+1));
				} else {
					text.add(idxnew+1,p);
					text.remove((idx));
				}
			}
			if (debug)
			{
			System.out.println(i);
			System.out.println();
			System.out.println(text.toString().replace("[","").replace("]",""));
			}
		}
		
//		System.out.println(text);
//		System.exit(0);
		System.out.println(text.toString().replace("[","").replace("]",""));

		int afterNull = 0;
		for(int i = 0;i < text.size();i++)
		{
			if (text.get(i).v == 0)
			{
				afterNull = i;
				break;
			}
		}
		// 4 -3 und 2
		int sum = 0;
		for(int i = 0;i <= 3001;i++)
		{
			if (afterNull == text.size()) afterNull = 0;
			if (i == 1000)
			{
				sum += text.get(afterNull).v;
				System.out.println("1000th: " + text.get(afterNull).v);
			} else if (i == 2000)
			{
				sum += text.get(afterNull).v;
				System.out.println("2000th: " + text.get(afterNull).v);
			} else if (i == 3000)
			{
				sum += text.get(afterNull).v;
				System.out.println("2000th: " + text.get(afterNull).v);
			}
			afterNull++;
		}
		System.out.println("Sum: " + sum);
	}

	private static int echtesMod(int v, int modop) 
	{
		int x = v % modop;
		if (x < 0)
		{
			x += modop;
		}
		return x;
	}
	
	public static void maintest(String[] args)  
	{
		for(int i = -10;i < 10;i++)
		{
			System.out.println(i + "  " + echtesMod(i, 6));
		}
	}
	
	public static void main(String[] args) throws Exception 
	{
		main1(args);
	}
}
