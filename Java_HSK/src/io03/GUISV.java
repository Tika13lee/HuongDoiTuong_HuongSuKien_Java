package io03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUISV extends JFrame implements ActionListener{
	private JTextField tfMa;
	private JTextField tfTen;
	private JTextField tfDiem;
	private JButton bttThem, bttTim, bttThoat, bttXuat;

	private static final String FILENAME = "src/data/SV.txt";

	DanhSachSinhVien ds = null;

	public GUISV() {
		// TODO Auto-generated constructor stub
		setTitle("Vi du");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		Box b = Box.createVerticalBox();
		JPanel p1, p2, p3, p4;
		b.add(p1 = new JPanel());
		b.add(p2 = new JPanel());
		b.add(p3 = new JPanel());
		b.add(p4 = new JPanel());
		add(b);

		JLabel lblMa, lblTen, lblDiem;
		p1.add(lblMa = new JLabel("Ma sinh vien: "));
		p1.add(tfMa = new JTextField(20));
		p2.add(lblTen = new JLabel("Ten sinh vien: "));
		p2.add(tfTen = new JTextField(20));
		p3.add(lblDiem = new JLabel("Diem trung binh: "));
		p3.add(tfDiem = new JTextField(20));
		p4.add(bttThem = new JButton("Them"));
		// p4.add(bttLuu = new JButton("Luu"));
		p4.add(bttTim = new JButton("Tim"));
		p4.add(bttXuat = new JButton("Xuat"));
		p4.add(bttThoat = new JButton("Thoat"));

		lblMa.setPreferredSize(lblDiem.getPreferredSize());
		lblTen.setPreferredSize(lblDiem.getPreferredSize());

		bttThoat.addActionListener(this);
		bttTim.addActionListener(this);
		bttThem.addActionListener(this);
		// bttLuu.addActionListener(this);
		bttXuat.addActionListener(this);

		setVisible(true);

		// Đọc danh sách từ file ra đối tượng ds
		if (!new File(FILENAME).exists())
			ds = new DanhSachSinhVien();
		else {
			try {
				LuuTru lt = new LuuTru();
				ds = (DanhSachSinhVien) lt.DocFile(FILENAME);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
				ds = new DanhSachSinhVien();
			}
			/*
			 * try { FileInputStream fis = new FileInputStream(FILENAME);
			 * ObjectInputStream ois = new ObjectInputStream(fis); ds =
			 * (DanhSachSinhVien) ois.readObject(); ois.close(); } catch
			 * (FileNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); } catch
			 * (ClassNotFoundException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		}
	}

	public static void main(String[] args) {
		new GUISV();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(bttThoat)) {
			String[] buttons = { "Có", "Không" };
			int ans = JOptionPane.showOptionDialog(this,
					"Có lưu thông tin mới vào file ko?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, buttons, "");
			if (ans == JOptionPane.YES_OPTION) {
				try {
					LuuTru lt = new LuuTru();
					lt.LuuFile(ds, FILENAME);
				} catch (Exception er) {
					JOptionPane.showMessageDialog(this, er.getMessage());
				}
				/*
				 * try { FileOutputStream fos = new FileOutputStream(FILENAME);
				 * ObjectOutputStream oos = new ObjectOutputStream(fos);
				 * oos.writeObject(ds); oos.close(); } catch
				 * (FileNotFoundException e1) { // TODO Auto-generated catch
				 * block e1.printStackTrace(); } catch (IOException e1) { //
				 * TODO Auto-generated catch block e1.printStackTrace(); }
				 */
			}
			System.exit(0);
		}
		if (o.equals(bttXuat)) {
			JOptionPane.showMessageDialog(null, ds.xuatThongTin());
		}
		if (o.equals(bttThem)) {
			String ms = tfMa.getText();
			String ten = tfTen.getText();
			double dtb = Double.parseDouble(tfDiem.getText());
			SinhVien sv = new SinhVien(ms, ten, dtb);
			if (!ds.themSinhVien(sv))
				JOptionPane.showMessageDialog(null, "Trung ID");
			else
				JOptionPane.showMessageDialog(null, "Thêm xong");
		}
		if (o.equals(bttTim)) {
			String maso = JOptionPane.showInputDialog("Nhap ma so can tim: ");
			for (SinhVien i : ds.getDssv()) {
				if (i.getMaSo().equalsIgnoreCase(maso)) {
					tfMa.setText(i.getMaSo());
					tfTen.setText(i.getTenSv());
					tfDiem.setText(i.getDtb() + "");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Not found!");
		}
		
	}
 
}
