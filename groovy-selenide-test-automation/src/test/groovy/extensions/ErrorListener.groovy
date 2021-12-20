package extensions

import org.spockframework.runtime.AbstractRunListener
import org.spockframework.runtime.model.ErrorInfo
import tests.AbstractBaseTest

class ErrorListener extends AbstractRunListener {

    void error(ErrorInfo error) {
        AbstractBaseTest.hasPassed = false
        AbstractBaseTest.lastError = error.exception
    }
}