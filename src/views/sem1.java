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
		JButton b3 = new JButton("REVIEW");
                JButton b5 = new JButton("LISTING");
                JButton b4 = new JButton("Transfer");
                JCheckBox c = new JCheckBox("send");
                JLabel l1 = new JLabel("End of Semester");
                JLabel l = new JLabel("(To transfer data to next sem, click transfer)");
                l1.setFont(new Font("Serif",Font.BOLD,30));
                l.setFont(new Font("Serif",Font.BOLD,20));
                setLayout(null);
                b1.setBounds(100,40,100,40);
                b2.setBounds(250,40,100,40);
                b5.setBounds(400,40,100,40);
                l1.setBounds(100,120,300,40);
                b3.setBounds(100,180,100,40);
                c.setBounds(220,180,60,30);
                b4.setBounds(270,180,100,30);
                l.setBounds(60,220,460,40);
                //b4.setBounds()
		add(b1);
		add(b2);
		add(b5);
                add(b5);
                add(l1);
                add(b3);
                add(c);
                add(b4);
                add(l);
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
