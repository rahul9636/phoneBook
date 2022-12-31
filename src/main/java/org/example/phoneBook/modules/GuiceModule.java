package org.example.phoneBook.modules;

import com.google.inject.*;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;
import org.example.phoneBook.configuration.CoreConfiguration;
import org.example.phoneBook.models.ImageDataDao;
import org.example.phoneBook.support.ImageData;
import org.example.phoneBook.support.ImageDataDaoImpl;
import org.hibernate.SessionFactory;

import java.util.Objects;

public class GuiceModule extends AbstractModule {

    private CoreConfiguration configuration;
    private final HibernateBundle<CoreConfiguration> hibernateBundle ;
    private Environment environment;

    public GuiceModule(CoreConfiguration configuration, HibernateBundle<CoreConfiguration> hibernateBundle, Environment environment) {
        this.configuration = configuration;
        this.hibernateBundle = hibernateBundle;
        this.environment = environment;
    }

    @Override
    protected void configure() {
        bind(ImageData.class);
        bind(ImageDataDao.class).to(ImageDataDaoImpl.class);
    }

    @Provides
    @Singleton
    SessionFactory providesSessionFactory() {
        SessionFactory sessionFactory = hibernateBundle.getSessionFactory();
        if (Objects.isNull(sessionFactory)){
            throw new ProvisionException("error");
        }
        return sessionFactory;
    }
}
