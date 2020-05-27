package AnnotationPractice;

import java.util.ArrayList;

@MyAnnotation(value = "hell")
@MyAnnotation(value = "hi")
public class AnnotationPractice {
}

//@Target({ElementType.TYPE_PARAMETERE})
class Generic<@MyAnnotation T>{

    //@Target({ElementType.TYPE_USE})
    public void show() throws @MyAnnotation RuntimeException{

        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}

