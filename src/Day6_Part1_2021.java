import java.util.ArrayList;

public class Day6_Part1_2021 
{
	static String 
	testInput = "3,4,3,1,2";	
static String input = "4,2,4,1,5,1,2,2,4,1,1,2,2,2,4,4,1,2,1,1,4,1,2,1,2,2,2,2,5,2,2,3,1,4,4,4,1,2,3,4,4,5,4,3,5,1,2,5,1,1,5,5,1,4,4,5,1,3,1,4,5,5,5,4,1,2,3,4,2,1,2,1,2,2,1,5,5,1,1,1,1,5,2,2,2,4,2,4,2,4,2,1,2,1,2,4,2,4,1,3,5,5,2,4,4,2,2,2,2,3,3,2,1,1,1,1,4,3,2,5,4,3,5,3,1,5,5,2,4,1,1,2,1,3,5,1,5,3,1,3,1,4,5,1,1,3,2,1,1,1,5,2,1,2,4,2,3,3,2,3,5,1,5,1,2,1,5,2,4,1,2,4,4,1,5,1,1,5,2,2,5,5,3,1,2,2,1,1,4,1,5,4,5,5,2,2,1,1,2,5,4,3,2,2,5,4,2,5,4,4,2,3,1,1,1,5,5,4,5,3,2,5,3,4,5,1,4,1,1,3,4,4,1,1,5,1,4,1,2,1,4,1,1,3,1,5,2,5,1,5,2,5,2,5,4,1,1,4,4,2,3,1,5,2,5,1,5,2,1,1,1,2,1,1,1,4,4,5,4,4,1,4,2,2,2,5,3,2,4,4,5,5,1,1,1,1,3,1,2,1";	

	static int daysToSimulate = 256;
	public static void main(String[] args) throws Exception 
	{
		long gesamt = 0;
		String[] nns = testInput.split(",");
		for(String ns : nns)
		{
			ArrayList<Fish> fishes = new ArrayList<>();
			fishes.add(new Fish(Byte.parseByte(ns)));
	
			for(int anz = 1;anz <= daysToSimulate;anz++)
			{
				int countOfNewFishes = 0;
				for(Fish f : fishes)
				{
					if (f.decrementCycle())
					{
						countOfNewFishes++;
					}
				}
				for(int i = 0;i < countOfNewFishes;i++)
				{
					fishes.add(new Fish((byte)8));
				}
	//			System.out.println(fishes);
			}
			System.out.println(fishes.size());
			gesamt += fishes.size();
		}		
		System.out.println(gesamt);
	}
}
