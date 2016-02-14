package naomi.request;

import java.io.IOException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import naomi.BotProperties;
import naomi.NaomiException;
import naomi.request.body.Attachment;
import naomi.request.body.Message;

import static java.util.Arrays.asList;

/**
 * Performs conversion and http operation to send message into Slack
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public class DefaultHookClient implements Hook {

    private final BotProperties configuration;

    private final OkHttpClient httpClient;

    private final ObjectMapper mapper;


    public DefaultHookClient(BotProperties configuration, OkHttpClient httpClient, ObjectMapper mapper) {
        this.configuration = configuration;
        this.httpClient = httpClient;
        this.mapper = mapper;

        this.httpClient.setDispatcher(new Dispatcher(new ThreadPoolExecutor(
                1,
                20,
                60L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>())));
    }

    public DefaultHookClient(BotProperties configuration){
        this(configuration, new OkHttpClient(), new ObjectMapper());
    }

    @Override
    public Response postMessage(Attachment... attachments) throws IOException {
        final String encodedMessage = encodeMessage(attachments);

        final Request request = new Request.Builder()
                .url(this.configuration.url())
                .addHeader("User-Agent", "Exception-Notifier")
                .post(RequestBody.create(MediaType.parse("application/json"), encodedMessage)).build();

        return this.httpClient.newCall(request).execute();
    }


    private String encodeMessage(Attachment... attachment) {
        try {
            return mapper.writeValueAsString(
                    new Message(asList(attachment), this.configuration.botName(), this.configuration.icon(), this.configuration.channel()));
        } catch (JsonProcessingException e) {
            throw new NaomiException(e);
        }
    }


}
