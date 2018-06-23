import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;


 public  class Pharmacy extends BasicFrameDesign implements ActionListener

	
   {
	String drugNameSelected;
	int drugCount;
	
	JLabel head,drugLabel,count,count2;
	JComboBox drugList;
	JTextField dinstock,dinstock2;
	JButton indg,updg,search,back,refresh;
	
	PharmacyDrugs drugObj= null,drugObj2=null;

    public Pharmacy(String title,String header) throws IOException
    {
       //setLayout(null);
	   setTitle(" Drug Store");
	   //setBounds(0,0,1020,725);
	   //setMinimumSize(new java.awt.Dimension(1020,720));
	   
	   head=new JLabel(" Pharmacy ");
	   head.setFont(new Font("Arial Narrow",Font.BOLD,36));
	   head.setForeground(new Color(0,0,255));
	   head.setHorizontalAlignment(SwingConstants.CENTER);
	   head.setBounds(220,40,660,50);
	   getContentPane().add(head);
         
           
        indg=new JButton("New Drug");
        indg.setFont(new Font("Arial Narrow",Font.BOLD,25));
        indg.setBounds(200,130,180,50);
        indg.setForeground(new Color(255, 255, 255));
        indg.setBackground(new Color(255, 153, 0));
        indg.setMnemonic(KeyEvent.VK_I);
        indg.addActionListener(this);
        indg.setToolTipText("Press To Enter The Drugs ");
        getContentPane().add(indg);

	    updg=new JButton("Update Drug");
	    updg.setFont(new Font("Arial Narrow",Font.BOLD,25));
	    updg.setForeground(new Color(255, 255, 255));
	    updg.setBackground(new Color(255, 153, 0));
        updg.setBounds(450,130,180,50);
	    updg.setMnemonic(KeyEvent.VK_U);
	    updg.addActionListener(this);
	    updg.setToolTipText("PRESS TO UPDATE THE DRUGS");
	    getContentPane().add(updg);
          
         search=new JButton("Search Drug");
         search.setFont(new Font("Arial Narrow",Font.BOLD,25));
         search.setForeground(new Color(255, 255, 255));
         search.setBackground(new Color(255, 153, 0));
         search.setBounds(700,130,180,50);
         search.setMnemonic(KeyEvent.VK_K);
         search.addActionListener(this);
         search.setToolTipText("PRESS TO KNOW ABOUT THE DRUGS STOCK");
         getContentPane().add(search);

         
         
        drugLabel = addHeader("Select Drug","Arial Narrow",Font.BOLD,20,SwingConstants.LEFT);
 		drugLabel.setForeground(new Color(0,0,0));
 		drugLabel.setBounds(350,220,200,40);
 		getContentPane().add(drugLabel);
 		drugLabel.setVisible(false);
 		
 	
 		
 		
 		
 		drugList = new JComboBox<String>();
 		//drugList.setForeground(new Color(255,51,255));
 		drugList.setFont(new Font("Arial Narrow",Font.PLAIN,20));
 		drugList.setBounds(600,220,200,40);
 		drugList.setEditable(true);
 		getContentPane().add(drugList);
 		drugList.setVisible(false);
		
		drugList.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  drugNameSelected = (String) drugList.getSelectedItem();
		    	  try {
					String drugStr = csvFileIO.readRecordFromCsvFile("Drugs.csv", 0, drugNameSelected.trim());
					
					if(drugStr!=null)
					{
						 drugObj = new PharmacyDrugs(drugStr);
						 if(drugObj!=null)
						 {
							 dinstock.setText(drugObj.getDrugCount()+"");
							
						 }
						 
					}
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		      }
		    });
		
		
 		
 		count=new JLabel("Available Quantity");
 	    count.setFont(new Font("Arial Narrow",Font.BOLD,20));
 	    count.setForeground(new Color(0,0,0));
 	    count.setHorizontalAlignment(SwingConstants.LEFT);
 	    count.setBounds(350,300,200,40);
 		getContentPane().add(count);
 		count.setVisible(false);
 		
 		 dinstock=new JTextField(30);
 		  dinstock.setFont(new Font("Arial Narrow",Font.BOLD,20));
 	      dinstock.setBounds(600,300,200,40);
 	      getContentPane().add(dinstock);
 	      dinstock.setEnabled(false);
 	      dinstock.setVisible(false);
 		 
 	      
 	     count2=new JLabel("Add Quantity");
  	    count2.setFont(new Font("Arial Narrow",Font.BOLD,20));
  	    count2.setForeground(new Color(0,0,0));
  	    count2.setHorizontalAlignment(SwingConstants.LEFT);
  	    count2.setBounds(350,360,200,40);
  		getContentPane().add(count2);
  		count2.setVisible(false);
  		
  		 dinstock2=new JTextField(30);
  		  dinstock2.setFont(new Font("Arial Narrow",Font.BOLD,20));
  	      dinstock2.setBounds(600,360,200,40);
  	      getContentPane().add(dinstock2);
  	      dinstock2.setVisible(false);  
         
	   
	   back=new JButton("BACK");
	   back.setFont(new Font("Arial Narrow",Font.BOLD,25));
	   back.setForeground(new Color(204,0,0));
 	   back.setBounds(300,580,200,40);
       back.setMnemonic(KeyEvent.VK_B);
       back.addActionListener(this);
       back.setToolTipText("Press to return - Home Page");
       getContentPane().add(back);
       
       
	   back=new JButton("REFRESH");
	   back.setFont(new Font("Arial Narrow",Font.BOLD,25));
	   back.setForeground(new Color(204,0,0));
 	   back.setBounds(520,580,250,40);
       back.setMnemonic(KeyEvent.VK_B);
       back.addActionListener(this);
       back.setToolTipText("Reset values");
       getContentPane().add(back);
       }

       public void actionPerformed(ActionEvent ae)
       {
 
    	   if(ae.getActionCommand().equals("BACK"))
    	   	{			
	    	 dispose();
    	   	}
    	   else if(ae.getActionCommand().equals("REFRESH"))
    	   {			
	    	 clearAll();
   	   		}
    	   else if(ae.getActionCommand().equals("New Drug"))
    	   	{
               new AddDrug("Add New Drug ","Add New Drug");
               updg.setEnabled(false);
               search.setEnabled(false);
		          
             }
    	   else if(ae.getActionCommand().equals("Add Quantity"))
		   {
    		   
    		   int addQuantity = Integer.parseInt(dinstock2.getText());
    		   int currQuantity = Integer.parseInt(dinstock.getText());
    		   int updatedQuanity = currQuantity+addQuantity;
    		   
    		   if(drugNameSelected!=null && addQuantity!=0)
    		   {
    			   try {
					String drgObjStr2 = csvFileIO.readRecordFromCsvFile("Drugs.csv", 0, drugNameSelected);
					drugObj2 = new PharmacyDrugs(drgObjStr2);
				    drugObj2.setDrugCount(updatedQuanity);
				    
				    csvFileIO.updatecsvFileRecord("Drugs.csv", 0, drugNameSelected,drugObj2.prepareDrugInsertStmt());
					updg.setText("Update Drug");  
					clearAll();
					
    			   	} 
    			   catch (IOException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
						updg.setText("Update Drug");
						clearAll();
					}			   
    		   }
    			   

			   
		   }
    	   else if(ae.getActionCommand().equals("Update Drug"))
    			   {
    		        clearAll();
    		   		List<String> drugValues = new ArrayList<String>();
    		   		try {
					drugValues = csvFileIO.readCsvFileColumnValues("Drugs.csv",0);
    		   		} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
    		   		}
   	 		
    		   		// create an empty combo box with items of type String
   	 		        drugList.removeAllItems();
    		   		for(String temp : drugValues)
    		   		{   if(temp!=null && temp!="")
    		   			drugList.addItem(temp);
    		   		}

    		   		
    		   		drugLabel.setVisible(true);
    		   		count.setVisible(true);
    		   		drugList.setVisible(true);
    		   		dinstock.setVisible(true);
    		   		indg.setEnabled(false);
    	            search.setEnabled(false);
   		            count2.setVisible(true);
   		            dinstock2.setVisible(true);
   		            updg.setText("Add Quantity");
    				   
    			   }
    	   else if(ae.getActionCommand().equals("Search Drug"))
   	   	   {
    		    clearAll();
    		   
    	 		
    	 		List<String> drugValues = new ArrayList<String>();
				try {
					drugValues = csvFileIO.readCsvFileColumnValues("Drugs.csv",0);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	 		
				 drugList.removeAllItems();
    	 		// create an empty combo box with items of type String
    	 		
    	 	    for(String temp : drugValues)
    	 	    {
    	 	    	drugList.addItem(temp);
    	 	    }

    	 	   
    		    drugLabel.setVisible(true);
    		    count.setVisible(true);
    		    drugList.setVisible(true);
    		    dinstock.setVisible(true);
    		    updg.setEnabled(false);
    		    indg.setEnabled(false);
		          
            }
			
         }//action Perfomed
       
       public void clearAll()
       {
    	    drugLabel.setVisible(false);
		    count.setVisible(false);
		    count2.setVisible(false);
		    drugList.setVisible(false);
		    dinstock.setVisible(false);
		    dinstock2.setText("");
		    dinstock2.setVisible(false);
		    indg.setEnabled(true);
		    updg.setEnabled(true);
		    search.setEnabled(true);
		   
       }
}



