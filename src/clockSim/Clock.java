/**
 * 
 */
package clockSim;

import java.util.ArrayList;

/**
 * Base class for all Clocks. Contains:
 * Integer clockTime,
 * double driftPerSecond,
 * virtual (empty) methods reset, tick, displayTime.
 */
abstract class Clock {
    /**
     * Current time stored in a clock, stored as an integer which emulates Unix time behaviour.
     */
    protected int clockTime;

    /**
     * How much this clock drifts away from "true" time every second.
     */
    private double driftPerSecond;

    /**
     * Amount of seconds in a day.
     */
    protected final int secsInDay = 86400;

    /**
     * Amount of seconds in an hour.
     */
    protected final int secsInHour = 3600;

    /**
     * Amount of seconds in a minute.
     */
    protected final int secsInMin = 60;

    /**
     * Returns clockTime to 0.
     */
    protected abstract void reset();

    /**
     * Advances the clock by a virtual second.
     * The clock's display will advance one second, but true time may advance more due to drift.
     */
    protected abstract void tick();

    /**
     * Returns the clock time as an array.
     * @return The clock time as an array, syled at [Seconds, Minutes, Hours]
     */
    protected int[] listTime(){
        // set up return list.
        ArrayList<Integer> timeList = new ArrayList<>(3);

        // loop time back if after 24 hours
        int dayTime = clockTime % secsInDay;

        // add seconds, minutes, hours
        timeList.add(dayTime%secsInMin);
        timeList.add(dayTime/secsInMin);
        timeList.add(dayTime/secsInHour);
        
        // convert to true array
        int[] timeArr = new int[3];
        for (int i = 0; i < timeList.size(); i++) {
            Integer tm = timeList.get(i);
            timeArr[i]=tm;
        }

        // return true array
        return timeArr;
    }

    /**
     * Formats the clock time as a string.
     * @return The string that represents the clock time in the format HH:MM:SS
     */
    protected String stringTime(){
        // get the time in array form.
        int[] timeArr = listTime();

        // prepare return string.
        String timeStr = "";

        // for each value in array (going in order: hour, minute, second)
        for(int i = timeArr.length-1;i>=0;--i){
            // add the formatted string (if string is less than 2 chars, pad with 0s)
            timeStr+=String.format("%02d", timeArr[i]);

            // if this is not the end of string, add ":"
            if (i>0) {
                timeStr+=":";
            }
        }

        // return string
        return timeStr;
    }

    /**
     * Displays time in terminal.
     */
    public abstract void displayTime();
}
