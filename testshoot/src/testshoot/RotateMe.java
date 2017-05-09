package testshoot;

import javax.swing.JFrame;

public class RotateMe extends JFrame {

   public static final int WIDTH = 800, HEIGHT = 600;

   public RotateMe() {

      add(new Board());

      setTitle("Pointless");
      setSize(WIDTH, HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(true);
      setVisible(true);

   }

   public static void main(String[] args) {
	   
      new RotateMe();

   }

}