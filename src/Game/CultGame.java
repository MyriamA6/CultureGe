package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CultGame extends JPanel implements ActionListener,KeyListener{
	
	ArrayList<Image> images;
	
	ArrayList<ArrayList<Integer>> positions;
	
    private ArrayList<Integer> choosenNumbersHist= new ArrayList<Integer>();
    private ArrayList<Integer> choosenNumbersDivers= new ArrayList<Integer>();
	
	Theme jeu;
	
	Scanner themeChoice;
	
	int choosenImage;
	
	int startingGame=1;
	
	int score=0;
	
	Timer movementOn;
	
	int gagne;
	
	private final int boardwidth=505;
	private final int boardheight=505;
	JButton b;


	
	public CultGame() {	
		b=new JButton();
		
		b.setBounds(180, 390, 150, 50);
		b.addActionListener(this);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        
		images=new ArrayList<Image>();
		positions = new ArrayList<ArrayList<Integer>>();		
		
		this.setFocusable(true);
	    this.requestFocusInWindow();
	    this.addKeyListener(this);
	    this.setLayout(null);
		
		this.setPreferredSize(new Dimension(boardwidth,boardheight));
		}	
	
	public void chooseTheme() {
		positions.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
		this.addImage("src//debut.png");
		this.add(b);
		this.repaint();
	}
	
	public void start_game() {
		reset();
		this.remove(b);
		this.revalidate();
		this.repaint();
		this.setPosition();
		this.addImage("src//fondCultGe.png");
		this.addImage("src//question.png");
		if (jeu instanceof Histoire) {
			if (choosenNumbersHist.size()==jeu.getVerites().size()) {
				choosenNumbersHist= new ArrayList<Integer>();
			}
			this.addImages(jeu.gameSet(choosenNumbersHist));
			choosenNumbersHist.add(jeu.getChoix());

		}
		else {
			if (choosenNumbersDivers.size()==jeu.getVerites().size()) {
				choosenNumbersDivers= new ArrayList<Integer>();
			}
			this.addImages(jeu.gameSet(choosenNumbersDivers));
			choosenNumbersDivers.add(jeu.getChoix());



		}
		this.addImages(new ArrayList<String>(Arrays.asList(
				"src//arrow//a1.png",
				"src//arrow//a2.png",
				"src//arrow//a3.png",
				"src//arrow//a4.png")));
		gagne = jeu.getPlaceVerite();
	}
	
	public void setPosition() {
		positions.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
		positions.add(new ArrayList<Integer>(Arrays.asList(165, 50)));
		positions.add(new ArrayList<Integer>(Arrays.asList(0, 241))); //up
		positions.add(new ArrayList<Integer>(Arrays.asList(0, 311))); //left
		positions.add(new ArrayList<Integer>(Arrays.asList(0,371))); //right
		positions.add(new ArrayList<Integer>(Arrays.asList(0,431))); //down
		positions.add(new ArrayList<Integer>(Arrays.asList(10, 241))); //up
		positions.add(new ArrayList<Integer>(Arrays.asList(10, 311))); //left
		positions.add(new ArrayList<Integer>(Arrays.asList(10,371))); //right
		positions.add(new ArrayList<Integer>(Arrays.asList(10,431))); //down
	}
	
	public void addImage(String imagePath) {
        Image img = new ImageIcon(imagePath).getImage();
        if (img.getWidth(null)==-1) {
        	System.out.println("error");
        }
        images.add(img);
    }

	public void addImages(ArrayList<String> paths) {
		for (String imagePath : paths) {
			this.addImage(imagePath);
		}
		this.repaint();
    }
	
	public void reset() {
		images=new ArrayList<Image>();
		positions = new ArrayList<ArrayList<Integer>>();
	}
	
	public void paint(Graphics g){
		Graphics2D g2 =(Graphics2D) g;
        for(int i=0; i<images.size();i++) {
        	g2.drawImage(images.get(i), positions.get(i).get(0),positions.get(i).get(1),this);
        }
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.setColor(new Color(91, 146, 209));
		g2.drawString("Score : " + score, 13, 25);
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b) {
			reset();
			positions.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
			this.addImage("src//score.png");
			this.repaint();
		}
		else {
			move();
			repaint();
		}
		
	}
	
	public void move() {
		int i=choosenImage;
		
		String result;
		if (i==gagne+6) {
			result ="src//gagne.png";
		}
		else {
			result="src//perd.png";
		}
		switch (i) {
		case -1 :
			movementOn.stop();
    		startingGame=1;
			chooseTheme();
			break;
		case 6 :
			
			positions.get(i).set(1,positions.get(i).get(1)-1);
			if (positions.get(i).get(1)==211) {
				afficheResult(result);
				movementOn.stop();

			}
			break;
		case 7 :
			positions.get(i).set(0,positions.get(i).get(0)-1);
			if (positions.get(i).get(0)==-30) {
				afficheResult(result);
				movementOn.stop();

			}
			break;
		case 8 :
			positions.get(i).set(0,positions.get(i).get(0)+1);
			if (positions.get(i).get(0)==30) {
				afficheResult(result);
				movementOn.stop();

			}
			break;
		case 9 :
			positions.get(i).set(1,positions.get(i).get(1)+1);
			if (positions.get(i).get(1)==461) {
				afficheResult(result);
				movementOn.stop();

			}
			break;
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		movementOn = new Timer(10,this);
		movementOn.start();
		//System.out.println("KeyEvent: " + e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            choosenImage=6;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	if (startingGame==1) {
        		movementOn.stop();
        		jeu= new Histoire();
        		startingGame=0;
        		start_game();
        	}
        	else {
        		choosenImage=7;
        	}
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	if (startingGame==1) {
        		movementOn.stop();
        		jeu= new FaitsDivers();
        		startingGame=0;
        		start_game();

        	}
        	else {
        		choosenImage=8;
        	}
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	choosenImage=9;
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	if (choosenImage==gagne+6) {
    			score+=1;
    		}
        	choosenImage=-1;
        }

        
    }
	
	public void afficheResult(String result) {
		images = new ArrayList<Image>();
		positions =new ArrayList<ArrayList<Integer>>();
		positions.add(new ArrayList<Integer>(Arrays.asList(0, 0)));
		this.addImage(result);
		this.repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	

}
