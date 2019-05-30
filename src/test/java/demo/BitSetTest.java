package demo;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.BitSet;

/**
 * @Author: ZJ
 * @Date: 18-9-3 下午4:50
 */
public class BitSetTest {
    //全量bitset
    private static BitSet allBitSet = new BitSet();
    //偶数bitset
    private static BitSet evenBitSet = new BitSet();
    //奇数bitset
    private static BitSet oddBitSet = new BitSet();
    //空bitset
    private static BitSet emptyBitSet = new BitSet();
    @BeforeClass
    public static void init(){
        for (int i = 0; i <10; i++) {
            allBitSet.set(i);
            if (i % 2 == 0) {
                evenBitSet.set(i);
            }else{
                oddBitSet.set(i);
            }
        }
    }
    //测试初始化
   // @Test
    public void testInit(){
        //断点进去看
        BitSet initBitSet1 = new BitSet(55);
        BitSet initBitSet2 = new BitSet(129);
    }
    //测试基础的and\or\xor运算
   //@Test
    public void testOper(){
        //System.out.println(evenBitSet.toByteArray());
        evenBitSet.and(allBitSet);
        System.out.println("偶数Bit and 全量Bit："+evenBitSet);
        // ^ 运算 相同0不相同1
        evenBitSet.xor(allBitSet);

        System.out.println("偶数Bit xor 全量Bit："+evenBitSet);
        evenBitSet.or(allBitSet);
        System.out.println("偶数Bit or 全量Bit："+evenBitSet);
    }
    //测试动态扩展，每次是以64位为单位
  //  @Test
    public void testExpand(){
        testSize();
        allBitSet.set(100000000);
        System.out.println("全量Bit-设置64之后大小：" + allBitSet.size()/8/1024/1024+"m");
        System.out.println("全量Bit-设置64之后长度：" + allBitSet.length());
        System.out.println("全量Bit-设置64之后实际true的个数：" + allBitSet.cardinality());
    }
    //oddBitSet过滤掉evenBitSet
   //@Test
    public void testOddFilterEvenBitSet(){
        oddBitSet.set(2);
        oddBitSet.set(4);
        oddBitSet.set(6);
        System.out.println("过滤前：oddBitSet:"+oddBitSet);
        evenBitSet.and(oddBitSet);
        System.out.println("oddBitSet："+evenBitSet);
        oddBitSet.xor(evenBitSet);
        System.out.println("oddBitSet过滤evenBitSet相同的元素的结果："+oddBitSet);
    }
    //偶数和奇数bitset合并去重之后和allbitSet内容一致
   //@Test
    public void testOddAndEventBitSet(){
        System.out.println("偶数BitSet合并前 ："+evenBitSet);
        System.out.println("奇数BitSet合并前 ："+oddBitSet);
        System.out.println("------------------------");
        oddBitSet.or(evenBitSet);
        System.out.println("偶数BitSet合并后 ："+evenBitSet);
        System.out.println("奇数BitSet合并后 ："+oddBitSet);
        System.out.println("全亮BitSet内容是 ："+allBitSet);
    }
    //返回true的个数
    //@Test
    public void testCardinality(){
        System.out.println("偶数Bit-true的个数：" + evenBitSet.cardinality());
    }
    //判断是否为空
    //@Test
    public void testIsEmpty(){
        System.out.println("全量Bit-判断非空：" + allBitSet.isEmpty());
        System.out.println("空  Bit-判断非空：" + emptyBitSet.isEmpty());
    }
    //根据下表开始结束获取
    //@Test
    public void testGetFromEnd(){
        System.out.println("全量Bit-[0,5]：" + allBitSet.get(0, 5));
        System.out.println("空  Bit-[0,5]：" + emptyBitSet.get(0, 5));
    }
    //判断是否存在bitset
    //@org.junit.Test
    public void testGet(){
        System.out.println("全量Bit-下标为2是否存在:" + allBitSet.get(2));
        System.out.println("偶数Bit-下标为1是否存在:" + evenBitSet.get(1));
        System.out.println("偶数Bit-下标为2是否存在:" + evenBitSet.get(2));
    }
    //计算bitset内存大小
    //@org.junit.Test
    public void testSize(){
        System.out.println("空  Bit-大小：:" + emptyBitSet.size()+"byte");
        System.out.println("偶数Bit-大小：" + evenBitSet.size() + "byte");
        System.out.println("全量Bit-大小：" + allBitSet.size() + "byte");
    }
    //计算bitset长度（bitset最大数+1）
    @org.junit.Test
    public void testLength(){
        System.out.println("全量Bit-长度：" + allBitSet.length());
        System.out.println("偶数Bit-长度：" + evenBitSet.length());
    }
}
