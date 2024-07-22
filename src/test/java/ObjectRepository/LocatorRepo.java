package ObjectRepository;

import org.openqa.selenium.By;

public class LocatorRepo {
	 public static final By TXT_Id_Username= By.id("username");
	 public static final By TXT_Id_Password= By.id("password");
	 public static final String TXT_Field = "//input[@placeholder='%s']";
	 public static final String BTN_Field = "//button[@id='%s']";
	 public static final String TXT_title = "//h1[contains(text(),'%s')]";
	 public static final String BTN_Navigate = "//a[contains(text(),'%s')]";
	
}
