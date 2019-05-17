package com.tvd.rest.dto;

import java.io.Serializable;

public class Student implements Serializable{

private String name;
private String address;
private String clg;


public Student() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getClg() {
	return clg;
}
public void setClg(String clg) {
	this.clg = clg;
}
public Student(String name, String address, String clg) {
	this.name = name;
	this.address = address;
	this.clg = clg;
}

}
