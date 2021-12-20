import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

spockReports {
    def format = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
    def date = format.format(LocalDateTime.now())
    set 'com.athaydes.spockframework.report.showCodeBlocks': true
    set 'com.athaydes.spockframework.report.outputDir': 'target/spock-reports/' //+ date.toString()
    set 'com.athaydes.spockframework.report.projectName': 'Sample API Automation Tests | '
    set 'com.athaydes.spockframework.report.projectVersion': '' + date.toString()
}