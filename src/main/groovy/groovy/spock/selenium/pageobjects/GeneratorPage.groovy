package groovy.spock.selenium.pageobjects

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GeneratorPage {

    WebDriver driver

    @FindBy(xpath = "//h1")
    WebElement pageTitle

    @FindBy(xpath = "//blockquote/p")
    WebElement pageDescription

    @FindBy(xpath = "//*[@id='i']")
    WebElement quantityDropdown

    GeneratorPage(WebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    WebElement setQuantity(number) {
        return quantityDropdown.findElement(By.xpath("//*[@id='i']//option[@value='$number']"))
    };

}