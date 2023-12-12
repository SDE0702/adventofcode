package aoc.jahr2022;

public class CurrentXYPos {

	public int x;
	public int y;
	public CurrentXYPos(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		
		return x + ";" + y;
	}
}
