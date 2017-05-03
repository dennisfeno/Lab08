package it.polito.tdp.borders.model;

import org.jgrapht.graph.DefaultEdge;

public class Border extends DefaultEdge{

	private String c1 ; 
	private String c2 ;
	
	// private int year ;
	// private int connectionType ; 
	// private int Version


	public Border() { // devo implementare il costruttore vuoto per poter chiamare l'add vertex.
		super();
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public Border(String c1, String c2) {
		super();
		this.c1 = c1;
		this.c2 = c2;
	}
/*
	public Border(String c1, String c2, int year, int connectionType) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.year = year;
		this.connectionType = connectionType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(int connectionType) {
		this.connectionType = connectionType;
	}
	*/
	
	
}
