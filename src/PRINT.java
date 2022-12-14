import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PRINT extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PRINT frame = new PRINT();
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
	public PRINT() {
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 268, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(79, 213, 5, 22);
		contentPane.add(textArea);

		
		
		

		
	}
	
	 String lsub;
	 String lPay;
	 String lbala;
	 
	
	public PRINT(String sub, String Pay, String bala, TableModel tablemodel) {
		// TODO Auto-generated constructor stub
		this.lsub=sub;
		this.lPay=Pay;
		this.lbala= bala;
		
		
		/*textArea.setText(textArea.getText() + "************SUPERPOS***********\n");
		textArea.setText(textArea.getText()+"\n");
		textField.setText(textField.getText() +);*/
	}
}
