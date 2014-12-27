import java.util.concurrent.*;
import java.io.*;
import java.net.*;

public class HandleAClient implements Runnable {
	private Socket connectToClient;
	private int clientNo;

	public HandleAClient(Socket socket, int clientNo) {
		connectToClient = socket;
		this.clientNo = clientNo;
	}
	public void run() {
		try {
			DataInputStream isFromClient = new DataInputStream(
					connectToClient.getInputStream());
			DataOutputStream osToClient = new DataOutputStream(
					connectToClient.getOutputStream());
			while (true) {
				double radius = isFromClient.readDouble();
				System.out.println("radius received from client " + clientNo + ": "
						+ radius);
				double area = radius*radius*Math.PI;
				osToClient.writeDouble(area);
				System.out.println("Area found: " + area);
			}
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}
}
