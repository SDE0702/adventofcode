package aoc.jahr2022;

import java.util.Objects;

public class ElfXYPoint extends XYPoint 
{
	public int moveX;
	public int moveY;
	
	public ElfXYPoint(int x, int y) 
	{
		super(x,y);
	}
	
	@Override
	public String toString() {
		
		return super.toString() +  "(" + moveX + ";" + moveY + ")";
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
}
