package general.tutorial.java8.regular;


import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultNamesResolvingStrategy {

    public static Pattern PATTERN = Pattern.compile("(?<=[a-z])[A-Z]");

    public static String PREFIX_TYPE = "t_";

    public static String PREFIX_VIEW = "v_";

    public static String PREFIX_COLUMN = "c_";

    public static String PREFIX_ID = "id_";

    public static String POSTFIX_ID = "_id";

    public static String SPLITTER = "_";

    public static String DOT = ".";

    public static String ID = "id";

    public static String POSTFIX_ID_FOR_JAVA = "Id";




    public String getViewName(Class<?> type) {

        return (PREFIX_VIEW + toUnderscoreNotation(type.getSimpleName())).toUpperCase();
    }

    public String getFieldName(Field field) {


        String fieldName = toUnderscoreNotation(field.getName());

        if (fieldName.endsWith(POSTFIX_ID)) {
            fieldName = fieldName.replaceAll("(.*)" + POSTFIX_ID, PREFIX_ID + "$1");
        } else if (fieldName.equals(ID)) {
            fieldName = fieldName.toUpperCase();
        } else {
            fieldName = PREFIX_COLUMN + fieldName;
        }

        return fieldName.toUpperCase();
    }

    public String getFieldNameForJava(String field){

        String fieldName = field.toLowerCase();

        if (fieldName.startsWith(PREFIX_COLUMN)) {
            fieldName = fieldName.replaceAll(PREFIX_COLUMN, "");
        } else if (fieldName.startsWith(PREFIX_ID)) {
            fieldName = fieldName.replaceAll(PREFIX_ID,"") + POSTFIX_ID_FOR_JAVA;
        }

        fieldName = toCamelCaseNotation(fieldName);

        return fieldName;

    }

    public String toCamelCaseNotation(String str){

        String res = str;
        int numChar;

        while(res.contains(SPLITTER)){
            numChar = res.indexOf(SPLITTER)+1;
            res = res.replaceFirst(SPLITTER + DOT,String.valueOf(res.charAt(numChar)).toUpperCase());
        }
        return res;
    }

    public String toUnderscoreNotation(String string) {
        Matcher matcher = PATTERN.matcher(string);

        StringBuffer stringBuilder = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder, SPLITTER + matcher.group().toLowerCase());
        }

        matcher.appendTail(stringBuilder);
        return stringBuilder.toString().toLowerCase();
    }
}
