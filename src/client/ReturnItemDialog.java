package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

public class ReturnItemDialog extends JDialog{
	private JFrame owner;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	JFormattedTextField txtDate = new JFormattedTextField(df);
	private TitledBorder titledTextField1;
	private JButton button1;
	
	public ReturnItemDialog(JFrame owner, final ModelInterface model, int row) {

		super(owner, true);
		this.owner = owner;

		txtDate.setHorizontalAlignment(JLabel.CENTER);
		txtDate.setPreferredSize(new Dimension(250, 40));
		titledTextField1 = new TitledBorder("");
		txtDate.setBorder(titledTextField1);
		txtDate.setEditable(true);
		add(txtDate);
		

		titledTextField1.setTitle("Return Date");

		txtDate.requestFocusInWindow();

		button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JDialog dialog = (JDialog) SwingUtilities.getRoot(button1);

				if (txtDate.getText().equalsIgnoreCase("")) {
					JOptionPane.showConfirmDialog(dialog,
							"Please ensure values are entered for all fields",
							"Error", JOptionPane.CLOSED_OPTION,
							JOptionPane.ERROR_MESSAGE);
					txtDate.requestFocusInWindow();
				} else {
					model.returnItem(row,txtDate.getText());
					setVisible(false);
				}
			}
		});

		JButton clear = new JButton("Reset");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				txtDate.setText("");
				txtDate.requestFocusInWindow();
			}
		});

		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});
		button1.setText("Return Item");
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
