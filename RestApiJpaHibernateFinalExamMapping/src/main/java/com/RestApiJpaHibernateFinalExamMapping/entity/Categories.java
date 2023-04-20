package com.RestApiJpaHibernateFinalExamMapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="categories")
public class Categories {


@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String type;
private String colour;
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public Categories(int id, String name, String type, String colour) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.colour = colour;
}
public Categories() {
	super();
	// TODO Auto-generated constructor stub
}

}
