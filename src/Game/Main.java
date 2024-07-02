package Game;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	private static Scanner play;
	
	public static void main(String[] args) {
		play=new Scanner(System.in);
			SwingUtilities.invokeLater(() -> {
			
            CultGame game = new CultGame();
            JFrame frame = new JFrame("Cult Game");
    		frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(game);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            game.chooseTheme();
            frame.pack();


            
			});
		
		
	}

}
