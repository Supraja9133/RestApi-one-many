package com.RestApiJpaHibernateFinalExamMapping.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String productno;
@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
@JoinColumn(name="product_category")
private List<Categories>categories;
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
public String getProductno() {
	return productno;
}
public void setProductno(String productno) {
	this.productno = productno;
}
public List<Categories> getCategories() {
	return categories;
}
public void setCategories(List<Categories> categories) {
	this.categories = categories;
}
public Product(int id, String name, String productno, List<Categories> categories) {
	super();
	this.id = id;
	this.name = name;
	this.productno = productno;
	this.categories = categories;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}

}
