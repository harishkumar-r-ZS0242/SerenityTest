package MyDriver;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import net.thucydides.core.webdriver.DriverSource;



public class DriverClass implements DriverSource  {
	@Override
	public WebDriver newDriver() {
		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--homepage=about:blank");
			options.addArguments("--test-type");
			options.addArguments("--enable-logging=stderr");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--start-maximized");
			options.addArguments("window-size=1920x1080");
			 options.addArguments("--remote-allow-origins=*");
			 // necessary for continuous integration			 
			 

			Map<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("download.default_directory", System.getProperty("java.io.tmpdir"));
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("pdfjs.disabled", true);

			options.setExperimentalOption("prefs", chromePrefs);			
			return new ChromeDriver(options);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}
