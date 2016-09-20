package www.springweb.hello.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;

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

    private static final Logger LOGGER = LoggerFactory
            .getLogger(YxControllerAdvice.class);
    /**
     * 全局捕获异常
     * 
     * @param throwable
     * @param request
     * @return
     * @throws IOException
     * @throws JsonProcessingException
     */
/*    @ExceptionHandler
    public Object exceptionHandler(Throwable throwable,
            HttpServletRequest request, HttpServletResponse response)
            throws JsonProcessingException, IOException {
        
        LOGGER.error("系统未捕获异常", throwable);

        // ##
        // Ajax请求
        Boolean isAjaxRequest = false;

        // ##
        // Ajax请求:是?否?
        String xRequestedWith = request.getHeader("X-Requested-With");
        if (StringUtils.isNotBlank(xRequestedWith)) {
            isAjaxRequest = true;
        }

        // ##
        // 异常明细
      //  User currentUser = userService.getCurrentUser();
        Map<String, Object> map = new TreeMap<String, Object>();
        // 1. 请求用户
        //map.put("userId", currentUser.getId());
       // map.put("username", currentUser.getUsername());
        // 2. 请求地址
        map.put("requestUri", request.getRequestURI());
        map.put("requestUrl", request.getRequestURL());
        // 3. 请求IP
        map.put("remote-addr", request.getRemoteAddr());
        map.put("x-forwarded-for", request.getHeader("x-forwarded-for"));
        // 4. Header
        map.put("User-Agent", request.getHeader("User-Agent"));
        // 5. 异常堆栈
        StringWriter writer = new StringWriter();
        throwable.printStackTrace(new PrintWriter(writer));
        map.put("stackTrace", writer.toString());
        // 6. 异常邮件
        if ("pro".equals(activeProfile)) {
      //      producerTemplate.sendBody(ErrorMailSenderRoute.URI, map);
        } else {
            LOGGER.info("非生产环境,无需发送异常邮件!");
        }

        // ##
        // 请求返回:JSON
        if (isAjaxRequest) {
       //     ResponseBodyPayload rbp = new ResponseBodyPayload();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
         //   rbp.setErrorMsg("服务器开小差了...");
         //   rbp.setErrorResData(map);
         //   String responseJson = objectMapper.writeValueAsString(rbp);
         //   IOUtils.write(responseJson, response.getWriter());
            return null;
        }
        // 请求返回:Redirect
        else {
            return "redirect:/";
        }
    }

    /**
     * InitBinder
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
    public void modelAttribute(Model model, HttpServletRequest request) {
        // 获取:当前登陆用户
     //   Object principal = SecurityUtils.getSubject().getPrincipal();
        // 判断:已登录?
//        if (principal == null) {
//            return;
//        }
        // 判断:User实例?
//        if (!(principal instanceof User)) {
//            return;
//        }
//        User currentUser = (User) principal;
//        String currentSchoolId = currentUser.getCurrentSchoolId();
        // 判断:已选学校?
     // /  if (StringUtils.isNotBlank(currentSchoolId)) {
       //     return;
       // }
        // 判断:是否教师?
      //  if (!currentUser.chkIsTeacher()) {
      //      return;
      //  }
        // 查询:学校列表
     //   List<String> schoolIdLst = teacherSchoolService
      //          .findSchoolIdsByTeacherId(currentUser.getId());
        // 选择:学校:(默认选择第一个)
//        String schoolId = null;
//        for (String schoolIdTmp : schoolIdLst) {
//            schoolId = schoolIdTmp;
//            break;
//        }
        // 切换:学校
//        currentUser.switchSchool(schoolId);
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
