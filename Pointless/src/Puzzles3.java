import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.pointless.journey.window.Window;

public class Puzzles3 extends JFrame {

	private JPanel contentPane;
	private JTextPane txtpnAnOldMan;
	private JButton btnAxeAndHammer;
	private JButton btnMatchsticksAndCandles;
	private JButton btnWaterBottles;
	private static Puzzles3 frame;

	/**
	 * Launch the application.
	 */
	public static void Begin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Puzzles3();
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
	public Puzzles3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTextPane txtpnAnOldMan = new JTextPane();
		txtpnAnOldMan.setText("An old man was dying and so he called his three sons. He gave them equal money and ask them to buy something that can fill their living room entirely. He told them that he will give all his money and property to the son who is able to do this task as asked. The first son buys sticks and tries to fill the room but he falls short of sticks. The second son buys straw but he also falls short of filling the room. The third son buys only two things and he is able to fill the room completely and thus earns all the property and money. What did he buy?");
		txtpnAnOldMan.setEditable(false);
		txtpnAnOldMan.setBounds(38, 11, 355, 149);
		contentPane.add(txtpnAnOldMan);

		final JButton btnAxeAndHammer = new JButton("Axe and Hammer");
		btnAxeAndHammer.setBounds(107, 171, 226, 23);
		contentPane.add(btnAxeAndHammer);

		final JButton btnMatchsticksAndCandles = new JButton("Matchsticks and Candles");
		btnMatchsticksAndCandles.setBounds(107, 193, 226, 23);
		contentPane.add(btnMatchsticksAndCandles);

		final JButton btnWaterBottles = new JButton("Guns and Bullets");
		btnWaterBottles.setBounds(107, 214, 226, 23);
		contentPane.add(btnWaterBottles);

		btnAxeAndHammer.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Incorrect");
				btnMatchsticksAndCandles.setEnabled(false);
				btnWaterBottles.setEnabled(false);
			}
		}
				);

		btnMatchsticksAndCandles.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Correct");
				btnAxeAndHammer.setEnabled(false);
				btnWaterBottles.setEnabled(false);
				Window.paused=false;
				frame.setVisible(false);
			}
		}
				);
		btnWaterBottles.addActionListener (new ActionListener ()
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.print("Incorrect");
				btnAxeAndHammer.setEnabled(false);
				btnMatchsticksAndCandles.setEnabled(false);
			}
		}
				);



	}
}
