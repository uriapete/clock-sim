package clockSim;

/**
 * Class that represents a sundial.
 * @author Luis Martinez
 * @version 0.1.0.0 - Create class
 */
public class SundialClock extends NaturalClock {

    /**
     * Constructor with a default initial time.
     */
    public SundialClock() {
        super(0);
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
    }

}
