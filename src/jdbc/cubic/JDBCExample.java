package jdbc.cubic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCExample {
	
	public static Scanner getScanner() {
		Scanner s = new Scanner(System.in);
		return s;
	}
	
	public static Statement getStatement() throws ClassNotFoundException, SQLException {
		// step 1: Register the driver - to make jvm to understand what db software we are using
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		
		//step 2: establish connection with the oracle database 
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Amzn2012");
		System.out.println("dfafafa");
		
		// step 3: Create statement object to run/write queries
		Statement st = con.createStatement();
		
		return st;
	}
	
	public static void register() throws ClassNotFoundException, SQLException {
		int id;
		String name, address;
		System.out.println("Enter the student details:");
		Scanner s = getScanner();
		System.out.println("ID:");
		id = s.nextInt();
		System.out.println("Name:");
		name = s.next();
		System.out.println("Address:");
		address = s.next();
		Statement st = getStatement();
		// check if the student id is already available within database.
		// if available don't insert the recode and give mess to user saying id already exists
		// else insert the record
		
		st.executeUpdate("INSERT INTO student VALUES ("+id+",'"+name+"','"+address+"')");
		System.out.println("Student Registered successfully!");
	}
	
	public static void delete() throws ClassNotFoundException, SQLException {
		System.out.println("Enter student ID to delete");
		Scanner s = getScanner();
		int id = s.nextInt();
		Statement st = getStatement();
		// check if the student with the given id is available in database
		//if available delete the student
		//else give the mess saying that stu with the given id doesn't exist
		st.executeUpdate("DELETE FROM student WHERE id = "+id);
		System.out.println("Student with the ID: "+id+" has been deleted!");
	}
	
	
	public static void update() throws ClassNotFoundException, SQLException {
		
		System.out.println("Enter student ID to update");
		Scanner s = getScanner();
		int id = s.nextInt();
		Statement st = getStatement();
		
		// check if the given student is is available
		// if available continue to update process
		// else show the mess saying given student ID doesn't exist
		
		System.out.println("what data you want to update:");
		System.out.println("1) Name");
		System.out.println("2) Address");
		int option = s.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("Enter the new name:");
			String new_name = s.next();
			
			// if the new name entered is same as old name give mess saying that no changes in the data
			// else update with new data
			
			st.executeUpdate("UPDATE student SET name = '"+new_name+"' WHERE id = "+id);
			System.out.println("Name is updated!");
			break;
		case 2:
			System.out.println("Enter the new address:");
			String new_address = s.next();
			
			// if the new address entered is same as old address give mess saying that no changes in the data
			// else update with new data
			
			st.executeUpdate("UPDATE student SET address = '"+new_address+"' WHERE id = "+id);
			System.out.println("Address is updated!");
			break;
			default:
				
		}
	}
	
	
	public static void search() throws ClassNotFoundException, SQLException {
		System.out.println("Enter the student name you want to search:");
		Scanner s = getScanner();
		String str = s.nextLine();
		Statement st = getStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM student WHERE name LIKE '"+str+"'");
		
		// get all the students data on given substring
		
		while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		
	}
	
	public static void list() {
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		System.out.println("Registration Page:");
		
		System.out.println("1) Register Student");
		System.out.println("2) Delete Student");
		System.out.println("3) Update Student Record");
		System.out.println("4) Search Student");
		System.out.println("5) List Students");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your option");
		int option_selected = s.nextInt();
		
		switch(option_selected) {
			
		case 1 :
			register();
			break;
		case 2:
			delete();
			break;
		case 3:
			update();
			break;
		case 4:
			search();
			break;
		case 5:
			list();
			break;
		default:
				System.out.println("Invalid option selected. Please try again!");
		}
	}		
	
	

}
