// Write a Client for group chatting.
// Written by 121220130.

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends JFrame {
	private Socket socket;
	 
	private JTextField jtfInput;
	private JTextArea jtaLog;

	public static void main (String[] args) {
		new ChatClient();
	}

	public ChatClient() {

		// UI initialization
		setLayout(new BorderLayout());
		jtfInput = new JTextField();
		jtaLog = new JTextArea();

		add(jtfInput, BorderLayout.SOUTH);
		add(jtaLog, BorderLayout.CENTER);

		setTitle("Chat Client");
		setLocationRelativeTo(null);
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// logic
		try {
			socket = new Socket("localhost", 40000);
//			Listener acceptFromServer = new Listener();
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jtfInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					toServer.writeUTF(jtfInput.getText());
				} catch (Exception innerE) {
					innerE.printStackTrace();
				}
				}
		});
	
		System.out.println("listening");
		try {
			while (true) {
				String message = fromServer.readUTF();
				System.out.println("message receive: " + message);
				jtaLog.append(message);
			}
		} catch (Exception innerE) {
			innerE.printStackTrace();
		}
	}
}
