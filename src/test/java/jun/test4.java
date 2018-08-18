package jun;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class test4 {

    //@Test
    public  void test1(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        String s = simpleDateFormat.format(date);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        Instant instant = date.toInstant();
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        LocalDate localDate1 = localDate.plusDays(1);
        Date date1 = Date.from(localDate1.atStartOfDay(defaultZoneId).toInstant());
        System.out.println(date1);
    }

    @Test
    public  void test() throws IOException {
        String msg="%7B%22update_time%22:%222017-08-07%2018:19:05%22,%22payment%22:%2211.00%22,%22tid%22:%22E20170807181905034500002%22,%22status%22:%22TRADE_CLOSED%22%7D";

        String decode = URLDecoder.decode(msg, "utf-8");
        System.out.println(decode);

        ObjectMapper mapper=new ObjectMapper();

        Msg value = mapper.readValue(decode, Msg.class);
        System.out.println(value);


    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class  Msg{
    private String status;
    private String update_time;
    private Double payment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "status='" + status + '\'' +
                ", update_time='" + update_time + '\'' +
                ", payment=" + payment +
                '}';
    }
}