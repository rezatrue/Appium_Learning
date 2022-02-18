import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Swipe extends Base{

	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Let's -- Swipe...");
		
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		driver.findElementByXPath("//*[@content-desc='10']").click();
		
		TouchAction touchAction = new TouchAction(driver);
		LongPressOptions longPressOptions = new LongPressOptions();
		ElementOption elementOption = new ElementOption();
		 
		WebElement firstElement = driver.findElementByXPath("//*[@content-desc='45']");
		WebElement secondElement = driver.findElementByXPath("//*[@content-desc='15']");
		touchAction.longPress(longPressOptions.withElement(elementOption.withElement(firstElement))
				.withDuration(Duration.ofSeconds(2))).moveTo(elementOption.withElement(secondElement)).release();
		
		
	}
}
