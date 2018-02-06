package demo.ui.login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = -3102677829264603632L;

	JButton cancel;
	JTextField message;
	GridBagConstraints gridBagConstraints;

	public WelcomePanel(LoginDemoFrame frame) {

		message = new JTextField("Welcome to the LoginDemoFrame application...");
		
		setPreferredSize(new Dimension(500, 250));
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();

		cancel = new JButton("Cancel");

		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		add(message, gridBagConstraints);
		
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		add(cancel, gridBagConstraints);

		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
	}

}
