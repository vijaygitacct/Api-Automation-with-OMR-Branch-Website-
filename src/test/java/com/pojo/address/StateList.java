package com.pojo.address;
/**
 * @description  request body for getStateList endpoint
 * @Date 31-oct-22
 * @author hp
 *
 */
public class StateList {
	private int id;
	private String name;
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

}
