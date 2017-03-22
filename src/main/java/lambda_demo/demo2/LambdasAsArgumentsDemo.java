package lambda_demo.demo2;

public class LambdasAsArgumentsDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambda add power to Java";
        String outStr;
        System.out.println("Hello is input string: " + inStr);

        // Here, a simple expression lambda that uppercases a string is passed to stringOp()
        outStr = stringOp((str) -> str.toUpperCase(), inStr);
        System.out.println("The string in uppercase: " + outStr);

        // This passed a block lambda that removes spaces
        outStr = stringOp((str) -> {
            String result = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result += str.charAt(i);
                }
            }

            return result;
        }, inStr);
        System.out.println("The string with spaces removed: " + outStr);

        /*
        Of course, it is also possible to pass a StringFunc instance
        created by an earlier lambda expression. For example, after this declaration
        executes, reverse refers to an instance of StringFunc.
         */
        StringFunc reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }

            return result;
        };

        System.out.println("The string reversed: " + stringOp(reverse, inStr));
    }
}
