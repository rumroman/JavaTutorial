package general.tutorial.java8.regular;




import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import java.util.*;

import java.util.stream.Collectors;


public class RegularDemo {

    public static void main(String args[]) throws IOException {

        DefaultNamesResolvingStrategy defaultNamesResolvingStrategy =
                new DefaultNamesResolvingStrategy();


        //Положим поля в лист
        /*List<String> listField = Stream.of(Country.class.getDeclaredFields())
                .map(defaultNamesResolvingStrategy::getFieldName)
                .collect(Collectors.toList());

        listField.forEach(System.out::println);
        System.out.println("");
        System.out.println("");

        listField.stream()
                .map(defaultNamesResolvingStrategy::getFieldNameForJava)
                .forEach(System.out::println);*/

        // Удаляем первую и последнюю квадратные скобки "[" и "]" .
        String str = "[{\"ID\":49,\"C_CODE\":\"MY\",\"C_NAME\":\"Малайзия\"," +
                "\"ID_LANGUAGE\":46,\"ID_CURRENCY\":37,\"C_CURRENCY_CODE\":\"MYR\"," +
                "\"C_CURRENCY_NAME\":\"Малайзийский ринггит\",\"C_CURRENCY_SYMBOL\":\"RM\"," +
                "\"C_LANGUAGE_CODE\":\"ms-MY\",\"C_LANGUAGE_NAME\":\"Малайский\"," +
                "\"ID_COUNTRY_GROUP\":null,\"C_COUNTRY_GROUP\":null,\"C_PHONE_CODE\":\"60\"," +
                "\"C_PHONE_LENGTH\":null,\"C_MCC\":502,\"C_NAME_TRANSLATE\":\"Малайзия\"," +
                "\"C_WEEKDAY_START\":null}," +
                "{\"ID\":49,\"C_CODE\":\"MY\",\"C_NAME\":\"Малайзия\"," +
                "\"ID_LANGUAGE\":46,\"ID_CURRENCY\":37,\"C_CURRENCY_CODE\":\"MYR\"," +
                "\"C_CURRENCY_NAME\":\"Малайзийский ринггит\",\"C_CURRENCY_SYMBOL\":\"RM\"," +
                "\"C_LANGUAGE_CODE\":\"ms-MY\",\"C_LANGUAGE_NAME\":\"Малайский\"," +
                "\"ID_COUNTRY_GROUP\":null,\"C_COUNTRY_GROUP\":null,\"C_PHONE_CODE\":\"60\"," +
                "\"C_PHONE_LENGTH\":null,\"C_MCC\":502,\"C_NAME_TRANSLATE\":\"Малайзия\"," +
                "\"C_WEEKDAY_START\":null}]";


        /*String str2 = "[{\"code\":\"MY\",\"languageId\":46,\"currencySymbol\":\"RM\"," +
                "\"nameTranslate\":\"Малайзия\",\"countryGroupId\":null," +
                "\"languageCode\":\"ms-MY\",\"mcc\":502,\"weekdayStart\":null," +
                "\"languageName\":\"Малайский\",\"phoneLength\":null," +
                "\"countryGroup\":null,\"currencyName\":\"Малайзийский ринггит\"," +
                "\"name\":\"Малайзия\",\"phoneCode\":\"60\",\"id\":49,\"currencyId\":37," +
                "\"currencyCode\":\"MYR\"},{\"code\":\"MY\",\"languageId\":46,\"currencySymbol\":\"RM\"," +
                "\"nameTranslate\":\"Евразия\",\"countryGroupId\":null," +
                "\"languageCode\":\"ms-MY\",\"mcc\":502,\"weekdayStart\":null," +
                "\"languageName\":\"Малайский\",\"phoneLength\":null," +
                "\"countryGroup\":null,\"currencyName\":\"Малайзийский ринггит\"," +
                "\"name\":\"Евразия\",\"phoneCode\":\"60\",\"id\":49,\"currencyId\":37," +
                "\"currencyCode\":\"MYR\"}]";*/


        JacksonMBrokerSerializer jacksonMBrokerSerializer = new JacksonMBrokerSerializer(new FieldsResolvingFromView(),new ObjectMapper());

        str = jacksonMBrokerSerializer.serializeResponse(str);

        Country[] country = jacksonMBrokerSerializer.deserialize(str,Country[].class);

        System.out.println(country.length);



    }
}
