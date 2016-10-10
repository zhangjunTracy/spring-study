package www.springweb.hello.util;

import org.apache.tomcat.util.codec.binary.Base64;

import www.springweb.hello.Constants;
import www.springweb.hello.entity.User;
import www.springweb.hello.repository.UserRepository;

/**
 * 认证工具类
 *
 */
public class AuthorizationUtil {

    public static final ThreadLocal<AuthorizationInfo> AUTHORIZATION_INFO = new ThreadLocal<>();

    /**
     * 解析认证信息
     * 
     * @param authorization
     * @return
     */
    public static AuthorizationInfo parseAuthorization(String authorization, String x_yx_dev_t) {
        AuthorizationInfo info = AuthorizationInfo.getInstance(authorization, x_yx_dev_t);
        AUTHORIZATION_INFO.set(info);
        return info;
    }

    /**
     * 获取认证信息
     * 
     * @return
     */
    public static AuthorizationInfo getAuthorizationInfo() {
        return AUTHORIZATION_INFO.get();
    }

    /**
     * 认证信息
     *
     */
    public static class AuthorizationInfo {
        private String username;// 用户名
        private String authcode;// 授权码
        private String userid;// 用户Id
        private String appType;// 登录类型

        private Boolean authenticated = false;

        /**
         * 构造函数
         * 
         * @param username
         * @param authcode
         * @param userid
         */
        public AuthorizationInfo(String username, String authcode, String userid, String appType) {
            this.username = username;
            this.authcode = authcode;
            this.userid = userid;
            this.appType = appType;
        }

        /**
         * 构造函数
         */
        public AuthorizationInfo() {
            this(null, null, null, null);
        }

        /**
         * 解析并获取认证信息
         * 
         * @param authorization
         * @return
         */
        public static AuthorizationInfo getInstance(String authorization, String x_yx_dev_t) {
            AuthorizationInfo info = new AuthorizationInfo();
            String appType = "";
            if (Constants.AppType.ANDROID.toString().equalsIgnoreCase(x_yx_dev_t.toString())) {
                appType = Constants.AppType.ANDROID.toString();
            } else if (Constants.AppType.IOS.toString().equalsIgnoreCase(x_yx_dev_t.toString())) {
                appType = Constants.AppType.IOS.toString();
            } else if (Constants.AppType.WINPHONE.toString().equalsIgnoreCase(x_yx_dev_t.toString())) {
                appType = Constants.AppType.WINPHONE.toString();
            } else {
                appType = Constants.AppType.WEB.toString();
            }
            info.setAppType(appType);

            // ##
            if (authorization == null) { return info; }
            // ##
            if (!authorization.startsWith("Bearer ")) { return info; }
            // ##
            authorization = authorization.replace("Bearer ", "");
            authorization = new String(Base64.decodeBase64(authorization.getBytes()));
            // ##
            if (authorization.indexOf(":") == -1) { return info; }
            // ##
            String[] strArr = authorization.split(":");
            if (strArr.length != 2) { return info; }
            // ##
            String username = strArr[0];
            String authcode = strArr[1];
            UserRepository uRepository = SpringContextUtil.getBean(UserRepository.class);
            User user = uRepository.findByUsername(username);
            // ##
            info = new AuthorizationInfo(username, authcode, user.getId(), appType);
            return info;
        }

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAuthcode() {
            return authcode;
        }

        public void setAuthcode(String authcode) {
            this.authcode = authcode;
        }

        public Boolean getAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(Boolean authenticated) {
            this.authenticated = authenticated;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getAppType() {
            return appType;
        }

        public void setAppType(String appType) {
            this.appType = appType;
        }

        @Override
        public String toString() {
            return "AuthorizationInfo [username=" + username + ", authcode=" + authcode + ", userid=" + userid
                    + ", appType=" + appType + ", authenticated=" + authenticated + "]";
        }

    }
}
