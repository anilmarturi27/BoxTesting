package Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Scary.Testing.BasePage;

public class DocumentHomePage extends BasePage {
	By FileMenu = By.xpath("//div[@id='docs-file-menu']");
	By FileMenuCss = By.cssSelector("#docs-file-menu");
	By NewDoc = By.xpath("//*[@id=\":5y\"]/div");
	By NewDoc2 = By.cssSelector("#\\:5y > div");
	By MakeACopy = By.xpath("//div[@class='goog-menuitem apps-menuitem']//span[@aria-label='Make a copy c']");
	By MakeACopyDialogue = By.xpath("(//button//*[contains(text(),\"Make a copy\")])");
	By MakeACopyDialogueCss = By.xpath("body > div.javascriptMaterialdesignGm3WizDialog-dialog.javascriptMaterialdesignGm3WizDialog-dialog--standard.baseCopyDocDialogContainer.javascriptMaterialdesignGm3WizDialog-dialog--open > div.javascriptMaterialdesignGm3WizDialog-dialog__container > div > div.javascriptMaterialdesignGm3WizDialog-dialog__actions > div:nth-child(2) > button > span.javascriptMaterialdesignGm3WizButtonProgressFilled-button__label");
	By InsertMenu = By.xpath("//div[@id='docs-insert-menu']");
	By Drawingx = By.xpath("//*[@id=\":7q\"]/div");
	By DrawingCss = By.cssSelector("#\\:7q > div");
	By DrawingFrame = By.xpath("//iframe[contains(@name,'xpcpeer')]");
	By DrawingShapeBut = By.xpath("//*[@id=\"shapeButton\"]");
	By DrawingShape = By.xpath("//*[@id=\"goog-palette-cell-45\"]");
	By DrawingBoard = By.xpath("//*[@id=\"editor-p-bg\"]");
	By DrawingSaveCloseButX = By.xpath("/html/body/div[52]/div[2]/div/div/div/div/div[2]/button");
	By DrawingSaveCloseButCss = By.cssSelector("body > div.javascriptMaterialdesignGm3WizDialog-dialog.javascriptMaterialdesignGm3WizDialog-dialog--sheet.javascriptMaterialdesignGm3WizDialog-dialog--no-content-padding.sketchyUnnestedDialogFloatingSheetContainer.javascriptMaterialdesignGm3WizDialog-dialog--open.javascriptMaterialdesignGm3WizDialog-dialog--scrollable > div.javascriptMaterialdesignGm3WizDialog-dialog__container > div > div > div > div > div.mdc-touch-target-wrapper > button");
	By VersionHistorySym = By.xpath("//div[@id='docs-revisions-appbarbutton']");
	By Body = By.xpath("//body[@class='body']");
	//*[@id="mod-google-dss-1"]//div[@class='google-dss-frame-holder']//iframe[@name='docs_editor_frame']
//	#docs_editor_frame
	By DocumentBodyFrame = By.xpath("//*[@id='mod-google-dss-1']//div[@class='google-dss-frame-holder']//iframe[@name='docs_editor_frame']");
//	//*[@id=\"docs_editor_frame\"]
	By DocumentBodyFrameCss = By.cssSelector("#docs_editor_frame");
	By Title = By.xpath("//input[@class='docs-title-input']");
	By iframeCheck = By.xpath("//iframe");
	By TextBodyiframex = By.xpath("//iframe[@class='docs-texteventtarget-iframe docs-offscreen-z-index docs-texteventtarget-iframe-negative-top']");
	By TextBodyiframeCss = By.cssSelector("body > iframe.docs-texteventtarget-iframe.docs-offscreen-z-index.docs-texteventtarget-iframe-negative-top");
	By DocumentContent = By.xpath("//div[@role='textbox']");
	By HeadingStyles = By.xpath("//*[@id=\"headingStyleSelect\"]");
	By CommentBut = By.xpath("//*[@id=\"docos-stream-view\"]/div[1]/div[1]/div[2]/div[9]/div[1]");
	
	By HorizontalLine = By.xpath("//*[@id=\":7s\"]");
	By SpecialCharacter = By.xpath("//*[@id=\":80\"]");
	By SpChar1 = By.xpath("//div[contains(text(),'←')]");
	//*[@id="2wu7gr:1ac.contentEl"]/div[2]/div/div/div/div/div[1]
//	By SpChar1Css = By.cssSelector("#\\35 2en2r\\:1bb\\.contentEl > div.ita-cp-cell.ita-cp-left-cell > div > div > div > div > div:nth-child(1)");
	By SpChar2 = By.xpath("//div[contains(text(),'↑')]");
	By SpChar3 = By.xpath("//div[contains(text(),'→')]");
	By SpCharCancel = By.xpath("//div[@class='modal-dialog ita-cp-whole-pad']//span[@class='modal-dialog-title-close']");
//	/html/body/div[53]/div[1]/span[2]
	
	public DocumentHomePage(WebDriver driver) {
		super(driver);
	}
	
	public boolean DocFromFileMenu() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
		click(FileMenu);
		Thread.sleep(2000);
		try {
		HoverClickX30(NewDoc);
		}catch(Exception e){
			HoverClickX30(NewDoc2);
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
//		List<String> l = new ArrayList<>();
		while(itr.hasNext()) {
			String s= itr.next();
			driver.switchTo().window(s);
//			l.add(driver.getTitle());
//			System.out.println(l);
			if(driver.getTitle().contains("Untitled document")) {
				return true;
				
			}
			
		}
		return false;
	}
	
