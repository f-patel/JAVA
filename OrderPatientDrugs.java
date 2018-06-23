import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class OrderPatientDrugs extends BasicFrameDesign implements ActionListener {

	public JLabel head , drugLabel, patientLabel, count,warn1,msg;
	public JComboBox<String> drugList, patientList;
	public JTextField dinstock;
	public String drugNameSelected;
	int quantityValue,drugSelctedIndex;
	JButton submit,back,refresh;
	
	public OrderPatientDrugs(String title,String header) throws IOException
	{
		
		setTitle(title);
		head = super.addHeader(header,"Arial Narrow",Font.BOLD,25,SwingConstants.CENTER);
		head.setForeground(new Color(0,0,255));
		head.setBounds(300,0,570,60);
		getContentPane().add(head);
		
		
		patientLabel = addHeader("Select Patient","Arial Narrow",Font.BOLD,24,SwingConstants.LEFT);
		patientLabel.setForeground(new Color(0,0,0));
		patientLabel.setBounds(200,100,200,40);
		getContentPane().add(patientLabel);
		
		List<String> patientValues = csvFileIO.readCsvFileColumnValues("Users.csv",0);
		
		// create an empty combo box with items of type String
		patientList = new JComboBox<String>();
		//drugList.setForeground(new Color(255,51,255));
		patientList.setFont(new Font("Arial Narrow",Font.PLAIN,22));
		patientList.setBounds(350,100,200,40);
		patientList.setEditable(true);
		patientList.setVisible(true);
		patientList.addItem("--None--");
	    for(String temp :patientValues)
	    {
	    	patientList.addItem(temp);
	    }
		
		getContentPane().add(patientList);
		
		
		drugLabel = addHeader("Select Drug","Arial Narrow",Font.BOLD,24,SwingConstants.LEFT);
		drugLabel.setForeground(new Color(0,0,0));
		drugLabel.setBounds(200,150,200,40);
		getContentPane().add(drugLabel);
		
		List<String> drugValues = csvFileIO.readCsvFileColumnValues("Drugs.csv",0);
		
		// create an empty combo box with items of type String
		drugList = new JComboBox<String>();
		//drugList.setForeground(new Color(255,51,255));
		drugList.setFont(new Font("Arial Narrow",Font.PLAIN,22));
		drugList.setBounds(350,150,200,40);
		drugList.setEditable(true);
		drugList.setVisible(true);
		drugList.addItem("--None--");
	    for(String temp :drugValues)
	    {
	    	drugList.addItem(temp);
	    }
		
		getContentPane().add(drugList);
		
		
		count=new JLabel("Quantity");
	    count.setFont(new Font("Arial Narrow",Font.BOLD,24));
	    count.setForeground(new Color(0,0,0));
	    count.setHorizontalAlignment(SwingConstants.LEFT);
	    count.setBounds(200,200,100,40);
		getContentPane().add(count);
		
		 dinstock=new JTextField(30);
		  dinstock.setFont(new Font("Arial Narrow",Font.BOLD,22));
	      dinstock.setBounds(350,200,200,40);
	      getContentPane().add(dinstock);
		  
		  warn1=new JLabel("(Enter only Integers)");
		  warn1.setFont(new Font("Arial Narrow",Font.BOLD,18));
		  warn1.setForeground(new Color(0,0,0));
		  warn1.setHorizontalAlignment(SwingConstants.LEFT);
	      warn1.setBounds(350,250,170,40);
		  getContentPane().add(warn1);
		

		
		drugList.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  drugSelctedIndex = drugList.getSelectedIndex();
		    	  drugNameSelected = (String) drugList.getSelectedItem();
		      }
		    });
		
		submit=new JButton("SUBMIT");
	       submit.setFont(new Font("Arial Narrow",Font.BOLD,22));
	       submit.setBounds(200,480,230,50);
	       submit.setForeground(new Color(255, 255, 255));
	       submit.setBackground(new Color(255, 153, 0));
	       submit.setMnemonic(KeyEvent.VK_S);
	       submit.addActionListener(this);
	       submit.setToolTipText("Press to submit the detials");
	       getContentPane().add(submit); 

	       back=new JButton("BACK");
	       back.setFont(new Font("Arial Narrow",Font.BOLD,22));
	       back.setBounds(470,480,220,50);
	       back.setForeground(new Color(255, 255, 255));
	       back.setBackground(new Color(255, 153, 0));
	       back.setMnemonic(KeyEvent.VK_B);
	       back.addActionListener(this);
	       back.setToolTipText("PRESS TO DISPOSE");
	       getContentPane().add(back); 

	       refresh = addButton("REFRESH","Arial Narrow",Font.BOLD,22,"Clear All Values");
	       refresh.setBounds(730,480,220,50);
	       refresh.setForeground(new Color(255, 255, 255));
	       refresh.setBackground(new Color(255, 153, 0));
	       refresh.addActionListener(this);
	       getContentPane().add(refresh); 
	       
	       msg = super.addJLabelComponent("Order placed successfully!");
	       msg.setFont(new Font("Arial Narrow",Font.BOLD,22));
	       msg.setBounds(200,520,800,50);
	       getContentPane().add(msg); 
	       msg.setVisible(false);
	      
		
	}

	
    public void actionPerformed(ActionEvent ae)
    {
	  if(ae.getActionCommand().equals("BACK"))
        	 	dispose();
	  else  if(ae.getActionCommand().equals("REFRESH"))
  	 	clearAll();

	    else if(ae.getActionCommand().equals("SUBMIT")) {
                try {
                	
						if(drugSelctedIndex!=0)
						{	
						quantityValue =  Integer.parseInt( dinstock.getText());
						
						String drugRecordDetails = csvFileIO.readRecordFromCsvFile("Drugs.csv",0,drugNameSelected);
						PharmacyDrugs drugObj = new  PharmacyDrugs(drugRecordDetails);
						if(drugObj.getDrugStatus() && (drugObj.getDrugCount() >= quantityValue)) {
						
						int drugAvailableQuantity = drugObj.getDrugCount();
						
						DrugOrders newOrder = new DrugOrders(drugNameSelected,quantityValue);
						csvFileIO.writeCsvFile("DrugsOrders.csv",newOrder.prepareDrugOrderInsertStmt());
						
						drugAvailableQuantity = drugAvailableQuantity -  quantityValue;
						drugObj.setDrugCount(drugAvailableQuantity);
						
						csvFileIO.updatecsvFileRecord("Drugs.csv",0,drugNameSelected,drugObj.prepareDrugInsertStmt());
						
						clearAll();
						msg.setText("Placed Order Successfully !");
						msg.setVisible(true);
						}
						else
							{
							msg.setText("Sorry ! Requested Quantity not available .Please place order agian");
							msg.setVisible(true);
							}
						}
						else
							{
							clearAll();
							msg.setText("Re-enter order ! Invalid Selction");
							msg.setVisible(true);
							}
				    }

                	catch(Exception ex) {  System.out.println(ex.getMessage()); 
                	}
               		
	       }
    }
  
  public void clearAll()
  {
	  dinstock.setText("");
	  drugList.setSelectedIndex(0);
	  msg.setVisible(false);
  }
	
	public static void main(String args[]) throws IOException
	{
		new OrderPatientDrugs("Order Patient Drugs","Order Patient Drugs");
	}
}
