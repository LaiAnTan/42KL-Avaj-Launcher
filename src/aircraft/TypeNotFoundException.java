package aircraft;

public class TypeNotFoundException extends Exception
{
	public TypeNotFoundException()
	{
		super("Aircraft Type Not Found");
	}
}
