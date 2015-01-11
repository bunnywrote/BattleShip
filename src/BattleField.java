import java.awt.Point;
//import java.awt.geom.Point2D;
//import java.util.Arrays;
import java.util.ArrayList;


public class BattleField {
	final int MAXSIZE = 10;
	final int MAXSHIPSIZE = 4;
	ArrayList<Ship> ships = new ArrayList<Ship>();
	int[][] field = new int[MAXSIZE][MAXSIZE]; 
	
	public BattleField(){
		for (int i = 0; i < MAXSIZE; i++){
			for (int j = 0; j < MAXSIZE; j++){
				field[i][j] = -1;
			}
		}	
	}
	
	/*
	 * 		set ships on the field
	 */
	public void setShips(){
		int shipId = 1;
		for (int i = 1; i <= MAXSHIPSIZE; i++){
			int length = MAXSHIPSIZE - i + 1;
			int shipsCount = MAXSHIPSIZE - length + 1;
			
			for (int count = 1; count <= shipsCount; count++){ 
				boolean fits = false;
				while(!fits){
					Point p = randPoint();
					Point dir = randDirection();
					Ship testShip = new Ship(length);
					int[][] tsfield = new int[MAXSIZE][MAXSIZE];
					
					if (this.isTaken(p.x, p.y) == false){
						int switcher = 0;
						for (int ts = 0; ts < length; ts++){
							if (ts==0){
								testShip.setPoint(ts, p.x, p.y);
								tsfield[p.x][p.y] = shipId;
							}else{
								int x = p.x + ts * dir.x;
								int y = p.y + ts * dir.y;
								
								if ((x < 0 || y < 0) || (x == 0 && y == 0) || (x >= 10 || y >= 10) || (this.isTaken(x, y) == true)){		
									switcher++;
									continue;
								}else{
									tsfield[x][y] = shipId;
									testShip.setPoint(ts, x, y);
								}
							}
						}	
						fits = switcher > 0 ? false : true;
						
					
						if (fits == true){
							shipId++;
							for (int xKey = 0; xKey < MAXSIZE; xKey++){
								for (int yKey = 0; yKey < MAXSIZE; yKey++){
									
									if (field[xKey][yKey] < 0 && tsfield[xKey][yKey] > 0){
										field[xKey][yKey] = tsfield[xKey][yKey];
									}
								}
							}
							
							this.setRegionOfShip(field);
							ships.add(testShip);
							testShip.drawShip();
						}
					}
				}
			}
		}
	}
	
	public boolean getShipsAlive(){
		for (int i = 0; i < MAXSIZE; i++){
			for (int j = 0; j < MAXSIZE; j++){
				if ( this.field[i][j] > 0 && this.field[i][j] < 69){
					return true;
				}
			}
		}
		return false;
	}
	
	public int[][] getField(){
		return this.field;
	}
	
	/*
	 * 		Return id of ship at battleField
	 */
	public int getShipId(int x, int y){
		return this.field[x][y]-1;
	}
	
	/*
	 * 		Shooting
	 */
	public boolean shootCell(int x, int y){
		if (this.field[x][y] > 0 && this.field[x][y] != 69){			// if it's point of a ship
			System.out.println(this.field[x][y]+"\n");
			this.ships.get(this.field[x][y]-1).setPointSunk(x, y);		
			
			System.out.println("ship health: "+this.ships.get(this.field[x][y]-1).getHealth());		
			
			return true;
		}
		System.out.println(this.field[x][y]+"\n");

		return false;
	}
	
	/*
	 *      Set new value into cell after shot
	 */
	public void setShotCell(int x, int y){
		this.field[x][y] = 69;
	}
	
	/*
	 * 		draw battlefield in console
	 */
	public void drawBattleField(){
		for (int i = 0; i < ships.size(); i++){
			ships.get(i).drawShip();
		}
	}
	
