package enums

enum TreeMenuItemsFirstLevel {
    INPUT_FORMS("Input Forms"),
    DATE_PICKERS("Date pickers"),
    TABLE("Table"),
    PROGRESS_BARS_AND_SLIDERS("Progress Bars & Sliders"),
    ALERTS_AND_MODALS("Alerts & Modals"),
    LIST_BOX("List Box"),
    OTHERS("Others")

    private final String value

    TreeMenuItemsFirstLevel(String value) {
        this.value = value
    }

    String getValue() {
        return value
    }
}
