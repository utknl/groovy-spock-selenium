package groovy.spock.selenium.helpers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class Base extends Specification {

    static WebDriver driver

    WebDriver initializeDriver() {
        def prop = new Properties()
        def fis = new FileInputStream("src/main/resources/properties")
        prop.load(fis)

        prop.getProperty("browser") == "chrome" ? setChrome() : otherBrowser()

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

}