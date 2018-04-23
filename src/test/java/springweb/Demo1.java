package springweb;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);

        Integer[] strings = new Integer[list.size()];
        for (int j = 0; j < list.size(); j++) {
            strings[j] = j;
        }

        // list.toArray(strings);

        for (Integer integer : strings) {
            System.out.println(integer);
        }

    }

}
