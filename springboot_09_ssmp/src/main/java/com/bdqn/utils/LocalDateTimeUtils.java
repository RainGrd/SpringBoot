package com.bdqn.utils;

import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @BelongsProject: spring_ioc
 * @BelongsPackage: com.recruitment.util
 * @Author: RainGrd
 * @CreateTime: 2022-06-26  09:18
 * @Description: 时间格式化工具类
 * @Version: 1.0
 */
public class LocalDateTimeUtils {
    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time) {
        /*判断是否为空*/
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        /*格式化*/
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd
     */
    public static String convertLongTimeToStringYMD(Long time) {
        if (StringUtils.isEmpty(time)) {
            return null;
        }
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

    /**
     * 将字符串转换为Long类型的时间戳 格式为：yyyy-MM-dd HH:mm:ss
     * @param time
     * @return
     */
    public static Long convertTimeToLong(String time) {
        if (StringUtils.isEmpty(time)) {
            throw new IllegalArgumentException("事件参数异常");
        }
        /*格式化*/
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    /**
     * 将字符串转换为Long类型的时间戳 格式为：yyyy-MM-dd
     * @param time 需要格式化的字符串
     * @return java.lang.Long
     */
    public static Long convertTimeToLongYMD(String time) {
        if (StringUtils.isEmpty(time)) {
            throw new IllegalArgumentException("事件参数异常");
        }
        /*格式化*/
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 将日期转换为字符串 格式为:yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(ftf);
    }

    /**
     * 将日期格式化为字符串 格式为:yyyy-MM-dd
     */
    public static String convertStringTimeToStringYMD(LocalDateTime localDateTime){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return localDateTime.format(ftf);
    }
    /**
     * 将字符串转换为时间 格式为：yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime convertTimeToDate(String time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(time,ftf);
    }

    /**
     * 将字符串转换为时间 格式为：yyyy-MM-dd
     */
    public static LocalDateTime convertTimeToDateYMD(String time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDateTime.parse(time,ftf);
    }

}
