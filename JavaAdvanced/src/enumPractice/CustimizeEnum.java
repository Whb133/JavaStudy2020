package enumPractice;

public class CustimizeEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
    }
}


//自定义枚举类
class Season {
    //1.声明Season对象的属性，使用 private final修饰
    private final String SeasonName;
    private final String SeasonDesc;

    //2.私有化类的构造器，并给对象属性赋值
    private Season(String SeasonName, String SeasonDesc) {
        this.SeasonName = SeasonName;
        this.SeasonDesc = SeasonDesc;
    }

    //3.提供当前枚举类多个对象
    static Season SPRING = new Season("spring","warm");
    static Season SUMMER = new Season("summer","hot");
    static Season AUTUMN = new Season("autumn","bleak");
    static Season WINTER = new Season("winter","cold");

    @Override
    public String toString() {
        return "Season{" +
                "SeasonName='" + SeasonName + '\'' +
                ", SeasonDesc='" + SeasonDesc + '\'' +
                '}';
    }
}
