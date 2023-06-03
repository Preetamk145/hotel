package Foodorder;

import java.util.*;
import java.util.Date;
import java.sql.*;

public class order {

	public static void main(String[] args) throws SQLException {
		String password="abcde";
		ResultSet rs=null;
		while(true)
		{
			int ch;
			database.connectToDatabase();
			
			System.out.println("***** Welcome to our restaurant *****");
			System.out.println("Choose one \n1.Admin login 2.Order food");
			Scanner s =new Scanner(System.in);
			ch=s.nextInt();
			if(ch==1)
			{
				String pass;
				int c;
				System.out.print("enter the password\n");
				pass=s.next();
				if(pass.equals(password))
				{
					while(true)
					{
				    	System.out.println("Choose one \n1.Check food list 2.Add more food 3.Update price 4.exit");
				    	c=s.nextInt();
				    	if(c==1)
				    	{
				    		try {
				    			rs=database.showFood();
				    			System.out.println(" ID      Item      Price");
				    			while(rs.next())
				    			{
				    				int id = rs.getInt("fid");
				                    String name = rs.getString("item");
				                    int amt = rs.getInt("price");
				                    System.out.println(" "+id+"      "+name+"      "+amt);
				    			}
				    		} catch (SQLException e) {
				    			e.printStackTrace();
				    		}
				    		
				    	}
				    	else if(c==2)
				    	{
				    		int id,price;
				    		String name;
				    		System.out.println("Enter the following details food id,name,price");
				    		id=s.nextInt();
				    		name=s.next();
				    		price=s.nextInt();
				    		try {
				    			database.addFood(id, name, price);
				    		} catch (SQLException e) {
							e.printStackTrace();
				    		}
				    	}
				    	else if(c==3)
				    	{
				    		int price;
				    		String name;
				    		System.out.println("Enter the following details foodname,price");
				    		name=s.next();
				    		price=s.nextInt();
				    		try {
								database.updateFood(name, price);
								} catch (SQLException e) {
								e.printStackTrace();
								}
				    	}
				    	else if(c==4)
				    	{
				    		break;
				    	}
				    	else
				    	{
				    		System.out.println("Wrong input ");
				    		continue;
				    	}
				 	}
				    		
				}
				else
				{
					System.out.print("Wrong password\n");
					continue;
				}
			}
			else if(ch==2)
			{
				try {
	    			rs=database.showFood();
	    			System.out.println(" ID      Item      Price");
	    			while(rs.next())
	    			{
	    				int id = rs.getInt("fid");
	                    String name = rs.getString("item");
	                    int amt = rs.getInt("price");
	                    System.out.println(" "+id+"      "+name+"      "+amt);
	    			}
	    		} catch (SQLException e) {
	    			e.printStackTrace();
	    		}
				System.out.print("Enter the following customer name ,food ,quantity\n");
				String cname,food;
				int quan,fid,price;
				ResultSet r=null;
				cname=s.next();
				food=s.next();
				quan=s.nextInt();
				Date d=new Date();
				Timestamp t=new Timestamp(d.getTime());
				r=database.showfoodid(food);
				r.next();
				fid=r.getInt("fid");
				price=r.getInt("price");
				price=price*quan;
				database.addCustomer(t, cname, price);
				database.addCFood(t, fid, quan);
				System.out.println("Bill :"+price);
				
			}
			else
			{
				System.out.println("Thank you");
				database.closeConnection();
				System.exit(0);
			}
		}

	}

}
