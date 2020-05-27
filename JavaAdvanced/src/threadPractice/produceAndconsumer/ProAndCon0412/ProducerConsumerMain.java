package threadPractice.produceAndconsumer.ProAndCon0412;

import threadPractice.produceAndconsumer.ProAndCon0412.ProAndCon.ConsumerT;
import threadPractice.produceAndconsumer.ProAndCon0412.ProAndCon.ProducerT;

public class ProducerConsumerMain {
    public static void main(String[] args) {

        Countable[] apples = new Apple[30];
        Plate plate = new Plate(apples);
        new Thread(new ProducerT(plate)).start();
        new Thread(new ProducerT(plate)).start();
        new Thread(new ConsumerT(plate)).start();
        new Thread(new ConsumerT(plate)).start();
    }
}

