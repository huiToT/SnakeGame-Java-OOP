import GameState.GameState;
import GameState.Menu;
import GameState.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements Runnable, KeyListener {

    public static int WIDTH = 900;
    public static int HEIGHT = 700;

    private Thread thread;
    private boolean runState = false;


    private static StateManager gameStateManager;

    public Screen(){
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        gameStateManager = new StateManager();
        thread = new Thread(this);
        thread.start();
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void run() {
        runState = true;
        while (runState){
            movement();
            repaint();
        }
    }

    private void movement() {

    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);
        if (gameStateManager.getGameState() != null) {
            gameStateManager.draw(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            gameStateManager.update(e);
            System.out.println("Key Press UP");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            gameStateManager.update(e);
            System.out.println("Key Press DOWN");
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            gameStateManager.update(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
