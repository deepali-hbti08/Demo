package com.example.demo.model;
public class Root{
    public Space space;
    public String type;
    public String title;
    public Body body;
	public Root(Space space, String type, String title, Body body) {
		super();
		this.space = space;
		this.type = type;
		this.title = title;
		this.body = body;
	}
}
