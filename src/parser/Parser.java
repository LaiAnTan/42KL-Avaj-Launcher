package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.NoSuchElementException;

public class Parser
{

	public int simulation_runs;
	public ArrayList<AircraftData> aircrafts = new ArrayList<>();
	
	public Parser(String filename) throws InvalidFileFormatException, FileNotFoundException
	{	
		File input = new File(filename);
		Scanner file_reader;

		file_reader = new Scanner(input);
		parseInputFile(file_reader);
		
		if (file_reader instanceof Scanner)
			file_reader.close();
	}

	private void parseInputFile(Scanner file_reader) throws InvalidFileFormatException
	{
		String line;
		String[] tokens;

		int longitude;
		int latitude;
		int height;

		try
		{
			this.simulation_runs = file_reader.nextInt();
		}
		catch (NoSuchElementException e)
		{
			throw (new InvalidFileFormatException());
		}

		while (file_reader.hasNextLine())
		{
			line = file_reader.nextLine();

			if (line.isBlank())
				continue;

			tokens = line.split(" ");
			
			if (tokens.length != 5 || isValidType(tokens[0]) == false)
				throw (new InvalidFileFormatException());

			try
			{
				longitude = Integer.parseInt(tokens[2]);
				latitude = Integer.parseInt(tokens[3]);
				height = Integer.parseInt(tokens[4]);

				if (height > 100 || height <= 0)
					throw (new NumberFormatException());

				this.aircrafts.add(new AircraftData(tokens[0], tokens[1], longitude, latitude, height));
			}
			catch (NumberFormatException e)
			{
				throw (new InvalidFileFormatException());
			}
		}
		return ;
	}

	private boolean isValidType(String type)
	{
		List<String> types = List.of("JetPlane", "Balloon", "Helicopter");

		return (types.contains(type) ? true : false);
	}

}
