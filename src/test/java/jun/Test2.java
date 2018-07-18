package jun;

import org.junit.Test;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;


public class Test2 {


    @Test
    public void test3(){
        int num1 = 7;

        int num2 = 9;

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        System.out.println("num1和num2的百分比为:" + result + "%");
    }


   // @Test
    public void test() {
        int[] ia = range(1, 10).map(i -> i).toArray();
        Arrays.stream(ia).forEach(s -> System.out.printf(s + "-"));

        List<Integer> result = range(1, 10).map(i -> i * 2).boxed().collect(toList());
        System.out.printf(result.toString());
        System.out.println(result);
        int sum = range(1, 1000).sum();
        int sum1= range(1, 1000).reduce(0, Integer::sum);
        int sum2=Stream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
        int sum3=IntStream.iterate(0, i -> i + 1).limit(1000).reduce(0, Integer::sum);
        System.out.printf(sum + ":" +sum1 +":" +sum2 +":"+sum3);

    }

  //  @Test
    public void test1(){
        final List<String> keywords = Arrays.asList("brown", "fox", "dog", "pangram");
        final String tweet = "The quick brown fox jumps over a lazy dog. #pangram http://www.rinkworks.com/words/pangrams.shtml";

        System.out.println(keywords.stream().anyMatch(tweet::contains) + "");
        System.out.println("" +keywords.stream().reduce(false, (b, keyword) -> b || tweet.contains(keyword), (l, r) -> l || r));
    }

}
