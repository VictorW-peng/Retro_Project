package com.example.common.object;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Supplier;

/**
 * @author: William.Peng
 * @date: 2022/11/29 15:24
 * @description:
 */
public class DateTime extends Date {
    private boolean mutable;
    private TimeZone timeZone;
    private Week firstDayOfWeek;
    private int minimalDaysInFirstWeek;
    public static boolean isNull(Object obj) {
        return null == obj || obj.equals((Object)null);
    }
    public DateTime(long timeMillis, TimeZone timeZone) {
        super(timeMillis);
        this.mutable = true;
        this.firstDayOfWeek = Week.MONDAY;
        this.timeZone = (TimeZone)defaultIfNull(timeZone, TimeZone::getDefault);
    }
    public static <T> T defaultIfNull(T object, T defaultValue) {
        return isNull(object) ? defaultValue : object;
    }

    public static <T> T defaultIfNull(T source, Supplier<? extends T> defaultValueSupplier) {
        return isNull(source) ? defaultValueSupplier.get() : source;
    }

    public DateTime(Date date, TimeZone timeZone) {
        this(((Date)defaultIfNull(date, new Date())).getTime(), timeZone);
    }

    public DateTime(Date date) {
        this(date, date instanceof DateTime ? ((DateTime)date).timeZone : TimeZone.getDefault());
    }


    public DateTime offset(DateField datePart, int offset) {
        if (DateField.ERA == datePart) {
            throw new IllegalArgumentException("ERA is not support offset!");
        } else {
            Calendar cal = this.toCalendar();
            cal.add(datePart.getValue(), offset);
            DateTime dt =  this;
            return dt.setTimeInternal(cal.getTimeInMillis());
        }
    }

    private DateTime setTimeInternal(long time) {
        super.setTime(time);
        return this;
    }

    public static boolean isArray(Object obj) {
        return null != obj && obj.getClass().isArray();
    }
    public Calendar toCalendar() {
        return this.toCalendar(Locale.getDefault(Locale.Category.FORMAT));
    }

    public Calendar toCalendar(Locale locale) {
        return this.toCalendar(this.timeZone, locale);
    }

    public Calendar toCalendar(TimeZone zone, Locale locale) {
        if (null == locale) {
            locale = Locale.getDefault(Locale.Category.FORMAT);
        }

        Calendar cal = null != zone ? Calendar.getInstance(zone, locale) : Calendar.getInstance(locale);
        cal.setFirstDayOfWeek(this.firstDayOfWeek.getValue());
        if (this.minimalDaysInFirstWeek > 0) {
            cal.setMinimalDaysInFirstWeek(this.minimalDaysInFirstWeek);
        }
        cal.setTime(this);
        return cal;
    }

}
