package demoLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class STT30_LeThiThuyKieu_GridLayout extends JFrame {
	public STT30_LeThiThuyKieu_GridLayout() {
		this.setTitle("Demo GridLayout");
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		GridLayout gridLayout = new GridLayout(4, 4);
		this.setLayout(gridLayout);

		for (int i = 0; i < 14; i++) {
			JButton btn = new JButton("Button" + i);
			this.add(btn);
		}
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_GridLayout().setVisible(true);
	}
}
