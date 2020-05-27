package javabase.Boxing;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.InterruptedIOException;

public class AutoBoxing {
    public static void main(String[] args){

        Integer t1 = new Integer(1);
        Integer t2 = new Integer(1);
        System.out.println(t1 == t2);//false

        Integer t3 = 1;
        Integer t4 = 1;
        System.out.println(t3 == t4);//true

        Integer t5 = 127;
        Integer t6 = 127;
        System.out.println(t5 == t6);//true

        Integer t7 = 128;
        Integer t8 = 128;
        System.out.println(t7 == t8);//false
    }
}
