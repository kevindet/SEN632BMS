package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
//import java.util.ArrayList;
import client.Item;

public class BorrowMyStuffServer extends Thread {

	private Socket[] socketList = new Socket[10];
	private ServerSocket serverSocket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private ObjectInputStream in1;
	private ObjectOutputStream out1;
	private boolean start = true;

	// private ArrayList<User> users;
	// private int port = 8080;
	// private MessageModel model;

	public BorrowMyStuffServer(int port) throws IOException {
		// model = new MessageModel();
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(500000);
		// users = new ArrayList<>();
	}

	public void run() {

		while (true) {
			try {
				getConnection();

				// out.writeObject(users);
				// out.flush();
				Object o = in.readObject();

				// System.out.println(o);
				if (o instanceof Item) {
					Item item = (Item) o;
					System.out.println(item.getItemName() + " "
							+ item.getCategory());
					// model.addNewUser(user);
				} /*
				 * else if (o instanceof Message) { //Message message =
				 * (Message) o; //System.out.println(message.getMessageText());
				 * } else { System.out.println("Waiting"); }
				 */

			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public void getConnection() throws IOException, ClassNotFoundException {
		if (socketList[0] == null) {
			//get localhost IP
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Server running on : " + ip.getHostAddress());
			//
			
			System.out.println("Waiting for client on port "
					+ serverSocket.getLocalPort() + "...");

			socketList[0] = serverSocket.accept();
			System.out.println("Success");
			in = new ObjectInputStream(socketList[0].getInputStream());
			out = new ObjectOutputStream(socketList[0].getOutputStream());

		} /*
		 * else if (socketList[1] == null) {
		 * System.out.println("Waiting for client on port " +
		 * serverSocket.getLocalPort() + "..."); socketList[1] =
		 * serverSocket.accept(); in1 = new
		 * ObjectInputStream(socketList[1].getInputStream()); out1 = new
		 * ObjectOutputStream(socketList[1].getOutputStream()); }
		 */
	}

	public static void main(String[] args) {
		int port = 8080;
		try {
			Thread t = new BorrowMyStuffServer(port);
			t.start();
			
			DatabaseConnection.initialize();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
