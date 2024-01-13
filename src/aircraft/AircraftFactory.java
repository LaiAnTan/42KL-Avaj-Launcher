package aircraft;

import coordinates.Coordinates;

public class AircraftFactory
{

	/*
	 Factory design pattern implementation:

	 - Singleton base
	 - function that returns new objects
	 */

	private static AircraftFactory instance = null;

	private int p_id = 0;

	private AircraftFactory()
	{
		
	}

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return (instance);
	}

	// need to specify exceptions thrown
	public Flyable newAircraft(String p_type, String p_name, Coordinates p_Coordinates) throws TypeNotFoundException
	{
		p_id += 1;

		switch (p_type)
		{
			case "JetPlane":
				return (new JetPlane(p_id, p_name, p_Coordinates));
			case "Helicopter":
				return (new Helicopter(p_id, p_name, p_Coordinates));
			case "Balloon":
				return (new Balloon(p_id, p_name, p_Coordinates));
			default:
				throw (new TypeNotFoundException());
		}
	}


}

