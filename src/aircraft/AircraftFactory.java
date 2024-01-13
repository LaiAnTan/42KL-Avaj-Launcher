package aircraft;

import coordinates.Coordinates;

public class AircraftFactory
{

	/*
	 Factory design pattern implementation:

	 - Singleton base
	 - returns new objects
	 */

	private static AircraftFactory instance = null;

	private AircraftFactory()
	{
	
	}

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return (instance);
	}

	public Flyable newAircraft(String[] p_type, String[] p_name, Coordinates p_Coordinates)
	{
		return (new )
	}
}