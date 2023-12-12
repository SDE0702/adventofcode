
public class Instruction 
{
	public Instruction(String opCode, int operant) 
	{
		this.opCode = opCode;
		this.operant = operant;
		
	}
	String opCode;
	int operant;
	boolean executionFlag;
	
	@Override
	public String toString() 
	{
		return opCode + " " + operant + " " + executionFlag;
	}
}
