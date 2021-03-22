package ca.cooperators.logger.dwpayloadlogger.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "payload")
public class Payload {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	@NotNull
	@JsonProperty
	String appName;
	
	@NotNull
	@JsonProperty
	String requestType;
	
	@NotNull
	@JsonProperty
	String payload;
	
	@NotNull
	@JsonProperty
	String integrationName;
	
	@NotNull
	@JsonProperty
	Long flowID;
	
	public Payload() {
		super();
	}
	public Payload(String appName, String requestType, 
		 String integrationName, long flowID, String payload) {
		
		this.appName = appName;
		this.requestType = requestType;
		this.payload = payload;
		this.integrationName = integrationName;
		this.flowID = flowID;
	}
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getIntegrationName() {
		return integrationName;
	}
	public void setIntegrationName(String integrationName) {
		this.integrationName = integrationName;
	}
	public Long getFlowID() {
		return flowID;
	}
	public void setFlowID(Long flowID) {
		this.flowID = flowID;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
