/**
 * 
 */
package clockSim;

/**
 * A program that simulates workflow of multiple types of clocks for a week and compares how much they drift from real time.
 * @author Peter Uriarte
 * @version 0.1.4.0 (MARKETING.BREAKING.FEATURE.PATCH) - Add GrandfatherClock
 */
public class ClockSimulator {

	/**
	 * Creates a collection of different clocks, and compares their drift from creation to a week later.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// how many seconds in a week?
		int secsInWeek = 604800;

		// list of clocks
		Clock[] clocks = {
			new SundialClock(),
			new CuckooClock(),
			new GrandfatherClock(),
			new WristClock(),
		};

		/*
		Expected output:
		Reported clock times after resetting:
		=====================================
		Sundial Clock time [00:00:00] - total drift = 0 seconds
		Cuckoo Clock time [00:00:00] - total drift = 0 seconds
		Grandfather Clock time [00:00:00] - total drift = 0 seconds
		Wrist Clock time [00:00:00] - total drift = 0 seconds
		Atomic Clock time [00:00:00] - total drift = 0 seconds

		Running the clocks for one (1) week...

		Reported clock times after running:
		===================================
		Sundial Clock time [00:00:00] - total drift = 0 seconds
		Cuckoo Clock time [00:00:00] - total drift = 420 seconds
		Grandfather Clock time [00:00:00] - total drift = 210 seconds
		Wrist Clock time [00:00:00] - total drift = 20.9999 seconds
		Atomic Clock time [00:00:00] - total drift = 0 seconds
		 */

		System.out.println("Reported clock times after resetting:");
		System.out.println("=====================================");

		// for each clock, display time
		for (Clock clock : clocks) {
			clock.displayTime();
		}

		System.out.println();
		System.out.println("Running the clocks for one (1) week...");
		System.out.println();

		System.out.println("Reported clock times after running:");
		System.out.println("=====================================");

		// for each clock, advance by week, display
		for (Clock clock : clocks) {
			for (int i = 0; i < secsInWeek; i++) {
				clock.tick();
			}
			clock.displayTime();
		}
	}

}
