package com.valuemomentum.training.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	        
	            // register jdbd driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // creatind connection object
	            
	           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Sayli@123");
	           System.out.println("system is loaded"); 
	           Statement stmt=con.createStatement();
	           con.setAutoCommit(false);
	        try {
	        	int i1=stmt.executeUpdate("insert into candidate_skills values(103,3)");
	        	int i2=stmt.executeUpdate("update skills set name='Ruby' where id=4");
	        	int i3=stmt.executeUpdate("delete from candidates where id=19");
	            con.commit();
	            System.out.println("Transaction is success");
	       
	        }
	        catch(Exception e) {
	        	try {
	        		con.rollback();
	        		System.out.println("Transaction is failed");
	        		
	        	}
	        	catch(Exception ex)
	             {  
	        		System.out.println(ex);
	        		}
	        }
	        stmt.close();
	        con.close();
	        System.out.println("connection is closed");
	}

}
