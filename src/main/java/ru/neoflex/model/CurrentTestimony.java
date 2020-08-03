package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class CurrentTestimony{

	@SerializedName("coldWater")
	private int coldWater;

	@SerializedName("gas")
	private int gas;

	@SerializedName("electricity")
	private int electricity;

	@SerializedName("hotWater")
	private int hotWater;

	public void setColdWater(int coldWater){
		this.coldWater = coldWater;
	}

	public int getColdWater(){
		return coldWater;
	}

	public void setGas(int gas){
		this.gas = gas;
	}

	public int getGas(){
		return gas;
	}

	public void setElectricity(int electricity){
		this.electricity = electricity;
	}

	public int getElectricity(){
		return electricity;
	}

	public void setHotWater(int hotWater){
		this.hotWater = hotWater;
	}

	public int getHotWater(){
		return hotWater;
	}

	@Override
 	public String toString(){
		return 
			"CurrentTestimony{" + 
			"coldWater = '" + coldWater + '\'' + 
			",gas = '" + gas + '\'' + 
			",electricity = '" + electricity + '\'' + 
			",hotWater = '" + hotWater + '\'' + 
			"}";
		}
}