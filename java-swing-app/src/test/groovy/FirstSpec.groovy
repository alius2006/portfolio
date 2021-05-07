import swing.SwingApp
import swing.enums.MyEnum
import spock.lang.Specification

class FirstSpec extends Specification {

    def "The first test"() {
        given:
        SwingApp.CurrentThirdValue = MyEnum.NAME3

        when:
        def actual = SwingApp.getThirdValue()

        then:
        assert actual == MyEnum.NAME3.getValue()
    }

}