package springweb;

import java.time.LocalDate;

public class Demo1 {
    public static void main(String[] args) {

        LocalDate STARTDATE = LocalDate.of(2018, 4, 10);

        LocalDate ENDDATE = LocalDate.of(2018, 5, 11);

        LocalDate nDate = LocalDate.of(2018, 5, 11);

        System.out.println(nDate.isAfter(STARTDATE));
        System.out.println(nDate.isBefore(ENDDATE));

    }

}
