//import java.util.Scanner;
//
//
//public class BattleFieldTest {
//
//	public static void main(String[] args){
//		BattleField playerField = new BattleField();
//		BattleField computerField = new BattleField();
//		
//		playerField.setShips();
//		computerField.setShips();
//		
//		boolean game = true;
//		boolean player = true;
//		boolean computer = false;
//		int counter = 0;
//		
//		while(game == true){
//			counter++;
//			/*
//			 * 		Game lauft solang die Spieler schiffen im shipsArray haben,
//			 *  
//			 * 		d.h. wenn shipsArray.size() eines Spielers gleich 0 ist, hat der Spieler verloren
//			 * 
//			 * 		Regeln:
//			 * 		
//			 * 		1.Gegnerisches Field ist unsichtbar
//			 * 
//			 * 		2.Players schiessen nacheinander, aber ...
//			 * 
//			 * 			a). wenn ein gegnerische Shiff getroffen wird, schiesst der Player ausser der Reihe
//			 * 
//			 * 			
//			 */
//			
//			while (player == true){
//				System.out.println("PLAYER FIELD:\n\n");
//				playerField.fieldDraw();
//				System.out.println("COMPUTER FIELD:\n\n");
//				computerField.fieldDraw();
//				
//				Scanner in = new Scanner(System.in);
//				int x = in.nextInt();
//				
//				if (x >= 0){
//					
//					System.out.println("X = " + x+"\n Please give Y:\n");
//					
//					int y = in.nextInt();
//					if (y >= 0){
//						
//						if (computerField.shootCell(x, y) == true){
//							
//							System.out.println("Ship wurde getroffen, ship id: " + computerField.getShipId(x, y)+"\n");
//							
//						}else{
//
//							System.out.println("Kein ship wurde getroffen\n\n");
//							
//							player = false;
//							computer = true;
//						}
//						computerField.setShotCell(x, y);
//						if(computerField.getShipsAlive() == false){
//							computer = false;					
//							player = false;					
//							game = false;					
//						}
//
//					}
//	//				System.out.println("Player shot :" + x + " " + y +"\n\n");
//				}			
//				
//			}
////			System.out.println("\n");
//			//computerField.fieldDraw();
//			
//			while (computer == true){
//				int[] randomShot = Computer.shotGenerator();
//				int x = randomShot[0];
//				int y = randomShot[1];
//				
//				String values = "";
//				for(int i = 0; i < randomShot.length; i++){
//						values += "["+randomShot[i]+"]";
//				}
//				
//				System.out.println("random shot: "+values);
//				if (playerField.shootCell(x, y) == true){
//					
//					System.out.println("ship id: " + playerField.getShipId(x, y));
//					
//					if(playerField.getShipsAlive() == false){
//						game = false;					
//					}					
//				}else{
//					computer = false;
//					player = true;
//				}
//				System.out.println("counter: "+counter);
//				playerField.setShotCell(x, y);
//			}
//			
//			
//		}
//		
////		System.console().readLine();
////		
////		
////		Ship ship = new Ship(2);
////		ship.getShip();
////		System.out.print(playerField.toString());
//	}
//	
////	public String toString(){
////	String values = "";
////	for(int ch = 0; ch < this.field.length; ch++){
////		for (int i = 0; i < this.field.length; i++){
////			values += "["+this.field[ch][i]+"]";
////		}
////	}
////	return values;
////}	
//	
//	
//
//}
