package JavaCommomClass.ObjectPractice;

public class TestEquals {
    public static void main(String [] args){
        Cat a1 = new Cat(1,2);
        Cat a2 = new Cat(1,3);
        Cat a3 = new Cat(1,2);
        System.out.println(a1 == a3);
        System.out.println(a1.equals(a3));
    }
}
class Cat{
    int color;
    int weight ;
    Cat(int a,int b){
        this.color = a;
        this.weight  = b;
    }
    public boolean equals(Object obj) {
        if (obj != null) {
            Cat c = (Cat) obj;
            if (obj instanceof Cat) {
                if (c.weight == this.weight && c.color == this.color) {
                    return true;
                }
            }
        }
        return false;
    }
}
