import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Frame;

public class POS extends JFrame {

	private JPanel contentPane;
	private JTextField textProcode;
	private JTextField textPrice;
	private JTextField textQuantity;
	private JTextField textSubtotal;
	private JTextField textPay;
	private JTextField textBalance;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS frame = new POS();
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
	public POS() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(192, 192, 192));
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 255));
		panel_1.setBounds(0, 0, 212, 711);
		contentPane.add(panel_1);
		
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
		lblProduct.setBounds(21, 257, 120, 41);
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
		lblPos.setBounds(23, 414, 81, 31);
		panel_1.add(lblPos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 414, 81, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblExit = new JLabel("Log Out");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showConfirmDialog(null,"Do you want to exit from  the system?","Select",JOptionPane.YES_NO_OPTION);
		int Option=0;
				if(Option==JOptionPane.YES_OPTION) {
				
				System.exit(0);
			}
			
			}
		});
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblExit.setBounds(21, 576, 120, 31);
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
		lblBrand.setBounds(21, 178, 120, 31);
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
		lblCategory.setBounds(21, 84, 131, 41);
		panel_1.add(lblCategory);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setForeground(Color.WHITE);
		lblSupplier.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblSupplier.setBounds(21, 334, 106, 33);
		panel_1.add(lblSupplier);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(Color.WHITE);
		lblReports.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReports.setBounds(21, 494, 106, 33);
		panel_1.add(lblReports);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbout.setBounds(21, 639, 106, 33);
		panel_1.add(lblAbout);
		
		JLabel lblNewLabel_2 = new JLabel("POS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_2.setBounds(228, 31, 132, 56);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(279, 98, 150, 29);
		contentPane.add(lblNewLabel);
		
		JTextField textProname = new JTextField();
		textProname.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textProname.setColumns(10);
		textProname.setBounds(564, 202, 262, 51);
		contentPane.add(textProname);
		
		JLabel lblNewLabel_3 = new JLabel("Product Code");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3.setBounds(227, 153, 262, 44);
		contentPane.add(lblNewLabel_3);
		
		textProcode = new JTextField();
		textProcode.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textProcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					String name =textProcode.getText();
					try {
						
						Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
						PreparedStatement pst = con.prepareStatement("select * from product where barcode=?");
						pst.setString(1, name);
						ResultSet rst = pst.executeQuery();
						if(rst.next()==false) {
							JOptionPane.showMessageDialog(null, "Bar code not found");
						}else {
							String productName=rst.getString("product");
							String retailPrice=rst.getString("retail_price");
							textProname.setText(productName.trim());
							textPrice.setText(retailPrice.trim());
							
						}
		
						
					}catch(Exception e1) {
						System.out.println(e1);
					}
				}
				}
			
		});
		textProcode.setBounds(223, 202, 252, 51);
		contentPane.add(textProcode);
		textProcode.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Product Name");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_3_1.setBounds(574, 150, 252, 51);
		contentPane.add(lblNewLabel_3_1);
		/*
		JTextField textProname = new JTextField();
		textProname.setColumns(10);
		textProname.setBounds(553, 210, 104, 20);
		contentPane.add(textProname);*/
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Price");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3_1_1.setBounds(920, 150, 104, 51);
		contentPane.add(lblNewLabel_3_1_1);
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textPrice.setColumns(10);
		textPrice.setBounds(905, 202, 132, 52);
		contentPane.add(textPrice);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Quantity");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3_1_1_1.setBounds(1090, 150, 160, 51);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		textQuantity = new JTextField();
		textQuantity.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textQuantity.setColumns(10);
		textQuantity.setBounds(1100, 202, 150, 51);
		contentPane.add(textQuantity);
		
		JButton btnUpdate = new JButton("DELETE ITEM");
		btnUpdate.setForeground(new Color(0, 0, 0));
		btnUpdate.setBackground(new Color(34, 139, 34));
		btnUpdate.setSelectedIcon(null);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.removeRow(table.getSelectedRow());

				double sum=0;
				for(int p=0;p<table.getRowCount();p++) {
					sum=sum+Double.parseDouble( table.getValueAt(p, 4).toString());
				}
				
				textSubtotal.setText(Double.toString(sum));
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnUpdate.setBounds(1071, 445, 285, 80);
		contentPane.add(btnUpdate);
	  /*
		private void Pos() {
			String name =textProcode.getText();
			try {
				
				Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
				PreparedStatement pst = con.prepareStatement("select * from product where barcode=?");
				pst.setString(1, name);
				ResultSet rst = pst.executeQuery();
				
				while(rst.next()) {
					int Currentqty;
					Currentqty=rst.getInt("quantity");
					JOptionPane.showMessageDialog(null, Currentqty);
				}
				
				
				
		}catch(Exception ex) {
			System.out.println(ex);
			}
	*/
		
	
		
		
		
		JButton btnNewButton = new JButton("ADD ITEM");
		btnNewButton.setIcon(null);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name =textProcode.getText();
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					PreparedStatement pst = con.prepareStatement("select * from product where barcode=?");
					pst.setString(1, name);
					ResultSet rst = pst.executeQuery();
					
					while(rst.next()) {
						int Currentqty;
						Currentqty=rst.getInt("quantity");
						double price= Double.parseDouble(textPrice.getText());
						int qty =Integer.parseInt(textQuantity.getText());
						double total=price*qty;
						
						if(qty>Currentqty) {
						JOptionPane.showMessageDialog(null, "No adequate quantity");
						JOptionPane.showMessageDialog(null,"Current availability " +"= " +Currentqty);
						} else {
							//table.setModel(DbUtils.resultSetToTableModel(rst));
							DefaultTableModel model=(DefaultTableModel)table.getModel();
						model.addRow(new Object[] {
							textProcode.getText(),
							textProname.getText(),
						textPrice.getText(),
						textQuantity.getText(),
						total,
						}
								);
						
						double sum=0;
						for(int p=0;p<table.getRowCount();p++) {
							sum=sum+Double.parseDouble( table.getValueAt(p, 4).toString());
						}
						
						textSubtotal.setText(Double.toString(sum));
						
						textProcode.setText("");
						textProname.setText("");
					textPrice.setText("");
					textQuantity.setText("");
				
							
							
								}
						
						}
						
					
					
					
					
			}catch(Exception ex) {
				System.out.println(ex);
				}
				
				
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnNewButton.setBounds(1071, 281, 285, 80);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3_2 = new JLabel("SubTotal");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3_2.setBounds(222, 637, 207, 51);
		contentPane.add(lblNewLabel_3_2);
		
		textSubtotal = new JTextField();
		textSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 36));
		textSubtotal.setColumns(10);
		textSubtotal.setBounds(404, 628, 145, 60);
		contentPane.add(textSubtotal);
		
		JLabel lblNewLabel_3_3 = new JLabel("Pay");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3_3.setBounds(566, 631, 82, 57);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Change");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_3_3_1.setBounds(769, 636, 160, 52);
		contentPane.add(lblNewLabel_3_3_1);
		
		textPay = new JTextField();
		textPay.setFont(new Font("Tahoma", Font.PLAIN, 36));
		textPay.setColumns(10);
		textPay.setBounds(640, 628, 124, 60);
		contentPane.add(textPay);
		
		textBalance = new JTextField();
		textBalance.setFont(new Font("Tahoma", Font.PLAIN, 36));
		textBalance.setColumns(10);
		textBalance.setBounds(920, 628, 150, 60);
		contentPane.add(textBalance);
		
		JButton btnInvoice = new JButton(" PAY INVOICE");
		btnInvoice.setForeground(new Color(0, 0, 0));
		btnInvoice.setBackground(new Color(34, 139, 34));
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double pay =Double.parseDouble(textPay.getText());
				double subtotal =Double.parseDouble(textSubtotal.getText());
				double balance=pay-subtotal;
				textBalance.setText(String.valueOf(balance));
				
				DateTimeFormatter Dft =DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDateTime now =LocalDateTime.now();
				String date =Dft.format(now);
				String subtot = textSubtotal.getText();
				String pay2 = textPay.getText();
				String bal = textBalance.getText();
				int lastID=0;
				try {
					
					Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarketdb","root","");
					String query="insert into sales(date,subtotal,pay,balance) values(?,?,?,?);";
					
					PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
					pst.setString(1, date);
					pst.setString(2,subtot);
					pst.setString(3,pay2);
					pst.setString(4,bal);

					pst.executeUpdate();
					
					ResultSet generatedKeyResult =pst.getGeneratedKeys();
					if(generatedKeyResult.next()) {
						lastID=generatedKeyResult.getInt(1);
						//JOptionPane.showMessageDialog(null, lastID);
					}
					
					int rows =table.getRowCount();
					String query2="insert into sales_product( salesID, productID, sell_price, quantity, total) values(?,?,?,?,?);";
					 pst = con.prepareStatement(query2);
					 String productID="";
					 String productPrice="";
					 String produceQuantity="";
					 double total=0;
					 
					 for(int p =0;p<table.getRowCount();p++) {
						 productID= (String)table.getValueAt(p, 0);
						 productPrice= (String)table.getValueAt(p, 2);
						 produceQuantity= (String)table.getValueAt(p, 3);
						 total= (Double)table.getValueAt(p, 4);
						 pst.setInt(1, lastID);
						 pst.setString(2, productID);
						 pst.setString(3, productPrice);
						 pst.setString(4, produceQuantity);
						 pst.setDouble(5, total);
						 pst.executeUpdate();
					 }
					 
					
					 
					 
					 
					 
						String query3=" update product set quantity=quantity-? where barcode=?";
						 pst = con.prepareStatement(query3);
					 
						 
						 for(int p =0;p<table.getRowCount();p++) {
							 productID= (String)table.getValueAt(p, 0);
							 //productPrice= (String)table.getValueAt(p, 2);
							 produceQuantity= (String)table.getValueAt(p, 3);
							 //total= (Double)table.getValueAt(p, 4);
							 pst.setString(1, produceQuantity);
							 pst.setString(2,  productID);
							pst.execute();
						 }
					 
					 
					 pst.addBatch();
					 JOptionPane.showMessageDialog(null, " product yatengwa");
					 
					 String sub =textSubtotal.getText();
					 String Pay =textPay.getText();
					 String bala =textBalance.getText();
					 
					 new PRINT(sub,Pay,bala,table.getModel()).setVisible(true);
					 
					 
					 
			
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
				
				
			}
			
		});
		btnInvoice.setFont(new Font("Tahoma", Font.BOLD, 34));
		btnInvoice.setBounds(1079, 603, 277, 85);
		contentPane.add(btnInvoice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(153, 50, 204));
		scrollPane.setFont(new Font("Tahoma", Font.BOLD, 24));
		scrollPane.setBounds(222, 264, 846, 353);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Product Code", "Product Name", "Price", "Quantity", "Total",
			}
		) {
			
			
			
		});
	}
}
