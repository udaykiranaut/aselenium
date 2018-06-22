package drag_drop_action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop1 {

	static WebDriver driver;
	/*public static void scrollIntoView(WebElement element ,WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}*/
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\01 for testing\\selenium web drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com");
		driver.findElement(By.linkText("Draggable")).click();
		
//		WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(),'Visual feedback')]"));
//		DragAndDrop1.scrollIntoView(ele1, driver);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions act1 = new Actions(driver);
		act1.dragAndDropBy(draggable, 100, 100).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Droppable")).click();
		driver.switchTo().frame(0);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act1.dragAndDrop(source, target).build().perform();
		System.out.println("end");
		
	}

}
