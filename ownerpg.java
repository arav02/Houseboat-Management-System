
package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class ownerpg extends JFrame {

  private JPanel contentPane;
  private JTable table;

  /*
   * Launch the application.
   */
  public static void main(String[] args) {
    String jdbcURL = "jdbc:postgresql://localhost:5432/houseboat";
    String username = "postgres";
    String password = "andumadom";
    
    try {
      Connection connection = DriverManager.getConnection(jdbcURL, username, password);
      
      System.out.print("Connected");
          }
      catch(SQLException e) {
        System.out.println("Error in connection");
        e.printStackTrace();
      }
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ownerpg frame = new ownerpg();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /*
   * Create the frame.
   */
  public ownerpg() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 856, 541);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JButton addboat = new JButton("Add Boat");
    addboat.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
    addboat.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    addboat.setBounds(239, 60, 146, 37);
    contentPane.add(addboat);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
    btnDelete.setBounds(468, 60, 146, 37);
    contentPane.add(btnDelete);
    
    JPanel panel = new JPanel();
    panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    panel.setBounds(44, 146, 773, 337);
    contentPane.add(panel);
    panel.setLayout(null);
    
    table = new JTable();
    table.setBounds(6, 15, 761, 316);
    panel.add(table);
    
    JLabel lblNewLabel = new JLabel("Your Boat");
    lblNewLabel.setFont(new Font("Vivaldi", Font.PLAIN, 26));
    lblNewLabel.setBounds(22, 25, 224, 18);
    contentPane.add(lblNewLabel);
  }
}