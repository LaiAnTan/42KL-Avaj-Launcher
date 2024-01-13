package aircraft;

import java.io.IOException;

import coordinates.Coordinates;

public class Helicopter extends Aircraft
{

	private static String type = "Helicopter";
	
	public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public void updateConditions()
	{
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();
		String msg = "";

		switch (this.weather_tower.getWeather(this.coordinates))
		{
			case "RAIN":
				longitude += 5;
				msg = "Its raining!";
				break;
			case "FOG":
				longitude += 1;
				msg = "Its foggy!";
				break;
			case "SUN":
				height += 2;
				longitude += 10;
				msg = "Its sunny!";
				break;
			case "SNOW":
				height -= 12;
				msg = "Its snowing!";
				break;
		}

		if (height > 100)
			height = 100;

		if (height < 0)
		{
			height = 0;
			this.weather_tower.unregister(this);
			msg = "I landed.";
		}
		
		this.coordinates =  new Coordinates(longitude, latitude, height);

		writeStatusToFile(type + "#" + this.name + "(" + this.id + "): " + msg + "\n");
	}

}
