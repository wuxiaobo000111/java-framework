package com.bobo.springcloud.learn.gatewayprodicatedemo.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String getUTCTimeNow () {
        String format = ZonedDateTime.now().minusHours(1).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
        return format;
    }

    public static void main(String[] args) {
        String utcTimeNow = getUTCTimeNow();
        System.out.println(utcTimeNow);
    }
}
