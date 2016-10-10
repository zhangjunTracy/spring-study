package www.springweb.hello.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 获取客户端IP(真实IP地址) ThreadLocal
 *
 */
public class ClientIPUtil {
    private static final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    /**
     * 真实IP地址
     * 
     * @return
     */
    public static String getRealClientIP() {
        return LOCAL.get();
    }

    /**
     * 真实IP地址
     * 
     * @param request
     * @return
     */
    public static String getRealClientIP(HttpServletRequest request) {
        String clientIP = "";
        String remote_addr = request.getRemoteAddr();
        String x_forwarded_for = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(x_forwarded_for)) {
            clientIP = remote_addr;
        } else {
            clientIP = x_forwarded_for;
        }
        LOCAL.set(clientIP);
        return clientIP;
    }
}
