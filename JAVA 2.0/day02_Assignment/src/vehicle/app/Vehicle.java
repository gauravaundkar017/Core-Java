package vehicle.app;

import color_enum.Color;

public class Vehicle {
	private String chasisNo;
	private double price;
	private Color color;
	private double pollutionLevel;
//	private Date insuranceExpDate;
//	private Date manufactureDate;

	public Vehicle(String chasisNo, Color color,double price, double pollutionLevel) {
		this.chasisNo = chasisNo;
		this.price = price;
		this.color = color;
		this.pollutionLevel = pollutionLevel;
	}
	public String getChasisNo() {
		return chasisNo;
	}

	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getPollutionLevel() {
		return pollutionLevel;
	}

	public void setPollutionLevel(double pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}


	@Override
	public String toString() {
		return "Vehilcle [chasisNo=" + chasisNo + ", price=" + price + ", color=" + color + ", pollutionLevel="
				+ pollutionLevel + "]";
	}
}
