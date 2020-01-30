import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
//import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
//import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebDriver driver = DriverFactory.getWebDriver()

WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_FirstName'), FirstName)

WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_LastName'), SecondName)

WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_CompanyName'), CompanyName)

WebUI.setText(findTestObject('Zeenyx/Zeenyx InformationRequest_Page/Txt_ZipCode'), ZipCode)

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




