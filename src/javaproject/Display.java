/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import com.sun.glass.events.ViewEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tanuj
 */
public class Display extends JFrame{
    public String title;
    public JPanel mainPanel;
    public JPanel panel2;
    public JPanel panel3;
    public JPanel panel4;
    public JLabel name;
    static public JButton newEvent;
    public JLabel name1;
    public JLabel name2;
    public JLabel name3;
    public JLabel name4;
    public JLabel name7;
    public JLabel name8;
    public JLabel name9;
    
    Display(String title){
        this.title = title;
        this.setResizable(false);
        this.setSize(600, 700);
       
        this.mainPanel= new JPanel(null);
        this.mainPanel.setSize(600,700);
        this.panel2 = new JPanel();
        this.panel2.setLayout(new GridLayout(3,3,5,5));
       
        this.name1 = new JLabel();
        this.panel2.add(name1);
        this.name2 = new JLabel();
        this.panel2.add(name2);
        this.name3 = new JLabel();
        this.panel2.add(name3);
        this.name4 = new JLabel();
        this.panel2.add(name4);
        this.name = new JLabel();
        this.name.setForeground(Color.white);
        this.name.setFont(new java.awt.Font("Tahoma", 1, 24));
        this.name.setText(this.title);
        this.panel2.add(this.name);
        
        this.name9 = new JLabel();
        this.panel2.add(this.name9);
        
        this.name7 = new JLabel();
        this.panel2.add(name7);
        this.name8 = new JLabel();
        
        this.panel2.add(name8);
        
        this.newEvent = new JButton();
        this.newEvent.setText("Back");
        this.panel2.add(newEvent);
        ActionListener al2 = new ButtonListener();
        Display.newEvent.addActionListener(al2);
        
        this.panel2.setBackground(new java.awt.Color(248,148,6));
        this.panel2.setSize(600,80);
        
        this.mainPanel.add(this.panel2);
        
        this.panel3 = new JPanel();
        this.panel3.setBackground(new java.awt.Color(44,62,80));
        this.panel3.setLocation(0, 80);
        this.panel3.setSize(600,620);
        this.panel4 = new JPanel(new GridLayout(10,6));
        this.panel4.setBackground(new java.awt.Color(44,62,80));
        this.panel4.setLocation(0,0);
        this.panel4.setPreferredSize(new Dimension(560,560));
        JPanel p0 = new pan2("Name","Number","Sem","Div","Branch","USN");
        this.panel4.add(p0);
        try{
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","test1234");
            Statement stmt = conn.createStatement();
            String query = "Select* from "+this.title;
             ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                JPanel p = new pan2(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
                panel4.add(p);
                
            }   
            this.panel3.add(this.panel4);
                    this.mainPanel.add(this.panel3);
                    conn.close();
        }
        catch(Exception e){
            System.out.println("MEssage:" + e.getMessage());
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.mainPanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    class ButtonListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
            AdminForm.display.dispose();
            AdminForm.event =  new ViewEvents();
            AdminForm.event.setVisible(true);
        }
    }
}
class pan2 extends JPanel{
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JLabel l5;
    JLabel l6;
    
    pan2(String s1,String s2,String s3,String s4,String s5,String s6){
        this.setLayout(new GridLayout(1,6));
        l1 = new JLabel();
        l2 = new JLabel();
        l3 = new JLabel();
        l4 = new JLabel();
        l5 = new JLabel();
        l6 = new JLabel();
        l1.setText(s1);
        l2.setText(s2);
        l3.setText(s3);
        l4.setText(s4);
        l5.setText(s5);
        l6.setText(s6);
        this.add(l1);
        this.add(l2);
        this.add(l3);
        this.add(l4);
        this.add(l5);
        this.add(l6);
        
        ///////////////////////////////////////////////////////////////////////////////////
    }
}