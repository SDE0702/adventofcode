import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;

public class Day14_Part2_2021
{

	private static String testInput = """
CH -> B
HH -> N
CB -> H
NH -> C
HB -> C
HC -> B
HN -> C
NN -> C
BH -> H
NC -> B
NB -> B
BN -> B
BB -> N
BC -> B
CC -> N
CN -> C
""";
	
	static String input = 
"""	
CP -> C
SF -> S
BH -> F
SS -> N
KB -> N
NO -> N
BP -> F
NK -> P
VP -> H
OF -> O
VH -> O
FV -> F
OP -> V
FP -> B
VB -> B
OK -> S
BS -> B
SK -> P
VV -> H
PC -> S
HV -> K
PS -> N
VS -> O
HF -> B
SV -> C
HP -> O
NF -> V
HB -> F
VO -> B
VN -> N
ON -> H
KV -> K
OV -> F
HO -> H
NB -> K
CB -> F
FF -> H
NH -> F
SN -> N
PO -> O
PH -> C
HH -> P
KF -> N
OH -> N
KS -> O
FH -> H
CC -> F
CK -> N
FC -> F
CF -> H
HN -> B
OC -> F
OB -> K
FO -> P
KP -> N
NC -> P
PN -> O
PV -> B
CO -> C
CS -> P
PP -> V
FN -> B
PK -> C
VK -> S
HS -> P
OS -> N
NP -> K
SB -> F
OO -> F
CV -> V
BB -> O
SH -> O
NV -> N
BN -> C
KN -> H
KC -> C
BK -> O
KO -> S
VC -> N
KK -> P
BO -> V
BC -> V
BV -> H
SC -> N
NN -> C
CH -> H
SO -> P
HC -> F
FS -> P
VF -> S
BF -> S
PF -> O
SP -> H
FK -> N
NS -> C
PB -> S
HK -> C
CN -> B
FB -> O
KH -> O
""";
	
	private static String startStringTest = "NN"; // "NNCB";
	private static String startString = "SCSCSKKVVBKVFKSCCSOV";

	private static HashMap<String, String> polymerinfo = new HashMap<String, String>(); 
	private static HashMap<Character, Long> countOfPolymers = new HashMap<Character, Long>(); 
	private static HashMap<Character, Long> countPolymersIntermediate;

	private static int maxRounds = 20;	
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);

/*		
		System.out.println(countChars("NCNBCHB"));
		System.out.println(countChars("NBCCNBBBCBHCB"));
		System.out.println(countChars("NBBBCNCCNBBNBNBBCHBHHBCHB"));
		System.out.println(countChars("NBBNBNBBCCNBCNCCNBBNBBNBBBNBBNBBCBHCBHHNHCBBCBHCB"));
System.exit(0);
*/
		String startString = startStringTest;
		while (true)
		{
			String line = br.readLine();
			if (line == null) break;
			String polymer = line.substring(0,2);
			String insert = line.substring(6,7);
			polymerinfo.put(polymer, insert);
			countOfPolymers.put(insert.charAt(0), 0L);
		}
		
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream("output.txt")));
		String s = br1.readLine();
		br1.close();

		for(int i = 0; i < s.length();i++)
		{
			incrementCounters(s.substring(i,i+1),countOfPolymers);
		}
		long l = System.nanoTime();

		HashMap<String, Integer> uniques = new HashMap<>();

		for(int i = 0; i < s.length() - 1;i++)
		{
			int depth = 0;
			String t = s.substring(i,i+2);
			
			Integer ccc = uniques.get(t);
			if (ccc == null) 
			{
				ccc = 1;
			} else {
				ccc++;
			}
			uniques.put(t,ccc);
		}

		System.out.println(uniques);

		for(String k : uniques.keySet())
		{
			int depth = 0;
			countPolymersIntermediate = new HashMap<>();
			for(Character p : countOfPolymers.keySet())
			{
				countPolymersIntermediate.put(p, 0L);
			}
			doInsert(k,depth,countPolymersIntermediate);
			
			for(Character p : countOfPolymers.keySet())
			{
				long v = countOfPolymers.get(p);
				long vi = countPolymersIntermediate.get(p);
				int mul = uniques.get(k);
				v = v + vi * mul;
				countOfPolymers.put(p,v);
			}
		}
		
		l = System.nanoTime() - l;
		System.out.println(countOfPolymers);
		System.out.println(l / 1000 / 1000 + " ms");
	}

	private static void incrementCounters(String c, HashMap<Character, Long> countOfPolymers)
	{
		countOfPolymers.put(c.charAt(0),countOfPolymers.get(c.charAt(0)) + 1);		
	}

	private static void doInsert(String s,int depth, HashMap<Character, Long> countPolymers) 
	{
//		System.out.print(depth + ") Check " + s);
		String v = polymerinfo.get(s);
		String t = s;
		if (v != null)
		{
			incrementCounters(v,countPolymers);			
			t = t.substring(0,1) + v + t.substring(1,2); 
		}
//		System.out.println(" -> " + v + " -> " + t);
		depth++;
		if (depth >= maxRounds)
		{
			return;
		}
		for(int i = 0;i < t.length() -1;i++)
		{
			String r = t.substring(i,i + 2);
			doInsert(r,depth,countPolymers);
		}			
	}

	
	private static HashMap<String, Long>  countChars(String s)
	{
		HashMap<String, Long> h = new HashMap<String, Long>();
		
		for(int i = 0;i < s.length();i++)
		{
			Long v = h.get(s.substring(i,i+1));
			if (v == null) v = 1L; else v++;
			h.put(s.substring(i,i+1),v);
		}
		
		return h;
	}
	
}
