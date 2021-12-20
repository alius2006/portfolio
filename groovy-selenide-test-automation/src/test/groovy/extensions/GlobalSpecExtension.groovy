package extensions

import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

class GlobalSpecExtension implements IGlobalExtension{
// This method is redundant but has to implemented
    @Override
    void start() {}

    @Override
    void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new ErrorListener())
    }

    // This method is redundant but has to implemented
    @Override
    void stop() {}
}
