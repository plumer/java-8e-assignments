import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			Socket connectToServer = new Socket("188.226.231.252", 23333);
			DataInputStream isFromServer = new DataInputStream(
					connectToServer.getInputStream() );
			DataOutputStream osToServer = new DataOutputStream(
					connectToServer.getOutputStream() );
			while (true) {
				System.out.print("Please enter a word: ");
				String word = input.nextLine();
				osToServer.writeUTF(word);
				osToServer.flush();
//				double area = isFromServer.readDouble();

//				System.out.println("Area received from the server is " + area);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
