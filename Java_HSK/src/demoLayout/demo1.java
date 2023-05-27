package demoLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class demo1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField txtUserName;
	private JTextField txtPassWord;
	private JButton btnLogin;
	private JButton btnExit;

	public demo1() {
		setTitle("demo mau");
		setSize(350, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JLabel lblUser = new JLabel("User Name");
		JLabel lblPassword = new JLabel("password: ");
		txtUserName = new JTextField(15);
		txtPassWord = new JTextField(15);
		btnLogin = new JButton("Login");
		btnExit = new JButton("Exit");
		JPanel p = new JPanel();
		p.setBorder(BorderFactory.createTitledBorder("username"));
		add(p);

		lblPassword.setPreferredSize(lblUser.getPreferredSize());
		p.add(lblUser);
		p.add(txtUserName);
		p.add(lblPassword);
		p.add(txtPassWord);
		p.add(btnLogin);
		p.add(btnExit);

		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	public static void main(String[] args) {
		new demo1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnLogin)) {
			if (txtPassWord.getText().equals("123"))
				JOptionPane.showMessageDialog(this, "password chinh xac");
			else {
				JOptionPane.showMessageDialog(this, "password sai");
			}
		} else
			System.exit(0);

	}
}
