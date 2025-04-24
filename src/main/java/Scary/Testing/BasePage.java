package Scary.Testing;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	}
	
	
	
	public WebElement WaitForElement(By locator) {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}catch(Exception e) {
			System.out.println("________");
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			
		}
		
	}
	public WebElement WaitForElementForFrame(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	@SuppressWarnings("unchecked")
	public List<WebElement> WaitForElements(By locator){
		try {
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(Exception e) {
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			}
		
	}
	
	public List<WebElement> WaitForElementsForFrames(By locator){
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void sendkeys(By locator,String Name){
		WebElement element = WaitForElement(locator);
		element.sendKeys(Name);
	}
	public String getText(By locator) {
		WebElement element = WaitForElement(locator);
		return element.getText();
	}
	public void click(By locator) {
		WaitForElement(locator).click();
	}
	public boolean isdisplayed(By locator) {
		return WaitForElement(locator).isDisplayed();
	}
	public void ActionClick(By locator) {
		Actions action = new Actions(driver);
		WebElement element = WaitForElement(locator);
		action.moveToElement(element).click().perform();
	}
	public void HoverClickX30(By Hoverlocator) throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement element1 = WaitForElement(Hoverlocator);
		action.moveToElement(element1).build().perform();
		Thread.sleep(3000);
		action.moveByOffset(200, 15).click().build().perform();
//		WebElement element2 = WaitForElement(Optlocator);
//		element2.click();
		
	}
	public boolean isEnabled(By locator) {
		return WaitForElement(locator).isEnabled();
	}
	
	public void SwitchToIframe(By locator) {
		WebElement element = WaitForElementForFrame(locator);
		driver.switchTo().frame(element);
	}
	public void clear(By locator) {
		WaitForElement(locator).clear();
	}
	public boolean FluentWaitForElementEnabled(By locator) {
	    Wait<WebDriver> FWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(90))
	            .pollingEvery(Duration.ofMillis(500))
	            .ignoring(NoSuchElementException.class)
	            .ignoring(StaleElementReferenceException.class);

	    return FWait.until(driver -> {
	        try {
	            WebElement element = ExpectedConditions.presenceOfElementLocated(locator).apply(driver);
	            return (element != null && element.isDisplayed() && element.isEnabled());
	        } catch (Exception e) {
	            return false;
	        }
	    });
	}
	
	public void TimesClickEnter(int n) {
		Actions action = new Actions(driver);
		for(int i=0;i<n;i++) {
			action.sendKeys(Keys.RETURN).build().perform();
		}
	}

}
