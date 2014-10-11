package main;

public abstract class LoopTask {
	
    // Frame speed
    private final int FPS = 60;
    private final int FRAME_PERIOD = 1000 / FPS;
    private final int MAX_FRAME_SKIPS = 5;

    // Frame timing
    private long mStartTime;
    private long mDrawTime;
    private int mSleepTime;
    private int mFramesSkipped;
	
	private boolean mIsRunning;
	
	private Thread mThread;
	
	public LoopTask() {
		mIsRunning = true;
		mThread = new Thread(new LoopRunnable());
		mThread.start();
	}
	
	protected abstract void onProcessInput();
	protected abstract void onUpdateLogic();
	protected abstract void onDraw();

	private final class LoopRunnable implements Runnable {

		@Override
		public void run() {
			while(mIsRunning) {
		        // Stores the time when rendering begins
		        mStartTime = System.currentTimeMillis();
		        mFramesSkipped = 0;
		        
		        onProcessInput();
		        onUpdateLogic();
		        onDraw();
		        
		        // Calculates how long the thread can sleep for
		        mSleepTime = (int)(FRAME_PERIOD - mDrawTime);

		        /**
		         * Everything is running smoothly. The thread can sleep off the rest of the frame period.
		         */
		        if(mSleepTime > 0) {
		            try {
		                Thread.sleep(mSleepTime);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		        
		        GameClock.tick(FRAME_PERIOD);

		        /**
		         * Catch up is required in this case, logic is updated and rendering does not occur until
		         * sleep time is below the FPS cap again.
		         */
		        while(mSleepTime < 0 && mFramesSkipped < MAX_FRAME_SKIPS) {
		            onUpdateLogic();
		            mSleepTime += FRAME_PERIOD;
		            mFramesSkipped ++;
		        }
			}
		}
	}
}
