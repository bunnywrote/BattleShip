
public class ShipPoint {
	private int x,y = 0;
	private boolean sunk = false;
	
	public ShipPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void drawShipPoint(){
		System.out.println(this.x+"=="+this.y);
	}
	
	public boolean getSunk(){
		return sunk;
	}
	
	public void setSunk(){
		this.sunk = true;
	}
	
}
