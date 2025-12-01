package clockSim;

/**
 * Class that represents a Wrist Clock.
 * @authour Luis Martinez & Peter Uriarte
 * @version 0.1.1.0 - implement abstracts
 */

public class WristClock extends DigitalClock {
	
	/**
	 * How much drift a wrist clock experiences per second.
	 */
	private static final double DRIFT_PER_SECOND = 0.000034722;
	
	/**
	 * Default constructor with a default initial time.
	 */
	public WristClock() {
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
		final String name = "WristClock";
		System.out.printf("%-18s time [%s] - total drift = %d seconds",
				name+" ",
				super.clockTime.stringTime(),
				(int)Math.round(super.driftPerSecond*super.clockTime.getUnixSeconds())
		);
		
		// outputs:
		// Wrist Clock [00:00:00] - total drift = 0 seconds
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		WristClock test = new WristClock();
		
		// tests display time
		System.out.println("Init");
		test.displayTime();
		//OK
		
		//tick clock for 6 mins
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
