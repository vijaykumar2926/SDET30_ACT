package com.crm.GenericLibrary;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains all the webdriver related methods
 * @author vijay
 *
 */
public class Webdriverutility 
{
	/**
	 * 1
	 * This method will maximize the window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * 2
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	/**
	 * 3
	 * This element will wait for 10 seconds for an element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * 4
	 * This element will wait for 10 seconds for an element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 5
	 * This method will select the data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * 6
	 * This method will select the data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element ,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * 7
	 * This method will select the data from dropdown using value
	 * @param value
	 * @param element
	 */
	public void select(String value , WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * 8
	 * This method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * 9
	 * This method will perform drag and drop action 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * 10
	 * This method will perform double click on webpage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * 11
	 * This method will perform double click on element
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * 12
	 * This method will perform rightclick action on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * 13
	 * This method will perform Rightclick action on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * 14
	 * This method will perform click action on enter key
	 * @param driver
	 */
	public void enterKey(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * 15
	 * This method will press and hold enter key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKeyPress(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * 16
	 * This method will release enter key
	 * @param driver
	 * @throws Throwable 
	 */
	public void enterKeyRelease(WebDriver driver) throws Throwable
	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * 17
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * 18
	 * This method will switch to frame based on NameOrID
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToFrame(WebDriver driver,String NameOrID)
	{
		driver.switchTo().frame(NameOrID);
	}
	
	/**
	 * 19
	 * This method will switch to frame based on address of the element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * 20
	 * This method will accept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * 21
	 * This method will dismiss the alert
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 22
	 * This method will switch to window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		// Step 1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		
		// Step 2: Iterate thru the windows
		Iterator<String> it = windows.iterator();
		
		//Step 3: check whether there is next window
		while(it.hasNext())
		{
			// Step 4: capture current window id
			String winId = it.next();
			
			// Step 5: switch to current window title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			// Step 6: check whether current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * 23
	 * This method will do random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("windows.scrollBy(0,500)", "");
	}
	
	/**
	 * 24
	 * This method will scroll until specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jss.executeScript("window.scrollBy(0,"+y+")", element);
		//jss.executeScript("argument[0].scrollIntoView()", element);
	}
	
	/**
	 * 25
	 * This method will take screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public void getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+screenShotName+".png");
		Files.copy(src, dst);
	}
	
	/**
	 * 26
	 * This method will do verification
	 * @param element
	 * @param ecpectedText
	 * @param nameOfElement
	 */
	public void verification(WebElement element, String ecpectedText ,String nameOfElement ,String action)
	{
		String header = element.getText();
		if(header.contains(ecpectedText))
		{
			System.out.println(ecpectedText+"  "+nameOfElement+" is "+action+"");
		}else {
			System.out.println(ecpectedText+"  "+nameOfElement+" is not "+action+"");
		}
	}
	
	/**
	 * 27
	 * This method will pass value into disabled textfields
	 * @param driver
	 * @param Id
	 * @param value
	 */
	public void passDataIntoDisabledTextfields(WebDriver driver, String Id , String value)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('"+Id+"').value=('"+value+"')", "");
	}
	
	/**
	 * 28
	 * This method will click on element based linktextvalue
	 * @param driver
	 * @param value
	 */
	public void clickOnElementByLinktextValue(WebDriver driver, String value)
	{
		driver.findElement(By.linkText(""+value+"")).click();
	}
	
	}
