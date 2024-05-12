package passbyref;

public class Employee {
	private int id;
	private String name;
	private double salary;
	
	private static String orgName = "MIT";
	public Employee() {
		id = 0;
		name = "na";
		salary = 0.0;
	}
	public Employee(int id, String name , double salary) {
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", OrgName="+orgName+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public static String getOrgName() {
		return orgName;
	}
	public static void setOrgName(String orgName) {
		Employee.orgName = orgName;
	}
	
	
}
