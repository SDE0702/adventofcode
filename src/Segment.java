
public class Segment 
{
	XYPos start;
	XYPos end;
	
	public Segment(String line) 
	{
		// x1,y1 -> x2,y2 
		// 0,9 -> 5,9
		int pos = line.indexOf(" -> ");
		String t1 = line.substring(0,pos);
		String t2 = line.substring(pos + 4);
		
		start = new XYPos(t1);
		end = new XYPos(t2);
	}
	
	public static void main(String[] args) 
	{
		Segment s = new Segment("0,9 -> 5,9");
		System.out.println(s);
	}

	public XYPos getStart() {
		return start;
	}

	public void setStart(XYPos start) {
		this.start = start;
	}

	public XYPos getEnd() {
		return end;
	}

	public void setEnd(XYPos end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Segment [start=" + start + ", end=" + end + "]";
	}

	
}
