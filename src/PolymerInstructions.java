import java.util.Objects;

public class PolymerInstructions 
{
	String polymerpattern;
	String insert;
	
	public PolymerInstructions(String line) 
	{
		polymerpattern = line.substring(0,2);
		insert = line.substring(6,7);
	}

	public String getPolymerpattern() {
		return polymerpattern;
	}

	public void setPolymerpattern(String polymerpattern) {
		this.polymerpattern = polymerpattern;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

	@Override
	public String toString() {
		return polymerpattern + " -> " + insert;
	}

	@Override
	public int hashCode() {
		return Objects.hash(polymerpattern);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolymerInstructions other = (PolymerInstructions) obj;
		return Objects.equals(polymerpattern, other.polymerpattern);
	}	
	
	
}
