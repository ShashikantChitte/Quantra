package Test;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestScript {
  private WebDriver driver;


  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  
      WebDriverManager.chromiumdriver().setup();
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.get("https://quantra.quantinsti.com/");
  }

  @Test
  public void verify() throws Exception {
    
      driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).clear();
      driver.findElement(By.name("email")).sendKeys("shashikantchitte1987@gmail.com");
      driver.findElement(By.name("password")).click();
      driver.findElement(By.name("password")).clear();
      driver.findElement(By.name("password")).sendKeys("abcd1234");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      Actions actions=new Actions(driver);
      actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Browse Courses')]"))).perform();
      WebElement selectCourse=driver.findElement(By.xpath("//span[contains(text(),'Sentiment Analysis in Trading')]"));
      selectCourse.click();
      driver.findElement(By.xpath("//h1[contains(text(),'Learning Track: Sentiment Analysis in Trading')]")).getText();
      driver.findElement(By.xpath("//span[contains(text(),'22575')]")).getText();
      driver.findElement(By.xpath(" //button[@class='vue-ui-button btn button tertiary']")).click();
      int coursesCount= driver.findElements(By.xpath("//h5[@class='cart-item-title']")).size();
      String s= driver.findElement(By.xpath("//a[@class='link router-link-exact-active router-link-active']//span[@class='cart-count']")).getText();
      int cartCount=Integer.parseInt(s);
      Assert.assertEquals(coursesCount, cartCount);
      String baseAmount= driver.findElement(By.cssSelector("div.cart-summary-item:nth-child(3) > div.cart-summary-right")).getText();
      
      System.out.println("Base Amount is: " +baseAmount);
      String amountPayable= driver.findElement(By.cssSelector("div.cart-summary-right h5.font-bold > span:nth-child(1)")).getText();
      System.out.println("Amount Payable is: " +amountPayable);
      driver.findElement(By.linkText("View Details")).click();
      

      ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
      driver.switchTo().window(tabs.get(1));
      driver.close();
      driver.switchTo().window(tabs.get(0));
      
      driver.findElement(By.xpath("//a[contains(text(),'Remove')]")).click();
      driver.findElement(By.xpath("//span[contains(text(),'Apply Coupon')]")).click();
      
      driver.findElement(By.xpath("//input[@placeholder='Type coupon code']")).click();
      driver.findElement(By.xpath("//input[@placeholder='Type coupon code']")).clear();
      driver.findElement(By.xpath("//input[@placeholder='Type coupon code']")).sendKeys("ABC");
      driver.findElement(By.xpath("//div[@class='coupon-form__button']//span[@class='content']")).click();
      String alertBox= driver.findElement(By.xpath("//div[@class='coupon-alert-box']")).getText();
      System.out.println("Alert Message is: " +alertBox);
      driver.findElement(By.xpath("//span[contains(text(),'×')]")).click();
      driver.findElement(By.xpath("//div[@class='profile-pic-initials']")).click();
      driver.findElement(By.xpath("//ul[@class='avatar-menu']//a[contains(text(),'Logout')]")).click();
      
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

}
