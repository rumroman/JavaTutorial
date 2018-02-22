package general.tutorial.java8.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {

        Human human = new Human();

        //human.setName("Edward");
        //human.setAge(21);

        /*Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("Ten",2);
        map.put("two",3);
        map.put("one",22);
        human.setMoney(map);*/

        List<Map<String,Integer>> list = new ArrayList<Map<String, Integer>>();
        Map<String,Integer> map1 = new HashMap<String, Integer>();
        Map<String,Integer> map2 = new HashMap<String, Integer>();
        Map<String,Integer> map3 = new HashMap<String, Integer>();
        //map1.put("Ten",2);
        //map2.put("Two",21);
        map3.put("one",10);
        map3.put("TEST",55);
        map3.put("TEST2",130);

        //list.add(map1);
        //list.add(map2);
        list.add(map3);
        //human.setList(list);

        ObjectMapper objectMapper = new ObjectMapper();

        human.setMapList(Collections.singletonList(Collections.singletonMap("ID",Collections.singletonMap("eq","40"))));

        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class,Map.class);

        objectMapper.writeValue(new FileOutputStream("/home/rum/Projects/human.txt"),human.getMapList());

        //objectMapper.writeValue(new FileOutputStream("/home/rum/Projects/human.txt"),human);
        String json = "";
        //json = objectMapper.writeValueAsString(human);
        String filePath = "/home/rum/Projects/human.txt";



        try{
            human = (Human)objectMapper.readValue(new FileInputStream(filePath),Human.class);
            System.out.println(human);
        } catch(IOException e){
            System.out.println(e);
        }

        //Serializer serializer = new Serializer(new ObjectMapper());

        //human = serializer.deserializer(json,Human.class);

        //System.out.println(human);


    }
}


