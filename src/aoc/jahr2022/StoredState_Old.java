package aoc.jahr2022;

public class StoredState_Old 
{
	private long rounds;
	private long score;
	public StoredState_Old(long rounds,long score) 
	{
		this.rounds = rounds;
		this.score = score;
	}
	
	public long score()
	{
		return score;
	}
	public long rounds()
	{
		return rounds;
	}
}
