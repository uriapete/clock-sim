package clockSim;

/**
 * Class that represents an Atomic Clock. (Zoom! You can't see me!)
 * @author Luis Martinez & Peter Uriarte
 * @version 0.1.1.0 (marketing.BREAKING.Features.patch) - Implement object
 */
public class AtomicClock extends QuantumClock {

    /**
     * How much drift an atomic clock experiences per second.
     */
    private static final double DRIFT_PER_SECOND = 0;

    /**
     * Default constructor with a default initial time.
     */
    public AtomicClock() {
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
        final String name = "Atomic Clock";
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
        AtomicClock test = new AtomicClock();

        // tests display time
        System.out.println("Init");
        test.displayTime();
        // OK

        // tick clock for a day
        for (int i = 0; i < (24*3600); i++) {
            test.tick();
        }
        // confirm with display
        // should be 0 seconds
        System.out.println("After 24 hours");
        test.displayTime();

        // test reset and confirm
        test.reset();
        System.out.println("After reset");
        test.displayTime();
    }
}
