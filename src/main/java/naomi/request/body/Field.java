package naomi.request.body;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Field {

    private final String title;

    private final String value;

    @JsonProperty("short")
    private final boolean isShort;

    @JsonCreator
    public Field(@JsonProperty("title") String title,
                 @JsonProperty("value") String value,
                 @JsonProperty("short") boolean isShort) {
        this.title = title;
        this.value = value;
        this.isShort = isShort;
    }

    public Field(String title, String value) {
        this.title = title;
        this.value = value;
        this.isShort = false;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public boolean isShort() {
        return isShort;
    }
}
