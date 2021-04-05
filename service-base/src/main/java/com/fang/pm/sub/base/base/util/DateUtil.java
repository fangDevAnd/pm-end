package com.fang.pm.sub.base.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    public static String dateForType(long time, int type) {
        String[] types = {
                "YYYY-MM-dd hh:mm:ss",
                "YYYY-MM-dd hh:mm",
                "YYYY-MM-dd hh",
                "YYYY-MM-dd",
        };
        SimpleDateFormat format = new SimpleDateFormat(types[type]);
        return format.format(new Date(time));
    }


}
