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

    @FindBy(xpath = "//*[@id='u']")
    WebElement uniqueDropdown

    @FindBy(xpath = "//*[@id='low']")
    WebElement low

    @FindBy(xpath = "//*[@id='high']")
    WebElement high

    @FindBy(xpath = "//*[@id='groups']")
    WebElement groupsDropdown

    @FindBy(xpath = "//input[@value='Go']")
    WebElement goButton

    @FindBy(xpath = "//p[@class='output']")
    List<WebElement> groupOutputs

    GeneratorPage(WebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    WebElement getGroupOutput(int number) {
        return groupOutputs.get(number - 1)
    }

    WebElement setQuantity(number) {
        return quantityDropdown.findElement(By.xpath("//*[@id='i']//option[@value='$number']"))
    };

    WebElement isUnique(Boolean val) {
        if (val) {
            return uniqueDropdown.findElement(By.xpath("//*[@id='u']//option[@value='1']"))
        } else
            return uniqueDropdown.findElement(By.xpath("//*[@id='u']//option[@value='0']"))
    }

    WebElement setLow(int val) {
        low.clear()
        return low.sendKeys(val as String)
    }

    WebElement setHigh(int val) {
        high.clear()
        return high.sendKeys(val as String)
    }

    WebElement setGroups(number) {
        return groupsDropdown.findElement(By.xpath("//*[@id='groups']//option[@value='$number']"))
    }

}