package TestProject.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class TestShaadi {
 
    String CSV_PATH = "C:\\Users\\RIL-LT-NEW\\eclipse-workspace\\AssignmentSaurabh\\Resources\\TestData.csv";
    WebDriver driver;
    private CSVReader csvReader;
    String[] csvCell;
 
    @BeforeTest
    public void setup() throws Exception {
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\RIL-LT-NEW\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.gujaratishaadi.com/");
    }
 
    @Test
    public void test() throws IOException, DocumentException {
        //Create an object of CSVReader
        csvReader = new CSVReader(new FileReader(CSV_PATH));
        File inputFile = new File(System.getProperty("user.dir") +"\\properties.xml");
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputFile);
        String letsBeginxpath = document.selectSingleNode("//panel1/letsBeginxpath").getText();							
        String emailXpath = document.selectSingleNode("//panel1/emailXpath").getText();							
        String passwordXpath = document.selectSingleNode("//panel1/passwordXpath").getText();	
        String createProfileforDropdownXpath = document.selectSingleNode("//panel1/createProfileforDropdownXpath").getText();							
        String nextButtonXpath = document.selectSingleNode("//panel1/nextXpath").getText();							
        String mothertongue = document.selectSingleNode("//panel1/mothertongue").getText();
        String brotherItem = document.selectSingleNode("//panel1/brotherItem").getText();
        try {
			while ((csvCell = csvReader.readNext()) != null) {
			String emailId = csvCell[0];
			String password = csvCell[1];
			
			driver.findElement(By.xpath(letsBeginxpath)).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath(emailXpath)).sendKeys(emailId);
			Thread.sleep(1000);
			driver.findElement(By.xpath(passwordXpath)).sendKeys(password);
			Thread.sleep(1000);
			driver.findElement(By.xpath(createProfileforDropdownXpath)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(brotherItem)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(nextButtonXpath)).click();
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath(mothertongue)).getText();
			System.out.println(text);
			Thread.sleep(1000);
			}
		} catch (CsvValidationException | IOException | InterruptedException e) {
			e.printStackTrace();
		}
    }
 
    @AfterTest
    public void exit() {
        driver.close();
        driver.quit();
    }
}
