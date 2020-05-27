package SinglePattern;

public class TestSinglePattern {
    public static void main(String[] args) {
        SinglePatternlan.getInstance().show();
        SinglePatternlan.getInstance().show();
//        new SinglePatternlan().show();


        SinglePatternehan.getInstance().show();
        SinglePatternehan.getInstance().show();
//        new SinglePatternehan().show();
    }
}
class SinglePatternlan{

    static SinglePatternlan sp ;
    static int count = 0;
    private SinglePatternlan(){}
    public static SinglePatternlan getInstance(){
        if (sp == null){
            count++;
            sp = new SinglePatternlan();
            return sp;
        }else {
            return sp;
        }
    }
    void show(){
        System.out.println(this);
        System.out.println("懒汉模式类实例化对象个数"+count);
    }
}
class SinglePatternehan{

    static int count = 1;
    static SinglePatternehan sp = new SinglePatternehan();
    private SinglePatternehan(){}
    public static SinglePatternehan getInstance(){
        return sp;
    }
    void show(){
        System.out.println(this);
        System.out.println("饿汉模式类实例化对象个数"+count);
    }
}