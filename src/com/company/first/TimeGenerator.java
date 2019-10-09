package com.company.first;

import java.time.LocalTime;

// static class created for generating random checkin and checkout times
public class TimeGenerator {

    // this method generates a time between 7am and noon
    public static LocalTime randomMorning() {
        int randomInt = (int)(6.0 * Math.random()) + 7;
        return LocalTime.of(randomInt, 0);
    }

    // this method generates a time between 1pm and 11pm
    public static LocalTime randomEvening() {
        int randomInt = (int)(11.0 * Math.random()) + 13;
        return LocalTime.of(randomInt, 0);
    }
}
