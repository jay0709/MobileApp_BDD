/**
* 
*/
package Driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author jayabrata
 *
 */
//@Parameters({"port","device"})
public class desiredCapabilities {
	public static AppiumDriver<MobileElement> driver ;
    public static WebDriverWait wait;
    PropertyData prop = new PropertyData();
    //public  String username = "isaacindeevervem1";
	//public static String accessKey = "8sxjEpfRKJaw84cfA8Kb";
    
	public  String username = "syedmehdi2";
	public static String accessKey = "4BpkRSWcgPrG4ywH9V6S";
	
	String app = "bs://b3f49767bf61e651a62a70f5e914386914ef796a"; 
	String appiOS = "bs://07a33c9c802e1d55904f4268c08c946634c90ff4";
	
	
	
	public void BrowserStack() throws MalformedURLException,InterruptedException
	{
    	if(prop.platformName.equalsIgnoreCase("Android"))
    	{
    		final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Google Nexus 6");
    	capabilities.setCapability("os_version", "6.0");
        capabilities.setCapability("app", "MyApp");
        capabilities.setCapability("browserstack.debug", "true");
        capabilities.setCapability("automationName", "Appium");
    	   driver = new AndroidDriver<MobileElement>(new URL("https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
    	   wait = new WebDriverWait(driver, 20);
    	   System.out.println("Initialize: "+driver);
    	}
    	else
    	{	
    		final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "iPhone 7 Plus");
    	capabilities.setCapability("os_version", "10.3");
    	capabilities.setCapability("app", appiOS);
        capabilities.setCapability("browserstack.debug", "true");
         driver = new IOSDriver<MobileElement>(new URL("http://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), capabilities);
     }

}

    public void SetDesiredCapabilities() throws MalformedURLException, InterruptedException {
    	
    	if(prop.platformName.equalsIgnoreCase("Android"))
    	{	
    		final File appDir = new File("/Users/Jayabrata/Downloads/Automation/App");
    	    final File app = new File(appDir,"app-snapshot.apk");
    		final DesiredCapabilities capabilities = new DesiredCapabilities();
            
    	capabilities.setCapability("deviceName", "OnePlus2");
    	//capabilities.setCapability("udid", "8775bef9");
    	//capabilities.setCapability("platformVersion", "6.0.1");
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("app", app.getAbsolutePath());
    	capabilities.setCapability("appPackage", "com.owners.buyer");
    	capabilities.setCapability("appActivity", "com.owners.buyer.MainActivity");
    	driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	//driver = new AndroidDriver<MobileElement>(new URL("http://localhost:"+port+"/wd/hub"), capabilities);
        wait = new WebDriverWait(driver, 20);
    	System.out.println("Initialize: "+driver);
    	}
    	else
    	{
    	    final File appDir = new File("/Users/syedzubair/Desktop");
    	    final File app = new File(appDir,"Owners_final.ipa");
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "iPhone5");
            //capabilities.setCapability("deviceName", "iPhone Simulator");
            capabilities.setCapability("platformName", "iOS");
            capabilities.setCapability("platformVersion", "11.3");
            //capabilities.setCapability("platformVersion", "11.1");
            capabilities.setCapability("udid", "fc1650f37d318a2b3c0399db133ff76209c5a6bc");
            //capabilities.setCapability("udid", "66b0c7f772fccab38d99ac18199f2e33cd86eaad");
            capabilities.setCapability("app", app.getAbsolutePath());
            capabilities.setCapability("bundleId", "com.Owners.Owners.com");
            capabilities.setCapability("automationName", "XCUITest");
            //capabilities.setCapability("useNewWDA", true);

             driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
                   capabilities);
    	}
    	}
	
	
	public void iPhone5() throws MalformedURLException, InterruptedException {
		final File appDir = new File("/Users/syedzubair/Desktop");
	    final File app = new File(appDir,"Owners.ipa"); 
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone5");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "11.0");
        capabilities.setCapability("udid", "fc1650f37d318a2b3c0399db133ff76209c5a6bc");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("bundleId", "com.Owners.Owners.com");
        capabilities.setCapability("automationName", "XCUITest");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
               capabilities);
     }
	



	
	public AppiumDriver<MobileElement> getAndroidDriver() {
		return driver;
	}

	public WebDriverWait getWebDriverWait() {
		return wait;
	}
}
