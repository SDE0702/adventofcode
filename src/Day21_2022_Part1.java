import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;

import aoc.jahr2022.Day21_Real_Input;
import aoc.jahr2022.TextWithPos;

public class Day21_2022_Part1 {

	private static String test =
"""			
root: pppw + sjmn
dbpl: 5
cczh: sllz + lgvd
zczc: 2
ptdq: humn - dvpt
dvpt: 3
lfqf: 4
humn: 5
ljgn: 2
sjmn: drzm * dbpl
sllz: 4
pppw: cczh / lfqf
lgvd: ljgn * ptdq
drzm: hmdt - zczc
hmdt: 32			
""";
	
	//	private static String input = test;
		private static String input = Day21_Real_Input.real;
	
	public static void main(String[] args) throws Exception 
	{
		HashMap<String,String> ops = new HashMap<String, String>();
		
		StringReader sr = new StringReader(input);
		BufferedReader br = new BufferedReader(sr);

		while (true)
		{
			String line = br.readLine();
			if (line == null) 
			{
				break;
			}
			if (line.startsWith("#")) continue;
			String[] t = line.split(":");
			ops.put(t[0].trim(),t[1].trim());
		}
		
		long result = calc(ops.get("root"),ops);
		
		System.out.println(result);
	}

	private static long calc(String op, HashMap<String, String> ops) throws Exception 
	{
		
		String[] t = op.split(" ");
		if (t.length == 1) return Long.parseLong(t[0]);
		long left = calc(ops.get(t[0]),ops);
		long right = calc(ops.get(t[2]),ops);
		
		switch (t[1])
		{
		case "+" : return Math.addExact(left, right);
		case "-" : return Math.subtractExact(left, right);
		case "*" : return Math.multiplyExact(left, right);
		case "/" : return left / right;
		default :
			throw new Exception("Unknow operator");
		}
	}
}
