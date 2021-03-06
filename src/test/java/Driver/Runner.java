package Driver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"},		
features = {"/Users/Jayabrata/Documents/workspace/Owners_App_BDD/src/test/resources/features/DiscoverTab.feature"},
tags= {"~@Sanity","@Regression"},
//tags= {"@Notes"},
monochrome = true
 )
public class Runner {
	
	@BeforeClass
	public static void setup() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("target/cucumber-reports/"+timeStamp.replace(":","_").replace(".","_")+".html");
	}
	

	@AfterClass
	public static void writeExtentReport() {
		
		Reporter.loadXMLConfig(new File("/Users/Jayabrata/Documents/workspace/Owners_App_BDD/target/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	  }
	}

	



/* 
 Jenkins
/var/lib/jenkins/workspace/cucumberMobileApp/CucumberReports
 /var/lib/jenkins/workspace/cucumberMobileApp/src/test/resources/features
  /var/lib/jenkins/workspace/cucumberMobileApp/target/extent-config.xml    -- doubt 
  */

/* local
 target/cucumber-reports/
 target/cucumber-reports/report.html
 /Users/syedzubair/Desktop/BDD_IOS_workspace/Owners_App_BDD/src/test/resources/features
  /Users/syedzubair/Desktop/Cucumber Reports
  /Users/syedzubair/Desktop/BDD_IOS_workspace/Owners_App_BDD/target/extent-config.xml

   */
