package com.country.form;



public class DireccionForm extends Form  {

	private Integer id=0;
	private String streetName;
	private String streetNumber;
	private String tower;
	private String block;
	private String floor;
	private String flat;
	private int person;
	private Integer town;
	private String townName;

	
	
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}

	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getTower() {
		return tower;
	}
	public void setTower(String tower) {
		this.tower = tower;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public Integer getTown() {
		return town;
	}
	public void setTown(Integer town) {
		this.town = town;
	}

	
	
}
