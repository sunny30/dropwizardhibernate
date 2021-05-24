package io.com.dropwizard;

import io.com.dropwizard.configurtion.DropWizardEntityConfiguration;
import io.com.dropwizard.entity.GuestEntity;
import io.com.dropwizard.entity.dao.GuestEntityDAO;
import io.com.dropwizard.resource.SampleResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<DropWizardEntityConfiguration> {


    public static void main(String[] args)throws Exception {
        new App().run(args);
    }

    public String getName(){
        return "DropWizardRocks" ;
    }
    @Override
    public void run(DropWizardEntityConfiguration dropWizardEntityConfiguration, Environment environment) throws Exception {

        GuestEntityDAO guestEntityDAO = new GuestEntityDAO(hibernateBundle.getSessionFactory()) ;
        environment.jersey().register(new SampleResource(guestEntityDAO));
    }

    private HibernateBundle<DropWizardEntityConfiguration> hibernateBundle = new HibernateBundle<DropWizardEntityConfiguration>(GuestEntity.class) {
        public DataSourceFactory getDataSourceFactory(DropWizardEntityConfiguration dropWizardEntityConfiguration) {
            return dropWizardEntityConfiguration.getDataSourceFactory() ;
        }
    };

    public void initialize(Bootstrap<DropWizardEntityConfiguration> bootstrap){
        bootstrap.addBundle(hibernateBundle);
    }
}
