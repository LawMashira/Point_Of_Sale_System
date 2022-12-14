import java.awt.BorderLayout;

import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import net.proteanit.sql.DbUtils;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class Brand_Co extends JFrame {
	private JPanel contentPane;
	private JTextField textBrand;
	private JTable table;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brand_Co frame = new Brand_Co();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Brand_Co() {
		this.setExtendedState(Brand_Co.MAXIMIZED_BOTH);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst=con.prepareStatement("select * from brand");
				table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
				
				ResultSet rst = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rst));
				
				}catch (Exception e1) {
					System.out.println(e1);
				}
			
			}
			
		});
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1385, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		
		contentPane.setToolTipText("ADD");
		contentPane.setFont(new Font("Tahoma", Font.BOLD, 18));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 212, 760);
		panel_1.setBackground(Color.BLUE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Product().setVisible(true);
			}
		});
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProduct.setBounds(38, 228, 131, 39);
		panel_1.add(lblProduct);
		
		JLabel lblPos = new JLabel("Pos");
		lblPos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new POS().setVisible(true);
			}
		});
		lblPos.setForeground(Color.WHITE);
		lblPos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPos.setBounds(38, 390, 81, 39);
		panel_1.add(lblPos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(60, 414, 81, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblExit = new JLabel("Log Out");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null,"Do you want to exit the system?","Select",JOptionPane.YES_NO_OPTION);
				int Option=0;
						if(Option==JOptionPane.YES_OPTION) {
						
						System.exit(0);
					}
			}
		});
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExit.setBounds(38, 549, 103, 44);
		panel_1.add(lblExit);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Brand_Co().setVisible(true);
			}
			
		});
		lblBrand.setForeground(Color.WHITE);
		lblBrand.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBrand.setBounds(38, 157, 81, 31);
		panel_1.add(lblBrand);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Category().setVisible(true);
			}
		});
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblCategory.setBounds(38, 81, 131, 39);
		panel_1.add(lblCategory);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSupplier.setBounds(38, 312, 106, 33);
		panel_1.add(lblSupplier);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReports.setBounds(35, 470, 106, 33);
		panel_1.add(lblReports);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbout.setBounds(38, 636, 106, 33);
		panel_1.add(lblAbout);
		
		JLabel lblNewLabel_2 = new JLabel("Brand");
		lblNewLabel_2.setBounds(277, 121, 132, 51);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("SUPERMARKET POINT OF SALE SYSTEM");
		lblNewLabel_2_1.setBounds(357, 49, 555, 51);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(222, 195, 519, 430);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Brand", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(panel);
		panel.setLayout(null);
		
		textBrand = new JTextField();
		textBrand.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textBrand.setBounds(300, 57, 192, 39);
		panel.add(textBrand);
		textBrand.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Brand");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(34, 57, 153, 41);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Status");
		lblNewLabel_2_2.setBounds(34, 127, 132, 47);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(300, 126, 189, 48);
		panel.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 25));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "DeActive"}));
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(10, 279, 132, 76);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand=textBrand.getText();
				String status =comboBox.getSelectedItem().toString();
				try {
			
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("insert into brand(Brand,Status) values(?,?);");
					pst.setString(1, brand);
					pst.setString(2,status);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record successfully added");
					ResultSet rst = pst.executeQuery("select * from brand");
					table.setModel(DbUtils.resultSetToTableModel(rst));
					
	
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnUpdate = new JButton("DELETE");
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setBackground(new Color(34, 139, 34));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				int dialogueResult =JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning" ,JOptionPane.YES_NO_OPTION);
				
				if(dialogueResult==JOptionPane.YES_OPTION) {
					
					try {
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
						PreparedStatement pst = con.prepareStatement("delete from brand  where ID =?");
						//pst.setString(1, category);
						//pst.setString(2,status);
						pst.setInt(1,ID);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record successfully deleted");
						ResultSet rst = pst.executeQuery("select * from brand");
						table.setModel(DbUtils.resultSetToTableModel(rst));
						
						/*while(rst.next()) {
							
						}*/
						
					}catch(Exception e1) {
						System.out.println(e1);
					}	
					
					
					
				}
			
				
			}
			
		});
		btnUpdate.setBounds(341, 279, 168, 77);
		panel.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnDelete = new JButton("UPDATE");
		btnDelete.setBounds(152, 278, 168, 79);
		panel.add(btnDelete);
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setBackground(new Color(34, 139, 34));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				String brand = textBrand .getText();
				String status =comboBox.getSelectedItem().toString();
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("update brand set Brand=?,Status=? where ID =?");
					pst.setString(1, brand);
					pst.setString(2,status);
					pst.setInt(3,ID);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record successfully updated");
					ResultSet rst = pst.executeQuery("select * from brand");
					table.setModel(DbUtils.resultSetToTableModel(rst));
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		scrollPane =new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(751, 256, 608, 230);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//table.setModel();
				int selectedIndex = table.getSelectedRow();
				textBrand.setText(table.getValueAt(selectedIndex, 1).toString());
				comboBox.setSelectedItem(table.getValueAt(selectedIndex, 1).toString());
				
 }
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Category", "Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
	}
}
