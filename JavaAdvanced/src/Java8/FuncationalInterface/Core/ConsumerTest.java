package Java8.FuncationalInterface.Core;

import java.util.function.Consumer;

public class ConsumerTest {

    static void pay(double money,Consumer consumer){
        consumer.accept(money);
    }

    public static void main(String[] args) {
        ConsumerTest.pay(500, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("pay "+money);
            }
        });
        System.out.println("**************");
        ConsumerTest.pay(700,money-> System.out.println("pay "+money));
    }
}

