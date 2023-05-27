package bai1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorld extends JFrame implements ActionListener {

	private JLabel lblLoiChao;
	private JButton btbExit, btnHienThi;

	public HelloWorld() {
		// 1. thiết lập thuộc tính cho Jframe
		this.setTitle("demo hello world....");
		setSize(210, 100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setResizable(false);

		// 2. khai báo các component(đối tượng cần dùng)
		lblLoiChao = new JLabel("Hello word ....");
		btbExit = new JButton("Exit");
		btnHienThi = new JButton("Đổi lời chào");

		// 3. Thêm các component vào JFrame
		add(lblLoiChao);
		add(btnHienThi);
		add(btbExit);

		// 4. đăng ký lắng nghe cho đối tượng
		btbExit.addActionListener(this);
		btnHienThi.addActionListener(this);
	}

	public static void main(String[] args) {
		new HelloWorld().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(btbExit))
			System.exit(0);
		if (obj.equals(btnHienThi))
			lblLoiChao.setText("Happy new year DHTPM17C!!");
	}
}
