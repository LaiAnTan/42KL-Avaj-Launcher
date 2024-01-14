package aircraft;

import coordinates.Coordinates;

public class Aircraft extends Flyable
{

	protected static String type = "Aircraft";
	
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
	{
		super();
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinate;
	}

	public void updateConditions()
	{
	}

	public long getId()
	{
		return (this.id);
	}

	public String getName()
	{
		return (this.name);
	}

	public String getType()
	{
		return (type);
	}
}
