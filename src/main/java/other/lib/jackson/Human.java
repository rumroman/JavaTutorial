package other.lib.jackson;

import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class Human {

    //private List<Map<String,Integer>> list;

    private List<Map<String,Map<String,Object>>> mapList;

    //private Map<String,List<Map<String,Object>>> stringListMap;



    //public List<Map<String, Integer>> getList() {
      //  return list;
    //}

    //public void setList(List<Map<String, Integer>> list) {
      //  this.list = list;
    //}
}
