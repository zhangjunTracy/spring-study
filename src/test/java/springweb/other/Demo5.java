package springweb.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class Demo5 {

    // @Test
    public void test() {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        System.out.println(list);

        Collections.sort(list);

        // Comparable
        // Comparator
        /**
         * Comparable & Comparator 都是用来实现集合中元素的比较、排序的，只是 Comparable
         * 是在集合内部定义的方法实现的排序，Comparator 是在集合外部实现的排序，所以，如想实现排序，就需要在集合外定义
         * Comparator 接口的方法或在集合内实现 Comparable 接口的方法。
         */
    }

    @Test
    public void test1() {
        // compose 函数先执行参数，然后执行调用者，而 andThen 先执行调用者，然后再执行参数。

        Function<Integer, Integer> times2 = e -> e * 2;

        Function<Integer, Integer> squared = e -> e * e;

        // 4*4 * 2
        System.out.println(times2.compose(squared).apply(4));

        // 2*4 *8
        System.out.println(times2.andThen(squared).apply(4));

    }

}
