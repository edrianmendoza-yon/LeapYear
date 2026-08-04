package leapyear;

/**
 * The class that determines if a given year is a leap year or not based on the
 * following criteria: A year is a leap year if it is divisible by 4. However, a
 * year is not a leap year if it is divisible by 100 unless it is also divisible
 * by 400.
 */
public class LeapYear {

    // Instance variable to store the year
    private int year;

    // Constructor to initialize the year
    public LeapYear(int year) {
        this.year = year;
    }

    // Method to check if the year is a leap year
    public boolean isLeapYear() {
        // A year is a leap year if:
        // It is divisible by 4, but not by 100, unless also divisible by
        // 400.
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Main method to test the LeapYear class
    public static void main(String[] args) {
        // Test cases to check the leap year logic

        // Test case 1: Year 2000 (Divisible by 400, hence leap year)
        LeapYear leapYear1 = new LeapYear(2000);
        System.out.println(leapYear1.isLeapYear()); // Output: true

        // Test case 2: Year 1900 (Divisible by 100, but not by 400, hence not a
        // leap year)
        LeapYear leapYear2 = new LeapYear(1900);
        System.out.println(leapYear2.isLeapYear()); // Output: false

        // Test case 3: Year 2016 (Divisible by 4, but not by 100, hence leap
        // year)
        LeapYear leapYear3 = new LeapYear(2016);
        System.out.println(leapYear3.isLeapYear()); // Output: true

        // Test case 4: Year 2017 (Not divisible by 4, hence not a leap year)
        LeapYear leapYear4 = new LeapYear(2017);
        System.out.println(leapYear4.isLeapYear()); // Output: false
    }
}
