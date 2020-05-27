package containerPractice.Container.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class KeywordsCount {
    public static void main(String[] args) {
        Set ketwordsset = getKeywordsSet();
//        System.out.println(ketwordsset.size());

        File file = new File("E:\\JavaCode\\JavaStudy2020\\JavaAdvanced\\src\\containerPractice\\Container\\Map\\KeywordsCount.java");
        System.out.println(countkeywords(file));

    }
    //将java关键字放入String数组
    static String[] getKeywords(){
        String kw = "abstract default if private this " +
                "boolean do implements protected throw " +
                "break double import public throws " +
                "byte else instanceof return transient " +
                "case extends int short try " +
                "catch final interface static void " +
                "char finally long strictfp volatile " +
                "class float native super while " +
                "const for new switch " +
                "continue goto package synchronized ";
        return kw.split(" ");
    }

    //将java关键字String数组转化为Set集合
    static Set getKeywordsSet(){
        String[] keywords = getKeywords();
//        System.out.println(keywords.length);
        List<String> strings = Arrays.asList(keywords);
        Set ketwordsset = new HashSet();
        ketwordsset.addAll(strings);
//        System.out.println(ketwordsset);
//        System.out.println(ketwordsset.size());
        return ketwordsset;
    }

    static Map countkeywords(File file){
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Set set = getKeywordsSet();
        Map<String,Integer> map =new HashMap();
        while(scanner.hasNext()){
            String word = scanner.next();
//            System.out.println(word);
            if (set.contains(word)) {
                if (map.containsKey(word)) {
                    map.put(word,map.get(word)+1);

                }else {
                    map.put(word, 1);
                }
            }
        }
        return map;
    }
}
