//josh has edited this again

//Discord Link: https://discord.gg/B2cWfMr

// http://www.beepbox.co/#5s0kbl00e03t7a7g0fj7i0r1w1111f0000d1112c0000h0000v0000o3210b4O8i8h8x4y4h4h4h4h4h4h4h4h4h4h4h4h4h4h4h4h4p21Dxj713g5Cf0EsAd5CjmlBk79zwrqaqwQRk1HOGOWJClCpBpBplxOqqrcCIHaEei2hj7i31xxidgqxw8kNQwQ6I18Fyg6Yd8qqagQxF00
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5776825164765599157L;
	private JPanel contentPane;
	public Clip clip;
	static MainMenu frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void Song() {
		  try {
		   File file = new File("BeepBox-Song.wav");
		   clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
		   clip.start();
		   clip.addLineListener(new LineListener(){
			   public void update(LineEvent update){
				   if(update.getType().equals(LineEvent.Type.CLOSE))clip.start();
			   }
		   });
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
		  return;
		 }

	//Decleration
	//Panel (Main Menu)
	JPanel panel = new JPanel();;
	JButton btnExit = new JButton("");
	JButton btnHelp = new JButton("");
	JButton btnOptions = new JButton("");
	JButton btnNewGame = new JButton("");
	JButton btnContinue = new JButton("");
	JLabel Background = new JLabel("");//Background image
	JLabel EasterEgg = new JLabel("");//ea
	JLabel Title = new JLabel("");//title
	int x = 0;//ee counter
	JLabel lblNewLabel_2 = new JLabel("");
	//Panel 1 (option button)	
	JPanel panel_1 = new JPanel();
	JButton btnMainMenu = new JButton("");
	JLabel label = new JLabel("New label");
	//Panel 2 (help button)	
	JPanel panel_2 = new JPanel();
	JButton button = new JButton("");
	JLabel label_1 = new JLabel("New label");
	//Panel 3	
	JPanel panel_3 = new JPanel();
	JButton button_1 = new JButton("");
	JLabel label_2 = new JLabel("New label");
	JLabel lblMessage = new JLabel("");
	int width;
	int height;//these three are used for resizing
	int offsetx = 0;
	int offsety = 0;
	
	public MainMenu() {
		Song();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(832,468);//for design purposes, simply comment out the resizing code to design something, then bring it back and introduce the percentages

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		if((double)(screenSize.getWidth()/16*9)<=(double)(screenSize.getHeight())){
			width = (int)(screenSize.getWidth()/16.0)*16;
			height = width/16*9;
			offsetx = (int)((screenSize.getWidth()-width)/2);
			offsety = (int)((screenSize.getHeight()-height)/2);
		}else{
			height = (int)(screenSize.getHeight()/9)*9;
			width = height/9*16;
			offsetx = (int)((screenSize.getWidth()-width)/2);
			offsety = (int)((screenSize.getHeight()-height)/2);
		}
		System.out.println("Width: "+width+"\nHeight: "+height);
		//pack();
		//setSize(width,height);

		//full screen 
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		//setAlwaysOnTop(true);

		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(panel, "name_21515824946450");
		panel.setLayout(null);
		panel.setBackground(new Color(0x05040b));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//exit action listener
				panel_3.setVisible(true);
				panel.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setIcon(new ImageIcon(new ImageIcon("Exit1.png").getImage().getScaledInstance(-1, btnExit.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnExit.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setIcon(new ImageIcon(new ImageIcon("Exit0.png").getImage().getScaledInstance(-1, btnExit.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnExit.setForeground(Color.WHITE);
			}
		});
		btnExit.setHorizontalAlignment(SwingConstants.LEFT);
		btnExit.setOpaque(false);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnExit.setFocusPainted(false);
		btnExit.setContentAreaFilled(false);
		btnExit.setBorderPainted(false);
		//btnA.setBounds(668,404,59,26);
		btnExit.setBounds((int)(980.0/1360.0*width+offsetx), (int)(670.0/765.0*height+offsety)-24, (int)(80.0/1360.0*width), (int)(40.0/765.0*height));
		btnExit.setIcon(new ImageIcon(new ImageIcon("Exit0.png").getImage().getScaledInstance(-1, btnExit.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		//System.out.println(btnA.getBounds());
		panel.add(btnExit);
		
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//help action listener
				panel_2.setVisible(true);
				panel.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHelp.setIcon(new ImageIcon(new ImageIcon("Help1.png").getImage().getScaledInstance(-1, btnHelp.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnHelp.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHelp.setIcon(new ImageIcon(new ImageIcon("Help0.png").getImage().getScaledInstance(-1, btnHelp.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnHelp.setForeground(Color.WHITE);
			}
		});
		btnHelp.setOpaque(false);
		btnHelp.setForeground(Color.WHITE);
		btnHelp.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnHelp.setFocusPainted(false);
		btnHelp.setContentAreaFilled(false);
		btnHelp.setBorderPainted(false);
		//btnHelp.setBounds(543, 404, 116, 26);
		btnHelp.setBounds((int)(800.0/1360.0*width+offsetx), (int)(670.0/765.0*height+offsety)-24, (int)(80.0/1360.0*width), (int)(40.0/765.0*height));
		btnHelp.setIcon(new ImageIcon(new ImageIcon("Help0.png").getImage().getScaledInstance(-1, btnHelp.getHeight(), java.awt.Image.SCALE_DEFAULT)));
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
				btnOptions.setIcon(new ImageIcon(new ImageIcon("Options1.png").getImage().getScaledInstance(-1, btnOptions.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnOptions.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnOptions.setIcon(new ImageIcon(new ImageIcon("Options0.png").getImage().getScaledInstance(-1, btnOptions.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnOptions.setForeground(Color.WHITE);
			}
		});
		btnOptions.setOpaque(false);
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnOptions.setFocusPainted(false);
		btnOptions.setContentAreaFilled(false);
		btnOptions.setBorderPainted(false);
		//btnOptions.setBounds(441, 404, 92, 26);
		btnOptions.setBounds((int)(600.0/1360.0*width+offsetx), (int)(670.0/765.0*height+offsety)-24, (int)(120.0/1360.0*width), (int)(40.0/765.0*height));
		btnOptions.setIcon(new ImageIcon(new ImageIcon("Options0.png").getImage().getScaledInstance(-1, btnOptions.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel.add(btnOptions);
		
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//new game action listener
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewGame.setIcon(new ImageIcon(new ImageIcon("New-Game1.png").getImage().getScaledInstance(-1, btnNewGame.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnNewGame.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewGame.setIcon(new ImageIcon(new ImageIcon("New-Game0.png").getImage().getScaledInstance(-1, btnNewGame.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnNewGame.setForeground(Color.WHITE);
			}
		});
		btnNewGame.setOpaque(false);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnNewGame.setFocusPainted(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorderPainted(false);
		//btnNewGame.setBounds(315, 404, 116, 26);
		btnNewGame.setBounds((int)(400.0/1360.0*width+offsetx), (int)(670.0/765.0*height+offsety)-24, (int)(140.0/1360.0*width), (int)(40.0/765.0*height));
		btnNewGame.setIcon(new ImageIcon(new ImageIcon("New-Game0.png").getImage().getScaledInstance(-1, btnNewGame.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel.add(btnNewGame);
		
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Continue game action listener
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//btnContinue.setForeground(Color.CYAN);
				btnContinue.setIcon(new ImageIcon(new ImageIcon("Continue1.png").getImage().getScaledInstance(-1, btnContinue.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//btnContinue.setForeground(Color.WHITE);
				btnContinue.setIcon(new ImageIcon(new ImageIcon("Continue0.png").getImage().getScaledInstance(-1, btnContinue.getHeight(), java.awt.Image.SCALE_DEFAULT)));
			}
		});
		btnContinue.setOpaque(false);
		btnContinue.setForeground(Color.WHITE);
		//btnContinue.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnContinue.setFocusPainted(false);
		btnContinue.setContentAreaFilled(false);
		btnContinue.setBorderPainted(false);
		//btnContinue.setBounds(50, 670, 120, 40);
		btnContinue.setBounds((int)(50.0/1360.0*width+offsetx), (int)(670.0/765.0*height+offsety)-24, (int)(120.0/1360.0*width), (int)(40.0/765.0*height));
		btnContinue.setIcon(new ImageIcon(new ImageIcon("Continue0.png").getImage().getScaledInstance(-1, btnContinue.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel.add(btnContinue);
		EasterEgg.setOpaque(true);
		EasterEgg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				x++;
				if (x==10)
				{
					EasterEgg.setIcon(new ImageIcon(new ImageIcon("sao_lost_song_logo_2_by_gunsli.png").getImage().getScaledInstance(-1, EasterEgg.getHeight(), java.awt.Image.SCALE_DEFAULT)));
					EasterEgg.removeMouseListener(this);
				}
			}
		});		
		//EasterEgg.setBounds(180, 60, 50, 50);
		EasterEgg.setBounds((int)(160.0/1360.0*width+offsetx), (int)(95.0/765.0*height+offsety)-24, (int)(80.0/1360.0*width), (int)(80.0/765.0*height));
		EasterEgg.setBackground(new Color(0x05040b));
		panel.add(EasterEgg);
	
		Title.setIcon(new ImageIcon(new ImageIcon("FinTitle.png").getImage().getScaledInstance(-1, (int)(330.0/765.0*height), java.awt.Image.SCALE_DEFAULT)));
		//lblNewLabel_1.setBounds(22, -13, 304, 285);
		Title.setBounds((int)(22.0/832.0*width+offsetx), (int)(11.0/468.0*height+offsety)-24, (int)(304.0/832.0*width), (int)(285.0/468.0*height));
		panel.add(Title);
		
		Background.setIcon(new ImageIcon(new ImageIcon("ezgif.com-crop.gif").getImage().getScaledInstance(-1, (int)height, java.awt.Image.SCALE_DEFAULT)));
		//lblNewLabel.setBounds(0, -15, 1014, 497);
		Background.setBounds((int)(00.0/832.0*width+offsetx), (int)(0.0/468.0*height+offsety)-24, (int)(1014.0/832.0*width), (int)(497.0/468.0*height));
		panel.add(Background);
		//Panel 1		
		contentPane.add(panel_1, "name_1431079614477");
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0x05040b));
		
		btnMainMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Panel 1 (options menu) main Menu button action listener
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMainMenu.setIcon(new ImageIcon(new ImageIcon("Main-Menu1.png").getImage().getScaledInstance(-1, btnMainMenu.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnMainMenu.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMainMenu.setIcon(new ImageIcon(new ImageIcon("Main-Menu0.png").getImage().getScaledInstance(-1, btnMainMenu.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//btnMainMenu.setForeground(Color.WHITE);
			}
		});
		btnMainMenu.setOpaque(false);
		btnMainMenu.setForeground(Color.WHITE);
		btnMainMenu.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		btnMainMenu.setFocusPainted(false);
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorderPainted(false);
		//btnMainMenu.setBounds(10, 11, 116, 26);		
		btnMainMenu.setBounds((int)(30.0/832.0*width+offsetx), (int)(30.0/468.0*height+offsety)-24, (int)(116.0/832.0*width), (int)(26.0/468.0*height));
		btnMainMenu.setIcon(new ImageIcon(new ImageIcon("Main-Menu0.png").getImage().getScaledInstance(-1, btnMainMenu.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel_1.add(btnMainMenu);

		label.setIcon(new ImageIcon(new ImageIcon("ezgif.com-crop.gif").getImage().getScaledInstance(-1, (int)height, java.awt.Image.SCALE_DEFAULT)));
		//label.setBounds(0, 0, 1014, 497);
		label.setBounds((int)(00.0/832.0*width+offsetx), (int)(0.0/468.0*height+offsety)-24, (int)(1014.0/832.0*width), (int)(497.0/468.0*height));
		panel_1.add(label);

		//Panel 2		
		contentPane.add(panel_2, "name_1576174767462");
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0x05040b));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Panel 2 (help main) main menu button action listener
				panel.setVisible(true);
				panel_2.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setIcon(new ImageIcon(new ImageIcon("Main-Menu1.png").getImage().getScaledInstance(-1, button.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//button.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button.setIcon(new ImageIcon(new ImageIcon("Main-Menu0.png").getImage().getScaledInstance(-1, button.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//button.setForeground(Color.WHITE);
			}
		});


		button.setOpaque(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		//button.setBounds(10, 11, 116, 26);
		button.setBounds((int)(30.0/832.0*width+offsetx), (int)(30.0/468.0*height+offsety)-24, (int)(116.0/832.0*width), (int)(26.0/468.0*height));
		button.setIcon(new ImageIcon(new ImageIcon("Main-Menu0.png").getImage().getScaledInstance(-1, button.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel_2.add(button);

		label_1.setIcon(new ImageIcon(new ImageIcon("ezgif.com-crop.gif").getImage().getScaledInstance(-1, (int)height, java.awt.Image.SCALE_DEFAULT)));
		label_1.setBounds((int)(0.0/832.0*width+offsetx), (int)(0.0/468.0*height+offsety)-24, (int)(1014.0/832.0*width), (int)(497.0/468.0*height));
		//label_1.setBounds(0, 0, 1014, 497);
		panel_2.add(label_1);
		contentPane.add(panel_3, "name_1583552623428");
		
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0x05040b));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(true);
				panel_3.setVisible(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				button_1.setIcon(new ImageIcon(new ImageIcon("I-Agree1.png").getImage().getScaledInstance(-1, button_1.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//button_1.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_1.setIcon(new ImageIcon(new ImageIcon("I-Agree0.png").getImage().getScaledInstance(-1, button_1.getHeight(), java.awt.Image.SCALE_DEFAULT)));
				//button_1.setForeground(Color.WHITE);
			}

		});
		button_1.setOpaque(false);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Sakkal Majalla", Font.PLAIN, 20));
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		//button_1.setBounds(10, 11, 116, 26);
		button_1.setBounds((int)(580.0/1360.0*width+offsetx), (int)(470.0/765.0*height+offsety)-24, (int)(200.0/1360.0*width), (int)(80.0/765.0*height));
		button_1.setIcon(new ImageIcon(new ImageIcon("I-Agree0.png").getImage().getScaledInstance(-1, button_1.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel_3.add(button_1);
		
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setFont(new Font("Sakkal Majalla", Font.PLAIN, 65));
		//lblNewLabel_4.setBounds(184, 166, 502, 90);
		lblMessage.setBounds((int)(66.0/832.0*width+offsetx), (int)(166.0/468.0*height+offsety)-24, (int)(700.0/832.0*width), (int)(90.0/468.0*height));
		lblMessage.setIcon(new ImageIcon(new ImageIcon("Message.png").getImage().getScaledInstance(-1, lblMessage.getHeight(), java.awt.Image.SCALE_DEFAULT)));
		panel_3.add(lblMessage);

		label_2.setIcon(new ImageIcon(new ImageIcon("ezgif.com-crop.gif").getImage().getScaledInstance(-1, (int)height, java.awt.Image.SCALE_DEFAULT)));
		//label_2.setBounds(0, 0, 1014, 497);
		label_2.setBounds((int)(0.0/832.0*width+offsetx), (int)(0.0/468.0*height+offsety)-24, (int)(1014.0/832.0*width), (int)(497.0/468.0*height));
		panel_3.add(label_2);
		
		btnNewGame.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				OverworldEngine.go();
			}
			
			
		});
	}
}
