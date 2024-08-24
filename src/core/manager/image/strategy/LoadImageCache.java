package core.manager.image.strategy;

import java.awt.Image;
import java.util.*;

import core.manager.image.ImageContainer;

import javax.swing.ImageIcon;


public class LoadImageCache implements I_LoadImageStrategy{

    private String basePath = "./src/resources";
    private List<ImageContainer> imageContainerList;

    public LoadImageCache(){
        imageContainerList = new ArrayList<>();
    }

    @Override
    public Image getImage(String key) {
        Image _image = getImageFromCache(key);
        if(_image == null)
            _image = getImageFromFile(key);
        return _image;
    }

    public Image getImageFromCache(String key){

        for(ImageContainer imageContainer: imageContainerList){
            if(key.equals(imageContainer.key))
                return imageContainer.image;
        }

        return null;
    }

    public Image getImageFromFile(String fileName){
        String realPath = String.format("%s/%s", basePath, fileName);
        Image _image = new ImageIcon(realPath).getImage();

        ImageContainer imageContainer = new ImageContainer(fileName, _image);
        imageContainerList.add(imageContainer);

        return _image;
    }
}
