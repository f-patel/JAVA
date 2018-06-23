import java.io.IOException;
import java.util.ArrayList;


public class DrugOrders {
	
	public String drugName;
	public int drugCount = 0;
	
	
	
	public DrugOrders(String csvFormatPatient)
	{
		String[] tokens = csvFormatPatient.split(",");
		
		if(tokens.length>0 && (tokens[0]!=null || tokens[0]!=""))
			drugName = tokens[0];
		
		if(tokens.length>1 && (tokens[1]!=null || tokens[1]!=""))
			drugCount = Integer.parseInt(tokens[1]);
		
	}

	public DrugOrders(String name , int count)
	{
		drugName = name;
		drugCount = count;
	
	}
	
	public void setDrugName(String name)
	{
		drugName = name;	
	}
	
	public void setDrugCount(int count)
	{
		drugCount = drugCount+count;
	}

	
	 public String prepareDrugOrderInsertStmt()
	   {
		   ArrayList<Object> values = new ArrayList<Object>();
		   values.add(drugName);
		   values.add(drugCount);
		   
		   String rowValue = values.toString();
		   rowValue = rowValue.substring(1, rowValue.length()-1);
		
		   return rowValue;
	   }
	 
	

}

