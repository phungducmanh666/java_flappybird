package main.screen.game;

import javax.swing.JPanel;

import core.manager.image.ImageManager;
import main.Game;
import main.GameProperties;
import main.bird.Bird;
import main.pipe.PipeManager;
import main.runtime.PipeRuntime;
import main.screen.gameOver.GameOverScreen;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Image;


public class GameScreen extends JPanel {

    private Bird bird;
    private CheckGameStatus checkGameStatus;
    private Image backgroundImg;

    {
        GameProperties.bird = new Bird(GameProperties.birdStrategy);
        GameProperties.birdStrategy.setBird(GameProperties.bird);
        bird = GameProperties.bird;
    }

    public GameScreen(){
        this.backgroundImg = ImageManager.gI().getImage("background.png");
        GameProperties.startGameScreen();
        PipeManager.gI().reset();
        PipeRuntime.gI().start();
  
        gameLoop();

        checkGameStatus = new CheckGameStatus();
    }

    // update bird and pipes
    public void update(){
        PipeManager.gI().updatePipes();
        bird.update();
        GameProperties.pipeSpeed += 0.0001;
        checkGameStatus.update();
    }

    // draw pipes and bird
    public void draw(Graphics g){
        Image _image = createImage(getWidth(), getHeight());
        Graphics _g = _image.getGraphics();
        _g.clearRect(0, 0, getWidth(), getHeight());

        _g.drawImage(this.backgroundImg, 0, 0, GameProperties.GAME_WIDTH, GameProperties.GAME_HEIGHT, null);

        //#region draw pipes
        PipeManager.gI().drawPipes(_g);
        //#endregion

        //#region draw bird
        bird.draw(_g);
        // //#endregion

        _g.drawString(String.format("Score: %d", GameProperties.score), 30, 30);

        if(GameProperties.isDead){
            GameProperties.inGame = false;
            Game.gI().switchScreen(new GameOverScreen());

            // GameProperties.inGame = false;

            // int _x = GameProperties.GAME_WIDTH/2 - 100;
            // int _y = GameProperties.GAME_HEIGHT / 2 - 25;
            // int _width = 200;
            // int _height = 50;
            // _g.setColor(Color.BLACK);
            // _g.fillRect(_x, _y, _width, _height);

            // String text = "Play again";
            // FontMetrics metrics = g.getFontMetrics(_g.getFont());
            // int stringWidth = metrics.stringWidth(text);
            // int stringHeight = metrics.getHeight();

            // _g.setColor(Color.WHITE);
            // _g.drawString(text, _x + _width / 2 - stringWidth/2, _y + _height / 2 );
        }

        g.drawImage(_image, 0, 0, this);
    }

    public void gameLoop(){
        Thread loopThread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                while (GameProperties.inGame) {
                    try{
                        update();
                        draw(getGraphics());
                        Thread.sleep(10);
                    }
                    catch(Exception ex){}
                }
            }
        };

        loopThread.start();
    }
}
