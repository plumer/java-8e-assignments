import java.awt.GraphicsEnvironment;

public class AllFonts {
	public static void main (String [] args) {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = e.getAvailableFontFamilyNames();
		
		for (int i = 0; i < fontNames.length; ++i) 
			System.out.println(fontNames[i]+'~');
	}
}