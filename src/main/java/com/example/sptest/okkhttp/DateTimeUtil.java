package com.example.sptest.okkhttp;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
    private static DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
    private static DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static LocalDateTime getLocalDateTime(long epochMillis) {
        Instant instant = Instant.ofEpochMilli(epochMillis);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        return zonedDateTime.toLocalDateTime();
    }

    private static LocalDate getLocalDate(long epochMillis) {
        return getLocalDateTime(epochMillis).toLocalDate();
    }

    private static long toEpochMillis(LocalDate date) {
        return date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000L;
    }

    public static long getDateStartEpochMillis(long epochMillis, int dayDelta) {
        LocalDate date = getLocalDate(epochMillis).plusDays(dayDelta);
        return toEpochMillis(date);
    }

    public static long getMonthStartEpochMillis(long epochMillis, int monthDelta) {
        LocalDate date = getLocalDate(epochMillis).plusMonths(monthDelta);
        LocalDate firstDay = LocalDate.of(date.getYear(), date.getMonthValue(), 1);
        return toEpochMillis(firstDay);
    }

    public static long getYearStartEpochMillis(long epochMillis, int yearDelta) {
        LocalDate date = getLocalDate(epochMillis).plusYears(yearDelta);
        LocalDate firstDay = LocalDate.of(date.getYear(), Month.JANUARY, 1);
        return toEpochMillis(firstDay);
    }

    public static String epochMillisToDateString(long epochMillis) {
        return dateFormatter.format(getLocalDate(epochMillis));
    }

    public static String epochMillisToMonthString(long epochMillis) {
        return monthFormatter.format(getLocalDate(epochMillis));
    }

    public static String epochMillisToYearString(long epochMillis) {
        return yearFormatter.format(getLocalDate(epochMillis));
    }

    public static long dateStringToEpochMillis(String date) {
        return toEpochMillis(LocalDate.parse(date, dateFormatter));
    }

    public static long monthStringToEpochMillis(String month) {
        return toEpochMillis(LocalDate.parse(month + "-01", dateFormatter));
    }

    public static long timeAndZoneToEpochMillis(String datetime, String zoneId) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetime, datetimeFormatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zoneId));
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static long timeAndDefaultZoneToEpochMillis(String datetime) {
        LocalDateTime localDateTime = LocalDateTime.parse(datetime, datetimeFormatter);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static String epochMillisToDefaultZoneTime(long epochMillis) {
        return datetimeFormatter.format(getLocalDateTime(epochMillis));
    }
}
