package aoc.jahr2022;

public class ElfStatusPoints 
{
	public ElfXYPoint oldPoint;
	public ElfXYPoint newPoint;

	public ElfStatusPoints(ElfXYPoint oldPoint, ElfXYPoint newPoint) 
	{
		this.oldPoint = oldPoint;
		this.newPoint = newPoint;
	}
	
	@Override
	public String toString() 
	{
		return "Move: " + oldPoint + " -> " + newPoint;
	}
	
}
