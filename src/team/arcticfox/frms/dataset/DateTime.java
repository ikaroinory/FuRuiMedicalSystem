package team.arcticfox.frms.dataset;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    private final int year;
    private final int month;
    private final int day;
    private final int hour;
    private final int minute;
    private final int second;

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
