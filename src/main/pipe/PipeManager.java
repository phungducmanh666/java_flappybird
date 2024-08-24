package main.pipe;

import java.util.List;

import main.GameProperties;
import utils.AppLogger;
import utils.NumberUtil;

import java.util.ArrayList;

import java.awt.Graphics;

public class PipeManager {

    public static PipeManager gI(){
        if(instance == null)
        instance = new PipeManager();
        return instance;
    }

    private static PipeManager instance;

    public List<GamePipe> pipeList;

    private PipeManager(){
        pipeList = new ArrayList<>();
    }

    public void drawPipes(Graphics g){
        for(GamePipe _pipe : pipeList){
            _pipe.draw(g);
        }
    }

    public void updatePipes(){
        for(GamePipe _pipe : pipeList){
            if(_pipe.x <= 0){
                removePipe(_pipe);
            }
            else{
                _pipe.update();
            }
        }
    }

    public void removePipe(GamePipe pipe){
        if(pipe.onTop){
            GameProperties.score += 1;
        }
        pipeList.remove(pipe);
        AppLogger.logger.info(String.format("PIPE NUMBER: %d \t\t ::: IMAGE INSTANCE OFF REMOVED PIPE :: %d", pipeList.size(), pipe.image.hashCode()));
    }

    public void addRandomPipePair(){
        GamePipe top, bottom;
        int min = GameProperties.pipeMinHeight + GameProperties.halfPipeDistance;
        int max = GameProperties.GAME_HEIGHT - min;

        int middleY = NumberUtil.randomIntInRange(min, max);

        int topX = GameProperties.GAME_WIDTH;
        int topY = middleY - GameProperties.halfPipeDistance;
        int bottomX = GameProperties.GAME_WIDTH;
        int bottomY = middleY + GameProperties.halfPipeDistance;
        int topHeight = topY;
        int bottomHeight = GameProperties.GAME_HEIGHT - bottomY;

        top = new GamePipe(topX, 0, topHeight,  true);
        bottom = new GamePipe(bottomX, bottomY, bottomHeight,  false);

        pipeList.add(top);
        pipeList.add(bottom);
    }

    public void reset(){
        pipeList = new ArrayList<>();
    }
}
