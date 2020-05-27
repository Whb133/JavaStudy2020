package AnnotationPractice;


import com.sun.deploy.security.ValidationState;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE,ElementType.TYPE_PARAMETER,ElementType.TYPE_USE})
public @interface MyAnnotations {

    MyAnnotation[] value();
}
