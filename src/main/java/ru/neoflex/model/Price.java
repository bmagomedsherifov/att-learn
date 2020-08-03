package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class Price{

	@SerializedName("priceHotWater")
	private int priceHotWater;

	@SerializedName("priceGas")
	private int priceGas;

	@SerializedName("priceColdWater")
	private int priceColdWater;

	@SerializedName("priceElectricity")
	private int priceElectricity;

	public void setPriceHotWater(int priceHotWater){
		this.priceHotWater = priceHotWater;
	}

	public int getPriceHotWater(){
		return priceHotWater;
	}

	public void setPriceGas(int priceGas){
		this.priceGas = priceGas;
	}

	public int getPriceGas(){
		return priceGas;
	}

	public void setPriceColdWater(int priceColdWater){
		this.priceColdWater = priceColdWater;
	}

	public int getPriceColdWater(){
		return priceColdWater;
	}

	public void setPriceElectricity(int priceElectricity){
		this.priceElectricity = priceElectricity;
	}

	public int getPriceElectricity(){
		return priceElectricity;
	}

	@Override
 	public String toString(){
		return 
			"Price{" + 
			"priceHotWater = '" + priceHotWater + '\'' + 
			",priceGas = '" + priceGas + '\'' + 
			",priceColdWater = '" + priceColdWater + '\'' + 
			",priceElectricity = '" + priceElectricity + '\'' + 
			"}";
		}
}