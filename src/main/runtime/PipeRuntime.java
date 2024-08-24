package main.runtime;

import main.GameProperties;
import main.pipe.PipeManager;

public class PipeRuntime {

    private static PipeRuntime instance;

    public static PipeRuntime gI(){
        if(instance == null)
        instance = new PipeRuntime();
        return instance;
    }

    private long nextTimeAddRandomPipePair = 0l;

    private PipeRuntime(){}

    public void start(){
        Thread t = new Thread(){
            @Override
            public void run() {
                while (GameProperties.inGame) {
                    try {
        
                        long _millis = System.currentTimeMillis();
                        if(_millis > (nextTimeAddRandomPipePair)){
                            PipeManager.gI().addRandomPipePair();
                            nextTimeAddRandomPipePair = _millis + GameProperties.PIPE_GENERATE_DELAY_MILLIS;
                        }
        
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                }
            }
        
        };

        t.start();
    }

}
