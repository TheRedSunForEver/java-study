package generic_demo.demo1;

/**
 * 泛型类
 */
public class Box<T> {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>();
        box.setObject(1);
        System.out.println(box.getObject());

        Box<String> box2 = new Box<>();
        box2.setObject("abc");
        System.out.println(box2.getObject());
    }
}
