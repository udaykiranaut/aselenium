package select_class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select1 {

	public static void main(String[] args) 
	{
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver","E:\\01 for testing\\selenium web drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement element_day = driver.findElement(By.id("day"));
	Select select1 = new Select(element_day);
	WebElement element_month = driver.findElement(By.id("month"));
	Select month = new Select(element_month);
	
	month.selectByIndex(9);
	WebElement element_year = driver.findElement(By.id("year"));
	Select year = new Select(element_year);
	year.selectByValue("1991");
	if(select1.isMultiple())
	{
		System.out.println(" multi_select_element");
	}else
	{
		System.out.println("not a multi select element");
	}
	select1.selectByIndex(9);
	select1.selectByIndex(7);
	
	select1.selectByValue("8");
	select1.selectByValue("10");
	
	select1.selectByVisibleText("22");
	select1.selectByVisibleText("28");
	
	List<WebElement> drop_down_day = select1.getOptions();
	
	System.out.println("No of elements in a day "  +drop_down_day.size());
	
	WebElement first_element = select1.getFirstSelectedOption();
	
	System.out.println(first_element.getText());
	driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
	
	

	}

}
