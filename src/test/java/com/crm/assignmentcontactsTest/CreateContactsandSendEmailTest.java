package com.crm.assignmentcontactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.Webdriverutility;
import com.crm.ObjectRepository.ContactsInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsandSendEmailTest extends BaseClass //TC_20
{
	@Test
	public void CreateContactsandSendEmail() throws Throwable 
	{
		SoftAssert sa  = new SoftAssert();
		// read data excel sheet
		String lastname1 = eLib.readDataFromExcel("Contacts", 22, 2)+"_"+jLib.getRandomNumber();
		String lastname2 = eLib.readDataFromExcel("Contacts", 23, 2)+"_"+jLib.getRandomNumber();
		String EmailID1 = eLib.readDataFromExcel("Contacts", 22, 3);
		String EmailID2 = eLib.readDataFromExcel("Contacts", 23, 3);
		
		/* prerequisite */
		// create 2 contacts
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link", true);

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLink();
		Reporter.log("Clicked on create contacts lookup image", true);

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createNewContact(lastname1, EmailID1);
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		Reporter.log("New contacts created", true);

		String header1 = cip.contactNameInfo();
		Assert.assertTrue(header1.contains(lastname1));
		hp.clickOnContactLink();
		cp.clickOnCreateContactsLink();
		ccp.createNewContact(lastname2, EmailID2);
		Reporter.log("New contacts created", true);

		String header2 = cip.contactNameInfo();
		Assert.assertTrue(header2.contains(lastname2));
		
		/* send mail to multiple contacts */
		hp.clickOnContactLink();
		cp.getLastBtn().click();
		cp.selectContact(driver, lastname1);
		cp.selectContact(driver, lastname2);
		
		
		
//		driver.findElement(By.linkText("Contacts")).click();
//		driver.findElement(By.xpath("//img[@src='themes/images/end.gif']")).click();
//		Thread.sleep(5000);
//		//WebElement ele = driver.findElement(By.xpath("//a[.='"+lastname1+"']"));
//		//wlib.waitForElementToBeVisible(driver, ele);
//		driver.findElement(By.xpath("//a[.='"+lastname1+"']/../../td/input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//a[.='"+lastname2+"']/../../td/input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//input[@value='Send Mail']")).click();
//		//driver.findElement(By.xpath("//input[@value='80']")).click();
//		driver.findElement(By.name("Select")).click();
//		wlib.switchToWindow(driver, "sendmail");
//		driver.findElement(By.name("subject")).sendKeys("sending mail to "+lastname1+" and "+lastname2+"");
//		driver.findElement(By.name("Send")).click();
//		driver.close();
//		wlib.switchToWindow(driver, "parenttab");
//		
//		/* logout of the application */
//		WebElement eleSO = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wlib.mouseHover(driver, eleSO);
//		driver.findElement(By.linkText("Sign Out")).click();
//		
//		/* close the browser */
//		driver.quit();
				
	}
}
