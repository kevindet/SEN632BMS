package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class BorrowItemDialog extends JDialog {
	
	private JFrame owner;
	private JTextField textField1 = new JTextField(null, 20);
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	JFormattedTextField txtDate = new JFormattedTextField(df);
	private TitledBorder titledTextField1;
	private TitledBorder titledTextField2;
	private JButton button1;

	public BorrowItemDialog(JFrame owner, final ModelInterface model, int row) {

		super(owner, true);
		this.owner = owner;

		textField1.setHorizontalAlignment(JLabel.CENTER);
		textField1.setPreferredSize(new Dimension(50, 40));
		titledTextField1 = new TitledBorder("");
		textField1.setBorder(titledTextField1);
		textField1.setEditable(true);
		add(textField1);

		txtDate.setHorizontalAlignment(JLabel.CENTER);
		txtDate.setPreferredSize(new Dimension(250, 40));
		titledTextField2 = new TitledBorder("");
		txtDate.setBorder(titledTextField2);
		txtDate.setEditable(true);
		add(txtDate);
		

		titledTextField1.setTitle("Borrower");
		titledTextField2.setTitle("Borrow Date");

		textField1.requestFocusInWindow();

		button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JDialog dialog = (JDialog) SwingUtilities.getRoot(button1);

				if (textField1.getText().equalsIgnoreCase("")
						|| txtDate.getText().equalsIgnoreCase("")) {
					JOptionPane.showConfirmDialog(dialog,
							"Please ensure values are entered for all fields",
							"Error", JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE);
					textField1.requestFocusInWindow();
				} else {
					model.borrowItem(row,textField1.getText(), txtDate.getText());
					setVisible(false);
				}
			}
		});

		JButton clear = new JButton("Reset");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textField1.setText("");
				txtDate.setText("");
				textField1.requestFocusInWindow();
			}
		});

		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		button1.setText("Borrow Item");
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(button1);
		buttonPanel.add(clear);
		buttonPanel.add(close);
		add(buttonPanel, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(owner);
		setLayout(new FlowLayout());
		setSize(300, 250);
		setResizable(false);
		setVisible(false);
	}

}
