package springweb.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * java正则
 * 
 * @author Mr.Zhang
 * @Date 2016年11月18日
 * @Email zhangjunTracy@qq.com
 */
public class RegexDemo {
    /**
     * [...] 位于括号之内的任意字符
     * 
     * [^...] 不在括号之中的任意字符
     * 
     * .除了换行符之外的任意字符,等价于[^\n]
     * 
     * \w 任何单字字符, 等价于[a-zA-Z0-9]
     * 
     * \W 任何非单字字符,等价于[^a-zA-Z0-9]
     * 
     * \s 任何空白符,等价于[\ t \ n \ r \ f \ v]
     * 
     * \S 任何非空白符,等价于[^\ t \ n \ r \ f \ v]
     * 
     * \d 任何数字,等价于[0-9]
     * 
     * \D 除了数字之外的任何字符,等价于[^0-9]
     * 
     * [\b] 一个退格直接量(特例)
     * 
     * 
     * 
     * {n, m} 匹配前一项至少n次,但是不能超过m次
     * 
     * {n, } 匹配前一项n次,或者多次
     * 
     * {n} 匹配前一项恰好n次
     * 
     * ? 匹配前一项0次或1次,也就是说前一项是可选的. 等价于 {0, 1}
     * 
     * + 匹配前一项1次或多次,等价于{1,}
     * 
     * 匹配前一项0次或多次.等价于{0,}
     * 
     * 
     * 
     * | 选择.匹配的要么是该符号左边的子表达式,要么它右边的子表达式
     * 
     * (...) 分组.将几个项目分为一个单元.这个单元可由 *、+、？和|等符号使用,而且还可以记住和这个组匹配的字符以供此后引用使用
     * 
     * \n 和第n个分组所匹配的字符相匹配.分组是括号中的子表达式(可能是嵌套的).分组号是从左到右计数的左括号数
     * 
     * 
     * 
     * ^ 匹配的是字符的开头,在多行检索中,匹配的是一行的开头
     * 
     * $ 匹配的是字符的结尾,在多行检索中,匹配的是一行的结尾
     * 
     * \b 匹配的是一个词语的边界.简而言之就是位于字符\w 和 \w之间的位置(注意:[\b]匹配的是退格符)
     * 
     * \B 匹配的是非词语的边界的字符
     * 
     */
    @Test
    public void test() {

        String reg = "(var\\s+totalPage)(\\s+)?=(\\s+)?(\\d)+(\\s+)?;";
        Pattern pattern = Pattern.compile(reg);

        String str = "Welcome to RegExr v2.1 by gskinner.com, proudly hosted by Media Temple! var totalPage = 4; Edit the Expression & Text to see matches. Roll over matches or the expression for details. Undo";

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group(4));
        }

    }

}
