package lambda_demo.demo1;

/**
 * A lambda expression is, essentially, an anonymous(that is, unnamed) method.
 * However, this method is not executed on its own.
 * Instead, it is used to implements a method defined by a functional interface.
 * Thus, a lambda expression results in a form of anonymous class.
 *
 * 匿名方法 => 匿名类
 * Lambda => Functional Interface（Instance）
 * 这样一来：
 *      一段lambda表达式（匿名方法），就变成一个类定义
 *      一段lambda表达式就变成了一个接口的实现
 */
public class UseFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Calculator addition = (int a, int b) -> (a + b);    // 一般情况
        System.out.println(addition.calculate(5, 20));


        Calculator division = (a, b) -> (a - b);            // 可以不自动参数类型，一般可以推测
        System.out.println(division.calculate(5, 20));
        System.out.println(division.add(5, 20));    // 调用默认方法
    }
}
