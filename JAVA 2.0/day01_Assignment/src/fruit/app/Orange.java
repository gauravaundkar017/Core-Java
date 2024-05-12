package fruit.app;

public class Orange extends Fruit {
	
	public Orange(String color, double weight, String name, boolean fresh) {
		super(color, weight,name,fresh);
	}
	
	public String taste() {
		return "Apple taste is sour";
	}
	public void juice() {
		System.out.println("Name-"+this.name + " Weight-"+this.weight + " extracting juice!");
	}
	
}
