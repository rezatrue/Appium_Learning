import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;


public class Gestures extends Base{
	
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Hello .appium.... Gestures...");
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement viewElement = null;
		try {
			viewElement = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
			viewElement.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));");
			viewElement = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
			viewElement.click();
		}
		
		
		//Tap
		TouchAction<?> touchAction = new TouchAction<>(driver);
		TapOptions tapOp = new TapOptions();
		ElementOption elementOption = new ElementOption();
		WebElement element = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		touchAction.tap(tapOp.withElement(elementOption.element(element))).perform();
		
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		// Log Press
		LongPressOptions longPressOptions = new LongPressOptions();
		element = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		
		
		touchAction.longPress(
				longPressOptions.withElement(
						elementOption.element(element)).withDuration(Duration.ofSeconds(2)))
												.release().perform();
		
//		touchAction.longPress(
//				longPressOptions.withElement(
//						elementOption.element(element)).withDuration(Duration.ofSeconds(2)))
//												.release().perform();
		
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		

	}

}
