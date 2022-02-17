import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidUIAutomator extends Base{

	public static void main(String[] args) throws MalformedURLException {
System.out.println("Welcome .... to... Android UI Automator...");
		
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
		

	}
	
}
