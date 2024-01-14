package tower;

public class DowncastFailedException extends Exception
{
	public DowncastFailedException()
	{
		super("Flyable downcast to Aircraft TFailed");
	}
}
