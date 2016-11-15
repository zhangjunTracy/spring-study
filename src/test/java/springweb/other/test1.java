package springweb.other;

public class test1 {
    public static void main(String[] args) {

        Integer a = 11;
        Integer b = 11;

        Integer c = 300;
        Integer d = 300;

        System.out.println(a == b);
        System.out.println(c == d);

        Integer integer;// -XX:AutoBoxCacheMax=<size>} 调解
        Byte aByte;//

        Long long1;//

        Short short1;// -128-127

        Character character;// 0-127

        Float float1;

        Double double1;

        Boolean boolean1;

        // Integer g = Integer.valueOf(10); // under the hood
        Integer f = 10; // autoboxing
        Integer g = new Integer("10");// Constructs

        System.out.println(f == g);

    }

}
