
	package Driver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
	

	
public String getReportConfigPath(){
	Properties prop = new Properties();
	InputStream input = null;
	try
	{
		prop.load(getClass().getClassLoader().getResourceAsStream("/Users/Jayabrata/Documents/workspace/Owners_App_BDD/src/test/resources/PropertyFiles/Configuration.properties"));
        String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		

	}
	catch (IOException io) {
		io.printStackTrace();
	}finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	return null;
	
}
}