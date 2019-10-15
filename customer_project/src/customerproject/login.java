package customerproject;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class login {
    AgentProcess objagent= new AgentProcess();
    AdminProcess objadmin=new AdminProcess();
    connection con=new connection();

	public void loginadmin() throws ClassNotFoundException, SQLException 
	{
		JFrame f=new JFrame("LOGIN ");
		JLabel user,pwd,head;
		head=new JLabel("LOGIN");
		head.setForeground(Color.BLUE);
		
		head.setBounds(150,50,250,30);

		user=new JLabel("User name");
		
		user.setBounds(100,100,100,30);

		JTextField tf=new JTextField();  
		   tf.setBounds(200,100, 150,20);  
		   pwd=new JLabel("Password");
		  
		
		   pwd.setBounds(100,150,100,30);

		JTextField tl=new JTextField();  
		   tl.setBounds(200,150, 150,20);
		   f.add(user);
		   f.add(tf);
		   f.add(pwd);
		   f.add(tl);
		   
		   //<a href="">Pictures of Me</a>
		   JButton b=new JButton("SUBMIT");
		  
		   
			
		   b.setBackground(Color.GREEN);
		   b.setBounds(100,200,100,40);
		   JButton b2=new JButton("CANCEL");
		   
		   
			
		   b2.setBackground(Color.RED);
		   b2.setBounds(250,200,100,40);
		   
		   b2.addActionListener(new ActionListener(){  
	    	    public void actionPerformed(ActionEvent e){  
	    	    	tf.setText("");
	    	    	tl.setText("");
	    	    }
	    	    
	    	    });
        b.addActionListener(new ActionListener()
        {  
    	    public void actionPerformed(ActionEvent e)
    	    {  
    	    	String uname,password;
    	    	uname=tf.getText();
    	    	password=tl.getText();
    	    	Statement statement = null;
				try {
					statement = con.connections().createStatement();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 connection con=new connection();
				try {
					statement = con.connections().createStatement();
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
    	    	ResultSet rs = null;
					try {
						rs = statement.executeQuery("select username,password from admin where username='"+uname+"' AND password='"+password+"'");
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
    	    	try {
					if(rs.next()){
						
						AdminProcess objadmin= new AdminProcess();
						try {
							objadmin.admin();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
					else{
						JOptionPane.showMessageDialog(null,"Invalid Username or Password");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    	    }
        });
        f.add(b2);   
        f.add(b);
  	  
		//JOptionPane.showMessageDialog(controllingFrame,"Success! You typed the right password.");
    	   
    		
    	f.setSize(500,600);
    	f.setLayout(null);

    	f.setVisible(true);
	}
	
	
	public void loginagent() throws ClassNotFoundException, SQLException 
	{
		
	    connection con=new connection();
		Statement statement=con.connections().createStatement();
		JFrame f=new JFrame("LOGIN ");
		JLabel user,pwd,head;
		head=new JLabel("LOGIN");
		head.setForeground(Color.BLUE);
		
		head.setBounds(150,50,250,30);

		user=new JLabel("User name");
		
		user.setBounds(100,100,100,30);

		JTextField tf=new JTextField();  
		   tf.setBounds(200,100, 150,20);  
		   pwd=new JLabel("Password");
		  
		
		   pwd.setBounds(100,150,100,30);

		JTextField tl=new JTextField();  
		   tl.setBounds(200,150, 150,20);
		   f.add(user);
		   f.add(tf);
		   f.add(pwd);
		   f.add(tl);
		   
		   //<a href="">Pictures of Me</a>
		   JButton b=new JButton("SUBMIT");
		  
		   
			
		   b.setBackground(Color.GREEN);
		   b.setBounds(100,200,100,40);
		   JButton b2=new JButton("CANCEL");
		   
		   
			
		   b2.setBackground(Color.RED);
		   b2.setBounds(250,200,100,40);
		   
		   b2.addActionListener(new ActionListener(){  
	    	    public void actionPerformed(ActionEvent e){  
	    	    	tf.setText("");
	    	    	tl.setText("");
	    	    }
	    	    
	    	    });
        b.addActionListener(new ActionListener(){  
    	    public void actionPerformed(ActionEvent e){  
    	    	String uname,password;
    	    	uname=tf.getText();
    	    	password=tl.getText();
    	    	
    	    	
    	   
    	    	ResultSet rs = null;
				
					try {
						rs = statement.executeQuery("select username,password from agent where username='"+uname+"' AND password='"+password+"'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// TODO Auto-generated catch block
					try {
						if(rs.next()){
							
								objagent.agent(uname,password);
						}
						else{
							JOptionPane.showMessageDialog(null,"Invalid Username or Password");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
        });
        f.add(b2);   
        f.add(b);
  	  
		//JOptionPane.showMessageDialog(controllingFrame,"Success! You typed the right password.");
    	   
    		
    	f.setSize(500,600);
    	f.setLayout(null);

    	f.setVisible(true);
	}

}

