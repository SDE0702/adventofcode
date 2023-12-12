import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Day14_Part1_2021 
{

	static String testInput1 = 
"""
NNCB

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
	static String testInput2 = 
"""
""";	

	static String testInput3 = 
"""
""";
	
	static String input = 
"""	
SCSCSKKVVBKVFKSCCSOV

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
	
	static HashMap<String,String> polymers = new HashMap<>();
	
	public static void main(String[] args) throws Exception 
	{
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);
		String startpattern = "";
		int i = 0;
		
		while (true)
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			if (i == 0)
			{
				i++;
				startpattern = line;
				continue;
			}
			if (i++ == 1) continue;
			polymers.put(line.substring(0,2),line.substring(6,7));
		}
		System.out.println(startpattern);
		System.out.println(polymers);
		
		int runde = 0;
		String s = startpattern;
		while (runde++ < 20)
		{
			s = doInserts(s);
			System.out.println("Runde:" + runde + " length=" + s.length());
		}
		
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"))))
		{
			int pos = 0;
			while (pos < s.length())
			{
				int end = Math.min(pos + 10, s.length());
				bw.write(s.substring(pos,end));
				pos = end;
			}
		}
		
		// Counts
		HashMap<Character, Integer> counts = new HashMap<>();
		for(i = 0;i < s.length();i++)
		{
			char c = s.charAt(i);
			
			Integer v = counts.get(c);
			if (v == null) 
			{
				v = 1;
			} else {
				v++;
			}
			counts.put(c,v);
		}
		ArrayList<Integer> cc = new ArrayList<>(counts.values());
		
		Collections.sort(cc);
		System.out.println(cc.get(cc.size() - 1) - cc.get(0));
		
		
	}

	private static String doInserts(String s) 
	{
		StringBuilder newS = new StringBuilder();
		newS.append(s.substring(0,1));
		for(int i = 0; i < s.length() - 1;i++)
		{
			String check = s.substring(i,i+2);
			String v = polymers.get(check);
			if (v != null)
			{
				check = v + check.substring(1,2);
			}
			newS.append(check);
		}
		
		return newS.toString();
	}		
}