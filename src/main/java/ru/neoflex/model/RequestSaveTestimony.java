package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class RequestSaveTestimony{

	@SerializedName("date")
	private String date;

	@SerializedName("currentTestimony")
	private CurrentTestimony currentTestimony;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setCurrentTestimony(CurrentTestimony currentTestimony){
		this.currentTestimony = currentTestimony;
	}

	public CurrentTestimony getCurrentTestimony(){
		return currentTestimony;
	}

	@Override
 	public String toString(){
		return 
			"RequestSaveTestimony{" + 
			"date = '" + date + '\'' + 
			",currentTestimony = '" + currentTestimony + '\'' + 
			"}";
		}
}