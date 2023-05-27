package demoComponents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class STT30_LeThiThuyKieu_JPasswordField extends JFrame implements ActionListener{
	private JPasswordField txt;
	private JButton btnOk;
	private JButton btnCancel;

	public STT30_LeThiThuyKieu_JPasswordField() {
		setTitle("JPasswordField");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel jpLeft, jpRight;
		jpLeft = new JPanel();
		jpLeft.add(new JLabel("Password:"));
		jpLeft.add(txt = new JPasswordField(10));
		jpRight = new JPanel(new GridLayout(2, 1));
		jpRight.add(btnOk = new JButton("OK"));
		jpRight.add(btnCancel = new JButton("Cancel"));
		
		add(jpLeft, BorderLayout.WEST);
		add(jpRight, BorderLayout.EAST);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JPasswordField().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnCancel))
			System.exit(0);
		else {
			char chPassword[] = txt.getPassword();
			String strPassword = new String(chPassword);
			if(strPassword.trim().equals("130303")){
				JOptionPane.showMessageDialog(this, "Correct Password");
				System.exit(0);
			}
			else {
				JOptionPane.showMessageDialog(this, "Incorrect Password");
				txt.selectAll();
				txt.requestFocus();
			}
		}
		
	}
}
