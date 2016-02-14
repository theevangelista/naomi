package naomi;

import com.fasterxml.jackson.databind.ObjectMapper;
import naomi.request.body.Attachment;
import naomi.request.body.Message;
import org.hamcrest.Matchers;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertThat;

/**
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public class MessageEncodingTests {

    @Test
    public void shouldEncodeMessageUsingConstructors() throws Exception {
        ObjectMapper encoder = new ObjectMapper();
        Message message = new Message(singletonList(new Attachment("Foo","Bar", MessageUtils.writeFields(null))),"Exception Notifier");
        String encodedMessage = encoder.writeValueAsString(message);
        System.out.println(encodedMessage);
        assertThat(encodedMessage, Matchers.containsString("Foo"));
    }

}