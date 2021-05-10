package ec.ftt.model;

public class Pacient {
	private int id;
	private String name;
	private int age;
	private int weight;

	public Pacient() {

	}

	public Pacient(int id, String name, int age, int weight) {
		super();
		setId(id);
		setName(name);
		setAge(age);
		setWeight(weight);
	}

	public Pacient(String id, String name, int age, int weight) {
		super();
		setId(Integer.parseInt(id));
		setName(name);
		setAge(age);
		setWeight(weight);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
