public class PolymorphismTest2 {
	public static void main(String[] args) {
		Cat c = new Cat("Kitty", "pink");
		Dog d = new Dog("Duby","yellow");
		Man m1 = new Man("sater1",c);
		Man m2 = new Man("sater2",d);
		m1.petEnjoy();
		m2.petEnjoy();
		System.out.println(c.getName()); 
	}
}

class Man {
	private String name;
	Animal pet;
	public Man(String name, Animal pet) {
		this.name = name;
		this.pet = pet;
	}
	public void petEnjoy() {
		pet.enjoy();
	}
}

abstract class Animal {
	private String name;
	public Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public abstract void enjoy();
}

class Cat extends Animal {
	private String color;
	public Cat(String name, String color) {
		super(name);
		this.color = color;
	}
	public void enjoy() {
		System.out.println("Cat's yell...");
	}
}

class Dog extends Animal {
	private String color;
	public Dog(String name, String color) {
		super(name);
		this.color = color;
	}
	public void enjoy() {
		System.out.println("Dog's yell...");
	}
}