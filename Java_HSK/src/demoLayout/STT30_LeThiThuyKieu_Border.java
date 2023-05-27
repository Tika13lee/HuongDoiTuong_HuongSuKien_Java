package demoLayout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class STT30_LeThiThuyKieu_Border extends JFrame {

	public STT30_LeThiThuyKieu_Border() {
		super("Border Demo");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lbl1 = new JLabel("Line Border", JLabel.CENTER);
		JLabel lbl2 = new JLabel("Etched Border", JLabel.CENTER);
		JLabel lbl3 = new JLabel("Raised Bevel Border", JLabel.CENTER);
		JLabel lbl4 = new JLabel("Lowered Bevel Border", JLabel.CENTER);
		JLabel lbl5 = new JLabel("Titled Border", JLabel.CENTER);
		JLabel lbl6 = new JLabel("Titles Border (right)", JLabel.CENTER);
		JLabel lbl7 = new JLabel("Compound Border", JLabel.CENTER);
		JLabel lbl8 = new JLabel("Matte Border", JLabel.CENTER);

		Border lineBorder, loweredBevel;
		lbl1.setBorder(lineBorder = BorderFactory.createLineBorder(Color.BLACK, 3));
		lbl2.setBorder(BorderFactory.createEtchedBorder());
		lbl3.setBorder(BorderFactory.createRaisedBevelBorder());
		lbl4.setBorder(loweredBevel = BorderFactory.createLoweredBevelBorder());
		lbl5.setBorder(BorderFactory.createTitledBorder(lineBorder, "Title"));
		lbl6.setBorder(BorderFactory.createTitledBorder(lineBorder, "Title", TitledBorder.RIGHT, TitledBorder.TOP));
		lbl7.setBorder(BorderFactory.createCompoundBorder(lineBorder, loweredBevel));
		lbl8.setBorder(BorderFactory.createMatteBorder(1, 4, 1, 1, Color.WHITE));

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 2, 10, 20));
		jp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.add(jp);
		jp.add(lbl1);
		jp.add(lbl2);
		jp.add(lbl3);
		jp.add(lbl4);
		jp.add(lbl5);
		jp.add(lbl6);
		jp.add(lbl7);
		jp.add(lbl8);

	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_Border().setVisible(true);
	}
}
