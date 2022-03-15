package xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;

public class Select_and_Delete_5TH_ContactTest extends BaseClass 
{
	@Test
	public void delete5thele() throws Throwable 
	{
	HomePage hp = new HomePage(driver);
	hp.clickOnContactLink();
	Reporter.log("clicked on contacts link",true);
	ContactsPage cp = new ContactsPage(driver);
	List<WebElement> eles = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	int count = 0;
	for (WebElement webe : eles) 
	{
		count++;
		if (count==5) 
		{
			webe.click();
			Reporter.log("5th Contact Selected ",true);
			cp.getDeleteBtn().click();
			wLib.acceptAlert(driver);
			Thread.sleep(5000);
			Reporter.log(" selected Contact is deleted successfully",true);
		}
	}
	}
}
