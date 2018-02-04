package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class BorrowMyStuffClient extends Thread {

	private String serverName = "192.168.1.66";
	private int port = 8080;
	private Socket server;
	private Object request;
	private boolean running = true;
	private boolean newRequest = false;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public BorrowMyStuffClient() {

	}

	public void run() {

		try {

			while (server == null && running) {

				try {
					server = new Socket(serverName, port);
					server.setSoTimeout(9000);
					System.out.println(running);

				} catch (Exception e) {
					//System.out.println("Trying to connect");

				}
			}

			if (running) {
				out = new ObjectOutputStream(server.getOutputStream());
				in = new ObjectInputStream(server.getInputStream());
			}

			while (running) {

				try {
					Thread.sleep(200);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				try {
					if (newRequest) {
						out.writeObject(request);
						out.flush();
						newRequest = false;
					}
				} catch (SocketTimeoutException e) {
					System.out.println("Socket timed out");
				}
			}
			// server.close();

		} catch (IOException e) {
			System.out.println("I/O error" + e);

		}
	}

	public void setIPAddress(String ip, int port) {
		serverName = ip;
		this.port = port;
		System.out.println(serverName);
		System.out.println(port);
		// run();
	}

	public void close() {
		running = false;
	}

	public void send(Object r) {
		request = r;
		newRequest = true;
	}

	// public void setView(MessageView view) { this.view=view; }

}
