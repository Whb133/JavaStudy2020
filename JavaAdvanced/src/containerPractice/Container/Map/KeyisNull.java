package containerPractice.Container.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class KeyisNull {
    public static void main(String[] args) {

        Map map = new HashMap<>();
        map.put(null,null);
        System.out.println(map);
        System.out.println(map.containsKey(null));



//        Map tmap = new TreeMap();
//        tmap.put(null,null);//java.lang.NullPointerException
//        System.out.println(tmap);
    }

}
