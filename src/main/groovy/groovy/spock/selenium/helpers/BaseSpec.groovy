package groovy.spock.selenium.helpers

class BaseSpec extends Base {

    def setupSpec() {
        driver = initializeDriver()
    }

    def cleanupSpec() {
        driver.close()
    }

}
