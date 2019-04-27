package groovy.spock.selenium.specs

import groovy.spock.selenium.helpers.BaseSpec
import groovy.spock.selenium.pageobjects.GeneratorPage

class GeneratorSpec extends BaseSpec {

    static def URL = "http://www.miraclesalad.com/webtools/random.php"
    def generatorPage = new GeneratorPage(driver)

    def setupSpec() {
        driver.get(URL)
    }

    def "Number Generator should have a title"() {
        when:
        def title = generatorPage.pageTitle.text

        then:
        println("Page title is = " + title)
        title == "Random Number Generator"
    }

    def "Number Generator should have a description"() {
        when:
        def description = generatorPage.pageDescription.text

        then:
        description == "This is a simple random number generator. Hit refresh after you \"Go\" to get a new list of random numbers or hit Go again."
    }

    def "Number Generator should generate a number between selected limits in a group"(){

        //will be edited
        when:
        generatorPage.setQuantity(4).click()
        generatorPage.setQuantity(2).click()
        generatorPage.setQuantity(1).click()
        generatorPage.setQuantity(3).click()
        generatorPage.setQuantity(5).click()
        generatorPage.setQuantity(6).click()
        generatorPage.setQuantity(3).click()
        generatorPage.setQuantity(2).click()
        generatorPage.setQuantity(1).click()
        generatorPage.setQuantity(4).click()
        generatorPage.setQuantity(5).click()
        generatorPage.setQuantity(6).click()

        then:
        println("okay")

    }

}
