import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;


 public class AddDrug extends BasicFrameDesign implements ActionListener
  {

    String drugName;
    int drugCount;
    JLabel shead,ssub,dname,instock,exda1,exda2,warn1,msg;
    JTextField dtext,dinstock,dexda1,dexda2;
    JButton submit,back,refresh;
    
     public AddDrug(String title,String header)
     {
      setTitle(title);
      
	  shead = addHeader(header,"Arial Naroow",Font.BOLD,40,SwingConstants.CENTER);
	  shead.setForeground(new Color(0,0,255));
      shead.setBounds(250,20,460,60);
	  getContentPane().add(shead);
	
	  dname=new JLabel("Drug Name");
	  dname.setFont(new Font("Arial Narrow",Font.BOLD,24));
	  dname.setForeground(new Color(0,0,0));
	  dname.setHorizontalAlignment(SwingConstants.LEFT);
      dname.setBounds(70,130,180,40);
	  getContentPane().add(dname);
	
      instock=new JLabel("Quantity");
	  instock.setFont(new Font("Arial Narrow",Font.BOLD,24));
	  instock.setForeground(new Color(0,0,0));
	  instock.setHorizontalAlignment(SwingConstants.LEFT);
      instock.setBounds(70,214,180,40);
	  getContentPane().add(instock);
	  
	  warn1=new JLabel("(Enter only Integers)");
	  warn1.setFont(new Font("Arial Narrow",Font.BOLD,20));
	  warn1.setForeground(new Color(0,0,0));
	  warn1.setHorizontalAlignment(SwingConstants.LEFT);
      warn1.setBounds(250,255,170,40);
	  getContentPane().add(warn1);
	  
	  dtext=new JTextField(30);
	  dtext.setFont(new Font("Arial Narrow",Font.BOLD,22));
      dtext.setBounds(250,130,430,40);
      getContentPane().add(dtext);

		
      dinstock=new JTextField(30);
	  dinstock.setFont(new Font("Arial Narrow",Font.BOLD,22));
      dinstock.setBounds(250,215,430,40);
      getContentPane().add(dinstock);
  
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
       back.setToolTipText("Press to go back");
       getContentPane().add(back); 

       refresh = addButton("REFRESH","Arial Narrow",Font.BOLD,22,"Clear All Values");
       refresh.setBounds(730,480,220,50);
       refresh.setForeground(new Color(255, 255, 255));
       refresh.setBackground(new Color(255, 153, 0));
       refresh.addActionListener(this);
       getContentPane().add(refresh); 
       
       msg = super.addJLabelComponent("Added Drug Successfully !");
       msg.setFont(new Font("Arial Narrow",Font.BOLD,22));
       msg.setBounds(200,520,230,50);
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
							drugName = dtext.getText();
							drugCount =  Integer.parseInt( dinstock.getText());
							
							PharmacyDrugs newDrug = new PharmacyDrugs(drugName,drugCount);
							csvFileIO.writeCsvFile("Drugs.csv",newDrug.prepareDrugInsertStmt());
							
							clearAll();
							msg.setVisible(true);
					    }

                    	catch(Exception ex) {  System.out.println(ex.getMessage()); 
                    	}
                   		
    	       }
        }
      
      public void clearAll()
      {
    	  dinstock.setText("");
    	  dtext.setText("");   
    	  msg.setVisible(false);
      }
}





   