import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {
	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver;

		DesiredCapabilities cap= new DesiredCapabilities();

		File appDir = new File("src");

		File app = new File(appDir, "ApiDemos-debug.apk");
		
		if(device.contains("emulator"))
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Ali-Pixel-2-XL-API-30");
		if(device.contains("real"))
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		// Android 5 & lower uiautomator1 and for higher uiautomator2
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator1"); 

		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
	}
}
