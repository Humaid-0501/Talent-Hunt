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
import java.util.jar.Attributes;
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
public class ViewEvents extends JFrame{
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
    
    ViewEvents(){
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
        this.newEvent.setText("Back");
        this.panel2.add(newEvent);
        ActionListener al2 = new ButtonListener();
        ViewEvents.newEvent.addActionListener(al2);
        
        this.panel2.setBackground(new java.awt.Color(248,148,6));
        this.panel2.setSize(600,80);
        
        this.mainPanel.add(this.panel2);
        
        this.panel3 = new JPanel();
        this.panel3.setBackground(new java.awt.Color(44,62,80));
        this.panel3.setLocation(0, 80);
        this.panel3.setSize(600,620);
        this.panel4 = new JPanel(new GridLayout(10,1));
        this.panel4.setBackground(new java.awt.Color(44,62,80));
        this.panel4.setLocation(0,0);
        this.panel4.setPreferredSize(new Dimension(560,560));
        try{
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","test1234");
            Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("Select * from events;");
            while(rs.next()){
                JButton p = new panel1(rs.getString(1));
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
//     public static void main(String[] args) {
//        new ViewEvents();
//    }
    class ButtonListener implements ActionListener{
         public void actionPerformed(ActionEvent e){
            AdminForm.event.dispose();
            AdminForm adForm =  new AdminForm();
            adForm.setVisible(true);
        }
}
}
class panel1 extends JButton{
    panel1(String s1){
        this.setText(s1);
        ActionListener al = new ButtonListener(s1);
        this.addActionListener(al);
        }
        class ButtonListener implements ActionListener{
        private String name;
        public ButtonListener(String name) {
            
            this.name = name;
        }
        
         public void actionPerformed(ActionEvent e){
                AdminForm.display = new Display(this.name);
                AdminForm.display.setVisible(true);
                AdminForm.event.dispose();   
         }
    }
}
