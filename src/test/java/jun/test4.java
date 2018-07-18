package jun;


import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class test4 {

    @Test
    public  void test(){
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
}
