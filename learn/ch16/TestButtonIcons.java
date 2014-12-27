import javax.swing.*;

public class TestButtonIcons extends JFrame {
	public static void main(String[] args) {
		JFrame frame = new TestButtonIcons();
		frame.setTitle("ButtonIcons");
		frame.setSize(200, 100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public TestButtonIcons() {
		ImageIcon usIcon = new ImageIcon("us.jpeg");
		ImageIcon ukIcon = new ImageIcon("uk.jpeg");
		ImageIcon caIcon = new ImageIcon("canada.gif");
		
		JButton jbt = new JButton("Click me", usIcon);
		jbt.setPressedIcon(caIcon);
		jbt.setRolloverIcon(ukIcon);
		
		add(jbt);
	}
}