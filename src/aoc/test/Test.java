package aoc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import aoc.jahr2022.XYPoint;

public class Test 
{
	public static void main1(String[] args) 
	{
		ArrayList<char[]> field = new ArrayList<>();
		
		String t = " abcdef";
		
		field.add(null); // Dummy for null
		field.add(t.toCharArray());
		field.add(t.toCharArray());
		field.add(t.toCharArray());

		char c = getField(field,1,1);
		System.out.println(c);
		
		
	}

	private static char getField(ArrayList<char[]> field, int i, int j) 
	{
		
		return field.get(j)[i];
	}	
	
	public static void main(String[] args) 
	{
		HashSet<String> ps = new HashSet<>();
		
		XYPoint p = new XYPoint(1,2);
		
		ps.add("A");
		
		System.out.println(ps);
		ps.add("A");
		
		System.out.println(ps);
	}
}
