
public enum Direction {
	UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

	// ��Ա����
    private final int directionCode;
    
    // ��Ա����
    public int directionCode() {
        return directionCode;
    }
    
    public boolean compatibleWith (Direction direction){
    	if(this.directionCode != direction.directionCode){
    		return true;
    	}  
    	return false;
    }
	// ���캯��
    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
    
}
