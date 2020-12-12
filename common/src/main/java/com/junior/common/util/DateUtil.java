package com.junior.common.util;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author wangyiwengetTimeStamp
 * @version 1.0 Created in 2019-10-17 10:27
 */
public class DateUtil {


    private DateUtil() {
    }

    public static long now() {
        return System.currentTimeMillis();
    }

    public static String formatDate(long time) {
        return format(time, "yyyyMMdd");
    }

    public static String formatTime(long time) {
        return format(time, "HHmmss");
    }

    public static String format(long time) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return dtf.format(localDateTime);
    }

    public static String format(long time, String pattern) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dtf.format(localDateTime);
    }

    @SneakyThrows
    public static Long formatToLong(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.parse(date).getTime();
    }

    @SneakyThrows
    public static Long formatToLong(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date).getTime();
    }

    public static void main(String[] args) {


        System.out.println(zero());
    }
    //今天的00：00:00
    public static long zero() {
        long current = System.currentTimeMillis();
        long zero = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        return zero;

    }  public static long twelve() {
        long current = System.currentTimeMillis();
        long zero = current/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        long twelve=zero+24*60*60*1000-1;//今天23点59分59秒的毫秒数
        return twelve;
    }

    public static Long getTodayZeroPointTimestamps() {
        long currentTimestamps = System.currentTimeMillis();
        long oneDayTimestamps = 60 * 60 * 24 * 1000L;
        return currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps;
    }

    public static Long getYesterdayZeroPointTimestamps() {
        return getTodayZeroPointTimestamps() - 60 * 60 * 24 * 1000L;
    }

    public static Long getTomorrowZeroPointTimestamps() {
        return getTodayZeroPointTimestamps() + 60 * 60 * 24 * 1000L;
    }


    public static Long getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        //周日为第一天
        return cal.getTimeInMillis() - (60 * 60 * 24 * 1000L);
    }

    /**
     * 获取上周日期范围
     */
    @SneakyThrows
    public static List<Long> getLastWeekRange() {
        LocalDate today = LocalDate.now();
        DayOfWeek week = today.getDayOfWeek();
        int value = week.getValue();
        String monday = today.minusDays(value - 1L).minusDays(7L).toString();
        System.out.println(monday);
        String sunday = today.plusDays(7L - value).minusDays(7L).toString();
        System.out.println(sunday);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long mondayMS = sdf.parse(monday).getTime();
        long sundayMS = sdf.parse(sunday).getTime();
        return Lists.newArrayList(mondayMS, sundayMS);
    }

    public static List<String> getLastWeekRangeStr() {
        LocalDate today = LocalDate.now();
        DayOfWeek week = today.getDayOfWeek();
        int value = week.getValue();
        String monday = today.minusDays(value - 1L).minusDays(7L).toString();
        System.out.println(monday);
        String sunday = today.plusDays(7L - value).minusDays(7L).toString();
        System.out.println(sunday);
        return Lists.newArrayList(monday, sunday);
    }


    public static Long getMonthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(now()));

        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH, 1);
        //将小时至0
        c.set(Calendar.HOUR_OF_DAY, 0);
        //将分钟至0
        c.set(Calendar.MINUTE, 0);
        //将秒至0
        c.set(Calendar.SECOND, 0);
        //将毫秒至0
        c.set(Calendar.MILLISECOND, 0);
        // 获取本月第一天的时间戳
        return c.getTimeInMillis();
    }

    public static  Long nextMonth(){
        Date date = new Date();
        int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));//取到年份值
        int month=Integer.parseInt(new SimpleDateFormat("MM").format(date))+1;//取到鱼粉值
        int day=Integer.parseInt(new SimpleDateFormat("dd").format(date));//取到天值
        int time = Integer.parseInt(new SimpleDateFormat("HH").format(date));//时
        int min = Integer.parseInt(new SimpleDateFormat("mm").format(date));//分
        int ss = Integer.parseInt(new SimpleDateFormat("ss").format(date));//秒
        if(month==0){
            year-=1;month=12;
        }
        else if(day>28){
            if(month==2){
                if(year%400==0||(year %4==0&&year%100!=0)){
                    day=29;
                }else day=28;
            }else if((month==4||month==6||month==9||month==11)&&day==31)
            {
                day=30;
            }
        }
        String y = year+"";String m ="";String d ="";
        if(month<10) m = "0"+month;
        else m=month+"";
        if(day<10) d = "0"+day;
        else d = day+"";
        String dateStr = y + "-" + m + "-" + d+" "+time+":"+min+":"+ss;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time1 = 0L;
        try {
            time1 = format.parse(dateStr).getTime();
        }catch (Exception e){
            e.printStackTrace();
        }
        return time1;
    }

    /**
     * 获取0点的时间戳
     *  day传0代表今天0点的时间戳，day传-1代表昨天0点的时间戳，day传-7代表一周前0点的时间戳
     *  时间戳为毫秒值
     * @param day
     * @return
     */
    public static Long getTimeStamp(int day) {
        //初始化一个long值，用于接收数据
        Long time = 0L;
        //Calendar工具类
        Calendar calendar = new GregorianCalendar();
        //获取当前时间的XXX小时，并替换为0
        calendar.set(Calendar.HOUR_OF_DAY,0);
        //获取当前时间的XXX分钟，并替换为0
        calendar.set(Calendar.MINUTE,0);
        //获取当前时间的XXX秒钟，并替换为0
        calendar.set(Calendar.SECOND,0);
        calendar.add(Calendar.DATE,day);
        //转换为毫秒值
        time = calendar.getTimeInMillis();
        return time;
    }


}
