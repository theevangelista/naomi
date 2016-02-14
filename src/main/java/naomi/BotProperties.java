package naomi;

/**
 *
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
public interface BotProperties {

    /**
     * Url to post the message
     * @return slack webhook url
     */
    String url();

    /**
     * Bot name to appear as message sender
     * @return bot name
     */
    String botName();

    String icon();

    String channel();
}
