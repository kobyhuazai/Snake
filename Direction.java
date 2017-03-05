
public enum Direction {
	UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

	// 成员变量
    private final int directionCode;
    
    // 成员方法
    public int directionCode() {
        return directionCode;
    }
    
    public boolean compatibleWith (Direction direction){
    	if(this.directionCode != direction.directionCode){
    		return true;
    	}  
    	return false;
    }
	// 构造函数
    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
    
}
