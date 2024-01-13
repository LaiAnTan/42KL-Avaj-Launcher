package simulator;

public class SimulationErrorException extends Exception
{
	public SimulationErrorException(String msg)
	{
		super("Error Occured During Simulation: " + msg);
	}		
}
