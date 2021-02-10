import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private ImageIcon titleImage;
	private ImageIcon appleImage;
	private ImageIcon snakeimage;
	
	private int[] snakeXlength_1 = new int[750];
	private int[] snakeYlength_1 = new int[750];
	
	private int[] snakeXlength_2 = new int[750];
	private int[] snakeYlength_2 = new int[750];
	
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;
	
	private boolean a = false;
	private boolean d = false;
	private boolean w = false;
	private boolean s = false;
	
	private boolean disable_1 = false;
	private boolean disable_2 = false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	
	private int lengthOfSnake_1 = 3;
	private int lengthOfSnake_2 = 3;
	
	private int[] appleXpos = {25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325,
			350, 375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 
			675, 700, 725, 750, 775, 800, 825, 850};
	private int[] appleYpos = {75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 
			375, 400, 425, 450, 475, 500, 525, 550, 575, 600, 625};
	
	private Random random = new Random();	
	private int xPos = random.nextInt(34);
	private int yPos = random.nextInt(23);
	
	private int score_1 = 0;
	private int score_2 = 0;
	
	private Timer timer;
	private int delay = 100;
	
	private int moves = 0;
	
	
	public Gameplay()
	{
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void paint(Graphics g)
	{
		if(moves == 0) //set initial position of snake
		{
			snakeXlength_1[2] = 50;
			snakeXlength_1[1] = 75;
			snakeXlength_1[0] = 100;
			
			snakeYlength_1[2] = 100;
			snakeYlength_1[1] = 100;
			snakeYlength_1[0] = 100;
			
			snakeXlength_2[2] = 50;
			snakeXlength_2[1] = 75;
			snakeXlength_2[0] = 100;
			
			snakeYlength_2[2] = 550;
			snakeYlength_2[1] = 550;
			snakeYlength_2[0] = 550;
		}
		
		//draw title image folder
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		
		//draw title image
		titleImage = new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border for gameplay
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);
		
		//draw background for the gameplay
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		//draw scores
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Score(P1): "+ score_1, 780, 30);
		
		//draw length
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Score(P2): "+ score_2, 780, 50);
		
		
		//create Snake 1
		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakeXlength_1[0], snakeYlength_1[0]);
		
		//create Snake 2
		leftmouth = new ImageIcon("rightmouth.png");
		leftmouth.paintIcon(this, g, snakeXlength_2[0], snakeYlength_2[0]);
		
		for(int a = 0; a < lengthOfSnake_1; a++) //animation for 1st snake
		{
			if(a == 0 && right)
			{
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXlength_1[a], snakeYlength_1[a]);
			}
			if(a == 0 && left)
			{
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakeXlength_1[a], snakeYlength_1[a]);
			}
			if(a == 0 && up)
			{
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakeXlength_1[a], snakeYlength_1[a]);
			}
			if(a == 0 && down)
			{
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakeXlength_1[a], snakeYlength_1[a]);
			}
			
			if(a != 0)
			{
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXlength_1[a], snakeYlength_1[a]);
			}
		}
		
		for(int x = 0; x < lengthOfSnake_2; x++) //animation for 2nd snake
		{
			if(x == 0 && d)
			{
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakeXlength_2[x], snakeYlength_2[x]);
			}
			if(x == 0 && a)
			{
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakeXlength_2[x], snakeYlength_2[x]);
			}
			if(x == 0 && w)
			{
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakeXlength_2[x], snakeYlength_2[x]);
			}
			if(x == 0 && s)
			{
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakeXlength_2[x], snakeYlength_2[x]);
			}
			
			if(x != 0)
			{
				snakeimage = new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXlength_2[x], snakeYlength_2[x]);
			}
		}
		
		appleImage = new ImageIcon("apple.png");	//set animation for apple
		appleImage.paintIcon(this, g, appleXpos[xPos], appleYpos[yPos]);
		
		//after eating the apple for snake 1
		if (appleXpos[xPos] == snakeXlength_1[0] && appleYpos[yPos] == snakeYlength_1[0])
		{
			score_1++;
			lengthOfSnake_1++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
		}
		
		//after eating the apple for snake 1
		if (appleXpos[xPos] == snakeXlength_2[0] && appleYpos[yPos] == snakeYlength_2[0])
		{
			score_2++;
			lengthOfSnake_2++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
		}
		
		for(int i = 0; i <lengthOfSnake_1; i++)	//checks every snake 1 cell,and if snake 2 head collide,game over.
		{
			if(snakeXlength_2[0] == snakeXlength_1[i] && snakeYlength_2[0] == snakeYlength_1[i]) {
				
				d = false;
				a = false;
				w = false;
				s = false;
				disable_2 = true;
				repaint();
				
			}
			
			
		}
		for(int d = 0; d <lengthOfSnake_2; d++)		//checks every snake 2 cell,and if snake 1 head collide,game over.
		{
			if(snakeXlength_1[0] == snakeXlength_2[d] && snakeYlength_1[0] == snakeYlength_2[d]) {
				
				right = false;
				left = false;
				up = false;
				down = false;
				disable_1 = true;
				repaint();
				
			}
		}
		
		//if snake 1 lose
		for (int b = 1; b < lengthOfSnake_1; b++)
		{
			if(snakeXlength_1[b] == snakeXlength_1[0] && snakeYlength_1[b] == snakeYlength_1[0]) 
			{
				right = false;
				left = false;
				up = false;
				down = false;
				disable_1 = true;
				repaint();
			}
		}
		
		//if snake 2 lose
		for (int b = 1; b < lengthOfSnake_2; b++)
		{
			if(snakeXlength_2[b] == snakeXlength_2[0] && snakeYlength_2[b] == snakeYlength_2[0]) 
			{
				d = false;
				a = false;
				w = false;
				s = false;
				disable_2 = true;
				repaint();
			}
		}
		
		if (disable_1 == true && disable_2 == true)
		{
			if(score_1 > score_2)
			{
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 60));
				g.drawString("Player 1 Won!", 300, 300);
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
			}
			
			if(score_2 > score_1)
			{
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 60));
				g.drawString("Player 2 Won!", 300, 300);
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
			}
			
			if(score_2 == score_1)
			{
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 60));
				g.drawString("Draw!", 300, 300);
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Space to RESTART", 350, 340);
			}
		}
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (right)
		{
			for (int r = lengthOfSnake_1-1; r >= 0; r--)
			{
				snakeYlength_1[r+1] = snakeYlength_1[r];
			}
			for (int r = lengthOfSnake_1; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeXlength_1[r] = snakeXlength_1[r] + 25;
				}
				else
				{
					snakeXlength_1[r] = snakeXlength_1[r-1];
				}
				if (snakeXlength_1[r] > 850) //out of border
				{
					snakeXlength_1[r] = 25;	//set position on other side
				}
			}
			repaint();
			
		}
		if (left)
		{
			for (int r = lengthOfSnake_1-1; r >= 0; r--)
			{
				snakeYlength_1[r+1] = snakeYlength_1[r];
			}
			for (int r = lengthOfSnake_1; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeXlength_1[r] = snakeXlength_1[r] - 25;
				}
				else
				{
					snakeXlength_1[r] = snakeXlength_1[r-1];
				}
				if (snakeXlength_1[r] < 25) //out of border
				{
					snakeXlength_1[r] = 850;	//set position on other side
				}
			}
			repaint();
		}
		if (up)
		{
			for (int r = lengthOfSnake_1-1; r >= 0; r--)
			{
				snakeXlength_1[r+1] = snakeXlength_1[r];
			}
			for (int r = lengthOfSnake_1; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeYlength_1[r] = snakeYlength_1[r] - 25;
				}
				else
				{
					snakeYlength_1[r] = snakeYlength_1[r-1];
				}
				if (snakeYlength_1[r] < 75) //out of border
				{
					snakeYlength_1[r] = 625;	//set position on other side
				}
			}
			repaint();
		}
		if (down)
		{
			for (int r = lengthOfSnake_1-1; r >= 0; r--)
			{
				snakeXlength_1[r+1] = snakeXlength_1[r];
			}
			for (int r = lengthOfSnake_1; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeYlength_1[r] = snakeYlength_1[r] + 25;
				}
				else
				{
					snakeYlength_1[r] = snakeYlength_1[r-1];
				}
				if (snakeYlength_1[r] > 625) //out of border
				{
					snakeYlength_1[r] = 75;	//set position on other side
				}
			}
			repaint();
		}
		
		if (d)
		{
			for (int r = lengthOfSnake_2-1; r >= 0; r--)
			{
				snakeYlength_2[r+1] = snakeYlength_2[r];
			}
			for (int r = lengthOfSnake_2; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeXlength_2[r] = snakeXlength_2[r] + 25;
				}
				else
				{
					snakeXlength_2[r] = snakeXlength_2[r-1];
				}
				if (snakeXlength_2[r] > 850) //out of border
				{
					snakeXlength_2[r] = 25;	//set position on other side
				}
			}
			repaint();
			
		}
		if (a)
		{
			for (int r = lengthOfSnake_2-1; r >= 0; r--)
			{
				snakeYlength_2[r+1] = snakeYlength_2[r];
			}
			for (int r = lengthOfSnake_2; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeXlength_2[r] = snakeXlength_2[r] - 25;
				}
				else
				{
					snakeXlength_2[r] = snakeXlength_2[r-1];
				}
				if (snakeXlength_2[r] < 25) //out of border
				{
					snakeXlength_2[r] = 850;	//set position on other side
				}
			}
			repaint();
		}
		if (w)
		{
			for (int r = lengthOfSnake_2-1; r >= 0; r--)
			{
				snakeXlength_2[r+1] = snakeXlength_2[r];
			}
			for (int r = lengthOfSnake_2; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeYlength_2[r] = snakeYlength_2[r] - 25;
				}
				else
				{
					snakeYlength_2[r] = snakeYlength_2[r-1];
				}
				if (snakeYlength_2[r] < 75) //out of border
				{
					snakeYlength_2[r] = 625;	//set position on other side
				}
			}
			repaint();
		}
		if (s)
		{
			for (int r = lengthOfSnake_2-1; r >= 0; r--)
			{
				snakeXlength_2[r+1] = snakeXlength_2[r];
			}
			for (int r = lengthOfSnake_2; r >= 0; r--)
			{
				if (r == 0)
				{
					snakeYlength_2[r] = snakeYlength_2[r] + 25;
				}
				else
				{
					snakeYlength_2[r] = snakeYlength_2[r-1];
				}
				if (snakeYlength_2[r] > 625) //out of border
				{
					snakeYlength_2[r] = 75;	//set position on other side
				}
			}
			repaint();
		}
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) //reset game
		{
			moves = 0;
			score_1 = 0;
			lengthOfSnake_1 = 3;
			score_2 = 0;
			lengthOfSnake_2 = 3;
			disable_1 = false;
			disable_2 = false;
			repaint();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) //check if right is pressed for player 1
		{
			moves++;
			right = true;
			if (!left)	//disable the use of opposite direction
			{
				right = true;
			}
			else
			{
				right = false;
				left = true;
			}
			
			up = false;
			down = false;
			
			if(disable_1 == true)
			{
				right = false;
				left = false;
				down = false;
				up = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)	//check if left is pressed for player 1
		{
			moves++;
			left = true;
			if (!right)	//disable the use of opposite direction
			{
				left = true;
			}
			else
			{
				left = false;
				right = true;
			}
			
			up = false;
			down = false;
			
			if(disable_1 == true)
			{
				right = false;
				left = false;
				down = false;
				up = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP)	//check if up is pressed for player 1
		{
			moves++;
			up = true;
			if (!down)	//disable the use of opposite direction
			{
				up = true;
			}
			else
			{
				up = false;
				down = true;
			}
			
			left = false;
			right = false;
			
			if(disable_1 == true)
			{
				right = false;
				left = false;
				down = false;
				up = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN)	//check if down is pressed for player 1
		{
			moves++;
			down = true;
			if (!up)	//disable the use of opposite direction
			{
				down = true;
			}
			else
			{
				down = false;
				up = true;
			}
			
			left = false;
			right = false;
			
			if(disable_1 == true)
			{
				right = false;
				left = false;
				down = false;
				up = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_D)	//check if right is pressed for player 2
		{
			moves++;
			d = true;
			if (!a)	//disable the use of opposite direction
			{
				d = true;
			}
			else
			{
				d = false;
				a = true;
			}
			
			w = false;
			s = false;
			
			if(disable_2 == true)
			{
				d = false;
				a = false;
				w = false;
				s = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A)	//check if left is pressed for player 2
		{
			moves++;
			a = true;
			if (!d)	//disable the use of opposite direction
			{
				a = true;
			}
			else
			{
				a = false;
				d = true;
			}
			
			w = false;
			s = false;
			
			if(disable_2 == true)
			{
				d = false;
				a = false;
				w = false;
				s = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_W)	//check if up is pressed for player 2
		{
			moves++;
			w = true;
			if (!s)	//disable the use of opposite direction
			{
				w = true;
			}
			else
			{
				w = false;
				s = true;
			}
			
			a = false;
			d = false;
			
			if(disable_2 == true)
			{
				d = false;
				a = false;
				w = false;
				s = false;
			}
		}
		
		if (e.getKeyCode() == KeyEvent.VK_S)	//check if down is pressed for player 2
		{
			moves++;
			s = true;
			if (!w)	//disable the use of opposite direction
			{
				s = true;
			}
			else
			{
				s = false;
				w = true;
			}
			
			a = false;
			d = false;
			
			if(disable_2 == true)
			{
				d = false;
				a = false;
				w = false;
				s = false;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		
	}
}
