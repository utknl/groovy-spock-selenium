package groovy.spock.selenium.specs

import groovy.spock.selenium.helpers.BaseSpec
import groovy.spock.selenium.pageobjects.GeneratorPage

class NumberGeneratorSpec extends BaseSpec {

    static def URL = "http://www.miraclesalad.com/webtools/random.php"
    def generatorPage = new GeneratorPage(driver)

    def setupSpec() {
        driver.get(URL)
    }

    def "should have a title"() {
        when:
        def title = generatorPage.pageTitle.text

        then:
        println("\n Page title is = $title")
        title == "Random Number Generator"
    }

    def "should have a description"() {
        when:
        def description = generatorPage.pageDescription.text

        then:
        println("\n Page description is = $description")
        description == "This is a simple random number generator. Hit refresh after you \"Go\" to get a new list of random numbers or hit Go again."
    }

    def "should generate a number between selected limits in a group"() {
        given:
        generatorPage.setLow(2)
        generatorPage.setHigh(6)
        generatorPage.setQuantity(1).click()
        generatorPage.setGroups(1).click()

        when:
        generatorPage.goButton.click()

        then:
        def number = generatorPage.getGroupOutput(1).text as int
        print("\n Number is = $number")
        number >= 2
        number <= 6
    }

    def "should generate numbers in stated quantities between selected limits in a group"() {
        given:
        generatorPage.setQuantity(10).click()
        generatorPage.setLow(20)
        generatorPage.setHigh(1000)
        generatorPage.setGroups(1).click()

        when:
        generatorPage.goButton.click()

        then:
        def numbers = generatorPage.getGroupOutput(1).text

        and:
        print("\n Down limit is = 20")

        def numbersToArrayList = []
        numbers.split("\n").each { x ->
            numbersToArrayList.add(x as int)
            print("\n Number is = $x")
        }

        print("\n Up limit is = 1000")

        numbersToArrayList.each { x ->
            assert x >= 20
            assert x <= 1000
        }
    }

    def "should generate unique numbers in stated quantities between selected limits in a group"() {
        given:
        generatorPage.setQuantity(8).click()
        generatorPage.setLow(200)
        generatorPage.setHigh(6000)
        generatorPage.setGroups(1).click()

        when:
        generatorPage.goButton.click()

        then:
        def numbers = generatorPage.getGroupOutput(1).text
        def numbersToArrayList = []
        numbers.split("\n").each { x -> numbersToArrayList.add(x as int) }

        and:
        def uniqueList = numbersToArrayList.toSet()
        uniqueList.each { x -> print("\n Unique number is = $x") }
        uniqueList.size() == 8
    }

    def "should generate numbers in stated quantities for selected groups"(){
        given:
        generatorPage.setQuantity(6).click()
        generatorPage.setGroups(6).click()

        when:
        generatorPage.goButton.click()

        then:
        def group1 = generatorPage.getGroupOutput(1).text
        print("\n Group 1 : \n $group1")
        group1.split("\n").size() == 6

        def group2 = generatorPage.getGroupOutput(2).text
        print("\n Group 2 : \n $group2")
        group1.split("\n").size() == 6

        def group3 = generatorPage.getGroupOutput(3).text
        print("\n Group 3 : \n $group3")
        group1.split("\n").size() == 6

        def group4 = generatorPage.getGroupOutput(4).text
        print("\n Group 4 : \n $group4")
        group1.split("\n").size() == 6

        def group5 = generatorPage.getGroupOutput(5).text
        print("\n Group 5 : \n $group5")
        group1.split("\n").size() == 6

        def group6 = generatorPage.getGroupOutput(6).text
        print("\n Group 6 : \n $group6")
        group1.split("\n").size() == 6

        and:
        def numbersToArrayList = []
        group1.split("\n").each { x -> numbersToArrayList.add(x as int) }
        group2.split("\n").each { x -> numbersToArrayList.add(x as int) }
        group3.split("\n").each { x -> numbersToArrayList.add(x as int) }
        group4.split("\n").each { x -> numbersToArrayList.add(x as int) }
        group5.split("\n").each { x -> numbersToArrayList.add(x as int) }
        group6.split("\n").each { x -> numbersToArrayList.add(x as int) }
        numbersToArrayList.size() == 36
    }

}
