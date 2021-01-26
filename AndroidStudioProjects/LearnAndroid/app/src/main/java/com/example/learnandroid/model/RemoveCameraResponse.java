package com.example.learnandroid.model;

import com.google.gson.annotations.SerializedName;

public class RemoveCameraResponse {

	@SerializedName("alert_status")
	private String alertStatus;

	@SerializedName("camUUID")
	private String camUUID;

	/*@SerializedName("query")
	private Query query;

	public String getBatchcomplete(){
		return batchcomplete;
	}*/

	public String getCamUUID(){	return camUUID; }

	public String getAlertStatus(){
		return alertStatus;
	}
}