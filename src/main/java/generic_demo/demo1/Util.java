package generic_demo.demo1;

/**
 * 泛型方法
 */
public class Util {
    // generic method
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    // bounds for type variables
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        T smallest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }

        return smallest;
    }

    public static void main(String[] args) {
        String m = Util.<String>getMiddle("a", "b", "c");
        System.out.println(m);

        // 一般忽略类型声明，编译器可以判断
        String middle = Util.getMiddle("a", "b", "c");
        System.out.println(middle);

        String smallest = Util.min(new String[]{"a", "b", "c"});
        System.out.println(smallest);
    }
}
