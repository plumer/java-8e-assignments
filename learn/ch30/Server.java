import java.io.*;
import java.net.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			// start listening for connections on the server socket
			Socket connectToClient = serverSocket.accept();
			DataInputStream isFromClient = new DataInputStream(
					connectToClient.getInputStream() );
			DataOutputStream osToClient = new DataOutputStream(
					connectToClient.getOutputStream() );

			while (true) {
				double radius = isFromClient.readDouble();
				System.out.println("radius received from client: " + radius);
				double area = radius*radius*Math.PI;
				osToClient.writeDouble(area);
				osToClient.flush();

				System.out.println("Area found: " + area);
			}
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
