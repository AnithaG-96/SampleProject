package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		
	public static WebDriver driver;

	//           BROWSER LAUNCH===chrome
    public static WebDriver chromeLaunch() {
	WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	return driver;
	}
    //Browser Launch=Edge
    public static WebDriver edgeDriver() {
    	WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
		return driver;
			}

    //Browser launch using if
   public static void browserLaunch(String browsername) {
	   if(browsername.equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		    driver=new ChromeDriver();   
	   }
	   else if(browsername.equalsIgnoreCase("edge")){
		   WebDriverManager.edgedriver().setup();
	        driver=new EdgeDriver() ;
	   }
   }    
    
	//          URL LAUNCH
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
			}
	
	
	//          ImpLiCIT WAIT
	public static void impWait(int sec) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//get wait
    public static void staticWait( int millisec) throws InterruptedException {
		Thread.sleep(10);

	}
	//===================================================================================
	//         SENDKEYS
	public static void sendKeys(WebElement e,String data) {
		e.sendKeys(data);	
		
	}
	
	//     CLICK-WEBELEMENT
	
	public static void click(WebElement e) {
		e.click();
	}
	
	
	//  getTitle
	public static  String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	
	//get CurrentUrl
	public static String getCurrenturl() {
		String current =  driver.getCurrentUrl();
		return current;
	}
	
	//Quit
	public static void quit() {
		driver.quit();
			}
	

	//getAttribute("value")
	public static String getAttribute(WebElement e) {
		String a = e.getAttribute("value");
		return a;
			}
	
	
	//getAttribute("innerText")
	public static String getAttributeInner(WebElement e){
	String b = e.getAttribute("innerText");
	return b;
	}
	
	
	//getText
	public static String  getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	
	//clear
	public static void clear(WebElement e) {
		e.clear();
			}
		
		
	//moveToElement===========================================================================================
	public static void moveToElement(WebElement from) {
		Actions a=new Actions(driver);
		a.moveToElement(from).perform();
	}
	
	//dragAndDrop
	public static void dragAndDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des).perform();
					}
	
	//ContextClick
	public static void contextClick(WebElement e) {
	Actions a=new Actions(driver);
    a.contextClick(e).perform();
	}
	
	//DoubleClick
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	
	//ActionsClick
	public static void  clickAct(WebElement e) {
		Actions a=new Actions(driver);
		a.click(e).perform();
	}
	
	//clickAndHold
		public static void clickAndHold(WebElement src) {
			Actions a=new Actions(driver);
			a.clickAndHold(src);
				}
		
	//release
		public static void release(WebElement des) {
		Actions a=new Actions(driver);
		a.release(des);
		}
	
	//clickHold Release
	public static void clickAndHoldRel(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.clickAndHold(src).release(des).perform();
			}
	
	//clickholdmovetorelease
	public static  void clickMoveRelease(WebElement src,WebElement tar,WebElement des) {
		Actions a=new Actions(driver);
		a.clickAndHold(src).moveToElement(tar).release(des);
	}
	//keypress
	public static void keyPress(int input) throws AWTException {
		Robot r=new Robot();
		r.keyPress(input);
	}
	//keyRelease
	public static void keyRelease(int input) throws AWTException {
		Robot r=new Robot();
		r.keyRelease(input);
		}
	
	//SelectBy Index=======================================================================================
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	
	//select By Value
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	
	//select by visibleText
	public static void selectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	
	//ismultiple
	public static boolean isMultiple(WebElement e) {
		Select s=new Select(e);
		boolean mul = s.isMultiple();
		return mul;
		
		}
		
	//getOptions
	public static List<WebElement> getOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> options = s.getOptions();
		return options;	
	}
	
	
	//get first Selected options
	public static String getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		WebElement fs = s.getFirstSelectedOption();
		String text = fs.getText();
		return text;
	}
			
