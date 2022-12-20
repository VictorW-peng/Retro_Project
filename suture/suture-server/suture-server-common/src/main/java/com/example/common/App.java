package com.example.common;

import com.example.common.object.DateField;
import com.example.common.object.DateTime;
import com.example.common.utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 * @author 10858683
 */
public class App {
    public static void main( String[] args ) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateStr = "2017-03-01 22:33:23";
        Date date2 = sdf.parse(dateStr);
        Date datef= new Date(new SimpleDateFormat(pattern).parse("2019-11-29 22:33:23").getTime());
        Date date = new Date();

        //结果：2017-03-03 22:33:23
        String newDate = DateUtil.offset(date2, DateField.MINUTE, 2);
        System.out.println(dateStr);
        System.out.println(newDate);
        System.out.println(DateUtil.offset(date2, DateField.HOUR, 2));
        System.out.println(DateUtil.offset(date2, DateField.DAY_OF_YEAR, 22));
        String test = "2017-03-01 22:33:23.0";
        System.out.println(test.substring(0, 19));

        String a = "1" ;
        String b = a ;
        System.out.println(a);
        System.out.println(b);
        b = "2";
        System.out.println(a);
        System.out.println(b);


    }
}
