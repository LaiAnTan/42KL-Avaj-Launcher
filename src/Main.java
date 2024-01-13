
import java.io.IOException;
import java.io.FileWriter;

import aircraft.TypeNotFoundException;
import parser.*;
import simulator.*;

class Main
{
	public static void main(String[] args)
	{
		Parser parser;
		Simulator simulator;
		FileWriter output;

		if (args.length != 1)
			return ;
		
		try
		{
			output = new FileWriter("simulation.txt", false);
			output.write("");
			output.close();
			parser = new Parser(args[0]);

			simulator = new Simulator(parser.simulation_runs, parser.aircrafts);
		
			simulator.runSimulation();
		}
		catch (InvalidFileFormatException | TypeNotFoundException | IOException e)
		{
			System.err.println(e.getMessage());
			return ;
		}
	}

}