// Java Programming Assignment 9.21
// Modify source code 9-9 (ReplaceText.java) to change the behavior of the program
// Instead of writing replaced text to a new file, write to the original file.
// Written by 121220130

import java.io.*;
import java.util.*;

public class ReplaceText {
	public static void main(String [] args) throws Exception {

		// Check command-line parameter usage
		/* change: number of arguments changed from 4 to 3
		 * since TARGETFILE argument is no longer needed
		 */
		if (args.length != 3) {
			System.out.println("Usage: java ReplaceText file oldStr newStr");
			System.exit(0);
		}
		
		// Check if file exists
		File file = new File( args[0] );
		if ( !file.exists() ) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(0);
		}

/**		// Check if target file exists
		File targetFile = new File( args[1] );
no		if ( targetFile.exists() ) {
longer		System.out.println( "Target file " + args[1] + " already exists");
needed		System.exit(0);
		}
**/
		// Create a Scanner for input and a Print Writer for output
		Scanner input = new Scanner( file );
//	-	PrintWriter output = new PrintWriter( targetFile );
//		I intend to read the whole file in, close it, and then write to it.
		
		StringBuilder s1 = new StringBuilder( (int)(file.length()) );
		while ( input.hasNext() ) {
			s1.append( input.nextLine() + '\n');
		}
		
		input.close();
		
		String text = new String( s1 );
		
		PrintWriter output = new PrintWriter( file );
		output.print( text.replaceAll(args[1], args[2]) );
		output.close();

	}

}
