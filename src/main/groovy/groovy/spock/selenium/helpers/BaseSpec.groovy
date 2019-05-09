package groovy.spock.selenium.helpers

class BaseSpec extends Base {

    def setupSpec() {
        driver = initializeDriver()
    }

    def cleanup(){
        print("\n========================\n")
    }

    def cleanupSpec() {
        driver.close()
    }

}
