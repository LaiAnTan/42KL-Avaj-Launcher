package parser;

public class ParseErrorException extends Exception
{
	public ParseErrorException(String msg)
	{
		super("Error Occured During Parsing:" + msg);
	}	
}
