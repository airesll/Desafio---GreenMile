package com.br.gm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stop {
	@Id
	private String stopKey;
	private float lat;
	private float lng;
	private String description;
	private int deliveryRadius;
	
	//construtor vazio
	public Stop () { }
	
	public Stop(String stopKey, float lat, float lng, String description, int deliveryRadius) {
		super();
		this.stopKey = stopKey;
		this.lat = lat;
		this.lng = lng;
		this.description = description;
		this.deliveryRadius = deliveryRadius;
	}
	
	public String getStopKey() {
		return stopKey;
	}
	public void setStopKey(String stopKey) {
		this.stopKey = stopKey;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDeliveryRadius() {
		return deliveryRadius;
	}
	public void setDeliveryRadius(int deliveryRadius) {
		this.deliveryRadius = deliveryRadius;
	}
	
}
