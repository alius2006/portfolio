package helpers

class JsonHelper {
    static String loadJson(String path) {
        byte[] bytes

        try {
            bytes = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(path)).readAllBytes();
        } catch (IOException | NullPointerException e) {
            bytes = null
        }
        return new String(bytes)
    }
}
