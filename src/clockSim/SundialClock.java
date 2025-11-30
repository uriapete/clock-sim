package clockSim;

/**
 * Class that represents a sundial.
 * @author Luis Martinez
 * @version 0.1.0.0 - Create class
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
        System.out.printf("%18s", name+" ");
    }

}
