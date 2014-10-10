package main;

import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Panel extends JPanel{
	
	private LoopTask mLoop;
	
	public Panel()
	{
		setFocusable(true);
		
		mLoop = new LoopTask(3, 40, 20, TimeUnit.MILLISECONDS, true) {

			@Override
			protected void onProcessInput() {
				
			}

			@Override
			protected void onUpdateLogic() {
				
			}

			@Override
			protected void onDraw() {
				
			}
		};
	}

}
