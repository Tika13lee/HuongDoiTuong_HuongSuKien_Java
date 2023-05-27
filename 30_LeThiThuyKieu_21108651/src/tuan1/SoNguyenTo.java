package tuan1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SoNguyenTo extends JFrame implements ActionListener {
	private JTextField txtNhap;
	private JButton btnGenerate;
	private JTextArea txtArea;
	private JScrollPane scrollPane;

	public SoNguyenTo() {
		setTitle("Primes");
		setSize(500, 380);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel jpTop = new JPanel();
		jpTop.add(txtNhap = new JTextField(30));
		txtNhap.setToolTipText("Nhập vào số lượng số nguyên tố cần hiển thị");
		jpTop.add(btnGenerate = new JButton("Generate"));
		this.add(jpTop, BorderLayout.NORTH);

		JPanel jpBottom = new JPanel();
		scrollPane = new JScrollPane(txtArea = new JTextArea(15, 40));
		txtArea.setToolTipText("Danh sách các số nguyên tố hiển thị");
		txtArea.setEditable(false);
		jpBottom.add(scrollPane);
		this.add(jpBottom);

		btnGenerate.addActionListener(this);
	}

	public static void main(String[] args) {
		new SoNguyenTo().setVisible(true);
	}

	public boolean kiemTraSoNguyenTo(int a) {
		if (a <= 1)
			return false;
		else {
			for (int i = 2; i <= Math.sqrt(a); i++) {
				if (a % i == 0)
					return false;
			}
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnGenerate)) {
			txtArea.setText("");
			int dem = 0;
			String result = "";
			int a = Integer.parseInt(txtNhap.getText());
			for (int i = 2; i < Integer.MAX_VALUE; i++) {
				if (kiemTraSoNguyenTo(i)) {
					result += i + "\n";
					dem++;
				}
				if (dem == a)
					break;
			}
			txtArea.setText(result);
		}
	}

}
