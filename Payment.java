
package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JFrame {

  private JPanel contentPane;
  private JTable table;
  private final ButtonGroup buttonGroup = new ButtonGroup();
  private JPasswordField passwordField;

  
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
          Payment frame = new Payment();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  
  public Payment() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1296, 742);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("PAYMENT");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
    lblNewLabel.setBounds(513, 64, 238, 51);
    contentPane.add(lblNewLabel);
    
    table = new JTable();
    table.setBounds(98, 150, 1037, 156);
    contentPane.add(table);
    
    JLabel lblNewLabel_1 = new JLabel("Total Price");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNewLabel_1.setBounds(230, 359, 213, 51);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_2 = new JLabel("58786");
    lblNewLabel_2.setBackground(Color.RED);
    lblNewLabel_2.setBounds(481, 367, 205, 41);
    contentPane.add(lblNewLabel_2);
    
    JLabel lblNewLabel_3 = new JLabel("Mode of Payment");
    lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNewLabel_3.setBounds(230, 436, 191, 51);
    contentPane.add(lblNewLabel_3);
    
    JPanel panel = new JPanel();
    panel.setBounds(465, 436, 613, 41);
    contentPane.add(panel);
    
    JRadioButton rdbtnNewRadioButton = new JRadioButton("CREDIT CARD");
    rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 15));
    buttonGroup.add(rdbtnNewRadioButton);
    panel.add(rdbtnNewRadioButton);
    
    JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("DEBIT CARD");
    rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
    buttonGroup.add(rdbtnNewRadioButton_1);
    panel.add(rdbtnNewRadioButton_1);
    
    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("UPI");
    rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
    buttonGroup.add(rdbtnNewRadioButton_2);
    panel.add(rdbtnNewRadioButton_2);
    
    JLabel lblNewLabel_4 = new JLabel("Confirm Password");
    lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNewLabel_4.setBounds(230, 540, 185, 41);
    contentPane.add(lblNewLabel_4);
    
    passwordField = new JPasswordField();
    passwordField.setEchoChar('*');
    passwordField.setBounds(465, 540, 349, 25);
    contentPane.add(passwordField);
    
    JCheckBox chckbxNewCheckBox = new JCheckBox("I'M NOT A ROBOT");
    chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 15));
    chckbxNewCheckBox.setBounds(937, 568, 185, 51);


contentPane.add(chckbxNewCheckBox);
    
    JButton btnNewButton = new JButton("PAY");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        customerdetails accpage = new customerdetails();
        accpage.setVisible(true);
      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
    btnNewButton.setBounds(552, 610, 177, 57);
    contentPane.add(btnNewButton);
  }
}