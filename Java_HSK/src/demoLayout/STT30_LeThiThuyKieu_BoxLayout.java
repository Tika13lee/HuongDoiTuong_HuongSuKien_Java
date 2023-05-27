package demoLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class STT30_LeThiThuyKieu_BoxLayout extends JFrame {
	public STT30_LeThiThuyKieu_BoxLayout() {
		setTitle("Demo BoxLayout");
		setSize(400, 250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();

		b1.add(new JLabel("Username:"));
		b1.add(new JTextField(20));
		b2.add(new JLabel("Password:"));
		b2.add(new JPasswordField(20));
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b2);
		this.add(b, BorderLayout.NORTH);

		Box b3 = Box.createHorizontalBox();
		JButton btnExit = new JButton("EXIT");
		JButton btnLogin = new JButton("LOGIN");
		b3.add(btnExit);
		b3.add(btnLogin);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b3);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_BoxLayout().setVisible(true);
	}
}
