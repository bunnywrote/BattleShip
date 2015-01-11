import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class BattleFieldCell {
	private int			x = 1;
	private int 		y = 1;
	private int			cellSize = 30;
	private Rectangle 	cell;
	private boolean 	ship = false;
	private boolean		hit  = false;
	
	public BattleFieldCell(int newX, int newY, int indexX, int indexY, boolean ship, boolean hit){
		this.x = newX;
		this.y = newY;
		if (ship && hit == false){
			this.cell = new Rectangle (x+(cellSize*indexX), y+(cellSize*indexY), cellSize, cellSize);		
			this.ship = true;
		} else if (ship && hit) {
			this.cell = new Rectangle (x+(cellSize*indexX), y+(cellSize*indexY), cellSize, cellSize);		
			this.ship = true;
			this.hit = true;
		} else if (ship == false && hit) {
			this.cell = new Rectangle (x+(cellSize*indexX), y+(cellSize*indexY), cellSize, cellSize);		
			this.hit = true;
		} else{
			this.cell = new Rectangle (x+(cellSize*indexX), y+(cellSize*indexY), cellSize, cellSize);		
		}
	}
/*	
	public BattleFieldCell(int newX, int newY, int indexX, int indexY, int maxSize, boolean ship, boolean hit){
		x = newX;
		y = newY;
		if (ship && hit == false){
			this.cell = new Rectangle (x+(maxSize/10*indexX), y+(maxSize/10*indexY), maxSize/10, maxSize/10);		
			this.ship = true;
		} else if (ship && hit) {
			this.cell = new Rectangle (x+(maxSize/10*indexX), y+(maxSize/10*indexY), maxSize/10, maxSize/10);		
			this.ship = true;
			this.hit = true;
		} else if (ship == false && hit) {
			this.cell = new Rectangle (x+(maxSize/10*indexX), y+(maxSize/10*indexY), maxSize/10, maxSize/10);		
			this.hit = true;
		} else{
			this.cell = new Rectangle (x+(maxSize/10*indexX), y+(maxSize/10*indexY), maxSize/10, maxSize/10);		
		}
	}
*/
	
	public void drawPlayersCell(Graphics2D g2){
		if(this.ship == true && this.hit == true){
			g2.setColor(new Color(200, 10, 0));
			g2.fill(this.cell);			
		}else if(this.ship == true && this.hit == false){
			g2.setColor(new Color(0, 200, 10));
			g2.fill(this.cell);
		}else if (this.hit == true){
			g2.setColor(new Color(0, 10, 0));
			g2.fill(this.cell);
		}else{
			g2.setColor(new Color(34, 230, 209));
			g2.fill(this.cell);
		}
	}

	public void drawOpponentCell(Graphics2D g2){
		if(this.ship == true && this.hit == true){
			g2.setColor(new Color(200, 10, 0));
			g2.fill(this.cell);	
		}else if(this.hit == true){
			g2.setColor(new Color(0, 10, 0));
			g2.fill(this.cell);	
		}else{
			g2.setColor(new Color(0, 0, 0));
			g2.draw(this.cell);
		}
	}
	

	

	
	public void setHit(){
		this.hit = true;
	}
	
	public boolean getHit(){
		return this.hit;
	}
	
	public boolean insideShip(){
		return (this.ship == true) ? true : false;
	}

}
