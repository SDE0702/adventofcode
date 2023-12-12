package aoc.jahr2023.Day3;

public class NumbersInLineInfo 
{
	public NumbersInLineInfo(String s, int start, int end) 
	{
		number = Integer.valueOf(s);
		this.start = start;
		this.end = end;
	}
	public int number;
	public int start;
	public int end;
	
	
	@Override
	public String toString() 
	{
		return number + "(" + start + "," + end + ")";
	}
}
