package demo.ui.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * See https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
 */
public class LoginPanel extends JPanel {

	private static final long serialVersionUID = -1579877463312942909L;

	JButton login, cancel;
	JTextField username;
	JPasswordField password;
	JLabel usernameLabel, passwordLabel, loginLabel;
	GridBagConstraints gridBagConstraints;

	public LoginPanel(LoginDemoFrame frame) {
		usernameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		loginLabel = new JLabel("Login");
		loginLabel.setFont(new Font("Serif", Font.BOLD, 28));

		username = new JTextField(15);
		password = new JPasswordField(20);

		login = new JButton("Login");
		cancel = new JButton("Cancel");

		setPreferredSize(new Dimension(500, 250));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(loginLabel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(usernameLabel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(username, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(passwordLabel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(password, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(cancel, gridBagConstraints);

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.insets = new Insets(10,0,0,0);
		add(login, gridBagConstraints);

		username.requestFocus();

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String un = username.getText();
				String pa = new String(password.getPassword());
				System.out.println("Login clicked");

				if ((un.equals("user")) && (pa.equals("password"))) {
					System.out.println("Login successful");
					frame.initWelcomeScreen();
				}
			}
		});

		KeyAdapter k = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					login.doClick();
				}
			}
		};

		password.addKeyListener(k);
		username.addKeyListener(k);
	}

}
