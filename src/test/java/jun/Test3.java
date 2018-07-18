package jun;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

public class Test3 {

    // @Test
    public void test() {

        Long time = new Date().getTime();
        System.out.println(time + "");
        SortedMap<String, String> map = new TreeMap<>();
        map.put("roomid", "732453975");
        map.put("account", "55555");
        map.put("username", "feo");
        map.put("signedat", time + "");
        map.put("email", "1226972909@qq.com");
        map.put("app_key", "b609b31e4d96c623b793b617d7f6c8af");
        StringBuffer stringBuffer = new StringBuffer("653507e1c6c73edfe8331989173e1a75");
        for (String s : map.keySet()) {
            stringBuffer.append(s);
            stringBuffer.append(map.get(s));
        }
        stringBuffer.append("653507e1c6c73edfe8331989173e1a75");
        System.out.println(stringBuffer.toString());
        String md5Hex = DigestUtils.md5Hex(stringBuffer.toString());
        System.out.println(md5Hex);


        System.out.println("355".substring(1));


    }

    //@Test
    public void test1() {
        //http://cnstatic01.e.vhall.com/jssdk/dist/2.3.3/index.html?app_key=b609b31e4d96c623b793b617d7f6c8af&signedat=1530521746626&sign=a8b9228b5c1dfac6aa04729b23367aa6&email=98795252@qq.com&id=732453975&account=28318437&username=afadsf
        Long time = new Date().getTime();
        System.out.println(time + "");
        SortedMap<String, String> map = new TreeMap<>();
        map.put("roomid", "732453975");
        map.put("account", "28382602");
        map.put("username", "erer");
        map.put("signedat", time + "");
        map.put("app_key", "b609b31e4d96c623b793b617d7f6c8af");
        map.put("email", "987999252@qq.com");
        StringBuffer stringBuffer = new StringBuffer("653507e1c6c73edfe8331989173e1a75");
        for (String s : map.keySet()) {
            stringBuffer.append(s);
            stringBuffer.append(map.get(s));
        }
        stringBuffer.append("653507e1c6c73edfe8331989173e1a75");
        System.out.println(stringBuffer.toString());
        String md5Hex = DigestUtils.md5Hex(stringBuffer.toString());
        System.out.println(md5Hex);

    }

    // @Test
    public void test2() {

        Long time = new Date().getTime();
        System.out.println(time + "");
        SortedMap<String, String> map = new TreeMap<>();
        map.put("id", "732453975");
        map.put("account", "1226972909");
        map.put("name", "visitorss");
        map.put("signed_at", time + "");
        map.put("app_key", "b609b31e4d96c623b793b617d7f6c8af");
        StringBuffer stringBuffer = new StringBuffer("653507e1c6c73edfe8331989173e1a75");
        for (String s : map.keySet()) {
            stringBuffer.append(s);
            stringBuffer.append(map.get(s));
        }
        stringBuffer.append("653507e1c6c73edfe8331989173e1a75");
        System.out.println(stringBuffer.toString());
        String md5Hex = DigestUtils.md5Hex(stringBuffer.toString());
        System.out.println(md5Hex);

    }

    @Test
    public  void test3() {
        SortedMap<String, String> map = new TreeMap<>();
        map.put("account","s27680701");
        map.put("password","cheers2018");
        map.put("webinar_id","732453975");
        map.put("auth_type","1");
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Response> entity = restTemplate.getForEntity("http://e.vhall.com/api/vhallapi/v2/webinar/report?account={account}&password={password}&webinar_id={webinar_id}&auth_type={auth_type}", Response.class, map);
        // Response object = restTemplate.getForObject("http://e.vhall.com/api/vhallapi/v2/webinar/report?account={account}&password={password}&webinar_id={webinar_id}&auth_type={auth_type}", Response.class, map);
        System.out.println(entity.getBody().getData().getTotal_attendee_number());
    }
}

class Response{
    private Integer code;
    private String msg;
    private report data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public report getData() {
        return data;
    }

    public void setData(report data) {
        this.data = data;
    }
}

@JsonIgnoreProperties
class report{

    private String total_attendee_number;

    private String total_watch_number;

    private String total_watch_times;

    private String total_watch_duration;


    public String getTotal_attendee_number() {
        return total_attendee_number;
    }

    public void setTotal_attendee_number(String total_attendee_number) {
        this.total_attendee_number = total_attendee_number;
    }

    public String getTotal_watch_number() {
        return total_watch_number;
    }

    public void setTotal_watch_number(String total_watch_number) {
        this.total_watch_number = total_watch_number;
    }

    public String getTotal_watch_times() {
        return total_watch_times;
    }

    public void setTotal_watch_times(String total_watch_times) {
        this.total_watch_times = total_watch_times;
    }

    public String getTotal_watch_duration() {
        return total_watch_duration;
    }

    public void setTotal_watch_duration(String total_watch_duration) {
        this.total_watch_duration = total_watch_duration;
    }

}

