package helperMethods

import org.apache.commons.lang3.StringUtils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Dates {
    public static final String DEFAULT_DATE_PATTERN = "yyyyMMdd_HHmmss"

    /**
     * Returns a string formatted for given datetime pattern with today's date
     *
     * @return current datetime as string. The date pattern can be specified. The default pattern is {@link Dates#DEFAULT_DATE_PATTERN}
     */
    static String getCurrentDateAsFileNameSuffix() {
        return getCurrentDateAsFileNameSuffix(DEFAULT_DATE_PATTERN)
    }

    /**
     * Returns a string formatted for given datetime pattern with today's date
     *
     * @param pattern a datetime pattern
     * @return formatted string
     */
    static String getCurrentDateAsFileNameSuffix(String pattern) {
        String updatedPattern = StringUtils.isEmpty(pattern) ? DEFAULT_DATE_PATTERN : pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(updatedPattern)
        LocalDateTime now = LocalDateTime.now()
        return formatter.format(now)
    }
}
