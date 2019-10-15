package customerproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AgentProcess {
	public void agent(String uname,String password) throws IOException, ClassNotFoundException, SQLException
	{
		connection con=new connection();
		Statement statement=con.connections().createStatement();
		
		char option;
		String confirm;
		int pdtid,minquantity,price;
		String pdtname,buy;
		int totalcost;
		 String pdtname1 = null;
		 int minquantity1 = 0;
		 int price1 = 0,price11 = 0;
		do
		{

		System.out.println("\n1.BUY/SELL");
		System.out.println("2.SHOW HISTORY");
		System.out.println("3.LOGOUT");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner inp = new Scanner(System.in);
		option=(char)br.read();
		switch(option)
		{
		case '1': 
			System.out.println("product id:");
			pdtid=inp.nextInt();
			inp.nextLine();
			System.out.println("enter buy or sell(buy/sell)");
			buy=inp.nextLine();
			if(buy.equalsIgnoreCase("BUY"))
			{
				String sql = "SELECT  product_name, price FROM admin where product_id='"+pdtid+"'";
			      ResultSet rs = statement.executeQuery(sql);
			      System.out.println(" product name  price");
			      while(rs.next()){   
			         pdtname1 = rs.getString("product_name");
			          price11  = rs.getInt("price");
	                 System.out.print(pdtname1+"           ");
			         System.out.println(price11);
			      }  
			      
			      System.out.println("Enter Quantity:");
					minquantity=inp.nextInt();
					 rs = statement.executeQuery("SELECT  minsellquantity,price FROM admin where product_id='"+pdtid+"'"); 
					 while(rs.next()){
				         
				       minquantity1  = rs.getInt("minsellquantity");
				       price1  = rs.getInt("price");
					 }
			   if(minquantity>minquantity1)
			   {
				   System.out.println("only "+minquantity1+" quantity  is available");
			   }
			   else
			   {
				   totalcost=minquantity*price1;
				   System.out.println("Total cost="+totalcost);
				   System.out.println("Do you want to confirm booking(yes/no)");
				   inp.nextLine();
				   confirm=inp.nextLine();
				   if(confirm.equalsIgnoreCase("YES")) {
					   
					   statement.executeUpdate("INSERT INTO agent (username,password,transaction,product_id,product_name,total_cost,quantity,price) VALUES ('"+uname+"','"+password+"','"+buy+"','"+pdtid+"','"+pdtname1 +"','"+totalcost+"','"+minquantity+"','"+price11+"')");
					   minquantity1=minquantity1-minquantity;
					   String sql11 = "UPDATE admin SET minsellquantity =minquantity1  WHERE product_id='"+pdtid+"'";
			           statement.executeUpdate(sql11);
				   }
			   }
			   
			}
			break;
		case '2':
			//login obj=new login();
			
			String sqll = "SELECT transaction,product_id,product_name,total_cost,quantity,price FROM agent where username='"+uname+"' AND password='"+password+"'";
			ResultSet rs1 = statement.executeQuery(sqll);
             while(rs1.next()){
            	 String transaction = rs1.getString("transaction");
		         int pdtid1  = rs1.getInt("product_id");  
		         String pdtnam1 = rs1.getString("product_name");
		         int totalcostt  = rs1.getInt("total_cost");
		         int minquantity11  = rs1.getInt("quantity");
		         int price12  = rs1.getInt("price");
		         

		         System.out.print(transaction+"               ");
		         System.out.print(pdtid1+"               ");
		         System.out.print(pdtname1+"           ");
		         System.out.print(totalcostt+"      ");
		         System.out.print(minquantity11+"      ");
		         System.out.println(price12);
		      }  
		
		case '3':
			Admin_Agent.main(null);
			break;
		

			
			
		}
			
			
		
		
		}while(option!='2');
		}

	}


