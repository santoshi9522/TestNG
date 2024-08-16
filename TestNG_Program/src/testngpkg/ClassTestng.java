package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassTestng 
{
	public WebDriver d;
	  public WebElement srch;
	  public WebElement sbtn;
	  public WebElement a;
	public WebElement cart;
	  
	@AfterTest
	  public void link ()
	  {
		  List <WebElement> m1 = d.findElements(By.tagName("a"));
		  System.out.println("The links present on the page is " +m1.size());
	  }
	  @Test (priority=3)
	  public void mble()
	  {
		a = d.findElement(By.xpath("//*[@id=\'search\']/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div/div[2]/div[1]/h2/a/span"));
	    a.click();	
	    d.navigate().back();
	  }
	   
	  @Test (priority=2) 
	  public void search() throws InterruptedException
	  {
		srch = d.findElement(By.xpath("//*[@id=\'twotabsearchtextbox\']"));
		srch.sendKeys("mobile");
		
		sbtn = d.findElement(By.xpath("//*[@id=\'nav-search-bar-form\']/div[3]/div"));
		srch.submit();	
	  }
	  @Test (priority=4)
	  public void fail ()
	  {
		 cart = d.findElement(By.xpath("//*[@id=\"nav-cart-count-container\"]/span[2]"));
		 cart.click();
		//*[@id="nav-cart-count-container"]/span[2]
	  }
	
	  @Test (priority=1)
	  public void launchsite()
	  {
		  d.get("https://www.amazon.com/");
		  d.manage().window().maximize();	  
	  }
	  
	  
	  
	  
	  @BeforeTest
	  public void setup ()
	  {
		  ChromeOptions co = new ChromeOptions ();
			co.addArguments("--remote-allow-origins=*");
		  WebDriverManager.chromedriver().setup();
		  
		  ChromeOptions opt = new ChromeOptions();
	       opt.addArguments("--disable-notification");
	       
		  d = new ChromeDriver(co);
		  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(120)); 
	  }

	
	
	
	
	
	
	
  }
