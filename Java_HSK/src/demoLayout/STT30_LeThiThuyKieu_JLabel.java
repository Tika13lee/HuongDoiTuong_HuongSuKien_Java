package demoLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class STT30_LeThiThuyKieu_JLabel extends JFrame {
	public STT30_LeThiThuyKieu_JLabel() {
		super("Demo JLaber");
//		this.setTitle("Demo JLabel");
		this.setSize(400, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		JPanel jp = new JPanel();
		jp.add(new JLabel("User Name: ",
				new ImageIcon("C:/Users/DELL/eclipse-workspace/LTHSK/src/img/new-icon-gif-22.jpg"),
				SwingConstants.CENTER));
		jp.add(new JLabel("Password"));
		this.add(jp);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JLabel().setVisible(true);
	}
}
