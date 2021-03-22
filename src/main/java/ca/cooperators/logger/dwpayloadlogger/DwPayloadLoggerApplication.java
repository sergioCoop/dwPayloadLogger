package ca.cooperators.logger.dwpayloadlogger;

import org.jdbi.v3.core.Jdbi;

import ca.cooperators.logger.dwpayloadlogger.core.Payload;
import ca.cooperators.logger.dwpayloadlogger.db.DwPayloadLoggerDao;
import ca.cooperators.logger.dwpayloadlogger.resources.DwPayloadLoggerResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DwPayloadLoggerApplication extends Application<DwPayloadLoggerConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DwPayloadLoggerApplication().run(args);
    }

    private final HibernateBundle<DwPayloadLoggerConfiguration> hibernate = new HibernateBundle<DwPayloadLoggerConfiguration>(Payload.class) {
    	@Override 
    	public DataSourceFactory getDataSourceFactory(DwPayloadLoggerConfiguration configuration) {
    		return configuration.getDataSourcFactory();
    	}
  	};
    
   
  	
    @Override
    public String getName() {
        return "DwPayloadLogger";
    }

    @Override
    public void initialize(final Bootstrap<DwPayloadLoggerConfiguration> bootstrap) {
    	//when reading config.yaml properites are converted as environment variables
    	//so that we can set up secret for kubectl
    	bootstrap.setConfigurationSourceProvider(
    			new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
    					                              new EnvironmentVariableSubstitutor(false)));
        
    	bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final DwPayloadLoggerConfiguration configuration,
                    final Environment environment) {
    	/*
       final JdbiFactory factory = new JdbiFactory();
       final Jdbi jdbi = factory.build(environment, configuration.getDataSourcFactory(), "postgresql");
       final DwPayloadLoggerDao dwplDao = jdbi.onDemand(DwPayloadLoggerDao.class);
       */
    	
       final DwPayloadLoggerDao dwplDao = new DwPayloadLoggerDao(hibernate.getSessionFactory());
       final DwPayloadLoggerResource dwplRes = new DwPayloadLoggerResource(dwplDao);
       environment.jersey().register(dwplRes);
       
    }

}
