package aircraft;

import coordinates.Coordinates;
import util.Util;

public class Balloon extends Aircraft
{

	private static String type = "Balloon";
	
	public Balloon(long p_id, String p_name, Coordinates p_coordinate)
	{
		super(p_id, p_name, p_coordinate);
	}

	@Override
	public String getType()
	{
		return (type);
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
				height -= 5;
				msg = "Damn you rain! You messed up my balloon.";
				break;
			case "FOG":
				height -= 3;
				msg = "I cannot see anything in this fog!";
				break;
			case "SUN":
				height += 4;
				longitude += 2;
				msg = "Let's enjoy the weather and take some pics.";
				break;
			case "SNOW":
				height -= 15;
				msg = "Its snowing. We're gonna crash.";
				break;
		}

		
		if (height > 100)
			height = 100;

		if (height < 0)
		{
			height = 0;
			this.weather_tower.unregister(this);
			msg = "landing.";
		}
		
		this.coordinates =  new Coordinates(longitude, latitude, height);

		Util.writeToFile(type + "#" + this.name + "(" + this.id + "): " + msg + "\n");
	}

}
