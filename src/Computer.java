import java.awt.Point;


public class Computer {
	final static  int MAXSIZE = 10;
	final static  int MISS = 100;
	  int[][] stackShots = new int[10][10]; 
	  int counter = 0;
	  int[] lShot = new int[2];
	  int[] lLuckyShot = {101, 101};
	  int[] nextShots = new int[6];
	
	
	public   int[] computerShot(boolean luckyShot){
		if (luckyShot){
			System.out.println("lucky");
			lLuckyShot[0] = lShot[0];
			lLuckyShot[1] = lShot[1];
		}
		
		int newX = MISS;
		int newY = MISS;
		
		if (lLuckyShot[0] >= MISS && lLuckyShot[1] >= MISS){
			System.out.println("randomShot");

			int[] randomCoordinate = randomShot();
			
			newX = randomCoordinate[0];
			newY = randomCoordinate[1];
		}else{			
			System.out.println("followShot");

			boolean choseCoordinate = false;
			int[] newCoordinate = shotGenerate();
			int counter = 0;		
			
			for (int i = 0; i < newCoordinate.length-1; i += 2){
				newX = newCoordinate[i];
				newY = newCoordinate[i+1];
				
				System.out.println("new Coord: ("+i+":"+(i+1)+")"+newX+":"+newY);
				counter ++;
				
				System.out.println("Counter : "+counter);
				if(newX != MISS){
					if(stackShots[newX][newY] == 0){
//					stackShots[newX][newY] = 1;
						choseCoordinate = true;
						break;
					}					
				}
			}
			
			if (choseCoordinate == false){
				int[] randomCoordinate = randomShot();
				
				newX = randomCoordinate[0];
				newY = randomCoordinate[1];
				lLuckyShot[0] = MISS;
				lLuckyShot[1] = MISS;
			}
		}
		
		lShot[0] = newX;
		lShot[1] = newY;
		stackShots[newX][newY] = 1;
		int[] arr = {newX, newY};
		System.out.println("shot coordinate"+arr[0]+":"+arr[1]);
		return arr;
	}
	
	private   int[] shotGenerate(){
		int x,y;
		int[] arr = new int[8];
		
		x = lLuckyShot[0];
		y = lLuckyShot[1];
		
		arr[0] = x + 1;
		arr[1] = y;
		arr[2] = x - 1;
		arr[3] = y;
		arr[4] = x;
		arr[5] = y + 1;
		arr[6] = x;
		arr[7] = y - 1;
		
		if (x == 0){
			arr[2] = MISS;
			arr[3] = MISS;
		}
		if (x == 9){
			arr[0] = MISS;
			arr[1] = MISS;
		}
		if (y == 0){
			arr[6] = MISS;
			arr[7] = MISS;
		}
		if (y == 9){
			arr[4] = MISS;
			arr[5] = MISS;
		}
		
		return arr;

	}
	
	private   int[] randomShot(){
		int[] arr = new int[2];
		
		do{
			arr[0] = (int)(Math.random()*MAXSIZE); // new x value
			arr[1] = (int)(Math.random()*MAXSIZE); // new y value
			
		}while(stackShots[arr[0]][arr[1]] == 1);	
		
		return arr;
	}
		
	public   void getShotsArr(){
		String str = "";
		
		for (int i = 0; i < MAXSIZE; i++){
			for (int j = 0; j < MAXSIZE; j++){
				if (stackShots[i][j] > 0){
					str = "["+i+":"+j+"] :"+stackShots[i][j];
					System.out.println(str);;
				}
			}
		}
	}
	
	  Point randShotDirection() {
		int x = (int)(Math.random()*3) - 1;
		int y = 0;
		if (x == 0) 
			y = Math.random()<0.5 ? -1 : 1;
		return new Point(x, y);
	}
	
//	public   int[] shotGenerator(){
//		int x = 0;
//		int y = 0;
//		do{
//			y = (int)(Math.random()*MAXSIZE);
//			x = (int)(Math.random()*MAXSIZE);
//			
//		}while(stackShots[x][y] == 1);
//		
//		int[] shotCell = {x, y};
//		stackShots[x][y] = 1;
//		lShot[0] = x;
//		lShot[1] = y;
//		counter++;
//		
//        return shotCell;
//	}
}
