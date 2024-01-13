package weather;

import coordinates.Coordinates;

public class WeatherProvider
{

	/*
	 Singleton implementation:

	 - private constructor
	 - private static instance variable of class
	 - public static getInstance method that creates an instance of a class // returns the current instance
	 */

	private static WeatherProvider instance = null;

	String[] weather;
	
	
	private WeatherProvider()
	{
	}

	public static WeatherProvider getInstance()
	{
		if (instance == null)
			instance = new WeatherProvider();
		return (instance);
	}

	String[] getCurrentWeather(Coordinates p_coordinates)
	{
		return (weather);
	}
}
