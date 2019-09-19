package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes type) {
        if (ImageTypes.JPG.equals(type)) {
            return new JpgReader();
        } else if (ImageTypes.BMP.equals(type)) {
            return new BmpReader();
        } else if (ImageTypes.PNG.equals(type)) {
            return new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
