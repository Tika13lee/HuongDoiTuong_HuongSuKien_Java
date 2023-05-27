package tuan4_30_QuanLySach;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUISach extends JFrame implements ActionListener, MouseListener {
	private DefaultTableModel modelSach;
	private JTable tableSach;
	private JScrollPane pane;
	private ListSach ds = new ListSach();

	private JTextField txtDonGia;
	private JTextField txtMa;
	private JTextField txtTua;
	private JTextField txtTg;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtISBN;
	private JTextField txtMess;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	JComboBox<String> cboMa;

	private static final String FILE = "src/data/dsSach.txt";

	public GUISach() {
		setTitle("Quản lý sách");
		setSize(900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel jpNorth, jpCenter;

		// jpNorth
		jpNorth = new JPanel();
		this.add(jpNorth, BorderLayout.NORTH);
		jpNorth.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		jpNorth.setLayout(null);
		jpNorth.setPreferredSize(new Dimension(800, 200));

		JLabel lblMa, lblTua, lblTg, lblNamXB, lblNhaXB, lblSoTrang, lblDonGia, lblISBN;
		jpNorth.add(lblMa = new JLabel("Mã sách:"));
		jpNorth.add(lblTua = new JLabel("Tựa sách:"));
		jpNorth.add(lblTg = new JLabel("Tác giả:"));
		jpNorth.add(lblNamXB = new JLabel("Năm xuất bản:"));
		jpNorth.add(lblNhaXB = new JLabel("Nhà xuất bản:"));
		jpNorth.add(lblSoTrang = new JLabel("Số trang:"));
		jpNorth.add(lblDonGia = new JLabel("Đơn giá:"));
		jpNorth.add(lblISBN = new JLabel("International Standard Book Number (ISBN):"));

		jpNorth.add(txtMa = new JTextField(20));
		jpNorth.add(txtTua = new JTextField(20));
		jpNorth.add(txtTg = new JTextField(20));
		jpNorth.add(txtNamXB = new JTextField(20));
		jpNorth.add(txtNhaXB = new JTextField(20));
		jpNorth.add(txtSoTrang = new JTextField(20));
		jpNorth.add(txtDonGia = new JTextField(20));
		jpNorth.add(txtISBN = new JTextField(20));

		// text mess
		jpNorth.add(txtMess = new JTextField());
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Arial", Font.ITALIC, 16));

		int x = 10, y = 30, w = 230, w2 = 330, h = 20;
		lblMa.setBounds(x, 30, w, h);
		lblTua.setBounds(x, y += 25, w, h);
		lblNamXB.setBounds(x, y += 25, w, h);
		lblSoTrang.setBounds(x, y += 25, w, h);
		lblISBN.setBounds(x, y += 25, w2, h);
		txtMess.setBounds(x, y += 30, w, h);

		x += 80;
		txtMa.setBounds(x, y -= 130, w, h);
		txtTua.setBounds(x, y += 25, w2, h);
		txtNamXB.setBounds(x, y += 25, w2, h);
		txtSoTrang.setBounds(x, y += 25, w2, h);
		txtISBN.setBounds(x += 170, y += 25, 160, h);

		x += 200;
		lblTg.setBounds(x, y -= 75, w, h);
		lblNhaXB.setBounds(x, y += 25, w, h);
		lblDonGia.setBounds(x, y += 25, w, h);

		x += 80;
		txtTg.setBounds(x, y -= 50, w2, h);
		txtNhaXB.setBounds(x, y += 25, w2, h);
		txtDonGia.setBounds(x, y += 25, w2, h);

		// set data
		txtMa.setText("K001");
		txtTua.setText("Nhà giả kim");
		txtTg.setText("Paulo Coelho");
		txtNamXB.setText("2013");
		txtNhaXB.setText("Hội nhà văn");
		txtSoTrang.setText("225");
		txtDonGia.setText("79000");
		txtISBN.setText("978-604-53-7204-3");

		// jpCenter
		jpCenter = new JPanel();
		this.add(jpCenter, BorderLayout.CENTER);

		jpCenter.add(btnThem = new JButton("Thêm"));
		jpCenter.add(btnXoaRong = new JButton("Xóa rỗng"));
		jpCenter.add(btnSua = new JButton("Sửa"));
		jpCenter.add(btnXoa = new JButton("Xóa"));
		jpCenter.add(btnLuu = new JButton("Lưu"));
		jpCenter.add(new JLabel("Tìm theo mã sách"));
		jpCenter.add(cboMa = new JComboBox<String>());
		cboMa.setPreferredSize(new Dimension(100, 25));

		// jpSouth;
		String[] cols = { "Mã sách", "Tựa sách", "Tác giả", "Năm xuất bản", "Nhà xuất bản", "Số trang", "Đơn giá",
				"ISBN" };
		modelSach = new DefaultTableModel(cols, 0);
		tableSach = new JTable(modelSach);
		pane = new JScrollPane(tableSach);
		pane.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		pane.setPreferredSize(new Dimension(0, 300));
		this.add(pane, BorderLayout.SOUTH);

		// load data
//		renderDuLieuVaoModel(ds);
//		LuuTruSach lt = new LuuTruSach();
//		try {
//			lt.docFile(ds, FILE);
//			loadDataToTable();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		// dang ky su kien
		tableSach.addMouseListener(this);
		cboMa.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);
	}

//	public void renderDuLieuVaoModel(ListSach ds) {
//    	LuuTruSach l = new LuuTruSach();
//    	l.docFile(ds, FILE);
//    	loadDataToTable();
// 
//    }

	public static void main(String[] args) {
		new GUISach().setVisible(true);
	}

	private void xoaRong() {
		txtMa.setText("");
		txtTua.setText("");
		txtNamXB.setText("");
		txtSoTrang.setText("");
		txtISBN.setText("");
		txtTg.setText("");
		txtNhaXB.setText("");
		txtDonGia.setText("");
		txtMa.requestFocus();
	}

	private boolean validData() {
		String maSach = txtMa.getText().trim();
		String tuaSach = txtTua.getText().trim();
		String tacGia = txtTg.getText().trim();
		String nam = txtNamXB.getText().trim();
		String gia = txtDonGia.getText().trim();
		String isbn = txtISBN.getText().trim();
		String soTrang = txtSoTrang.getText().trim();

		if (!(maSach.length() > 0) && maSach.matches("NV\\d{3}")) {
			JOptionPane.showMessageDialog(this, "Mã sách không được rỗng và bắt đầu bằng "
					+ "ký tự đầu tiên của tựa sách viết hoa theo sau là 3 ký tự số bất kỳ");
			return false;
		}
		return true;
	}

	private Sach createSach() {
		String maSach = txtMa.getText().trim();
		String tuaSach = txtTua.getText().trim();
		String tacGia = txtTg.getText().trim();
		String nhaXB = txtNhaXB.getText().trim();
		String isbn = txtISBN.getText().trim();

		String nam = txtNamXB.getText().trim();
		int namXB = nam.length() == 0 ? 0 : Integer.parseInt(nam);
		String trang = txtSoTrang.getText().trim();
		int soTrang = trang.length() == 0 ? 0 : Integer.parseInt(trang);
		String gia = txtDonGia.getText().trim();
		double donGia = gia.equals("") ? 0 : Double.parseDouble(gia);

		return new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, isbn);
	}

	private void loadDataToTable() {
		modelSach.setRowCount(0);
		for (Sach s : ds.getDs()) {
			modelSach.addRow(new Object[] { s.getMaSach(), s.getTuaSach(), s.getNamXB(), s.getSoTrang(), s.getIsbn(),
					s.getTacGia(), s.getNhaXB(), s.getDonGia() });
		}
		cboMa.addItem(txtMa.getText());
	}

