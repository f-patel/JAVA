import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginModule extends BasicFrameDesign implements ActionListener{
	JLabel head,user_name,password,msg;
	JTextField userNameValue,passwordValue;
	JButton submit,exit,refresh;
    
	String userName,userPassword;

	public LoginModule(String title , String header){
	setTitle(title);

	
	// top to bottom
	head = super.addHeader(header,"Arial Narrow",Font.BOLD,35,SwingConstants.CENTER);
	head.setForeground(new Color(0,0,255));
	head.setBounds(100,40,1000,40);
	getContentPane().add(head);

	user_name=new JLabel("User ID");
	user_name.setFont(new Font("Arial Narrow",Font.BOLD,25));
	user_name.setHorizontalAlignment(SwingConstants.LEFT);
	user_name.setBounds(300,180,100,40);
	getContentPane().add(user_name);
	
	userNameValue=new JTextField(30);
	userNameValue.setFont(new Font("Arial Narrow",Font.BOLD,25));
	userNameValue.setBounds(450,180,200,40);
	getContentPane().add(userNameValue);

	password=new JLabel("Password");
	password.setFont(new Font("Arial Narrow",Font.BOLD,25));
	password.setHorizontalAlignment(SwingConstants.LEFT);
	password.setBounds(300,250,100,40);
	getContentPane().add(password);
	
	passwordValue=new JPasswordField(30);
	passwordValue.setFont(new Font("Arial Narrow",Font.BOLD,25));
	passwordValue.setBounds(450,250,200,40);
	getContentPane().add(passwordValue);
	
	submit=new JButton("LOGIN");
	submit.setFont(new Font("Arial Narrow",Font.BOLD,18));
	submit.setBounds(300,400,120,40);
	submit.setForeground(new Color(255, 255, 255));
	submit.setBackground(new Color(255, 153, 0));
	submit.setMnemonic(KeyEvent.VK_S);
	submit.addActionListener(this);
	submit.setToolTipText("Press to submit the details");
	getContentPane().add(submit); 

	
	exit=new JButton("EXIT");
	exit.setFont(new Font("Arial Narrow",Font.BOLD,18));            
	exit.setBounds(450,400,120,40);
	exit.setForeground(new Color(255, 255, 255));
	exit.setBackground(new Color(255, 153, 0));
	exit.addActionListener(this);
	exit.setToolTipText("Press to Create New patient");
	getContentPane().add(exit); 
	
	refresh = addButton("REFRESH","Arial Narrow",Font.BOLD,18,"resets all values");
	refresh.setBounds(600,400,120,40);
	refresh.addActionListener(this);
	getContentPane().add(refresh);
	
	msg =  addJLabelComponent("Invalid Username or Password.");
	msg.setFont(new Font("Arial Narrow",Font.BOLD,16));
	msg.setForeground(new Color(255,0,0));
	msg.setBounds(300,450,300,40);
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

		else if(ae.getActionCommand().equals("LOGIN")) {
			try {
				 userName = userNameValue.getText();
				 userPassword = passwordValue.getText();
				 userDetails userObj = null;
					
				
				String userRecordStr = csvFileIO.readRecordFromCsvFile("Users.csv", 0, userName.trim());
				
				if(userRecordStr!=null)
				 userObj = new userDetails(userRecordStr);
				
				if(userObj!=null && (userPassword.equals(userObj.getPassword().trim())) && !(userObj.getUserType().trim().equals("patient")))
				{
					
					new Home("Home","Admin System");
					this.dispose();
				}
				else if(userObj!=null && (userPassword.equals(userObj.getPassword().trim())) && (userObj.getUserType().trim().equals("patient")))
				{
					new HomePatient("Home","Patient Sytem");
					this.dispose();
				}
				
				else
				{
					clearValues();
					msg.setVisible(true);
				}
					
			}
			catch(Exception e){
				dispose();
			}
			
		}
		
	}
		
	public void clearValues()
	{
		userNameValue.setText("");
		passwordValue.setText("");
		msg.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LoginModule("Login - HealthCare System", "Login - HealthCare System");

	}

}
