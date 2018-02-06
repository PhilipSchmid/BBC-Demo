package demo.ui.login;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class LoginDemoFrame extends JFrame {

	private static final long serialVersionUID = 9094026405766119493L;

	private JPanel mainPanel;
	private WelcomePanel welcomePanel;
	private LoginPanel loginPanel;

	public LoginDemoFrame() {
		mainPanel = new JPanel(new BorderLayout());
		welcomePanel = new WelcomePanel(this);
		loginPanel = new LoginPanel(this);
		
		setPreferredSize(new Dimension(1200, 1000));
		setTitle("Login");
		getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(mainPanel, BorderLayout.CENTER);

		mainPanel.add(loginPanel);
		pack();
		setVisible(true);
	}

	public void initWelcomeScreen() {
		mainPanel.removeAll();
		mainPanel.add(welcomePanel);
		mainPanel.revalidate();
	}

	public static void main(String args[]) {
		new LoginDemoFrame();
	}

}