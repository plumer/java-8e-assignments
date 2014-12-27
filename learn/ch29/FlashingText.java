import javax.swing.*;

public class FlashingText extends JFrame implements Runnable {
	private JLabel jlblText = new JLabel("Welcome", JLabel.CENTER);

	public static void main(String[] args) {
		FlashingText flt = new FlashingText();
		flt.setTitle("flash");
		flt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		flt.setLocationRelativeTo(null);
		flt.setVisible(true);
	}

	public FlashingText() {
		add(jlblText);
		new Thread(this).start();
	}

	public void run () {
		try {
			while (true) {
				if (jlblText.getText() == null)
					jlblText.setText("Welcome");
				else
					jlblText.setText(null);

				Thread.sleep(200);
			}
		} catch (InterruptedException ex) {
		}
	}
}