//	//GetAllSelectedOptions
	public static List<WebElement> getAllselectedOptions(WebElement e) {
		Select s=new Select(e);
		List<WebElement> sel = s.getAllSelectedOptions();
		return sel;
	}
        	
    //deselect index
	public static void deSelectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	
	//deselect value
		public static void deSelectByValue(WebElement e,String value) {
			Select s=new Select(e);
			s.deselectByValue(value);
		}
	
		//deselect visibletext
		public static void deSelectByVisibleText(WebElement e,String text) {
			Select s=new Select(e);
			s.deselectByVisibleText(text);
		}
	
	//deselectAll
		public static void deSelectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
		}
		
	//simple Alert============================================================================================--------
		public static void simpleAlert() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		
	//confirm Alert
		public static  void confirmAlert() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
					}
		
	//prompt Alert	
		public static void promptAlert(String data) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(data);
			alert.accept();
			
					}
		
	//         SENDKEYS alert
		public static void sendKeysAlert(WebElement e,String data) {
			e.sendKeys(data);	
		}
	
	//Get text alert	
			public static String  GetTextAlert(WebElement e) {
				String text = e.getText();
				return text;
			}
			
	//FrameIndex-===========================================================================================================-
			public static void frameIndex(int index) {
				driver.switchTo().frame(index);
							}
			
	//Framewebelement
			public static void frameWebEle(String data) {
				driver.switchTo().frame(data);
			}
	
	//Frameid
		public static void frameid(String value) {
			driver.switchTo().frame(value);
					}
		
		
	//Default Frame	
		public static void defaultContent() {
			driver.switchTo().defaultContent();

		}
	
	//parent Frame
		public static void parentFrame() {
			driver.switchTo().parentFrame();
		}
	
	//ScreenShot=================================================================================================
		public static void screenShot(String location) throws IOException {
			TakesScreenshot t=(TakesScreenshot)driver;
			File from1 = t.getScreenshotAs(OutputType.FILE);
			File to1=new File(location);
			FileUtils.copyFile(from1,to1);
		}
	
	//getScreenShotAs
		public static void getScreenShotAs(WebElement e) {
			e.getScreenshotAs(OutputType.FILE);
		}
		
	//javaScript setAttribute	=====================================================================================
		public static void jsSetAttribute(WebElement e,String data) {
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].setAttribute('value','data')",e);
		}
		
	//javaScript click
		public static void jsClick(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()",e);
					}
		
	//javaScript Getattribute
		public static String jsGetAttribute(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			Object s = js.executeScript("return arguments[0].getAttribute('value')",e);
			String b = s.toString();
			return b;
		}
	
	//js Scrolldown
		public static void scrollDown(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true)",e);
					}
	
	//js scrollup
		public static void scrollUp(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false)",e);
		}
	
		
	//window handle=======================================================================================================
	   public static String windowHandle() {
		String ha = driver.getWindowHandle();
		return ha;
	    }
	 
	   //window handles
       public static  Set<String> windowHandles(int index) {
	   
	    Set<String> set = driver.getWindowHandles();
	    List<String>li=new ArrayList<String>();
	    li.addAll(set);
	    driver.switchTo().window(li.get(index));
	    return set;
        }

		   
	 //navigation=================================================================================================
	   public static void navigateUrl(String url) {
		driver.navigate().to(url);
	}
	   
	 //comeBack
	  public static void backNav() {
		  driver.navigate().back();
			}
			   
	//forward	   
		public static void forwardNav() {
			driver.navigate().forward();
					}   
	//refresh	   
         public static void refreshNav() {
		driver.navigate().refresh();
		}
         
	//IsDisplayed 
	   public static boolean isDisplayedNav(WebElement e) {
		   boolean displayed = e.isDisplayed();
		return displayed;
		   
			}
	 //IsEnabled
	   public static boolean isEnabledNav(WebElement e) {
		boolean enabled = e.isEnabled();
		return enabled;
	}
	   
	 //isSelected
	   public static boolean isSelectedNav(WebElement e) {
	    boolean selected = e.isSelected();
	   return selected;
	}
	   
 //excel   
		   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	  
		 
}	