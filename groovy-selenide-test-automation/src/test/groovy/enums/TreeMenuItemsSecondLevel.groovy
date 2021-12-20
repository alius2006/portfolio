package enums

enum TreeMenuItemsSecondLevel {
    INPUT_FORM_SUBMIT("Input Form Submit")

    private final String value

    TreeMenuItemsSecondLevel(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }
}