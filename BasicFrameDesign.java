
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
 
public class BasicFrameDesign extends JFrame{
   
	public String frameName;
	public String frameHeader;
	
	public BasicFrameDesign()
	{
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(null);
	        setBounds(0,0,1200, 900);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        setBackground(Color.blue);
	        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we)
	           {

	            dispose();

	           }

         });
	}
	
	public void paint(Graphics draw){
	      getContentPane().setBackground(new Color(147, 214, 206));
	    }
	
	public JLabel addJLabelComponent(String labelName)
	{
		JLabel label = new JLabel(labelName);
		return label;
		
	}
	
	public JLabel addHeader(String headerName,String fontName,int fontStyle,int fontSize,int HAlign)
	{
		JLabel label = addJLabelComponent(headerName);
        label.setFont(new Font(fontName,fontStyle,fontSize));
        label.setHorizontalAlignment(HAlign);
		return label;
	}
	
	public JButton addButton(String buttonName,String fontName,int fontStyle,int fontSize,String toolTip) {
    JButton button = new JButton(buttonName);
	button.setFont(new Font(fontName,fontStyle,fontSize));
	button.setForeground(new Color(255, 255, 255));
	button.setToolTipText(toolTip);
	button.setBackground(new Color(255, 153, 0));
	return button;
	}
	
}
