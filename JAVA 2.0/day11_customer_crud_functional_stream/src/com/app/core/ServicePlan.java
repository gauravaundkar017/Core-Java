package com.app.core;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);
	private double planPrice;
	ServicePlan(double planPrice){
		this.planPrice = planPrice;
	}
	public double getPalnPrice() {
		return this.planPrice;
	}
}
