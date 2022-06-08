package team.arcticfox.frms.dataset;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    @JSONField(name = "year")
    public int year;
    @JSONField(name = "month", ordinal = 1)
    public int month;
    @JSONField(name = "day", ordinal = 2)
    public int day;
    @JSONField(name = "hour", ordinal = 3)
    public int hour;
    @JSONField(name = "minute", ordinal = 4)
    public int minute;
    @JSONField(name = "second", ordinal = 5)
    public int second;

    public DateTime(int year, int month, int day, int hour, int minute, int second) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // yyyy-mm-dd hh:mm:ss
    public static DateTime parse(String str) {
        String[] list = str.split(" ");
        String[] date = list[0].split("-");
        String[] time = list[1].split(":");
        return new DateTime(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]),
                Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2])
        );
    }

    public static DateTime now() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return parse(df.format(new Date()));
    }

    public long timeToLong() {
        return hour * 10000 + minute * 100 + second;
    }

    @Override
    public String toString() {
        return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day)
                + " "
                + String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
    }
}

