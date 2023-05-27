package demoComponents;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class STT30_LeThiThuyKieu_JComboBox extends JFrame implements ActionListener {
	private JLabel lblText;
	private JComboBox faceCombo;

	public STT30_LeThiThuyKieu_JComboBox() {
		setTitle("JComboBox Demo");
		setSize(300, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		lblText = new JLabel("The quick brown fox jumps over the lazy dog");
		lblText.setFont(new Font("Serif", Font.PLAIN, 14));
		add(lblText, BorderLayout.CENTER);

		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		add(faceCombo, BorderLayout.SOUTH);

		faceCombo.addActionListener(this);
	}

	public static void main(String[] args) {
		new STT30_LeThiThuyKieu_JComboBox().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fontName = (String) faceCombo.getSelectedItem();
		lblText.setFont(new Font(fontName, lblText.getFont().getStyle(), lblText.getFont().getSize()));

	}
}
