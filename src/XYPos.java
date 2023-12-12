import java.util.Objects;

public class XYPos 
{
	int x;
	int y;
	public XYPos(String t) 
	{
		String[] tok = t.split(",");
		x = Integer.parseInt(tok[0]);
		y = Integer.parseInt(tok[1]);
	}
	public XYPos(int x,int y) 
	{
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return x + ";" + y;
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
		XYPos other = (XYPos) obj;
		return x == other.x && y == other.y;
	}
	
}
