import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class OpponentPanel extends Panel {

	private static final long serialVersionUID = -991861669659832835L;

	private PlayerPanel _player;

    public OpponentPanel(PlayerPanel player) {
    	_player = player;
    	System.out.println(fieldCells.size());
    	
    }

    protected boolean intoField(int x, int y){
    	if ((x >= 30 && x <= 330) && (y >= 30 && y <= 330)){
    		return true;
    	} 
    	return false;
    }


    protected int getAbsoluteCell(int point){
    	int cellAbsolute = (point - 30) / 30;
    	int r = (point - 30) % 30;
    	
    	if (r != 0){
    		return cellAbsolute += 1;
    	}else{
    		return cellAbsolute;
    	}
    }
    
    @Override
    protected void handleMouseClick(MouseEvent e) {
    	System.out.println("Opponent: ");
    	super.handleMouseClick(e);
    	super.player.fieldDraw();

    	
    	if (this.intoField(super.mouseX, super.mouseY) && super.gameOver == false){
    		int x = this.getAbsoluteCell(super.mouseX);
    		int y = this.getAbsoluteCell(super.mouseY);
    		
    		int absCell = x-1 + y*10-10;	//	number in an array "fieldCells"
    		
	    	System.out.println(absCell+" "+this.getAbsoluteCell(super.mouseX)+" "+this.getAbsoluteCell(super.mouseY));
	    	
	    	if(!fieldCells.get(absCell).getHit()){	// if the field wasn't still shot
	    		
		    	fieldCells.get(absCell).setHit();
				super.player.setShotCell(absCell%10,absCell/10);
		    	this.goDrawing(getGraphics());	    		
		    
		    	if (fieldCells.get(absCell).insideShip() == false){
		    		System.out.println("Computer shot:");
		    		
		    		_player.shotMe(false);
		    	}	  	
	    	}
    	}
    	if(super.player.getShipsAlive() == true){
    		System.out.println("ALIVE!!!!!!!!!!!!!!!!");
    	}
    	if(super.player.getShipsAlive() == false){
    		super.gameOver = true;
    		super.endOfTheGame(getGraphics(),true);
    	}
    }
        
    @Override
    public void goDrawing(Graphics g) {
    	super.goDrawing(g);
    	for (int i = 0; i < this.fieldCells.size(); i++){
			fieldCells.get(i).drawOpponentCell((Graphics2D)g);
		}
    }
}
