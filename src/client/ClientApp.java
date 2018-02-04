package client;

import java.awt.Dimension;
import javax.swing.JFrame;

public class ClientApp {

	public static void main(String[] args) {
		BorrowMyStuffClient client = new BorrowMyStuffClient();
		client.start();
		ModelInterface model = new ClientModel(client);
		BorrowMyStuffView view = new BorrowMyStuffView(client, model);
		LoginDialog login = new LoginDialog(view);

		view.setPreferredSize(new Dimension(600, 500));
		view.setSize(800, 700);
		view.setLocationRelativeTo(null);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		login.setPreferredSize(new Dimension(350, 175));
		login.setResizable(false);
		login.pack();
		login.setLocationRelativeTo(null);
		login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		login.setVisible(true);
		
	}
}