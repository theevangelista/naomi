package naomi;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
final class StackTraceParser {

    public static String asString(Throwable exception) {
        StringWriter writer = new StringWriter();
        exception.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

}
