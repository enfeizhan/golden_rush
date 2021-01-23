package com.example.learnandroid.model;

import com.google.gson.annotations.SerializedName;

public class Searchinfo{

	@SerializedName("totalhits")
	private int totalhits;

	public int getTotalhits(){
		return totalhits;
	}
}