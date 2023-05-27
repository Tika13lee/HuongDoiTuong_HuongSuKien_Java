package demoLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class STT30_LeThiThuyKieu_JButton extends JFrame implements ActionListener {
	JButton btn1, btn2;
	JPanel jp;

	public STT30_LeThiThuyKieu_JButton() {
		super("Button Test");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		btn1 = new JButton("Blue Button");
		btn2 = new JButton("Red Button");
		btn1.addActionListener(this);
		btn2.addActionListener(this);

		jp = new JPanel();
		jp.add(btn1);
		jp.add(btn2);
		add(jp);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn1))
			jp.setBackground(Color.BLUE);
		else if (source.equals(btn2))
			jp.setBackground(Color.RED);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JButton().setVisible(true);
	}

}
