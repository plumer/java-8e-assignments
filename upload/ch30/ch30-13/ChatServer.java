// Server for multi chatting

import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer extends JFrame {
	private JTextArea jtaLog;
	HashSet<DataOutputStream> senders;
	HashSet<DataInputStream> receivers;
	public static void main(String[] args) {
		new ChatServer();
	}

	public ChatServer() {
		
		jtaLog = new JTextArea();
		add(jtaLog);
		setTitle("Chat Server");
		setLocationRelativeTo(null);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try {
			ServerSocket serverSocket = new ServerSocket(40000);
			
			senders = new HashSet<DataOutputStream>();
			receivers = new HashSet<DataInputStream>();

			while (true) {
				Socket socket = serverSocket.accept();
				DataOutputStream sender = new DataOutputStream(socket.getOutputStream());
				DataInputStream receiver = new DataInputStream(socket.getInputStream());
				senders.add(sender);
				receivers.add(receiver);

				HandleTask task = new HandleTask(sender, receiver);
				new Thread(task).start();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class HandleTask implements Runnable {
		private DataOutputStream sender;
		private DataInputStream receiver;
		public HandleTask(DataOutputStream sender, DataInputStream receiver) {
			this.sender = sender;
			this.receiver = receiver;
		}

		public void run() {
			try {
				while (true) {
					String message = receiver.readUTF();
					jtaLog.append(message+'\n');
					Iterator<DataOutputStream> senderIterator = senders.iterator();
					while (senderIterator.hasNext()) {
						DataOutputStream s = senderIterator.next();
						if (/*s != sender*/true) {
							System.out.println("send: " + message);
							s.writeUTF(message);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
