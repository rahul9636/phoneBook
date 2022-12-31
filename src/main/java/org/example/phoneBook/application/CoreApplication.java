package org.example.phoneBook.application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.example.phoneBook.configuration.CoreConfiguration;
import org.example.phoneBook.modules.GuiceModule;
import org.example.phoneBook.resources.BlogEntryResource;
import org.example.phoneBook.support.ImageData;

import javax.inject.Inject;

public class CoreApplication extends Application<CoreConfiguration> {
    @Override
    public void run(CoreConfiguration coreConfiguration, Environment environment) throws Exception {
        Injector injector = getInjector(coreConfiguration,environment);
        environment.jersey().register(injector.getInstance(BlogEntryResource.class));
    }

    private Injector getInjector(CoreConfiguration coreConfiguration, Environment environment) {
        return Guice.createInjector(new GuiceModule(coreConfiguration,hibernateBundle,environment));
    }

    private static final HibernateBundle<CoreConfiguration> hibernateBundle = new HibernateBundle<CoreConfiguration>(ImageData.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(CoreConfiguration coreConfiguration) {
            return coreConfiguration.getDataSourceFactory();
        }
    };
    public static void main(String[] args) throws Exception {
        new CoreApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CoreConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }
}
