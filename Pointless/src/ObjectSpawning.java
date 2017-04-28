import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ObjectSpawning extends JFrame {

	private JPanel contentPane;
	int x =0;
	int y =0;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObjectSpawning frame = new ObjectSpawning();
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

	public ObjectSpawning() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_2055773597395");
		panel.setLayout(null);
		
		for (int z= 0; z < 10; z++)
		{		
			x = (int) (Math.random() * getWidth() - 61);
			y = (int) (Math.random() * getHeight() - 124);	
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("G:\\Pictures\\206e99ea4b999a70192c577634c977.png"));
		    lblNewLabel.setBounds(x, y, 61, 124);
		    panel.add(lblNewLabel);
		    //JLabel lblNewLabel1 = new JLabel("");
		   // lblNewLabel1.setIcon(new ImageIcon("G:\\Pictures\\206e99ea4b999a70192c577634c977.png"));
		    //lblNewLabel1.setBounds(x, y, 61, 124);
		   // panel.add(lblNewLabel1);
		    
		    //panel.add(new RandomObj);
       
	}
	}
}
