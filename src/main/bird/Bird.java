package main.bird;

import main.GameProperties;
import main.bird.strategy.BirdPhysical;
import main.bird.strategy.I_BirdStrategy;

import java.awt.Graphics;
import java.awt.Image;

import core.manager.image.ImageManager;

public class Bird {

    public static Bird player;
    
    public float y;
    public int x, width, height;

    private I_BirdStrategy strategy;
    private Image image;

    {
        x = 100;
        y = GameProperties.GAME_HEIGHT / 3;
        width = GameProperties.BIRD_SIZE;
        height = GameProperties.BIRD_SIZE;
        // image = ImageManager.gI().getImage("flappybird.png");
        image = ImageManager.gI().getImage("flappybird.gif");
    }

    public Bird(I_BirdStrategy strategy){
        this.strategy = strategy;
    }

    public void update(){
        strategy.update();
    }

    public void draw(Graphics g){
        g.drawImage(image, x, (int)y, width, height, null);
    }
}
