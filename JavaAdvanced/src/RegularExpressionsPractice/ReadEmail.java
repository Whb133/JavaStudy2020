package RegularExpressionsPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadEmail {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("E:\\testcode\\SimpleTest\\fileTest.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        Pattern p = Pattern.compile("(\\._*\\.)*@\\.*.\\.");
//        Pattern p = Pattern.compile("^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$");
        Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w[.-]]+");
        String str = null;
        try {
            while ((str = br.readLine()) != null) {
                Matcher m= p.matcher(str);
                while (m.find()){
                    System.out.println(m.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
