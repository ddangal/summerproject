/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.DatabaseHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import models.Student;

class find_s1 extends JFrame {

    JLabel l1, l2, l3, l4, l5, l6, l7;

    JTextField tf1, tf2, tf3, tf4, tf5, tf6;

    JButton btn1, btn2;
    String photo;
    find_s1() {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setTitle("Data Entry Form ");

        l1 = new JLabel("Find Data:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setFont(new Font("Serif", Font.ITALIC, 20));

        l2 = new JLabel("Enter Name:");
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        l3 = new JLabel("Enter TU Roll:");
        l3.setFont(new Font("Serif", Font.BOLD, 20));
        tf1 = new JTextField();
        tf1.setFont(new Font("Serif", Font.BOLD, 20));
        tf2 = new JTextField();
        tf2.setFont(new Font("Serif", Font.BOLD, 20));
        btn1 = new JButton("Submit");
        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        btn2 = new JButton("Clear");
        btn2.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);
        tf1.setBounds(300, 70, 200, 30);

        tf2.setBounds(300, 110, 200, 30);
        btn1.setBounds(80, 150, 100, 30);

        btn2.setBounds(210, 150, 100, 30);

        add(l1);
        add(l2);
        add(tf1);
//       add(l5); 
//       add(tf2); 
        add(btn1);
        add(btn2);

        JLabel r_name, r_address, r_batch, r_roll, r_contact, r_photo;
        r_name = new JLabel("");
        r_name.setFont(new Font("Serif", Font.BOLD, 20));
        r_address = new JLabel("");
        r_address.setFont(new Font("Serif", Font.BOLD, 20));
        r_batch = new JLabel("");
        r_batch.setFont(new Font("Serif", Font.BOLD, 20));
        r_roll = new JLabel("");
        r_roll.setFont(new Font("Serif", Font.BOLD, 20));
        r_contact = new JLabel("");
        r_contact.setFont(new Font("Serif", Font.BOLD, 20));
        r_photo = new JLabel("");
        add(r_name);
        add(r_address);
        add(r_batch);
        add(r_roll);
        add(r_contact);
        add(r_photo);
        r_name.setBounds(80, 200, 300, 30);
        r_name.setForeground(new Color(20, 20, 250));
        r_address.setForeground(new Color(20, 20, 250));
        r_batch.setForeground(new Color(20, 20, 250));
        r_roll.setForeground(new Color(20, 20, 250));
        r_contact.setForeground(new Color(20, 20, 250));
        r_photo.setBounds(400, 400, 400, 400);
        r_address.setBounds(80, 250, 300, 30);
        r_batch.setBounds(80, 300, 300, 30);
        r_roll.setBounds(80, 350, 300, 30);
        r_contact.setBounds(80, 400, 300, 30);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == btn1) {

                    try {

                        DatabaseHandler dh = new DatabaseHandler();
                        String name = tf1.getText();

                        List<Student> list = dh.find(name);
                        for (int i = 0; i < list.size(); i++) {
                            // TODO USE TABLE VIEW TO DISPLAY MULTIPLE DATA AND DISPLAY IMAGE
                            //FIRST MOVE SELECTED IMAGE TO RESOURCES FOLDER WHILE INSERTING DATA INTO DATABASEE
                            Student s = list.get(i);
                            r_name.setText("Name: " + s.getName());
                            r_address.setText("Address:  " + s.getAddress());
                            r_batch.setText("Batch:  " + s.getBatch());
                            r_roll.setText("Roll:  " + s.getRoll());;
                            r_contact.setText("Contact:  " + s.getContact());
                             photo = s.getPhoto();
//                             tf1.setText(photo);
//                              ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource(photo)); 
//                            JLabel llll = new JLabel(ico);
//                            llll.setBounds(400, 400, 400, 400);

                        }

                    } catch (Exception ee) {

                    }

                }

            }

        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                if (ae.getSource() == btn2) {

                    tf1.setText("");

                    tf2.setText("");

//          DatabaseHandler dh = new DatabaseHandler();
//          List<Student> list = dh.find_s1(s);
//          for (int i = 0; i < list.size(); i++) {
//                   Student s = list.get(i);
//          }
                }

            }
        });
    }
}
