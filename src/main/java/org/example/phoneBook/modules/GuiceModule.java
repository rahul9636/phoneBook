package org.example.phoneBook.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Environment;
import org.example.phoneBook.configuration.CoreConfiguration;

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

    }
}
