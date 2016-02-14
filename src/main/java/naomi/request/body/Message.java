package naomi.request.body;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author Joao Pedro Evangelista
 * @since 13.02.2016
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Message {

    private final List<Attachment> attachments;

    private final String username;

    @JsonProperty("icon_url")
    private final String icon;

    private final String channel;

    @JsonCreator
    public Message(@JsonProperty("attachments") List<Attachment> attachments,
                   @JsonProperty("username") String username,
                   @JsonProperty("icon_url") String icon,
                   @JsonProperty("channel") String channel) {
        this.attachments = attachments;
        this.username = username;
        this.icon = icon;
        this.channel = channel;
    }

    public Message(List<Attachment> attachments, String username) {
        this.attachments = attachments;
        this.username = username;
        this.icon = "";
        this.channel = "";
    }


    public String getUsername() {
        return username;
    }

    public String getIcon() {
        return icon;
    }

    public String getChannel() {
        return (channel == null) ? "" : ("#" + channel);
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }
}
