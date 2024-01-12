public class AircraftFactory {

	private static AircraftFactory instance = null;

	public static AircraftFactory getInstance()
	{
		if (instance == null)
			instance = new AircraftFactory();
		return (instance);
	}

	public Flyable* newAircraft(string p_type, string p_name, Coordinates p_Coordinates)
	{

	}
}