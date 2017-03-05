
public class Grid {
 
    private Snake snake;
    private Node food;
  
    //默认初始方向为左
    private Direction snakeDirection = Direction.LEFT;
    
    public Grid() {

    	 
     
    	   initSnake();
    	   createFood(); 
    }
    
    private Snake initSnake() {
    	   snake = new Snake();

    	   snake.addHead(new Node(Settings.DEFAULT_GRID_WIDTH/2,Settings.DEFAULT_GRID_HEIGHT/2));// 设置Snake的Body
    	   

    	   return snake;
    	}
    
    public Node createFood() {
        int x, y;
        x = (int )(Math.random() * (Settings.DEFAULT_GRID_WIDTH));
		y = (int )(Math.random() * (Settings.DEFAULT_GRID_HEIGHT));          // 使用Random设置x和y
        this.food = new Node(x, y);
        return food;
    }
    
   
    public Snake getSnake(){
    	return snake;
    }
    public Node getFood(){
    	return food;
    }
    public Direction getDirection(){
    	return snakeDirection;
    }
    public void changeDirection(Direction newDirection) {
        if (snakeDirection.compatibleWith(newDirection)) {
            snakeDirection = newDirection;
        }
    }
}


