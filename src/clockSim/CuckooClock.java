package clockSim;

/**
 * Class that represents a Cuckoo Clock. (Cuckoo! Cuckoo!)
 * @author Luis Martinez & Peter Uriarte
 * @version 0.1.1.0 (marketing.BREAKING.Features.patch) - implement abstracts
 */
public class CuckooClock extends MechanicalClock {

    /**
     * How much drift a cuckoo clock experiences per second.
     */
    private static final double DRIFT_PER_SECOND = 0.000694444;

    /**
     * Default constructor with a default initial time.
     */
    public CuckooClock() {
        super(DRIFT_PER_SECOND);
    }@Override
    protected void reset() {
        super.clockTime.reset();
    }

    @Override
    protected void tick() {
        super.clockTime.tick();
    }

    @Override
    public void displayTime() {
        final String name = "Cuckoo Clock";
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
        CuckooClock test = new CuckooClock();

        // tests display time
        System.out.println("Init");
        test.displayTime();
        // OK

        // tick clock for 6 mins
        for (int i = 0; i < 360; i++) {
            test.tick();
        }
        // confirm with display
        System.out.println("After 6mins");
        test.displayTime();

        // test reset and confirm
        test.reset();
        System.out.println("After reset");
        test.displayTime();
    }

}
