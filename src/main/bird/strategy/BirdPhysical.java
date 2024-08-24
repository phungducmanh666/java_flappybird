package main.bird.strategy;

import main.bird.Bird;

public class BirdPhysical implements I_BirdStrategy{

    private Bird bird;
    
    private long nextTimeChangeDirection = 0;
    private long dropDelayMillis = 100;
    private boolean moveToUp = false;

    public BirdPhysical(Bird bird){
        this.bird = bird;
    }

    public BirdPhysical(){

    }

    public void setBird(Bird bird)
    {
        this.bird =bird;
    }

    @Override
    public void update() {
        long _currentMillis = System.currentTimeMillis();

        if(_currentMillis > nextTimeChangeDirection && moveToUp){
            moveToUp = false;
        }

        birdMove();
    }

    public void birdMove(){
        if(bird != null){
            if(moveToUp){
                bird.y  -= 4;
            }
            else{
                bird.y  += 2;
            }
        }
    }

    public void moveToUp(){
        nextTimeChangeDirection = System.currentTimeMillis() + dropDelayMillis;
        moveToUp = true;
    }
}