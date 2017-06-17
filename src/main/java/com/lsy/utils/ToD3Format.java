package com.lsy.utils;

import com.lsy.domain.Person;

import java.util.*;

/**
 * Created by lsy on 2017/6/14.
 */
public class ToD3Format{
    private final static ToD3Format toD3Format = new ToD3Format();
    private ToD3Format() {
    }
    public static ToD3Format getInstance(){
        return toD3Format;
    }
    public Map<String,Object> toD3Format(Collection<Person> persons){
        List<Map<String,Object>> nodes = new ArrayList<>();
        List<Map<String,Object>> rels = new ArrayList<>();
        int i = 0;
        for(Person p : persons) {
            nodes.add(map("title", p.getName(), "label", "person"));
        }
        for(Person p : persons){
            int source = i;
            i++;
            if(p.getFriends().size()!=0) {
                for (Person person :
                        p.getFriends()) {
                        Map<String, Object> friend = map("title", person.getName(), "label", "person");
                        int target = nodes.indexOf(friend);
                        rels.add(map("source", source, "target", target));
                }
            }
        }
        return map("nodes",nodes,"links",rels);
    }

    public Map<String,Object> map(String key1,Object value1, String key2, Object value2){
        Map<String,Object> result = new HashMap<>(2);
        result.put(key1,value1);
        result.put(key2,value2);
        return result;
    }
}
