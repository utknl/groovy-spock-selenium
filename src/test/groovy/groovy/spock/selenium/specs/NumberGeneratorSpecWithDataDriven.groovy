package groovy.spock.selenium.specs

import groovy.spock.selenium.helpers.BaseSpec
import groovy.spock.selenium.pageobjects.GeneratorPage

class NumberGeneratorSpecWithDataDriven extends BaseSpec {

    static def URL = "http://www.miraclesalad.com/webtools/random.php"
    def generatorPage = new GeneratorPage(driver)

    def setupSpec() {
        driver.get(URL)
    }

    def "should generate numbers in stated quantities between selected limits in a group"() {
        given:
        generatorPage.setLow(low)
        generatorPage.setHigh(high)
        generatorPage.setQuantity(quantity)
        generatorPage.setGroups(1).click()

        when:
        generatorPage.goButton.click()

        then:
        def numbers = generatorPage.getGroupOutput(1).text
        def numbersToArrayList = []

        print("\n Down limit is = $low")

        numbers.split("\n").each { x ->
            numbersToArrayList.add(x as int)
            print("\n Number is = $x")
        }

        print("\n Up limit is = $high")

        and:
        numbersToArrayList.each { x ->
            assert x >= low
            assert x <= high
        }

        where:
        low | high  | quantity
        1   | 7     | 2
        56  | 67    | 3
        400 | 567   | 1
        800 | 850   | 4
        25  | 30    | 5
        123 | 200   | 6
        800 | 900   | 7
        86  | 99    | 8
        35  | 53    | 9
        1   | 22    | 10
        17  | 33    | 6
        299 | 349   | 3
        77  | 477   | 8
        89  | 96    | 6
        25  | 45    | 5
        18  | 81    | 4
        19  | 23    | 1
        19  | 38888 | 1
    }

}
