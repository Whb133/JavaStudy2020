package javabase.javaReference;

public class changeNum {
    int a =3;
    int b =4;
    public static void main(String []args){

        changeNum c= new changeNum();
        c.exchange(c.a,c.b);
        System.out.println(c.a);
        System.out.println(c.b);

        c.exchangeadd(c.a,c.b);
        System.out.println(c.a);
        System.out.println(c.b);
    }
    void exchange(int a,int b){
        int flag=a;
        a=b;
        b=flag;
    }
    void exchangeadd(int a, int b){
        this.a=b;
        this.b=a;
    }
}
