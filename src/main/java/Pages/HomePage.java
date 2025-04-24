package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scary.Testing.BasePage;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By New = By.xpath("//button[@class='btn create-dropdown-menu-toggle-button']");
	By NewListElements = By.xpath("//ul[@data-testid='new-item-menu']//li[@role='menuitem']");
	By DocumentName=By.xpath("//input[@name='name']");
	By CreateBut = By.xpath("//button[@class='btn btn-primary ']");
	By CancelBut = By.xpath("(//button[@class='btn'])[1]");	
	By DuplicateFileName = By.xpath("//span[contains(text(),'Duplicate')]");
	By OverwriteBut = By.xpath("//button[@class='btn btn-primary '][@data-resin-target='primarybutton']");
	By DupCancelBut = By.xpath("(//button[@class='btn'])[2]");
	
	
	@SuppressWarnings("deprecation")
	public boolean ClickOnProduct(String product) {
		click(New);
		List<WebElement> elements = WaitForElements(NewListElements);
		List<String> documents = new ArrayList<>();
		for(WebElement element : elements) {
			documents.add(element.getText());
		}
		
		for(String s:documents) {
			if(s.trim().toLowerCase().contains(product)) {
				By GoogleDoc = By.xpath("//span[contains(text(),'"+s+"')]");
				click(GoogleDoc);
				return true;
			}
		}
		return false;
	}
	
	public boolean CreateDocWithProductNameOverWrite(String name) {
		sendkeys(DocumentName,name);
		click(CreateBut);
//		if(isdisplayed(DuplicateFileName)) {
//			click(OverwriteBut);
//			return true;
//		}
		return true;
	}
	public void DuplicateDocCancel(String name) {
		sendkeys(DocumentName,name);
		click(CreateBut);
		if(isdisplayed(DuplicateFileName)) {
			click(DupCancelBut);
			click(CancelBut);
		}
	}
	
}
