import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class  RegisterUser extends BasicFrameDesign implements ActionListener
{
	private static final String userTypeSelectedName = null;
	private static final String userSexSelectedName = null;
	JLabel head,user_name,first_name,last_name,user_age,user_sex,user_type,user_address,msg;
	JButton submit,back,refresh;
    JTextField userName,firstName,lastName,userAge;
	JTextArea  userAddress;
	JComboBox userSex,userType;
	JScrollPane userAddressPane;
	

	String userNameValue,firstNameValue,lastNameValue,userAddressValue, Address,userTypeNameSelected,userSexNameSelected;
    int userAgeValue,userTypeSelectedIndex,userSexSelectedIndex;
	


	public RegisterUser(String title ,String header) {   
		setTitle(title);
		head = super.addHeader(header,"Arial Narrow",Font.BOLD,45,SwingConstants.CENTER);
		head.setForeground(new Color(0,0,255));
		head.setBounds(210,0,570,60);
		getContentPane().add(head);

		user_name=new JLabel("User ID");
		user_name.setFont(new Font("Arial Narrow",Font.BOLD,22));
		//user_name.setForeground(new Color(0,0,255));
		user_name.setHorizontalAlignment(SwingConstants.RIGHT);
		user_name.setBounds(230,80,180,40);
		getContentPane().add(user_name);
		
		userName=new JTextField(30);
		userName.setFont(new Font("Arial Narrow",Font.BOLD,22));
		userName.setBounds(470,80,300,40);
		getContentPane().add(userName);

		   first_name=new JLabel("Firt Name");
		   first_name.setFont(new Font("Arial Narrow",Font.BOLD,22));
		  // first_name.setForeground(new Color(204,0,51));
		   first_name.setHorizontalAlignment(SwingConstants.RIGHT);
		first_name.setBounds(230,130,180,40);
		getContentPane().add(first_name);
		
		firstName=new JTextField(30);
		firstName.setFont(new Font("Arial Narrow",Font.BOLD,22));
		firstName.setBounds(470,130,300,40);
		getContentPane().add(firstName);
		
		   last_name=new JLabel("Last Name");
		   last_name.setFont(new Font("Arial Narrow",Font.BOLD,22));
		  // last_name.setForeground(new Color(204,0,51));
		   last_name.setHorizontalAlignment(SwingConstants.RIGHT);
		   last_name.setBounds(230,180,180,40);
		getContentPane().add(last_name);
		
		lastName=new JTextField(30);
		lastName.setFont(new Font("Arial Narrow",Font.BOLD,22));
		lastName.setBounds(470,180,300,40);
		getContentPane().add(lastName);

		user_age=new JLabel("Age");
		user_age.setFont(new Font("Arial Narrow",Font.BOLD,22));
		//user_age.setForeground(new Color(204,0,51));
		user_age.setHorizontalAlignment(SwingConstants.RIGHT);
		user_age.setBounds(230,230,180,40);
		getContentPane().add(user_age);
		
		userAge=new JTextField(30);
		userAge.setFont(new Font("Arial Narrow",Font.BOLD,22));
		userAge.setBounds(470,230,300,40);
		getContentPane().add(userAge);

		user_sex=new JLabel("Gender");
		user_sex.setFont(new Font("Arial Narrow",Font.BOLD,22));
		//user_sex.setForeground(new Color(204,0,51));
		user_sex.setHorizontalAlignment(SwingConstants.RIGHT);
		user_sex.setBounds(230,280,180,40);
		getContentPane().add(user_sex);
		
		userSex = new JComboBox();
		userSex.addItem("None");
		userSex.addItem("female");
		userSex.addItem("male");
		userSex.setEditable(false);
		//userSex.setForeground(new Color(204,0,51));
		userSex.setFont(new Font("Arial Narrow",Font.BOLD,22));
		userSex.setBounds(470,280,300,40);
		getContentPane().add(userSex);
		userSex.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  userSexSelectedIndex = userSex.getSelectedIndex();
		    	  userSexNameSelected = (String) userSex.getSelectedItem();
		      }
		    });
		
		user_type=new JLabel("User Type");
		user_type.setFont(new Font("Arial Narrow",Font.BOLD,22));
		//user_type.setForeground(new Color(204,0,51));
		user_type.setHorizontalAlignment(SwingConstants.RIGHT);
		user_type.setBounds(230,330,180,40);
		getContentPane().add(user_type);
		
		userType = new JComboBox();
		userType.addItem("admin");
		userType.addItem("doctor");
		userType.addItem("patient");
		//userType.setForeground(new Color(204,0,51));
		userType.setFont(new Font("Arial Narrow",Font.BOLD,22));
		userType.setBounds(470,330,300,40);
		getContentPane().add(userType);
		userType.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  userTypeSelectedIndex = userType.getSelectedIndex();
		    	  userTypeNameSelected = (String) userType.getSelectedItem();
		      }
		    });
		
		user_address=new JLabel("Address");
		user_address.setFont(new Font("Arial Narrow",Font.BOLD,22));
		//user_address.setForeground(new Color(204,0,51));
		user_address.setHorizontalAlignment(SwingConstants.RIGHT);
		user_address.setBounds(230,380,180,50);
		getContentPane().add(user_address);

		 userAddress=new JTextArea(5,8);
		 userAddress.setBounds(470,380,330,80);
		 userAddress.setFont(new Font("Arial Narrow",Font.BOLD,22));
		 JScrollPane userAddressPane=new  JScrollPane(userAddress,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 getContentPane().add(userAddress);
		 
		
		submit=new JButton("ADD USER");
		submit.setFont(new Font("Arial Narrow",Font.BOLD,22));
		submit.setBounds(300,550,150,40);
		submit.setForeground(new Color(255, 255, 255));
		submit.setBackground(new Color(255, 153, 0));
		submit.addActionListener(this);
		submit.setToolTipText("Press to submit the details");
		getContentPane().add(submit); 

		
		back=new JButton("EXIT");
		back.setFont(new Font("Arial Narrow",Font.BOLD,22));            
		back.setBounds(500,550,150,40);
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(255, 153, 0));
		back.addActionListener(this);
		back.setToolTipText("Press to exit");
		getContentPane().add(back); 
		
		refresh = addButton("REFRESH","Arial Narrow",Font.BOLD,22,"resets all values");
		refresh.setBounds(700,550,150,40);
		refresh.setForeground(new Color(255, 255, 255));
		refresh.setBackground(new Color(255, 153, 0));
		refresh.addActionListener(this);
		getContentPane().add(refresh);
		
		msg = addJLabelComponent("User Created Successfully");
		msg.setFont(new Font("Arial Narrow",Font.ITALIC,22));
		msg.setBounds(300, 610, 320, 40);
		getContentPane().add(msg);
		msg.setVisible(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("EXIT")) {
			dispose();
		}
		else if(ae.getActionCommand().equals("REFRESH"))
		{
			clearValues();
		}

		else if(ae.getActionCommand().equals("ADD USER")) {
			try {
				 userNameValue = userName.getText();
				 firstNameValue = firstName.getText();
				 lastNameValue = lastName.getText();
				 userAddressValue = userAddress.getText();
				 userAgeValue  = Integer.parseInt(userAge.getText());
				 
				 
				userDetails newUserObj = new userDetails(userNameValue,userTypeNameSelected,
						firstNameValue, lastNameValue, userAgeValue,userSexNameSelected, userAddressValue);
				csvFileIO.writeCsvFile("Users.csv",newUserObj.prepareInsertStmt());
				
				clearValues();
				msg.setVisible(true);
			}
			catch(Exception ex) {  
				System.out.println(ex.getMessage()); 
				}
			}
	}

	public void clearValues()
	{
		userName.setText("");
		firstName.setText("");
		lastName.setText("");
		userAddress.setText("");
		userAge.setText("");
		userType.setSelectedIndex(0);
		userSex.setSelectedIndex(0);
		
	
		msg.setVisible(false);
	}
	
	public static void main(String args[])
	{
		new RegisterUser("title ","headerval");
	}
}