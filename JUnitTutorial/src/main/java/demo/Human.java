package demo;


import lombok.Data;
import mockito.QueryDescription;

import java.util.List;

import static java.util.Arrays.asList;

@Data
public class Human {

    private String name;
    private int age;
    private String speciality;

    private MBrokerSerializer serializer;

    private String someMethod(String result){return result;}

    private <T> List<T> queryDefault(String contextId, QueryDescription queryDescription, Class<T[]> responseItemsType) {
        try {

            String query = serializer.serialize(queryDescription);
            //String response = service.getViewV2(contextId, query, extendedInfo, getVarParams());

            T[] items = serializer.deserialize(serializer.serializeResponse(""), responseItemsType);

            return asList(items);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void test(){
        queryDefault("contextId",new QueryDescription(),String[].class);
    }

}
