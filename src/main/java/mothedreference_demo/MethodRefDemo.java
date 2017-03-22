package mothedreference_demo;


/**
 * Demonstrate a method reference for a static method.
  */

// A functional interface for string operations.
interface StringFunc {
    String func(String n);
}

// This class defines a static method called strReverse().
class MyStringOps {
    // A static method that reverses a string.
    static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }

        return result;
    }

    String sayHello(String str) {
        return "hello " + str;
    }
}

public class MethodRefDemo {
    /*
    This method has functional interface as the type of its first parameter.
    Thus, it can be passed any instance of that interface, including a method reference.
     */
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    String stringOp2(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda add power to Java";
        String outStr;

        // Here, a method reference to strReverse is passed to stringOp().
        outStr = stringOp(MyStringOps::strReverse, inStr);
        //outStr = new MethodRefDemo().stringOp2(MyStringOps::strReverse, outStr);

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);

        MyStringOps myObj = new MyStringOps();
        System.out.println(stringOp(myObj::sayHello, "abc"));
    }

}


