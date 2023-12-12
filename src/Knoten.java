import java.util.Objects;

public class Knoten 
{
	String name;
	boolean largeKnoten;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLargeKnoten() {
		return largeKnoten;
	}
	public void setLargeKnoten(boolean largeKnoten) {
		this.largeKnoten = largeKnoten;
	}
	
	public Knoten(String name) 
	{
		this.name = name;
		largeKnoten = name.equals(name.toUpperCase());
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knoten other = (Knoten) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return name;
	}
	
	
}
