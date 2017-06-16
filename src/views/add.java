package views;





import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*; 

public class add extends JFrame implements ActionListener
  { 

    JLabel l1, l2, l3,l4,l5,l6,l7;

    JTextField tf1, tf2, tf3,tf4,tf5;
     
    JButton btn1, btn2,btn;
    String s;

 
    add()
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

 

        l2 = new JLabel("Name:" );
       
        l3 = new JLabel( "Address:" ); 
        
        l4 = new JLabel("Batch:");

        l5 = new JLabel("TU Roll:");


        l6 = new JLabel("Contact:");  
        
        l7 = new JLabel("Photo:");  

       
        
        tf1 = new JTextField();

        tf2 = new JTextField();

               tf3 = new JTextField();
               tf4 = new JTextField();
               tf5 = new JTextField();


        btn = new JButton("Click to add");
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
        btn.setBounds(300, 270, 200, 30);

        btn1.setBounds(50, 350, 100, 30);

        btn2.setBounds(170, 350, 100, 30);

       add(l1);  add(l2); add(tf1); add(l3); add(tf2); add(l4); 

        add(tf3);  add(l5); 

        add(tf4); 
        
        add(l6); add(tf5);
        
        add(l7); add(btn);

        add(btn1);

        add(btn2);
       
    btn.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent ae)
        {
          Frame fr = new Frame();
         FileDialog fd = new FileDialog(fr,"File Dialog");         
            fd.setVisible(true);        
             s = fd.getFile();
        }
    }
    );
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
    			String address=tf2.getText();
    			String batch=tf3.getText();
                 String roll=tf4.getText();
                 String contact= tf5.getText();
                 
                 if(name!=null)
                 {
                	 String sql="insert into s1(name,address,batch,roll,contact,photo) values('"+name+"','"+address+"','"+batch+"','"+roll+"','"+contact+"','"+s+"')";
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

    

    public static void main(String args[])
   {

        new add();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
