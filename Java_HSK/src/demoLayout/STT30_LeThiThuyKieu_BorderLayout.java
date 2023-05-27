package demoLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class STT30_LeThiThuyKieu_BorderLayout extends JFrame {
	public STT30_LeThiThuyKieu_BorderLayout() {
		this.setTitle("Demo Border Layout");
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		BorderLayout borderLayout = new BorderLayout();
		this.setLayout(borderLayout);

		this.add(new JButton("NORTH"), borderLayout.NORTH);
		this.add(new JButton("WEST"), borderLayout.WEST);
		this.add(new JButton("CENTER"));
		this.add(new JButton("EAST"), borderLayout.EAST);
		this.add(new JButton("SOUTH"), borderLayout.SOUTH);

	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_BorderLayout().setVisible(true);
	}
}
