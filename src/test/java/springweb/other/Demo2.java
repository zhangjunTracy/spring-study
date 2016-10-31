package springweb.other;

import org.junit.Test;

public class Demo2 {

    @Test
    public void test() throws Exception {

        int data[] = { 9, 8, 1, 2, 2, 1, 3, 7, 3, 7 };
        int temp = 0;
        // 第一次疑惑的结果
        for (int i = 0; i < data.length; i++) {
            temp ^= data[i];
        }
        System.out.println(temp);

        // 找到从右向左的第一个1的位置，通过位运算
        int count = 1;
        int i = 1;
        while (true) {
            if ((temp & i) == 1) {
                break;
            }
            temp = temp >> 1;
            count = count << 1;
            System.out.println(count + "===");
        }

        int num1 = 0;
        int num2 = 0;
        /**
         * count 为 1 2 4 .... 数&count 要么=0一定是那个位为0的 为一组
         */
        for (int j = 0; j < data.length; j++) {
            // 分为二组^
            if ((data[j] & count) == 0) {
                num1 ^= data[j];
            } else {
                num2 ^= data[j];
            }
        }
        System.out.println(num1 + "###" + num2);

    }
}
