import java.io.*;
import java.util.*;

public class BMI_Capstone
{
	
	static ViprFile rv = new ViprFile();
	static HealthMapFile rhm = new HealthMapFile();
	static FileOutput fo = new FileOutput();
	
	public static ArrayList<String> viprResultsArray = new ArrayList<String>();
	public static ArrayList<String> hmResultsArray = new ArrayList<String>();	
	public static ArrayList<String> viprResultsArrayOutput = new ArrayList<String>();
	public static ArrayList<String> hmResultsArrayOutput = new ArrayList<String>();
	
	public static String state;
	 
	public static void main(String[] args) throws FileNotFoundException 
	{

		
		   Scanner console = new Scanner (System.in);

	       //String choice;
		   char command;

	        // print the menu
			      printMenu();
	      do
	       {
	           // ask a user to choose a command
	          System.out.println("\nPlease enter a command or type ?");
	          String choice = console.next();//.toLowerCase();
              command = choice.charAt(0);

	           switch (command)
	            {
	                 case 'a':
	             		rv.readFile();
	             		rhm.readFile();	             		
	                    break;
	                      
	                 case 'b': 
	                	  rv.compareFiles();
	                      break;
	                 case 'q':
	                      break;
	                 case 'o':
	                	   fo.writeToFile();
	                	   break;
	                 default:
	                       System.out.println("Invalid input");

	            }

	        } while (command != 'q');
		

		

			
	}//end main
	
	
	
	  public static void printMenu()
	   {
	    System.out.print("\nCommand Options\n"
	                   + "-----------------------------------\n"
	                   + "a: Read files\n"
	                   + "b: Search state\n"
	                   + "o: Output Common Dates to File\n"
	                   + "q: quit this program\n\n");
	    } // end of the printMenu method
}
