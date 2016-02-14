package naomi;

import com.squareup.okhttp.Response;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import naomi.request.DefaultHookClient;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public class NaomiTests {

    private Naomi naomi;

    private BotProperties properties;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        properties = new SimpleBotProperties(System.getenv("HOOK_URL"));
        naomi = new Naomi(new DefaultHookClient(properties));
    }

    @Test
    public void sendMessageUsingDefaults() throws Exception {
        Response response = this.naomi.notify(new WATException());
        assertTrue("Response must be not null", response != null);
        assertThat(response.message(), is("OK"));
        assertThat(response.code(), is(200));
    }

    @Test
    public void sendMessageWithNoStackTrace() throws Exception {
        Response response = this.naomi.notify(new WATException(), false);
        assertTrue("Response must be not null", response != null);
        assertThat(response.message(), is("OK"));
        assertThat(response.code(), is(200));

    }
}