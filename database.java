package Foodorder;

import java.sql.*;  
import java.util.Date;


public class database {
	static Connection conn = null;
	static Statement stmt=null;
	public static void connectToDatabase() {
        // JDBC driver and database URL
        String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/kbase";

        // Database credentials
        String USERNAME = "root";
        String PASSWORD = "";

        

        try {
            
            Class.forName(JDBC_DRIVER);

            
                try {
                    
                    conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    stmt=conn.createStatement();
                   
                    System.out.println("Connected to the database successfully!");

                   
                    

                } catch (SQLException se) {
                    System.out.print(se);
                } 
               
            
        } catch (ClassNotFoundException e) {
           System.out.print(e);
        }
}

	 public static ResultSet showFood() throws SQLException {
		 ResultSet rs=null;
	        String sql = "select * from food_record ;";
	        rs=stmt.executeQuery(sql);
	        return rs;
	    }
	 public static void addFood(int id,String item ,int price) throws SQLException {
		 
	        String sql = "insert into food_record (fid,item,price) values ("+id+",'"+item+"',"+price+") ;";
	        stmt.executeUpdate(sql);
	    }
	 public static void updateFood(String item ,int price) throws SQLException {
		
	        String sql = "update food_record set price="+price+" where item ='"+item+"';";
	        stmt.executeUpdate(sql);
	        
	    }
	 public static void addCustomer(Timestamp id,String item ,int price) throws SQLException {
		 String time = id.toString();
	        String sql = "insert into customer_record (ordid,cust_name,amount) values ('"+time+"','"+item+"',"+price+"); ";
	       stmt.executeUpdate(sql);
	       
	    }
	 public static void addCFood(Timestamp id,int fid ,int quantity) throws SQLException {
		 String time = id.toString();
	        String sql = "insert into customer_food (ordid,fid,quantity) values ('"+time+"',"+fid+","+quantity+"); ";
	      stmt.executeUpdate(sql);
	       
	    }
	 public static ResultSet showfoodid(String item ) throws SQLException {
		 ResultSet rs=null;
	        String sql = "select * from  food_record where item= '"+ item +"';";
	        rs=stmt.executeQuery(sql);
	        return rs;
	    }
	 public static void closeConnection() {
	        try {
	            if (stmt != null)
	                stmt.close();
	            if (conn != null)
	                conn.close();
	            System.out.println("Connection closed successfully!");
	        } catch (SQLException se) {
	            System.out.println(se);
	        }
	 }
}
