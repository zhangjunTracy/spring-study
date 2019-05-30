package demo;

import java.util.BitSet;

/**
 * @author : ZJ
 * @date : 18-9-17 下午2:59
 */
public class Test3 {
    public static void main(String[] args) {
        int[] list = {2,2,2,3,3,1};
        int len = list.length * 2;
        BitSet bs = new BitSet(len);

        for (int i = 0; i < list.length; i++) {
            int n = 2 * list[i];
            boolean b1 = bs.get(n);
            boolean b2 = bs.get(n + 1);
            if (!b1 && !b2) { // 00
                bs.set(n, true);
                bs.set(n + 1, false);
            }
            else if (b1 && !b2) { // 01
                bs.set(n + 1, true);
                bs.set(n, false);
            }
            else if (!b1 && b2) { // 10
                bs.set(n, n + 1, true);
            }
        }

        for (int i = 0; i < bs.length(); i += 2) {
            boolean b1 = bs.get(i);
            boolean b2 = bs.get(i + 1);
            if (!b1 && !b2) { // 00
                // 0次
            }
            else if (b1 && !b2) { // 01
                System.out.println(i / 2 + "一次");
            }
            else if (!b1 && b2) { // 10
                System.out.println(i / 2 + "两次");
            }
            else if (b1 && b2) { // 11
                System.out.println(i / 2 + "三次");
            }
        }
    }
}
