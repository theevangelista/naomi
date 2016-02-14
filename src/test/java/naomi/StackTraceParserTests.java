package naomi;

import org.junit.Test;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
public class StackTraceParserTests {

    @Test
    public void shouldConvertStackTranceIntoString() throws Exception {
        String trace = StackTraceParser.asString(new WATException());
        System.out.println(trace);


    }
}