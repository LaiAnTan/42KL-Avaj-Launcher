package aircraft;

import tower.WeatherTower;


public abstract class Flyable
{

	protected WeatherTower weather_tower;
	
	public abstract void updateConditions();

	public void registerTower(WeatherTower p_tower)
	{
		weather_tower = p_tower;
		weather_tower.register(this);
	}

}