	/*
	 * 		set a region about a ships
	 */
	public int[][] setRegionOfShip(int[][] tsfield){
		for (int xKey = 0; xKey < MAXSIZE; xKey++){
			for (int yKey = 0; yKey < MAXSIZE; yKey++){
				
				if (tsfield[xKey][yKey] > 0){
					if (isTaken(xKey-1, yKey) == false ) 
						tsfield[xKey-1][yKey] = 0;
										
					if (isTaken(xKey, yKey-1) == false  )
						tsfield[xKey][yKey-1] = 0;
					
					if (isTaken(xKey+1, yKey) == false  )
						tsfield[xKey+1][yKey] = 0;						
					
					if (isTaken(xKey, yKey+1) == false  )					
						tsfield[xKey][yKey+1] = 0;

					if (isTaken(xKey-1, yKey-1) == false )
						tsfield[xKey-1][yKey-1] = 0;
					
					if (isTaken(xKey+1, yKey+1) == false  )
						tsfield[xKey+1][yKey+1] = 0;
					
					if (isTaken(xKey-1, yKey+1) == false  )
						tsfield[xKey-1][yKey+1] = 0;

					if (outOfField(xKey+1, yKey-1) == false  )
						tsfield[xKey+1][yKey-1] = 0;
				}
			}
			
		}
		return tsfield;
	}
	
	
	/*
	 * 		check if new coordinates belong to the field
	 */
	private boolean outOfField(int x, int y){
		if ((x >= 0 && x <= 9) && (y >= 0 && y <= 9)){
			return false;
		}
		return true;
	}
	
	/*
	 * 		check if a cell was taken
	 * 
	 */
	public boolean isTaken(int x, int y){
		if (outOfField(x, y) == false){
			if (this.field[x][y] >= 0)
				return true;
			else 
				return false;
		}else{
			return true;
		}
	}
	
	public Point randPoint() {
		return new Point((int)(Math.random()*MAXSIZE), (int)(Math.random()*MAXSIZE));
	}
	
	public Point randDirection() {
		int x = (int)(Math.random()*3) - 1;
		int y = 0;
		if (x == 0) 
			y = Math.random()<0.5 ? -1 : 1;
		return new Point(x, y);
	}
	
	/*
	 * 		print in console the field with ships
	 */
	public  void fieldDraw(){

		String topBoard = " +---+---+---+---+---+---+---+---+---+---+";
		String[] boardLetters = {"0","1","2","3","4","5","6","7","8","9"};
		int length = this.field.length; 
		
		/*
		 * 		print first line of numbers
		 */
		for (int i = 0; i < length; i++){
			if(i == length-1){
				System.out.println("   "+i);
			}else{
				System.out.print("   "+i);
			}
		}

		for (int ch = 0; ch < field.length; ch++){
			System.out.println(topBoard);

			for (int i = 1; i < length; i++){
				if (i == 1){
					System.out.print(boardLetters[ch]+"|");
					for (int j = 0; j < length; j++){
						if(j == 9){
							String cell = " ";
							if (this.field[j][ch] == 0)
								cell = "   |";
							else
								cell = this.field[j][ch] > 0 ? "#"+this.field[j][ch]+"#|" : " "+this.field[j][ch]+"|";
							System.out.println(cell);
						}else{
							String cell = " ";
							if (this.field[j][ch] == 0)
								cell = "   |";
							else
								cell = this.field[j][ch] > 0 ? "#"+this.field[j][ch]+"#|" : " "+this.field[j][ch]+"|";
							System.out.print(cell);						
						}
					}
				}	
			}
		}
		System.out.println(topBoard);

	}
////	
//	public String toString(){
//		String values = "";
//		for(int ch = 0; ch < this.field.length; ch++){
//			for (int i = 0; i < this.field.length; i++){
//				values += "["+this.field[ch][i]+"]";
//			}
//		}
//		return values;
//	}	
}
