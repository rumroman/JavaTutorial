package other.lib.jackson;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

import java.io.IOException;


@RequiredArgsConstructor
public class Serializer {

    private final ObjectMapper objectMapper;


    public <T> T deserializer(String payload, Class<T> targetType) throws IOException {
        //log.info("Deserializing {}" , payload);
        System.out.println("Deserializing {}" + payload);
        return objectMapper.readValue(payload,targetType);
    }
}
