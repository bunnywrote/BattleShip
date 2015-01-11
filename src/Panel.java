import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Panel extends JPanel implements MouseListener,ComponentListener {

	private static final long serialVersionUID = -22858;
    
	BattleField player = new BattleField();
	ArrayList<BattleFieldCell> fieldCells = new ArrayList<BattleFieldCell>();
	int[][] field = new int[10][10];
	int mouseX;
	int mouseY;
	boolean gameOver = false;
	
	
	
	
	public Panel() {
		player.setShips();
		this.field = player.getField();
		
		this.addMouseListener(this);
		this.addComponentListener(this);
		/*
		 * 		Put the cells into fieldCells
		 */
		for (int y = 0; y < this.field.length; y++){
			for (int x = 0; x < this.field.length; x++){
			
				System.out.println(field[x][y]+":"+x+"-"+y);
				if(field[x][y] > 0 && field[x][y] < 69){
					fieldCells.add(new BattleFieldCell(0, 0, x+1,y+1, true, false));	// it's a ship
				}else if(field[x][y] == 69){
					fieldCells.add(new BattleFieldCell(0, 0, x+1,y+1, false, true));  // it's a hit cell 
				}else if(field[x][y] == 96){
					fieldCells.add(new BattleFieldCell(0, 0, x+1,y+1, true, true));  // it's a hit ship
				}else{
					fieldCells.add(new BattleFieldCell(0, 0, x+1,y+1, false, false));  // it's a see
				}
			
			}
		}
	

	}

   public void paintComponent(Graphics g){
	   this.goDrawing(g);
	   Graphics2D g2 = (Graphics2D) g;
	   this.drawSides(g2);
   } 
   
   public void getCell(int x, int y){
	   System.out.println(x+":"+y);
   }
   
   public void goDrawing(Graphics g){
	   
	   Graphics2D g2 = (Graphics2D) g;
   		g2.setRenderingHint(
			RenderingHints.KEY_ANTIALIASING, 
			RenderingHints.VALUE_ANTIALIAS_ON);
   }
   
   public void endOfTheGame(Graphics g, boolean won){
	   this.gameOver = true;
	   		String winner = (won) ? "Player" : "Computer";
	   		String picture = (won) ? "images/won.jpeg" : "images/defeated.jpeg";
	   		
			ImageIcon icon = new ImageIcon(getClass().getResource(picture));
			JOptionPane.showMessageDialog(null, "", "Congradulations!", JOptionPane.ERROR_MESSAGE, icon);
			System.exit(0);
		}

	public static void drawSides(Graphics2D g2){
		char [] top 	= { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
//		char [] top 	= { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char [] left 	= { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		int offsetX = 40;
	 	int offsetY = 50;
		 
 		g2.setColor(Color.BLACK);
		
 		for(int i = 0; i < 10; i++){ 
		   g2.drawChars(top, i, 1, offsetX, 20);
		   if (i == 9){
			   g2.drawChars(left, 0, 1, 10, offsetY);			   			   
			   g2.drawChars(left, i, 1, 15, offsetY);			   
		   }else{
			   g2.drawChars(left, i, 1, 15, offsetY);			   
		   }
		   offsetX += 30;
		   offsetY += 30;
		 }
	}
	
   
   	protected void handleMouseClick(MouseEvent e) {
   		this.mouseX = e.getX();
   		this.mouseY = e.getY();
   		
   	}
   	
   	
   	@Override
	public void mouseClicked(MouseEvent e) {
		this.handleMouseClick(e);
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
//		e.getComponent().getGraphics().clearRect(0, 0, e.getComponent().getSize().width, e.getComponent().getSize().height);
//		int maxSize = (e.getComponent().getSize().height > e.getComponent().getSize().width ? e.getComponent().getSize().height : e.getComponent().getSize().width);		
		

	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
