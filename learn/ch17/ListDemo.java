import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListDemo extends JFrame {
	final int NUMBER_OF_FLAGS = 9;
	private String[] flagTitles = {
		"Canada", "China", "Denmark",
		"France", "Germany", "India", "Norway", "United Kingdom",
		"United States of America"
	};
	
	private JList jlst = new JList(flagTitles);
	
	private ImageIcon[] imageIcons = {
		new ImageIcon("canada.gif"),
		new ImageIcon("cn.jpg"),
		new ImageIcon("dm.jpeg"),
		new ImageIcon("fr.gif"),
		new ImageIcon("ge.jpeg"),
		new ImageIcon("id.jpeg"),
		new ImageIcon("nw.jpeg"),
		new ImageIcon("uk.jpeg"),
		new ImageIcon("us.jpeg")
	};
	
	private JLabel[] jlblImageViewer = new JLabel[NUMBER_OF_FLAGS];
	
	public static void main(String [] args) {
		ListDemo frame = new ListDemo();
		frame.setSize(650, 500);
		frame.setTitle("ListDemo");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public ListDemo() {
		JPanel p = new JPanel(new GridLayout(3, 3, 5, 5));
		
		for (int i = 0; i < NUMBER_OF_FLAGS; ++i) {
			p.add(jlblImageViewer[i] = new JLabel());
			jlblImageViewer[i].setHorizontalAlignment(SwingConstants.CENTER);
		}
		add(p, BorderLayout.CENTER);
		add(new JScrollPane(jlst), BorderLayout.WEST);
		
		jlst.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				int [] indices = jlst.getSelectedIndices();
				
				int i;
				for (i = 0; i < indices.length; i++)
					jlblImageViewer[i].setIcon(imageIcons[indices[i]]);
				for (; i < NUMBER_OF_FLAGS; i++)
					jlblImageViewer[i].setIcon(null);
			}
		});
	}
}