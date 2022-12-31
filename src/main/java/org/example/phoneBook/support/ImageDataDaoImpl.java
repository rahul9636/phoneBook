package org.example.phoneBook.support;

import io.dropwizard.hibernate.AbstractDAO;
import org.example.phoneBook.models.ImageDataDao;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

public class ImageDataDaoImpl extends AbstractDAO<ImageData> implements ImageDataDao {

    private SessionFactory sessionFactory;
    @Inject
    public ImageDataDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public long saveImage(ImageData imageData) {
        return persist(imageData).getImageId();
    }

    @Override
    public ImageData getImage(long image_id) {
        return null;
    }
}
