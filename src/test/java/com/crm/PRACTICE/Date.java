package com.crm.PRACTICE;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.DateFormatter;

import org.testng.annotations.Test;

public class Date 
{
@Test
public void tests()
{
	java.util.Date d = new java.util.Date();
	Calendar c = Calendar.getInstance();
	c.setTime(d);
	SimpleDateFormat sfd = new SimpleDateFormat("d MMMM YYYY");
	String today = sfd.format(d);
	System.out.println(today);
	String[] spl = today.split(" ");
	String Day = spl[0];
	String Month = spl[1];
	String Year = spl[2];

}
}
