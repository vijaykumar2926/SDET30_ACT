package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class PrintAllLastnameTest extends BaseClass
{
	@Test
	public void print_all_lastname()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnContactLink();
		Reporter.log("clicked on contacts link",true);
		List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		for (WebElement webElement : eles) 
		{
			String text = webElement.getText();
			System.out.println(text);
		}
		Reporter.log("All contacts in the page are printed Successfully",true);	
	}
}
