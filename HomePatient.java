import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class HomePatient extends BasicFrameDesign implements ActionListener {
	   
	   JButton order,refresh,exit;
	   JLabel hcms,homePage,image;

	    public HomePatient(String name , String header) {
	    	 setTitle(name);
             hcms = super.addHeader(header,"Arial Narrow",Font.BOLD,45,SwingConstants.CENTER);
             hcms.setBounds(200,20,780,70);
             getContentPane().add(hcms);
             
		  
	           
	        order = super.addButton("Order Drugs"," Arial Narrow", Font.BOLD, 22,
		    		"Check / update available drugs");
		    order.setBounds(300,100,240,40);
	        order.addActionListener(this);
	        getContentPane().add(order);
                                                                           
	        exit = super.addButton("Exit"," Arial Narrow", Font.BOLD, 22,
		    		"Close Application");
		    exit.setBounds(600,100,240,40);
		    exit.addActionListener(this);
	        getContentPane().add(exit);
	        
	        setVisible(true);

	 }

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			      if(ae.getActionCommand().equals("Exit"))
			    	  	dispose();

		           else if(ae.getActionCommand().equals("Order Drugs")) {
		        	   try {
						new PlaceDrugOrder("Place Order for Drugs","Place order for Drugs");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		       	
		           }
		   
		}
}
