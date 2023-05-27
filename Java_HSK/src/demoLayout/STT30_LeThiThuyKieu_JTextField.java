package demoLayout;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class STT30_LeThiThuyKieu_JTextField extends JFrame {
	JTextField txtFN, txtLN;

	public STT30_LeThiThuyKieu_JTextField() {
		super("Input data");
		setSize(250, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.add(new Label("Firstname:"));
		jp.add(txtFN = new JTextField(10));
		jp.add(new Label("Lastname:"));
		jp.add(txtLN = new JTextField(10));

		add(jp);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JTextField().setVisible(true);
	}
}