	public boolean DocumentCheck() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
//		try {
//			click(Title);
//			Thread.sleep(2000);
//			Actions action = new Actions(driver);
//			action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
//	        action.sendKeys(Keys.BACK_SPACE).perform();
//			Thread.sleep(2000);
//			sendkeys(Title,"Hello File New");
//			action.sendKeys(Keys.RETURN).perform();
//		
//		}catch(Exception e) {
//			System.out.println(e);
//		}
		Thread.sleep(5000);
		return isEnabled(VersionHistorySym);
		
	}
	
	@SuppressWarnings("deprecation")
	public void MakeACopyFromFileMenu() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
		click(FileMenu);
		Thread.sleep(2000);
		ActionClick(MakeACopy);		
		try {click(MakeACopyDialogue);
		}
		catch(Exception e) {
			click(MakeACopyDialogueCss);
		}
	}
	
	public boolean isDocumentLoaded() {
		SwitchToIframe(DocumentBodyFrame);
		return FluentWaitForElementEnabled(HeadingStyles);
		
	}
	
	@SuppressWarnings("deprecation")
	public void EnterText(String text) throws InterruptedException {
//		List<WebElement> elemen = WaitForElementsForFrames(iframeCheck);
//		System.out.println(elemen.size()); //7
		
		Actions action = new Actions(driver);
		SwitchToIframe(DocumentBodyFrame);
			
		try {
			SwitchToIframe(TextBodyiframex);
//			System.out.println("iframecheck pass");
		}catch(Exception e) {
			SwitchToIframe(TextBodyiframeCss);
//			System.out.println("iframecheck pass");
		}
		
		sendkeys(DocumentContent,text);	
		TimesClickEnter(3);
		driver.switchTo().defaultContent();
		
	}
	
	public void DrwaingInsert() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
		click(InsertMenu);
		Thread.sleep(2000);
		try {
			HoverClickX30(Drawingx);
		}catch(Exception e) {
			HoverClickX30(DrawingCss);
		}
		List<WebElement> elemen = WaitForElementsForFrames(iframeCheck);
		System.out.println(elemen.size()); //7
		for(WebElement ele : elemen) {
			System.out.println(ele.getAttribute("name"));
		}
		
		SwitchToIframe(DrawingFrame);
		Actions action = new Actions(driver);
		WebElement element = WaitForElementForFrame(DrawingShapeBut);
		action.moveToElement(element).click().build().perform();
		action.moveByOffset(0, 25).click().build().perform();
		Thread.sleep(2000);
		WebElement element2 = WaitForElementForFrame(DrawingShape);
		action.click(element2).build().perform();
		WebElement element3 = WaitForElementForFrame(DrawingBoard);
		action.click(element3).build().perform();
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		
		try {
			WebElement element4 = WaitForElementForFrame(DrawingSaveCloseButCss);
			action.moveToElement(element4).click().build().perform();
		}catch(Exception e) {
			WebElement element4 = WaitForElementForFrame(DrawingSaveCloseButX);
			action.moveToElement(element4).click().build().perform();
		}
		try {
			//Switching to the body for clicking enter
			SwitchToIframe(TextBodyiframex);
			TimesClickEnter(3);
		}catch(Exception e) {
			SwitchToIframe(TextBodyiframeCss);
			TimesClickEnter(3);
		}
		driver.switchTo().defaultContent();
				
	}
	
	public void InsertComment() throws InterruptedException {
		Actions action = new Actions(driver);
		SwitchToIframe(DocumentBodyFrame);
		try {
			SwitchToIframe(TextBodyiframex);
		}catch(Exception e) {
			SwitchToIframe(TextBodyiframeCss);
		}
		
		sendkeys(DocumentContent,"anil marturi");
		sendkeys(DocumentContent,"Jai Shri Ram");
		action.sendKeys(Keys.RETURN).build().perform();
//		sendkeys(DocumentContent,"anil marturi");
		WebElement element = WaitForElement(DocumentContent);
		action.doubleClick(element).click().build().perform();
		action.keyDown(Keys.CONTROL).keyDown(Keys.ALT).sendKeys("m").keyUp(Keys.CONTROL).keyUp(Keys.ALT).build().perform();
		action.sendKeys("this is the automated comment").build().perform();
		driver.switchTo().parentFrame();
		click(CommentBut);
		try {
			SwitchToIframe(TextBodyiframex);
		}catch(Exception e) {
			SwitchToIframe(TextBodyiframeCss);
		}
//		Thread.sleep(2000);
		action.moveToElement(element, 10, 10).click().build().perform();
		TimesClickEnter(3);
		driver.switchTo().defaultContent();
	}
	public void HorizontalLine() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
		click(InsertMenu);
		Thread.sleep(2000);
		click(HorizontalLine);
		TimesClickEnter(3);
		driver.switchTo().defaultContent();
		
	}
	public void SpecialCharacters() throws InterruptedException {
		SwitchToIframe(DocumentBodyFrame);
		click(InsertMenu);
		Thread.sleep(2000);
		click(SpecialCharacter);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
//		action.sendKeys("car").click().build().perform();
		click(SpChar1);		
		click(SpChar2);
		click(SpChar3);
		Thread.sleep(5000);
		WebElement el = WaitForElement(SpCharCancel);
		System.out.println("Height: " + el.getSize().getHeight());
		System.out.println("Width: " + el.getSize().getWidth());
		System.out.println("Displayed: " + el.isDisplayed());
//		click(By.xpath("(//div[@class='modal-dialog-title modal-dialog-title-draggable'])[2]"));
		
//		WebElement closeBtn = driver.findElement(By.xpath("//span[@class='modal-dialog-title-close']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeBtn);

		
		action.moveToElement(el, 5, 5).click().build().perform();
		
//		click(SpCharCancel);
		TimesClickEnter(3);
		driver.switchTo().defaultContent();	
	}
	
	
	
}
