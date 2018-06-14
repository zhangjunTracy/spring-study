package jun;

import java.text.NumberFormat;

public class Test2 {

    public static void main(String[] args) {
        int num1 = 7;

        int num2 = 9;

        // 创建一个数值格式化对象

        NumberFormat numberFormat = NumberFormat.getInstance();

        // 设置精确到小数点后2位

        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);

        System.out.println("num1和num2的百分比为:" + result + "%");

    }
}
