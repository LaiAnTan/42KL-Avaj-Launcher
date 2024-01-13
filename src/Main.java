
import coordinates.Coordinates;
import parser.*;
import weather.WeatherProvider;
import simulator.*;

class Main
{
	public static void main(String[] args)
	{
		Parser parser;
		Simulator simulator;
		
		try
		{
			parser = new Parser("assets/scenario.txt");
			simulator = new Simulator(parser.simulation_runs, parser.aircrafts);
		
			simulator.runSimulation();
		}
		catch (ParseErrorException | SimulationErrorException e)
		{
			System.err.println(e.getMessage());
			return ;
		}

		// System.out.println(parser.simulation_runs);

		// for (AircraftData data : parser.aircrafts) {
		// 	System.out.println(data.type + " " + data.name + " "  + data.longitude + " "  + data.latitude + " " + data.height);
		// }


	}

}