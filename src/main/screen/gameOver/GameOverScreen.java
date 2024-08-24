package main.screen.gameOver;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.FontMetrics;

public class GameOverScreen extends JPanel {

    public int buttonWidth = 300;
    public int buttonHeight = 30;
    
    public GameOverScreen(){
        // gameOverLoop();
    }

    public void update(){}

    public void draw(Graphics g){

        if(g == null)return;

        Image _image = createImage(getWidth(), getHeight());
        Graphics _g = _image.getGraphics();
        _g.clearRect(0, 0, getWidth(), getHeight());

        //draw here

            int _x = getWidth() / 2 - buttonWidth / 2;
            int _y = getHeight() / 2 - 100;

            // Font font = new Font("Body", Font.PLAIN, 24);
            // _g.setFont(font);
            FontMetrics metrics = g.getFontMetrics(_g.getFont());

            String txtGameOver = "GAME OVER";
            int _tw1 = metrics.stringWidth(txtGameOver);

            _g.drawString(txtGameOver, getWidth() / 2 - _tw1 / 2, _y);

            _y += 50;

            String txtRestart = "Press Enter to Play again";
            _g.setColor(Color.BLACK);
            _g.fillRect(_x, _y, buttonWidth, buttonHeight);
            int _tw2 = metrics.stringWidth(txtRestart);
            int _th2 = metrics.getHeight();
            _g.setColor(Color.WHITE);
            _g.drawString(txtRestart, getWidth() / 2 - _tw2 / 2, _y + buttonHeight / 2 + 5);


        //end draw

        g.drawImage(_image, 0, 0, this);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    // public void gameOverLoop(){
    //     try {
    //     Thread.sleep(100);
    //     } catch (Exception e) {
    //     }
    //     Thread t = new Thread(){
    //         @Override
    //         public void run() {
    //             while(this != null){
    //                 draw(getGraphics());
    //                 try {
    //                     Thread.sleep(100);
    //                     } catch (Exception e) {
    //                     }
    //             }
    //         }
    //     };

    //     t.start();
    // }

}
