package clockSim;

/**
 * Class that represents a sundial.
 * @author Luis Martinez & Peter Uriarte
 * @version 0.1.1.0 - Add method displayTime()
 */
public class SundialClock extends NaturalClock {

    /**
     * How much drift a sundial experiences per second.
     */
    private static final double DRIFT_PER_SECOND = 0;

    /**
     * Constructor with a default initial time.
     */
    public SundialClock() {
        super(DRIFT_PER_SECOND);
    }

    @Override
    protected void reset() {
        super.clockTime.reset();
    }

    @Override
    protected void tick() {
        super.clockTime.tick();
    }

    @Override
    public void displayTime() {
        final String name = "Sundial Clock";
        System.out.printf("%-18s time [%s] - total drift = %d seconds",
            name+" ",
            super.clockTime.stringTime(),
            (int)Math.round(super.driftPerSecond*super.clockTime.getUnixSeconds())
        );

        // outputs:
        // Sundial Clock time [00:00:00] - total drift = 0 seconds

        System.out.println();
    }

    public static void main(String[] args) {
        SundialClock test = new SundialClock();

        // tests display time
        test.displayTime();
        // OK

        // tick clock for 6 mins
        for (int i = 0; i < 360; i++) {
            test.tick();
        }
        // confirm with display
        test.displayTime();

        // test reset and confirm
        test.reset();
        test.displayTime();
    }

}
