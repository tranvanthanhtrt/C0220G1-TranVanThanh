package Bai6.AbstractVaInterface;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.lang.instrument.Instrumentation;

public class tas {

    public class ObjectSizeFetcher {
        private Instrumentation instrumentation;

        public  void premain(String args, Instrumentation inst) {
            instrumentation = inst;
        }

        public long getObjectSize(Object o) {
            return instrumentation.getObjectSize(o);
        }
    }
    static class A {
        int x=1;
        double y=1.1;
        String z="a";


    }
    static class B extends A{

    }
    static class C{

    }

    public static void main(String[] args) throws IllegalAccessException {
        A a=new A();
        B b=new B();
        C c=new C();
        System.out.println(aa.sizeOf(a));
        System.out.println(aa.sizeOf(b));
        System.out.println(aa.sizeOf(c));
    }
}
