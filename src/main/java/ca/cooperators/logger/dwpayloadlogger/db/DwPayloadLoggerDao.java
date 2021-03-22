package ca.cooperators.logger.dwpayloadlogger.db;

import java.util.List;

import org.hibernate.SessionFactory;
import ca.cooperators.logger.dwpayloadlogger.core.Payload;
import io.dropwizard.hibernate.AbstractDAO;

public class DwPayloadLoggerDao extends AbstractDAO<Payload> {
	
	public DwPayloadLoggerDao(SessionFactory factory) {
		super(factory);
	}
	
	public List<Payload> getAll(){
		return (List<Payload> ) currentSession().createCriteria(Payload.class).list();
			
	}
	
	public Payload findById(Long id) {
		return get(id);
	}
	

	public long createPayloadMsg(Payload payload) {
		Long id  = payload.getFlowID();
		if(id == 0) {
			SequenceGenerator gen = new SequenceGenerator();
			id = gen.nextId();
		}
		payload.setFlowID(id);
		return persist(payload).getFlowID();
	}
	

}
