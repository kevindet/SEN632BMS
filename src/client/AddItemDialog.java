package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class AddItemDialog extends JDialog {

	private JFrame owner;
	private JTextField textField1 = new JTextField(null, 20);
	private JTextField textField2 = new JTextField(null, 20);
	private JTextField textField3 = new JTextField(null, 20);
	private JTextField textField4 = new JTextField(null, 20);
	private TitledBorder titledTextField1;
	private TitledBorder titledTextField2;
	private TitledBorder titledTextField3;
	private TitledBorder titledTextField4;
	private JButton button1;

	public AddItemDialog(JFrame owner, final ModelInterface model) {

		super(owner, true);
		this.owner = owner;

		textField1.setHorizontalAlignment(JLabel.CENTER);
		textField1.setPreferredSize(new Dimension(50, 40));
		titledTextField1 = new TitledBorder("");
		textField1.setBorder(titledTextField1);
		textField1.setEditable(true);
		add(textField1);

		textField2.setHorizontalAlignment(JLabel.CENTER);
		textField2.setPreferredSize(new Dimension(50, 40));
		titledTextField2 = new TitledBorder("");
		textField2.setBorder(titledTextField2);
		textField2.setEditable(true);
		add(textField2);

		textField3.setHorizontalAlignment(JLabel.CENTER);
		textField3.setPreferredSize(new Dimension(50, 40));
		titledTextField3 = new TitledBorder("");
		textField3.setBorder(titledTextField3);
		textField3.setEditable(true);
		add(textField3);

		textField4.setHorizontalAlignment(JLabel.CENTER);
		textField4.setPreferredSize(new Dimension(50, 40));
		titledTextField4 = new TitledBorder("");
		textField4.setBorder(titledTextField4);
		textField4.setEditable(true);
		add(textField4);

		titledTextField1.setTitle("Item Name");
		titledTextField2.setTitle("Owner");
		titledTextField3.setTitle("Category");
		titledTextField4.setTitle("Status");

		textField1.requestFocusInWindow();

		button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JDialog dialog = (JDialog) SwingUtilities.getRoot(button1);

				if (textField1.getText().equalsIgnoreCase("")
						|| textField2.getText().equalsIgnoreCase("")
						|| textField3.getText().equalsIgnoreCase("")
						|| textField4.getText().equalsIgnoreCase("")) {
					JOptionPane.showConfirmDialog(dialog,
							"Please ensure values are entered for all fields",
							"Error", JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE);
					textField1.requestFocusInWindow();
				} else {
					model.addItem(textField1.getText(), textField2.getText(),
							textField3.getText(), textField4.getText());
					setVisible(false);
				}
			}
		});

		JButton clear = new JButton("Reset");
		clear.setMnemonic('R');
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField1.requestFocusInWindow();
			}
		});

		JButton close = new JButton("Close");
		close.setMnemonic('C');
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		button1.setText("Add Item");
		button1.setMnemonic('E');
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
