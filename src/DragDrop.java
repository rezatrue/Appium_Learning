import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragDrop extends Base{
	
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Drag & Drop .......");
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		TouchAction touchAction = new TouchAction(driver);
		WebElement source = driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination = driver.findElementsByClassName("android.view.View").get(1);
		LongPressOptions longPressOptions = new LongPressOptions();
		ElementOption elementOption = new ElementOption();
		
//		touchAction.longPress(longPressOptions.withElement(elementOption.element(source)))
//		.moveTo(elementOption.element(destination)).release().perform();
		
		touchAction.longPress(elementOption.element(source))
		.moveTo(elementOption.element(destination)).release().perform();
		
	}
	
}
