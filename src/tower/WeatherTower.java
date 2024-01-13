package tower;

import coordinates.Coordinates;
import weather.WeatherProvider;
import aircraft.Flyable;

public class WeatherTower extends Tower
{

	private WeatherProvider wp = WeatherProvider.getInstance();

	public String getWeather(Coordinates p_coordinates)
	{
		return (wp.getCurrentWeather(p_coordinates));
	}

	public void changeWeather()
	{
		this.conditionChanged();
	}

}
