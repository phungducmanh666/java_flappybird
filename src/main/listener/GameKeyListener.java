package main.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GameProperties;
import main.bird.Bird;
import main.screen.game.GameScreen;
import main.screen.gameOver.GameOverScreen;

public class GameKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Game.gI().currentScreen instanceof GameOverScreen && e.getKeyCode() == 10){
            Game.gI().switchScreen(new GameScreen());
        }
        if(Game.gI().currentScreen instanceof GameScreen && e.getKeyCode() == 32){
            GameProperties.birdStrategy.moveToUp();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
