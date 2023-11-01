package selenium;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Wait {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://phptravels.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name=\"first_name\"]")).sendKeys("Anbu");
		driver.findElement(By.xpath("//input[@name=\"last_name\"]")).sendKeys("R");
		driver.findElement(By.xpath("//input[@name=\"business_name\"]")).sendKeys("customer care");
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("anbumariya1@gmail.com");
		WebElement ele1=driver.findElement(By.xpath("//span[@id=\"numb1\"]"));
		WebElement ele2=driver.findElement(By.xpath("//span[@id=\"numb2\"]"));
		String a=ele1.getText();
		String b=ele2.getText();
		int num1=0;
		for(int i=0;i<a.length();i++) {
			if(Character.isDigit(a.charAt(i))) {
				num1=num1+Character.getNumericValue(a.charAt(i));
			}
				
		}
		int num2=0;
		for( int i=0;i<b.length();i++) {
			if(Character.isDigit(b.charAt(i))) {
				num2=num2+Character.getNumericValue(b.charAt(i));
			}
				
		}
		
		 int num=num1+num2;
		 String result=String.valueOf(num);
		 driver.findElement(By.id("number")).sendKeys(result);
		 Actions builder= new Actions(driver);
		 Thread.sleep(3000);
		 WebElement ele3= driver.findElement(By.id("demo"));
		 builder.moveToElement(ele3).perform();
		 driver.findElement(By.id("demo")).click();
         String actual=" Thank you!";
         System.out.println(actual);
         String excepted =" Thank you!";
         if(actual.contains(excepted)) {
	     System.out.println("Logged in sucessfully");
         }else {
	     System.out.println("Login is unsucessful");
          }
         Thread.sleep(3000);
        TakesScreenshot screensht =((TakesScreenshot)driver);
        File source= screensht.getScreenshotAs(OutputType.FILE);
        File destination = new File("snap/thankyou.png");
        FileUtils.copyFile(source, destination);
		driver.close();
		
	}

}
