package com.common.page.util.filter;

/**
 * 
 * @author loudyn
 * 
 */
public class SensitiveWordMonitor {

	/**
	 * 
	 * @author loudyn
	 * 
	 */
	private static enum State {
		FOUND, NOT_FOUND
	}

	private static final ThreadLocal<State> HOLDER = new ThreadLocal<State>() {

		@Override
		protected State initialValue() {
			return State.NOT_FOUND;
		}
	};

	/**
	 * 
	 */
	public static void found() {
		HOLDER.set(State.FOUND);
	}

	/**
	 * 
	 */
	public static void notFound() {
		HOLDER.set(State.NOT_FOUND);
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isFound() {
		if (null == HOLDER.get()) {
			return false;
		}

		return HOLDER.get() == State.FOUND;
	}

}
