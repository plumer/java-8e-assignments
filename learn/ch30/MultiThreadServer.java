import java.io.*;
import java.net.*;

public class MultiThreadServer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000);
			int clientNo = 1;
			while (true) {
				Socket connectToClient = serverSocket.accept();
				System.out.println("Start thread for client " + clientNo);
				InetAddress clientInetAddress = connectToClient.getInetAddress();

				System.out.println("Client " + clientNo + "\'s hostname is " + 
						clientInetAddress.getHostName());
				System.out.println("Client " + clientNo + "\'s IP Address is" +
						clientInetAddress.getHostAddress());

				HandleAClient task = new HandleAClient(connectToClient, clientNo);
				new Thread(task).start();
				clientNo++;
			} 
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
