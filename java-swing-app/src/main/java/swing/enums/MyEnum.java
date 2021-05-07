package swing.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MyEnum {
    NAME1("value1"),
    NAME2("value2"),
    NAME3("value3");

    private final String value;
    private static final Map<String, MyEnum> valueMap = Stream.of(values()).collect(Collectors.toMap(MyEnum::getValue, Function.identity()));

    MyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MyEnum fromValue(String value) {
        return valueMap.get(value);
    }
}
