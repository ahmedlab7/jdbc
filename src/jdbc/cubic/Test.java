package jdbc.cubic;

	import java.sql.*;  
	public class Test{  
	public static void main(String args[]){  
	try{  
	//step1 load the driver class  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	  
	//step2 create  the connection object  
	Connection con=DriverManager.getConnection(	
			"jdbc:oracle:thin:@localhost:1521:xe","system","Amzn2012"); 
	  // making a comment is not a bad idea lol 
	//step3 create the statement object  
	Statement stmt=con.createStatement();  
	 String sql = " CREATE TABLE Competitor2 ( cName varchar(64) primary key)";
	 //String sql ="commit";
	  //String sql_update = "insert into persontexass  (id, firstName) values (12, 'hi')";
	  
	  System.out.println("table created");
	 stmt.execute(sql);
	//  stmt.execute(sql_update);
	//step5 close the connection object  
	con.close();  
	  
	}catch(Exception e){ System.out.println(e);}  
	  
	}  
	}  
	
