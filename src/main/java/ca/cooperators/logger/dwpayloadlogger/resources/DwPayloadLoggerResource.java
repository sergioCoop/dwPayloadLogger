package ca.cooperators.logger.dwpayloadlogger.resources;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ca.cooperators.logger.dwpayloadlogger.core.Payload;
import ca.cooperators.logger.dwpayloadlogger.db.DwPayloadLoggerDao;
import io.dropwizard.hibernate.UnitOfWork;

@Path("/payload")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DwPayloadLoggerResource {
	DwPayloadLoggerDao payloadDao;
	
	public DwPayloadLoggerResource(DwPayloadLoggerDao payloadDao) {
		this.payloadDao = payloadDao;
		
	}
	
	@GET
	@UnitOfWork
	public List<Payload> getAll(){
		return payloadDao.getAll();
	}
	
	@GET
	@Path("/{id}")
	@UnitOfWork
	public Payload get(@PathParam("id") Long id){
		return payloadDao.findById(id);
	}
	
	@POST
	@UnitOfWork
	public Long add(@Valid Payload payload) {
		return payloadDao.createPayloadMsg(payload);
	}

}
