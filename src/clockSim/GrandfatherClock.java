package clockSim;

/**
 * Class that represents a Grandfather Clock. (Bong! Bong!)
 * @author Luis Martinez & Peter Uriarte
 * @version 0.1.1.1 (marketing.BREAKING.Features.patch) - Correct test output in main
 */
public class GrandfatherClock extends MechanicalClock {

    /**
     * How much drift a cuckoo clock experiences per second.
     */
    private static final double DRIFT_PER_SECOND = 0.000347222;

    /**
     * Default constructor with a default initial time.
     */
    public GrandfatherClock() {
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
        final String name = "Grandfather Clock";
        System.out.printf("%-18s time [%s] - total drift = %d seconds",
            name+" ",
            super.clockTime.stringTime(),
            (int)Math.round(super.driftPerSecond*super.clockTime.getUnixSeconds())
        );

        // outputs:
        // Cuckoo Clock time [00:00:00] - total drift = 0 seconds

        System.out.println();
    }

    public static void main(String[] args) {
        GrandfatherClock test = new GrandfatherClock();

        // tests display time
        System.out.println("Init");
        test.displayTime();
        // OK

        // tick clock for a day
        for (int i = 0; i < (24*3600); i++) {
            test.tick();
        }
        // confirm with display
        // should be 30 seconds
        System.out.println("After 24 hours");
        test.displayTime();

        // test reset and confirm
        test.reset();
        System.out.println("After reset");
        test.displayTime();
    }
}
