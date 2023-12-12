package aoc.jahr2022;

import java.util.Objects;

public class TextWithPos 
{
	public int pos;
	public int v;
	
	public TextWithPos(int pos, int v) {
		this.pos = pos;
		this.v = v;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pos, v);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextWithPos other = (TextWithPos) obj;
		return pos == other.pos && v == other.v;
	}
	
	@Override
	public String toString() 
	{
		return Integer.toString(v);
	}
}
