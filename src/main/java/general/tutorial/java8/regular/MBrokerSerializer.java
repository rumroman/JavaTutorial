package general.tutorial.java8.regular;

import java.io.IOException;
import java.net.URL;

public interface MBrokerSerializer  {

    <T> String serialize(T payload) throws IOException;

    <T> T deserialize(String payload, Class<T> targetType) throws IOException;

    <T> T deserialize(URL payloadUrl, Class<T> targetType) throws IOException;

    <T> T deserializeBrokerEntity(String payload, Class<T> targerType) throws IOException;
}
