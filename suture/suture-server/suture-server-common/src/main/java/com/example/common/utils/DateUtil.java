package com.example.common.utils;

import com.example.common.object.DateField;
import com.example.common.object.DateTime;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: William.Peng
 * @date: 2022/11/29 15:18
 * @description:
 */
public class DateUtil {
    static String pattern = "yyyy-MM-dd HH:mm:ss";
    public static DateTime dateNew(Date date) {
        return new DateTime(date);
    }

    public static String offset(Date date, DateField dateField, int offset) {
        DateTime afterOffset = dateNew(date).offset(dateField, offset);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(afterOffset);
    }

}
