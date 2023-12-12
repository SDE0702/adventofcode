
public class Fish 
{
	byte cyclevalue;
	public Fish(byte init) 
	{
		cyclevalue = init;
	}
	
	boolean decrementCycle()
	{
		cyclevalue--;
		if (cyclevalue < 0)
		{
			cyclevalue = 6;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() 
	{
		return Integer.toString(cyclevalue);
	}
}
