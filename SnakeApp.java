
import java.awt.*;

import javax.swing.*;

public class SnakeApp {
			
	 public static void main(String[] args) {
		 	Grid grid = new Grid();
		 	 JFrame window = new JFrame("SnakeGame");
			   GamePanel gamepanel = new GamePanel (grid);
			   Container contentPane = window.getContentPane(); 
			   
			   
			   window.setBackground(Color.white);
			   window.add(gamepanel);                                       
			   Dimension Dim = new Dimension(Settings.DEFAULT_GRID_WIDTH , Settings.DEFAULT_GRID_HEIGHT);
			   
			   contentPane.setPreferredSize(Dim);
			   gamepanel.setPreferredSize(Dim);
			   window.pack();
		       window.setResizable(false);
		       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       window.setVisible(true);
			 
	
			  
			    
			 
		    
	    }
}
