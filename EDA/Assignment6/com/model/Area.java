package com.model;

public class Area {
	
	public float areaOfTriangle(int side1, int side2, int side3) {
		float s = (side1 + side2 + side3)/2;
		float temp = s * (s - side1) * (s - side2) * (s - side3);
		return (float) Math.sqrt(temp);
	}
}
