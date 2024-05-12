package fruit.app;
public class Apple extends Fruit{
	public Apple(String color, double weight, String name, boolean fresh) {
		super(color, weight,name,fresh);
	}
	public String taste() {
		return "Apple taste is sweet and sour";	
	}
	public void jam() {
		System.out.println("Name-"+this.name + " making jam!");
	}
}