import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		this.setExtendedState(Category.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1385, 800);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\download.jfif"));
		btnNewButton.setBounds(455, 38, 456, 297);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Developed By: Law Mashira");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(521, 380, 390, 76);
		contentPane.add(lblNewLabel);
		
		JLabel lblLawMashira = new JLabel("+263 772 608 332");
		lblLawMashira.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLawMashira.setBounds(570, 455, 303, 76);
		contentPane.add(lblLawMashira);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblOr.setBounds(674, 492, 71, 76);
		contentPane.add(lblOr);
		
		JLabel lblNewLabel_1 = new JLabel("+263 713 355 308");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(580, 526, 303, 76);
		contentPane.add(lblNewLabel_1);
	}
}
