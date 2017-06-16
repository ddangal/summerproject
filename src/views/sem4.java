package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class sem4 extends JPanel
{
    	public sem4()
	{	
		JButton b1 = new JButton("ADD");
		JButton b2 = new JButton("FIND");
		JButton b3 = new JButton("REMOVE");
                JButton b4 = new JButton("Transfer");
                JCheckBox c = new JCheckBox("abc");
                JLabel l = new JLabel("if the checkbox is selected and transfer button is clicked, then "
                        + "all data of first semester is transferred to second semester");
                
		add(b1);
		add(b2);
		add(b3);
                add(l);
                add(c);
                add(b4);
		b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
                                    
					JLabel l1,l2,l3,l4;
					JTextField t1,t2,t3;
					JButton b;
					l1 = new JLabel("Name:");
					l2 = new JLabel("Address:");
					l3 = new JLabel("Age:");
					l4 = new JLabel("");
					t1 = new JTextField(30);
					t2 = new JTextField(30);
					t3 = new JTextField(30);
					b = new JButton("Add");
                            
                                        add(l1);
                                           add(t1);
                                        
					add(l2);add(t2);
					add(l3);add(t3);
					add(b);
					add(l4);
                                        b.addActionListener(new ActionListener()
                                        {
                                            public void actionPerformed(ActionEvent ae)
                                            {
                                                try {
                                                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
                                                    Statement stmt=con.createStatement();
                                                    String name = t1.getText();
                                                    String address = t2.getText();
                                                    int age = Integer.parseInt(t3.getText());
                                                   String sql = "insert into sem1 values('"+name+"','"+address+"','"+age+"')";
                                                    stmt.executeUpdate(sql);
                                                    
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(sem1.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                            
                                        }
                                        );
				}
			});
                      b2.addActionListener(new ActionListener()
                      {
                          public void actionPerformed(ActionEvent ae)
                          {
                             JTextField  t = new JTextField(30);
                             JLabel l = new JLabel("Enter Name of Student:");
                             JButton b = new JButton("FIND");
                             add(l); add(t); add(b);
                             b.addActionListener(new ActionListener()
                             {
                                 public void actionPerformed(ActionEvent ae)
                                 {
                                     try {
                                         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
                                         Statement st = conn.createStatement();
                                         String nameofs = t.getText();
                                         String sql = "select * from sem1 where name = '"+nameofs+"'";
                                         ResultSet  r =  st.executeQuery(sql);
                                         while(r.next())
                                         {
                                              String name=r.getString("name");
                                              JLabel l = new JLabel();
                                              add(l);
                                              l.setText("Hello "+name);
                                              
                                         }
                                      
                                         
                                     } catch (SQLException ex) {
                                         Logger.getLogger(sem1.class.getName()).log(Level.SEVERE, null, ex);
                                     }
                                 }
                             }
                             );
                          }
                      }
                      );
                  b3.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent ae)
                      {
                             JTextField  t = new JTextField(30);
                             JLabel l = new JLabel("Enter Name of Student:");
                             JButton b = new JButton("DELETE");
                             add(l); add(t); add(b);
                             b.addActionListener(new ActionListener()
                             {
                                 public void actionPerformed(ActionEvent ae)
                                 {
                                     try {
                                         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
                                         Statement st = conn.createStatement();
                                         String s = t.getText();
                                         String sql = "delete  from sem1 where name='"+s+"'";
                                         st.executeUpdate(sql);
                                     } catch (SQLException ex) {
                                         Logger.getLogger(sem1.class.getName()).log(Level.SEVERE, null, ex);
                                     }
                                 }
                             }
                             );
                      }
                  }
                  );
              /*  b4.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                        if(c.isSelected())
                        {
                            try {
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","");
                                Statement st = conn.createStatement();
                                String sql = "insert into sem2('"+name+"','"+address+"','"+age+"') select (name,address,age) from sem1";
                                st.executeUpdate(sql);
                            //    String sql1 ="delete from sem1";
                              //  st.executeUpdate(sql1);
                            } catch (SQLException ex) {
                                Logger.getLogger(sem1.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                }
                );
                */
		
	}

}