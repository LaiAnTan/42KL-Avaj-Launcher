package parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

import aircraft.TypeNotFoundException;

public class Parser
{

	public int simulation_runs;
	public ArrayList<AircraftData> aircrafts = new ArrayList<>();
	
	public Parser(String filename) throws ParseErrorException
	{
		System.out.println("Parser: Constructor called");
		
		File input = new File(filename);
		Scanner file_reader;

		try
		{
			file_reader = new Scanner(input);
			parseInputFile(file_reader);
		}
		catch (FileNotFoundException | InvalidFileFormatException | TypeNotFoundException e) // can catch multiple types
		{
			throw new ParseErrorException(e.getMessage());
		}
		
		if (file_reader instanceof Scanner)
			file_reader.close();
	}

	private void parseInputFile(Scanner file_reader) throws InvalidFileFormatException, TypeNotFoundException, InputMismatchException
	{
		String line;
		String[] tokens;

		String type;
		String name;
		int longitude;
		int latitude;
		int height;

		try
		{
			this.simulation_runs = file_reader.nextInt();
		}
		catch (InputMismatchException e)
		{
			throw (new InvalidFileFormatException());
		}

		while (file_reader.hasNextLine())
		{
			line = file_reader.nextLine();

			if (line.isBlank())
				continue;

			tokens = line.split(" ");

			if (tokens.length != 5)
				throw (new InvalidFileFormatException());

			type = tokens[0];

			if (isValidType(type) == false)
				throw (new TypeNotFoundException());

			name = tokens[1];

			try
			{
				longitude = Integer.parseInt(tokens[2]);
				latitude = Integer.parseInt(tokens[3]);
				height = Integer.parseInt(tokens[4]);
			}
			catch (NumberFormatException e)
			{
				throw (new InvalidFileFormatException());
			}

			this.aircrafts.add(new AircraftData(type, name, longitude, latitude, height));
		}
		return ;
	}

	private boolean isValidType(String type)
	{
		List<String> types = List.of("JetPlane", "Balloon", "Helicopter");

		return (types.contains(type) ? true : false);
	}

}
