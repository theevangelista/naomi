package naomi.request.body;

/**
 * @author Joao Pedro Evangelista
 * @since 14.02.2016
 */
public class Markdown {

    public static String bold(String text) {
        return "*" + text + "*";
    }

    public static String italic(String text) {

        return "_" + text + "_";
    }

    public static String code(String text){
        return "`" + text + "`";
    }

    public static String codeBlock(String text){
        return "```" + text + "```";
    }
}
