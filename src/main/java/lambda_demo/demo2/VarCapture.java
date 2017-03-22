package lambda_demo.demo2;

public class VarCapture {
    public static void main(String[] args) {
        // A local variable that can be captured.
        int num = 10;

        // The following line would also cause an error
        // because it would remove the effectively final status from num.
        //num = 5;

        MyFunc myLambda = (n) -> {
            // This use of num is OK. It does nto modify num.
            int v = num + n;

            // However, the following is illegal because it attempts to modify the value of num.
            //num++;

            return v;
        };


        System.out.println(myLambda.func(5));
    }
}
