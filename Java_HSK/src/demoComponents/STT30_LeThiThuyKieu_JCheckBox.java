package demoComponents;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class STT30_LeThiThuyKieu_JCheckBox extends JFrame implements ItemListener {
	private JLabel lblText;
	private JCheckBox chkBold;
	private JCheckBox chkItalic;

	public STT30_LeThiThuyKieu_JCheckBox() {
		setTitle("JCheckBox Test");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2, 1));

		JPanel jpText, jpCheck;
		jpText = new JPanel();
		jpText.add(lblText = new JLabel("Watch the font style change"));
		lblText.setFont(new Font("Serif", Font.PLAIN, 20));

		jpCheck = new JPanel();
		jpCheck.add(chkBold = new JCheckBox("chkBold"));
		jpCheck.add(chkItalic = new JCheckBox("chkItalic"));

		add(jpText);
		add(jpCheck);

		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JCheckBox().setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = lblText.getFont();
		if (e.getItem() == chkBold) {
			lblText.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
		}
		if (e.getItem() == chkItalic) {
			lblText.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));
		}
	}
}
