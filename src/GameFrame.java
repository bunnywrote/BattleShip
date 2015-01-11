import java.awt.Color;


import java.awt.GridLayout;
import javax.sound.sampled.*;
import java.io.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GameFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = -1284720947150755133L;
	
	JFrame frame = new JFrame();
	
	PlayerPanel field = new PlayerPanel();
	OpponentPanel field2 = new OpponentPanel(field); 
		
	public static void main(String[] args)
	{
		(new GameFrame()).run();
	}

	@Override
	public void run() {
		/*
		 * Menu
		 */
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		frame.setJMenuBar(menuBar);
		menuBar.add(file);
		JMenuItem newGame = new JMenuItem("New Game");
		file.add(newGame);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Your Progress will be lost! \nAre you sure?");
				(new GameFrame()).run();
			}
		});
		JMenuItem exit = new JMenuItem("Exit");
		file.add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Are you sure?");
				System.exit(0); //System exit
			}
		});
		
		frame.setSize(1000, 400);
		frame.setTitle("Battle Ships <dev>");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 2));
		
		frame.getContentPane().add(field);
		field.setBorder(BorderFactory.createLineBorder(Color.black));
		
		field2.setBorder(BorderFactory.createLineBorder(Color.black));
		frame.getContentPane().add(field2);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		music();
	}
	
	public static void music(){
		try{
			File soundFile = new File("music.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			
	        // Get a sound clip resource.
	        Clip clip = AudioSystem.getClip();
	        
	        // Open audio clip and load samples from the audio input stream.
	        clip.open(audioIn);
	        clip.start();
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
	        
	     } catch (UnsupportedAudioFileException e) {
	        e.printStackTrace();
	     } catch (IOException e) {
	        e.printStackTrace();
	     } catch (LineUnavailableException e) {
	        e.printStackTrace();
	     }
	}
}