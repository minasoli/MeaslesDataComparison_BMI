import java.io.*;
import java.util.*;

public class HealthMapFile 
{
	private Scanner x;
		
	// READ THE FILE //
	public void readFile()
	{
		try
		{
			x = new Scanner(new File("clean health map data.txt"));
			
			while (x.hasNext())
			{
				String a = x.next();
				String b = x.next();
				String c = x.next();
				
				System.out.printf("%s %s %s\n\n", a,b,c);
			}
			
			x.close();
			
		}
		catch (Exception e)
		{
			System.out.println("file not found");
		}
		
	}
	
	
	
}
