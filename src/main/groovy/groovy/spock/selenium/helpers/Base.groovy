package groovy.spock.selenium.helpers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class Base extends Specification {

    static WebDriver driver

    WebDriver initializeDriver() {
        def prop = new Properties()
        def fis = new FileInputStream("src/main/resources/properties")
        prop.load(fis)

        prop.getProperty("browser") == "sauce" ? setSauceLabs() : otherBrowser()

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.manage().window().maximize()
        return driver
    }

    void setChrome() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe")
        driver = new ChromeDriver()
    }

    void otherBrowser() {
        throw new Exception("Other browsers are not applicable for now")
    }

    void setSauceLabs() {

        def sauceUserName = "very sensitive user name"
        def sauceAccessKey = "and very very sensitive access key"

        /**
         * In this section, we will configure our test to run on some specific
         * browser/os combination in Sauce Labs
         */
        def capabilities = new DesiredCapabilities()

        //set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", sauceUserName)

        //set your sauce labs access key
        capabilities.setCapability("accessKey", sauceAccessKey)

        //set your test case name so that it shows up in Sauce Lab)
        capabilities.setCapability("name", "cap test chrome")

        capabilities.setCapability("browserName", "Chrome")
        capabilities.setCapability("platform", "Windows 10")
        capabilities.setCapability("version", "74.0")
        capabilities.setCapability("screenResolution", "800x400")

        driver = new RemoteWebDriver(new URL("http://ondemand.eu-central-1.saucelabs.com:80/wd/hub"), capabilities)
    }

}