package containerPractice.Container.Map;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Traverse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTraverse {
    public static void main(String[] args) {

        Map map =new HashMap();
        map.put(1,11);
        map.put(2,22);
        map.put(3,33);
        map.put(4,44);
        map.put(5,44);
        MapTraverse.TraverseByEntryset(map);
        MapTraverse.TraverseByKeySet(map);
        MapTraverse.TraverseByValues(map);
    }
    static void TraverseByEntryset(Map map){

        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry  entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    static void TraverseByKeySet(Map map){
        Iterator i = map.keySet().iterator();
        while (i.hasNext()){
            Object o = (Object) i.next();
            System.out.println(o+" : "+map.get(o));
        }
    }
    static void TraverseByValues(Map map){
        Iterator i = map.values().iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
