/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Student;

/**
 *
 * @author rowsun
 */
public class DatabaseHandler {

  Connection con;
    public DatabaseHandler() {
       
      try {  
          Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/bim","root","");    

      } catch (ClassNotFoundException ex) {
          Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException ex) {
          Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
      }
   
        	
        	
    }
    
    
    public boolean insertStudent(Student s){
    	
      try {
          Statement stmt=con.createStatement();
          String batch= s.getBatch();
          String name=s.getName();
          String roll = s.getRoll();
          String address=s.getAddress();
          String photo= s.getPhoto();
          String contact= s.getContact();
          
         if(name!=null)
                 {
                	 String sql="insert into s1(name,address,batch,roll,contact,photo) values('"+name+"','"+address+"','"+batch+"','"+roll+"','"+contact+"','"+s+"')";
         			stmt.executeUpdate(sql);
                                
         			con.close();  
                                return true;
                 }
                
    			
      } catch (SQLException ex) {
          Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
      }
    	          return false;
		
}
    
    
    
}
