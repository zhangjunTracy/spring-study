package springweb.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import www.springweb.hello.util.DBUtil;

public class Test2 {

    public static void main(String[] args) {

        String sql = "INSERT INTO test(NAME,nick,address) VALUES(";
        String str = "";

        long start = System.currentTimeMillis();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100000; i++) {
            str = sql + "'" + i + "'," + "'" + (i + new Random().nextInt(10000)) + "'," + "'"
                    + (RandomStringUtils.randomAlphabetic(20)) + "')";
            // System.out.println(str);
            list.add(str);
            if (list.size() == 100) {
                DBUtil.execute(list);
                list.clear();
            }
        }
        DBUtil.execute(list);

        System.out.println((System.currentTimeMillis() - start) / 1000 + "s");

    }

}
