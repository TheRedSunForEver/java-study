package mothedreference_demo;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
    private int val;

    MyClass(int v) {
        val = v;
    }

    int getVal() {
        return val;
    }
}

public class UseMethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String args[]) {
        ArrayList<MyClass> al = new ArrayList<>();

        al.add(new MyClass(1));
        al.add(new MyClass(4));
        al.add(new MyClass(2));
        al.add(new MyClass(9));
        al.add(new MyClass(3));
        al.add(new MyClass(7));

        MyClass maxValObj = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Maximum value is: " + maxValObj.getVal());

        // 使用lambda表达式的情况，我的添加
        // MyClass minValObj = Collections.min(al, (a, b) -> {return (a.getVal() - b.getVal());});
        MyClass minValObj = Collections.min(al, (a, b) -> a.getVal() - b.getVal());
        System.out.println("Minimum value is: " + minValObj.getVal());
    }
}
