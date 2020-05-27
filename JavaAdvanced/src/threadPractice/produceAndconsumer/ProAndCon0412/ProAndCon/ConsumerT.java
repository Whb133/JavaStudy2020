package threadPractice.produceAndconsumer.ProAndCon0412.ProAndCon;

import threadPractice.produceAndconsumer.ProAndCon0412.Apple;
import threadPractice.produceAndconsumer.ProAndCon0412.Countable;
import threadPractice.produceAndconsumer.ProAndCon0412.Plate;


public class ConsumerT implements Runnable {

    Plate plate;

    public ConsumerT(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        Countable c;
        for (int i = 0; i < 30; i++) {
            c = plate.pop();
            System.out.println(Thread.currentThread().getName() + "  消费了 " + c.getId());

        }
    }
}

