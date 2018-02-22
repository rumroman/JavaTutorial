package general.tutorial.java8.regular;

public class FieldsResolvingFromView implements FieldResolvingJavaStrategy {

    private static String PREFIX_COLUMN = "c_";

    public static String PREFIX_ID = "id_";

    public static String POSTFIX_ID_FOR_JAVA = "Id";

    public static String SPLITTER = "_";

    public static String DOT = ".";

    public String getFieldName(String field){

        String fieldName = field.toLowerCase();

        if (fieldName.startsWith(PREFIX_COLUMN)) {
            fieldName = fieldName.replaceAll(PREFIX_COLUMN, "");
        } else if (fieldName.startsWith(PREFIX_ID)) {
            fieldName = fieldName.replaceAll(PREFIX_ID,"") + POSTFIX_ID_FOR_JAVA;
        }

        fieldName = toCamelCaseNotation(fieldName);

        return fieldName;

    }

    private String toCamelCaseNotation(String str){

        String res = str;
        int numChar;

        while(res.contains(SPLITTER)){
            numChar = res.indexOf(SPLITTER)+1;
            res = res.replaceFirst(SPLITTER + DOT,String.valueOf(res.charAt(numChar)).toUpperCase());
        }
        return res;
    }


}
