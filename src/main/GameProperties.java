package main;

import main.bird.Bird;
import main.bird.strategy.BirdPhysical;
import main.bird.strategy.I_BirdStrategy;

public class GameProperties {
    public static boolean inGame = false;
    public static float pipeSpeed = 1;

    public static int pipeMinHeight = 50;
    public static int halfPipeDistance = 70;

    public static final int GAME_WIDTH = 1200;
    public static final int GAME_HEIGHT = 800;

    public static final int PIPE_WIDTH = 40;
    public static final int PIPE_GENERATE_DELAY_MILLIS = 4000;

    public static final int BIRD_SIZE = 60;

    public static BirdPhysical birdStrategy = new BirdPhysical();

    public static Bird bird;

    public static boolean isDead = false;

    public static int score = 0;

    public static long timeWhenDead = 0;

    public static void startGameScreen(){
        inGame = true;
        pipeSpeed = 1;
    }

    public static void exitGameScreen(){
        inGame = false;
    }
}
