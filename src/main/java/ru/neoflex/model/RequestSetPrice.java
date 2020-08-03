package ru.neoflex.model;

import com.google.gson.annotations.SerializedName;

public class RequestSetPrice{

	@SerializedName("price")
	private Price price;

	public void setPrice(Price price){
		this.price = price;
	}

	public Price getPrice(){
		return price;
	}

	@Override
 	public String toString(){
		return 
			"RequestSetPrice{" + 
			"price = '" + price + '\'' + 
			"}";
		}
}