package core.manager.image;

import java.awt.Image;

public class ImageContainer {
    public String key;
    public Image image;

    public ImageContainer(){}

    public ImageContainer(String key, Image image){
        this.key = key;
        this.image = image;
    }
}
