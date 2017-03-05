import java.util.LinkedList;

public class Snake {
	
	private LinkedList<Node> body = new LinkedList<>();
	//获取蛇头的点
    public Node getHead() {
        return body.getFirst();
    }
    //将一个点加入蛇头
	public void addHead(Node area) {
	        this.body.addFirst(area);
	    }
	//将一个点加入蛇尾
	public Node addTail(Node area) {
        this.body.addLast(area);
        return area;
    }
	//获取贪吃蛇
    public LinkedList<Node> getBody() {
        return body;
    }
    public boolean did_i_ate_myself(){	
    	for(Node a:this.body){
    		if( Math.abs(a.getX() - this.getHead().getX()) < Settings.DEFAULT_NODE_SIZE &&
    			Math.abs(a.getY() - this.getHead().getY()) < Settings.DEFAULT_NODE_SIZE)
    			{
    				return true;    
    			}    		
    	}
    	return false;    	
	}
    public boolean did_i_hit_wall(){
    	
    		if( this.getHead().getX()<0||this.getHead().getX()>Settings.DEFAULT_GRID_WIDTH ||
    			this.getHead().getY()<0||this.getHead().getY()>Settings.DEFAULT_GRID_HEIGHT)
    			{
    				return true;    
    			}    			
    	return false;    	  	
    }
    
	public Node Move(Direction direction){
		int a;
		Node newhead;
		switch (direction){
		
		case UP:
			a = (this.getHead().getY())+Settings.DEFAULT_NODE_SIZE ;
			newhead = new Node(this.getHead().getX(),a);
			this.addHead(newhead);
			body.removeLast();
			break;
		
		case DOWN:
			a = (this.getHead().getY())-Settings.DEFAULT_NODE_SIZE ;
			newhead = new Node(this.getHead().getX(),a);
			this.addHead(newhead);
			body.removeLast();
			break;
		
		case LEFT:
			a = (this.getHead().getX())-Settings.DEFAULT_NODE_SIZE ;
			newhead = new Node(a,this.getHead().getY());
			this.addHead(newhead);			
			body.removeLast();
			break;
		
		case RIGHT:
			a = (this.getHead().getX())+Settings.DEFAULT_NODE_SIZE ;
			newhead = new Node(a,this.getHead().getY());
			this.addHead(newhead);
			body.removeLast();
			break;	
		}	
		return this.body.getLast();
	}	
	
}
