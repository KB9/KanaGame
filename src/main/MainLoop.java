package main;

import java.util.concurrent.TimeUnit;

public class MainLoop extends FixedTimeStepLoop {

	public MainLoop(int maxUpdates, int updateRate, int drawRate, TimeUnit timeUnit, boolean canSleep) {
		super(3, 40, 20, TimeUnit.MILLISECONDS, true);
	}

	@Override
	protected void onInput() {
		
	}

	@Override
	protected void onUpdate() {
		
	}

	@Override
	protected void onDraw() {
		
	}
}