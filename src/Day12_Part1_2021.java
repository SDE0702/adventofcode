import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;

public class Day12_Part1_2021 
{

	static String testInput1 = 
"""
start-A
start-b
A-c
A-b
b-d
A-end
b-end	 	
""";
	static String testInput2 = 
"""
dc-end
HN-start
start-kj
dc-start
dc-HN
LN-dc
HN-end
kj-sa
kj-HN
kj-dc		
""";	

	static String testInput3 = 
"""
fs-end
he-DX
fs-he
start-DX
pj-DX
end-zg
zg-sl
zg-pj
pj-he
RW-he
fs-DX
pj-RW
zg-RW
start-pj
he-WI
zg-he
pj-fs
start-RW	
""";
	
	static String input = 
"""	
DA-xn
KD-ut
gx-ll
dj-PW
xn-dj
ll-ut
xn-gx
dg-ak
DA-start
ut-gx
YM-ll
dj-DA
ll-xn
dj-YM
start-PW
dj-start
PW-gx
YM-gx
xn-ak
PW-ak
xn-PW
YM-end
end-ll
ak-end
ak-DA		
""";
	
	static ArrayList<Knoten> knoten = new ArrayList<>();
	static ArrayList<Path> pathes = new ArrayList<>();
	static ArrayList<ArrayList<Knoten>> allPathes = new ArrayList<ArrayList<Knoten>>();
	static Knoten start = new Knoten("start"); 
	static Knoten end = new Knoten("end"); 
			
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		
		while (true)
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			String[] tok = line.split("-");
			
			Knoten k1 = new Knoten(tok[0]);
			Knoten k2 = new Knoten(tok[1]);
			if (!knoten.contains(k1)) knoten.add(k1);
			if (!knoten.contains(k2)) knoten.add(k2);
			pathes.add(new Path(k1,k2));
		}
		System.out.println(knoten);
		System.out.println(pathes);
		
		for(Path p : pathes)
		{
			Knoten toGo;
			if (p.getOne().equals(start))
			{
				toGo = p.getTwo();
			} else 	if (p.getTwo().equals(start))
			{		
				toGo = p.getOne();
			} else {
				continue;
			}

			ArrayList<Knoten> dontGoAgain = new ArrayList<Knoten>();
			ArrayList<Knoten> onePath = new ArrayList<Knoten>();
			dontGoAgain.add(start);
			onePath.add(start);
			findPathPart2(toGo,onePath,dontGoAgain);
		}
		System.out.println(allPathes);
		System.out.println(allPathes.size());
	}
	/* testoutput 1
	 * start,A,b,A,c,A,end
	start,A,b,A,end
	start,A,b,end
	start,A,c,A,b,A,end
	start,A,c,A,b,end
	start,A,c,A,end
	start,A,end
	start,b,A,c,A,end
	start,b,A,end
	start,b,end	
	 */
	private static void findPath(Knoten k,ArrayList<Knoten> onePath,ArrayList<Knoten> dontGoAgain) 
	{
		onePath.add(k);
		if (!k.largeKnoten) dontGoAgain.add(k);
		for(Path p : pathes)
		{
			Knoten toGo;
			if (p.getOne().equals(k))
			{
				if (!dontGoAgain.contains(p.getTwo()))
				{
					toGo = p.getTwo();
				} else {
					continue;
				}
			} else if (p.getTwo().equals(k))
			{
				if (!dontGoAgain.contains(p.getOne()))
				{
					toGo = p.getOne();
				} else {
					continue;
				}
			} else {
				continue;
			}
			if (!k.equals(end))
			{
				ArrayList<Knoten> onePathNew = new ArrayList<Knoten>(onePath);
				ArrayList<Knoten> dontGoAgainNew = new ArrayList<Knoten>(dontGoAgain);
				findPath(toGo,onePathNew,dontGoAgainNew);
			}
		}
		if (onePath.get(onePath.size()-1).equals(end))
		{
			allPathes.add(onePath);
		}
	}

	private static void findPathPart2(Knoten k,ArrayList<Knoten> onePath,ArrayList<Knoten> dontGoAgain) 
	{
		onePath.add(k);
		if (!k.largeKnoten) dontGoAgain.add(k);
		for(Path p : pathes)
		{
			Knoten toGo;
			if (p.getOne().equals(k))
			{
				if (!checkDontAgain(dontGoAgain,p.getTwo()))
				{
					toGo = p.getTwo();
				} else {
					continue;
				}
			} else if (p.getTwo().equals(k))
			{
				if (!checkDontAgain(dontGoAgain,p.getOne()))
				{
					toGo = p.getOne();
				} else {
					continue;
				}
			} else {
				continue;
			}
			if (!k.equals(end) && !k.equals(start))
			{
				ArrayList<Knoten> onePathNew = new ArrayList<Knoten>(onePath);
				ArrayList<Knoten> dontGoAgainNew = new ArrayList<Knoten>(dontGoAgain);
				findPathPart2(toGo,onePathNew,dontGoAgainNew);
			}
		}
		if (onePath.get(onePath.size()-1).equals(end))
		{
			allPathes.add(onePath);
		}
	}
	
	private static boolean checkDontAgain(ArrayList<Knoten> dontGoAgain,Knoten l) 
	{
		if (l.isLargeKnoten()) return false;
		if (l.equals(start)) return true;
		ArrayList<Knoten> checklist = new ArrayList<Knoten>();	
		for(Knoten k : dontGoAgain)
		{
			if (checklist.contains(k)) 
			{
				if (dontGoAgain.contains(l))
				{
					return true;
				}
				return false;
			}
			checklist.add(k);
		}
		return false;
	}

}