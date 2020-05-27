package RegularExpressionsPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class quantifiersTest {
    public static void main(String[] args) {


        //Greedy quantifiers
        Pattern p1 = Pattern.compile(".{3,10}[0-9]");
        Matcher m1 = p1.matcher("aaaa8jjjj0");
        if (m1.find()){
            System.out.println("Greedy:"+m1.start()+"-"+m1.end());
        }else {
            System.out.println("not matches!");
        }


        //Reluctant quantifiers
        Pattern p2 = Pattern.compile(".{3,10}?[0-9]");
        Matcher m2 = p2.matcher("aaaa8jjjj0");
        if (m2.find()){
            System.out.println("Reluctant:"+m2.start()+"-"+m2.end());
        }else {
            System.out.println("not matches!");
        }

        //Reluctant quantifiers
        Pattern p3 = Pattern.compile(".{3,10}+[0-9]");
        Matcher m3 = p3.matcher("aaaa8jjjj0");
        if (m3.find()){
            System.out.println("Reluctant:"+m3.start()+"-"+m3.end());
        }else {
            System.out.println("not matches!");
        }
    }
}
