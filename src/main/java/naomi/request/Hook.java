package naomi.request;

import java.io.IOException;

import com.squareup.okhttp.Response;
import naomi.request.body.Attachment;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
public interface Hook {

    /**
     * Send the message into Slack
     * Messages must be accorded with Slack specifications
     * at <a href="https://api.slack.com/incoming-webhooks">Docs</a>
     * @param attachments attachments to be included on the message, we use it as it provide more information then a simple text message
     * @return response from api for further interactions when needed
     * @throws IOException in case of incomplete call
     */
    Response postMessage(Attachment... attachments) throws IOException;
}
