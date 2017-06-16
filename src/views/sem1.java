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

class sem1 extends JPanel
{
    	public sem1()
	{	
		JButton b1 = new JButton("ADD");
		JButton b2 = new JButton("FIND");
		JButton b3 = new JButton("REMOVE");
                JButton b5 = new JButton("LISTING");
                JButton b4 = new JButton("Transfer");
                JCheckBox c = new JCheckBox("send");
                JLabel l = new JLabel("(To transfer data to next sem, click transfer)");
                l.setFont(new Font("Serif",Font.BOLD,20));
                setLayout(null);
                b1.setBounds(100,40,100,40);
                b2.setBounds(300,40,100,40);
                b3.setBounds(100,110,100,40);
                b5.setBounds(300,110,100,40);
                c.setBounds(180,180,60,30);
                b4.setBounds(250,180,100,30);
                l.setBounds(60,220,460,40);
                //b4.setBounds()
		add(b1);
		add(b2);
		add(b3);
                add(b5);
                add(l);
                add(c);
                add(b4);
		b1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent ae)
				{
                                    new add();
                                }
                        });
                        
                      b2.addActionListener(new ActionListener()
                      {
                          public void actionPerformed(ActionEvent ae)
                          {
                              new find_s1();
                          }
                      }
                      );
                  b3.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent ae)
                      {
                       new remove_s1();
                      }
                  }
                  );
                  b5.addActionListener(new ActionListener()
                  {
                      public void actionPerformed(ActionEvent ae)
                      {
                       new transfer_s1();
                      }
                  }
                  );
                /*b4.addActionListener(new ActionListener()
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



/////////////////////////////////////
///////////////////////////////////////
///////////////////////////////////
////////////////////////////////////
//////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////




class find_s1 extends JFrame implements ActionListener
  { 
    JLabel r_name,r_address,r_batch,r_roll, r_contact, r_photo;

    JLabel l1, l2, l3,l4,l5,l6,l7;

    JTextField tf1, tf2, tf3,tf4,tf5,tf6;

    JButton btn1, btn2;



    find_s1()
     {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setTitle("Data Entry Form ");

 
                      
        l1 = new JLabel("Find Data:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setFont(new Font("Serif",Font.ITALIC, 20));

 
        
        
        r_name = new JLabel("" );
        r_name.setFont(new Font("Serif", Font.BOLD, 20));
        r_address = new JLabel("" );
        r_address.setFont(new Font("Serif", Font.BOLD, 20));
        r_batch = new JLabel("" );
        r_batch.setFont(new Font("Serif", Font.BOLD, 20));
        r_roll = new JLabel("" );
        r_roll.setFont(new Font("Serif", Font.BOLD, 20));
        r_contact = new JLabel("" );
        r_contact.setFont(new Font("Serif", Font.BOLD, 20));
        r_photo = new JLabel("");

        
        
        
        l2 = new JLabel("Enter Name:" );
       l2.setFont(new Font("Serif", Font.BOLD, 20));
        l3 = new JLabel( "Enter TU Roll:" ); 
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

       add(l1);  add(l2); add(tf1); add(l5); add(tf2); 
        add(btn1);

        add(btn2);
        add(r_name);add(r_address);add(r_batch);add(r_roll);add(r_contact);add(r_photo);
        r_name.setBounds(80,200,300,30);
        r_name.setForeground(new Color(20  ,20,250));
        r_address.setForeground(new Color(20  ,20,250));
        r_batch.setForeground(new Color(20  ,20,250));
        r_roll.setForeground(new Color(20  ,20,250));
        r_contact.setForeground(new Color(20  ,20,250));
        r_photo.setBounds(400,400,400,400);
        r_address.setBounds(80,250,300,30);
        r_batch.setBounds(80,300,300,30);
        r_roll.setBounds(80,350,300,30);
        r_contact.setBounds(80,400,300,30);
  btn1.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
     {
             
        if (e.getSource() == btn1)
         {

        	try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");    
    			Statement stmt=con.createStatement();  
    			String name= tf1.getText(); 
    			String roll=tf2.getText();
    			String sql = "select * from s1 where name='"+name+"' && roll ='"+roll+"'";
                 	// String sql="insert into "+batch+" values('"+fname+"','"+lname+"','"+address+"','"+phone1+"','"+phone2+"')";
         		ResultSet rs = 	stmt.executeQuery(sql);
                        while(rs.next())
                        {
                            String n = rs.getString(1);
                            String ad = rs.getString(2);
                            String batc = rs.getString(3);
                            String rol = rs.getString(4);
                            String co = rs.getString(5);
                            String photo = rs.getString(6);
                            r_name.setText("Name: "+n);
                            r_address.setText("Address:  "+ad);
                            r_batch.setText("Batch:  "+batc);
                            r_roll.setText("Roll:  "+rol);
                            r_contact.setText("Contact:  "+co);
                            System.out.println("Photo : " + photo);
//                        ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("img/"+photo));
//                            r_photo.setText("Photo:"+ico);
  ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("img/"+photo));
                            System.out.println();
                    JLabel     l = new JLabel(ico);
                        l.setBounds(100,100,400,200);                           
                        }
                        
                        
         		con.close();  	 
                 
    			}
        	
        	catch(Exception ee)
        	{ 
        		
        	} 
        	
        	
    	} 

        
       
    		}
    
    });
    
  btn2.addActionListener(new ActionListener()
		  {
  public void actionPerformed(ActionEvent ae)
  {

     if (ae.getSource() == btn2)
      {

          tf1.setText("");
  
          tf2.setText("");


     }

 } 
		  });
        }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}





//////////////////////////////////////////////
///////////////////////////////////////////
/////////////////////////////////////////////
//////////////////////////////////////////////
////////////////////////////////////////////
////////////////////////////////////////////
///////////////////////////////////////////


class remove_s1 extends JFrame implements ActionListener
  { 

    JLabel l1, l2, l3,l4,l5,l6,l7;

    JTextField tf1, tf2, tf3,tf4,tf5,tf6;

    JButton btn1, btn2;



    remove_s1()
     {

        setVisible(true);

        setSize(650, 500);

        setLayout(null);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setTitle("Data Entry Form ");

 

        l1 = new JLabel("Data Entry Form:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l1.setFont(new Font("Serif",Font.ITALIC, 20));

 

        l2 = new JLabel("Batch:" );
       
        l3 = new JLabel( "fName:" ); 
        
        l4 = new JLabel("lName:");

        l5 = new JLabel("Address:");


        l6 = new JLabel("Phone No1:");  
        
        l7 = new JLabel("Phone No2:");  

       
        
        tf1 = new JTextField();

        tf2 = new JTextField();

               tf3 = new JTextField();
               tf4 = new JTextField();
               tf5 = new JTextField();

               tf6 = new JTextField();

        btn1 = new JButton("Submit");

        btn2 = new JButton("Clear");

        l1.setBounds(100, 30, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        l4.setBounds(80, 150, 200, 30);
        
        l5.setBounds(80, 190, 200, 30);
        
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        tf2.setBounds(300, 110, 200, 30);
       
        tf3.setBounds(300, 150, 200, 30);
        
        tf4.setBounds(300, 190, 200, 30);
        
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);

        btn1.setBounds(50, 350, 100, 30);

        btn2.setBounds(170, 350, 100, 30);

       add(l1);  add(l2); add(tf1); add(l3); add(tf2); add(l4); 

        add(tf3);  add(l5); 

        add(tf4); 
        
        add(l6); add(tf5);
        
        add(l7); add(tf6);

        add(btn1);

        add(btn2);

    
  btn1.addActionListener(new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
     {
             
        if (e.getSource() == btn1)
         {

        	try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/bim","root","");    
    			Statement stmt=con.createStatement();  
    			String batch= tf1.getText(); 
    			String fname=tf2.getText();
    			String lname=tf3.getText();
                 String address=tf4.getText();
                 String phone1= tf5.getText();
                 String phone2= tf6.getText();
                 
                 if(fname!=null&&address!=null)
                 {
                	 String sql="insert into "+batch+" values('"+fname+"','"+lname+"','"+address+"','"+phone1+"','"+phone2+"')";
         			stmt.executeUpdate(sql);
         			JOptionPane.showMessageDialog(null,"Inserted Successfully!");
         			con.close();  	 
                 }
                 else
                 {
                	 JOptionPane.showMessageDialog(null,"textfield empty!");
                 }
    			}
        	
        	catch(Exception ee)
        	{ 
        		
        	} 
        	
        	
    	} 

        
       
    		}
    
    });
    
  btn2.addActionListener(new ActionListener()
		  {
  public void actionPerformed(ActionEvent ae)
  {

     if (ae.getSource() == btn2)
      {

          tf1.setText("");
  
          tf2.setText("");

          tf3.setText("");

     }

 } 
		  });
        }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


class transfer_s1 extends JFrame implements ActionListener
{

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
