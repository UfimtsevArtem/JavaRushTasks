package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by User on 01.03.2017.
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type){

        if(type==ImageTypes.JPG){
           return  new JpgReader();
        }
        else if(type==ImageTypes.PNG){
           return  new PngReader();
        }
        else if(type==ImageTypes.BMP) {
            return new BmpReader();
        }else{
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
