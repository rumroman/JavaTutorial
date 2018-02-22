package general.tutorial.java8.regular;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.RequiredArgsConstructor;



import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public class JacksonMBrokerSerializer implements MBrokerSerializer {

    private final FieldResolvingJavaStrategy fieldResolving;


    private final ObjectMapper objectMapper;


    @Override
    public <T> String serialize(T payload) throws IOException {

        return objectMapper.writeValueAsString(payload);
    }

    public String serializeResponse(String response) throws IOException{

        TypeFactory typeFactory = objectMapper.getTypeFactory();

        CollectionType collectionType = typeFactory.constructCollectionType(List.class,Map.class);

        List<Map<String,Object>>  listMap = objectMapper.readValue(response,collectionType);
        //List<Map<String,Object>>  listMap = deserializeMap(response);
        List<Map<String,Object>> mapNewFields = new ArrayList<>();



        for(int i = 0; i < listMap.size();i++){
            mapNewFields.add(new HashMap<>());
        }

        for(int i = 0; i < listMap.size();i++){
            for(Map.Entry<String,Object> entry : listMap.get(i).entrySet()){
                mapNewFields.get(i).put(fieldResolving.getFieldName(entry.getKey()),
                        entry.getValue());
            }
        }

        return serialize(mapNewFields);
    }

    @Override
    public <T> T deserialize(String payload, Class<T> targetType) throws IOException {

        System.out.println(payload);
        return objectMapper.readValue(payload,targetType);
    }

    public List<Map<String,Object>> deserializeMap(String payload) throws IOException {

        TypeReference<List<Map<String,Object>>> typeReference =
                new TypeReference<List<Map<String, Object>>>() {
                    @Override
                    public Type getType() {
                        return super.getType();
                    }
                };

        TypeFactory typeFactory = objectMapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(Map.class,String.class,Object.class);
        return objectMapper.readValue(payload,typeReference);
    }

    @Override
    public <T> T deserialize(URL payloadUrl, Class<T> targetType) throws IOException {
        return objectMapper.readValue(payloadUrl,targetType);
    }

    @Override
    public <T> T deserializeBrokerEntity(String payload, Class<T> targerType) throws IOException {
        return null;
    }


    /*@Override
    public <T> T deserializeBrokerEntity(String payload, Class<T> targetType) throws IOException {
        Object deserializedPayload = objectMapper.readValue(payload, Object.class);
        Class type;
        if (targetType.isArray()) {
            type = targetType.getComponentType();
        } else {
            type = targetType;
        }

        if (deserializedPayload instanceof Collection) {
            return (T) convertToObjects((Collection<Map<String, Object>>) deserializedPayload, type);
        } else if (deserializedPayload instanceof Map) {
            //@todo
        } else {
            throw new IllegalArgumentException("Unknown type of deserialized payload: " + deserializedPayload.getClass().getName());
        }
        return null;
    }*/
}
