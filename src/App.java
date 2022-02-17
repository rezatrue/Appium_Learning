import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class App {

	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Welcome .... to... Automation...");
		
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		//android.widget.TextView[@text='Preference']
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		//android.widget.TextView[@text='3. Preference dependencies']
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		// android:id/checkbox
		driver.findElementById("android:id/checkbox").click();
		//android.widget.RelativeLayout)[2]
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementById("android:id/edit").sendKeys("Hello");
		driver.findElementById("android:id/button1").click();
		
		

	}

}
