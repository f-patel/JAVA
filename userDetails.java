import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class userDetails
{

	String userName;
	String userPassword;
	boolean isActive;
	String userType;
	String firstName;
	String lastName;
	String userAddress;
	int userAge;
	String userSex;

    
	public userDetails(String csvFormatuser)
	{
		String[] tokens = csvFormatuser.split(",");
		userName = tokens[0];
		userPassword = tokens[1];
		
		if(tokens[2].equals("true"))
			isActive =true;
		else
			isActive = false;
		
		userType = tokens[3];
		firstName = tokens[4];
		lastName = tokens[5];
		userAge = Integer.parseInt(tokens[6]);
		userSex = tokens[7];
		userAddress = tokens[8];
		

	}
	
	public  userDetails(String userId,String type,String fname,String lname, int age, String sex,String address)
	{
	   userName = userId;
	   userPassword = "test";
	   isActive = true;
       userSex = sex;
       userAddress = address;
       userType = type;
       firstName= fname;
       lastName = lname;
       userAge = age;
	}
	
	public void setUserName(String userId)
	{
		userName = userId;
	}
	public void setPwd(String pwdValue)
	{
		userPassword = pwdValue;
	}
	
	public void setUserType(String typeValue)
	{
		userType =  typeValue;
	}
	
	public void setActive(boolean statusValue)
	{
		isActive = statusValue;
		
	}
	
    public void setAddress(String addressValue)
    {
    	userAddress = addressValue;
    }
    
    public void setAge(int ageValue)
    {
    	userAge = ageValue;
    }
    
    public void setSex(String sex)
    {
    	userSex = sex;
    }
    
    public void setFirstName(String Id)
    {
    	firstName = Id;
    }
    public void setLastName(String Id)
    {
    	firstName = Id;
    }
	
   public String getName()
   {
	   return userName;
   }
   
   public String getAddress()
   {
	   return userAddress;
   }
   
   public int getAge()
   {
	   return userAge;
   }
   public String getPassword()
   {
	   return userPassword;
   }
   public String getUserType()
   {
	   return userType;
   }
    
   public String getFistName()
   {
	   return firstName;
   }
   public String getLastName()
   {
	   return lastName;
   }
   public String getSex()
   {
	   return userSex;
   }
   public boolean getStatus()
   {
	   return isActive;
   }
   public String prepareInsertStmt()
   {
	   ArrayList<Object> values = new ArrayList<Object>();
	   values.add(userName);
	   values.add(userPassword);
	   values.add(isActive);
	   values.add(userType);
	   values.add(firstName);
	   values.add(lastName);
	   values.add(userAge);
	   values.add(userSex);
	   values.add(userAddress);
	   
	   String rowValue = values.toString();
	   rowValue = rowValue.substring(1, rowValue.length()-1);
	
	   return rowValue;
   }
   
   
   
}
