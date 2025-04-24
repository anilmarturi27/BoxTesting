package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Scary.Testing.BasePage;

public class WindowHandle extends BasePage{
	By SigninText = By.xpath("//button[@class='sign-in-button button primary-button']");
	By SignInBut = By.xpath("");
	
	
	public WindowHandle(WebDriver driver) {
		super(driver);
	}
	Signin sn = new Signin(driver);
	
	String HomeWindow = driver.getWindowHandle();
	
	public boolean DocmentWindow() {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
//		System.out.println(windows);
		while(itr.hasNext()) {
			String s = itr.next();
			if(!s.equals(HomeWindow)) {
				driver.switchTo().window(s);
				return true;
			}
		}
		
//		if(isdisplayed(SigninText)) {
//			sn.GoogleSignIn();
//		}
		return false;
		
	}
	public boolean switchTo(String s) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		List<String> l = new ArrayList<>();
		while(itr.hasNext()) {
			String str= itr.next();
			driver.switchTo().window(str);
			l.add(driver.getTitle());
//			System.out.println(l);
			if(driver.getTitle().toLowerCase().contains(s)) {
				return true;
				
			}
			
		}
		return false;
	}
	public void AllWindowHandlesTitles() {
		 Set<String> windows = driver.getWindowHandles();
		 Iterator<String> itr = windows.iterator();
		 ArrayList<String> list = new ArrayList<>();
		 while(itr.hasNext()) {
			 String s = itr.next();
			 driver.switchTo().window(s);
			 list.add(driver.getTitle());
		 }
		 System.out.println(list);
	}
	
}
