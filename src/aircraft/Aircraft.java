package aircraft;

import java.io.FileWriter;
import java.io.IOException;

import coordinates.Coordinates;

public class Aircraft extends Flyable
{
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		super();
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	public void updateConditions()
	{
	}

	protected void writeStatusToFile(String msg)
	{
		// this exception is propogated all the way to Simulator class and rethrown there

		FileWriter output;
		
		try
		{
			output = new FileWriter("simulation.txt", true);
			output.write(msg);
			output.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
		}
	}

}
