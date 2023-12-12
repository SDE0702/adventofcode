package aoc.jahr2022;

import java.util.ArrayList;
import java.util.Objects;

public class XYPoint 
{
	public int x;
	public int y;
	public char tag;
	public XYPoint() {
		
	}
	
	public XYPoint(int x,int y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public XYPoint(int x,int y,char tag) 
	{
		this.x = x;
		this.y = y;
		this.tag = tag;
	}

	@Override
	public String toString() {
		
		return x + ";" + y + (tag != 0 ? ";" + tag : "");
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		XYPoint other = (XYPoint) obj;
		return x == other.x && y == other.y;
	}

	public boolean contains(ArrayList<XYPoint> points, int x, int y) 
	{
		XYPoint p = new XYPoint(x, y);
		return points.contains(p);
	}
}
