package functions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
//import com.kms.katalon.core.util.KeywordUtil as KeywordUtil


public class CustomKeywords
{
	KeywordLogger log = new KeywordLogger()

	@Keyword
	public void invokeApp(String sURL){
		WebUI.openBrowser('')

		WebUI.navigateToUrl(sURL)
	}


	@Keyword
	public void ClickDroupdownItem(TestObject object){
		WebUI.mouseOver(findTestObject(object))
	}

	@Keyword
	public void clickElement(TestObject object){
		WebElement element = WebUiBuiltInKeywords.findWebElement(object);
		element.click()
	}

	@Keyword
	public void CloseApplication(){
		WebUI.closeBrowser()
	}

	@Keyword

	public void List(List<String> lsValues, String sValue){
		for(int i=0;i<=lsValues.size()-1;i++){
			if (lsValues[i]==sValue){
				println lsValues[i]
				println i+1
			}else{

				log.logError((lsValues[i] + ' is not same with ') + sValue)

			}
		}
	}

	@Keyword

	public void PartialList(List<String> lsValues, String sValue, int iPos){

		for(int i=0;i<=lsValues.size()-1;i++){
			if (lsValues[i]=~sValue){
				iPos=i+1
				println lsValues[i]
				int result =println iPos
			}else{

				log.logError((lsValues[i] + ' is not same with ') + sValue)

			}
		}
	}
}


