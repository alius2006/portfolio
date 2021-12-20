package helperMethods

import com.codeborne.selenide.SelenideElement
import org.apache.commons.lang3.StringUtils

class Log {

    static final String RELATIVE_PATH = "target" + File.separator

    static void exportDomTree() {
        writeToFile(DOM.getDomTree(), "dom-", "html", RELATIVE_PATH, null)
    }

    static void exportOuterHtml() {
        writeToFile(DOM.getHtml(), "html-", "html", RELATIVE_PATH, null)
    }

    static void exportElementInnerHtml(SelenideElement element) {
        writeToFile(element.innerHtml(), "element-", "html", RELATIVE_PATH, null)
    }

    static void customLog(String body) {
        appendToExistingFile(body, RELATIVE_PATH + "logs.txt")
    }

    static void appendToExistingFile(String fileContent, String fileRelativePath) throws IOException {
        try {
            def fileWriter = new BufferedWriter(new FileWriter(fileRelativePath, true))
            fileWriter.write(System.lineSeparator() + fileContent)
            fileWriter.close()
        }
        catch (IOException ioException) {
            throw new RuntimeException("Could not write to the file", ioException)
        }
    }

    /**
     * Creates a new file in the "user.dir" folder and writes the fileContent string into it. When parameters fileNamePrefix, fileExtension, relativePath and
     * dateFormat are null they are set to default value.
     *
     * @param fileContent File content
     * @param fileNamePrefix Default file name is the current date/time in format yyyyMMdd_HHmmss. Default file name prefix is blank.
     * @param fileExtension File extension. Default file extension is "txt"
     * @param relativePath Relative path from the project root folder. Default value si blank.
     * @param dateFormat Date format used for the filename. Default value is yyyyMMdd_HHmmss.
     * @return File path and name
     */
    static File writeToFile(String fileContent, String fileNamePrefix, String fileExtension, String relativePath, String dateFormat) {

        String updatedFileNamePrefix = StringUtils.isEmpty(fileNamePrefix) ? "" : fileNamePrefix
        String updatedFileExtension = StringUtils.isEmpty(fileExtension) ? "txt" : fileExtension
        String updatedRelativePath = StringUtils.isEmpty(relativePath) ? "" : relativePath
        String updatedDateFormat = StringUtils.isEmpty(dateFormat) ? Dates.DEFAULT_DATE_PATTERN : dateFormat

        String currentDate = Dates.getCurrentDateAsFileNameSuffix(updatedDateFormat)
        String projectPath = System.getProperty("user.dir") + File.separator
        String filePathAndName = String.format("%s%s%s%s.%s", projectPath, updatedRelativePath, updatedFileNamePrefix, currentDate, updatedFileExtension)
        File file

        try {
            file = new File(filePathAndName)
            FileWriter fileWriter = new FileWriter(file)
            fileWriter.write(fileContent)
            fileWriter.close()
        } catch (Exception e) {
            throw new RuntimeException("Cannot create log file", e)
        }
        return file
    }
}
