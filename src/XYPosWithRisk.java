import java.util.Objects;

public class XYPosWithRisk extends XYPos 
{
	int risk = 0;

	public XYPosWithRisk(int x, int y, int risk) {
		super(x,y);
		this.risk = risk;
	}

	@Override
	public String toString() 
	{
		return super.toString() + "#" + risk;
	}

	public int getRisk() {
		return risk;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(risk);
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
		XYPosWithRisk other = (XYPosWithRisk) obj;
		return risk == other.risk;
	}

}
