package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion 
{
  @Test
  public void test() {
	  SoftAssert sa = new SoftAssert();
	  System.out.println("1111");
	 // sa.assertEquals(true,false );
	  Assert.fail();
	  System.out.println("22222");
	  sa.assertAll();
  }
  @Test
  public void test2() {
	  System.out.println("33333333");
  }
  
}
