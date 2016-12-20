package springweb.other;

import java.text.DecimalFormat;

import org.junit.Test;

/**
 * DecimalFormat 的用法 由于格式化double float浮点数类
 * 
 * @author Json
 *
 */
// https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html

public class DecimalFormatDemo {

    @Test
    public void test() {
        float a = 1f;
        float b = a / 3;
        System.out.println(b);
        // 取整数位 没有返回0
        System.out.println(new DecimalFormat("0").format(22.96));

        // 0.00 表示四舍五入保留两位小数 如果不够用0补
        // 取整数位和两位小数
        System.out.println(new DecimalFormat("0.00").format(b));

        // 取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(b));

        // 取所有整数部分 没有返回0
        System.out.println(new DecimalFormat("#").format(b));

        // 以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("0.00%").format(b));
        System.out.println(new DecimalFormat("#.##%").format(b));
        long c = 299792458;
        // 每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//
    }

}
