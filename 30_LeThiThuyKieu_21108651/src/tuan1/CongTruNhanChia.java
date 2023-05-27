package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CongTruNhanChia extends JFrame implements ActionListener {
	private JButton btnGiai;
	private JButton btnXoa;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtKQ;
	private JRadioButton radCong;
	private JRadioButton radTru;
	private JRadioButton radNhan;
	private JRadioButton radChia;

	public CongTruNhanChia() {
		setTitle("Cong - Tru - Nhan - Chia");
		setSize(550, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel jpNorth, jpWest, jpSouth, jpCenter;

		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		JLabel lblTitle;
		jpNorth.add(lblTitle = new JLabel("Cộng Trừ Nhân Chia"));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setForeground(Color.BLUE);

		jpWest = new JPanel();
		jpWest.setLayout(new GridLayout(10, 0));
		this.add(jpWest, BorderLayout.WEST);
		jpWest.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		jpWest.add(btnGiai = new JButton("Giai"));
		jpWest.add(btnXoa = new JButton("Xoa"));
		jpWest.add(btnThoat = new JButton("Thoat"));

		jpCenter = new JPanel();
		this.add(jpCenter);
		jpCenter.setLayout(null);
		jpCenter.setBorder(BorderFactory.createTitledBorder("Tinh toan"));
		JLabel lblA, lblB, lblKQ;
		jpCenter.add(lblA = new JLabel("Nhap a:"));
		int x = 40, y = 20, width = 100, height = 30;
		lblA.setBounds(x, y, width, height);
		jpCenter.add(lblB = new JLabel("Nhap b:"));
		y += 50;
		lblB.setBounds(x, y, width, height);
		jpCenter.add(lblKQ = new JLabel("Ket qua:"));
		y += 150;
		lblKQ.setBounds(x, y, width, height);

		jpCenter.add(txtA = new JTextField());
		x += 50;
		y -= 200;
		width += 200;
		txtA.setBounds(x, y, width, height);
		jpCenter.add(txtB = new JTextField(20));
		y += 50;
		txtB.setBounds(x, y, width, height);
		jpCenter.add(txtKQ = new JTextField(20));
		y += 150;
		txtKQ.setBounds(x, y, width, height);
		txtKQ.setEditable(false);

		JPanel jpPhepToan = new JPanel();
		jpPhepToan.setLayout(new GridLayout(2, 2));
		jpPhepToan.setBorder(BorderFactory.createTitledBorder("Phep toan"));
		jpPhepToan.add(radCong = new JRadioButton("Cong"));
		jpPhepToan.add(radTru = new JRadioButton("Tru"));
		jpPhepToan.add(radNhan = new JRadioButton("Nhan"));
		jpPhepToan.add(radChia = new JRadioButton("Chia"));
		ButtonGroup gr = new ButtonGroup();
		gr.add(radCong);
		gr.add(radTru);
		gr.add(radNhan);
		gr.add(radChia);
		jpCenter.add(jpPhepToan);
		y -= 110;
		height += 60;
		jpPhepToan.setBounds(x, y, width, height);

		// event
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);

	}

	public static void main(String[] args) {
		new CongTruNhanChia().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			System.exit(0);
		}
		if (o.equals(btnXoa)) {
			txtA.setText("");
			txtB.setText("");
			txtA.requestFocus();
		}
		if (o.equals(btnGiai)) {
			double kq = 0;

			if (txtA.getText().equals("") || txtB.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ a và b");
			} else {
				double a = Double.parseDouble(txtA.getText());
				double b = Double.parseDouble(txtB.getText());
				if (!radCong.isSelected() && !radTru.isSelected() && !radNhan.isSelected() && !radChia.isSelected()) {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn phép tính");
				} else {
					if (radCong.isSelected()) {
						kq = a + b;
						txtKQ.setText(kq + "");
					}
					if (radTru.isSelected()) {
						kq = a - b;
						txtKQ.setText(kq + "");
					}
					if (radNhan.isSelected()) {
						kq = a * b;
						txtKQ.setText(kq + "");
					}
					if (radChia.isSelected()) {
						kq = a / b;
						txtKQ.setText(kq + "");
					}
				}
			}
		}
	}
}
