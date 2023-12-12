package aoc.jahr2023;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

import aoc.jahr2022.XYPoint;

public class Boiler {

	public String realInput = 
	"""
			
	""";
	
	public static String testInput = 
	"""
			
	""";
	
	public static String input = testInput;
	// static String input = realInput;
	
	public static void main(String[] args) throws Exception 
	{
		
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		
		ArrayList<XYPoint> points = new ArrayList<>();
		while (true)
		{
			String line = br.readLine();
			if (line == null) break;
			if (line.startsWith("#")) continue;
		}
	}
}
