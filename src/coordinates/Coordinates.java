package coordinates;

public class Coordinates
{
	
	private int longitude;
	private int latitude;
	private int height;

	// package private constructor, only can be accessed by classes from the same package
	public Coordinates(int p_longitude, int p_latitude, int p_height)
	{
		longitude = p_longitude;
		latitude = p_latitude;
		height = p_height;
	}

	public int getLongitude()
	{
		return (longitude);
	}

	public int getLatitude()
	{
		return (latitude);
	}

	public int getHeight()
	{
		return (height);
	}
}
