package GameState;

public abstract class GameState extends Object{
    final StateManager gameStateManager;

    GameState(StateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        init();
    }

    protected abstract void init();

    public abstract void update(float dt);

    public abstract void draw();

    public abstract void handleInput();

    public abstract void dispose();

}
