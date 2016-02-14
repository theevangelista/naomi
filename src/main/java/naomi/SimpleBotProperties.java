package naomi;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
public class SimpleBotProperties implements BotProperties {

    private final String url;

    private final String botName;

    private final String icon;

    private final String channel;

    public SimpleBotProperties(String url, String botName, String icon, String channel) {
        this.url = url;
        this.botName = botName;
        this.icon = icon;
        this.channel = channel;
    }

    public SimpleBotProperties(String url) {
        this(url, null);
    }

    public SimpleBotProperties(String url, String channel) {
        this(url, "Naomi",
                "https://cdn0.iconfinder.com/data/icons/robots-expression/512/Robot_16-128.png",
                channel);
    }

    @Override
    public String url() {
        return this.url;
    }

    @Override
    public String botName() {
        return this.botName;
    }

    @Override
    public String icon() {
        return this.icon;
    }

    @Override
    public String channel() {
        return this.channel;
    }
}
