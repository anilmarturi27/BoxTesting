package Scary.Testing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.DocumentHomePage;
import Pages.HomePage;
import Pages.Signin;
import Pages.WindowHandle;
import SetChromeProfile.SetChrome;
import junit.framework.Assert;




public class Box {
	
	
	WebDriver driver = new ChromeDriver();
		
	Random random = new Random();
	String DocumentName ="apr10"+random.nextInt(9999);
	String GoogleEmail = "user1@boxengsandbox.com";
	String TrustedMail = "marturi@google.com";
	
	@BeforeClass
	public void SignIn(){
//		WebDriver driver = new ChromeDriver();
		driver.get("https://boxfordocs.app.box.com/folder/0");
//		WebDriver profiledriver = new ChromeDriver(SetChrome.getChromeSetup());
//		profiledriver.get("https://www.google.com");
		driver.manage().window().maximize();
		Signin sn = new Signin(driver);
		sn.login();

	}
	
	@Test(priority=1)
	public void Createdoc() throws InterruptedException {
		HomePage hm = new HomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		Signin sn = new Signin(driver);
		DocumentHomePage dhm = new DocumentHomePage(driver);
		
//		Clicking on the Google Docs in the Box HomeScreen
		boolean ClickResult=  hm.ClickOnProduct("google docs");
		Assert.assertTrue("Google docs is not accessible", ClickResult);
		
//		Creating the document with the given document name
		boolean CreateDocName = hm.CreateDocWithProductNameOverWrite(DocumentName);
		Assert.assertTrue("Document is not created", CreateDocName);
//		hm.DuplicateDocCancel("April071");
		
//		If document is created, switching the document window
		boolean DocCreated = wh.DocmentWindow();
		Assert.assertTrue("Document is not created and switched ", DocCreated);
		
//		Clicking Google SignIn Button
		sn.GoogleSignInButton();
		
//		Switching to signin window
		wh.switchTo("sign in");
		
//		loging in using the credentials
		sn.GoogleLogin(GoogleEmail,TrustedMail);
//		
//		WebDriver profiledriver = new ChromeDriver(SetChrome.getChromeSetup());
//		profiledriver.get("https:www.google.com");
//		
		wh.switchTo(DocumentName);
		
		boolean documentload = dhm.isDocumentLoaded();
		Assert.assertTrue(documentload);
		System.out.println("Document is loaded");
		driver.switchTo().defaultContent();
	}
	
	
	@Test(priority=2,dependsOnMethods="Createdoc")
	public void CreateDocFromFile() throws InterruptedException {
		
		Signin sn = new Signin(driver);
		DocumentHomePage dhm = new DocumentHomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		
//		Creating the document from document File menu
		boolean FileMenuDoc=dhm.DocFromFileMenu();
		Assert.assertTrue("document is not created from file menu", FileMenuDoc);
		
//		Checking the created file menu document
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		driver.close();
		
//		Switching the document to the main document
		boolean switched = wh.switchTo(DocumentName);
		Assert.assertTrue(switched);
	}
	
	@Test(priority=3,dependsOnMethods="Createdoc")
	public void MakeACopy() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		WindowHandle wh = new WindowHandle(driver);
		dhm.MakeACopyFromFileMenu();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		boolean switched = wh.switchTo("copy");
//		Set<String> s = driver.getWindowHandles();
//		List<String> list = new ArrayList<>();
//		Iterator<String> itr = s.iterator();
//		while(itr.hasNext()) {
//			String ss = itr.next();
//			driver.switchTo().window(ss);
//			list.add(driver.getTitle());
//		}
//		
//		System.out.println(list);
		Assert.assertTrue(switched);
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		driver.close();
		
//		Switching the document to the main document
		boolean switchedd = wh.switchTo(DocumentName);
		Assert.assertTrue(switchedd);
	}
//		
	@Test(priority=4,dependsOnMethods="Createdoc")
	public void TextEntering() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.EnterText("Hello Anil Marturi");
	}
	
	@Test(priority=5,dependsOnMethods="Createdoc")
	public void InsertDrawing() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.DrwaingInsert();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
	}
//	
	@Test(priority=6)
	public void comment() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.InsertComment();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
	}
//	
	@Test(priority=7)
	public void InsertHorizontalLine() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.HorizontalLine();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
		}
	
	@Test(priority=8)
	public void InsertSpecialCharacter() throws InterruptedException {
		DocumentHomePage dhm = new DocumentHomePage(driver);
		dhm.SpecialCharacters();
		boolean Checked = dhm.DocumentCheck();
		Assert.assertTrue(Checked);
		//switching the driver to the default content because documentcheck method returns boolean and i am unable to switch to default content in that method itself
		driver.switchTo().defaultContent();
	}
	
	
	
//	@Test(priority=7)
//	public void close() {
//		driver.quit();
//	}
////	
//	
////	@AfterMethod
////	public void CloseDriver() {
////		driver.close();
////	}
//	

}
