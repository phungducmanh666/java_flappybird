package core.manager.image;

import core.manager.image.strategy.I_LoadImageStrategy;
import core.manager.image.strategy.LoadImageCache;

import java.awt.Image;

public class ImageManager {

    private static ImageManager instance;
    public static ImageManager gI(){
        if(instance == null)
        instance = new ImageManager();
        return instance;
    }
    
    ///////////////////////////////////////////////////////////
    private I_LoadImageStrategy strategy;

    private ImageManager(){
        strategy = new LoadImageCache();
    }

    public void setStrategy(I_LoadImageStrategy strategy){
        this.strategy = strategy;
    }

    public Image getImage(String key){
        return strategy.getImage(key);
    }
}
