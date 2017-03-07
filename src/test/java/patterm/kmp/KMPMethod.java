package patterm.kmp;

public class KMPMethod {

    public static Integer indexOf(String source, String pattern) {
        int i = 0, j = 0;
        char[] s = source.toCharArray();
        char[] p = pattern.toCharArray();

        while (i < s.length && j < p.length) {
            // 相等 继续比较下去
            if (s[i] == p[j]) {
                i++;
                j++;
            } else {
                // 字符串开始从下一个比较 因为有可能有相等的 所以 i并不能从0开始 下一个开始
                i = i - j + 1;
                // 不相等 重新冲目标的第一个字符比较 即 j=0
                j = 0;
            }
        }
        // 匹配成功,则返回模式字符串在原字符串中首次出现的位置;否则返回-1
        // 匹配成功 j肯定和p.length相等
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        System.out.println(indexOf("advdddddssss", "ds"));
    }

}
