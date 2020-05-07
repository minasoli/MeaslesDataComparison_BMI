
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class FileOutput 
{
	
	 public static void writeToFile() 
	 {
	      BufferedWriter bw = null;
	      try {
		 
	     //output file name or path
		 File file = new File("CommonDates.txt");

		 // This will make sure that the file gets created if it is not present at the specified location
		  if (!file.exists()) 
		  {
		     file.createNewFile();
		  }

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
		 
		  bw.write("Common Dates for " + BMI_Capstone.state + "\n");
		  bw.write("==============================");		  
		 
		  

				for (int i = 0; i < BMI_Capstone.viprResultsArrayOutput.size(); i++) {
					
					String dateToSearch ;
					String accessionID_Vipr;
					String eventID_HM;
					
					String[] viprParts = ( (String)BMI_Capstone.viprResultsArrayOutput.get(i)).split("!");
					dateToSearch = viprParts[0];
					accessionID_Vipr =  viprParts[1];
					boolean occurence = false;
					
						for (int x = 0; x < BMI_Capstone.hmResultsArrayOutput.size(); x++) 
						{
							String[] hmParts = ( (String)BMI_Capstone.hmResultsArrayOutput.get(x)).split("!");
							eventID_HM = hmParts[1];
							if(hmParts[0].contentEquals(dateToSearch))
							{
								bw.write("\nHMap" + " Date: " + dateToSearch + " AlertID: " + eventID_HM);
								occurence = true;
							}
						}// looping Health Plan
					
						if(occurence) bw.write("\nVipr" + " Date: " + dateToSearch + " GenBank Accession: " + accessionID_Vipr + "\n");
		        }// looping Vipr and comparing with hm
		  
		  
		  System.out.println("File written Successfully");
		  
		  BMI_Capstone.viprResultsArrayOutput.clear();
		  BMI_Capstone.hmResultsArrayOutput.clear();

	      } 
	      catch (IOException ioe) 
	      {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try
		   {
		      if(bw!=null)
			 bw.close();
		   }
		   catch(Exception ex)
		   {
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}//end finally
	   }//end function
	
	

}
