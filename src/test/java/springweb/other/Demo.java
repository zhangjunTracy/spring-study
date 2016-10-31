package springweb.other;

import org.junit.Test;

public class Demo {

    /**
     * java存储的是有符号数，在计算机中，有符号数通常是使用补码存储的 原码:二进制(符号位 0正数1负数)
     * 反码：正数的反码是其本身,复数的反码是原码取反 补码：正数的补码是其本身,负数的补码是其反码+1
     * 
     */
    @Test
    public void test1() {

        int a = -15, b = 15;
        System.out.println(a >> 2);

        System.out.println(b >> 2);

        int c = 2;
        System.out.println(~c);

        int d = 4;
        /**
         * 判断奇偶数 判断奇偶
         * 
         * 只要根据最未位是0还是1来决定，为0就是偶数，为1就是奇数。因此可以用if ((a & 1) == 0)代替if (a % 2 ==
         * 0)来判断a是不是偶数
         */

        if ((d & 1) == 0) {

            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        /**
         * 正数变负数 负数变正数 取反 +1 第一步 a^=b 即a=(a^b)； 第二步 b^=a
         * 即b=b^(a^b)，由于^运算满足交换律，b^(a^b)=b^b^a。由于一个数和自己异或的结果为0并且任何数与0异或都会不变的，
         * 所以此时b被赋上了a的值； 第三步 a^=b
         * 就是a=a^b，由于前面二步可知a=(a^b)，b=a，所以a=a^b即a=(a^b)^a。故a会被赋上b的值；
         */
        System.out.println(~7 + 1);
        System.out.println(~-7 + 1);

        /**
         * 求绝对值因此先移位来取符号位，int i = a >>
         * 31;要注意如果a为正数，i等于0，为负数，i等于-1。然后对i进行判断——如果i等于0，直接返回。否之，返回~a+1。完整代码如下：
         */
        int f = -9;
        int i = f >> 31;

        System.out.println(i);
        System.out.println(i == 0 ? f : (~f + 1));

        /**
         * 任何数与-1^ ==任何数取反 去绝对值 简化
         */
        System.out.println(((f ^ i) - i));
    }

}
