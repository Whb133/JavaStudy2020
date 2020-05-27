package AnnotationPractice;

import java.lang.annotation.*;

@Inherited
@Documented
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
@Retention(RetentionPolicy.CLASS)
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    /*
    如何自定义注解：
        ①注解声明为: @interface
        ②内部定义成员，通常使用value表示
        ③可以指定成员的默认值，使用default定义
        ④如果自定义注解没有成员，表明是一个标识作用。
    如果注解有成员，(在没有给定默认值的情况下)在使用注解时，需要指明成员的值。

    * */
    String value() default "hello";
}
