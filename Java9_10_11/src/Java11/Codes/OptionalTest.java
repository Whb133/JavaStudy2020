package Java11.Codes;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<Object> empty = Optional.empty();
        //判断内部的value是否存在
        System.out.println(empty.isPresent());//false
        //判断内部的value是否为空
        System.out.println(empty.isEmpty());//true

        empty = Optional.of("aaa");
        Object elseThrow = empty.orElseThrow();
        System.out.println(elseThrow);

        empty = Optional.empty();
        Optional<String> opnihao = Optional.of("nihao");
        //or:value非空， 返回对应的Optional; value为空，返回形参封装的Optional
        Optional<Object> or = empty.or(() -> opnihao);
        System.out.println(or);
        
    }
}
