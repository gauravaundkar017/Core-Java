package fruit.app;

public class Mango extends Fruit {
	
	public Mango(String color, double weight, String name, boolean fresh) {
		super(color, weight,name,fresh);
	}

	public String taste() {
		return "Mango taste is Sweet";	
	}
	public void pulp() {
		System.out.println("Name-"+this.name + " Color-"+this.color + " creating  pulp!");
	}


}
