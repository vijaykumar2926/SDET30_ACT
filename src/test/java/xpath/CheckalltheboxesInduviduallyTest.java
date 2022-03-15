package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class CheckalltheboxesInduviduallyTest  extends BaseClass
{
	@Test
	public void checkOnebyOne()
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on Organization link",true);
		List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		for (WebElement webe : eles) 
		{
			webe.click();
		}
		Reporter.log("All checkboxes selected ",true);

	}
}
