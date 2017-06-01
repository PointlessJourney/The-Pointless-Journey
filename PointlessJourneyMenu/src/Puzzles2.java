import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class Puzzles2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblOpenDoor;
	private JButton btnphillip;
	private JButton btnPhillip;
	private JButton btnphilip;
	private JButton btnNone;
	private JTextPane txtpnOnceUponA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzles2 frame = new Puzzles2();
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
	public Puzzles2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JButton btnphillip = new JButton("phillip");
		btnphillip.setBounds(109, 206, 226, 23);
		contentPane.add(btnphillip);

		final JButton btnPhillip = new JButton("Phillip");
		btnPhillip.setBounds(109, 183, 226, 23);
		contentPane.add(btnPhillip);

		final JButton btnphilip = new JButton("philip");
		btnphilip.setBounds(109, 160, 226, 23);
		contentPane.add(btnphilip);

		final JTextPane txtpnOnceUponA = new JTextPane();
		txtpnOnceUponA.setEditable(false);
		txtpnOnceUponA.setText("Once upon a time there were three guys named phillip, philip, and Phillip. One day philip ate a pizza that was so large he fell unconscious onto the floor. While philip was unconscious phillip and, Phillip went to get help. Along the way Phillip hit a wall and, also fell unconscious. Which Philip is still conscious? ");
		txtpnOnceUponA.setBounds(46, 11, 343, 138);
		contentPane.add(txtpnOnceUponA);

		final JButton btnNone = new JButton("None");
		btnNone.setBounds(109, 228, 226, 23);
		contentPane.add(btnNone);

		btnPhillip.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				btnphillip.setEnabled(false);
				btnphilip.setEnabled(false);
				btnNone.setEnabled(false);
				System.out.print("Incorrect");
			}
		}
				);

		btnphillip.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Correct");
				btnPhillip.setEnabled(false);
				btnphilip.setEnabled(false);
				btnNone.setEnabled(false);
			}
		}
				);

		btnphilip.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Incorrect");
				btnPhillip.setEnabled(false);
				btnphillip.setEnabled(false);
				btnNone.setEnabled(false);
			}
		}
				);
		
		btnNone.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Incorrect");
				btnPhillip.setEnabled(false);
				btnphillip.setEnabled(false);
				btnphilip.setEnabled(false);
			}
		}
				);

	}
}
