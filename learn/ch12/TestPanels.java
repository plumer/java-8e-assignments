import java.awt.*;
import javax.swing.*;
public class TestPanels extends JFrame {
	/* Hierarchy:
	 * TestPanel | - p2 of Layout BorderLayout
	 *			 |	| - p1 of Layout GridLayout
	 *			 |	|    > - 12 buttons
	 *			 |	> - TextField
	 *			 > - JButton("Food")
	 */
	public TestPanels() {
		// Create panel p1 for the button and set GridLayout
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		
		// Add buttons to the Panel	
		for (int i = 1; i <= 9; ++i) {
			p1.add(new JButton("" + i));
			
		}
		p1.add(new JButton("" + 0));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		// Create panel p2 to hold a text field and p1
		JPanel p2 = new JPanel(new BorderLayout());
		p2.add(new JTextField("Time to be displayed here"), BorderLayout.NORTH);
		p2.add(p1/*, BorderLayout.CENTER*/); // What if CENTER is omitted?
											 // Seems not of a big deal
		// add contents into the frame
		add(p2, BorderLayout.EAST);
		add(new JButton("Food to be placed here")/*, BorderLayout.CENTER*/);
	}
	
	public static void main( String [] args ) {
		TestPanels frame = new TestPanels();
		frame.setTitle("The Front View of a Microwave Oven");
		frame.setSize(400, 250); 
		// ^ changing 400 to 200 will cut off JButton in hierarchy 1
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}