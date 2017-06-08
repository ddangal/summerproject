import java.awt.Image.*;
import java.awt.*;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
class swing_event extends JFrame
{
	JLabel l;
	swing_event() throws FileNotFoundException
	{   
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try
                {
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                    Statement s = c.createStatement();
                    String sql = "select * from del1";
                    ResultSet rs = s.executeQuery(sql);
                    while(rs.next())
                    {
                        String image = rs.getString(1);
                     
                        ImageIcon ico = new ImageIcon(getClass().getClassLoader().getResource("c:/summerproject/img/"+image));
                      
                         l = new JLabel(ico);
                         l.setBounds(100,100,400,200);
                         }
                        
                }catch(Exception e)
                        {
                        
                        }
		/*b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				l.setText("First Button is pressed");
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				l.setText("second Button is pressed");
			}
		});
		f.add(b1);
		f.add(b2);
                f.add(jfc);
		l = new JLabel("Press the Button");
		f.add(l);
                */
                add(l);
                   
		setVisible(true);
	}
	public static void main(String[]args) throws FileNotFoundException
	{
		new swing_event();
	}
}
