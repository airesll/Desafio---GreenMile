package com.br.gm.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rota {
	@Id
	private String routerKey;
	private String assignedVehicle;
	private String status;
	@DBRef
	private List<Stop> plannedStops;
	
	//construtor vazio
	public Rota () { }
	
	public Rota(String routerKey, String assignedVehicle, List<Stop> plannedStops) {
		super();
		this.routerKey = routerKey;
		this.assignedVehicle = assignedVehicle;
		this.status = "Pendente";
		this.plannedStops = plannedStops;
	}
	
	
	public String getRouterKey() {
		return routerKey;
	}
	public void setRouterKey(String routerKey) {
		this.routerKey = routerKey;
	}
	public String getAssignedVehicle() {
		return assignedVehicle;
	}
	public void setAssignedVehicle(String assignedVehicle) {
		this.assignedVehicle = assignedVehicle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Stop> getPlannedStops() {
		return plannedStops;
	}
	public void setPlannedStops(List<Stop> plannedStops) {
		this.plannedStops = plannedStops;
	}
	
}
