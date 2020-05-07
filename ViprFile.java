import java.io.*;

import java.util.*;

public class ViprFile 
{
	

	private int viprResultsArrayCount = 0 ;
	private int hmResultsArrayCount = 0;
	private Scanner x;
	
	public int searchFile(String dateToSearch, ArrayList AL)
	{
		int occurrences = Collections.frequency(AL, dateToSearch);
		return occurrences;
	}


	
	// READ THE FILE //
	public void readFile()
	{
		
		try
		{
			x = new Scanner(new File("clean vipr measles results.txt"));
			
			while (x.hasNext())
			{
				String a = x.next();
				String b = x.next();
				String c = x.next();
				
				System.out.printf("%s %s %s \n\n", a,b,c);
			}
			
			x.close();
		}
		catch (Exception e)
		{
			System.out.println("file not found");
		}
	
	}
	
	
	
	public  void compareFiles()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhich State would you like to look up?");
		
		//user inputs state
		BMI_Capstone.state = scan.nextLine();

		int statesVIPR = 0;
		int statesHM = 0;
	
		/////////////////////////////////// Vipr File /////////////////////////////////////
		File file = new File("clean vipr measles results.txt");
		try
		{
			
			Scanner sc = new Scanner(new FileInputStream(file));
		    while (sc.hasNext())
		    {		    	
		       if(sc.next().equals(BMI_Capstone.state))
		    	   {
		    	   		statesVIPR++;	
		    	   		String AccessionNumber = sc.next(); // move to the next column ... Accession
		    	   		String viprDate = sc.next();
		    	   		BMI_Capstone.viprResultsArray.add(viprDate);
		    	   		BMI_Capstone.viprResultsArrayOutput.add(viprDate + "!" + AccessionNumber);
		    	   }
		       
		    }//end while
		    
		    viprResultsArrayCount = statesVIPR;	
		    
		}// end try
		catch (Exception e)
		{
			System.out.println("file not found");
		}
		
		///////////////////////////////// HM File /////////////////////////////////////
		File file2 = new File("clean health map data.txt");
		try
		{
			Scanner sc2 = new Scanner(new FileInputStream(file2));
		    while (sc2.hasNext())
		    {
		    	String AlertID = sc2.next();
		    	String dateHolder = sc2.next();
		    	
		       if(sc2.next().contains(BMI_Capstone.state)) 
		    	   {
		    	   		statesHM++;
		    	   		BMI_Capstone.hmResultsArray.add(dateHolder);		    	   		
		    	   		BMI_Capstone.hmResultsArrayOutput.add(dateHolder + "!" + AlertID);
		    	   }
		    }//end while
		    
		    hmResultsArrayCount = statesHM;
		    
		}// end try
		catch (Exception e)
		{
			System.out.println("file not found");
		}
		
		
		//prints out number of occurrences 
		System.out.println(BMI_Capstone.state + " occurs " + viprResultsArrayCount + " times in the vipr file and " + hmResultsArrayCount + " times in the health map file.");		
		 	
		    ///comparison between both arrays			
			
			for (int i = 0; i < BMI_Capstone.viprResultsArray.size(); i++) {
				
				String dateToSearch ;
				dateToSearch = (String)BMI_Capstone.viprResultsArray.get(i);
				
				int viprCount = searchFile(dateToSearch,BMI_Capstone.viprResultsArray);
				int hmCount = searchFile(dateToSearch,BMI_Capstone.hmResultsArray);
				
				if (hmCount > 0)
				{
					System.out.println(dateToSearch + " was found " + viprCount + " times in the VIPR file and " + hmCount + " in the Health Map file.");
					
				}
				
	        }// looping Vipr and comparing with hm
			
			
			//Clear Arrays for next selection
			BMI_Capstone.viprResultsArray.clear();
			BMI_Capstone.hmResultsArray.clear();
	} //End Compare function
	
}
