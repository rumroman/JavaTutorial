package demo;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public interface MBrokerSerializer {

    <T> String serialize(T payload) throws IOException;

    String serializeResponse(String response) throws IOException;

    String serializeResponse(List<Map<String, Object>> mapList) throws IOException;

    <T> T deserialize(String payload, Class<T> targetType) throws IOException;

    <T> T deserialize(URL payloadUrl, Class<T> targetType) throws IOException;

    <T> T deserializeBrokerEntity(String payload, Class<T> targerType) throws IOException;

}
