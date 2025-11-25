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
    protected final int secsInDay = 86400;

    /**
     * Amount of seconds in an hour.
     */
    protected final int secsInHour = 3600;

    /**
     * Amount of seconds in a minute.
     */
    protected final int secsInMin = 60;
}
