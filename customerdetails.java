package javaproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerdetails extends JFrame {

  private JPanel contentPane;

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
    setBounds(100, 100, 900, 504);
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
    mntmNewMenuItem.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		Booking bk=new Booking();
    		bk.setVisible(true);
    		dispose();   		
    	}
    });
    mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mnNewMenu.add(mntmNewMenuItem);
    
    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Track Status");
    mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    mnNewMenu.add(mntmNewMenuItem_1);
    
    JButton btnNewButton = new JButton("CANCEL");
    btnNewButton.setBackground(UIManager.getColor("Button.light"));
    btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 18));


btnNewButton.setBounds(1019, 664, 118, 34);
    contentPane.add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("YOUR DETAILS");
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		try {
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/houseboat","postgres","andumadom");
				String query = "SELECT * FROM login where authority = 'customer'";
				  
				  java.sql.Statement stm = connection.createStatement();
				  ResultSet res = stm.executeQuery(query);
				
				  String columns[] = { "username", "first_name", "last_name","phone_no_1","email" };
				  String data[][] = new String[8][5];
				
				  int i = 0;
				  while (res.next()) {
				    String id = res.getString("username");
				    String f_name = res.getString("first_name");
				    String l_name = res.getString("last_name");
				    String phone_no_1 = res.getString("phone_no_1");
				    String email = res.getString("email");
				    data[i][0] = id + "";
				    data[i][1] = f_name;
				    data[i][2] = l_name;
				    data[i][3] = phone_no_1;
				    data[i][4] = email;
				    
				    i++;
				  }
				
				  DefaultTableModel model = new DefaultTableModel(data, columns);
				  JTable table = new JTable(model);
				  table.setShowGrid(true);
				  table.setShowVerticalLines(true);
				  JScrollPane pane = new JScrollPane(table);
				  JFrame f = new JFrame("Populate JTable from Database");
				  JPanel panel = new JPanel();
				  panel.add(pane);
				  f.getContentPane().add(panel);
				  f.setSize(500, 250);
				  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				  f.setVisible(true);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	    
    	}
    });
    	
    btnNewButton_1.setFont(new Font("Stencil", Font.BOLD, 39));
    btnNewButton_1.setBounds(245, 189, 328, 92);
    contentPane.add(btnNewButton_1);
  }
}