package JavaCommomClass.StringPractice.StringCode;

public class SignCount {
    public static void main(String[] args) {
        //String str = "jfhsjbkjehjHJHUklk78@#$%^hjbnmjhjkkkkkkkKKJJHM*&^67";
        String str1 = "123asdVBN^&*";
        int Uppercount = 0;
        int Lowercount = 0;
        int Signcount = 0;
        /*
        for (int i= 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(ch>='a' && ch<='z'){
                Lowercount++;
            }else if(ch >= 'A' && ch <= 'Z'){
                Uppercount++;
            }else {
                Signcount++;
            }
        }

         */
        /*
        String sL = "qwertyuioplkjhgfdsazxcvbnm";
        String sU = sL.toUpperCase();
        for (int i= 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(sL.indexOf(ch) != -1){
                Lowercount++;
            }else if(sU.indexOf(ch) != -1){
                Uppercount++;
            }else {
                Signcount++;
            }
        }

         */

        for (int i= 0;i<str1.length();i++){
            char ch = str1.charAt(i);
            if(Character.isLowerCase(ch)){
                Lowercount++;
            }else if(Character.isUpperCase(ch)){
                Uppercount++;
            }else {
                Signcount++;
            }
        }


        System.out.println("大写字符："+Lowercount);
        System.out.println("小写字符："+Uppercount);
        System.out.println("符号字符："+Signcount);

    }
}
