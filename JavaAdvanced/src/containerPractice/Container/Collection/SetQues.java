package containerPractice.Container.Collection;

import java.util.HashSet;

public class SetQues {
    public static void main(String[] args) {
        HashSet s = new HashSet();
        User u1 = new User("tim",20);
        User u2 = new User("jack",30);
        s.add(u1);
        s.add(u2);
        System.out.println(s);

        u1.name = "jerry";
        s.remove(u1);
        System.out.println(s);

        s.add(new User("jerry",20));
        System.out.println(s);

        s.add(new User("tim",20));
        System.out.println(s);

    }
}
