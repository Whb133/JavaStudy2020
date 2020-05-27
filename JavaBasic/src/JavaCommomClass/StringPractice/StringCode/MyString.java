package JavaCommomClass.StringPractice.StringCode;

import java.util.Arrays;

public class MyString {

    //模拟trim方法，去除两端空格
    public static String mytrim(String str){
        boolean flag = true;
        while (flag) {
            if (str.startsWith(" ")) {
                str = str.substring(1);
            } else if (str.endsWith(" ")) {
                str = str.substring(0, str.length() - 1);
            }else {
                flag = false;
            }
        }
        return str;
    }

    //将字符串部分位置反转
    public static  String PartialReversal(String str,int start,int end){

        String substr = str.substring(start,end);
        String substrreve = "";
        for (int i = substr.length()-1; i >= 0; i--) {
            substrreve += substr.charAt(i);
        }
        return str.replace(substr,substrreve);
    }

    //获取一个字符串在另一个字符串出现次数
    public static  int AppearCount(String substr,String str){

        int count = 0;
        int strj = 0;
        while (strj <= (str.length()-substr.length())){
            if (substr.charAt(0) == str.charAt(strj)){
                for (int i = 1; i < substr.length(); i++) {
                    if (substr.charAt(i) == str.charAt(strj+i)){
                        if ((i+1) == substr.length()){
                            count++;
                            strj += substr.length();
                        }
                    }else {
                        strj++;
                        break;
                    }
                }
            }else {
                strj++;
            }
        }
        return count;
    }

    //获取一个字符串在另一个字符串出现次数优化
    public static  int AppearCountOptimization(String substr,String str){

        int count = 0;
        int index = -1;
        while ((index=str.indexOf(substr)) !=-1){
            count++;
            str = str.substring(index+substr.length());
        }

        return count;
    }

    //获取两个字符串最大相同子串
    public static String MaxCommonSubString(String str1,String str2){

        String maxCommomString = null;
        int maxLength = 0;
        String longString = str1.length() > str2.length() ? str1: str2;
        String shortString = str1.length() < str2.length() ? str1: str2;
        for (int i = 0; i < shortString.length()-1; i++) {
            int j = i+1;
            StringBuilder maxString = new StringBuilder();
            maxString.append(shortString.charAt(i));
            while (longString.indexOf(maxString.toString()) != -1){
                if (shortString.length() - i > maxLength) {
                    maxString.append(shortString.charAt(j++));
                }else {
                    break;
                }
            }
            if (maxString.length() > maxLength){
                maxCommomString = maxString.toString().substring(0,maxString.length()-1);
                maxLength = maxCommomString.length();
            }
        }


        return maxCommomString;
    }

    //对字符串中字符自然排序
    public static String SortToChars(String str){

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

class StringMain{
    public static void main(String[] args) {

//        String s1 = "    jn  java   ";
//        String str1 = MyString.mytrim(s1);
//        System.out.println(str1+"   "+str1.length());

//        String s2 = "l love java";
//        String str2 = MyString.PartialReversal(s2,2,6);
//        System.out.println(str2);

//        String s3 = "abcbabcbabcbauhubcbcbkjbcbkihbcbcb";
//        int count = MyString.AppearCount("bcb",s3);
//        System.out.println(count);

//        String s4 = "abcbabcbabcbauhubcbcbkjbcbkihbcbcb";
//        int count2 = MyString.AppearCount("bcb",s3);
//        System.out.println(count2);

//        String s5 = "qabwecbeweweweqabcbrabcc";
//        String s6 = "abweweweqccba";
//        String str6 = MyString.MaxCommonSubString(s5,s6);
//        System.out.println(str6);

        String s7 = "asdfghjkloiyntr";
        String str7 = MyString.SortToChars(s7);
        System.out.println(str7);
    }
}
