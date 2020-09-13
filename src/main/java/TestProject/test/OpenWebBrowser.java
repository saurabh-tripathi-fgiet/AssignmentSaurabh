package TestProject.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebBrowser {

	 public static void main(String[] args) {
		 
			System.setProperty("webdriver.chrome.driver","C:\\Users\\RIL-LT-NEW\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	        String baseUrl = "https://www.google.co.in/";
	        String expectedTitle = "Google";
	        String actualTitle = "";	        
	        driver.get(baseUrl);
	        actualTitle = driver.getTitle();
	        if (actualTitle.contentEquals(expectedTitle)){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	        }
//	        driver.close();
	    }
}

