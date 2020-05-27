package containerPractice.ContainerCode;

import java.util.HashMap;
import java.util.Map;

public class CountArgs {
    public static final Integer ONE = 1;
    public static void main(String[] args) {

        Map map = new HashMap();
        String[]  str = {"aaa","sss","ddd","aaa","fff","sss","aaa","aaa"};
        for (int i = 0 ; i < str.length ; i++){
            Integer count = (Integer)map.get(str[i]);
            map.put(str[i],count == null ? ONE : (Integer)map.get(str[i])+1);
        }
        System.out.println(map);
    }
}