//	private void fillForm(int row) {
//		if (row != -1) {
//			String maSach = (String) tableSach.getValueAt(row, 0);
//			Sach s = new Sach(maSach);
//			ArrayList<Sach> dsSach = ds.getDs();
//			if (ds.getDs().contains(s)) {
//				s = dsSach.get(dsSach.indexOf(s));
//				txtMa.setText(s.getMaSach());
//				txtTua.setText(s.getTuaSach());
//				txtTg.setText(s.getTacGia());
//				txtNhaXB.setText(s.getNhaXB());
//				txtNamXB.setText(s.getNamXB() + "");
//				txtSoTrang.setText(s.getSoTrang() + "");
//				txtDonGia.setText(s.getDonGia() + "");
//				txtISBN.setText(s.getIsbn());
//				txtMa.setEditable(false);
//			}
//		}
//	}

	private void themSach() {
//		if (txtMa.getText().equals("") || txtTua.getText().equals("") || txtNamXB.getText().equals("")
//				|| txtSoTrang.getText().equals("") || txtISBN.getText().equals("") || txtTg.getText().equals("")
//				|| txtNhaXB.getText().equals("") || txtDonGia.getText().equals("")) {
//			JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ các thông tin");
//		} else {
		if (validData() == true) {
			Sach s = createSach();
			if (ds.them(s)) {
//				modelSach.addRow(new Object[] { s.getMaSach(), s.getTuaSach(), s.getNamXB(), s.getSoTrang(),
//						s.getIsbn(), s.getTacGia(), s.getNhaXB(), s.getDonGia() });
//				cboMa.addItem(txtMa.getText());
				loadDataToTable();
				txtMess.setText("Thêm thành công");
			} else {
				txtMess.setText("Mã sách bị trùng");
			}
		}
//		}
	}

	private void xoaSach() {
		int r = tableSach.getSelectedRow();
		if (r == -1)
			JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần xóa");
		else {
			if (JOptionPane.showConfirmDialog(this, "Bạn chắc muốn xóa dòng này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (ds.xoa(r)) {
					modelSach.removeRow(r);
					txtMess.setText("Xóa thành công");
				}
			}
		}
	}

	private void timTheoMa() {
		String maSach = (String) cboMa.getSelectedItem();
		Sach s = ds.timKiem(maSach);
		if (s != null) {
			modelSach.setRowCount(0);
			modelSach.addRow(new Object[] { s.getMaSach(), s.getTuaSach(), s.getNamXB(), s.getSoTrang(), s.getIsbn(),
					s.getTacGia(), s.getNhaXB(), s.getDonGia() });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaRong)) {
			xoaRong();
		} else if (o.equals(btnThem)) {
			themSach();
		} else if (o.equals(btnXoa)) {
			xoaSach();
		} else if (o.equals(cboMa)) {
			timTheoMa();
		} else if (o.equals(btnLuu)) {
			LuuTruSach lt = new LuuTruSach();
			try {
				lt.ghiFile(ds, FILE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			txtMess.setText("Lưu thành công");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableSach.getSelectedRow();
		if (row != -1) {
			txtMa.setText(modelSach.getValueAt(row, 0).toString());
			txtTua.setText(modelSach.getValueAt(row, 1).toString());
			txtTg.setText(modelSach.getValueAt(row, 2).toString());
			txtNamXB.setText(modelSach.getValueAt(row, 3).toString());
			txtNhaXB.setText(modelSach.getValueAt(row, 4).toString());
			txtSoTrang.setText(modelSach.getValueAt(row, 5).toString());
			txtDonGia.setText(modelSach.getValueAt(row, 6).toString());
			txtISBN.setText(modelSach.getValueAt(row, 7).toString());
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
