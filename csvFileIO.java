
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvFileIO {
    private static final String NEW_LINE_SEPARATOR = "\n";
   
	public static void writeCsvFile(String fileName,String Value) throws IOException {
    	FileWriter fileWriter = null;
       
    
    		fileWriter = new FileWriter(fileName,true);
    		
    		//Add a new line separator after the header
    		fileWriter.append(NEW_LINE_SEPARATOR);
    		fileWriter.append(Value);

    		fileWriter.flush();
    		fileWriter.close();

    	
    }
	public static void updatecsvFileRecord(String fileName,int colNum,String searchValue,String newRowValues) throws IOException {
    	  
		
		 BufferedReader fileReader = null;
		 FileWriter fileWriter = null;
		 File tempfile = new File("temp.csv");
		 File originalFile = new File(fileName);
		 
		 int rowValue = 0; 
		 
		 try
		 {
   		 String line = "";
   		 fileReader = new BufferedReader(new FileReader(originalFile));
		 fileWriter = new FileWriter(tempfile,true);
    		

   		 while ((line = fileReader.readLine()) != null) {
   			 String tokens[] = line.split(",");
   				if((tokens[colNum].toString()).equals(searchValue)) {
   					fileWriter.append(newRowValues);
   					}
   				else
   					fileWriter.append(line);
   				    fileWriter.append(NEW_LINE_SEPARATOR);
   			
   		 	}//while
   		
		 }
		 catch (Exception e)
		 {
			 fileReader.close();
    		 fileWriter.flush();
	    	 fileWriter.close();
	    	 
	    	 tempfile.delete();
	    	 
		 }
    		 fileReader.close();
    		 fileWriter.flush();
	    	 fileWriter.close();
	    	 
	    	
	    	 originalFile.delete();
	    	 tempfile.renameTo(originalFile);
    }
    
    public static String readRecordFromCsvFile(String fileName,int colName,String recordValue) throws IOException {
    	BufferedReader fileReader = null;
		 String rowValue = null; 
    	try
    	{
    		 String line = "";
    		 fileReader = new BufferedReader(new FileReader(fileName));
    		 fileReader.readLine();


    		 while ((line = fileReader.readLine()) != null) {
    			String tokens[] = line.split(",");
    			if((tokens[colName].toString()).equals(recordValue)) {
    				rowValue = line;
    				break;
    			}
    		 }


    		 fileReader.close();
    	}
    	catch (Exception e)
    	{
    	  fileReader.close();
    	}

    	
    	return rowValue;
    }


	public static List<String> readCsvFileColumnValues(String fileName,int colNumber) throws IOException {
    	BufferedReader fileReader = null;
		 List<String> values = new ArrayList<String>(); 
    	try
    	{
    		 String line = "";
    		 fileReader = new BufferedReader(new FileReader(fileName));
    		 fileReader.readLine();


    		 while ((line = fileReader.readLine()) != null) {
    			String tokens[] = line.split(",");
    			
    			if(tokens.length > colNumber)
    			values.add(tokens[colNumber]); 			
    		 }
         fileReader.close();

    	}
    	catch (Exception e)
    	{
    	  fileReader.close();
    	}

    	return values;
    }


    
}
