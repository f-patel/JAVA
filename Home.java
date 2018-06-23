import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class Home extends BasicFrameDesign implements ActionListener {
	   
	   JButton register,drugStore,managePatientDrugs,exit;
	   JLabel hcms,homePage,image;

	    public Home(String name , String header) {
	    	 setTitle(name);
             hcms = super.addHeader(header,"Arial Narrow",Font.BOLD,45,SwingConstants.CENTER);
             hcms.setBounds(200,20,780,70);
             getContentPane().add(hcms);
             
		    register = super.addButton("Register User", "Arial Narrow", Font.BOLD, 22,
		    		" Create new patient record ");
		    register.setBounds(100,120,200,40);
	        register.addActionListener(this);
	        getContentPane().add(register);
	           
	        drugStore = super.addButton("Manage Drug"," Arial Narrow", Font.BOLD, 22,
		    		"Check / update available drugs");
		    drugStore.setBounds(320,120,200,40);
	        drugStore.addActionListener(this);
	        getContentPane().add(drugStore);
            
	        managePatientDrugs = super.addButton("Manage Patient Drug"," Arial Narrow", Font.BOLD, 22,
		    		"Check / update patient drugs");
	        managePatientDrugs.setBounds(540,120,260,40);
	        managePatientDrugs.addActionListener(this);
	        getContentPane().add(managePatientDrugs);
            
	        
	        exit = super.addButton("Exit"," Arial Narrow", Font.BOLD, 22,
		    		"Close Application");
		    exit.setBounds(820,120,240,40);
		    exit.addActionListener(this);
	        getContentPane().add(exit);
	        
	        setVisible(true);

	 }

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			      if(ae.getActionCommand().equals("Exit"))
			    	  	dispose();

		           else if(ae.getActionCommand().equals("Register User")) {
		        	 new RegisterUser("Add Users ","Add New User");
		           }
		           else if(ae.getActionCommand().equals("Manage Patient Drug")) {
			        	 try {
							new OrderPatientDrugs("Order Patient Drugs","Order Patient Drugs");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			           }
		           else if(ae.getActionCommand().equals("Manage Drug")) {
		               try {
						new Pharmacy("Drug Store","HCMS - Pharmacy");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		           }
		   
		}
}
