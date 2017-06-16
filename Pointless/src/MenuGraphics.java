import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pointless.journey.window.Window;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MenuGraphics extends JFrame {

	private JPanel contentPane;
	private JLabel lblPause;
	private JLabel lblAltKeyFor;
	private JLabel lblDKeyPlayer;
	private JLabel lblEKeyFor;
	private JLabel lblMouseClickdirectionTo;
	private JLabel lblSKeyPlayer;
	private JLabel lblWKeyTo;
	private JLabel lblAKeyPlayer;
	private JLabel lblSpaceBarActivates;
	private JLabel lblChangeControls;
	private JLabel lblChangeDisplay;
	private JLabel lblAdjustVolume;
	private JLabel lblMainMenu;
	private JLabel lblAdjustControls;
	private JButton btnPause;
	private JButton btnBack;
	private JButton btnResume;
	private JButton btnSettings;
	private JButton btnHelp;
	private JButton btnOptions;
	private JButton btnExit;
	private static MenuGraphics frame;


	/**
	 * Launch the application.
	 */
	public static void Begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenuGraphics();
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
	public MenuGraphics() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[17px][][][grow][]", "[grow][][][][grow][][][][][][][][][][][][227px]"));

		final JButton btnOptions = new JButton("Options");
		btnOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		final JLabel lblPause = new JLabel("Pause");
		contentPane.add(lblPause, "cell 3 1");

		final JLabel lblWKeyTo = new JLabel("W key to Jump");
		contentPane.add(lblWKeyTo, "cell 2 2");

		final JButton btnPause = new JButton("Pause");
		contentPane.add(btnPause, "cell 3 2,alignx right");

		final JLabel lblAKeyPlayer = new JLabel("A key player moves left");
		contentPane.add(lblAKeyPlayer, "cell 2 6");

		final JButton btnResume = new JButton("Resume");
		contentPane.add(btnResume, "cell 3 6");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Window.paused=false;
				frame.setVisible(false);
			}
		});

		final JLabel lblAltKeyFor = new JLabel("Alt key for speech");
		contentPane.add(lblAltKeyFor, "cell 4 6");

		final JLabel lblDKeyPlayer = new JLabel("D key player moves right");
		contentPane.add(lblDKeyPlayer, "cell 2 8");

		final JButton btnSettings = new JButton("Settings");
		contentPane.add(btnSettings, "flowx,cell 3 8");

		final JLabel lblEKeyFor = new JLabel("E key for interaction");
		contentPane.add(lblEKeyFor, "cell 4 8");

		final JLabel lblSKeyPlayer = new JLabel("S key player moves down ");
		contentPane.add(lblSKeyPlayer, "cell 2 10");

		final JButton btnHelp = new JButton("Help");
		contentPane.add(btnHelp, "cell 3 10");

		final JLabel lblMouseClickdirectionTo = new JLabel("Mouse click+direction to shoot");
		contentPane.add(lblMouseClickdirectionTo, "cell 4 10");

		final JLabel lblSpaceBarActivates = new JLabel("Space Bar activates power up");
		contentPane.add(lblSpaceBarActivates, "cell 2 12");
		contentPane.add(btnOptions, "cell 3 12,aligny top");

		final JButton btnExit = new JButton("Exit");
		contentPane.add(btnExit, "cell 3 14");

		final JButton btnBack = new JButton("Back");
		contentPane.add(btnBack, "cell 1 16");

		final JLabel lblChangeDisplay = new JLabel("Change Display");
		contentPane.add(lblChangeDisplay, "cell 2 16");

		final JLabel lblAdjustGraphics = new JLabel("Adjust Graphics");
		contentPane.add(lblAdjustGraphics, "flowx,cell 3 16,alignx center,aligny top");

		final JLabel lblChangeControls = new JLabel("Change Controls");
		contentPane.add(lblChangeControls, "cell 3 16,alignx left");

		final JLabel lblAdjustVolume = new JLabel("Adjust Volume");
		contentPane.add(lblAdjustVolume, "cell 4 16");

		final JLabel lblMainMenu = new JLabel("Main Menu");
		contentPane.add(lblMainMenu, "cell 3 8");

		lblPause.setVisible(false);
		lblMainMenu.setVisible(false);
		lblAltKeyFor.setVisible(false);
		lblDKeyPlayer.setVisible(false);
		lblEKeyFor.setVisible(false);
		lblMouseClickdirectionTo.setVisible(false);
		lblSKeyPlayer.setVisible(false);
		lblWKeyTo.setVisible(false);
		lblAKeyPlayer.setVisible(false);
		lblSpaceBarActivates.setVisible(false);
		lblChangeControls.setVisible(false);
		lblAdjustGraphics.setVisible(false);
		lblChangeDisplay.setVisible(false);
		lblAdjustVolume.setVisible(false);
		btnExit.setVisible(false);
		btnBack.setVisible(false);
		btnResume.setVisible(false);
		btnOptions.setVisible(false);
		btnSettings.setVisible(false);
		btnHelp.setVisible(false);

		btnBack.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				btnBack.setVisible(false);
				lblChangeControls.setVisible(false);
				lblAdjustGraphics.setVisible(false);
				lblChangeDisplay.setVisible(false);
				lblAdjustVolume.setVisible(false);
				lblPause.setVisible(true);
				btnExit.setVisible(true);
				btnResume.setVisible(true);
				btnOptions.setVisible(true);
				btnSettings.setVisible(true);
				btnHelp.setVisible(true);
				btnPause.setVisible(false);
				lblAltKeyFor.setVisible(false);
				lblDKeyPlayer.setVisible(false);
				lblEKeyFor.setVisible(false);
				lblMouseClickdirectionTo.setVisible(false);
				lblSKeyPlayer.setVisible(false);
				lblWKeyTo.setVisible(false);
				lblAKeyPlayer.setVisible(false);
				lblSpaceBarActivates.setVisible(false);
			}
		}
				);

		btnPause.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(true);
				btnExit.setVisible(true);
				btnResume.setVisible(true);
				btnOptions.setVisible(true);
				btnSettings.setVisible(true);
				btnHelp.setVisible(true);
				btnPause.setVisible(false);
			}
		}
				);
		btnResume.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(false);
				btnPause.setVisible(true);
				btnExit.setVisible(false);
				btnResume.setVisible(false);
				btnOptions.setVisible(false);
				btnSettings.setVisible(false);
				btnHelp.setVisible(false);
			}
		}
				);
		btnSettings.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(false);
				btnExit.setVisible(false);
				btnResume.setVisible(false);
				btnOptions.setVisible(false);
				btnSettings.setVisible(false);
				btnHelp.setVisible(false);
				lblChangeControls.setVisible(true);
				lblAdjustGraphics.setVisible(true);
				btnBack.setVisible(true);
			}
		}
				);
		btnHelp.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(false);
				btnExit.setVisible(false);
				btnResume.setVisible(false);
				btnHelp.setVisible(false);
				btnOptions.setVisible(false);
				btnSettings.setVisible(false);
				lblAltKeyFor.setVisible(true);
				lblDKeyPlayer.setVisible(true);
				lblEKeyFor.setVisible(true);
				lblMouseClickdirectionTo.setVisible(true);
				lblSKeyPlayer.setVisible(true);
				lblWKeyTo.setVisible(true);
				lblAKeyPlayer.setVisible(true);
				lblSpaceBarActivates.setVisible(true);
				btnBack.setVisible(true);
			}
		}
				);
		btnOptions.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(false);
				btnExit.setVisible(false);
				btnResume.setVisible(false);
				btnOptions.setVisible(false);
				btnSettings.setVisible(false);
				btnHelp.setVisible(false);
				btnBack.setVisible(true);
				lblChangeDisplay.setVisible(true);
				lblAdjustVolume.setVisible(true);

			}
		}
				);
		btnExit.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{

				lblPause.setVisible(false);
				btnExit.setVisible(false);
				btnResume.setVisible(false);
				btnOptions.setVisible(false);
				btnSettings.setVisible(false);
				btnHelp.setVisible(false);
				lblPause.setVisible(false);
				lblMainMenu.setVisible(true);
			}
		}
				);
	}

}
