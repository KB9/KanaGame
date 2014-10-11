package main;

public class GameClock {
	
	private static int TIME_ACCELERATION_FACTOR = 96;

	private static int mTotalMilliseconds;
	private static int mMilliseconds, mSeconds, mMinutes, mHours;
	
	public static void tick(int milliseconds) {
		mTotalMilliseconds += (milliseconds * TIME_ACCELERATION_FACTOR);
		
		updateRealTime();
	}
	
	private static void updateRealTime() {
		mMilliseconds = mTotalMilliseconds % 1000;
		mSeconds = (mTotalMilliseconds / 1000) % 60;
		mMinutes = ((mTotalMilliseconds / 1000) / 60) % 60;
		mHours = ((((mTotalMilliseconds) / 1000) / 60) / 60) % 24;
	}
	
	public static String getTimeString() {
		return mHours + ":" + mMinutes + ":" + mSeconds + "." + mMilliseconds;
	}
	
	public static int getUptime() {
		return mTotalMilliseconds;
	}
	
	public static int getMilliseconds() {
		return mMilliseconds;
	}
	
	public static int getSeconds() {
		return mSeconds;
	}
	
	public static int getMinutes() {
		return mMinutes;
	}
	
	public static int getHours() {
		return mHours;
	}
}
