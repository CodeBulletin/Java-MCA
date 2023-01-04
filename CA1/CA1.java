import java.util.Calendar;
import java.util.Locale;

public class CA1 {
    public static void main(String[] args) {
        int year = 2020;
        int month = 2;
        int day = 29;
        
        System.out.println("Is leap year: " +
            DateUtil.isLeapYear(year));
        System.out.println("Is valid date: " +
            DateUtil.isValidDate(year, month, day));
        System.out.println("Day of week: " +
            DateUtil.getDayOfWeek(year, month, day));
        System.out.println("Date string: " +
            DateUtil.toString(year, month, day));
    }
}

class DateUtil {
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }
    
    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) {
                    return false;
                }
            } else {
                if (day > 28) {
                    return false;
                }
            }
        } else if (
            month == 4 ||
            month == 6 ||
            month == 9 ||
            month == 11) {
            if (day > 30) {
                return false;
            }
        }
        return true;
    }
    
    public static int getDayOfWeek(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }
    
    public static String toString(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        String dayOfWeek = cal.getDisplayName(
            Calendar.DAY_OF_WEEK,
            Calendar.LONG,
            Locale.getDefault());
        String monthName = cal.getDisplayName(
            Calendar.MONTH,
            Calendar.LONG,
            Locale.getDefault());
        return String.format("%s %d %s %d", dayOfWeek, day, monthName, year);
    }
}