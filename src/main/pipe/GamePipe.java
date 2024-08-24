package main.pipe;

import java.awt.Graphics;
import java.awt.Image;

import core.manager.image.ImageManager;
import main.GameProperties;

public class GamePipe {

    public int x, y, width, height;
    public Image image;
    public boolean onTop;

    {
        width = GameProperties.PIPE_WIDTH;
    }

    public GamePipe(int x, int y, int width, int height, boolean onTop){
        this.x = x; 
        this.y = y; 
        this.width = width;
        this.height = height;
        this.onTop = onTop;
        if(onTop){
            this.image = ImageManager.gI().getImage("toppipe.png");
        }
        else{
            this.image = ImageManager.gI().getImage("bottompipe.png");
        }
    }

    public GamePipe(int x, int y, int height, boolean onTop){
        this.x = x;
        this.y = y; 
        this.height = height;
        this.onTop = onTop;
        if(onTop){
            this.image = ImageManager.gI().getImage("toppipe.png");
        }
        else{
            this.image = ImageManager.gI().getImage("bottompipe.png");
        }
    }

    public void update(){
        this.x -= GameProperties.pipeSpeed;
    }

    public void draw(Graphics g){
        g.drawImage(this.image, x, y,width, height, null);
    }
}
