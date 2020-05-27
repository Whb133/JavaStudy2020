package threadPractice.produceAndconsumer.ProAndCon0412.ProAndCon;

import threadPractice.produceAndconsumer.ProAndCon0412.Apple;
import threadPractice.produceAndconsumer.ProAndCon0412.Plate;

public class ProducerT implements Runnable{

    Plate plate;
    public ProducerT(Plate plate){
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            plate.push(new Apple(i));
            System.out.println(Thread.currentThread().getName()+"  生产了 "+i);
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
