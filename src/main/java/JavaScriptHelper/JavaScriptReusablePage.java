package JavaScriptHelper;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import net.serenitybdd.core.pages.PageObject;

public class JavaScriptReusablePage extends PageObject {

	WaitPage waitPage;

	public JavaScriptReusablePage(WebDriver driver) {
		super(driver);
		waitPage = new WaitPage(driver);
	}

	/**
	 * Java Script Reusable Action
	 */

	public boolean getReadOnlyStatus(String idProperty) {

		return (Boolean) evaluateJavascript("return document.getElementById('" + idProperty + "').readOnly");
	}

	public boolean getReadAndWriteStatus(String idProperty) {

		return !(Boolean) evaluateJavascript("return document.getElementById('" + idProperty + "').readOnly");
	}

	public boolean getPresenceOfElement(String idProperty) {
		Object status = evaluateJavascript("return document.getElementById(\"" + idProperty + "\")");
		if (status == null)
			return false;
		else
			return true;
	}

	public boolean getPresenceOfElementCss(String cssSelector) {
		try {
			Object status = evaluateJavascript("return document.querySelector(\"" + cssSelector + "\")");
			if (status == null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getAttributeUsingXpath(String xPath, String attribute) {

		return (String) evaluateJavascript("return document.evaluate(\"" + xPath
				+ "\", document, null, XPathResult.ANY_TYPE, null).iterateNext().attributes['" + attribute
				+ "'].value");

	}

	public boolean getPresenceOfElementXpath(String xPath) {
		try {
			Object status = evaluateJavascript("return document.evaluate(\"" + xPath
					+ "\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue");
			if (status == null)
				return false;
			else
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean getInvisibleStatus(String idProperty) {
		String type = (String) evaluateJavascript("return document.getElementById('" + idProperty + "').type");
		if ((type != null) && (type.equalsIgnoreCase("hidden")))
			return true;
		else
			return false;
	}

	public boolean getDisabledStatus(String idProperty) {
		return (Boolean) evaluateJavascript("return document.getElementById('" + idProperty + "').disabled");
	}

	public boolean getCheckedStatus(String idProperty) {
		return (Boolean) evaluateJavascript("return document.getElementById('" + idProperty + "').checked");
	}

	public boolean getCheckedStatusUsingSelector(String cssSelector) {
		return (Boolean) evaluateJavascript("return document.querySelector(\"" + cssSelector + "\").checked");
	}

	public String getValue(String idProperty) {
		return (String) evaluateJavascript("return document.getElementById('" + idProperty + "').value");
	}

	public String setandgetValue(String idProperty, String value) {
		return (String) evaluateJavascript("document.getElementById('" + idProperty + "').value='" + value + "'");
	}

	public void setValue(String idProperty, String value) {
		evaluateJavascript("document.getElementById('" + idProperty + "').value='" + value + "'");
	}

	public void setValueclass(String xpathProperty, String value) {
		evaluateJavascript("document.getElementByXpath('" + xpathProperty + "').value='" + value + "'");
	}

	public void setKendoTextBoxValue(String cssProperty, String value) {
		System.out.println("$(\"" + cssProperty + "\").val(\"" + value + "\").change();");
		evaluateJavascript("$(\"" + cssProperty + "\").val(\"" + value + "\").change();");
	}

	public void clickElement(String idProperty) {
		evaluateJavascript("document.getElementById('" + idProperty + "').click()");
	}

	public void clickElements(String element) {
		evaluateJavascript(element);
	}

	public Object getkElements(String element) {
		return evaluateJavascript(element);
	}

	public void clickCSSElement(String cssSelector) {
		evaluateJavascript("document.querySelector(\"" + cssSelector + "\").click();");
	}

	public void clickXPathElement(String xpath) {
		evaluateJavascript("document.evaluate (\"" + xpath
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
	}

	public void clickElement(WebElement element) {
		evaluateJavascript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", element);
	}

	public void scrollTop() {
		evaluateJavascript("$(document).scrollTop(0)");
	}

	public void scrollToView(WebElement element) {
		evaluateJavascript("arguments[0].scrollIntoView(true);", element);
		evaluateJavascript("arguments[0].click();", element);
	}

	public void removeReadonlyAttribute(WebElement element) {
		evaluateJavascript("arguments[0].removeAttribute('readonly','readonly')", element);
	}

	public void removeAriaReadonlyAttribute(WebElement element) {
		evaluateJavascript("arguments[0].setAttribute('aria-readonly','false')", element);
	}

	public boolean getAraiReadOnlyAttribute(String idProperty) {
		String status = (String) evaluateJavascript(
				"return document.getElementById('" + idProperty + "').getAttribute('aria-readonly')");
		return Boolean.parseBoolean(status);
	}

	public void zoom(int zoomPercentage) {
		evaluateJavascript("document.body.style.zoom = '" + zoomPercentage + "%';");
	}

	public void mouseHover(WebElement targetElement) {
		scrollToView(targetElement);
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		evaluateJavascript(javaScript, targetElement);
	}

	public void doubleClick(WebElement targetElement) {
		String javaScript = "var evt = new Event('dblclick');\r\n" + "arguments[0].dispatchEvent(evt);";
		evaluateJavascript(javaScript, targetElement);
	}

	public String getClassName(String idProperty) {
		return (String) evaluateJavascript(
				"return document.getElementById('" + idProperty + "').getAttribute('class')");
	}

	public String getAttributeUsingId(String id, String attribute) {
		return (String) evaluateJavascript(
				"return document.getElementById('" + id + "').getAttribute('" + attribute + "')");
	}

	public String getAttributeWithCssSelector(String cssSelector, String attribute) {
		return (String) evaluateJavascript(
				"return document.querySelector(\"" + cssSelector + "\").getAttribute('" + attribute + "')");
	}

	public boolean getDisabledStatusCssSelector(String selector) {

		return (Boolean) evaluateJavascript("return document.querySelector(\"" + selector + "\").disabled");
	}

	public String getInnerText(String idProperty) {

		return (String) evaluateJavascript("return document.getElementById('" + idProperty + "').innerText");
	}

	public String getInnerTextBySelector(String selector) {

		return (String) evaluateJavascript("return document.querySelector(\"" + selector + "\").innerText");
	}

	public String clickBySelector(String selector, int row) {

		return (String) evaluateJavascript(
				"return document.querySelectorAll(\"" + selector + "\")[" + row + "].click();");
	}

	public String getInnerTextBySelector(String selector, int row) {

		return (String) evaluateJavascript(
				"return document.querySelectorAll(\"" + selector + "\")[" + row + "].innerText");
	}

	public String getInnerTextByXpath(String xpath) {
		return (String) evaluateJavascript("return document.evaluate(\"" + xpath
				+ "\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.innerText");
	}

	public String getReadOnlyAttributeByXpath(String xpath) {
		return (String) evaluateJavascript("return document.evaluate(\"" + xpath
				+ "\",document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.getAttribute('readonly')");
	}

	public void doubleClick_Element(String cssSelector) {
		evaluateJavascript("$(\"" + cssSelector + "\").dblclick()");
	}

	public String getValueByCss(String cssSelector) {
		return (String) evaluateJavascript("return document.querySelector(\"" + cssSelector + "\").value");
	}

	public long getListOfElementsSize(String cssSelector) {

		return (long) evaluateJavascript("return $(\"" + cssSelector + "\").size();");
	}

	public long getListOfElementsLength(String cssSelector) {

		return (long) evaluateJavascript("return $(\"" + cssSelector + "\").length;");
	}

	public String getMessage() {
		String script = "var a = $(\"gps-dlg-htmlcontent\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].innerText;\r\n" + "  }\r\n" + "return e;";
		return (String) evaluateJavascript(script);
	}

	public String IsReadOnly(String element) {
		String script = "var a = $(\"" + element + "\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].readOnly;\r\n" + "  }\r\n" + "return e;";
		System.out.println(script);
		return (String) evaluateJavascript(script).toString();
	}

	public String Isdisabled(String element) {
		String script = "var a =$(\"" + element + "\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].disabled;\r\n" + "  }\r\n" + "return e;";
		System.out.println(script);
		return (String) evaluateJavascript(script).toString();
	}

	public String IsDisplayed(String element) {
		String script = "var a =$(\"" + element + "\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].type;\r\n" + "  }\r\n" + "return e;";
		System.out.println(script);
		return (String) evaluateJavascript(script).toString();
	}

	public String Ishidden(String element) {
		String script = "var a =$(\"" + element + "\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].hidden;\r\n" + "  }\r\n" + "return e;";
		System.out.println(script);
		return (String) evaluateJavascript(script).toString();
	}

	public String winningDate(String element) {
		String script = "var a =$(\"" + element + "\");\r\n" + "var e;\r\n" + "for(var i=0;i<a.length;i++){\r\n"
				+ "   e=a[i].placeholder;\r\n" + "  }\r\n" + "return e;";
		System.out.println(script);
		return (String) evaluateJavascript(script).toString();
	}

	public void setAttribute(String xPath) {
		evaluateJavascript(
				"document.evaluate(\"" + xPath + "\",document.body, null, XPathResult.ANY_TYPE, null).value = '\\t';");
		evaluateJavascript("document.evaluate(\"" + xPath
				+ "\",document.body, null, XPathResult.ANY_TYPE, null).dispatchEvent(pressTabKey)");
		evaluateJavascript("document.evaluate(\"" + xPath + "\".setAttribute('target', 'self');");
		clickXPathElement(xPath);
	}

	public void scrollDown() {
		evaluateJavascript("window.scrollBy(0,350)", "");
	}

	public void scrollBottom() {
		evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
		element(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
	}

	public void scrollUp() {
		evaluateJavascript("window.scrollTo(0,500)");
		evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
		element(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.UP);
	}

	public void zoomOut() {
		evaluateJavascript("document.body.style.zoom = '0.8'");
	}

	public void dropFile(File filePath, WebElement target, int offsetX, int offsetY) {
		if (!filePath.exists())
			throw new WebDriverException("File not found: " + filePath.toString());

		JavascriptExecutor jse = (JavascriptExecutor) getDriver();

		String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2]," + "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');"
				+ "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };" + ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};"
				+ "document.body.appendChild(input);" + "return input;";

		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
		input.sendKeys(filePath.getAbsoluteFile().toString());
	}
	
	public void clickDynamicXPathElement(String baseXPath, String dynamicString) {
		try {
		    String dynamicXPath = String.format(baseXPath, dynamicString);
		    evaluateJavascript("document.evaluate (\"" + dynamicXPath +
		            "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();");
		}
		catch(StaleElementReferenceException e) {
			
		}
	}
	
	public void clickTabKey() {
		Actions action =new Actions(getDriver());
	       action.sendKeys(Keys.TAB).build().perform();
	}
}
