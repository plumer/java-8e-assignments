// Java Programming assignment 22.3
// Count occurrences of all keywords in a given java source code file
// Written by 121220130
// This program accepts multiple arguments,
//   each of them as a java source code file
//   and print statistics respectively.

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class CountWords {
	public static void main (String[] args) {
		File sourceFile;
		Scanner fileInput;
		String [] buf;
		String word;
		TreeMap<String, Integer> counter = new TreeMap<String, Integer>();
		for (int j = 0; j < args.length; ++j) {
			sourceFile = new File ( args[j] );
			if (!sourceFile.exists()) {
				System.out.println("sorry, file does not exist");
				System.exit(1);
			}
	
			counter.clear();
	
			try {
			System.out.println("\nFile : " + args[j]);
			System.out.println("-----------------");
			fileInput = new Scanner( sourceFile );
			while ( fileInput.hasNext() ) {
				buf = fileInput.nextLine().split("[ \t\n\r,;.:?!@#$%^&*=+\'\"\\(\\)\\[\\]\\{\\}]");
				for (int i = 0; i < buf.length; ++i) {
					word = buf[i].toLowerCase();
					if (!Character.isLetter( word.charAt(0) ))
						continue;
					if (counter.get(word) == null) {
						counter.put(word, 1);
					} else {
						int temp = counter.get(word).intValue();
						counter.put(word, temp+1);
					}
				}
			} // end of while: entire file read
		
			Set< Map.Entry<String, Integer> > entrySet = counter.entrySet();
			for (Map.Entry<String, Integer> entry: entrySet)
				System.out.println(entry.getValue() + "\t" + entry.getKey());
	
			} catch (Exception e) {
				System.out.println("File open exception occurred");
				System.exit(2);
			}
		}
	}

}
