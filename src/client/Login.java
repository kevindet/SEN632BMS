package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	
	private JTextField userField;
	private JTextField passwordField;
	private boolean loggedIn = false;
	
	public Login() {
		super("Enter User Credentials");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		add(panel);

		JLabel userLabel = new JLabel("User Name:  ");
		panel.add(userLabel, BorderLayout.CENTER);
		userField = new JTextField(15);
		panel.add(userField, BorderLayout.NORTH);

		JLabel passwordLabel = new JLabel("Password:");
		panel.add(passwordLabel, BorderLayout.CENTER);
		passwordField = new JPasswordField(15);
		panel.add(passwordField, BorderLayout.NORTH);

		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			private String userName;
			private String password;

			public void mouseClicked(MouseEvent e) {
				boolean success = false;

				userName = userField.getText();
				password = passwordField.getText();



			}
		});
		panel.add(loginButton);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		panel.add(cancelButton);

		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.LIGHT_GRAY);
		add(panelSouth, BorderLayout.SOUTH);
		
		JButton newUserButton = new JButton("Register as New User");
		newUserButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//register();
			}
		});
		panelSouth.add(newUserButton);
	}
	
	public boolean authenticated() {
		return loggedIn;
		
	}

}
