package main.screen.game;

import main.GameProperties;
import main.bird.Bird;
import main.pipe.GamePipe;
import main.pipe.PipeManager;

public class CheckGameStatus {

    public CheckGameStatus(){
        GameProperties.isDead = false;
        GameProperties.score = 0;
    }

    public void update(){
        if(GameProperties.bird == null)
        return;
        for(GamePipe _pipe : PipeManager.gI().pipeList){
            if(GameProperties.bird.y >= GameProperties.GAME_HEIGHT){
                birdDead();
            }
            if(_pipe.x > GameProperties.bird.x)
                continue;
            if(phungDucManhTinhToanhVaCham(_pipe)){
                birdDead();
            }
        }
    }

    public boolean phungDucManhTinhToanhVaCham(GamePipe pipe){
        Bird bird = GameProperties.bird;
        // goc tren
        if(bird.y <= pipe.y + pipe.height && bird.y >= pipe.y){
            // ben trai
            if(bird.x > pipe.x && bird.x < pipe.x + pipe.width){
                return true;
            }
            // ben phai
            if(bird.x + bird.width > pipe.x && bird.x + bird.width < pipe.x + pipe.width){
                return true;
            }
        }
        // goc duoi
        if(bird.y + bird.height <= pipe.y + pipe.height && bird.y  + bird.height>= pipe.y){
            // ben trai
            if(bird.x > pipe.x && bird.x < pipe.x + pipe.width){
                return true;
            }
            // ben phai
            if(bird.x + bird.width > pipe.x && bird.x + bird.width < pipe.x + pipe.width){
                return true;
            }
        }

        return false;
    }

    public void birdDead(){
        GameProperties.isDead = true;
        // GameProperties.inGame = false;
        GameProperties.timeWhenDead = System.currentTimeMillis();
    }
}
