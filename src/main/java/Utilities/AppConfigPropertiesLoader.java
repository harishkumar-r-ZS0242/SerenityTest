package Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfigPropertiesLoader {
	public String applicationURL = null;
	private static AppConfigPropertiesLoader _myInstance = null;
	public AppConfigPropertiesLoader() {

	Properties appConfigPropertySet = new Properties();
	
	try{

		// read properties file
		InputStream appConfigPropertyStream = AppConfigPropertiesLoader.class.getResourceAsStream("/Config/appConfig.properties");
		appConfigPropertySet.load(appConfigPropertyStream);
		 applicationURL = appConfigPropertySet.getProperty("ApplicationURL");
		 System.out.println("##########  App URL "+ applicationURL);
		appConfigPropertyStream.close();

	} catch (IOException e) {
		e.printStackTrace();
}}
	public static AppConfigPropertiesLoader getInstance() {
		if (_myInstance == null) {
			_myInstance = new AppConfigPropertiesLoader();
		}
		return _myInstance;
	}	
}