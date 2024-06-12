package aircraft;

import coordinates.Coordinates;
import util.Util;

public class JetPlane extends Aircraft
{
	
	private static String type = "JetPlane";

	public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
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
				latitude += 5;
				msg = "Its raining. Better watch out for lightings.";
				break;
			case "FOG":
				latitude += 1;
				msg = "Its foggy! I'm gonna crash!";
				break;
			case "SUN":
				height += 2;
				latitude += 10;
				msg = "Time to go fast. Zoooooom!";
				break;
			case "SNOW":
				height -= 7;
				msg = "OMG! Winter is coming!";
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
