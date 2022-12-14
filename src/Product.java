import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import com.mysql.cj.protocol.a.NativeConstants.IntegerDataType;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Product extends JFrame {

	private JPanel contentPane;
	private JTextField textProduct;
	private JTextField textDesc;
	private JTextField textCost;
	private JTextField textRetail;
	private JTextField textBarcode;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product frame = new Product();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public class categoryItem{
		int ID;
		String Name;
		
		public categoryItem(int ID, String Name) {
			this.ID=ID;
			this.Name=Name;
		}
		public String toString() {
			return Name;
		}
	}

	private  void Category() {
		try {
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
			PreparedStatement pst = con.prepareStatement("insert into category(Category,Status) values(?,?);");
			//pst.setString(1, category);
			//pst.setString(2,status);
			pst.executeUpdate();
			//JOptionPane.showMessageDialog(null,"Record successfully added");
			ResultSet rst = pst.executeQuery("select * from category");
			
			//comboCategory.removeAllItems();
			
			
			
			
			//table.setModel(DbUtils.resultSetToTableModel(rst));
			
			while(rst.next()) {
				//comboCategory.addItem(new categoryItem(rst.getInt(1),rst.getString(2)));
			}
			
		}catch(Exception e1) {
			//System.out.println(e1);
		}
	}
		
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Product() {
		setBackground(Color.GREEN); 
		this.setExtendedState(Product.MAXIMIZED_BOTH);

		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("select * from product");
					//pst.setString(1, category);
					//pst.setString(2,status);
					//pst.executeUpdate();
					//JOptionPane.showMessageDialog(null,"Record successfully added");
					ResultSet rst = pst.executeQuery();
					
	
					table.setModel(DbUtils.resultSetToTableModel(rst));

					
					
		
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("SUPERMARKET POINT OF SALE SYSTEM");
		lblNewLabel_2_1.setBounds(323, 11, 1000, 28);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 0, 212, 712);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Category");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new Category().setVisible(true);
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 57, 142, 37);
		panel_1.add(lblNewLabel);
		
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
		lblBrand.setBounds(10, 126, 81, 37);
		panel_1.add(lblBrand);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setForeground(Color.WHITE);
		lblProduct.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblProduct.setBounds(10, 205, 117, 31);
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
		lblPos.setBounds(10, 372, 81, 31);
		panel_1.add(lblPos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 414, 81, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSupplier.setBounds(10, 289, 106, 33);
		panel_1.add(lblSupplier);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReports.setBounds(10, 457, 106, 33);
		panel_1.add(lblReports);
		
		JLabel lblExit_1 = new JLabel("Log Out");
		lblExit_1.setForeground(Color.WHITE);
		lblExit_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExit_1.setBounds(10, 559, 103, 44);
		panel_1.add(lblExit_1);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbout.setBounds(10, 656, 106, 33);
		panel_1.add(lblAbout);
		
		JLabel lblNewLabel_2 = new JLabel("Product");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(217, 74, 132, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Product");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3.setBounds(343, 123, 112, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Description");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(343, 192, 148, 28);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Category");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_2.setBounds(343, 263, 132, 28);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Brand");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_3.setBounds(343, 342, 81, 29);
		contentPane.add(lblNewLabel_3_3);
		
		textProduct = new JTextField();
		textProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textProduct.setBounds(499, 110, 274, 40);
		contentPane.add(textProduct);
		textProduct.setColumns(10);
		
		textDesc = new JTextField();
		textDesc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDesc.setColumns(10);
		textDesc.setBounds(500, 174, 274, 72);
		contentPane.add(textDesc);
		
		
		JComboBox comboBrand = new JComboBox();
		comboBrand.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBrand.setBounds(499, 336, 274, 40);
		contentPane.add(comboBrand);
		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("select * from brand");
					//pst.setString(1, category);
					//pst.setString(2,status);
					//pst.executeUpdate();
					//JOptionPane.showMessageDialog(null,"Record successfully added");
					ResultSet rst = pst.executeQuery();
					
					comboBrand.removeAllItems();
					//table.setModel(DbUtils.resultSetToTableModel(rst));
					
					

					
					
					
					
					while(rst.next()) {
						comboBrand.addItem(new categoryItem(rst.getInt(1),rst.getString(2)));
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});
		
		JComboBox comboCategory = new JComboBox();
		comboCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboCategory.setBounds(499, 271, 274, 40);
		contentPane.add(comboCategory);
		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("select * from category");
					//pst.setString(1, category);
					//pst.setString(2,status);
					//pst.executeUpdate();
					//JOptionPane.showMessageDialog(null,"Record successfully added");
					ResultSet rst = pst.executeQuery();
					comboCategory.removeAllItems();
					//table.setModel(DbUtils.resultSetToTableModel(rst));
					while(rst.next()) {
						comboCategory.addItem(new categoryItem(rst.getInt(1),rst.getString(2)));
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_3_4 = new JLabel("Cost Price");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_4.setBounds(955, 120, 164, 28);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Retail Price");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_5.setBounds(955, 174, 164, 29);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("Quantity");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_6.setBounds(955, 224, 132, 37);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("Barcode");
		lblNewLabel_3_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_7.setBounds(955, 277, 132, 38);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_3_8 = new JLabel("Status");
		lblNewLabel_3_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_3_8.setBounds(955, 347, 81, 37);
		contentPane.add(lblNewLabel_3_8);
		
		textCost = new JTextField();
		textCost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCost.setColumns(10);
		textCost.setBounds(1176, 111, 147, 37);
		contentPane.add(textCost);
		
		textRetail = new JTextField();
		textRetail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textRetail.setColumns(10);
		textRetail.setBounds(1176, 166, 147, 37);
		contentPane.add(textRetail);
		
		JTextField textQuantity = new JTextField();
		textQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textQuantity.setColumns(10);
		textQuantity.setBounds(1176, 221, 147, 37);
		contentPane.add(textQuantity);
		
		textBarcode = new JTextField();
		textBarcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textBarcode.setColumns(10);
		textBarcode.setBounds(1176, 282, 147, 37);
		contentPane.add(textBarcode);
		
		JComboBox comboStatus = new JComboBox();
		comboStatus.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"Active", "DeActive"}));
		comboStatus.setBounds(1176, 347, 147, 37);
		contentPane.add(comboStatus);
		
		
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int selectedIndex = table.getSelectedRow();
				//int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				categoryItem item =(categoryItem) comboCategory.getSelectedItem();
				categoryItem item2 =(categoryItem) comboBrand.getSelectedItem();
					try {
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
						PreparedStatement pst = con.prepareStatement("insert into product( product, description, cat_ID, brand_ID, cost_price, retail_price, quantity, barcode, status) values(?,?,?,?,?,?,?,?,?);");
						//pst.setInt(0,ID);
						pst.setString(1, textProduct.getText());
						pst.setString(2,textDesc.getText());
						pst.setInt ( 3,item.ID);
						pst.setInt(4,item2.ID);
						pst.setString(5,textCost.getText());
						pst.setString(6,textRetail.getText());
						pst.setString(7,textQuantity.getText());
						pst.setString(8,textBarcode.getText());
						pst.setString(9,comboStatus.getSelectedItem().toString());
						
						
						
						
						
						
						
						//pst.setString(8,textDesc.getText());
						//pst.setString(9,textDesc.getText());
						//pst.setString(9,textDesc.getText());
						
						
						
						
						
						
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record successfully added");
						
						ResultSet rst = pst.executeQuery("select * from product");
						table.setModel(DbUtils.resultSetToTableModel(rst));
						
						//ResultSet rst = pst.executeQuery("select * from category");
						
						//comboCategory.removeAllItems();
		
						
						/*while(rst.next()) {
							//comboCategory.addItem( new categoryItem(rst.getInt(1),rst.getString(2)));
						}*/
						
					}catch(Exception e1) {
						System.out.println(e1);
					}
						}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(341, 399, 134, 61);
		contentPane.add(btnNewButton);
		
		JButton btnDelete = new JButton("UPDATE");
		btnDelete.setBackground(new Color(34, 139, 34));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String product=textProduct.getText();
				String desc=textDesc.getText();
				categoryItem item =(categoryItem) comboCategory.getSelectedItem();
				categoryItem item2 =(categoryItem) comboBrand.getSelectedItem();
				String cprice=textCost.getText();
				String rprice=textRetail.getText();
				String qty=textQuantity.getText();
				String barcode=textBarcode.getText();
				String status =comboStatus.getSelectedItem().toString();
				
				
				int selectedIndex = table.getSelectedRow();
				int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				//textProduct.setText(table.getValueAt(selectedIndex,1 ).toString());
			
				
				
				//String category = textCategory .getText();
				//String status =comboBox.getSelectedItem().toString();
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("update product set product=?,description=?,cat_ID=?,brand_ID=?,cost_price=?,retail_price=?,quantity= ?,barcode=?,status=? where ID =?");
					//pst.setString(1, category);
					//pst.setString(2,status);
					pst.setString(1, product);
					pst.setString(2,desc);
					pst.setInt ( 3,item.ID);
					pst.setInt(4,item2.ID);
					pst.setString(5,cprice);
					pst.setString(6,rprice);
					pst.setString(7,qty);
					pst.setString(8,barcode);
					pst.setString(9,status);
					pst.setInt(10,ID);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Record successfully updated");
					ResultSet rst = pst.executeQuery("select * from product");
					table.setModel(DbUtils.resultSetToTableModel(rst));
					//textProduct.setText(table.getValueAt(selectedIndex,1 ).toString());
					//textDesc.setText(table.getValueAt(selectedIndex,2 ).toString());
					
					
					
					
					
					
					//int selectedIndex = table.getSelectedRow();
					
					/*while(rst.next()) {
						
					}*/
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
				
				
				
				
				
				
				
			
			
	
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnDelete.setBounds(505, 399, 164, 61);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("DELETE");
		btnUpdate.setBackground(new Color(34, 139, 34));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = table.getSelectedRow();
				int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				int dialogueResult =JOptionPane.showConfirmDialog(null, "Do you want to delete the record","Warning" ,JOptionPane.YES_NO_OPTION);
				
				if(dialogueResult==JOptionPane.YES_OPTION) {
					
					try {
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
						PreparedStatement pst = con.prepareStatement("delete from product  where ID =?");
						//pst.setString(1, category);
						//pst.setString(2,status);
						pst.setInt(1,ID);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Record successfully deleted");
						ResultSet rst = pst.executeQuery("select * from product");
						table.setModel(DbUtils.resultSetToTableModel(rst));
						
						/*while(rst.next()) {
							
						}*/
						
					}catch(Exception e1) {
						System.out.println(e1);
					}	
					
					
					
				}
	
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUpdate.setBounds(679, 399, 198, 61);
		contentPane.add(btnUpdate);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedIndex = table.getSelectedRow();
				//int ID = Integer .parseInt(table.getValueAt(selectedIndex, 0).toString());
				//setInt(0,ID);
				textProduct.setText(table.getValueAt(selectedIndex, 1).toString());
				textDesc.setText(table.getValueAt(selectedIndex, 2).toString());
				comboCategory.setSelectedItem(table.getValueAt(selectedIndex, 3).toString());
				comboBrand.setSelectedItem(table.getValueAt(selectedIndex, 4).toString());
				textCost.setText(table.getValueAt(selectedIndex, 5).toString());
				textRetail.setText(table.getValueAt(selectedIndex, 6).toString());
				textQuantity.setText(table.getValueAt(selectedIndex, 7).toString());
				textBarcode.setText(table.getValueAt(selectedIndex, 8).toString());
				comboStatus.setSelectedItem(table.getValueAt(selectedIndex, 9).toString());
			}
		});
		scrollPane.setBounds(229, 471, 1083, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Product", "Description", "Category", "Brand", "Cost Price", "Retail Price", "Quantity", "Barcode", "Status"
			}
	));
		/*
		JComboBox comboCategory = new JComboBox();
		comboCategory.setBounds(449, 266, 139, 22);
		contentPane.add(comboCategory);
		

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("select * from category");
					//pst.setString(1, category);
					//pst.setString(2,status);
					//pst.executeUpdate();
					//JOptionPane.showMessageDialog(null,"Record successfully added");
					ResultSet rst = pst.executeQuery();
					comboCategory.removeAllItems();
					//table.setModel(DbUtils.resultSetToTableModel(rst));
					while(rst.next()) {
						comboCategory.addItem(new categoryItem(rst.getInt(1),rst.getString(2)));
					}
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
			
		});	*/
	         }
	}
	