package combobox;


import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JViewport;
import javax.swing.Timer;

public abstract class PCIIMouseDragAdapter extends MouseAdapter {

	// speed decrease percentage per second
	protected static final int SPEED_DECREASE_PERCENTAGE_PER_SECOND = 230;

	// time delay for timer in milliseconds
	protected static final int TIMER_DELAY_IN_MILLISECONDS = 30;

	// speed at which the drag is stopped
	protected static final double NEGLIGIBLE_SPEED = 40.0;

	// component being dragged
	protected final JComponent component;

	// original cursor of the component
	protected final Cursor originalCursor;

	// the hand cursor is used while dragging
	private final Cursor handCursor = Cursor
			.getPredefinedCursor(Cursor.HAND_CURSOR);

	// timer responsible for the scrolling
	protected final Timer scrollTimer;

	// time of when the actionPerformed was last called (needs to be set to
	// current time when timer is started so can't be internal to the
	// ActionListener
	protected long timeAtLastActionPerfomedInMilliseconds = 0;

	// set on true if a drag event was detected
	private boolean mouseDragged = false;

	// y coordinates to remember
	private int yMousePressed = 0;
	private int yMouseDragged = 0;
	private int yPreviousMouseDragged = 0;
	private int yPreviousScroll = 0;
	
	// times to remember
	private long timeAtMouseDragged = 0;
	private long timeAtPreviousMouseDragged = 0;
		
	// speed to remember
	private double lastMeasuredDragSpeed = 0.0;
	protected double currentScrollSpeed = 0.0;

	public PCIIMouseDragAdapter(JComponent comp) {
		this.component = comp;
		this.originalCursor = comp.getCursor();

		scrollTimer = new javax.swing.Timer(TIMER_DELAY_IN_MILLISECONDS,
				new ActionListener() {

					// accumulates distance moved in double till accumulation
					// more than 1 pixel
					// and speed has effect
					protected double moveDistance = 0;

					public void actionPerformed(ActionEvent e) {

						// called every DELAY milliseconds convert from speed to
						// move distance in DELAY milliseconds
						// moveDistance accumulates double values till the
						// integer conversion is non-zero : in that case
						// scrollTableUp
						// is called and the integer height is subtracted from
						// the accumulated distance to move

						long currentTimeInMilliseconds = System
								.currentTimeMillis();
						long elapsedTimeInMilliseconds = currentTimeInMilliseconds
								- timeAtLastActionPerfomedInMilliseconds;
						timeAtLastActionPerfomedInMilliseconds = currentTimeInMilliseconds;

						moveDistance += (currentScrollSpeed * elapsedTimeInMilliseconds / 1000.0);
						/*
						 * System.out.println("moveDistance " + moveDistance +
						 * " speed = " + speed);
						 */
						int height = (int) moveDistance;
						if (height != 0) {
							moveDistance -= height;
							scrollUp(height);
						}
						// speed is decreasing at the
						// SPEED_DECREASE_PERCENTAGE_PER_SECOND rate
						// divided by 1000 (milliseconds -> seconds)
						double speedDecreasePercentage = SPEED_DECREASE_PERCENTAGE_PER_SECOND
								* elapsedTimeInMilliseconds / 1000.0;
						currentScrollSpeed = currentScrollSpeed * (100.0 - speedDecreasePercentage)
								* 1.e-2;

						/*
						 * System.out .println("elapsedTimeInMilliseconds " +
						 * elapsedTimeInMilliseconds +
						 * " speedDecreasePercentage " + speedDecreasePercentage
						 * + " speed = " + speed);
						 */
						if (Math.abs(currentScrollSpeed) < NEGLIGIBLE_SPEED) {
							currentScrollSpeed = 0.0;
							scrollTimer.stop();
						}
					}
					
					
					
					
				});
	}

	abstract void mouseReleasedButNoDrag(MouseEvent e);

	protected void scrollUp(int height) {
		/*
		 * System.out.println("scrollUp : " + height + " lastMeasuredDragSpeed "
		 * + lastMeasuredDragSpeed + " speed " + speed);
		 */
		if (height == 0)
			return;
		JViewport viewport = (JViewport) component.getParent();
		Point viewPosition = viewport.getViewPosition();
		viewPosition.translate(0, -height);
		component.scrollRectToVisible(new Rectangle(viewPosition, viewport
				.getSize()));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		component.setCursor(handCursor);

		yMousePressed = e.getPoint().y;
		yPreviousScroll = yMousePressed;
		yMouseDragged = yMousePressed;
		yPreviousMouseDragged = yMousePressed;

		// System.out.println("mousePressed " + startY);
		currentScrollSpeed = 0.0;
		scrollTimer.stop();
		mouseDragged = false;
		timeAtPreviousMouseDragged = System.currentTimeMillis();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// System.out.println("mouseReleased " + e.getPoint().y);
		component.setCursor(originalCursor);

		scrollTimer.stop();
		yMouseDragged = e.getPoint().y;
		currentScrollSpeed = lastMeasuredDragSpeed;

		if (mouseDragged) {
			if (Math.abs(lastMeasuredDragSpeed) > 0.2) {
				timeAtLastActionPerfomedInMilliseconds = System
						.currentTimeMillis();
				scrollTimer.start();
			}
			mouseDragged = false;
		} else {
			mouseReleasedButNoDrag(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		component.setCursor(handCursor);
		scrollTimer.stop();
		yMouseDragged = e.getPoint().y;

		timeAtMouseDragged = System.currentTimeMillis();
		// take mean in order to avoid vibration
		int meanStopY = (yMouseDragged + yPreviousMouseDragged) / 2;
		scrollUp(meanStopY - yPreviousScroll);

		if (timeAtMouseDragged != timeAtPreviousMouseDragged) {
			double timeIntervalInSeconds = (timeAtMouseDragged - timeAtPreviousMouseDragged) / 1000.0;
			double distanceScrolled = (double) (meanStopY - yPreviousScroll);
			lastMeasuredDragSpeed = distanceScrolled / timeIntervalInSeconds;
			/*
			 * System.out.println("timeIntervalInSeconds " +
			 * timeIntervalInSeconds + " distanceScrolled " + distanceScrolled +
			 * "meanStopY " + meanStopY + "startScrollY " + startScrollY +
			 * "lastMeasuredDragSpeed " + lastMeasuredDragSpeed);
			 */
		}

		yPreviousMouseDragged = yMouseDragged;
		timeAtPreviousMouseDragged = timeAtMouseDragged;
		yPreviousScroll = meanStopY;
		mouseDragged = true;
	}

}