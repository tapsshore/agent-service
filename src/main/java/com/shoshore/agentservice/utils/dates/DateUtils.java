package com.shoshore.agentservice.utils.dates;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

import static com.shoshore.agentservice.utils.criteria.CriteriaConstants.DATE_RANGE_DELIMITER;
import static com.shoshore.agentservice.utils.criteria.CriteriaConstants.RANGE_PATTERN;

public interface DateUtils {

    static Date getEndOfDay(Date date) {
        if (date == null) {
            return date;
        }
        final LocalDate localDate = dateToLocalDate(date);
        final LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    static Date getStartOfDay(Date date) {
        if (date == null) {
            return date;
        }
        final LocalDate localDate = dateToLocalDate(date);
        final LocalDateTime startOfDay = localDate.atTime(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    static Date localDateToDate(LocalDate startOfDay) {
        return Date.from(startOfDay.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
    }

    static LocalDate dateToLocalDate(Date date) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault()).toLocalDate();
    }

    static boolean isDateBeforeAndNotSameDay(final Date date1, final Date date2) {
        final LocalDateTime localDateTime1 = dateToLocalDateTime(date1);
        final LocalDateTime localDateTime2 = dateToLocalDateTime(date2);
        if (localDateTime1.with(LocalTime.MAX).isEqual(localDateTime2.with(LocalTime.MAX))) {
            return false;
        }
        return localDateTime1.isBefore(localDateTime2);
    }

    static boolean isDateBeforeOrSameDay(final Date date1, final Date date2) {
        final LocalDateTime localDateTime1 = dateToLocalDateTime(date1);
        final LocalDateTime localDateTime2 = dateToLocalDateTime(date2);
        if (localDateTime1.with(LocalTime.MAX).isEqual(localDateTime2.with(LocalTime.MAX))) {
        }
        return localDateTime1.isBefore(localDateTime2);
    }

    static boolean isDateBefore(final Date date1, final Date date2) {
        final LocalDateTime localDateTime1 = dateToLocalDateTime(date1);
        final LocalDateTime localDateTime2 = dateToLocalDateTime(date2);
        return localDateTime1.isBefore(localDateTime2);
    }

    static String formatSimpleDateNoTime(final Date dateParam) {
        final LocalDateTime localDateTime = dateToLocalDateTime(dateParam);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDateTime.format(formatter);
    }

    static String formatSimpleDate(final Date dateParam) {
        final LocalDateTime localDateTime = dateToLocalDateTime(dateParam);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimeFormatter.ISO_DATE_TIME.toString());
        return localDateTime.format(formatter);
    }

    static Date getDateFromString(String sourceDate, String datePattern) {
        LocalDate localDate = LocalDate.parse(sourceDate, DateTimeFormatter.ofPattern(datePattern, Locale.ENGLISH));
        return localDateToDate(localDate);
    }

    static LocalDate getLocalDateFromString(String sourceDate, String datePattern) {
        return LocalDate.parse(sourceDate, DateTimeFormatter.ofPattern(datePattern, Locale.ENGLISH));
    }

    static String formatToRangeDate(final Date date1, final Date date2) {
        //08/01/2013 1:00 PM - 08/01/2013 1:30 PM
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RANGE_PATTERN);
        return dateToLocalDateTime(date1).format(formatter) + DATE_RANGE_DELIMITER + dateToLocalDateTime(date2).format(formatter);
    }

    static LocalDate convertSimpleDate(final String text) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(text, dateTimeFormatter);
    }

    static String formatDefaultDateRange() {
        return formatToRangeDate(new Date(), org.apache.commons.lang3.time.DateUtils.addHours(new Date(), 1));
    }

    static List<Date> readDateRange(final String dateRange) {
        final List<Date> dates = new LinkedList<>();
        final String[] tokens = dateRange.split(DATE_RANGE_DELIMITER);
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendPattern(RANGE_PATTERN)
                .toFormatter();
        final LocalDateTime localDateTime1 = LocalDateTime.parse(tokens[0].trim(), formatter);
        dates.add(localDateTimeToDate(localDateTime1));
        dates.add(localDateTimeToDate(LocalDateTime.parse(tokens[1].trim(), formatter)));
        return dates;

    }

    static Date addDays(final Date date, final int days) {
        if (date == null) {
            return null;
        }
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    static Date addDaysToDate(final Date date, final int daysToAdd) {
        if (date == null) {
            return null;
        }
        if (daysToAdd < 0) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, daysToAdd);
        return cal.getTime();
    }

    static Date calculateExpiryDate(final Date date) {
        return endOfYear(date);
    }

    static Date endOfYear(final Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.MONTH, Calendar.DECEMBER);
        cld.set(Calendar.DAY_OF_MONTH, 31);
        return getEndOfDay(cld.getTime());
    }

    static Date beginningOfYear(final Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.MONTH, Calendar.JANUARY);
        cld.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(cld.getTime());
    }

    static LocalDate addWorkingDays(LocalDate date, final int workdays, final List<LocalDate> holidays) {
        if (workdays < 1) {
            return date;
        }

        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY
                    || result.getDayOfWeek() == DayOfWeek.SUNDAY
                    || isHolidayDate(result, holidays))) {
                ++addedDays;
            }
        }

        return result;
    }

    static boolean isSameDate(final LocalDate localDate1, final LocalDate localDate2) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate1.format(formatter).equalsIgnoreCase(localDate2.format(formatter));
    }

    static boolean isHolidayDate(final LocalDate localDate1, final List<LocalDate> holidays) {
        for (final LocalDate localDate2 : holidays) {
            if (isSameDate(localDate1, localDate2)) {
                return true;
            }
        }
        return false;
    }

    static Date addWorkingDays(Date date, final int workdays, final List<String> holidays) {
        final String datePattern = "dd-MM-yyyy";
        final int currentYear = LocalDate.now().getYear();
        List<LocalDate> localDates = new ArrayList<>();
        for (final String ddMM : holidays) {
            localDates.add(getLocalDateFromString(ddMM + "-" + currentYear, datePattern));
        }
        final LocalDate localDate = dateToLocalDate(date);
        return localDateToDate(addWorkingDays(localDate, workdays, localDates));
    }
}
