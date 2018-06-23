import java.util.ArrayList;


public class PharmacyDrugs {
	
	public String drugName;
	public int drugCount = 0;
	public boolean status = false;
	
	
	public PharmacyDrugs(String csvFormatPatient)
	{
		String[] tokens = csvFormatPatient.split(",");
		drugName = tokens[0].trim();
		drugCount = Integer.parseInt(tokens[1].trim());
		
		if(drugCount>0)
			status = true;
	}

	public PharmacyDrugs(String name , int count)
	{
		drugName = name;
		drugCount = count;
	
		if(drugCount>0)
		status = true;
	}
	
	public void setDrugName(String name)
	{
		drugName = name;	
	}
	
	public void setDrugCount(int count)
	{
		drugCount = count;
		setStatus();
	}
	
	public void setStatus()
	{
		if(drugCount>0)
				status = true;
		else
				status = false;
	}

	public boolean getDrugStatus()
	{
		return status;
	}
	
	public String getDrugName()
	{
		return drugName;
	}
	
	public int getDrugCount()
	{
		return drugCount;
	}
	 public String prepareDrugInsertStmt()
	   {
		   ArrayList<Object> values = new ArrayList<Object>();
		   values.add(drugName);
		   values.add(drugCount);
		   values.add(status);
		   
		   String rowValue = values.toString();
		   rowValue = rowValue.substring(1, rowValue.length()-1);
		
		   return rowValue;
	   }
	 
	 
	 
}

