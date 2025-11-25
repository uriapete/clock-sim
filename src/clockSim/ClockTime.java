/**
 * 
 */
package clockSim;

import java.util.ArrayList;

/**
 * @author Peter Uriarte
 * @version 0.1.0.0 (Epoch SemVer)
 * Data Type that handles conversion between Unix integer and Hours:Minutes:Seconds.
 */
public class ClockTime {
    /**
     * Number of seconds stored by this clock since midnight.
     */
    private int unixSeconds;

    /**
     * Amount of seconds in a day.
     */
    protected static final int secsInDay = 86400;

    /**
     * Amount of seconds in an hour.
     */
    protected static final int secsInHour = 3600;

    /**
     * Amount of seconds in a minute.
     */
    protected static final int secsInMin = 60;

    /**
     * Default time set for a no-argument constructor of ClockTime.
     */
    private static final int defaultTime = 0;

    /**
     * Constructor for ClockTime with a setting for the initial time.
     * @param initTime The inital time for this clock in seconds.
     */
    public ClockTime(int initTime){
        unixSeconds = initTime;
    }

    /**
     * Default Constructor for ClockTime, with a default initial time.
     */
    public ClockTime(){
        this(defaultTime);
    }

    /**
     * Returns the clock time as an array.
     * @return The clock time as an array, syled at [Seconds, Minutes, Hours]
     */
    protected int[] listTime(){
        // set up return list.
        ArrayList<Integer> timeList = new ArrayList<>(3);

        // loop time back if after 24 hours
        int dayTime = unixSeconds % secsInDay;

        // add seconds, minutes, hours
        // each item is the remainder from dividing by secsIn(x) members above

        // seconds is the remainder by dividing by minutes
        timeList.add((unixSeconds%secsInMin)/1);

        // minutes is the remainder from dividing by hours (then converting to minutes)
        timeList.add((unixSeconds%secsInHour)/secsInMin);

        // hours is the remainder from dividing by days (then converting to hours)
        timeList.add((unixSeconds%secsInDay)/secsInHour);
        
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

    public static void main(String[] args) {
        // testing for 5:26:57 PM -> 17:26:57
        int initTime = (17*secsInHour)+(26*secsInMin)+(57);
        ClockTime test = new ClockTime(initTime);
        // test OK

        System.out.println(test.stringTime());
    }
}
