/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    String batch, roll, tu_roll, name, address, contact, photo;

    public DatabaseHandler() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summerproject", "root", "");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Student> find(String name) {
        List<Student> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();

            if (name != null) {
                String sql = "select * from sem1 where name='" + name + "'";// where id = '"+name+"'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    name = rs.getString("name");
                    address = rs.getString("address");
                    batch = rs.getString("batch");
                    tu_roll = rs.getString("tu_roll");
                    contact = rs.getString("contact");
                    photo = rs.getString("photo");
                    roll = rs.getString("roll");
                    Student s1 = new Student(roll, name, batch, address, tu_roll, contact, photo);
                    list.add(s1);

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean insertStudent(Student s) {

        try {

            Statement stmt = con.createStatement();
            String batch = s.getBatch();
            String name = s.getName();
            String roll = s.getRoll();
            String tu_roll = s.getTURoll();
            String address = s.getAddress();
            String photo = s.getPhoto();
            String contact = s.getContact();
            if (name != null) {
                String sql = "insert into sem1(roll,name,address,batch,tu_roll,contact,photo) values('" + roll + "','" + name + "','" + address + "','" + batch + "','" + tu_roll + "','" + contact + "','" + photo + "')";
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
