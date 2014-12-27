// Java Programming assignment 22.3
// Count occurrences of all keywords in a given java source code file
// Written by 121220130
// This program accepts multiple arguments,
//   each of them as a java source code file
//   and print statistics respectively.

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class CountKeywords {
	private static HashSet<String> keywordSet = new HashSet<String>();
	public static void main (String[] args) {
		loadKeywords();
		File sourceFile;
		Scanner fileInput;
		String [] buf;
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
				buf = fileInput.nextLine().split("[^a-z]");
				for (int i = 0; i < buf.length; ++i) {
					if ( keywordSet.contains(buf[i]) ) {
	
						if (counter.get(buf[i]) == null) {
							counter.put(buf[i], 1);
						} else {
							int temp = counter.get(buf[i]).intValue();
							counter.put(buf[i], temp+1);
						}
	
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

	private static void loadKeywords() {
		String keyString = "asssert break class const continue default do double else enum " +
				   "extends final finally float for goto if implements import instanceof " +
				   "int interface long native new package private protected public return " +
				   "short static strictfp super switch synchronized this throw throws " +
				   "transient try void volatile while false null true";
		String[] keys = keyString.split(" ");
		for (int i = 0; i < keys.length; ++i)
			keywordSet.add(keys[i]);
	}
}
