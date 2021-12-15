
package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.UIManager;

public class customerdetails extends JFrame {

  private JPanel contentPane;
  private JTextField textField;
  private JTextField textField_1;
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
          customerdetails frame = new customerdetails();
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
  public customerdetails() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1350, 763);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);
    
    JMenuBar menuBar = new JMenuBar();
    menuBar.setBounds(10, 10, 98, 34);
    contentPane.add(menuBar);
    
    JMenu mnNewMenu = new JMenu("Manage");
    mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 17));
    menuBar.add(mnNewMenu);
    
    JMenuItem mntmNewMenuItem = new JMenuItem("Booking");
    mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mnNewMenu.add(mntmNewMenuItem);
    
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Track Status");
    mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mnNewMenu.add(mntmNewMenuItem_1);
    
    JLabel lblNewLabel = new JLabel("YOUR DETAILS");
    lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 39));
    lblNewLabel.setBounds(469, 150, 397, 61);
    contentPane.add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Name");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
    lblNewLabel_1.setBounds(213, 254, 203, 44);
    contentPane.add(lblNewLabel_1);
    
    JLabel lblNewLabel_1_1 = new JLabel("Phone Number\r\n");
    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
    lblNewLabel_1_1.setBounds(213, 308, 203, 44);
    contentPane.add(lblNewLabel_1_1);
    
    textField = new JTextField();
    textField.setBounds(436, 254, 261, 44);
    contentPane.add(textField);
    textField.setColumns(10);
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    textField_1.setBounds(436, 308, 261, 44);
    contentPane.add(textField_1);
    
    table = new JTable();
    table.setModel(new DefaultTableModel(
      new Object[][] {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
      },
      new String[] {
        "New column", "New column", "New column", "New column", "New column", "New column"
      }
    ));
    table.setBounds(42, 427, 1169, 200);
    contentPane.add(table);
    
    JButton btnNewButton = new JButton("CANCEL");
    btnNewButton.setBackground(UIManager.getColor("Button.light"));
    btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));


btnNewButton.setBounds(1019, 664, 118, 34);
    contentPane.add(btnNewButton);
  }
}