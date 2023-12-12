package aoc.jahr2022;
import java.io.BufferedReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;

import aoc.jahr2022.Day21_Real_Input;
import aoc.jahr2022.TextWithPos;

public class Day21_2022_Part2 {

	private static String test =
"""			
root: pppw - sjmn
dbpl: 5
cczh: sllz + lgvd
zczc: 2
ptdq: humn - dvpt
dvpt: 3
lfqf: 4
humn: 301
ljgn: 2
sjmn: drzm * dbpl
sllz: 4
pppw: cczh / lfqf
lgvd: ljgn * ptdq
drzm: hmdt - zczc
hmdt: 32			
""";
	
	// private static String input = test; // 301
		private static String input = Day21_Real_Input.real_part2;
	
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
	
		long x = 0;
		String humnLabel = "humn";
		long inc = x / 2;
		
		// 3876000000000;343079324
		// 3877000000000;-12271900100
		
		for(x = 3876027196000L;x <= 3876027197000L;x += 1)
		{
			ops.put(humnLabel, Long.toString(x));
			BigInteger result1 = calc(ops.get("root"),ops);
			System.out.println(x + ";" + result1);
			
/*			if (result1.longValue() == 0 || inc <= 2) break;
			if (result1.longValue() < 0) x = x - inc;
			if (result1.longValue() > 0) x = x + inc;
			inc = inc / 2;
*/			
		}
		
	}

	private static BigInteger calc(String op, HashMap<String, String> ops) throws Exception 
	{
		
		String[] t = op.split(" ");
		if (t.length == 1) return BigInteger.valueOf(Long.parseLong(t[0]));
		BigInteger left = calc(ops.get(t[0]),ops);
		BigInteger right = calc(ops.get(t[2]),ops);
		
		switch (t[1])
		{
		case "+" : return left.add(right);
		case "-" : return left.subtract(right);
		case "*" : return left.multiply(right);
		case "/" : return left.divide(right);
		default :
			throw new Exception("Unknow operator");
		}
	}
}
