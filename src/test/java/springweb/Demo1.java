package springweb;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();

        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(4);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(1);
        list3.add(22);
        list3.add(43);

        list.retainAll(list2);
        //
        // list.retainAll(list3);

        // list.removeAll(list2);
        // System.out.println(list);
        System.out.println(list);

        // Integer[] strings = new Integer[list.size()];
        // for (int j = 0; j < list.size(); j++) {
        // strings[j] = j;
        // }
        //
        // // list.toArray(strings);
        //
        // for (Integer integer : strings) {
        // System.out.println(integer);
        // }

    }

}
