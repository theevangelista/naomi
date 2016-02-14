package naomi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import naomi.request.body.Field;
import naomi.request.body.Markdown;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
final class MessageUtils {

    private MessageUtils() {
        //no instance
    }

    static List<Field> writeFields(String additionalMessage) {
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("Occurred at", timestamp(), false));
        if (additionalMessage != null && !additionalMessage.isEmpty()) {
            fields.add(new Field("Additional Message", additionalMessage, false));
        }
        return fields;
    }

    static String getTrace(Throwable exception, boolean includeStackTrace) {
        return includeStackTrace ? Markdown.codeBlock(StackTraceParser.asString(exception)) : "No stack trance included";
    }

    private static String timestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.MEDIUM));
    }

}
