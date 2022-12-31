package org.example.phoneBook.models;

import org.example.phoneBook.support.ImageData;

public interface ImageDataDao {
    long saveImage(ImageData imageData);

    ImageData getImage(long image_id);
}
