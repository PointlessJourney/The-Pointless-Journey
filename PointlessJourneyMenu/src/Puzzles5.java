import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Puzzles5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzles5 frame = new Puzzles5();
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
	public Puzzles5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(37, 23, 355, 149);
		contentPane.add(textPane);
		
		JButton button = new JButton("");
		button.setBounds(93, 183, 226, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(93, 205, 226, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(93, 228, 226, 23);
		contentPane.add(button_2);
	}
}
