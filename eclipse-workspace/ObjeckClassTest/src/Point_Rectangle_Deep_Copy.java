class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int x, int y) {
		this.xPos =x;
		this.yPos =y;
	}
	public void showPosition() {
		System.out.println("x : "+xPos+" y : "+yPos);
	}
	public void changPos(int x, int y) {
		xPos = y;
		yPos = x;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Rectangle implements Cloneable {
	Point upperLeft, lowerRight;
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new Point(x1,y1);
		lowerRight = new Point(x2,y2);
	}
	public void showPosition() {
		System.out.print("좌 상단 : ");
		upperLeft.showPosition();
		System.out.print("우 하단 : ");
		lowerRight.showPosition();
		System.out.print("\n");
	}
	public void changPos(int x1,int y1,int x2,int y2) {
		upperLeft.changPos(x1, y1);
		lowerRight.changPos(x2, y2);
	}
	public Object clone() throws CloneNotSupportedException {
		Rectangle copy = (Rectangle)super.clone();
		copy.upperLeft=(Point)upperLeft.clone();
		copy.lowerRight=(Point)lowerRight.clone();
		return copy;
	}
	
}
public class Point_Rectangle_Deep_Copy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle org = new Rectangle(1,1,9,9);
		Rectangle cpy;

		try {
			cpy=(Rectangle)org.clone();
			org.changPos(2, 2, 7, 7);
			org.showPosition();
			cpy.showPosition();
		}catch(CloneNotSupportedException e) {
			e.getStackTrace();
		}
		
	}

}
