package generic_demo.generic_demo.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericReading {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }

        /*
        告诉编译器readCovariant方法接受的参数只要满足Fruit的子类就行（包括Fruit自身）
        这样子类和父类之间的关系也就关联上了
         */
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    /*
    注释掉的部分，不能编译通过。
    虽然Apple是Fruit的子类，但是在泛型中List<Fruit>和List<Apple>之间没有任何关系
    可以使用通配符类解决这个问题, 参见f2
     */
    static void f1() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        // fruitReader.readExact(apples);
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
        //Apple b = fruitReader.readCovariant(apples); //error
    }

    static <E> void append(List<E> list, Class<E> cls) throws Exception {
        // E elem = new E(); // compile-time error
        E elem = cls.newInstance();
        list.add(elem);
    }

    public static void main(String[] args) {
        List<? extends Fruit> fruitList = new ArrayList<Apple>();

        //fruitList.add(new Apple());
        //fruitList.add(new Fruit());


        // Erase
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c2);
        System.out.println(c1 == c2);
    }
}
