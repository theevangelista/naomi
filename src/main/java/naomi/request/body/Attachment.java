package naomi.request.body;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static java.util.Arrays.asList;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
public class Attachment {

    private final String text;

    private final String title;

    private final String color;

    private final List<Field> fields;

    @JsonProperty("mrkdwn_in")
    private final List<String> markdownIn;

    @JsonCreator
    public Attachment(@JsonProperty("title") String title,
                      @JsonProperty("text") String text,
                      @JsonProperty("color") String color,
                      @JsonProperty("fields") List<Field> fields) {
        this.text = text;
        this.title = title;
        this.color = color;
        this.fields = fields;
        this.markdownIn = asList("text", "pretext");
    }

    public Attachment(String title, String text, List<Field> fields) {
        this(title, text, "FF5555", fields);
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return (color.indexOf("#") == 0) ? color : "#" + color;
    }


    public List<Field> getFields() {
        return fields;
    }

    public List<String> getMarkdownIn() {
        return markdownIn;
    }
}
