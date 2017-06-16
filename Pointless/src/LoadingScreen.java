import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pointless.journey.window.Window;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadingScreen extends JFrame {

	private JPanel contentPane;
	private static LoadingScreen frame;

	/**
	 * Launch the application.
	 */
	public static void Begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoadingScreen();
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
	public LoadingScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_1887648760939");
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("loading-animation-bd.gif"));
		lblNewLabel.setBounds(97, 38, 236, 164);
		panel.add(lblNewLabel);
		
		JTextArea txtrAFewThings = new JTextArea();
		txtrAFewThings.setEditable(false);
		txtrAFewThings.setWrapStyleWord(true);
		txtrAFewThings.setText("A few things before you get started:\r\nExplore! We aren't going to hold your hand in this,\r\nyou'll have to look around to find where to go! \r\nHint: try the edges of the map\r\nDon't Die! Things are rough out there, and dying \r\nwon't solve anything, if you're having too much \r\ntrouble hold down space! but don't let go...\r\nAnd most of all, don't give up! If you're unlucky enough \r\nto beplaying a finished version of this game, it will do \r\neverything in it's power to stop you from quitting.");
		txtrAFewThings.setBounds(10, 254, 483, 190);
		panel.add(txtrAFewThings);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.paused=false;
				frame.setVisible(false);
			}
		});
		btnContinue.setBounds(196, 11, 89, 23);
		panel.add(btnContinue);
		
		
		
		
	}
}
