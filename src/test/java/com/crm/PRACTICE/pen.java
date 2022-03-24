package com.crm.PRACTICE;

import org.apache.poi.xddf.usermodel.PenAlignment;
import org.testng.annotations.Test;

public class pen
{
	String colour;
	int price;
	String brand;
	
	public pen(int price, String colour, String brand)
	{
		this.colour=colour;
		this.price=price;
		this.brand=brand;

	}
	
	
	public static void main(String[] args) {
	
		pen p = new pen(100, "red", "cello");
		pen p1 = new pen(200, "green", "parker");
		System.out.println(p);
		System.out.println(p1);

		
	}


	@Override
	public String toString() {
		return "pen [colour=" + colour + ", price=" + price + ", brand=" + brand + "]";
	}

}

