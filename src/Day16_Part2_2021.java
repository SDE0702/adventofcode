import java.util.ArrayList;
import java.util.Stack;

public class Day16_Part2_2021 
{
	private static String real = "C20D59802D2B0B6713C6B4D1600ACE7E3C179BFE391E546CC017F004A4F513C9D973A1B2F32C3004E6F9546D005840188C51DA298803F1863C42160068E5E37759BC4908C0109E76B00425E2C530DE40233CA9DE8022200EC618B10DC001098EF0A63910010D3843350C6D9A252805D2D7D7BAE1257FD95A6E928214B66DBE691E0E9005F7C00BC4BD22D733B0399979DA7E34A6850802809A1F9C4A947B91579C063005B001CF95B77504896A884F73D7EBB900641400E7CDFD56573E941E67EABC600B4C014C829802D400BCC9FA3A339B1C9A671005E35477200A0A551E8015591F93C8FC9E4D188018692429B0F930630070401B8A90663100021313E1C47900042A2B46C840600A580213681368726DEA008CEDAD8DD5A6181801460070801CE0068014602005A011ECA0069801C200718010C0302300AA2C02538007E2C01A100052AC00F210026AC0041492F4ADEFEF7337AAF2003AB360B23B3398F009005113B25FD004E5A32369C068C72B0C8AA804F0AE7E36519F6296D76509DE70D8C2801134F84015560034931C8044C7201F02A2A180258010D4D4E347D92AF6B35B93E6B9D7D0013B4C01D8611960E9803F0FA2145320043608C4284C4016CE802F2988D8725311B0D443700AA7A9A399EFD33CD5082484272BC9E67C984CF639A4D600BDE79EA462B5372871166AB33E001682557E5B74A0C49E25AACE76D074E7C5A6FD5CE697DC195C01993DCFC1D2A032BAA5C84C012B004C001098FD1FE2D00021B0821A45397350007F66F021291E8E4B89C118FE40180F802935CC12CD730492D5E2B180250F7401791B18CCFBBCD818007CB08A664C7373CEEF9FD05A73B98D7892402405802E000854788B91BC0010A861092124C2198023C0198880371222FC3E100662B45B8DB236C0F080172DD1C300820BCD1F4C24C8AAB0015F33D280";
	private static String test0 = "D2FE28";
	private static String test1 = "38006F45291200";
	private static String test2 = "EE00D40C823060";
	private static String test3 = "8A004A801A8002F478"; // 16  // 100 010 1 00000000001 001 010 1 000000000011 0101000000000000010
	
	private static String test4 = "620080001611562C8802118E34"; // 12
	private static String test5 = "C0015000016115A2E0802F182340"; // 23 
	private static String test6 = "A0016C880162017C3686B18A3D4780"; // 31
	
	// Part2
	private static String test7 = "C200B40A82"; // Sum packet 1+2 = 3
	private static String test8 = "04005AC33890"; // Prod 6*9 = 54
	private static String test9 = "880086C3E88112"; // min aus 7,8,9 -> 7
	private static String test10 = "CE00C43D881120"; // max aus 7,8,9 -> 9
	private static String test11 = "D8005AC2A8F0"; // Less --> 1
	private static String test12 = "F600BC2D8F"; // Greater --> 0
	private static String test13 = "9C005AC2F8F0"; // Equal --> 0
	private static String test14 = "9C0141080250320F1802104A08"; // 1
	private static String input = real;
	
	
	private static int sumVersions = 0;
	public static void main(String[] args) throws Exception
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length();i++)
		{
			int n = Integer.parseInt(input.substring(i,i+1),16);
			String b = Integer.toString(n,2);
			b = "0".repeat(4 - b.length()) + b;
			
			sb.append(b);
		}
		String r = sb.toString();
		
		System.out.println(r);
		
		ArrayList<Integer> pos = new ArrayList<>();
		pos.add(0);
		sumVersions = 0;
		long result = packetAnalyser(r, pos);
//		System.out.println("Sumversions: " + sumVersions);
		
		System.out.println("Result:" + result );
	}

	//private static Stack<Long> operanten = new Stack<Long>();
	
	private static Long packetAnalyser(String r, ArrayList<Integer> pos) throws Exception 
	{
		int version = getNextValue(r,pos,3);
		sumVersions += version;  
		int id = getNextValue(r,pos,3);
		
		System.out.println("Version:" + version + " - ID:" + id);
		Stack<Long> operanten = new Stack<Long>();
		
		if (id == 4) 
		{   long num = 0;
			int conti = 0;
			while (true)
			{
				conti = getNextValue(r,pos,1);
				int value = getNextValue(r,pos,4);
				System.out.println("Literal:" + value);
				num = num * 16 + value;
				if (conti == 0) break;
			} 
			System.out.println("Num=" + num);
			operanten.push(num);
		} else {  // Operator packet
			
			int lengthtypeid = getNextValue(r,pos,1);
			int lengthofsubpacket = 0;
			if (lengthtypeid == 0)
			{
				lengthofsubpacket = getNextValue(r,pos,15);  // Bytes total
				int oldpos = pos.get(0);
				while (pos.get(0)  - oldpos < lengthofsubpacket)
				{
					operanten.push(packetAnalyser(r, pos));
				}
			} else {
				lengthofsubpacket = getNextValue(r,pos,11);  // Number of subpackets
				for(int i = 0;i < lengthofsubpacket;i++)
				{
					operanten.push(packetAnalyser(r, pos));
				}
			}
			if (id == 0) // Sum packets
			{
				long sum = 0;
				while (operanten.size() > 0)
				{
					sum += operanten.pop();
				}
				System.out.println(">> Sum=" + sum);
				operanten.push(sum);
			} else if (id == 1)
			{
				long prod = 1;
				while (operanten.size() > 0)
				{
					prod *= operanten.pop();
				}
				operanten.push(prod);
				System.out.println(">> Prod=" + prod);
			} else if (id == 2)
			{
				long min = Long.MAX_VALUE;
				while (operanten.size() > 0)
				{
					min = Math.min(min, operanten.pop());
				}
				System.out.println(">> Min=" + min);
				operanten.push(min);
			} else if (id == 3)
			{
				long max = Long.MIN_VALUE;
				while (operanten.size() > 0)
				{
					max = Math.max(max, operanten.pop());
				}
				System.out.println(">> Max=" + max);
				operanten.push(max);
			} else if (id == 5)
			{
				long first = operanten.pop();
				long second = operanten.pop();
				if (first < second)
				{
					System.out.println(">> Greater=1");
					operanten.push(1L);
				}
				else
				{
					System.out.println(">> Greater=0");
					operanten.push(0L);
				}
			} else if (id == 6)
			{
				long first = operanten.pop();
				long second = operanten.pop();
				if (first > second)
				{
					System.out.println(">> Less=1");
					operanten.push(1L);
				}
				else
				{
					System.out.println(">> Less=0");
					operanten.push(0L);
				}
			} else if (id == 7)
			{
				long first = operanten.pop();
				long second = operanten.pop();
				if (first == second)
				{
					System.out.println(">> Equal=1");
					operanten.push(1L);
				}
				else
				{
					System.out.println(">> Equal=0");
					operanten.push(0L);
				}
			}
		}
		return operanten.pop();
	}

	private static int getNextValue(String r, ArrayList<Integer> pos,int len) 
	{
		int p = pos.remove(0);
		
		String sub = r.substring(p,p + len);
		p += len;
		pos.add(p);
		int n = Integer.parseInt(sub,2); 
		return n;
	}
}

