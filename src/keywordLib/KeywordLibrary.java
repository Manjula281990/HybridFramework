package keywordLib;

import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;



public class KeywordLibrary {
	static WebDriver driver;
	static String parentWindow;
	
	public static void controller(String methodName, String arg1, String arg2, 
			String arg3) throws NoSuchMethodException, Exception {
		Method method = KeywordLibrary.class.getDeclaredMethod(methodName, 
				String.class, String.class, String.class);
		method.invoke(KeywordLibrary.class, arg1, arg2, arg3);
	}
	
	
	public static void launchBrowser(String arg1, String arg2, String arg3) 
			throws Exception {
		if(arg1.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manjula\\Downloads\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		} else if(arg1.equals("firefox")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manjula\\Downloads\\chromedriver.exe");
				driver = new ChromeDriver();
				
			} else if(arg1.equals("firefox")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manjula\\Downloads\\chromedriver.exe");
				driver = new FirefoxDriver();
				
			} else if (arg1.equals("ie")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Manjula\\Downloads\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Invalid browser name");

		}
			driver.get(arg2);
	}
	
	public static void enterText(String arg1, String arg2, String arg3) {
		if (arg1.equals("name")){
			driver.findElement(By.name(arg2)).sendKeys(arg3);
		}
		else if(arg1.equals("id")) {
			driver.findElement(By.id(arg2)).sendKeys(arg3);
		}
		else if(arg1.equals("xpath")) {
			driver.findElement(By.xpath(arg2)).sendKeys(arg3);
		}
		
		
	}
	
		
	
	
	public static void click(String arg1, String arg2, String arg3) {
		if(arg1.equals("name")) {
		driver.findElement(By.name(arg2)).click();
		}
		else if(arg1.equals("id")) {
			driver.findElement(By.id(arg2)).click();
		}
		else if(arg1.equals("xpath")) {
			driver.findElement(By.xpath(arg2)).click();
		}
		/*else if(arg1.equals("linkText")) {
			driver.findElement(By.linkText(arg2)).click();
		} */

	}
	
	

	public static void selectDropdown(String arg1,String arg2,String arg3) {
	WebElement dd=null;
	
	if(arg1.equals("name")) {
		dd = driver.findElement(By.name(arg2));
	}
	else if(arg1.equals("id")) {
		dd=driver.findElement(By.id(arg2));
	}
	else if(arg1.equals("xpath")) {
	dd=driver.findElement(By.xpath(arg2));
		
	}
	Select obj= new Select(dd);
	obj.selectByVisibleText(arg3);
	

}
	
	/*public static void parentWindow(String arg1,String arg2,String arg3)
	{
	String parentwindow=driver.getWindowHandle();
	System.out.println(parentwindow);
	Set<String> allWindows = driver.getWindowHandles();   //gives the id of the window
	
	System.out.println(allWindows);
	for (String window:allWindows)
	{
		if(! window.equals(parentwindow)) {
			driver.switchTo().window(window);
				driver.findElement(By.xpath(arg1)).click();
	}
	driver.switchTo().window(parentwindow);
}
}*/
	
	public static void getparentWindow(String arg1,String arg2,String arg3) throws Exception
	{
		String parentWindow =driver.getWindowHandle();
		System.out.println(parentWindow);
		Thread.sleep(2000);
	}
	
	public static void switchtoWindow(String arg1,String arg2,String arg3)
	{
		Set<String> allWindows = driver.getWindowHandles();   //gives the id of the window
		
		System.out.println(allWindows);
		for (String window:allWindows)
		{
			if(! window.equals(parentWindow)) {
				driver.switchTo().window(window);
	}
		}
	}
	
	public static void switchtoParent(String arg1,String arg2,String arg3) throws Exception
	{
		driver.switchTo().window(parentWindow);	
		//Thread.sleep(1000);
	}
	
	
	

	public static void getText(String arg1, String arg2, String arg3) throws Exception {
		//Thread.sleep(2000);
		if(arg1.equals("name")) {
		System.out.println(driver.findElement(By.name(arg2)).getText());
		}
		else if(arg1.equals("id")) {
			System.out.println(driver.findElement(By.id(arg2)).getText());
		}
		else if(arg1.equals("xpath")) {
			System.out.println(driver.findElement(By.xpath(arg2)).getText());
		}
		else if(arg1.equals("linkText")) {
			System.out.println(driver.findElement(By.linkText(arg2)).getText());
		}

	}
	
	
      public static void selectItem(String arg1, String arg2, String arg3) {
    	  WebElement result=null;
    	   if(arg1.equals("name"))
    	   {
	       System.out.println(result = driver.findElement(By.name(arg2 + "[" + arg3 + "]")));
	       }
    	   else if(arg1.equals("id"))
    	   {
	       result = driver.findElement(By.id(arg2 + "[" + arg3 + "]"));
	       }
    	   else if(arg1.equals("xpath"))
    	   {
	        result = driver.findElement(By.xpath(arg2 + "[" + arg3 + "]"));
	       }
    	   else if(arg1.equals("linkText"))
    	   {
	       result = driver.findElement(By.linkText(arg2 + "[" + arg3 + "]"));
	       }
    	   result.findElement(By.tagName("a")).click();
       } 
}
	
	
	
