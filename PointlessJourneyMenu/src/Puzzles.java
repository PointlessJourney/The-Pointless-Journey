import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Puzzles extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblOpenDoor;
	private JButton btnYes;
	private JButton btnNo;
	private JButton btnEnter;
	private JLabel lblSolveThisWhat;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblPauseMenu;
	/**
	 * Launch the application.
	 */
	String ans="19";
	String ans2;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Puzzles frame = new Puzzles();
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
	public Puzzles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px]", "[14px][][][]"));

		final JLabel lblOpenDoor = new JLabel("Open door?");
		contentPane.add(lblOpenDoor, "cell 0 0,growx,aligny top");

		final JButton btnYes = new JButton("Yes");
		contentPane.add(btnYes, "flowx,cell 0 1");

		final JButton btnNo = new JButton("No");
		contentPane.add(btnNo, "cell 0 1");

		final JLabel lblSolveThisWhat = new JLabel("Solve this. What is the next number?");
		contentPane.add(lblSolveThisWhat, "cell 0 2");

		final JLabel label = new JLabel("5");
		contentPane.add(label, "flowx,cell 0 3");

		final JLabel label_1 = new JLabel("7");
		contentPane.add(label_1, "cell 0 3");

		final JLabel label_2 = new JLabel("11");
		contentPane.add(label_2, "cell 0 3");

		final JLabel label_3 = new JLabel("13");
		contentPane.add(label_3, "cell 0 3");

		final JLabel label_4 = new JLabel("17");
		contentPane.add(label_4, "cell 0 3");

		textField = new JTextField();
		contentPane.add(textField, "cell 0 3");
		textField.setColumns(10);

		final JLabel lblPauseMenu = new JLabel("Pause Menu");
		contentPane.add(lblPauseMenu, "cell 0 1");

		final JButton btnEnter = new JButton("Enter");
		contentPane.add(btnEnter, "cell 0 3");

		textField.setVisible(false);
		lblSolveThisWhat.setVisible(false);
		lblPauseMenu.setVisible(false);
		label.setVisible(false);
		label_1.setVisible(false);
		label_2.setVisible(false);
		label_3.setVisible(false);
		label_4.setVisible(false);
		btnEnter.setVisible(false);

		btnYes.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				btnYes.setVisible(false);
				btnNo.setVisible(false);
				lblOpenDoor.setVisible(false);
				textField.setVisible(true);
				lblSolveThisWhat.setVisible(true);
				label.setVisible(true);
				btnEnter.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
			}
		}
				);
		btnNo.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				lblPauseMenu.setVisible(true);
				btnYes.setVisible(false);
				btnNo.setVisible(false);
				lblOpenDoor.setVisible(false);
				textField.setVisible(false);
				lblSolveThisWhat.setVisible(false);
				label.setVisible(false);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				label_4.setVisible(false);
				System.out.println("What is answer?");
				ans2=textField.getText();
				if (ans2.equals(ans))
				{
					System.out.println("Correct");
				}
				else
				{
					System.out.println("Incorrect");
				}
			}
		}
				);
		btnEnter.addActionListener (new ActionListener () 
		{
			public void actionPerformed (ActionEvent e)
			{
				System.out.println("What is answer?");
				ans2=textField.getText();
				if (ans2.equals(ans))
				{
					System.out.println("Correct");
				}
				else
				{
					System.out.println("Incorrect");
				}
			}
		}
				);
	}

}
