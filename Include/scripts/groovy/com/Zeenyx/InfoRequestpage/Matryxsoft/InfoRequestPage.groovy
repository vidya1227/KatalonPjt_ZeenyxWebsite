package com.Zeenyx.InfoRequestpage.Matryxsoft
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject


class InfoRequestPage {

	WebDriver driver = DriverFactory.getWebDriver()

	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("I want to set text")
	def EnterDetails(String Txt_FirstName ,String Txt_SecondName ,String Txt_CompanyName, String Txt_Zipcode ){
		//String Txt_FirstName = "vidya"
		//String Txt_SecondName = "Shri"
		//String Txt_CompanyName ="Matryxsoft"
		//String Txt_ZipCode ="560094"
		WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_FirstName'), findTestData("New Test Data").getValue(1, 1))

		WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_LastName'), findTestData("New Test Data").getValue(2, 1))


		WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_CompanyName'), findTestData("New Test Data").getValue(3, 1))


		WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_ZipCode'), findTestData("New Test Data").getValue(4, 1))

	}


	@Then("Compare and Click on Specified State")
	def CompareAndClick() {

		Integer iNo_States = WebUI.getNumberOfTotalOption(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Pop_State'))

		String sSearchState = 'WA'


		KeywordLogger log = new KeywordLogger()

		for (int i = 1; i <= iNo_States; i++) {
			String sState = driver.findElement(By.xpath(('//*[@id="State"]/option[' + i) + ']')).getText()

			if (sState == sSearchState) {
				println((sState + ' is same with ') + sSearchState)

				WebUI.selectOptionByIndex(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Pop_State'), i - 1)

				break
			} else {
				log.logError((sState + ' is not same with ') + sSearchState)
			}
		}
		WebUI.click(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Rbn_RequestType'))

		WebUI.click(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Chk_FirstTimeContact'))
	}


}