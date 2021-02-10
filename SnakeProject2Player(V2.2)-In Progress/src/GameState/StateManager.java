package GameState;


import ScoreBoard.GameScore;

public class StateManager {
    private GameState gameState;

    //Constants list of Game State
    public enum State {
        MENU, PLAY, HIGHSCORES, GAMEOVER
    }

    private static boolean newGame;

    public StateManager() {
        setState(State.MENU);
    }


    //Setter to set Game State
    public void setState(State state) {
        if (gameState != null) {
            gameState.dispose();
            gameState = null;
            System.gc();

        }

        switch (state) {
            case MENU:
                break;
            case PLAY:
                break;
            case HIGHSCORES:
                gameState = new ScoreBoardState(this);
                break;
            case GAMEOVER:
                break;
        }
    }
    public static boolean isNewGame() {
        return newGame;
    }

    public static void startNewGame() {
        newGame=!newGame;
    }

    public void update(float dt) {
        gameState.update(dt);

    }

    public void draw() {
        gameState.draw();

    }
}

