package demo;

import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.junit.Test;

/**
 * @author : ZJ
 * @date : 18-9-6 下午2:42
 */
public class Test1 {
    @Test
    public  void  test(){
        // 最大值100
        int[] d = new int[]{1,6,9,10,52,92};
        //默认值都是0
        byte[] bits = new byte[13];
        System.out.println("==================");
        for (int i : d) {
            bits[i/8] |=1<< i%8;
        }
        System.out.println("==================");
        for (int i : d) {
            // 不等于0 存在
          Boolean d1=(bits[i/8] & 1<< i%8)!=0;
          System.out.println(d1);
        }
        System.out.println("==================");
        int count = 0;
        for (int i=0;i<bits.length;i++){
            for(int j=0;j<8;j++){
                //不为0 有数字
                if((bits[i] & 1<<j)!=0) {
                    count++;
                    System.out.println("输出第" + count  +"个数" + (i * 8 + j));
                }
            }
        }

    }

   // @Test
    public  void test2(){
        byte b=1;
        // 会把b隐转换到int 类型 所以会报错
        //b = b + 1;
        // 会有强制转换
        b+=1;
        b=(byte)(b+1);

    }
}
