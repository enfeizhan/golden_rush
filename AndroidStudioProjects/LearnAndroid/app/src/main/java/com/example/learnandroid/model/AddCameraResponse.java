package com.example.learnandroid.model;

import com.google.gson.annotations.SerializedName;

public class AddCameraResponse {

	@SerializedName("camNum")
	private String camNum;

	/*@SerializedName("continue")
	private JsonMemberContinue jsonMemberContinue;

	@SerializedName("query")
	private Query query;

	public String getBatchcomplete(){
		return batchcomplete;
	}

	public JsonMemberContinue getJsonMemberContinue(){
		return jsonMemberContinue;
	}*/

	public String getCamNum(){
		return camNum;
	}
}