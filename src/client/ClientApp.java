package client;
//TEST for Fetch!!
import java.awt.Dimension;

import javax.swing.JFrame;

public class ClientApp {

	public static void main(String[] args) {
		BorrowMyStuffClient client = new BorrowMyStuffClient();
		BorrowMyStuffView view = new BorrowMyStuffView(client);
		view.setPreferredSize(new Dimension(600, 500));
		view.setSize(800, 700);
		view.setExtendedState(JFrame.MAXIMIZED_BOTH);
		view.setLocationRelativeTo(null);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
}