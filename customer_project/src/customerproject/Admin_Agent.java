package customerproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Admin_Agent 
{
	static login objlogin= new login();
	public static void main(String[] args)
	{
		JFrame f=new JFrame("OPTION");
		JLabel head;
		head=new JLabel("OPTION");
		head.setForeground(Color.BLUE);
		head.setBounds(100,100,200,30);
		JButton b=new JButton("ADMIN LOGIN");
		b.setBounds(100,100,200,40);
		JButton b2=new JButton("AGENT LOGIN");
	    b2.setBounds(100,150,200,40);
	    JButton b3=new JButton("EXIT");
	    b3.setBounds(100,200,200,40);
	    b.addActionListener(new ActionListener()
	    {  
    	    public void actionPerformed(ActionEvent e)
    	    {  
    	    	    
					try {
						objlogin.loginadmin();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
    	    }
    	    
    	    }
	    );
	    b2.addActionListener(new ActionListener(){  
    	    public void actionPerformed(ActionEvent e){  
    	    	try {
					login objlogin= new login();
					objlogin.loginagent();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    	
    	    }
    	    
    	    });
	    b3.addActionListener(new ActionListener(){  
    	    public void actionPerformed(ActionEvent e){  
    	    	System.exit(0);
    	    	
    	    }
    	    
    	    });
	    
	    f.add(b);
	    f.add(b2);
	    f.add(b3);
		f.setSize(400,500);
    	f.setLayout(null);
    	f.setVisible(true);
}
	}
	


