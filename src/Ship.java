import java.util.ArrayList;
import java.util.Random;


public class Ship {
	
	private ArrayList<ShipPoint> shipPoints = new ArrayList<ShipPoint>();
	
	
	public Ship(int size) {
		for (int i = 1; i <= size; i++){
			shipPoints.add(new ShipPoint(0, 0));
		}
	}
	
	public int getSize() {
		return shipPoints.size();
	}
	
	public int getHealth(){
		int health = 0;
		for (int i = 0; i < shipPoints.size(); i++){ 
			if (!shipPoints.get(i).getSunk())
				health++;
		}
		return health;
	}
	
	public void setPoint(int index, int x, int y){
		shipPoints.set(index, new ShipPoint(x,y));
	}
	
	public void setPointSunk(int x, int y){
		if (this.getPointSunk(x, y) == false) {
			for (int i = 0; i < this.shipPoints.size(); i++){
				if (this.shipPoints.get(i).getX() == x && this.shipPoints.get(i).getY() == y){
																							
					System.out.println("ship wurde getroffen\n");
					
					this.shipPoints.get(i).setSunk();
				}
			}
		}
		
	}
	
	public boolean getPointSunk(int x, int y){
		for (int i = 0; i < this.shipPoints.size(); i++){
			if (this.shipPoints.get(i).getX() == x && this.shipPoints.get(i).getY() == y){
				
				System.out.println("Sunk : @"+this.shipPoints.get(i).getSunk()+"@");
				
				return this.shipPoints.get(i).getSunk();
			}
		}
		return false;
	}
	
//	public int[][] getPoints(){
//		int[][] array = new int[10][10];
//		for (int i = 0; i < this.shipPoints.size(); i++){
//			//array[this.shipPoints.get(i).getX()][this.shipPoints.get(i).getY()] = this.getSize();
//			if (this.shipPoints.get(i).getX() == x && this.shipPoints.get(i).getY() == y){
//				
//			}
//			
//		}
//		return array;
//	}
	
	public void drawShip(){
		for (int i = 0; i < shipPoints.size(); i++){
			shipPoints.get(i).drawShipPoint();
		}
		System.out.println("lol");
	}

	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
