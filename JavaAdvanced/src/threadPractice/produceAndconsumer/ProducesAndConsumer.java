package threadPractice.produceAndconsumer;

public class ProducesAndConsumer{

    public static void main(String[] args){
        SyncStackBox ssb = new SyncStackBox();
        Producer producer = new Producer(ssb);
        Consumer consumer = new Consumer(ssb);
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();

    }
}

class Bread{
    int id;
    Bread(int id){
        this.id = id;
    }
}
class SyncStackBox{

    Bread[] box = new Bread[10];
    int index = 0;

    public synchronized void push(Bread bread){
        while (index == box.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        box[index] = bread;
        index++;
    }
    public synchronized Bread pop(){
        while (index == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return box[index];
    }
}
class Producer implements Runnable{

    SyncStackBox ssb = null;
    Producer(SyncStackBox ssb){
        this.ssb = ssb;
    }

    @Override
    public void run() {

        for (int i = 0 ; i< 20 ;i++){
            ssb.push(new Bread(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产 "+i);
        }

    }
}
class Consumer implements Runnable{

    SyncStackBox ssb = null;
    Consumer(SyncStackBox ssb){
        this.ssb = ssb;
    }

    @Override
    public void run() {
        for (int i=0 ;i<20;i++){
            Bread b = ssb.pop();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费 "+b.id);
        }

    }
}

