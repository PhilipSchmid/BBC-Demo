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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = -3102677829264603632L;

	JButton closeAppBtn;
	JTextField message;
	GridBagConstraints gridBagConstraints;

	public WelcomePanel(LoginDemoFrame frame) {

		message = new JTextField("Welcome to the LoginDemoFrame application...");
		message.setBackground(null);
		message.setBorder(null);
		message.setFont(new Font("Arial", Font.BOLD, 28));
		
		setPreferredSize(new Dimension(1200, 1000));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();

		closeAppBtn = new JButton("Close application");
		
		closeAppBtn.requestFocus();

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.insets = new Insets(30,0,0,0);
		add(message, gridBagConstraints);
		
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.insets = new Insets(0,0,30,0);
		gridBagConstraints.anchor = GridBagConstraints.PAGE_END;
		add(closeAppBtn, gridBagConstraints);

		closeAppBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		
		KeyAdapter k = new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
					closeAppBtn.doClick();
				}
			}
		};

		closeAppBtn.addKeyListener(k);
	}

}
