import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import java.awt.event.*;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class  GamePanel extends JPanel implements ActionListener{
	
	private boolean running;
	private Grid grid;
	
	public void paint(Graphics win){
	
	super.paint(win);
	
	Graphics2D g2 =(Graphics2D) win;
	
	
		
	if( running ){
		this.drawSnake(g2,grid.getSnake());
		this.drawFood(g2, grid.getFood());
	}
	// 防止图像闪烁的一行代码
	Toolkit.getDefaultToolkit().sync();
	
 	win.dispose();
}
	
	public GamePanel(Grid grid){
		
		
		this.grid = grid;
		
		this.setFocusable(true);

    	this.addKeyListener(new KeyBoardAgent());
    	
    	Timer timer = new Timer(50, this);
        timer.start();
		
	}
	
	 private class KeyBoardAgent extends KeyAdapter {
	        public void keyReleased(KeyEvent e) {}
	        public void keyPressed(KeyEvent e) {
	        	int key = (e.getKeyCode());
	    		if( key == KeyEvent.VK_LEFT ){
	    			grid.changeDirection(Direction.LEFT);
	    		}
	    		if( key == KeyEvent.VK_DOWN ){
	    			grid.changeDirection(Direction.DOWN);
	    		}
	    		if( key == KeyEvent.VK_UP ){
	    			grid.changeDirection(Direction.UP);
	    		}
	    		if( key == KeyEvent.VK_RIGHT ){
	    			grid.changeDirection(Direction.RIGHT);
	    		}
	        }
	    }
	 public void actionPerformed(ActionEvent e) {
			// Calls the tick;
	    	while (running) {
	           
	            if(!this.nextRound()){
	            	break;
	            }
	        }
	        running = false;
	    }
	    public boolean nextRound() {
	    	
	    	Node deletedtail = this.grid.getSnake().Move(this.grid.getDirection());
	        if (!this.grid.getSnake().did_i_ate_myself() && !this.grid.getSnake().did_i_hit_wall()) {
	            if ( (this.grid.getSnake().getHead().getX() == this.grid.getFood().getX()) && 
	            	 (this.grid.getSnake().getHead().getY() == this.grid.getFood().getY())) {                
	            	this.grid.getSnake().addTail(deletedtail);
	                this.grid.createFood();          //创建一个新的食物
	            } 
	            this.repaint();             
	            return true;                  //alive
	        }  
	        return false;                    //dead
	    }
	    
	public void drawSnake(Graphics2D graphics, Snake snake) {
	    	for(Node a:snake.getBody()){
	    		graphics.drawRect(a.getX(),a.getY(), Settings.DEFAULT_NODE_SIZE , Settings.DEFAULT_NODE_SIZE );
	    	}
	    }

	    public void drawFood(Graphics2D graphics, Node squareArea) {
	    	graphics.drawOval(squareArea.getX(), squareArea.getY(), Settings.DEFAULT_NODE_SIZE, Settings.DEFAULT_NODE_SIZE );
	    }
}
