package mothedreference_demo;

interface MyConstructorTestFunc {
    MyConstructorTestClass func(int n);
}

class MyConstructorTestClass {
    private int val;
    MyConstructorTestClass (int v) { val = v; }
    MyConstructorTestClass() { val = 0; }
    int getVal() { return val; }
}

public class ConstructorRefDemo {
    public static void main(String args[]) {
        MyConstructorTestFunc myConstructorTestFunc = MyConstructorTestClass::new;
        MyConstructorTestClass mc = myConstructorTestFunc.func(100);
        System.out.println(mc.getVal());
    }
}
