package demoComponents;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class STT30_LeThiThuyKieu_JRadioButton extends JFrame implements ItemListener, ActionListener {
	private JCheckBox chkItalic;
	private JRadioButton radLeft;
	private JRadioButton radRight;
	private JLabel lblText;

	public STT30_LeThiThuyKieu_JRadioButton() {
		setTitle("RadioButton Demo");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jp1, jp2;
		jp1 = new JPanel();
		jp1.add(chkItalic = new JCheckBox("Italic"));
		jp1.add(radLeft = new JRadioButton("Left", true));
		jp1.add(radRight = new JRadioButton("Right"));
		ButtonGroup gr = new ButtonGroup();
		gr.add(radLeft);
		gr.add(radRight);

		add(lblText = new JLabel("Hello World"), BorderLayout.SOUTH);
		lblText.setFont(new Font("Serif", Font.PLAIN, 20));

		add(jp1);

		chkItalic.addItemListener(this);
		radLeft.addActionListener(this);
		radRight.addActionListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JRadioButton().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(radLeft)) {
			lblText.setHorizontalAlignment(SwingConstants.LEFT);
		} else if (o.equals(radRight)) {
			lblText.setHorizontalAlignment(SwingConstants.RIGHT);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = lblText.getFont();
		if (e.getItem() == chkItalic)
			lblText.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));

	}
}
