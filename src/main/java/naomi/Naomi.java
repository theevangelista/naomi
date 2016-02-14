package naomi;

import java.io.IOException;
import java.util.List;

import com.squareup.okhttp.Response;
import naomi.request.Hook;
import naomi.request.body.Attachment;
import naomi.request.body.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static naomi.MessageUtils.getTrace;
import static naomi.MessageUtils.writeFields;

/**
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public class Naomi {

    private static final Logger log = LoggerFactory.getLogger(Naomi.class);

    private final Hook hook;

    public Naomi(Hook hook) {
        this.hook = hook;
    }


    public Response notify(Throwable exception, String additionalMessage, boolean includeStackTrace) {
        try {
            String trace = getTrace(exception, includeStackTrace);
            List<Field> fields = writeFields(additionalMessage);
            return hook.postMessage(new Attachment(
                    exception.getLocalizedMessage(),
                    trace, fields));
        } catch (IOException e) {
            throw new NaomiException(e);
        }
    }

    public Response notify(Throwable exception) {
        return this.notify(exception, "", true);
    }

    public Response notify(Throwable exception, boolean includeStackTrace) {
        return this.notify(exception, "", includeStackTrace);
    }


}
