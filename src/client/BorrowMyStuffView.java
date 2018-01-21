package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorrowMyStuffView extends JFrame {

	private BorrowMyStuffClient client;
	private JPanel panel = new JPanel();
	private Item item;

	public BorrowMyStuffView(BorrowMyStuffClient client) {
		this.client = client;
		this.add(panel);

		JButton addButton = new JButton("Add Button");
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				item = new Item("Planet of the Apes", Category.MOVIE);
				item.toString();
				client.send(item);
			}
		});
		panel.add(addButton);
	}

}
