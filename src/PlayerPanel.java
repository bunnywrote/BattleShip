import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerPanel extends Panel {
	
	private static final long serialVersionUID = 6530162287721447393L;
	Computer _computer = new Computer();

	public PlayerPanel() {
	}

	
	public void shotMe(boolean followShot){
		try {
		    Thread.sleep(300);                 // 300 milliseconds delay
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		if (super.gameOver == false){
//		if(1 != 1){
			int[] shot;
			if (followShot){ 
				shot = _computer.computerShot(true); // shot with AI			
			}else{
				shot = _computer.computerShot(false);// Random shot			
			}
			//			Computer.getShotsArr();
			int x = shot[0];
			int y = shot[1];
			
			int absCell = (y == 0) ? x : y*10 + x;
			
			System.out.println(absCell+"="+x+"--"+y);
			
			fieldCells.get(absCell).setHit();
			super.player.setShotCell(x,y);
			this.goDrawing(getGraphics());
			if (fieldCells.get(absCell).insideShip()){

				this.shotMe(true);
			}
		}else{
			super.endOfTheGame(getGraphics(),false);
		}
		if(super.player.getShipsAlive() == false){
			super.gameOver = true;
			super.endOfTheGame(getGraphics(), false);
		}
	}
	

	
	
	@Override
	public void goDrawing(Graphics g) {
		super.goDrawing(g);
		for (int i = 0; i < this.fieldCells.size(); i++){
			fieldCells.get(i).drawPlayersCell((Graphics2D)g);
		}
	}
	
}
