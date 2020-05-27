package JavaCommomClass.StringPractice.StringCode;

public class SubStringSearch {
    public static void main(String[] args) {
        String str = "I like studying java!I hope you also like it! lllikelike";
        String substr = "like";
        /*
        char subfirst = substr.charAt(0);
        for(int i =0; i<str.length() ;i++){
            if(str.charAt(i) == subfirst){
                if(str.substring(i,i+substr.length()).equals(substr)){
                    System.out.println("出现"+substr+"的第一个位置索引是："+i);
                    return;
                }
            }
        }
        System.out.println("未找到该字符串！");

         */

        /*
        int index = str.indexOf(substr);
        if(index != -1) {
            System.out.println("出现" + substr + "的第一个位置索引是：" + index);
            int count = 1;
            int i = index + substr.length();
            while (i < str.length()) {
                if (str.charAt(i) == substr.charAt(0)) {
                    if (str.substring(i, i + substr.length()).equals(substr)) {
                        count++;
                        i = i + substr.length();
                    } else {
                        i++;
                    }
                }else {
                    i++;
                }
            }
            System.out.println("共出现"+count+"次！");
        }else {
            System.out.println("未找到该字符串！");
        }

         */

        int count = 0;
        int index = -1;
        while ((index=str.indexOf(substr)) != -1){
            str = str.substring(index + substr.length());
            count++;
        }
        System.out.println("共出现"+count+"次！");
    }
}
