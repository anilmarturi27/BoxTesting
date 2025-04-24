package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Scary.Testing.BasePage;

public class Signin extends BasePage{
	public Signin(WebDriver driver) {
		super(driver);
	}
	//Email text filed 
	
	By Email = By.xpath("//input[@id='login-email']");
	
	By NextBtn = By.xpath("//button[@id='login-submit']");
	By Password = By.xpath("//input[@id='password-login']");
	By loginBut = By.xpath("//button[@id='login-submit-password']");
	By GoogleSignin = By.xpath("//button[@class='sign-in-button button primary-button']");
	By GoogleEmail = By.xpath("//input[@type='email']");
	By GoogleNextBut = By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']");
	By Iframe = By.xpath("//iframe[@name='docs_editor_frame']");
	By ForgotMail = By.xpath("//button[@jsname='Cuz2Ue']");
	
	public void login() {
		//
		sendkeys(Email,"user1@boxengsandbox.com");
		click(NextBtn);
		sendkeys(Password,"BoxRocks00");
		click(loginBut);
	}
	
	public void GoogleSignInButton() {
		WebElement element = WaitForElement(Iframe);
		driver.switchTo().frame(element);
		ActionClick(GoogleSignin);
	}
	
	public void GoogleLogin(String GEmail,String TrustedMail) throws InterruptedException {
//		if(isdisplayed(ForgotMail)) {
//			sendkeys(GoogleEmail,GEmail);
//			click(GoogleNextBut);
//		}
		sendkeys(GoogleEmail,GEmail);
		click(GoogleNextBut);
		Thread.sleep(5000);
		sendkeys(GoogleEmail,TrustedMail);
		click(GoogleNextBut);
	}
	
	
	
}
