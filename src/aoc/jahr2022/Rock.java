package aoc.jahr2022;

import java.util.ArrayList;

public class Rock 
{
	public ArrayList<XYPoint> massiv = new ArrayList<>();
	
	public int maxx = 0;
	public int maxy = 0;
	String toStringString = null;
	
	public Rock() 
	{
	}

	public Rock add(String s) 
	{
		String[] t1 = s.split(",");
		for(String t : t1)
		{
			String[] t2 = t.split(";");
			int x = Integer.parseInt(t2[0]);
			int y = Integer.parseInt(t2[1]);
			massiv.add(new XYPoint(x,y));
			maxx = Math.max(maxx, x);
			maxy = Math.max(maxy, y);
		}
		return this;
	}
	
	@Override
	public String toString() 
	{
		if (toStringString == null)
		{
			StringBuilder sb = new StringBuilder();
			for(int y = maxy;y >= 0;y--)
			{
				for(int x = 0;x <= maxx;x++)
				{
					XYPoint p = new XYPoint(x,y);
					if (massiv.contains(p))
					{
						sb.append('#');
					} else {
						sb.append('.');
					}
				}
				sb.append('\n');
			}
			toStringString = sb.toString();
		}
		return toStringString;
	}

	public int getMaxX() 
	{
		return maxx;
	}

	public int getMaxY() 
	{
		return maxy;
	}
}
