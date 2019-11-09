/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.EventListener;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.xml.bind.annotation.XmlElementDecl;

/**
 *
 * @author Tanuj
 */
public class MainFrame extends JFrame{
    static  MainFrame f;
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
    
    MainFrame(){
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
        this.name.setText("TALENT HUNT");
        this.panel2.add(this.name);
        
        this.name9 = new JLabel();
        this.panel2.add(this.name9);
        
        this.name7 = new JLabel();
        this.panel2.add(name7);
        this.name8 = new JLabel();
        
        this.panel2.add(name8);
        
        this.newEvent = new JButton();
        this.newEvent.setText("Admin");
        this.panel2.add(newEvent);
        ActionListener al2 = new ButtonListener();
        MainFrame.newEvent.addActionListener(al2);
        
        this.panel2.setBackground(new java.awt.Color(248,148,6));
        this.panel2.setSize(600,80);
        
        this.mainPanel.add(this.panel2);
        
        this.panel3 = new JPanel();
        this.panel3.setBackground(new java.awt.Color(44,62,80));
        this.panel3.setLocation(0, 80);
        this.panel3.setSize(600,620);
        this.panel4 = new JPanel();
        this.panel4.setBackground(new java.awt.Color(44,62,80));
        this.panel4.setLocation(0,0);
        this.panel4.setPreferredSize(new Dimension(560,560));
        try{
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","test1234");
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("Select * from events;");
            while(rs.next()){
                JPanel p = new panel(rs.getString(1),rs.getString(2));
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
             JavaProject.frame.dispose();
                     LoginForm login = new LoginForm();
                     login.setVisible(true);
         }
    }
}

class panel extends JPanel {
    panel(String s1,String s2){
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(4,1));
        this.setPreferredSize(new Dimension(560,100));
        JButton b = new JButton();
        JLabel a = new JLabel();
        JLabel d = new JLabel();
        JLabel c = new JLabel();
        a.setFont(new java.awt.Font("Tahoma", 0, 18));
        a.setText("NAME:      "+ s1);
        this.add(a);
        d.setFont(new java.awt.Font("Tahoma", 0, 18));
        d.setText("Desc:      "+ s2);
        this.add(d);
        c.setFont(new java.awt.Font("Tahoma", 0, 18));
        c.setText("      ");
        this.add(c); 
        b.setText("Apply");
        this.add(b);
        ActionListener al = new ButtonListener(s1);
        b.addActionListener(al);

    }
        class ButtonListener implements ActionListener{
        private String name;
        public ButtonListener(String name) {
            
            this.name = name;
        }
        
         public void actionPerformed(ActionEvent e){
                RegistrationForm form = new RegistrationForm(this.name);
                form.setVisible(true);
                JavaProject.frame.dispose();   
         }
    }
}
