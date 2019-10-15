package customerproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminProcess {
	public void admin() throws IOException, ClassNotFoundException, SQLException
	{
		connection con=new connection();
		Statement statement=con.connections().createStatement();
		//int ch;
		char option;
		int pdtid,minquantity,price;
		String pdtname;
		do
		{

		System.out.println("\n1.Add Product");
		System.out.println("2.Display Inventory List");
		System.out.println("3.Logout");
		System.out.println("Choose Your option");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner inp = new Scanner(System.in);
		option=(char)br.read();
		switch(option)
		{
		case '1': 
			System.out.println("product id:");
			pdtid=inp.nextInt();
		
			System.out.println("product name:");
			inp.nextLine();
			pdtname=inp.nextLine();
			System.out.println("Minimum Sell Quality:");
			minquantity=inp.nextInt();
			System.out.println("Price:");
			price=inp.nextInt();
			statement.executeUpdate("INSERT INTO admin (product_id,product_name,minsellquantity,price) VALUES ('"+pdtid+"','"+pdtname+"','"+minquantity+"','"+price+"')");
			
		break;
		case '2':
			String sql = "SELECT product_id, product_name, minsellquantity, price FROM admin";
		      ResultSet rs = statement.executeQuery(sql);
		      System.out.println("product id  product name minsellquantity price");
		      while(rs.next()){
		         
		         int pdtid1  = rs.getInt("product_id");
		         
		         String pdtname1 = rs.getString("product_name");
		         
		         int minquantity1  = rs.getInt("minsellquantity");
		         int price1  = rs.getInt("price");
		         

		         
		         System.out.print(pdtid1+"               ");
		         System.out.print(pdtname1+"           ");
		         System.out.print(minquantity1+"      ");
		         System.out.println(price1);
		      }  
		
		case '3':System.exit(0);break;
		

		}
		//System.out.println("Do you want to continue?(1/0)");
		// ch=Integer.parseInt(br.readLine());
		}while(option!='3');
	}

}
