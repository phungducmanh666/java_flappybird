package main;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import main.listener.GameKeyListener;
import main.pipe.GamePipe;
import main.screen.game.GameScreen;
import main.screen.gameOver.GameOverScreen;


public class Game extends JFrame {


    // GamePipe pipe = new GamePipe(700, 0, 100, 500, false);

    private static Game instance;

    public JPanel currentScreen;

    public static Game gI(){
        if(instance == null)
        instance = new Game();
        return instance;
    }

    private Game(){
        setSize(GameProperties.GAME_WIDTH, GameProperties.GAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        switchScreen(new GameScreen());
        // switchScreen(new GameOverScreen());

        addKeyListener(new GameKeyListener());
    }

    public void switchScreen(JPanel screen){
        currentScreen = screen;
        getContentPane().removeAll();
        getContentPane().add(screen);
        revalidate();
        repaint();
    }


    public void start(){
        setVisible(true);
        // gameLoop();
    }


    // public void gameLoop(){
    //     while (true) {
    //         try {
    //             pipe.update();
    //             draw(getGraphics());
    //             GameProperties.pipeSpeed += 0.01;
    //             Thread.sleep(10);
    //         } catch (Exception e) {
    //         }
    //     }
    // }

    // public void draw(Graphics g){
    //     Image _image = createImage(getWidth(), getHeight());
    //     Graphics _g = _image.getGraphics();
    //     _g.clearRect(0, 0, getWidth(), getHeight());
    //     pipe.draw(_g);
    //     g.drawImage(_image, 0, 0, this);
    // }
}
