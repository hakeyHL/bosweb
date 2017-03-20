package com.bos.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by linux on 2017年03月20日.
 * Time 08:01
 */
public class TimeUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 以指定格式的日期返回字符串日期
     *
     * @param date   日期对象
     * @param format 日期格式化格式
     * @return
     */
    public static String getForMatString(Date date, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(simpleDateFormat);
    }

    /**
     * 返回yyyy-MM-dd HH:mm:ss 格式的日期
     *
     * @param date
     * @return
     */
    public static String getYMDHMSString(Date date) {
        return sdf.format(date);
    }
}
