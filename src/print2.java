import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class print2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFNumber1;
	private JTextField textNumber2;
	private JTextField textTotal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					print2 frame = new print2();
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
	public print2() {
		setFont(new Font("Dialog", Font.BOLD, 16));
		setForeground(new Color(255, 255, 0));
		setBackground(new Color(255, 20, 147));
		setTitle("Addition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 434);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Number One");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 75, 117, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNumberTwo = new JLabel("Number Two");
		lblNumberTwo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNumberTwo.setBounds(20, 167, 117, 35);
		contentPane.add(lblNumberTwo);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Javanese Text", Font.BOLD, 16));
		lblTotal.setBounds(10, 248, 117, 35);
		contentPane.add(lblTotal);
		
		textFNumber1 = new JTextField();
		textFNumber1.setBounds(214, 84, 129, 35);
		contentPane.add(textFNumber1);
		textFNumber1.setColumns(10);
		
		textNumber2 = new JTextField();
		textNumber2.setColumns(10);
		textNumber2.setBounds(214, 176, 129, 35);
		contentPane.add(textNumber2);
		
		textTotal = new JTextField();
		textTotal.setBackground(new Color(0, 255, 255));
		textTotal.setForeground(new Color(0, 0, 0));
		textTotal.setFont(new Font("Javanese Text", Font.ITALIC, 16));
		textTotal.setColumns(10);
		textTotal.setBounds(61, 260, 348, 35);
		contentPane.add(textTotal);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double n1 = Double.parseDouble(textFNumber1.getText());
				int n2 = Integer.parseInt(textNumber2.getText());
				double total = n1+n2;
				textField.setText(Double.toString(total));
				textTotal.setText("Welcome to GUI with Core Java Programming");
						
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(204, 335, 139, 49);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(198, 25, 129, 35);
		contentPane.add(textField);
	}
}
