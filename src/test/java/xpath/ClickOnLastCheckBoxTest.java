package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ClickOnLastCheckBoxTest extends BaseClass
{
	@Test
	public void clickonlastcheckbox() throws Throwable
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("clicked on Organization link",true);
		List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		int last = eles.size();
		int count = 0;
		for (WebElement webe : eles) 
		{
			count++;
			if (count==last) 
			{
				wLib.scrollAction(driver, webe);
				Thread.sleep(2000);
				webe.click();
				Thread.sleep(2000);
				Reporter.log("clicked on last Checkbox",true);
			}
		}
	}
}

