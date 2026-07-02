package org.psnbtech;

/**
 * Sample Java code that intentionally includes specific statement forms for
 * AST and call-graph extraction.
 */
public class StatementConstructSamples {

	private final Object lock = new Object();
	private int counter;

	public void runSamples(String value) {
		validateValue(value);
		incrementCounter();
		selectOutcome(value.length());
	}

	public void validateValue(String value) {
		if (value == null || value.isEmpty()) {
			throw new IllegalArgumentException("value must not be null or empty");
		}
	}

	public void incrementCounter() {
		synchronized (lock) {
			counter++;
			logCounter(counter);
		}
	}

	public int selectOutcome(int input) {
		return switch (input % 3) {
			case 0 -> {
				prepareOutcome("zero");
				yield 0;
			}
			case 1 -> {
				prepareOutcome("one");
				yield 1;
			}
			default -> {
				prepareOutcome("other");
				yield 2;
			}
		};
	}

	private void prepareOutcome(String label) {
		System.out.println("Preparing outcome: " + label);
	}

	private void logCounter(int currentCounter) {
		System.out.println("Counter: " + currentCounter);
	}

	public static void main(String[] args) {
		StatementConstructSamples samples = new StatementConstructSamples();
		samples.runSamples(args.length > 0 ? args[0] : "sample");
	}
}