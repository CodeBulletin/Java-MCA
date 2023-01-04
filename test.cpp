// Create main method
int main(int argc, char const *argv[])
{
    
    return 0;
}

// method to callculate days between two dates
int calculateDays(int day1, int month1, int year1, int day2, int month2, int year2)
{
    // create two dates
    Date date1(day1, month1, year1);
    Date date2(day2, month2, year2);
    // return days between two dates
    return date1.daysBetween(date2);
}
