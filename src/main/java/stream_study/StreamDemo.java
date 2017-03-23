package stream_study;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;

public class StreamDemo {

    @Test
    public void CollectionStreamDemo() {
        Collection books = new HashSet();
        books.add(new String("轻量级Java EE企业应用实战"));
        books.add(new String("疯狂Java讲义"));
        books.add(new String("疯狂IOS讲义"));
        books.add(new String("疯狂Android讲义"));

        // 含有“疯狂”子串的数量
        System.out.println(books.stream().filter(ele->((String)ele).contains("疯狂")).count());
        // 包含“Java”子串的数量
        System.out.println(books.stream().filter(ele->((String)ele).contains("Java")).count());
        // 统计字符串长度大于10的图书数量
        System.out.println(books.stream().filter(ele->((String)ele).length() > 10).count());

        // 转成IntStream
        books.stream().mapToInt(ele->((String)ele).length()).forEach(System.out::println);
    }

    @Test
    public void intSteamDemo() {
        IntStream is = IntStream.builder().add(20).add(13).add(-2).add(18).build();
        //System.out.println("max: " + is.max().getAsInt());
        //System.out.println("min: " + is.min().getAsInt());
        //System.out.println("sum: " + is.sum());
        //System.out.println("average: " + is.average());
        //System.out.println("所有平方都大于20: " + is.allMatch(ele -> ele * ele > 20));
        //System.out.println("任何元素的平方大于20：" + is.anyMatch((ele) -> ele * ele > 20));

        IntStream newIs = is.map(ele -> ele * 2 + 1);
        newIs.forEach(System.out::println);
    }
}

/*
 * filter(Predicate predicate): 过滤Stream中所有不符合predicate的元素
 * mapToXXX(TXxxFunction mapper): 使用ToXxxFunction对流中的元素执行一对一的转换，该方法返回的新流中包含了ToXxxxFunction转换生成的所有元素
 * peek(Consumer action): 一次对每个元素执行一些操作，该方法返回的流与原有流包含相同元素，该方法主要用于测试。
 * distinct(): 该方法用于排出流中素有重复的元素
 * sorted(): 排序
 * limit(long maxSize): 限制最大允许访问个数
 * forEach(Consumer action): 遍历
 * toArray(): 转换为数组
 * reduce(): 合并流中元素
 * min(): 返回最小值
 * max(): 返回最大值
 * count(): 返回元素个数
 * anyMatch(): 是否至少一个元素符合条件
 * allMatch(): 是否每个元素都符合条件
 * noneMatch(): 是否所有元素都不符合条件
 * findFisrt(): 返回第一个元素
 * findAny(): 返回任意一个元素
 */
