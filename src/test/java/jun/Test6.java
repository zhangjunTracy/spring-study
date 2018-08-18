package jun;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZJ
 * @Date: 18-8-17 上午9:47
 */
public class Test6 {


    //@Test
    public  void test1() throws  Exception{
        String path = "/home/zj/x.json";
        ObjectMapper objectMapper = new ObjectMapper();

        File file=new File(path);

        List<Xie> list=objectMapper.readValue(file,new TypeReference<List<Xie>>(){});
        System.out.println(list.size());
        for (Xie xie : list) {
            System.out.println(xie);
        }


       // Map<String, List<Object>> result = objectMapper.readValue(Test6.class.getResource(path),new TypeReference<Map<String, List<Object>>>() {});

//        URL url = Test6.class.getResource(path);
//
//        System.out.println(url);

//       List<Xie> result=objectMapper.readValue(Test6.class.getResource(path),new TypeReference<List<Xie>>(){});
//        for (Xie xie : result) {
//            System.out.println(xie);
//        }
    }

    @Test
    public  void test2() {
        String mobile="135";
        StringBuffer pa=new StringBuffer("{");
         pa.append("\"account_type\"");
         pa.append(":");
         pa.append("\"Mobile\"");
         pa.append(",");
         pa.append("\"account_id\"");
         pa.append(":");
         pa.append("\"");
         pa.append(mobile);
         pa.append("\"");
         pa.append("}");
        System.out.println(pa.toString());


        params params=new params();
        params.setAccount_id("135");
        params.setAccount_type("dd");
        ObjectMapper objectMapper=new ObjectMapper();
        String s = null;
        try {
            s = objectMapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s);

    }

}

class params{
    private String account_type;
    private String account_id;

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
}
class Xie{
    private String riddle;

    private String answer;

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Xie{" +
                "riddle='" + riddle + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}