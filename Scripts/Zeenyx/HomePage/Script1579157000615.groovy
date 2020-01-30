import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

//WebUI.callTestCase(findTestCase('Common_TestCase/NavigateApplication'), [:], FailureHandling.STOP_ON_FAILURE)


WebUI.mouseOver(findTestObject('Zeenyx/ZeenyxMainPage/Lnk_CONTACT'))

WebUI.waitForElementVisible(findTestObject('null'), 5)

WebUI.click(findTestObject('null'))

Boolean bPresent = WebUI.waitForElementVisible(findTestObject('Object Repository/Zeenyx/Zeenyx InformationRequest_Page/Txt_FirstName'), 
    5)

if (bPresent == true) {
    println('Info request page is opened successfully')
} else {
    log.logError('Info request page failed to open')
}

