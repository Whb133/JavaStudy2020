package RegularExpressionsPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRugularExpressions {
    public static void main(String[] args) {
        System.out.println("abc".matches("..."));
        System.out.println("a467ds5ds7da5s4".replaceAll("\\d","-"));
        System.out.println("ghf".matches("[a-z]{3}"));
        Pattern p = Pattern.compile("[a-z]{3}");
        Matcher m = p.matcher("asd");
        boolean b= m.matches();
        System.out.println(b);
        System.out.println("aaa".matches("a?"));
    }
}
