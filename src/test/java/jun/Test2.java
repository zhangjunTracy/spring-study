package jun;

import org.junit.Test;

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

    @Test
    public  void test2(){

        int[] ints = range(1, 5).toArray();
        System.out.println(ints.length);
        range(1, 5).boxed().map(i -> { System.out.print("Happy Birthday "); if (i == 3) return "dear NAME"; else return "to You"; }).forEach(System.out::println);
    }
}
