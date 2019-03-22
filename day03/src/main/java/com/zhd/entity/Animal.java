package com.zhd.entity;

public class Animal {

	private int id;
	private Dog dog;
	private Cat cat;
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(int id, Dog dog, Cat cat) {
		super();
		this.id = id;
		this.dog = dog;
		this.cat = cat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	public Cat getCat() {
		return cat;
	}
	public void setCat(Cat cat) {
		this.cat = cat;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", dog=" + dog + ", cat=" + cat + "]";
	}
	
	
}
