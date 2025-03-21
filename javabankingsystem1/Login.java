package javabankingsystem1;

/**
 *
 * @author Jay
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public  class Login extends JFrame implements ActionListener
{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3;

    Login()
    {
         //move text to center
        setFont(new Font("System", Font.BOLD,15));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("BANKING SYSTEM");
        int y = fm.stringWidth(" ");
        int z = getWidth()/2- (x/1);
        int w = z/y;
        String pad = " ";
        pad = String.format("%"+w+"s",pad);
        setTitle(pad+"BANKING SYSTEM");
        
        
        
        
        
        l1 = new JLabel("WELCOME TO BANK");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l2 = new JLabel("CARD NO:");
        l2.setFont(new Font("Calibri", Font.PLAIN, 38));
        
        l3 = new JLabel("PIN:");
        l3.setFont(new Font("Calibri", Font.PLAIN, 38));
        
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);    
        
        l1.setBounds(175,50,450,200);
        add(l1);
        
        l2.setBounds(100,170,375,200);
        add(l2);
        
        l3.setBounds(100,245,375,200);
        add(l3);
        
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        tf1.setBounds(300,255,230,30);
        add(tf1);
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,330,230,30);
        add(pf2);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,400,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,400,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(300,450,230,30);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,750);
        setLocation(500,200);
        setVisible(true);

    }
     public void actionPerformed(ActionEvent ae)
     {
        try
        {
          conn cl = new conn();
          String a = tf1.getText();
          String b = pf2.getText();
          String q = "select * from login_table where cardno = '"+a+"' and pin = '"+b+"'";
          ResultSet rs = cl.s.executeQuery(q);
          
          if(ae.getSource()==b1)
          {
              if(rs.next())
              {
                  new Transactions().setVisible(true);
                  setVisible(false);
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
              }
          }else if(ae.getSource()==b2)
                      {
                         tf1.setText("");
                         pf2.setText("");
                      }
              else if(ae.getSource()==b3)
              {
                  this.setVisible(false);
                  new Signup().setVisible(true);
                  
              }


         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("error: "+e);
        }
    }  
    public static void main(String[] args)
    {
        new Login().setVisible(true);
    }     
}