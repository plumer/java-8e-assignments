import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClockWithAudio extends JFrame {

	private StillClock clock = new StillClock();

	private Time time = new Timer(1000, new TimerListener());
	private JLabel jlblDigitTime = new JLabel("", JLabel.CENTER);
	
	public void init() {
		add(clock, BorderLayout.CENTER);
		add(jlblDigitTime, BorderLayout.SOUTH);
	}

	public static void main (String[] args) {
		timer.start();
	}

	public static void stop() {
		timer.stop();
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clock.setCurrentTime();
			clock.repaint();
			jlblDigitTime.setText(clock.getHour() + ":" + clock.getMinute()
					+ ":" + clock.getSecond());
		}
	}
