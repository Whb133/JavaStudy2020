package SinglePattern;

import SinglePattern.getInstance.SinglePatternehan;
import SinglePattern.getInstance.SinglePatternlan;

public class TestSinglePattern {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Hungryguys()).start();
        }
//        new SinglePatternlan().show();


        for (int i = 0; i < 10; i++) {
            new Thread(new Lazyguys()).start();
        }
//        new SinglePatternehan().show();
    }
}
class Lazyguys implements Runnable{

    @Override
    public void run() {
        SinglePatternlan.getInstance().show();
    }
}
class Hungryguys implements Runnable{

    @Override
    public void run() {
        SinglePatternehan.getInstance().show();
    }
}