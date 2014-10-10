package main;

import java.util.concurrent.TimeUnit;

public abstract class FixedTimeStepLoop {

	private float mSeconds, mForward, mBackward, mInterpolate;
    private long mMillis, mNanos, mMicros, mLastTime, mCurrentTime;

    private long mUpdateRate;   // The number of nanoseconds allocated to updating the game state
    private long mDrawRate;     // The number of nanoseconds allocated to drawing
    private int mMaxUpdates;    // The max amount of states updates that can occur before drawing
    private boolean mCanSleep;  // Allows the loop to sleep if time is left over at the loop's end

    private long mUpdateTime;   // The number of nanoseconds between update calls
    private long mDrawTime;     // The amount of nanoseconds since in the last update call
    
    public FixedTimeStepLoop(int maxUpdates, int updateRate, int drawRate, TimeUnit timeUnit, boolean canSleep) {
        mUpdateRate = timeUnit.toNanos(updateRate);
        mDrawRate = timeUnit.toNanos(drawRate);
        mMaxUpdates = maxUpdates;
        mCanSleep = canSleep;

        setElapsed(mUpdateRate);
    }

    protected abstract void onInput();
    protected abstract void onUpdate();
    protected abstract void onDraw();

    public final boolean loop() {
        long nanosElapsed = tick();
        mUpdateTime += nanosElapsed;

        int updateCount = 0;
        while (mUpdateTime >= mUpdateRate && updateCount < mMaxUpdates) {
            onInput();
            onUpdate();
            updateCount ++;
            mUpdateTime -= mUpdateRate;
        }

        mDrawTime += nanosElapsed;
        int drawCount = 0;
        if (mDrawTime >= mDrawRate || updateCount == 0) {
            mInterpolate = getStateInterpolation();
            mForward = mInterpolate * mSeconds;
            mBackward = mForward - mSeconds;
            onDraw();
            drawCount ++;
            mDrawTime -= (mDrawRate == 0 ? mDrawTime : mDrawRate);
        }

        if (mCanSleep && drawCount == 0 && updateCount == 0) {
            long actualTime = mUpdateTime + getElapsedSinceTick();
            long sleep = (mUpdateRate - actualTime) / 1000000L;
            if (sleep > 1) {
                try {
                    Thread.sleep(sleep - 1);
                }
                catch (Exception e) { }
            }
        }

        return (drawCount > 1);
    }

    protected final float interpolate(float lastPosition, float currentPosition) {
        return (currentPosition - lastPosition) * mInterpolate + lastPosition;
    }

    private final long tick() {
        mLastTime = mCurrentTime;
        mCurrentTime = System.nanoTime();
        return (mCurrentTime - mLastTime);
    }

    private final void setElapsed(long nanosElapsed) {
        mNanos = nanosElapsed;
        mMicros = nanosElapsed / 1000L;
        mMillis = nanosElapsed / 1000000L;
        mSeconds = (float)(nanosElapsed * 0.000000001);
    }

    private final long getElapsedSinceTick() {
        return (System.nanoTime() - mCurrentTime);
    }

    private final float getStateInterpolation() {
        return (float)((double)mUpdateTime / (double)mUpdateRate);
    }
}
