package www.springweb.hello.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

import com.fasterxml.jackson.core.JsonProcessingException;

import www.springweb.hello.Constants;
import www.springweb.hello.util.AuthorizationUtil;
import www.springweb.hello.util.ClientIPUtil;

/**
 * Yx Controller Advice <br>
 * <ul>
 * <li>全局捕获异常</li>
 * <li></li>
 * <li></li>
 * </ul>
 * 
 * @author Ertao.Fang
 * 
 */
@ControllerAdvice
public class YxControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(YxControllerAdvice.class);

    /**
     * 全局捕获异常
     * 
     * @param throwable
     * @param request
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
    /*
     * @ExceptionHandler public Object exceptionHandler(Throwable throwable,
     * HttpServletRequest request, HttpServletResponse response) throws
     * JsonProcessingException, IOException {
     * 
     * LOGGER.error("系统未捕获异常", throwable);
     * 
     * // ## // Ajax请求 Boolean isAjaxRequest = false;
     * 
     * // ## // Ajax请求:是?否? String xRequestedWith =
     * request.getHeader("X-Requested-With"); if
     * (StringUtils.isNotBlank(xRequestedWith)) { isAjaxRequest = true; }
     * 
     * // ## // 异常明细 // User currentUser = userService.getCurrentUser();
     * Map<String, Object> map = new TreeMap<String, Object>(); // 1. 请求用户
     * //map.put("userId", currentUser.getId()); // map.put("username",
     * currentUser.getUsername()); // 2. 请求地址 map.put("requestUri",
     * request.getRequestURI()); map.put("requestUrl", request.getRequestURL());
     * // 3. 请求IP map.put("remote-addr", request.getRemoteAddr());
     * map.put("x-forwarded-for", request.getHeader("x-forwarded-for")); // 4.
     * Header map.put("User-Agent", request.getHeader("User-Agent")); // 5. 异常堆栈
     * StringWriter writer = new StringWriter(); throwable.printStackTrace(new
     * PrintWriter(writer)); map.put("stackTrace", writer.toString()); // 6.
     * 异常邮件 if ("pro".equals(activeProfile)) { //
     * producerTemplate.sendBody(ErrorMailSenderRoute.URI, map); } else {
     * LOGGER.info("非生产环境,无需发送异常邮件!"); }
     * 
     * // ## // 请求返回:JSON if (isAjaxRequest) { // ResponseBodyPayload rbp = new
     * ResponseBodyPayload();
     * response.setContentType(MediaType.APPLICATION_JSON_VALUE); //
     * rbp.setErrorMsg("服务器开小差了..."); // rbp.setErrorResData(map); // String
     * responseJson = objectMapper.writeValueAsString(rbp); //
     * IOUtils.write(responseJson, response.getWriter()); return null; } //
     * 请求返回:Redirect else { return "redirect:/"; } }
     * 
     * /** InitBinder
     * 
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }

    /**
     * ModelAttribute<br>
     * 
     * 自动切换学校
     * 
     * @param model
     * @param request
     */
    @ModelAttribute
    public void modelAttribute(Model model, HttpServletRequest request,
            @RequestHeader(value = "api_key", required = false) String api_key, //
            @RequestHeader(value = "User-Agent", required = false) String user_agent, //
            @RequestHeader(value = "Authorization", required = false) String authorization, // 用户信息
                                                                                            // 加密带过来
            @RequestHeader(value = "x-forwarded-for", required = false) String x_forwarded_for, //
            //
            @RequestHeader(value = "x-yx-app-v", required = false) String x_yx_app_v, //
            @RequestHeader(value = "x-yx-net-t", required = false) String x_yx_net_t, //
            @RequestHeader(value = "x-yx-dev-t", required = false) String x_yx_dev_t, // 是什么类型登录
                                                                                      // 自定义类型
            @RequestHeader(value = "x-yx-dev-imei", required = false) String x_yx_dev_imei, //
            @RequestHeader(value = "x-yx-dev-model", required = false) String x_yx_dev_model//
    ) {
        // ##
        // 解析授权信息
        if (StringUtils.isBlank(x_yx_dev_t)) {
            x_yx_dev_t = Constants.AppType.WEB.toString();

        }
        AuthorizationUtil.parseAuthorization(authorization, x_yx_dev_t);
        // 客户端真实IP
        ClientIPUtil.getRealClientIP(request);
        String clientIP = ClientIPUtil.getRealClientIP();
        String remoteAddr = request.getRemoteAddr();
        LOGGER.info("=======================================================");
        LOGGER.info("RequestURI:" + request.getRequestURI());
        LOGGER.info("api_key:" + api_key);
        LOGGER.info("Authorization:" + authorization);
        LOGGER.info("ClientIP:" + clientIP);
        LOGGER.info("RemoteAddr:" + remoteAddr);
        LOGGER.info("x-forwarded-for:" + x_forwarded_for);
        LOGGER.info("x-yx-app-v:" + x_yx_app_v);
        LOGGER.info("x-yx-net-t:" + x_yx_net_t);
        LOGGER.info("x-yx-dev-t:" + x_yx_dev_t);
        LOGGER.info("x-yx-dev-imei:" + x_yx_dev_imei);
        LOGGER.info("x-yx-dev-model:" + x_yx_dev_model);
        LOGGER.info(AuthorizationUtil.getAuthorizationInfo().toString());
        LOGGER.info("User-Agent:" + user_agent);
        LOGGER.info("=======================================================");
    }

    /**
     * ModelAttribute
     * 
     * @param model
     * @param request
     */
    @ModelAttribute
    public void modelAttribute2(Model model, HttpServletRequest request) {
    }

}
