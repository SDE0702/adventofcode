
public class Path 
{
	Knoten one;
	Knoten two;
	public Path(Knoten k1, Knoten k2) 
	{
		one = k1;
		two = k2;
	}
	public Knoten getOne() {
		return one;
	}
	public void setOne(Knoten one) {
		this.one = one;
	}
	public Knoten getTwo() {
		return two;
	}
	public void setTwo(Knoten two) {
		this.two = two;
	}
	@Override
	public String toString() {
		return one + " - " + two;
	}
	
	
}
