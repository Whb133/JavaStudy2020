package enumPractice;

public class UseEnum {
    public static void main(String[] args) {

        //System.out.println(Season1.class.getSuperclass());

        //toString(）  返回当前枚举类对象常量的名称
        System.out.println(Season.SPRING);

        //values()   返回枚举类中定义的对象数组，该方式可以遍历枚举类所有枚举值。
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        //valueOf(String objName)   根据提供的objName，返回枚举类中对象名为objName的对象，若未找到会抛异常。
        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);
        spring.show();
    }
}

//使用enum定义枚举类，默认继承于java.lang.Enum类
enum Season1 implements Showable{

    //1.提供当前枚举类多个对象，多个对象之间使用,隔开，最后一个使用；
    SPRING("spring", "warm"){
        @Override
        public void show() {
            System.out.println("Spring");
        }
    },
    SUMMER("summer", "hot"){
        @Override
        public void show() {
            System.out.println("summer");
        }
    },
    AUTUMN("autumn", "bleak"){
        @Override
        public void show() {
            System.out.println("autumn");
        }
    },
    WINTER("winter", "cold"){
        @Override
        public void show() {
            System.out.println("winter");
        }
    };

    //2.声明Season对象的属性，使用 private final修饰
    private final String SeasonName;
    private final String SeasonDesc;

    //3.私有化类的构造器，并给对象属性赋值
    Season1(String SeasonName, String SeasonDesc) {
        this.SeasonName = SeasonName;
        this.SeasonDesc = SeasonDesc;
    }


//    @Override
//    public String toString() {
//        return "Season{" +
//                "SeasonName='" + SeasonName + '\'' +
//                ", SeasonDesc='" + SeasonDesc + '\'' +
//                '}';
//    }
}
interface Showable{
    void show();
}