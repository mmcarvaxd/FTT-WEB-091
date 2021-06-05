package ec.ftt.model;

public class Pacient {
	private int id;
	private String name;
	private int age;
	private int weight;
	private int height;
	private String cep;
	private int number;
	private String address;
	private String city;
	private String state;

	public Pacient() {

	}

	public Pacient(int id, String name, int age, int weight, int height, String cep, int number, String address, String city, String state) {
		super();
		setId(id);
		setName(name);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setCep(cep);
		setNumber(number);
		setAddress(address);
		setCity(city);
		setState(state);
	}

	public Pacient(String id, String name, int age, int weight, int height, String cep, int number, String address, String city, String state) {
		super();
		setId(Integer.parseInt(id));
		setName(name);
		setAge(age);
		setWeight(weight);
		setHeight(height);
		setCep(cep);
		setNumber(number);
		setAddress(address);
		setCity(city);
		setState(state);
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

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
