package com.skit.sqlite.model;


public class User
{
	int id;
	String name;
	int sex;//0:未知，1:男，2:女

	public User(){

	}
	public User(String name, int sex)
	{
		this.name = name;
		this.sex = sex;
	}
	public User(int id, String name, int sex){
		this.id = id;
		this.name = name;
		this.sex = sex;
	}


	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSex(int sex){
		this.sex = sex;
	}

	public int getSex(){
		return sex;
	}
}
