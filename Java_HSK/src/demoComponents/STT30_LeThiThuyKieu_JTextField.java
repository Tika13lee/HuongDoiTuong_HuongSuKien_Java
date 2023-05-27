package demoComponents;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class STT30_LeThiThuyKieu_JTextField extends JFrame implements ActionListener {
	private JLabel resultLable;
	private JTextField txt;

	public STT30_LeThiThuyKieu_JTextField() {
		setTitle("Chuyen doi don vi");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 2));

		add(new JLabel("Nhap vao so millimet:"));
		add(txt = new JTextField(10));
		add(new JLabel("So centimet tuong ung:"));
		add(resultLable = new JLabel("---"));

		txt.addActionListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JTextField().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double cm, mm;
		mm = Double.parseDouble(txt.getText());
		cm = mm / 10;
		resultLable.setText(Double.toString(cm));
	}
}
