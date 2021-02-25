package GameState;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameState extends Object{

    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    final StateManager gameStateManager;

    GameState(StateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        init();
    }

    protected abstract void init();

    public abstract void update(KeyEvent e);

    public abstract void draw(Graphics g);

    public abstract void dispose();

}
