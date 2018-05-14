package springweb.test1;

import java.time.LocalDate;
import java.time.Period;

public class Demo {

    public static void main(String[] args) {
        // Long now = new Date().getTime() - 1000 * 3600 * 24;
        //
        // long between = ChronoUnit.DAYS.between(new Date(now).toInstant(), new
        // Date().toInstant());
        // System.out.println(between);

        // Date date = new Date();
        // Instant instant = date.toInstant();
        // ZoneId zoneId = ZoneId.systemDefault();
        //
        // LocalDate endofCentury = instant.atZone(zoneId).toLocalDate();

        LocalDate endofCentury = LocalDate.of(2017, 5, 14);

        LocalDate now = LocalDate.now();

        Period diff = Period.between(endofCentury, now);

        System.out.printf("Difference is %d years, %d months and %d days old", diff.getYears(), diff.getMonths(),
                diff.getDays());
    }

}
