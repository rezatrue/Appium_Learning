import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Scroll extends Base{

	public static void main(String[] args) throws MalformedURLException {
		System.out.println(" --- Scrolling ------ ");
		
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		// Scroll
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Lists\"));");
		 
		
	}

}
