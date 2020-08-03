package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class ResponseSetPrice{

	@SerializedName("resultText")
	private String resultText;

	@SerializedName("resultCode")
	private String resultCode;

	public void setResultText(String resultText){
		this.resultText = resultText;
	}

	public String getResultText(){
		return resultText;
	}

	public void setResultCode(String resultCode){
		this.resultCode = resultCode;
	}

	public String getResultCode(){
		return resultCode;
	}

	@Override
 	public String toString(){
		return 
			"ResponseSetPrice{" + 
			"resultText = '" + resultText + '\'' + 
			",resultCode = '" + resultCode + '\'' + 
			"}";
		}
}