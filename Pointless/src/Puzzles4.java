import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pointless.journey.window.Window;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Puzzles4 extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnIAmA;
	private JButton btnFelix;
	private JButton btnNewton;
	private JButton btnEinstein;
	private static Puzzles4 frame;

	/**
	 * Launch the application.
	 */
	public static void Begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Puzzles4();
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
	public Puzzles4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextPane txtpnIAmA = new JTextPane();
		txtpnIAmA.setText("I am a son of a chemist and a mathematician.\r\nPeople called me Iron59.\r\n\r\nWhat's my name?\r\n");
		txtpnIAmA.setEditable(false);
		txtpnIAmA.setBounds(36, 21, 355, 149);
		contentPane.add(txtpnIAmA);
		
		final JButton btnN = new JButton("Newton\r\n");
		btnN.setBounds(101, 181, 226, 23);
		contentPane.add(btnN);
		
		final JButton btnF = new JButton("Felix\r\n");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnF.setBounds(101, 204, 226, 23);
		contentPane.add(btnF);
		
		final JButton btnE = new JButton("Einstein");
		btnE.setBounds(101, 228, 226, 23);
		contentPane.add(btnE);
		
		btnE.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Incorrect");
				//btnN.setEnabled(false);
				//btnE.setEnabled(false);
			}
		}
				);
		
		btnN.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				
				
				System.out.print("Incorrect");
			//	btnF.setEnabled(false);
				//btnN.setEnabled(false);
			}
		}
				);
		btnF.addActionListener (new ActionListener ()
				{
					public void actionPerformed (ActionEvent e)
					{
						
						System.out.print("Correct");
						Window.paused=false;
						frame.setVisible(true);
						//btnF.setEnabled(false);
						//btnE.setEnabled(false);
					}
				}
						);
		
	}
}
