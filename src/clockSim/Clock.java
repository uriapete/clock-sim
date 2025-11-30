/**
 * 
 */
package clockSim;

/**
 * Base class for all Clocks. Contains:
 * Integer clockTime,
 * double driftPerSecond,
 * virtual (empty) methods reset, tick, displayTime.
 * @author Peter Uriarte & Luis Martinez
 * @version 0.1.1.0 - driftPerSecond now protected instead of private
 */
abstract class Clock {
    /**
     * Current time stored in a clock, stored as an integer which emulates Unix time behaviour.
     */
    protected ClockTime clockTime;

    /**
     * How much this clock drifts away from "true" time every second.
     */
    protected double driftPerSecond;

    /**
     * Constructor.
     * @param drift How much this clock drifts away from real time per tick (virtual second)
     * @param initTime What time this clock starts at.
     */
    public Clock(double drift, int initTime){
        driftPerSecond = drift;
        clockTime = new ClockTime(initTime);
    }

    /**
     * Constructor, with default value defined in ClockTime used as the initial time.
     * @param drift How much this clock drifts away from real time per tick (virtual second)
     */
    public Clock(double drift){
        driftPerSecond = drift;
        clockTime = new ClockTime();
    }

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
     * Displays time in terminal.
     */
    public abstract void displayTime();
}
