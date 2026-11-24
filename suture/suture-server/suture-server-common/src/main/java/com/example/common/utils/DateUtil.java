package com.example.common.utils;

import com.example.common.object.DateField;
import com.example.common.object.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具。
 *
 * @author William.Peng
 */
public final class DateUtil {

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private DateUtil() {
    }

    public static DateTime dateNew(Date date) {
        return new DateTime(date);
    }

    public static String offset(Date date, DateField dateField, int offset) {
        DateTime afterOffset = dateNew(date).offset(dateField, offset);
        return new SimpleDateFormat(DEFAULT_PATTERN).format(afterOffset);
    }
}
