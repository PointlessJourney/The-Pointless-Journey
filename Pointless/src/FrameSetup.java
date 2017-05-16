import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class FrameSetup extends Canvas {

	private static final long serialVersionUID = -6499924088999628304L;

	public FrameSetup(int width, int height, String title, OverworldEngine game)
	{
		JFrame frame = new JFrame(title);
		
		frame.setUndecorated(true);

		frame.setPreferredSize(new Dimension (width, height));
		frame.setMaximumSize(new Dimension (width, height));
		frame.setMinimumSize(new Dimension (width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		BufferedImage cursorImg = LoadImage("crosshair.png");
		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");
		frame.getContentPane().setCursor(blankCursor);
		// Set the blank cursor to the JFrame.

		game.start();
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		
	}
	BufferedImage LoadImage(String FileName)
	{
		BufferedImage img = null;
		try
		{
			img = ImageIO.read(new File(FileName));
		}
		catch (IOException e)
		{
			
		}
		return img;
	}
}