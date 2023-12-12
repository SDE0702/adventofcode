package aoc.jahr2022;

import java.util.Objects;

public class XYZPoint extends XYPoint 
{
	public int z;
	
	public XYZPoint() 
	{
		super();	
	}

	public XYZPoint(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(z);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		XYZPoint other = (XYZPoint) obj;
		return z == other.z;
	}
	
}
