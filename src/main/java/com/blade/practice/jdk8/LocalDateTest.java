package com.blade.practice.jdk8;

import com.blade.util.Sl4jLoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author blade
 * 2019/9/5 14:23
 */
public class LocalDateTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LocalDateTest.class);

    public static void main(String[] args) {
        LOGGER.error("abc{}", "efg", new Exception("自定义的"));
        Sl4jLoggerUtils.error(LOGGER, new Exception("自定义的"), "abc{}", "efg");
//        testLocalDate();
    }

    private static void testLocalDate() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(localDate.minusDays(localDate.getDayOfMonth() - 1));
        System.out.println(localDate.plusDays(localDate.lengthOfMonth() - localDate.getDayOfMonth()).plusDays(1).atStartOfDay());

        localDate = localDate.plusMonths(1);
        System.out.println(localDate);

        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getMonth().getValue());
        localDate = localDate.minusMonths(2).minusDays(localDate.getDayOfMonth() - 1);
        System.out.println(localDate);
        System.out.println(localDate.getMonth().maxLength());
        localDate = localDate.plusDays(localDate.getMonth().maxLength() - 1);
        System.out.println(localDate);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        System.out.println(localDateTime);
        System.out.println(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(LocalDateTime.parse("2017-05-04 12:12:12", dtf));

        System.out.println(localDateTime.format(dtf));


    }
}
