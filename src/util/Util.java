package util;

import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	public static void writeToFile(String msg)
	{

		FileWriter output;
		
		try
		{
			output = new FileWriter("simulation.txt", true);
			output.write(msg);
			output.close();
		}
		catch (IOException e)
		{
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}

}
