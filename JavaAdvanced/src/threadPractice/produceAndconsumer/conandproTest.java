package threadPractice.produceAndconsumer;

public class conandproTest {
    public static void main(String[] args) {
        Baozi[] baozil = new Baozi[15];
        Stacklongzi stacklongzi = new Stacklongzi(baozil);
        new Thread(new Producert(stacklongzi)).start();
        new Thread(new Consumert(stacklongzi)).start();
    }
}


class Baozi {
    private int id;

    Baozi(int id) {
        this.id = id;
    }
}

class Stacklongzi {
    int index = 0;
    static int id = 0;
    Baozi[] baozilong;

    Stacklongzi(Baozi[] baozil) {
        baozilong = baozil;
    }

    //add（）在哪写？
    //remove()   how to code
    public synchronized void add() {
        while (index == baozilong.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        baozilong[index] = new Baozi(id++);
        index++;

    }

    public synchronized Baozi remove() {

        while (index == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return baozilong[index];
    }
}

class Producert implements Runnable {

    Stacklongzi stacklongzi;

    Producert(Stacklongzi stacklongzi) {
        this.stacklongzi = stacklongzi;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            stacklongzi.add();
            System.out.println("生产了"+i);
        }
    }
}

class Consumert implements Runnable {

    Stacklongzi stacklongzi;
    Consumert(Stacklongzi stacklongzi) {
        this.stacklongzi = stacklongzi;
    }

    public void run() {
        for (int i = 0; i < 30; i++) {
            stacklongzi.remove();
            System.out.println("消费了"+i);
        }
    }
}