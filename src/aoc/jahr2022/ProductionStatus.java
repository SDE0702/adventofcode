package aoc.jahr2022;

public class ProductionStatus 
{
	int maxOreBots = 1;
	int maxClayBots = 4;
	int maxObsidianBots = 2;
	int maxGeodeBots = 100;
	
	int bluePrintNr;
	int oreRobotsCostOres;
	int clayRobotsCostOres;
	int obsidianRobotsCostOres;
	int obsidianRobotsCostClays;
	int geodeRobotsCostOres;
	int geodeRobotsCostObsidian;
	public ProductionStatus(int bluePrintNr, int oreRobotsCostOres, int clayRobotsCostOres, int obsidianRobotsCostOres,
			int obsidianRobotsCostClays, int geodeRobotsCostOre, int geodeRobotsCostobsidian) {
		this.bluePrintNr = bluePrintNr;
		this.oreRobotsCostOres = oreRobotsCostOres;
		this.clayRobotsCostOres = clayRobotsCostOres;
		this.obsidianRobotsCostOres = obsidianRobotsCostOres;
		this.obsidianRobotsCostClays = obsidianRobotsCostClays;
		this.geodeRobotsCostOres = geodeRobotsCostOre;
		this.geodeRobotsCostObsidian = geodeRobotsCostobsidian;
	}

	public void printBluprintvalues()
	{
		System.out.println(bluePrintNr + "|" + oreRobotsCostOres + "|" + clayRobotsCostOres + "|" + 
			obsidianRobotsCostOres + "|" + obsidianRobotsCostClays + "|" + geodeRobotsCostOres + "|" + geodeRobotsCostObsidian);
	}

	int stockOre = 0;
	int stockClay = 0;
	int stockObsidian = 0;
	int stockGeode = 0;
	
	int countOreRobots = 1;
	int countClayRobots = 0;
	int countObsidianRobots = 0;
	int countGeodeRobots = 0;

	public void doProductionStep() 
	{
		boolean trottleOre = false;
		boolean trottleClay = false;
		boolean trottleObsidian = false;
		boolean trottleGeode = false;
		// Check create a new clay robot
		if (stockOre >= oreRobotsCostOres && countOreRobots < maxOreBots)
		{
			stockOre -= oreRobotsCostOres;
			countOreRobots++;
			trottleOre = true;
		}

		// Check create a new clay robot
		if (stockOre >= clayRobotsCostOres && countClayRobots < maxClayBots)
		{
			stockOre -= clayRobotsCostOres;
			countClayRobots++;
			trottleClay = true;
		}

		// Check create a new Obsidian robot
		if (stockOre >= obsidianRobotsCostOres && stockClay >= obsidianRobotsCostClays && countObsidianRobots < maxObsidianBots)
		{
			stockOre -= obsidianRobotsCostOres;
			stockClay -= obsidianRobotsCostClays;
			countObsidianRobots++;
			trottleObsidian = true;
		}

		// Check create a new Geode robot
		if (stockOre >= geodeRobotsCostOres && stockObsidian >= geodeRobotsCostObsidian && countGeodeRobots < maxGeodeBots)
		{
			stockOre -= geodeRobotsCostOres;
			stockObsidian -= geodeRobotsCostObsidian;
			countGeodeRobots++;
			trottleGeode = true;
		}

		// Ore robot
		for(int i = 0;i < countOreRobots;i++)
		{
			stockOre++;
		}
		if (stockOre > 0 && trottleOre) stockOre--;
		
		// Obsidian robot
		for(int i = 0;i < countClayRobots;i++)
		{
			stockClay++;
		}
		if (stockClay > 0 && trottleClay) stockClay--;
		// Obsidian robot
		for(int i = 0;i < countObsidianRobots;i++)
		{
			stockObsidian++;
		}
		if (stockObsidian > 0 && trottleObsidian) stockObsidian--;

		// Geode robot
		for(int i = 0;i < countGeodeRobots;i++)
		{
			stockGeode++;
		}
		if (stockGeode > 0 && trottleGeode) stockGeode--;
		
		
	}
	
	public void printStatus()
	{
		System.out.println("Ore=" + stockOre + ";Clay=" + stockClay + ";Obsidian=" + stockObsidian + ";Geode=" + stockGeode);
		System.out.println("Orebots=" + countOreRobots + ";Claybots=" + countClayRobots + ";Obsidianbots=" + countObsidianRobots + ";Geodebots=" + countGeodeRobots);
	}
}
