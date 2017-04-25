import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Decleration
	//Panel (Main Menu)
	JPanel panel = new JPanel();
	JButton btnA = new JButton("Exit");
	JButton btnHelp = new JButton("Help");
	JButton btnOptions = new JButton("Options");
	JButton btnNewGame = new JButton("New Game");
	JButton btnContinue = new JButton("Continue");
	JLabel lblNewLabel = new JLabel("New label");//Background image
	JLabel lblNewLabel_5 = new JLabel("");//ea
	JLabel lblNewLabel_1 = new JLabel("");//title
	int x = 0;
	//ee
	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	//
	JLabel lblNewLabel_2 = new JLabel("");
	JLabel lblNewLabel_3 = new JLabel("");
	JLabel lblNewLabel_6 = new JLabel("");
	//Panel 1 (option button)	
	JPanel panel_1 = new JPanel();
	JButton btnMainMenu = new JButton("Main Menu");
	JLabel label = new JLabel("New label");
	//Panel 2 (help button)	
	JPanel panel_2 = new JPanel();
	JButton button = new JButton("Main Menu");
	JLabel label_1 = new JLabel("New label");
	//Panel 3	
	JPanel panel_3 = new JPanel();
	JButton button_1 = new JButton("Main Menu");
	JLabel label_2 = new JLabel("New label");
	JLabel lblNewLabel_4 = new JLabel("Sorry only way to exit is\r\n");
	

	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(840,535);

		//getting size than making it full screen with top buttons
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//pack();
		//setSize(screenSize.width,screenSize.height);

		//full screen 
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		//setAlwaysOnTop(true);


		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(panel, "name_21515824946450");
		panel.setLayout(null);
		btnA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//exit action listener
				panel_3.setVisible(true);
				panel.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnA.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnA.setForeground(Color.WHITE);
			}
		});


		btnA.setHorizontalAlignment(SwingConstants.LEFT);
		btnA.setOpaque(false);
		btnA.setForeground(Color.WHITE);
		btnA.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnA.setFocusPainted(false);
		btnA.setContentAreaFilled(false);
		btnA.setBorderPainted(false);
		btnA.setBounds(688, 404, 59, 26);
		panel.add(btnA);
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//help action listener
				panel_2.setVisible(true);
				panel.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHelp.setForeground(Color.WHITE);
			}
		});


		btnHelp.setOpaque(false);
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnHelp.setFocusPainted(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setBorderPainted(false);
		btnHelp.setBounds(543, 404, 116, 26);
		panel.add(btnHelp);
		btnOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//options action listener
				panel_1.setVisible(true);
				panel.setVisible(false);			
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnOptions.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOptions.setForeground(Color.WHITE);
			}
		});


		btnOptions.setOpaque(false);
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnOptions.setFocusPainted(false);
		btnOptions.setContentAreaFilled(false);
		btnOptions.setBorderPainted(false);
		btnOptions.setBounds(441, 404, 92, 26);
		panel.add(btnOptions);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new game action listener
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewGame.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewGame.setForeground(Color.WHITE);
			}
		});


		btnNewGame.setOpaque(false);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnNewGame.setFocusPainted(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorderPainted(false);
		btnNewGame.setBounds(315, 404, 116, 26);
		panel.add(btnNewGame);
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Continue game action listener
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnContinue.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnContinue.setForeground(Color.WHITE);
			}
		});


		btnContinue.setOpaque(false);
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnContinue.setFocusPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setBorderPainted(false);
		btnContinue.setBounds(91, 404, 101, 26);
		panel.add(btnContinue);
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				x++;
				if (x==10)
				{
					lblNewLabel_5.setVisible(false);
				}
			}
		});
		
		
		lblNewLabel_5.setIcon(new ImageIcon("G:\\Pictures\\Black-screen_2511_1.jpg"));
		lblNewLabel_5.setBounds(100, 11, 92, 78);
		panel.add(lblNewLabel_5);
		lblNewLabel_2.setIcon(new ImageIcon("G:\\Pictures\\sao_lost_song_logo_2_by_gunsli.png"));
		lblNewLabel_2.setBounds(101, 26, 51, 51);

		panel.add(lblNewLabel_2);
		lblNewLabel_3.setIcon(new ImageIcon("G:\\Pictures\\blankk.jpg"));
		lblNewLabel_3.setBounds(101, 26, 51, 51);

		panel.add(lblNewLabel_3);

		
		lblNewLabel_1.setIcon(new ImageIcon("G:\\Pictures\\FinTitle.png"));
		lblNewLabel_1.setBounds(22, -13, 304, 285);
		panel.add(lblNewLabel_1);
		lblNewLabel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				//ee 1
				
			}
		});


		lblNewLabel.setIcon(new ImageIcon("G:\\Pictures\\92751e0ca5fb8b890839121c472df4f3.gif"));
		lblNewLabel.setBounds(0, 0, 1014, 497);
		panel.add(lblNewLabel);
		lblNewLabel_6.setBounds(768, 11, 46, 14);
		
		panel.add(lblNewLabel_6);
		//Panel 1		
		contentPane.add(panel_1, "name_1431079614477");
		panel_1.setLayout(null);
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Panel 1 (options menu) main Menu button action listener
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMainMenu.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMainMenu.setForeground(Color.WHITE);
			}
		});

		btnMainMenu.setOpaque(false);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnMainMenu.setFocusPainted(false);
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setBounds(10, 11, 116, 26);
		panel_1.add(btnMainMenu);


		label.setIcon(new ImageIcon("G:\\Pictures\\92751e0ca5fb8b890839121c472df4f3.gif"));
		label.setBounds(0, 0, 1014, 497);
		panel_1.add(label);

		//Panel 2		
		contentPane.add(panel_2, "name_1576174767462");
		panel_2.setLayout(null);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Panel 2 (help main) main menu button action listener
				panel.setVisible(true);
				panel_2.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setForeground(Color.WHITE);
			}
		});


		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(10, 11, 116, 26);
		panel_2.add(button);


		label_1.setIcon(new ImageIcon("G:\\Pictures\\92751e0ca5fb8b890839121c472df4f3.gif"));
		label_1.setBounds(0, 0, 1014, 497);
		panel_2.add(label_1);


		contentPane.add(panel_3, "name_1583552623428");
		panel_3.setLayout(null);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(true);
				panel_3.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				button_1.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_1.setForeground(Color.WHITE);
			}

		});


		button_1.setOpaque(false);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setBounds(10, 11, 116, 26);
		panel_3.add(button_1);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("MV Boli", Font.PLAIN, 65));
		lblNewLabel_4.setBounds(20, 91, 783, 90);

		panel_3.add(lblNewLabel_4);

		JLabel lblByBeatingThe = new JLabel("by beating the game");
		lblByBeatingThe.setForeground(Color.WHITE);
		lblByBeatingThe.setFont(new Font("MV Boli", Font.PLAIN, 65));
		lblByBeatingThe.setBounds(100, 185, 783, 90);
		panel_3.add(lblByBeatingThe);

		JLabel lblKayabaAkihiko = new JLabel("- Kayaba Akihiko");
		lblKayabaAkihiko.setForeground(Color.WHITE);
		lblKayabaAkihiko.setFont(new Font("MV Boli", Font.PLAIN, 65));
		lblKayabaAkihiko.setBounds(153, 275, 783, 90);
		panel_3.add(lblKayabaAkihiko);


		label_2.setIcon(new ImageIcon("G:\\Pictures\\92751e0ca5fb8b890839121c472df4f3.gif"));
		label_2.setBounds(0, 0, 1014, 497);
		panel_3.add(label_2);


	}
}
