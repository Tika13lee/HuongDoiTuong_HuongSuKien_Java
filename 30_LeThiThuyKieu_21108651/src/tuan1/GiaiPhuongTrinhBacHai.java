package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBacHai extends JFrame implements ActionListener {
	JTextField txtA, txtB, txtC, txtKQ;
	JButton btnGiai, btnXoa, btnThoat;

	public GiaiPhuongTrinhBacHai() {
		setTitle("ThuyKieu");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(new BorderLayout());

		JPanel jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		jpNorth.setBackground(Color.YELLOW);
		JLabel lbl1 = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		lbl1.setFont(new Font("Time New Roman", Font.PLAIN, 24));
		jpNorth.add(lbl1);

		JPanel jpCentre = new JPanel();
		this.add(jpCentre, BorderLayout.CENTER);
		jpCentre.setLayout(null);

		JLabel lblA, lblB, lblC, lblKQ;
		jpCentre.add(lblA = new JLabel("Nhập a:"));
		int x = 30, y = 40, width = 100, height = 30;
		lblA.setBounds(x, y, width, height);
		jpCentre.add(lblB = new JLabel("Nhập b:"));
		y += 50;
		lblB.setBounds(x, y, width, height);
		jpCentre.add(lblC = new JLabel("Nhập c:"));
		y += 50;
		lblC.setBounds(x, y, width, height);
		jpCentre.add(lblKQ = new JLabel("Kết quả:"));
		y += 50;
		lblKQ.setBounds(x, y, width, height);

		jpCentre.add(txtA = new JTextField());
		x += 70;
		y -= 150;
		width = 350;
		height = 30;
		txtA.setBounds(x, y, width, height);
		jpCentre.add(txtB = new JTextField());
		y += 50;
		txtB.setBounds(x, y, width, height);
		jpCentre.add(txtC = new JTextField());
		y += 50;
		txtC.setBounds(x, y, width, height);
		jpCentre.add(txtKQ = new JTextField());
		y += 50;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);

		JPanel jpSouth = new JPanel();
		this.add(jpSouth, BorderLayout.SOUTH);
		jpSouth.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		jpSouth.add(btnGiai = new JButton("Giải"));
		jpSouth.add(btnXoa = new JButton("Xóa rỗng"));
		jpSouth.add(btnThoat = new JButton("Thoát"));

		// event
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPhuongTrinhBacHai().setVisible(true);
	}

	public void giaiPTB1(float a, float b) {
		if (a != 0) {
			txtKQ.setText("x = " + (-b / a));
		} else if (b == 0) {
			txtKQ.setText("Vô số nghiệm");
		} else {
			txtKQ.setText("Vô nghiệm");
		}
	}

	public boolean isInt(JTextField txt) {
		boolean result = true;
		try {
			Integer.parseInt(txt.getText());
		} catch (NumberFormatException e) {
			result = false;
		}
		return result;
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			System.exit(0);
		} else if (o.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtKQ.setText("");
			txtA.requestFocus();
		} else if (o.equals(btnGiai)) {
			if (!isInt(txtA))
				txtA.requestFocus();
			else if (!isInt(txtB))
				txtB.requestFocus();
			else if (!isInt(txtC))
				txtC.requestFocus();
			else {
				float a = Integer.parseInt(txtA.getText());
				float b = Integer.parseInt(txtB.getText());
				float c = Integer.parseInt(txtC.getText());
				if (a == 0)
					giaiPTB1(b, c);
				else {
					float delta = b * b - 4 * a * c;
					if (delta < 0)
						txtKQ.setText("Vô nghiệm");
					else if (delta == 0)
						txtKQ.setText("Nghiệm kép x1 = x2 = " + -b / (2 * a));
					else {
						txtKQ.setText("2 nghiệm x1 = " + ((-b + Math.sqrt(delta)) / (2 * a)) + "x2 = "
								+ ((-b - Math.sqrt(delta)) / (2 * a)));
					}
				}
			}
		}
	}

}
