
import parser.*;

class Main
{
	public static void main(String[] args)
	{
		Parser parser;
		
		try
		{
			parser = new Parser("assets/scenario.txt");
		}
		catch (ParseErrorException e)
		{
			System.err.println("Error:" + e.getMessage());
			return ;
		}

		System.out.println(parser.simulation_runs);

		for (AircraftData data : parser.aircrafts) {
			System.out.println(data.type + " " + data.name + " "  + data.longitude + " "  + data.latitude + " " + data.height);
		}

	}

}