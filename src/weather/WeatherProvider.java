package weather;

import java.util.Arrays;
import java.util.Random;

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

	private String[] weather;
	
	private WeatherProvider()
	{
		// a way to convert all enums to string array
		// :: -> method reference operator used to call method with reference to class directly
		// maps each enum to  Enum.name() and puts them in an array
		this.weather = Arrays.stream(Weather.class.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}

	public static WeatherProvider getInstance()
	{
		if (instance == null)
			instance = new WeatherProvider();
		return (instance);
	}

	public String getCurrentWeather(Coordinates p_coordinates)
	{
		int latitude = p_coordinates.getLatitude();
		int longitude = p_coordinates.getLongitude();
		int height = p_coordinates.getHeight();

		// System.out.println(longitude + " " + latitude + " " + height + ": " + this.weather[(latitude + longitude + height) % 4]);

		int generated = Math.abs(new Random(latitude + longitude + height).nextInt());

		return (this.weather[generated % 4]);
	}
}
