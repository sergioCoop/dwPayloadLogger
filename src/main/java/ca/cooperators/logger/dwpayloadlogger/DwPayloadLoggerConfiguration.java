package ca.cooperators.logger.dwpayloadlogger;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;


public class DwPayloadLoggerConfiguration extends Configuration {
    // TODO: implement service configuration
	@NotNull
	@Valid
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();
	
	public DataSourceFactory getDataSourcFactory() {
		return database;
	}
}
