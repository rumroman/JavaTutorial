package mockito;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.List;
import java.util.Map;

/**
 * Описание запроса к вьюхе или табличной функции
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Wither
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class QueryDescription<T> {

    private int base;

    private String view;

    @JsonProperty("class")
    private String type;

    private List<String> params;

    private int limit;

    private List<Object> fields;

    private List<Map<String, Map<String, Object>>> filter;

    private List<Object> groupby;

    private Map<String, String> order;
}

